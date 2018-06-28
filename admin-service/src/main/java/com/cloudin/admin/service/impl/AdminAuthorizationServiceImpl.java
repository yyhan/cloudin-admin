package com.cloudin.admin.service.impl;

import com.cloudin.admin.bean.Menu;
import com.cloudin.admin.bean.MenuItem;
import com.cloudin.admin.dao.AdministratorRoleDAO;
import com.cloudin.admin.dao.AuthDao;
import com.cloudin.admin.dao.RoleDAO;
import com.cloudin.admin.entity.AdministratorRole;
import com.cloudin.admin.entity.AdministratorRoleExample;
import com.cloudin.admin.entity.Permission;
import com.cloudin.admin.entity.Role;
import com.cloudin.admin.entity.RoleExample;
import com.cloudin.admin.service.AdminAuthorizationService;
import com.cloudin.commons.langs.entity.BaseResult;
import com.sun.jersey.core.util.StringIgnoreCaseKeyComparator;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 小天
 * @version 1.0.0, 2018/6/6 0006 14:04
 */
@Service
public class AdminAuthorizationServiceImpl implements AdminAuthorizationService {
	
	@Resource
	private AuthDao authDao;
	
	@Resource
	private RoleDAO roleDAO;
	
	@Resource
	private AdministratorRoleDAO administratorRoleDAO;
	
	@Override
	public Menu get(Integer administratorId) {
		if(administratorId == null || administratorId <= 0) {
			return null;
		}
		List<Permission> permissionList = authDao.listPermission(administratorId);
		return convertToMenu(permissionList);
	}
	
	@Override
	public Menu getAll() {
		List<Permission> permissionList = authDao.listAllPermission();
		return convertToMenu(permissionList);
	}
	
	@Override
	public List<Role> listRoles(Integer administratorId) {
		return authDao.listRoles(administratorId);
	}
	
	@Override
	public Set<String> listRoleSet(Integer administratorId) {
		List<Role> roles = listRoles(administratorId);
		Set<String> roleCodeSet = new LinkedHashSet<>();
		for (Role role : roles) {
			roleCodeSet.add(role.getCode());
		}
		return roleCodeSet;
	}
	
	@Override
	public Map<String, Set<String>> listPermissionRolesMap() {
		List<Map<String, Object>> list = authDao.listPermissionRoleMap();
		if (CollectionUtils.isEmpty(list)) {
			return Collections.emptyMap();
		}
		Map<String, Set<String>> map = new HashMap<>((int) (list.size() * 0.75));
		for (Map<String, Object> item : list) {
			String content = (String) item.get("content");
			String code = (String) item.get("code");
			Set<String> permissionSet = map.get(content);
			if (permissionSet == null) {
				permissionSet = new HashSet<>();
				map.put(content, permissionSet);
			}
			permissionSet.add(code);
			
		}
		return map;
	}
	
	@Override
	public Set<String> listAllowedRoleCode(String url) {
		List<String> roles = authDao.listAllowedRoleCode(url);
		return new LinkedHashSet<>(roles);
	}
	
	@Override
	public BaseResult saveAdminRoles(Integer administratorId, List<Integer> roleIdList) {
		AdministratorRoleExample example = new AdministratorRoleExample();
		example.createCriteria().andAdministratorIdEqualTo(administratorId).andValidEqualTo(true);
		administratorRoleDAO.deleteByExample(example);
		if(CollectionUtils.isNotEmpty(roleIdList)) {
			administratorRoleDAO.batchInsertSelective(administratorId, roleIdList);
		}
		return BaseResult.build().success();
	}
	
	private Menu convertToMenu(List<Permission> permissionList) {
		List<MenuItem> menuItemList = new ArrayList<>(permissionList.size());
		Map<Integer, MenuItem> menuItemMap = new HashMap<>();
		for (Permission permission : permissionList) {
			if(permission.getCategory() != 1) {
				continue;
			}
			MenuItem menuItem = new MenuItem();
			menuItem.setId(permission.getId());
			menuItem.setName(permission.getName());
			menuItem.setIcon(permission.getIcon());
			menuItem.setUrl(permission.getContent());
			menuItem.setOrder(permission.getOrder());
			menuItem.setParentId(permission.getParentId());
			menuItem.setType(permission.getCategory());
			menuItem.setExtInfo(permission.getExtInfo());
			
			if (menuItem.getParentId() == null || menuItem.getParentId() <= 0) {
				menuItemMap.put(menuItem.getId(), menuItem);
			} else {
				menuItemList.add(menuItem);
			}
		}
		
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getParentId() == null || menuItem.getParentId() <= 0) {
				continue;
			}
			MenuItem parentMenu = menuItemMap.get(menuItem.getParentId());
			if (parentMenu != null) {
				List<MenuItem> subMenus = parentMenu.getSubMenus();
				if (subMenus == null) {
					subMenus = new ArrayList<>();
					parentMenu.setSubMenus(subMenus);
				}
				subMenus.add(menuItem);
			}
		}
		return new Menu(menuItemMap.values());
	}
}
