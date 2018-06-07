package com.cloudin.admin.service;

import com.cloudin.admin.entity.Permission;
import com.cloudin.admin.entity.Role;
import com.cloudin.commons.langs.entity.BaseResult;
import com.cloudin.commons.langs.support.datatables.DTRequest;
import com.cloudin.commons.langs.support.datatables.DTResponse;

/**
 * @author 小天
 * @version 1.0.0, 2018/6/6 0006 17:46
 */
public interface PermissionService {
	
	BaseResult add(Permission permission);
	
	/**
	 * 修改权限信息
	 *
	 * @param permission 新的权限信息，必须包含权限Id字段
	 *
	 * @return {@link com.cloudin.commons.langs.entity.BaseResult}
	 */
	BaseResult update(Permission permission);
	
	BaseResult delete(Integer id);
	
	Permission get(Integer id);
	
	DTResponse<Permission> listWithPage(DTRequest request);
	
}
