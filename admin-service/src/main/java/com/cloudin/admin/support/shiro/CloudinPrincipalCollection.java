package com.cloudin.admin.support.shiro;

import com.cloudin.admin.entity.vo.AdministratorVO;
import org.apache.shiro.subject.SimplePrincipalCollection;

/**
 * @author 小天
 * @version 1.0.0, 2018/6/27 0027 17:13
 */
public class CloudinPrincipalCollection extends SimplePrincipalCollection {
	
	private AdministratorVO primaryPrincipal;
	
	public void setPrimaryPrincipal(AdministratorVO primaryPrincipal, String realmName) {
		this.primaryPrincipal = primaryPrincipal;
		add(primaryPrincipal, realmName);
	}
	
	@Override
	public Object getPrimaryPrincipal() {
		return primaryPrincipal;
	}
	
}
