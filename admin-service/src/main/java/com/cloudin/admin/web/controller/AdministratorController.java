package com.cloudin.admin.web.controller;

import com.cloudin.admin.entity.Administrator;
import com.cloudin.admin.service.AdministratorService;
import com.cloudin.commons.langs.support.datatables.DTRequest;
import com.cloudin.commons.langs.support.datatables.DTResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author 小天
 * @version 1.0.0, 2018/6/6 0006 15:17
 */
@Controller
public class AdministratorController {
	
	@Resource
	private AdministratorService administratorService;
	
	@RequestMapping("/administrator/list.htm")
	public String listWithPage() {
		return "/administrator/list";
	}
	
	@ResponseBody
	@RequestMapping("/ajax/administrator/list.htm")
	public DTResponse<Administrator> listWithPage(DTRequest request) {
		return administratorService.listWithPage(request);
	}
}
