package com.cloudin.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 * @table permission
 * @author MyBatis Generator
 * @version 1.0.0, 2018-06-06 18:01:51
 */
public class Permission implements Serializable {
	/**
	 *
	 *
	 * @column permission.id
	 */
	private Integer id;
	
	/**
	 * 权限名称
	 *
	 * @column permission.name
	 */
	private String name;
	
	/**
	 * 权限美容
	 *
	 * @column permission.content
	 */
	private String content;
	
	/**
	 * 图标
	 *
	 * @column permission.icon
	 */
	private String icon;
	
	/**
	 * 分类
	 *
	 * @column permission.category
	 */
	private Integer category;
	
	/**
	 * 排序
	 *
	 * @column permission.order
	 */
	private Integer order;
	
	/**
	 * 父级权限Id
	 *
	 * @column permission.parent_id
	 */
	private Integer parentId;
	
	/**
	 * 扩展信息
	 *
	 * @column permission.ext_info
	 */
	private String extInfo;
	
	/**
	 * 数据库记录创建时间
	 *
	 * @column permission.create_time
	 */
	private Date createTime;
	
	/**
	 * 数据库记录更新时间
	 *
	 * @column permission.update_time
	 */
	private Date updateTime;
	
	/**
	 * 是否有效：1、有效；0、无效
	 *
	 * @column permission.is_valid
	 */
	private Boolean valid;
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @column permission.id
	 *
	 * @return
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * @column permission.id
	 *
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * @column permission.name
	 *
	 * @return 权限名称
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @column permission.name
	 *
	 * @param name 权限名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @column permission.content
	 *
	 * @return 权限美容
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * @column permission.content
	 *
	 * @param content 权限美容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * @column permission.icon
	 *
	 * @return 图标
	 */
	public String getIcon() {
		return icon;
	}
	
	/**
	 * @column permission.icon
	 *
	 * @param icon 图标
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	/**
	 * @column permission.category
	 *
	 * @return 分类
	 */
	public Integer getCategory() {
		return category;
	}
	
	/**
	 * @column permission.category
	 *
	 * @param category 分类
	 */
	public void setCategory(Integer category) {
		this.category = category;
	}
	
	/**
	 * @column permission.order
	 *
	 * @return 排序
	 */
	public Integer getOrder() {
		return order;
	}
	
	/**
	 * @column permission.order
	 *
	 * @param order 排序
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}
	
	/**
	 * @column permission.parent_id
	 *
	 * @return 父级权限Id
	 */
	public Integer getParentId() {
		return parentId;
	}
	
	/**
	 * @column permission.parent_id
	 *
	 * @param parentId 父级权限Id
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	/**
	 * @column permission.ext_info
	 *
	 * @return 扩展信息
	 */
	public String getExtInfo() {
		return extInfo;
	}
	
	/**
	 * @column permission.ext_info
	 *
	 * @param extInfo 扩展信息
	 */
	public void setExtInfo(String extInfo) {
		this.extInfo = extInfo;
	}
	
	/**
	 * @column permission.create_time
	 *
	 * @return 数据库记录创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * @column permission.create_time
	 *
	 * @param createTime 数据库记录创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * @column permission.update_time
	 *
	 * @return 数据库记录更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * @column permission.update_time
	 *
	 * @param updateTime 数据库记录更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	/**
	 * @column permission.is_valid
	 *
	 * @return 是否有效：1、有效；0、无效
	 */
	public Boolean getValid() {
		return valid;
	}
	
	/**
	 * @column permission.is_valid
	 *
	 * @param valid 是否有效：1、有效；0、无效
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}