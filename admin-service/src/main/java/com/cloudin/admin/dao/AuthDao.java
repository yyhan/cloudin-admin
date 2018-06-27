package com.cloudin.admin.dao;

import com.cloudin.admin.entity.Permission;
import com.cloudin.admin.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 小天
 * @version 1.0.0, 2018/6/7 0007 17:34
 */
public interface AuthDao {
	
	List<Role> listRoles(@Param("administratorId") Integer administratorId);
	
	List<Permission> listPermission(@Param("administratorId") Integer administratorId);
	
	List<Map<String, Object>> listPermissionRoleMap();
	
	/**
	 * 根据指定的权限内容，查询允许的角色集合
	 *
	 * @param content 权限内容
	 *
	 * @return 角色标识集合
	 */
	List<String> listAllowedRoleCode(String content);
	
}
