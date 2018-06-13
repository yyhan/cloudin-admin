package com.cloudin.admin.service;

import com.cloudin.admin.entity.Role;
import com.cloudin.commons.langs.entity.BaseResult;
import com.cloudin.commons.langs.support.datatables.DTRequest;
import com.cloudin.commons.langs.support.datatables.DTResponse;

import java.util.List;

/**
 * @author 小天
 * @version 1.0.0, 2018/6/6 0006 17:46
 */
public interface RoleService {
	
	BaseResult add(Role role);
	
	/**
	 * 修改角色信息
	 *
	 * @param role 新的角色信息，必须包含角色Id字段
	 *
	 * @return {@link com.cloudin.commons.langs.entity.BaseResult}
	 */
	BaseResult update(Role role);
	
	BaseResult delete(Integer roleId);
	
	Role get(Integer roleId);
	
	DTResponse<Role> listWithPage(DTRequest request);
	
	List<Role> listAll();
	
}
