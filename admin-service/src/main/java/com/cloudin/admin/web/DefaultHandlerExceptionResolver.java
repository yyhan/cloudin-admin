package com.cloudin.admin.web;

import com.alibaba.fastjson.JSON;
import com.cloudin.commons.langs.ContentTypes;
import com.cloudin.commons.langs.LogUtils;
import com.cloudin.commons.langs.ServletUtils;
import com.cloudin.commons.langs.entity.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author 小天
 * @version 1.0.0, 2017/11/29 0029 11:15
 */
public class DefaultHandlerExceptionResolver implements HandlerExceptionResolver, Ordered {
	
	private Logger logger = LoggerFactory.getLogger("access");
	
	private String loginUrl;
	
	public String getLoginUrl() {
		return loginUrl;
	}
	
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
		Exception ex) {
		
		ModelAndView mav = new ModelAndView();
		
		Integer code = null;
		String message = null;
		
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			logger
				.error(LogUtils.format("{},URI={}\n", handlerMethod.getShortLogMessage(), request.getRequestURI()), ex);
			
			if (ex instanceof org.springframework.validation.BindException) {
				code = 501;
				message = "请求参数错误";
			} else {
				code = 500;
				message = "请求出错";
			}
		} else {
			logger.error("请求出错", ex);
			code = 500;
			message = "请求出错";
		}
		
		if (isAjax(request)) {
			writeErrorBody(response, code, message);
			return mav;
		} else {
			mav.addObject("errorCode", code);
			mav.addObject("errorMessage", message);
			mav.setViewName("error");
			return mav;
		}
	}
	
	@Override
	public int getOrder() {
		return 1;
	}
	
	private boolean isAjax(HttpServletRequest request) {
		return ServletUtils.isAjax(request) || request.getRequestURI().startsWith("/ajax");
	}
	
	private void writeErrorBody(HttpServletResponse response, Integer code, String message) {
		try {
			response.setContentType(ContentTypes.APPLICATION_JSON_UTF8.toString());
			JSON.writeJSONString(response.getOutputStream(), StandardCharsets.UTF_8,
				BaseResult.build().error(code, message));
		} catch (IOException e) {
			logger.error("写入错误信息时出现IO异常", e);
		}
	}
	
}
