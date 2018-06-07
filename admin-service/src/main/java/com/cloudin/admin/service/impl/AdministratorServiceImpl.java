package com.cloudin.admin.service.impl;

import com.cloudin.admin.dao.AdministratorDAO;
import com.cloudin.admin.entity.Administrator;
import com.cloudin.admin.entity.AdministratorExample;
import com.cloudin.admin.service.AdministratorService;
import com.cloudin.commons.langs.entity.BaseResult;
import com.cloudin.commons.langs.support.datatables.DTRequest;
import com.cloudin.commons.langs.support.datatables.DTResponse;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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
	public BaseResult add(Administrator administrator) {
		BaseResult result = BaseResult.build();
		if(StringUtils.isEmpty(administrator.getAccount())) {
			return result.error(20001, "管理员账号不能为空");
		}
		if(StringUtils.isEmpty(administrator.getEmail())) {
			return result.error(20001, "管理员邮箱不能为空");
		}
		if(StringUtils.isEmpty(administrator.getMobile())) {
			return result.error(20001, "管理员手机号不能为空");
		}
		administrator.setId(null);
		administrator.setFreeze(false);
		administrator.setDisabled(false);
		administrator.setUpdateTime(null);
		administrator.setCreateTime(null);
		administrator.setValid(true);
		administratorDAO.insertSelective(administrator);
		return result.success();
	}
	
	@Override
	public BaseResult update(Administrator administrator) {
		BaseResult result = BaseResult.build();
		if(administrator.getId() == null || administrator.getId() <= 0) {
			return result.error(20001, "参数错误");
		}

		Administrator oldAdministrator = get(administrator.getId());
		if(oldAdministrator == null) {
			return result.error(20002, "管理员信息不存在");
		}
		
		if(StringUtils.isEmpty(administrator.getAccount())) {
			administrator.setAccount(null);
		}
		if(StringUtils.isEmpty(administrator.getEmail())) {
			administrator.setEmail(null);
		}
		if(StringUtils.isEmpty(administrator.getMobile())) {
			administrator.setMobile(null);
		}
		// 账号不允许修改
		administrator.setAccount(null);
		// 账号不允许修改
		administrator.setPassword(null);
		administrator.setUpdateTime(null);
		administrator.setCreateTime(null);
		administrator.setValid(true);
		administratorDAO.updateByPrimaryKeySelective(administrator);
		return result.success();
	}
	
	@Override
	public BaseResult delete(Integer administratorId) {
		BaseResult result = BaseResult.build();
		if(administratorId == null || administratorId <= 0) {
			return result.error(20001, "参数错误");
		}
		Administrator oldAdministrator = get(administratorId);
		if(oldAdministrator == null) {
			return result.error(20002, "管理员信息不存在");
		}

		Administrator administrator = new Administrator();
		administrator.setId(administratorId);
		administrator.setValid(false);
		administratorDAO.updateByPrimaryKeySelective(administrator);
		return result.success();
	}
	
	@Override
	public Administrator get(Integer id) {
		if(id == null || id <= 0) {
			return null;
		}
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
		criteria.andValidEqualTo(true);
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
		criteria.andValidEqualTo(true);
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
		criteria.andValidEqualTo(true);
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
		example.setOrderByClause("id desc");
		
		int count = (int) administratorDAO.countByExample(example);
		List<Administrator> list = administratorDAO.selectByExample(example);
		return new DTResponse<>(list, request.getDraw(), count);
	}
}
