package com.cloudin.admin.support.shiro;

import com.cloudin.admin.entity.vo.AdministratorVO;
import com.cloudin.admin.service.AdminAuthorizationService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Map;
import java.util.Set;

/**
 * @author 小天
 * @version 1.0.0, 2018/6/7 0007 16:33
 */
public class CloudinAccessControlFilter extends AuthorizationFilter {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private boolean defaultAccessAllowed = false;
	
	private Map<String, Set<String>> permissionToRolesMap;
	
	@Resource
	private AdminAuthorizationService authorizationService;
	
	public boolean isDefaultAccessAllowed() {
		return defaultAccessAllowed;
	}
	
	public void setDefaultAccessAllowed(boolean defaultAccessAllowed) {
		this.defaultAccessAllowed = defaultAccessAllowed;
	}
	
	@PostConstruct
	public void postConstruct() {
		permissionToRolesMap = authorizationService.listPermissionRolesMap();
	}
	
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
		throws Exception {
		Subject subject = getSubject(request, response);
		PrincipalCollection principals = subject.getPrincipals();
		
		AdministratorVO administrator = principals.oneByType(AdministratorVO.class);
		
		String path = getPathWithinApplication(request);
		
		permissionToRolesMap = authorizationService.listPermissionRolesMap();
		
		Set<String> allowedRoles = permissionToRolesMap.get(path);
		
		boolean isAccessAllowed = false;
		
		if (CollectionUtils.isEmpty(allowedRoles)) {
			logger.debug("未配置授权方式 - 采用默认授权：administratorId={},path={},defaultAccessAllowed={}", administrator.getId(), path, defaultAccessAllowed);
			isAccessAllowed = defaultAccessAllowed;
		} else {
			for (String role : allowedRoles) {
				if (subject.hasRole(role)) {
					isAccessAllowed = true;
					break;
				}
			}
			
		}
		if(isAccessAllowed) {
			logger.debug("授权结果 - 允许访问：administratorId={},path={}", administrator.getId(), path);
		} else {
			logger.debug("授权结果 - 禁止访问：administratorId={},path={}", administrator.getId(), path);
		}
		return isAccessAllowed;
	}
}
