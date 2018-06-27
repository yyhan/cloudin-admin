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
	
	/**
	 * 查询指定管理员的菜单信息
	 *
	 * @param administratorId 管理员Id，必须大于 0
	 *
	 * @return 菜单
	 */
	Menu get(Integer administratorId);
	
	/**
	 * 获取全部菜单
	 *
	 * @return 菜单
	 */
	Menu getAll();
	
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
	 * 查询允许访问指定 url 的角色标识集合
	 *
	 * @param url 指定 url
	 *
	 * @return 角色标识集合
	 */
	Set<String> listAllowedRoleCode(String url);
	
	/**
	 * 保存管理员 - 角色信息
	 *
	 * @param administratorId 管理员Id
	 * @param roleIdList      角色Id集合
	 *
	 * @return
	 */
	BaseResult saveAdminRoles(Integer administratorId, List<Integer> roleIdList);
	
}
