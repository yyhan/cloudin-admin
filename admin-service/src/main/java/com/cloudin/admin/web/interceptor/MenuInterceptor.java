package com.cloudin.admin.web.interceptor;

import com.cloudin.admin.bean.Menu;
import com.cloudin.admin.constants.Keys;
import com.cloudin.admin.entity.vo.AdministratorVO;
import com.cloudin.admin.service.AdminAuthorizationService;
import com.cloudin.admin.support.shiro.AuthConstants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 菜单拦截器，拦截指定路径，并将菜单列表放入 request 域
 *
 * @author 小天
 * @version 1.0.0, 2018/5/24 0024 15:55
 */
@Component
public class MenuInterceptor implements HandlerInterceptor {
	
	@Resource
	private AdminAuthorizationService adminAuthorizationService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
		ModelAndView modelAndView) throws Exception {
		
		Subject subject = SecurityUtils.getSubject();
		if(subject.hasRole(AuthConstants.ROLE_SUPER_ADMIN)) {
			Menu menu = adminAuthorizationService.getAll();
			request.setAttribute(Keys.REQ_MENU, menu);
		} else {
			AdministratorVO administratorVO = (AdministratorVO) request.getAttribute(Keys.REQ_USER);
			Menu menu = adminAuthorizationService.get(administratorVO.getId());
			request.setAttribute(Keys.REQ_MENU, menu);
		}
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
		throws Exception {
		
	}
}
