package sg.com.ioutlet.vo;

import java.math.BigDecimal;
import java.util.List;

import sg.com.ioutlet.model.Rating;
import sg.com.ioutlet.model.category.Category;
import sg.com.ioutlet.model.outlet.Outlet;
import sg.com.ioutlet.model.product.option.ProductOption;

public class ProductVo extends CommonVo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
	private int balance;

	private Category category;

	private String currencyCode;
	
	private String description;

	private String name;

	private Rating ratingCode;

	private int salesCounting=0;

	private Outlet outlet;

	private BigDecimal unitPrice;

	private int viewCounting=0;
	
	private  List<ProductOption> productOptions;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Rating getRatingCode() {
		return ratingCode;
	}

	public void setRatingCode(Rating ratingCode) {
		this.ratingCode = ratingCode;
	}

	public int getSalesCounting() {
		return salesCounting;
	}

	public void setSalesCounting(int salesCounting) {
		this.salesCounting = salesCounting;
	}

	public Outlet getOutlet() {
		return outlet;
	}

	public void setOutlet(Outlet outlet) {
		this.outlet = outlet;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getViewCounting() {
		return viewCounting;
	}

	public void setViewCounting(int viewCounting) {
		this.viewCounting = viewCounting;
	}

	public List<ProductOption> getProductOptions() {
		return productOptions;
	}

	public void setProductOptions(List<ProductOption> productOptions) {
		this.productOptions = productOptions;
	}
}
