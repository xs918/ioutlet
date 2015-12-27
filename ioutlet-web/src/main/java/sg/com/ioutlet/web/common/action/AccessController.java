package  sg.com.ioutlet.web.common.action;

import java.util.Set;

import sg.com.ioutlet.framework.authorization.model.IoltFunction;

public class AccessController {
	private Set<IoltFunction> accessFunctionIds;

	public AccessController(Set<IoltFunction> accessFunctionIds)
	{
		this.accessFunctionIds = accessFunctionIds;
	}

	public boolean getDashBoardAccess()
	{
		if (accessFunctionIds.contains(IoltFunction.ALL_FUNC)) return true;
		return accessFunctionIds.contains(IoltFunction.IOLT_DASH_BOARD);
	}

	
	
	public boolean getProductsAccess()
	{
		if (accessFunctionIds.contains(IoltFunction.ALL_FUNC)) return true;
		return accessFunctionIds.contains(IoltFunction.IOLT_PRODUCTS);
	}


	public boolean getOrdersAccess()
	{
		if (accessFunctionIds.contains(IoltFunction.ALL_FUNC)) return true;
		return accessFunctionIds.contains(IoltFunction.IOLT_ORDERS);
	}


	public boolean getPaymentsAccess()
	{
		if (accessFunctionIds.contains(IoltFunction.ALL_FUNC)) return true;
		return accessFunctionIds.contains(IoltFunction.IOLT_PAYMENTS);
	}


	public boolean getCustomersAccess()
	{
		if (accessFunctionIds.contains(IoltFunction.ALL_FUNC)) return true;
		return accessFunctionIds.contains(IoltFunction.IOLT_CUSTOMERS);
	}

	public boolean getIOutletsAccess()
	{
		if (accessFunctionIds.contains(IoltFunction.ALL_FUNC)) return true;
		return accessFunctionIds.contains(IoltFunction.IOLT_OUTLETS);
	}

	public boolean getSalesChartsAccess() {
		if (accessFunctionIds.contains(IoltFunction.ALL_FUNC)) return true;
		return accessFunctionIds.contains(IoltFunction.IOLT_SALES_CHART);
	}

	public boolean getCustomerChartsAccess() {
		if (accessFunctionIds.contains(IoltFunction.ALL_FUNC)) return true;
		return accessFunctionIds.contains(IoltFunction.IOLT_CUST_CHART);
	
	}

	public boolean getCollectionAccess() {
		if (accessFunctionIds.contains(IoltFunction.ALL_FUNC)) return true;
		return accessFunctionIds.contains(IoltFunction.IOLT_COLLECTIONS);
	}

	public boolean getDiscountsAccess() {
		if (accessFunctionIds.contains(IoltFunction.ALL_FUNC)) return true;
		return accessFunctionIds.contains(IoltFunction.IOLT_DISCOUNTS);
	}

	public boolean getStaffAccess() {
		if (accessFunctionIds.contains(IoltFunction.ALL_FUNC)) return true;
		return accessFunctionIds.contains(IoltFunction.IOLT_STAFF);
	}

	public boolean getOutletAccess() {
		if (accessFunctionIds.contains(IoltFunction.ALL_FUNC)) return true;
		return accessFunctionIds.contains(IoltFunction.IOLT_OUTLETS);
	}

     


}
