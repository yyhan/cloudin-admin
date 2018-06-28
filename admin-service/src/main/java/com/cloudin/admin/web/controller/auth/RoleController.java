package com.cloudin.admin.web.controller.auth;

import com.cloudin.admin.entity.Administrator;
import com.cloudin.admin.entity.Permission;
import com.cloudin.admin.entity.Role;
import com.cloudin.admin.service.AdministratorService;
import com.cloudin.admin.service.RoleService;
import com.cloudin.commons.langs.entity.BaseResult;
import com.cloudin.commons.langs.support.datatables.DTRequest;
import com.cloudin.commons.langs.support.datatables.DTResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 小天
 * @version 1.0.0, 2018/6/6 0006 15:17
 */
@Controller
public class RoleController {
	
	@Resource
	private RoleService roleService;
	
	@ResponseBody
	@RequestMapping("/ajax/role/add.htm")
	public BaseResult add(Role role) {
		return roleService.add(role);
	}
	
	@ResponseBody
	@RequestMapping("/ajax/role/update.htm")
	public BaseResult update(Role role) {
		return roleService.update(role);
	}
	
	@ResponseBody
	@RequestMapping("/ajax/role/delete.htm")
	public BaseResult delete(Integer roleId) {
		return roleService.delete(roleId);
	}
	
	@RequestMapping("/role/list.htm")
	public String listWithPage() {
		return "/role/list";
	}
	
	@ResponseBody
	@RequestMapping("/ajax/role/list.htm")
	public DTResponse<Role> listWithPage(DTRequest request) {
		return roleService.listWithPage(request);
	}
	
	@ResponseBody
	@RequestMapping("/ajax/role/listAll.htm")
	public BaseResult<List<Role>> listAll() {
		List<Role> roleList = roleService.listAll();
		return BaseResult.build(roleList).success();
	}
}
