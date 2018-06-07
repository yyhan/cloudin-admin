package com.cloudin.admin.web.controller;

import com.cloudin.admin.support.shiro.CloudinAuthorizationInfo;
import com.cloudin.commons.langs.entity.BaseResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 小天
 * @version 1.0.0, 2018/6/7 0007 15:17
 */
@Controller
public class CommonController {
	
	/**
	 * 刷新授权信息
	 */
	@ResponseBody
	@RequestMapping("/ajax/common/authorization/refresh.htm")
	public BaseResult refreshAuthorization() {
		Subject currentSubject = SecurityUtils.getSubject();
		PrincipalCollection principalCollection = currentSubject.getPrincipals();
		CloudinAuthorizationInfo authorizationInfo = principalCollection.oneByType(CloudinAuthorizationInfo.class);
		authorizationInfo.setExpire(true);
		return BaseResult.build().success();
	}
}
