package com.cloudin.admin.service;

import com.cloudin.admin.bean.Menu;
import com.cloudin.admin.entity.Role;
import com.cloudin.commons.langs.entity.BaseResult;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 小天
 * @version 1.0.0, 2018/6/6 0006 14:03
 */
public interface AdminAuthorizationService {
	
	Menu get(Integer administratorId);
	
	List<Role> listRoles(Integer administratorId);
	
	/**
	 * 查询指定 Id 的管理员的角色的 code 集合
	 *
	 * @param administratorId 管理员Id
	 *
	 * @return 角色的 code 集合
	 */
	Set<String> listRoleSet(Integer administratorId);
	
	Map<String, Set<String>> listPermissionRolesMap();
	
	/**
	 * 保存管理员 - 角色信息
	 *
	 * @param administratorId 管理员Id
	 * @param roleIdList 角色Id集合
	 *
	 * @return
	 */
	BaseResult saveAdminRoles(Integer administratorId, List<Integer> roleIdList);
	
}
