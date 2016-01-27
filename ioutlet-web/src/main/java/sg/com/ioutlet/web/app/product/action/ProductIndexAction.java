package sg.com.ioutlet.web.app.product.action;

import sg.com.ioutlet.framework.authorization.model.IoltFunction;
import sg.com.ioutlet.framework.web.form.CommonForm;
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
		return IoltFunction.IOLT_PRODUCTS.toString();
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
     ProductForm form = (ProductForm) getModel();
		
		ProductActionHandler handler = new ProductActionHandler(this);
		
		form.setData(handler.getAllProducts());
	
		return INPUT;
	}
	
	public String json() {
		System.out.println("********************json***************************");
			return SUCCESS;
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
