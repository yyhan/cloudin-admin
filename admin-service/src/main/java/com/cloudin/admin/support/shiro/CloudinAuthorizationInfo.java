package com.cloudin.admin.support.shiro;

import org.apache.shiro.authz.SimpleAuthorizationInfo;

/**
 * @author 小天
 * @version 1.0.0, 2018/6/7 0007 15:23
 */
public class CloudinAuthorizationInfo extends SimpleAuthorizationInfo {
	
	private boolean expire = false;
	
	public boolean isExpire() {
		return expire;
	}
	
	public void setExpire(boolean expire) {
		this.expire = expire;
	}
}
