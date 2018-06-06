package com.cloudin.admin.service;

import com.cloudin.admin.entity.Administrator;
import com.cloudin.commons.langs.support.datatables.DTRequest;
import com.cloudin.commons.langs.support.datatables.DTResponse;

/**
 * @author 小天
 * @version 1.0.0, 2018/6/6 0006 13:47
 */
public interface AdministratorService {
	
	Administrator get(Integer id);
	
	Administrator getByAccount(String account);
	
	Administrator getByMobile(String mobile);
	
	Administrator getByEmail(String email);
	
	DTResponse<Administrator> listWithPage(DTRequest request);
	
}
