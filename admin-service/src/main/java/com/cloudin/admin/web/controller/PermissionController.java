package com.cloudin.admin.web.controller;

import com.cloudin.admin.entity.Permission;
import com.cloudin.admin.service.PermissionService;
import com.cloudin.commons.langs.entity.BaseResult;
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
public class PermissionController {
	
	@Resource
	private PermissionService permissionService;
	
	@ResponseBody
	@RequestMapping("/ajax/permission/add.htm")
	public BaseResult add(Permission permission) {
		return permissionService.add(permission);
	}
	
	@ResponseBody
	@RequestMapping("/ajax/permission/update.htm")
	public BaseResult update(Permission permission) {
		return permissionService.update(permission);
	}
	
	@ResponseBody
	@RequestMapping("/ajax/permission/delete.htm")
	public BaseResult delete(Integer permissionId) {
		return permissionService.delete(permissionId);
	}
	
	@RequestMapping("/permission/list.htm")
	public String listWithPage() {
		return "/permission/list";
	}
	
	@ResponseBody
	@RequestMapping("/ajax/permission/list.htm")
	public DTResponse<Permission> listWithPage(DTRequest request) {
		return permissionService.listWithPage(request);
	}
}
