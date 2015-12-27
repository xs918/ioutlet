package sg.com.ioutlet.web.common.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import sg.com.ioutlet.framework.authorization.model.IoltFunction;
import sg.com.ioutlet.web.main.menu.MenuGroup;
import sg.com.ioutlet.web.main.menu.MenuLink;

public class IoutletMenuDisplayAction extends IoutletDisplayAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DOMAIN_ID="IOLT";
	List<MenuGroup> menu;

	
	public List<MenuGroup> generateMenus(AccessController ac) {

		List<MenuGroup> mainMenu = new ArrayList<MenuGroup>();
		LinkedHashMap<IoltFunction, MenuLink> dashboadMenu = new LinkedHashMap<IoltFunction, MenuLink>();
		if (ac.getDashBoardAccess())
		{
			dashboadMenu.put(IoltFunction.IOLT_DASH_BOARD, new MenuLink("fa fa-dashboard","dashboard", "/dashboard", "index", getText("dash.board")));
		}		

		
		if (dashboadMenu.size() > 0)
		{
			mainMenu.add(new MenuGroup("fa fa-dashboard",getText("dash.board"), dashboadMenu));
		}
		

		
		LinkedHashMap<IoltFunction, MenuLink> productsMenu = new LinkedHashMap<IoltFunction, MenuLink>();
		
		
		if (ac.getProductsAccess())
		{
			productsMenu.put(IoltFunction.IOLT_PRODUCTS, new MenuLink("fa fa-tags","products", "/product", "index", getText("products")));
		}

		
		if (dashboadMenu.size() > 0)
		{
			mainMenu.add(new MenuGroup("fa fa-tags",getText("products"), productsMenu));
		}
		

		
		
		LinkedHashMap<IoltFunction, MenuLink> ordersMenu = new LinkedHashMap<IoltFunction, MenuLink>();
		
		if(ac.getOrdersAccess()){
			ordersMenu.put(IoltFunction.IOLT_ORDERS, new MenuLink("fa fa-edit","orders", "/orders", "index", getText("orders")));
		}

		if (ordersMenu.size() > 0)
		{
			mainMenu.add(new MenuGroup("fa fa-edit",getText("orders"), ordersMenu));
		}
		
		
		
		LinkedHashMap<IoltFunction, MenuLink> collectionsMenu = new LinkedHashMap<IoltFunction, MenuLink>();
		
		if(ac.getCollectionAccess()){
			collectionsMenu.put(IoltFunction.IOLT_COLLECTIONS, new MenuLink("fa  fa-suitcase","collections", "/collections", "index", getText("orders")));
		}

		if (collectionsMenu.size() > 0)
		{
			mainMenu.add(new MenuGroup("fa  fa-suitcase",getText("collections"), collectionsMenu));
		}
		
		
		
		
		LinkedHashMap<IoltFunction, MenuLink> discountsMenu = new LinkedHashMap<IoltFunction, MenuLink>();
		
		if(ac.getDiscountsAccess()){
			discountsMenu.put(IoltFunction.IOLT_DISCOUNTS, new MenuLink("fa   fa-scissors","discounts", "/discounts", "index", getText("orders")));
		}

		if (discountsMenu.size() > 0)
		{
			mainMenu.add(new MenuGroup("fa   fa-scissors",getText("discounts"), discountsMenu));
		}
		
		
		
		LinkedHashMap<IoltFunction, MenuLink> chartsMenu = new LinkedHashMap<IoltFunction, MenuLink>();
		
		if(ac.getSalesChartsAccess()){
			chartsMenu.put(IoltFunction.IOLT_SALES_CHART, new MenuLink("fa fa-circle-o","saleschart", "/saleschart", "index", getText("saleschart")));
		}
		
		if(ac.getCustomerChartsAccess()){
			chartsMenu.put(IoltFunction.IOLT_CUST_CHART, new MenuLink("fa fa-circle-o","custchart", "/custchart", "index", getText("custchart")));
		}

		if (chartsMenu.size() > 0)
		{
			mainMenu.add(new MenuGroup("fa  fa-pie-chart",getText("charts"), chartsMenu));
		}
		
		
		LinkedHashMap<IoltFunction, MenuLink> outletsMenu = new LinkedHashMap<IoltFunction, MenuLink>();
		if(ac.getStaffAccess()){
			outletsMenu.put(IoltFunction.IOLT_STAFF, new MenuLink("fa fa-circle-o","staff", "/staff", "index", getText("staff")));
		}
		
		if(ac.getCustomersAccess()){
			outletsMenu.put(IoltFunction.IOLT_CUSTOMERS, new MenuLink("fa fa-circle-o","customers", "/customers", "index", getText("customers")));
		}
		
		
		
		if(ac.getOutletAccess()){
			outletsMenu.put(IoltFunction.IOLT_CUST_CHART, new MenuLink("fa fa-circle-o","outlets", "/oulets", "index", getText("outlet")));
		}

		if (outletsMenu.size() > 0)
		{
			mainMenu.add(new MenuGroup("fa  fa-institution",getText("outlets"), outletsMenu));
		}
		
		
		
       return mainMenu;
		
		
		
	
		
	}
	@Override
	protected String onLoad() {

		menu = generateMenus(getAccessControl());
	
		return INPUT;
	}
	@Override
	public String getDomainId() {
		

			return DOMAIN_ID;
		
	}
	@Override
	public String getFunctionId() {
		
		return IoltFunction.IOLT_SIDE_MENU.toString();
	}
	@Override
	protected String onSubmit() {
		
		return SUCCESS;
	}
	

}
