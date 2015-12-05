package  sg.com.ioutlet.web.common.action;

import java.util.Set;

import sg.com.ioutlet.framework.authorization.model.IoutletFunction;

public class AccessController {
	private Set<IoutletFunction> accessFunctionIds;

	public AccessController(Set<IoutletFunction> accessFunctionIds)
	{
		this.accessFunctionIds = accessFunctionIds;
	}

	public boolean getDashBoardAccess()
	{
		if (accessFunctionIds.contains(IoutletFunction.ALL_FUNC)) return true;
		return accessFunctionIds.contains(IoutletFunction.IOLT_DASH_BOARD);
	}

	
	
	public boolean getProductsAccess()
	{
		if (accessFunctionIds.contains(IoutletFunction.ALL_FUNC)) return true;
		return accessFunctionIds.contains(IoutletFunction.IOLT_PRODUCTS);
	}


	public boolean getOrdersAccess()
	{
		if (accessFunctionIds.contains(IoutletFunction.ALL_FUNC)) return true;
		return accessFunctionIds.contains(IoutletFunction.IOLT_ORDERS);
	}


	public boolean getPaymentsAccess()
	{
		if (accessFunctionIds.contains(IoutletFunction.ALL_FUNC)) return true;
		return accessFunctionIds.contains(IoutletFunction.IOLT_PAYMENTS);
	}


	public boolean getCustomersAccess()
	{
		if (accessFunctionIds.contains(IoutletFunction.ALL_FUNC)) return true;
		return accessFunctionIds.contains(IoutletFunction.IOLT_CUSTOMERS);
	}

	public boolean getIOutletsAccess()
	{
		if (accessFunctionIds.contains(IoutletFunction.ALL_FUNC)) return true;
		return accessFunctionIds.contains(IoutletFunction.IOLT_OUTLETS);
	}

	public boolean getSalesChartsAccess() {
		if (accessFunctionIds.contains(IoutletFunction.ALL_FUNC)) return true;
		return accessFunctionIds.contains(IoutletFunction.IOLT_SALES_CHART);
	}

	public boolean getCustomerChartsAccess() {
		if (accessFunctionIds.contains(IoutletFunction.ALL_FUNC)) return true;
		return accessFunctionIds.contains(IoutletFunction.IOLT_CUST_CHART);
	
	}

	public boolean getCollectionAccess() {
		if (accessFunctionIds.contains(IoutletFunction.ALL_FUNC)) return true;
		return accessFunctionIds.contains(IoutletFunction.IOLT_COLLECTIONS);
	}

	public boolean getDiscountsAccess() {
		if (accessFunctionIds.contains(IoutletFunction.ALL_FUNC)) return true;
		return accessFunctionIds.contains(IoutletFunction.IOLT_DISCOUNTS);
	}

	public boolean getStaffAccess() {
		if (accessFunctionIds.contains(IoutletFunction.ALL_FUNC)) return true;
		return accessFunctionIds.contains(IoutletFunction.IOLT_STAFF);
	}

	public boolean getOutletAccess() {
		if (accessFunctionIds.contains(IoutletFunction.ALL_FUNC)) return true;
		return accessFunctionIds.contains(IoutletFunction.IOLT_OUTLETS);
	}

     


}
