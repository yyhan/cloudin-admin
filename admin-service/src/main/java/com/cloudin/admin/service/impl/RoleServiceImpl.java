package com.cloudin.admin.service.impl;

import com.cloudin.admin.dao.RoleDAO;
import com.cloudin.admin.entity.Role;
import com.cloudin.admin.entity.RoleExample;
import com.cloudin.admin.service.RoleService;
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
public class RoleServiceImpl implements RoleService {
	
	@Resource
	private RoleDAO roleDAO;
	
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
}
