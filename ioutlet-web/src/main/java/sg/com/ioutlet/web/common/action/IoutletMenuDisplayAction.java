package sg.com.ioutlet.web.common.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import sg.com.ioutlet.model.IoutletFunction;
import sg.com.ioutlet.web.main.menu.MenuGroup;
import sg.com.ioutlet.web.main.menu.MenuLink;

public class IoutletMenuDisplayAction extends IoutletAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DOMAIN_ID="IOLT";
	List<MenuGroup> menu;

	
	public List<MenuGroup> generateMenus(AccessController ac) {

		List<MenuGroup> mainMenu = new ArrayList<MenuGroup>();
		LinkedHashMap<IoutletFunction, MenuLink> dashboadMenu = new LinkedHashMap<IoutletFunction, MenuLink>();
		if (ac.getDashBoardAccess())
		{
			dashboadMenu.put(IoutletFunction.IOLT_DASH_BOARD, new MenuLink("fa fa-dashboard","dashboard", "/dashboard", "index", getText("dash.board")));
		}		

		
		if (dashboadMenu.size() > 0)
		{
			mainMenu.add(new MenuGroup("fa fa-dashboard",getText("dash.board"), dashboadMenu));
		}
		

		
		LinkedHashMap<IoutletFunction, MenuLink> productsMenu = new LinkedHashMap<IoutletFunction, MenuLink>();
		
		
		if (ac.getProductsAccess())
		{
			productsMenu.put(IoutletFunction.IOLT_PRODUCTS, new MenuLink("fa fa-tags","products", "/product", "index", getText("products")));
		}

		
		if (dashboadMenu.size() > 0)
		{
			mainMenu.add(new MenuGroup("fa fa-tags",getText("products"), productsMenu));
		}
		

		
		
		LinkedHashMap<IoutletFunction, MenuLink> ordersMenu = new LinkedHashMap<IoutletFunction, MenuLink>();
		
		if(ac.getOrdersAccess()){
			ordersMenu.put(IoutletFunction.IOLT_ORDERS, new MenuLink("fa fa-edit","orders", "/orders", "index", getText("orders")));
		}

		if (ordersMenu.size() > 0)
		{
			mainMenu.add(new MenuGroup("fa fa-edit",getText("orders"), ordersMenu));
		}
		
		
		
		LinkedHashMap<IoutletFunction, MenuLink> collectionsMenu = new LinkedHashMap<IoutletFunction, MenuLink>();
		
		if(ac.getCollectionAccess()){
			collectionsMenu.put(IoutletFunction.IOLT_COLLECTIONS, new MenuLink("fa  fa-suitcase","collections", "/collections", "index", getText("orders")));
		}

		if (collectionsMenu.size() > 0)
		{
			mainMenu.add(new MenuGroup("fa  fa-suitcase",getText("collections"), collectionsMenu));
		}
		
		
		
		
		LinkedHashMap<IoutletFunction, MenuLink> discountsMenu = new LinkedHashMap<IoutletFunction, MenuLink>();
		
		if(ac.getDiscountsAccess()){
			discountsMenu.put(IoutletFunction.IOLT_DISCOUNTS, new MenuLink("fa   fa-scissors","discounts", "/discounts", "index", getText("orders")));
		}

		if (discountsMenu.size() > 0)
		{
			mainMenu.add(new MenuGroup("fa   fa-scissors",getText("discounts"), discountsMenu));
		}
		
		
		
		LinkedHashMap<IoutletFunction, MenuLink> chartsMenu = new LinkedHashMap<IoutletFunction, MenuLink>();
		
		if(ac.getSalesChartsAccess()){
			chartsMenu.put(IoutletFunction.IOLT_SALES_CHART, new MenuLink("fa fa-area-chart","saleschart", "/saleschart", "index", getText("saleschart")));
		}
		
		if(ac.getCustomerChartsAccess()){
			chartsMenu.put(IoutletFunction.IOLT_CUST_CHART, new MenuLink("fa fa-bar-chart","custchart", "/custchart", "index", getText("custchart")));
		}

		if (chartsMenu.size() > 0)
		{
			mainMenu.add(new MenuGroup("fa  fa-pie-chart",getText("charts"), chartsMenu));
		}
		
		
		LinkedHashMap<IoutletFunction, MenuLink> outletsMenu = new LinkedHashMap<IoutletFunction, MenuLink>();
		if(ac.getStaffAccess()){
			outletsMenu.put(IoutletFunction.IOLT_STAFF, new MenuLink("fa fa-user","staff", "/staff", "index", getText("staff")));
		}
		
		if(ac.getOutletAccess()){
			outletsMenu.put(IoutletFunction.IOLT_CUST_CHART, new MenuLink("fa  fa-cubes","outlets", "/oulets", "index", getText("outlet")));
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
	
		return IoutletFunction.IOLT_SIDE_MENU.toString();
	}

}
