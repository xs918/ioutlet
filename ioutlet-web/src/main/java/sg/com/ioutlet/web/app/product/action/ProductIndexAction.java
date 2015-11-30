package sg.com.ioutlet.web.app.product.action;

import sg.com.ioutlet.model.IoutletFunction;
import sg.com.ioutlet.web.common.action.IoutletDisplayAction;

public class ProductIndexAction extends IoutletDisplayAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getFunctionId() {
		return IoutletFunction.IOLT_PRODUCTS.toString();
	}


	@Override
	protected String onSubmit() {
		
		return SUCCESS;
	}


	@Override
	protected String onLoad() {
	
		return INPUT;
	}
	
	@Override
	public String getPageContentHeader()
	{

		
		
		return getText("products");
	}
	
	@Override
	public String getPageOptionaldescription()
	{
		return getText("click on a product to edit its info, images and more");
	}
	
	
	



}
