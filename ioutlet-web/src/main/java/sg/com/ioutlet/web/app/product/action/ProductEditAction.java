package sg.com.ioutlet.web.app.product.action;

import sg.com.ioutlet.framework.authorization.model.IoltFunction;
import sg.com.ioutlet.framework.web.form.CommonForm;
import sg.com.ioutlet.web.app.product.form.ProductForm;
import sg.com.ioutlet.web.app.product.handler.ProductActionHandler;
import sg.com.ioutlet.web.common.action.IoutletAction;

public class ProductEditAction extends IoutletAction {

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
		return null;
	}

	@Override
	public String getFunctionId() {
		return IoltFunction.IOLT_PRODUCTS.toString();
	}
	
	@Override
	protected String onLoad() {
		ProductForm form = (ProductForm) getModel();
		ProductActionHandler handler = new ProductActionHandler(this);
		return INPUT;
	}

}
