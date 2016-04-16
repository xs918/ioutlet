package sg.com.ioutlet.web.app.product.action.formflow;

import java.io.File;

import sg.com.ioutlet.framework.authorization.model.IoltFunction;
import sg.com.ioutlet.framework.web.form.CommonForm;
import sg.com.ioutlet.web.app.product.form.ProductForm;
import sg.com.ioutlet.web.common.action.IoutletAction;

public class ProductConfirmAction extends IoutletAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected CommonForm constructForm() {
		
		return new ProductForm();
	}

	@Override
	protected String onSubmit() {
		
		System.out.println("onSubmit product detail");
		ProductForm form = (ProductForm) getModel();
		
		   int i = 0;
	        for (File f : form.getFile()) {
	            System.out.print("\nFile [" + i + "] ");
	            System.out.print(" length: " + f.length());
	      
	            i++;
	        }
	        System.out.println("\n---------------------------------------\n");
	       
			
			
		return SUCCESS;
	}
	
	
	public String doCustom()
	{
		
		return SUCCESS;
	}
	
	public String json() {
	
			return SUCCESS;
	}
	
	

	@Override
	public String getFunctionId() {
		return IoltFunction.IOLT_PRODUCTS.toString();
	}
	
	@Override
	protected String onLoad() {
		
			return INPUT;
		
	}

	
}
