package com.cloudin.admin.service.impl;

import com.cloudin.admin.dao.AdministratorDAO;
import com.cloudin.admin.entity.Administrator;
import com.cloudin.admin.entity.AdministratorExample;
import com.cloudin.admin.service.AdministratorService;
import com.cloudin.commons.langs.support.datatables.DTRequest;
import com.cloudin.commons.langs.support.datatables.DTResponse;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 小天
 * @version 1.0.0, 2018/6/6 0006 13:47
 */
@Service
public class AdministratorServiceImpl implements AdministratorService {
	
	@Resource
	private AdministratorDAO administratorDAO;
	
	@Override
	public Administrator get(Integer id) {
		Administrator administrator = administratorDAO.selectByPrimaryKey(id);
		if(administrator.getValid()) {
			return administrator;
		}
		return null;
	}
	
	@Override
	public Administrator getByAccount(String account) {
		AdministratorExample example = new AdministratorExample();
		AdministratorExample.Criteria criteria = example.createCriteria();
		criteria.andAccountEqualTo(account);
		example.setLimit(1);
		List<Administrator> list = administratorDAO.selectByExample(example);
		if(CollectionUtils.isNotEmpty(list)) {
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public Administrator getByMobile(String mobile) {
		AdministratorExample example = new AdministratorExample();
		AdministratorExample.Criteria criteria = example.createCriteria();
		criteria.andMobileEqualTo(mobile);
		example.setLimit(1);
		List<Administrator> list = administratorDAO.selectByExample(example);
		if(CollectionUtils.isNotEmpty(list)) {
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public Administrator getByEmail(String email) {
		AdministratorExample example = new AdministratorExample();
		AdministratorExample.Criteria criteria = example.createCriteria();
		criteria.andEmailEqualTo(email);
		example.setLimit(1);
		List<Administrator> list = administratorDAO.selectByExample(example);
		if(CollectionUtils.isNotEmpty(list)) {
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public DTResponse<Administrator> listWithPage(DTRequest request) {
		AdministratorExample example = new AdministratorExample();
		AdministratorExample.Criteria criteria = example.createCriteria();
		criteria.andValidEqualTo(true);
		example.setOffset(request.getStart());
		example.setLimit(request.getLength());
		
		int count = (int) administratorDAO.countByExample(example);
		List<Administrator> list = administratorDAO.selectByExample(example);
		return new DTResponse<>(list, request.getDraw(), count);
	}
}
