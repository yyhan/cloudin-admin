package com.cloudin.admin.support.shiro;

import com.cloudin.admin.entity.vo.AdministratorVO;
import com.cloudin.admin.service.AdminAuthorizationService;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

/**
 * @author 小天
 * @version 1.0.0, 2018/6/7 0007 16:33
 */
public class CloudinAccessControlFilter extends AccessControlFilter {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 匹配参数 - 只认证
	 */
	public static final String ONLY_AUTHENTICATION = "ONLY_AUTHENTICATION";
	
	@Resource
	private AdminAuthorizationService authorizationService;
	
	/**
	 * 未授权访问时跳转的 url
	 */
	private String unauthorizedUrl;
	
	public String getUnauthorizedUrl() {
		return unauthorizedUrl;
	}
	
	public void setUnauthorizedUrl(String unauthorizedUrl) {
		this.unauthorizedUrl = unauthorizedUrl;
	}
	
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
		throws Exception {
		
		Subject subject = getSubject(request, response);
		
		if (!subject.isAuthenticated()) {
			return false;
		}
		
		// 判断是否为超级管理员
		if(subject.hasRole(AuthConstants.ROLE_SUPER_ADMIN)) {
			return true;
		}
		
		boolean isAccessAllowed = false;
		
		String[] mappedParams = (String[]) mappedValue;
		if(mappedParams != null) {
			for (String mappedParam : mappedParams) {
				// 如果设置了只认证参数，就直接返回
				if (ONLY_AUTHENTICATION.equals(mappedParam)) {
					return true;
				}
			}
		}
		
		String path = getPathWithinApplication(request);
		
		// 取出 url 允许的 角色 集合
		Set<String> allowedRoles = authorizationService.listAllowedRoleCode(path);
		for (String role : allowedRoles) {
			if (subject.hasRole(role)) {
				isAccessAllowed = true;
				break;
			}
		}
		
		if(logger.isTraceEnabled()) {
			PrincipalCollection principals = subject.getPrincipals();
			AdministratorVO administrator = principals.oneByType(AdministratorVO.class);
			if (isAccessAllowed) {
				logger.debug("授权结果 - 允许访问：administratorId={},path={}", administrator.getId(), path);
			} else {
				logger.debug("授权结果 - 禁止访问：administratorId={},path={}", administrator.getId(), path);
			}
		}

		return isAccessAllowed;
	}
	
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		Subject subject = getSubject(request, response);
		if (!subject.isAuthenticated() || subject.getPrincipal() == null) {
			saveRequestAndRedirectToLogin(request, response);
		} else {
			String unauthorizedUrl = getUnauthorizedUrl();
			if (StringUtils.hasText(unauthorizedUrl)) {
				WebUtils.issueRedirect(request, response, unauthorizedUrl);
			} else {
				WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
			}
		}
		return false;
	}
}
