package com.cloudin.admin.service;

import com.cloudin.admin.entity.Role;
import com.cloudin.commons.langs.support.datatables.DTRequest;
import com.cloudin.commons.langs.support.datatables.DTResponse;

/**
 * @author 小天
 * @version 1.0.0, 2018/6/6 0006 17:46
 */
public interface RoleService {
	
	DTResponse<Role> listWithPage(DTRequest request);
	
}
