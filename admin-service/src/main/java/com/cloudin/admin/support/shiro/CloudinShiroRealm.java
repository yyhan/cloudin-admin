package com.cloudin.admin.support.shiro;

import com.cloudin.admin.entity.Administrator;
import com.cloudin.admin.entity.vo.AdministratorVO;
import com.cloudin.admin.service.AdminAuthorizationService;
import com.cloudin.admin.service.AdministratorService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @author 小天
 * @version 1.0.0, 2018/5/24 0024 14:42
 */
public class CloudinShiroRealm extends AuthorizingRealm {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private String rootUserName = "root";
	
	@Resource
	private AdministratorService administratorService;
	
	@Resource
	private AdminAuthorizationService adminAuthorizationService;
	
	/**
	 * 授予用户权限 AdministratorAuthorization
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		SimplePrincipalCollection principalCollection = (SimplePrincipalCollection) principals;
		
		AdministratorVO administrator = principalCollection.oneByType(AdministratorVO.class);
		
		if(logger.isDebugEnabled()) {
			logger.debug("授权： administratorId={}", administrator.getId());
		}
		
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		
		authorizationInfo.setRoles(adminAuthorizationService.listRoleSet(administrator.getId()));
		
		if (rootUserName.equals(administrator.getAccount())) {
			authorizationInfo.addRole(AuthConstants.ROLE_SUPER_ADMIN);
		}
		return authorizationInfo;
	}
	
	/**
	 * 验证用户身份
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
		throws AuthenticationException {
		
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		if (StringUtils.isEmpty(token.getUsername())) {
			throw new AccountException("用户名不能为空");
		}
		if (token.getPassword() == null) {
			throw new AccountException("密码不能为空");
		}
		String username = token.getUsername();
		String password = String.valueOf(token.getPassword());
		
		logger.info("开始认证：username={},password={}", username, password);
		
		Administrator administrator;
		
		if (username.indexOf("@") > 0) {
			administrator = administratorService.getByEmail(username);
		} else {
			administrator = administratorService.getByAccount(username);
			if (administrator == null) {
				administrator = administratorService.getByMobile(username);
			}
		}
		
		if (administrator == null) {
			throw new UnknownAccountException("该用户不存在");
		}
		
		if (!administrator.getPassword().equals(password)) {
			throw new IncorrectCredentialsException("密码错误");
		}
		
		CloudinPrincipalCollection principalCollection = new CloudinPrincipalCollection();
		principalCollection.setPrimaryPrincipal(convertToVO(administrator), getName());
		
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo();
		simpleAuthenticationInfo.setPrincipals(principalCollection);
		
		logger.info("认证通过：username={},password={}", username, password);
		
		return simpleAuthenticationInfo;
	}
	
	@Override
	protected void assertCredentialsMatch(AuthenticationToken token, AuthenticationInfo info)
		throws AuthenticationException {
		// 认证时，已经比较过密码，这里忽略掉凭据比较
	}
	
	@Override
	protected Object getAuthorizationCacheKey(PrincipalCollection principals) {
		AdministratorVO administrator = principals.oneByType(AdministratorVO.class);
		// 将管理员Id 作为 缓存 key
		return administrator.getId();
	}
	
	private AdministratorVO convertToVO(Administrator administrator) {
		AdministratorVO administratorVO = new AdministratorVO();
		administratorVO.setId(administrator.getId());
		administratorVO.setAccount(administrator.getAccount());
		administratorVO.setName(administrator.getName());
		administratorVO.setMobile(administrator.getMobile());
		administratorVO.setEmail(administrator.getEmail());
		administratorVO.setFreeze(administrator.getFreeze() != null && administrator.getFreeze());
		administratorVO.setDisabled(administrator.getDisabled() != null && administrator.getDisabled());
		administratorVO.setPasswordExpiredTime(administrator.getPasswordExpiredTime());
		return administratorVO;
	}
}
