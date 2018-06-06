package com.cloudin.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @table role
 * @author MyBatis Generator
 * @version 1.0.0, 2018-06-06 14:52:53
 */
public class Role implements Serializable {
    /**
     * 
     * 
     * @column role.id
     */
    private Integer id;

    /**
     * 角色标识
     * 
     * @column role.code
     */
    private String code;

    /**
     * 角色名称
     * 
     * @column role.name
     */
    private String name;

    /**
     * 数据库记录创建时间
     * 
     * @column role.create_time
     */
    private Date createTime;

    /**
     * 数据库记录更新时间
     * 
     * @column role.update_time
     */
    private Date updateTime;

    /**
     * 是否有效：1、有效；0、无效
     * 
     * @column role.is_valid
     */
    private Boolean valid;

    private static final long serialVersionUID = 1L;

    /**
     * @column role.id
     * 
     * @return 
     */
    public Integer getId() {
        return id;
    }

    /**
     * @column role.id
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @column role.code
     * 
     * @return 角色标识
     */
    public String getCode() {
        return code;
    }

    /**
     * @column role.code
     * 
     * @param code 角色标识
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @column role.name
     * 
     * @return 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * @column role.name
     * 
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @column role.create_time
     * 
     * @return 数据库记录创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @column role.create_time
     * 
     * @param createTime 数据库记录创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @column role.update_time
     * 
     * @return 数据库记录更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @column role.update_time
     * 
     * @param updateTime 数据库记录更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @column role.is_valid
     * 
     * @return 是否有效：1、有效；0、无效
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * @column role.is_valid
     * 
     * @param valid 是否有效：1、有效；0、无效
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}