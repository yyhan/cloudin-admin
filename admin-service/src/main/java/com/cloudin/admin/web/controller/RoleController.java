package com.cloudin.admin.web.controller;

import com.cloudin.admin.entity.Administrator;
import com.cloudin.admin.entity.Role;
import com.cloudin.admin.service.AdministratorService;
import com.cloudin.admin.service.RoleService;
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
public class RoleController {
	
	@Resource
	private RoleService roleService;
	
	@RequestMapping("/role/list.htm")
	public String listWithPage() {
		return "/role/list";
	}
	
	@ResponseBody
	@RequestMapping("/ajax/role/list.htm")
	public DTResponse<Role> listWithPage(DTRequest request) {
		return roleService.listWithPage(request);
	}
}
