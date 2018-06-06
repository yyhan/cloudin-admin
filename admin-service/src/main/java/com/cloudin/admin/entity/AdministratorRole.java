package com.cloudin.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @table administrator_role
 * @author MyBatis Generator
 * @version 1.0.0, 2018-06-06 14:52:53
 */
public class AdministratorRole implements Serializable {
    /**
     * 
     * 
     * @column administrator_role.id
     */
    private Integer id;

    /**
     * 管理员Id
     * 
     * @column administrator_role.administrator_id
     */
    private Integer administratorId;

    /**
     * 角色Id
     * 
     * @column administrator_role.role_id
     */
    private Integer roleId;

    /**
     * 数据库记录创建时间
     * 
     * @column administrator_role.create_time
     */
    private Date createTime;

    /**
     * 数据库记录更新时间
     * 
     * @column administrator_role.update_time
     */
    private Date updateTime;

    /**
     * 是否有效：1、有效；0、无效
     * 
     * @column administrator_role.is_valid
     */
    private Boolean valid;

    private static final long serialVersionUID = 1L;

    /**
     * @column administrator_role.id
     * 
     * @return 
     */
    public Integer getId() {
        return id;
    }

    /**
     * @column administrator_role.id
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @column administrator_role.administrator_id
     * 
     * @return 管理员Id
     */
    public Integer getAdministratorId() {
        return administratorId;
    }

    /**
     * @column administrator_role.administrator_id
     * 
     * @param administratorId 管理员Id
     */
    public void setAdministratorId(Integer administratorId) {
        this.administratorId = administratorId;
    }

    /**
     * @column administrator_role.role_id
     * 
     * @return 角色Id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @column administrator_role.role_id
     * 
     * @param roleId 角色Id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @column administrator_role.create_time
     * 
     * @return 数据库记录创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @column administrator_role.create_time
     * 
     * @param createTime 数据库记录创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @column administrator_role.update_time
     * 
     * @return 数据库记录更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @column administrator_role.update_time
     * 
     * @param updateTime 数据库记录更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @column administrator_role.is_valid
     * 
     * @return 是否有效：1、有效；0、无效
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * @column administrator_role.is_valid
     * 
     * @param valid 是否有效：1、有效；0、无效
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}