package com.cloudin.admin.web.interceptor;

import com.cloudin.admin.constants.Keys;
import com.cloudin.admin.entity.vo.AdministratorVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 认证信息拦截器，将认证信息放入 request 域
 *
 * @author 小天
 * @version 1.0.0, 2018/5/24 0024 15:55
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {
	
	private Logger logger = LoggerFactory.getLogger("access");
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser == null || !currentUser.isAuthenticated()) {
			logger.info("未认证");
			return false;
		} else {
			AdministratorVO administrator = (AdministratorVO) currentUser.getPrincipal();
			
			logger.info("已认证： administratorId={}", administrator.getId());
			
			request.setAttribute(Keys.REQ_USER, administrator);
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
