package sg.com.ioutlet.web.app.product.form;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import sg.com.ioutlet.model.category.Category;
import sg.com.ioutlet.model.image.Image;
import sg.com.ioutlet.model.product.Product;
import sg.com.ioutlet.web.common.form.IoutletForm;

import com.opensymphony.xwork2.ActionSupport;

public class ProductForm extends IoutletForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String productName;
	
	private String sku;
	
	private BigDecimal productPrice;
	
	private boolean visibility;
	
	private List<Product> data;
	
	private List<Category> catlist;
	
	private int minQty;
	
	private int qty;
	
    private List<Image> prodImage;
    
    private List<String> productOption;

	
	@Override
	public Map<String, String> validate() {
		return null;
	}

	@Override
	public void reset() {
			
	}

	@Override
	public boolean validate(ActionSupport as) {
		return false;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public List<Product> getData() {
		return data;
	}

	public void setData(List<Product> data) {
		this.data = data;
	}

	public boolean isVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	public List<Category> getCatlist() {
		return catlist;
	}

	public void setCatlist(List<Category> catlist) {
		this.catlist = catlist;
	}

	public int getMinQty() {
		return minQty;
	}

	public void setMinQty(int minQty) {
		this.minQty = minQty;
	}

	public List<Image> getProdImage() {
		return prodImage;
	}

	public void setProdImage(List<Image> prodImage) {
		this.prodImage = prodImage;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public List<String> getProductOption() {
		return productOption;
	}

	public void setProductOption(List<String> productOption) {
		this.productOption = productOption;
	}

	

	
	

}
