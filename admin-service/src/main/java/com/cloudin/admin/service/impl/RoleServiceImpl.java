package com.cloudin.admin.service.impl;

import com.cloudin.admin.dao.RoleDAO;
import com.cloudin.admin.entity.Role;
import com.cloudin.admin.entity.RoleExample;
import com.cloudin.admin.service.RoleService;
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
 * @version 1.0.0, 2018/6/6 0006 17:46
 */
@Service
public class RoleServiceImpl implements RoleService {
	
	@Resource
	private RoleDAO roleDAO;
	
	@Override
	public BaseResult add(Role role) {
		BaseResult result = BaseResult.build();
		if(StringUtils.isEmpty(role.getCode())) {
			return result.error(20001, "角色标识不能为空");
		}
		if(StringUtils.isEmpty(role.getName())) {
			return result.error(20001, "角色名称不能为空");
		}

		role.setId(null);
		role.setUpdateTime(null);
		role.setCreateTime(null);
		role.setValid(true);
		roleDAO.insertSelective(role);
		return result.success();
	}
	
	@Override
	public BaseResult update(Role role) {
		BaseResult result = BaseResult.build();
		if(role.getId() == null || role.getId() <= 0) {
			return result.error(20001, "参数错误");
		}
		if(StringUtils.isEmpty(role.getCode())) {
			return result.error(20001, "角色标识不能为空");
		}
		if(StringUtils.isEmpty(role.getName())) {
			return result.error(20001, "角色名称不能为空");
		}
		
		if(get(role.getId()) == null) {
			return result.error(20001, "角色信息不存在");
		}
		
		role.setUpdateTime(null);
		role.setCreateTime(null);
		role.setValid(true);
		roleDAO.updateByPrimaryKeySelective(role);
		return result.success();
	}
	
	@Override
	public BaseResult delete(Integer roleId) {
		BaseResult result = BaseResult.build();
		if(roleId == null || roleId <= 0) {
			return result.error(20001, "参数错误");
		}
		
		if(get(roleId) == null) {
			return result.error(20001, "角色信息不存在");
		}
		Role updateRole = new Role();
		updateRole.setId(roleId);
		updateRole.setValid(false);
		roleDAO.updateByPrimaryKeySelective(updateRole);
		return result.success();
	}
	
	@Override
	public Role get(Integer roleId) {
		RoleExample example = new RoleExample();
		example.createCriteria().andIdEqualTo(roleId).andValidEqualTo(true);
		
		List<Role> list = roleDAO.selectByExample(example);
		if(CollectionUtils.isNotEmpty(list)) {
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public DTResponse<Role> listWithPage(DTRequest request) {
		RoleExample example = new RoleExample();
		example.createCriteria().andValidEqualTo(true);
		example.setOffset(request.getStart());
		example.setLimit(request.getLength());
		
		int count = (int) roleDAO.countByExample(example);
		List<Role> list = roleDAO.selectByExample(example);
		
		return new DTResponse<>(list, request.getDraw(), count);
	}
	
	@Override
	public List<Role> listAll() {
		return roleDAO.selectByExample(new RoleExample());
	}
}
