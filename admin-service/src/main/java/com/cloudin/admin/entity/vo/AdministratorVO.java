package com.cloudin.admin.entity.vo;

import java.util.Date;

/**
 * @author 小天
 * @version 1.0.0, 2018/6/6 0006 13:55
 */
public class AdministratorVO {
	
	/**
	 *
	 */
	private Integer id;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 手机号
	 */
	private String mobile;
	
	/**
	 * 密码过期时间
	 */
	private Date passwordExpiredTime;
	
	/**
	 * 是否冻结登录：1、是；0、否
	 */
	private boolean freeze;
	
	/**
	 * 是否禁用：1、是；0、否
	 */
	private boolean disabled;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public Date getPasswordExpiredTime() {
		return passwordExpiredTime;
	}
	
	public void setPasswordExpiredTime(Date passwordExpiredTime) {
		this.passwordExpiredTime = passwordExpiredTime;
	}
	
	public boolean isFreeze() {
		return freeze;
	}
	
	public void setFreeze(boolean freeze) {
		this.freeze = freeze;
	}
	
	public boolean isDisabled() {
		return disabled;
	}
	
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
}
