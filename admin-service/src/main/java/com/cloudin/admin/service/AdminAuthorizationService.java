package com.cloudin.admin.service;

import com.cloudin.admin.bean.Menu;

import java.util.Map;
import java.util.Set;

/**
 * @author 小天
 * @version 1.0.0, 2018/6/6 0006 14:03
 */
public interface AdminAuthorizationService {
	
	Menu get(Integer administratorId);
	
	Set<String> listRoles(Integer administratorId);
	
	Map<String, Set<String>> listPermissionRolesMap();
	
}
