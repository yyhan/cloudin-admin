package com.cloudin.admin.web.controller;

import com.cloudin.admin.entity.Administrator;
import com.cloudin.admin.entity.Role;
import com.cloudin.admin.service.AdminAuthorizationService;
import com.cloudin.admin.service.AdministratorService;
import com.cloudin.commons.langs.entity.BaseResult;
import com.cloudin.commons.langs.support.datatables.DTRequest;
import com.cloudin.commons.langs.support.datatables.DTResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 小天
 * @version 1.0.0, 2018/6/6 0006 15:17
 */
@Controller
public class AdministratorController {
	
	@Resource
	private AdministratorService administratorService;
	
	@Resource
	private AdminAuthorizationService adminAuthorizationService;
	
	@ResponseBody
	@RequestMapping("/ajax/administrator/add.htm")
	public BaseResult add(Administrator administrator) {
		return administratorService.add(administrator);
	}
	
	@ResponseBody
	@RequestMapping("/ajax/administrator/update.htm")
	public BaseResult update(Administrator administrator) {
		return administratorService.update(administrator);
	}
	
	@ResponseBody
	@RequestMapping("/ajax/administrator/delete.htm")
	public BaseResult delete(Integer administratorId) {
		return administratorService.delete(administratorId);
	}
	
	@RequestMapping("/administrator/list.htm")
	public String listWithPage() {
		return "/administrator/list";
	}
	
	@ResponseBody
	@RequestMapping("/ajax/administrator/list.htm")
	public DTResponse<Administrator> listWithPage(DTRequest request) {
		return administratorService.listWithPage(request);
	}
	
	/**
	 * 查询指定 id 的管理员拥有的角色
	 *
	 * @param id 管理员Id
	 *
	 * @return 管理员角色集合
	 */
	@ResponseBody
	@RequestMapping("/ajax/administrator/listRoles.htm")
	public BaseResult<List<Role>> listRoles(Integer id) {
		List<Role> roleList = adminAuthorizationService.listRoles(id);
		return BaseResult.build(roleList).success();
	}
	
	@ResponseBody
	@RequestMapping("/ajax/administrator/saveRoles.htm")
	public BaseResult saveRoles(Integer administratorId, String selectedRoleIdStr) {
		List<Integer> roleIdList = new ArrayList<>();
		if(StringUtils.isNotEmpty(selectedRoleIdStr)) {
			String[] roleRoleIdStrArr = selectedRoleIdStr.split(",");
			for (String s : roleRoleIdStrArr) {
				if(StringUtils.isNotEmpty(s)) {
					roleIdList.add(Integer.parseInt(s));
				}
			}
		}
		return adminAuthorizationService.saveAdminRoles(administratorId, roleIdList);
	}
}
