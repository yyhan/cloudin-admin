package com.cloudin.admin.service.impl;

import com.cloudin.admin.dao.PermissionDAO;
import com.cloudin.admin.entity.Permission;
import com.cloudin.admin.entity.PermissionExample;
import com.cloudin.admin.service.PermissionService;
import com.cloudin.commons.langs.support.datatables.DTRequest;
import com.cloudin.commons.langs.support.datatables.DTResponse;
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
