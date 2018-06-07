package com.cloudin.admin.dao;

import com.cloudin.admin.entity.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 小天
 * @version 1.0.0, 2018/6/7 0007 17:34
 */
public interface AuthDao {
	
	List<String> listRoles(@Param("administratorId") Integer administratorId);
	
	List<Permission> listPermission(@Param("administratorId") Integer administratorId);
	
	List<Map<String, Object>> listPermissionRoleMap();
	
}
