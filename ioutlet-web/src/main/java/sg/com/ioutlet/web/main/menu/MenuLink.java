
package sg.com.ioutlet.web.main.menu;

import java.io.Serializable;

public class MenuLink implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String urlId;
	private String namespace;
	private String action;
	private String menuText;
	private String iconStyle;
		
	public MenuLink(String iconStyle,String urlId, String namespace, String action, String menuText){
		this.iconStyle = iconStyle;
		this.urlId= urlId;
		this.namespace = namespace;
		this.action = action;
		this.menuText = menuText;
	}
	
	public String getAction()
	{
		return action;
	}

	public void setAction(String action)
	{
		this.action = action;
	}

	public String getMenuText()
	{
		return menuText;
	}

	public void setMenuText(String menuText)
	{
		this.menuText = menuText;
	}

	public String getNamespace()
	{
		return namespace;
	}

	public void setNamespace(String namespace)
	{
		this.namespace = namespace;
	}

	public String getIconStyle() {
		return iconStyle;
	}

	public void setIconStyle(String iconStyle) {
		this.iconStyle = iconStyle;
	}

	public String getUrlId() {
		return urlId;
	}

	public void setUrlId(String urlId) {
		this.urlId = urlId;
	}
	
}
