package com.cloudin.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @table role_permission
 * @author MyBatis Generator
 * @version 1.0.0, 2018-06-06 14:52:53
 */
public class RolePermission implements Serializable {
    /**
     * 
     * 
     * @column role_permission.id
     */
    private Integer id;

    /**
     * 角色Id
     * 
     * @column role_permission.role_id
     */
    private Integer roleId;

    /**
     * 权限Id
     * 
     * @column role_permission.permission_id
     */
    private Integer permissionId;

    /**
     * 数据库记录创建时间
     * 
     * @column role_permission.create_time
     */
    private Date createTime;

    /**
     * 数据库记录更新时间
     * 
     * @column role_permission.update_time
     */
    private Date updateTime;

    /**
     * 是否有效：1、有效；0、无效
     * 
     * @column role_permission.is_valid
     */
    private Boolean valid;

    private static final long serialVersionUID = 1L;

    /**
     * @column role_permission.id
     * 
     * @return 
     */
    public Integer getId() {
        return id;
    }

    /**
     * @column role_permission.id
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @column role_permission.role_id
     * 
     * @return 角色Id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @column role_permission.role_id
     * 
     * @param roleId 角色Id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @column role_permission.permission_id
     * 
     * @return 权限Id
     */
    public Integer getPermissionId() {
        return permissionId;
    }

    /**
     * @column role_permission.permission_id
     * 
     * @param permissionId 权限Id
     */
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * @column role_permission.create_time
     * 
     * @return 数据库记录创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @column role_permission.create_time
     * 
     * @param createTime 数据库记录创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @column role_permission.update_time
     * 
     * @return 数据库记录更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @column role_permission.update_time
     * 
     * @param updateTime 数据库记录更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @column role_permission.is_valid
     * 
     * @return 是否有效：1、有效；0、无效
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * @column role_permission.is_valid
     * 
     * @param valid 是否有效：1、有效；0、无效
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}