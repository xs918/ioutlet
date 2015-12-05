package sg.com.ioutlet.web.main.menu;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import sg.com.ioutlet.framework.authorization.model.IoutletFunction;


public class MenuGroup implements Serializable
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String iconStyle;
	private String title;
	private HashMap<IoutletFunction, MenuLink> menus;
	

	

	
	public MenuLink getFirstMenu()
	{
	  List<MenuLink> menuList = new ArrayList<MenuLink>(menus.values());
	  return menuList.get(0);
	}
	
	
	public int getSize()
	{
	  List<MenuLink> menuList = new ArrayList<MenuLink>(menus.values());
	  return menuList.size();
	}
	
	
	
	public MenuGroup(String iconStyle,String title){
		this.iconStyle=iconStyle;
		this.title = title;
		menus = new HashMap<IoutletFunction, MenuLink>();

	}
	
	public MenuGroup(String iconStyle,String title, HashMap<IoutletFunction, MenuLink> menus){
		this.iconStyle=iconStyle;
		this.title = title;
		this.menus = menus;
	}
	


	public HashMap<IoutletFunction, MenuLink> getMenus()
	{
		return menus;
	}
	

	public void setMenus(HashMap<IoutletFunction, MenuLink> menus)
	{
		this.menus = menus;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	

	public String getIconStyle() {
		return iconStyle;
	}

	public void setIconStyle(String iconStyle) {
		this.iconStyle = iconStyle;
	}

	public void addMenu(IoutletFunction function, MenuLink menu){
		menus.put(function, menu);
	}
	
	public MenuLink getMenuByIOLTFunction(IoutletFunction function){
		return menus.get(function);
	}
}
