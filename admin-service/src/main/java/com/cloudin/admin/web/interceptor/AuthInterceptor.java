package com.cloudin.admin.web.interceptor;

import com.cloudin.admin.bean.Menu;
import com.cloudin.admin.constants.Keys;
import com.cloudin.admin.entity.vo.AdministratorVO;
import com.cloudin.admin.service.AdminAuthorizationService;
import com.cloudin.commons.langs.ServletUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 小天
 * @version 1.0.0, 2018/5/24 0024 15:55
 */
@Component("logInterceptor")
public class AuthInterceptor implements HandlerInterceptor {
	
	private Logger logger = LoggerFactory.getLogger("access");
	
	@Resource
	private AdminAuthorizationService adminAuthorizationService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		Subject currentUser = SecurityUtils.getSubject();
		if(currentUser == null || !currentUser.isAuthenticated()) {
			logger.info("未认证");
		} else {
			PrincipalCollection principals = currentUser.getPrincipals();
			
			AdministratorVO administrator = principals.oneByType(AdministratorVO.class);
			
			logger.info("已认证： userId={}", administrator.getId());
			
			AuthorizationInfo authorizationInfo = principals.oneByType(AuthorizationInfo.class);
			if(authorizationInfo != null) {
				logger.info("已授权： userId={}", administrator.getId());
			} else {
				logger.info("未授权： userId={}", administrator.getId());
			}
			
			request.setAttribute(Keys.REQ_USER, administrator);
			
			// 如果不是 ajax 请求的话，将菜单放到 request 作用域里
			if(!ServletUtils.isAjax(request)) {
				Menu menu = principals.oneByType(Menu.class);
				if(menu == null) {
					menu = adminAuthorizationService.get(administrator.getId());
				}
				request.setAttribute(Keys.REQ_MENU, menu);
			}
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
		ModelAndView modelAndView) throws Exception {
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
		throws Exception {
		
	}
}
