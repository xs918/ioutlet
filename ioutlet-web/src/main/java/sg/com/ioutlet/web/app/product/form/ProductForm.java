package sg.com.ioutlet.web.app.product.form;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import sg.com.ioutlet.model.product.Product;
import sg.com.ioutlet.web.common.form.IoutletForm;

public class ProductForm extends IoutletForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String productName;
	
	private String productNumber;
	
	private BigDecimal productPrice;
	
	public List<Product> plist;
	
	
	@Override
	public Map<String, String> validate() {
		return null;
	}

	@Override
	public void reset() {
			
	}

	@Override
	public boolean validate(ActionSupport as) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public List<Product> getPlist() {
		return plist;
	}

	public void setPlist(List<Product> plist) {
		this.plist = plist;
	}

	

}
