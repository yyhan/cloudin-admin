package com.cloudin.admin.bean;

import java.util.List;

/**
 * @author 小天
 * @version 1.0.0, 2018/6/5 0005 16:21
 */
public class MenuItem {
	
	/**
	 * 菜单Id
	 */
	private Integer id;
	/**
	 * 菜单名称
	 */
	private String name;
	/**
	 * 菜单地址
	 */
	private String url;
	/**
	 * 菜单图标
	 */
	private String icon;
	/**
	 * 分类
	 */
	private Integer type;
	/**
	 * 菜单排序
	 */
	private Integer order;
	/**
	 * 扩展信息
	 */
	private String extInfo;
	
	/**
	 * 父级菜单Id
	 */
	private Integer parentId;
	
	/**
	 * 子菜单
	 */
	private List<MenuItem> subMenus;
	
	public MenuItem() {
	}
	
	public MenuItem(Integer id, String name, String url, String icon) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.icon = icon;
	}
	
	public MenuItem(Integer id, String name, String url, String icon, Integer parentId) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.icon = icon;
		this.parentId = parentId;
	}
	
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
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getIcon() {
		return icon;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public Integer getType() {
		return type;
	}
	
	public void setType(Integer type) {
		this.type = type;
	}
	
	public Integer getOrder() {
		return order;
	}
	
	public void setOrder(Integer order) {
		this.order = order;
	}
	
	public String getExtInfo() {
		return extInfo;
	}
	
	public void setExtInfo(String extInfo) {
		this.extInfo = extInfo;
	}
	
	public Integer getParentId() {
		return parentId;
	}
	
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	public List<MenuItem> getSubMenus() {
		return subMenus;
	}
	
	public void setSubMenus(List<MenuItem> subMenus) {
		this.subMenus = subMenus;
	}
}
