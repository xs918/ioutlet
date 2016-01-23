package sg.com.ioutlet.model.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import sg.com.ioutlet.bas.CommonPojo;
import sg.com.ioutlet.bas.CommonPojoKey;
import sg.com.ioutlet.model.Rating;
import sg.com.ioutlet.model.category.Category;
import sg.com.ioutlet.model.outlet.Outlet;
import sg.com.ioutlet.model.product.option.ProductOption;



public class Product  extends CommonPojo  {
	private static final long serialVersionUID = 1L;
	
	public static final String ENTITY_NAME = "Product";

	public enum Field
	{
		 key,
		 id(50),
		 name(50),
		 description(200),
		 unitPrice(16,2),
		 currencyCode(3),
		 category,
		 outlet,
		 salesCounting(11),
		 viewCounting(11),
         ratingCode(2),
         balance(11);
		 
		 
		 
		 public int length = 255;
		 public int precision;
		 public int scale;
		private Field()
		{
		}
		
		private Field(int length)
		{
			this.length = length;
		}
		
		private Field(int precision, int scale)
		{
			this.precision = precision;
			this.scale = scale;
		}
	}

	private ProductKey key;

	private int balance;

	private Category category;

	private String currencyCode;
	

	private String description;

	private String id;

	private String name;

	private Rating ratingCode;

	private int salesCounting=0;

	private Outlet outlet;

	private BigDecimal unitPrice;

	private int viewCounting=0;
	
	private  List<ProductOption> productOptions;
	

	public Product() {
		key = new ProductKey();
		
	}

	
	public Product(ProductKey key) {
		
		this.key = key;
		
	}


	public int getBalance() {
		return this.balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getSalesCounting() {
		return this.salesCounting;
	}

	public void setSalesCounting(int salesCounting) {
		this.salesCounting = salesCounting;
	}

	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getViewCounting() {
		return this.viewCounting;
	}

	public void setViewCounting(int viewCounting) {
		this.viewCounting = viewCounting;
	}

	@Override
	public String entityName() {
		return ENTITY_NAME;
	}

	@Override
	public ProductKey getKey() {
		 return key;
	}

	@Override
	public void setKey(CommonPojoKey key) {
		setKey((ProductKey)key);
		
	}

	@Override
	public List<Object[]> getFields() {
	
		List<Object[]> fields = new ArrayList<Object[]>();
		fields.add(new Object[]{Field.id.name(), id});
		fields.add(new Object[]{Field.name.name(), name});
		fields.add(new Object[]{Field.description.name(), description});
		fields.add(new Object[]{Field.unitPrice.name(), unitPrice});
		fields.add(new Object[]{Field.currencyCode.name(), currencyCode});
		fields.add(new Object[]{Field.category.name(), category});
		fields.add(new Object[]{Field.outlet.name(), outlet});
		fields.add(new Object[]{Field.salesCounting.name(),salesCounting});
		fields.add(new Object[]{Field.viewCounting.name(), viewCounting});
		fields.add(new Object[]{Field.ratingCode.name(), ratingCode});
		fields.add(new Object[]{Field.balance.name(), balance});
			
		
		
		return fields;
	}

	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public String getCurrencyCode() {
		return currencyCode;
	}


	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}


	public Rating getRatingCode() {
		return ratingCode;
	}


	public void setRatingCode(Rating ratingCode) {
		this.ratingCode = ratingCode;
	}


	public Outlet getOutlet() {
		return outlet;
	}


	public void setOutlet(Outlet outlet) {
		this.outlet = outlet;
	}


	public void setKey(ProductKey key) {
		this.key = key;
	}


	@Override
	public void initialize(Object... objects)
	{
	       int i = 0;
		
	       this.id =  (String) objects[i++];
		   this.name = (String) objects[i++];
		   this.description = (String) objects[i++];
		   this.currencyCode = (String) objects[i++];
		   this.category = (Category) objects[i++];
		   this.outlet = (Outlet) objects[i++];
		   this.salesCounting = Integer.valueOf(objects[i++].toString()) ;
		   this.ratingCode = (Rating) objects[i++];
		   this.balance = Integer.valueOf(objects[i++].toString());
	}


	public List<ProductOption> getProductOptions() {
		return productOptions;
	}


	public void setProductOptions(List<ProductOption> productOptions) {
		this.productOptions = productOptions;
	}




}