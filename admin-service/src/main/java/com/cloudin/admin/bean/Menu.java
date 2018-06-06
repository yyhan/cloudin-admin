package com.cloudin.admin.bean;

import java.util.Collection;

/**
 * @author 小天
 * @version 1.0.0, 2018/6/5 0005 17:28
 */
public class Menu {
	
	private Collection<MenuItem> menuItems;
	
	public Menu(Collection<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	
	public Collection<MenuItem> getMenuItems() {
		return menuItems;
	}
	
	public void setMenuItems(Collection<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
}
