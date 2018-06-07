package com.cloudin.admin.service.impl;

import com.cloudin.admin.dao.PermissionDAO;
import com.cloudin.admin.entity.Permission;
import com.cloudin.admin.entity.PermissionExample;
import com.cloudin.admin.service.PermissionService;
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
public class PermissionServiceImpl implements PermissionService {
	
	@Resource
	private PermissionDAO permissionDAO;
	
	@Override
	public BaseResult add(Permission permission) {
		BaseResult result = BaseResult.build();
		
		if(StringUtils.isEmpty(permission.getName())) {
			return result.error(20001, "权限名称不能为空");
		}
		if(StringUtils.isEmpty(permission.getContent())) {
			return result.error(20001, "权限内容不能为空");
		}
		if(permission.getOrder() == null) {
			permission.setOrder(0);
		}
		if(permission.getParentId() == null || permission.getParentId() < 0) {
			permission.setParentId(0);
		}
		
		permission.setId(null);
		permission.setUpdateTime(null);
		permission.setCreateTime(null);
		permission.setValid(true);
		permissionDAO.insertSelective(permission);
		return result.success();
	}
	
	@Override
	public BaseResult update(Permission permission) {
		BaseResult result = BaseResult.build();
		if(permission.getId() == null || permission.getId() <= 0) {
			return result.error(20001, "参数错误");
		}
		if(StringUtils.isEmpty(permission.getName())) {
			return result.error(20001, "权限名称不能为空");
		}
		if(StringUtils.isEmpty(permission.getContent())) {
			return result.error(20001, "权限内容不能为空");
		}
		if(permission.getOrder() == null) {
			permission.setOrder(0);
		}
		if(permission.getParentId() == null || permission.getParentId() < 0) {
			permission.setParentId(0);
		}
		
		permission.setUpdateTime(null);
		permission.setCreateTime(null);
		permission.setValid(true);
		permissionDAO.updateByPrimaryKeySelective(permission);
		return result.success();
	}
	
	@Override
	public BaseResult delete(Integer id) {
		BaseResult result = BaseResult.build();
		if(id == null || id <= 0) {
			return result.error(20001, "参数错误");
		}
		
		if(get(id) == null) {
			return result.error(20001, "权限信息不存在");
		}
		Permission updateRole = new Permission();
		updateRole.setId(id);
		updateRole.setValid(false);
		permissionDAO.updateByPrimaryKeySelective(updateRole);
		return result.success();
	}
	
	@Override
	public Permission get(Integer id) {
		if(id == null || id <= 0) {
			return null;
		}
		PermissionExample example = new PermissionExample();
		example.createCriteria().andIdEqualTo(id).andValidEqualTo(true);
		
		List<Permission> list = permissionDAO.selectByExample(example);
		if(CollectionUtils.isNotEmpty(list)) {
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public DTResponse<Permission> listWithPage(DTRequest request) {
		PermissionExample example = new PermissionExample();
		example.createCriteria().andValidEqualTo(true);
		example.setOffset(request.getStart());
		example.setLimit(request.getLength());
		
		int count = (int) permissionDAO.countByExample(example);
		List<Permission> list = permissionDAO.selectByExample(example);
		
		return new DTResponse<>(list, request.getDraw(), count);
	}
}
