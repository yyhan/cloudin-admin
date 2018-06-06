package com.cloudin.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @table administrator
 * @author MyBatis Generator
 * @version 1.0.0, 2018-06-06 14:52:53
 */
public class Administrator implements Serializable {
    /**
     * 
     * 
     * @column administrator.id
     */
    private Integer id;

    /**
     * 登录账号
     * 
     * @column administrator.account
     */
    private String account;

    /**
     * 名称
     * 
     * @column administrator.name
     */
    private String name;

    /**
     * 邮箱
     * 
     * @column administrator.email
     */
    private String email;

    /**
     * 手机号
     * 
     * @column administrator.mobile
     */
    private String mobile;

    /**
     * 密码
     * 
     * @column administrator.password
     */
    private String password;

    /**
     * 密码过期时间
     * 
     * @column administrator.password_expired_time
     */
    private Date passwordExpiredTime;

    /**
     * 是否冻结登录：1、是；0、否
     * 
     * @column administrator.freeze
     */
    private Boolean freeze;

    /**
     * 是否禁用：1、是；0、否
     * 
     * @column administrator.disabled
     */
    private Boolean disabled;

    /**
     * 数据库记录创建时间
     * 
     * @column administrator.create_time
     */
    private Date createTime;

    /**
     * 数据库记录更新时间
     * 
     * @column administrator.update_time
     */
    private Date updateTime;

    /**
     * 是否有效：1、有效；0、无效
     * 
     * @column administrator.is_valid
     */
    private Boolean valid;

    private static final long serialVersionUID = 1L;

    /**
     * @column administrator.id
     * 
     * @return 
     */
    public Integer getId() {
        return id;
    }

    /**
     * @column administrator.id
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @column administrator.account
     * 
     * @return 登录账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * @column administrator.account
     * 
     * @param account 登录账号
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * @column administrator.name
     * 
     * @return 名称
     */
    public String getName() {
        return name;
    }

    /**
     * @column administrator.name
     * 
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @column administrator.email
     * 
     * @return 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * @column administrator.email
     * 
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @column administrator.mobile
     * 
     * @return 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @column administrator.mobile
     * 
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @column administrator.password
     * 
     * @return 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * @column administrator.password
     * 
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @column administrator.password_expired_time
     * 
     * @return 密码过期时间
     */
    public Date getPasswordExpiredTime() {
        return passwordExpiredTime;
    }

    /**
     * @column administrator.password_expired_time
     * 
     * @param passwordExpiredTime 密码过期时间
     */
    public void setPasswordExpiredTime(Date passwordExpiredTime) {
        this.passwordExpiredTime = passwordExpiredTime;
    }

    /**
     * @column administrator.freeze
     * 
     * @return 是否冻结登录：1、是；0、否
     */
    public Boolean getFreeze() {
        return freeze;
    }

    /**
     * @column administrator.freeze
     * 
     * @param freeze 是否冻结登录：1、是；0、否
     */
    public void setFreeze(Boolean freeze) {
        this.freeze = freeze;
    }

    /**
     * @column administrator.disabled
     * 
     * @return 是否禁用：1、是；0、否
     */
    public Boolean getDisabled() {
        return disabled;
    }

    /**
     * @column administrator.disabled
     * 
     * @param disabled 是否禁用：1、是；0、否
     */
    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    /**
     * @column administrator.create_time
     * 
     * @return 数据库记录创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @column administrator.create_time
     * 
     * @param createTime 数据库记录创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @column administrator.update_time
     * 
     * @return 数据库记录更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @column administrator.update_time
     * 
     * @param updateTime 数据库记录更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @column administrator.is_valid
     * 
     * @return 是否有效：1、有效；0、无效
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * @column administrator.is_valid
     * 
     * @param valid 是否有效：1、有效；0、无效
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}