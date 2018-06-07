package com.cloudin.admin.service;

import com.cloudin.admin.entity.Administrator;
import com.cloudin.commons.langs.entity.BaseResult;
import com.cloudin.commons.langs.support.datatables.DTRequest;
import com.cloudin.commons.langs.support.datatables.DTResponse;

/**
 * @author 小天
 * @version 1.0.0, 2018/6/6 0006 13:47
 */
public interface AdministratorService {
	
	BaseResult add(Administrator administrator);
	
	/**
	 * 修改管理员基本信息（不包括账号和密码）
	 *
	 * @param administrator 新的管理员信息，必须包含管理员Id字段
	 *
	 * @return {@link com.cloudin.commons.langs.entity.BaseResult}
	 */
	BaseResult update(Administrator administrator);
	
	BaseResult delete(Integer administratorId);
	
	Administrator get(Integer administratorId);
	
	Administrator getByAccount(String account);
	
	Administrator getByMobile(String mobile);
	
	Administrator getByEmail(String email);
	
	DTResponse<Administrator> listWithPage(DTRequest request);
	
}
