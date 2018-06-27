package com.cloudin.admin.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by YFHan on 2017/1/3 0003.
 */
@Controller
public class HomeController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(path = {"/"})
	public String rootIndex(){
		return "redirect:/index.htm";
	}

    @RequestMapping(path = {"/index.htm"})
    public String index(){
        return "index";
    }
	
	@RequestMapping(path = {"/403.htm"})
	public String forbidden(){
		return "403";
	}

    @RequestMapping(path = {"/signin.htm"})
    public String signin(){
        return "signin";
    }
	
	@RequestMapping(value = "/ajax/signin.htm", method = RequestMethod.POST)
	public String doSignin(String username, String password, Model model) {
		logger.info("请求参数：username={},password={}", username, password);
		
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			SecurityUtils.getSubject().login(token);
		} catch (AuthenticationException e) {
			logger.info("登录失败|{}：username={},password={}", e.getMessage(), username, password);
			model.addAttribute("errMsg", e.getMessage());
			return "signin";
		}
		logger.info("登录成功：username={},password={}", username, password);
		return "redirect:/index.htm";
	}

    @RequestMapping(path = {"/signout.htm"})
    public String signout(){
		Subject currentSubject = SecurityUtils.getSubject();
		if(currentSubject == null) {
			return "signout";
		}
		currentSubject.logout();
		return "signout";
    }

}
