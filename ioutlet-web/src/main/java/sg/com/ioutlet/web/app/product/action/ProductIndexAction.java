package sg.com.ioutlet.web.app.product.action;

import sg.com.ioutlet.framework.web.form.CommonForm;
import sg.com.ioutlet.model.IoutletFunction;
import sg.com.ioutlet.web.app.product.form.ProductForm;
import sg.com.ioutlet.web.app.product.handler.ProductActionHandler;
import sg.com.ioutlet.web.common.action.IoutletAction;

public class ProductIndexAction extends IoutletAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Override
	protected CommonForm constructForm() {
		return new ProductForm();
	}

	
	

	@Override
	public String getFunctionId() {
		return IoutletFunction.IOLT_PRODUCTS.toString();
	}


	@Override
	protected String onSubmit() {
		ProductForm form = (ProductForm) getModel();
		ProductActionHandler handler = new ProductActionHandler(this);
		handler.getProducts("ABC");
		form.setProductName("Males Shirt");
		
		
		return SUCCESS;
	}


	@Override
	protected String onLoad() {
		
		System.out.println(this.getSfld());
	
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
