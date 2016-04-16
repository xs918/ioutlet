package sg.com.ioutlet.model.product.option;

import java.util.ArrayList;
import java.util.List;

import sg.com.ioutlet.bas.CommonPojo;
import sg.com.ioutlet.bas.CommonPojoKey;
import sg.com.ioutlet.model.product.Product;

public class ProductOption extends CommonPojo  {
	private static final long serialVersionUID = 1L;
	
	public static final String ENTITY_NAME = "ProductValue";
	
	
	private ProductOptionKey key;


	private String optionValue;

	private Product product;
	
	private String optionName;
	private String dataType;
	
	private String optionExtValue;
	
	
	public enum Field
	{
		 key,
		 optionName,
		 dataType,
		 optionValue,
		 product,
		 optionExtValue;
		
        
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

	
	

	public ProductOption() {
		
		key = new ProductOptionKey();
	}

	
	public ProductOption(ProductOptionKey productValueKey) {
		this.key = productValueKey;
	}


	public String getoptionValue() {
		return this.optionValue;
	}

	public void setoptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	

	@Override
	public String entityName() {
		
		return ENTITY_NAME;
	}

	@Override
	public ProductOptionKey getKey() {
		return key;
	}

	@Override
	public void setKey(CommonPojoKey key) {
		setKey((ProductOptionKey) key);
		
	}

	@Override
	public List<Object[]> getFields() {
	
		

		List<Object[]> fields = new ArrayList<Object[]>();
		fields.add(new Object[]{Field.optionName.name(), optionName});
		fields.add(new Object[]{Field.optionValue.name(), optionValue});
		fields.add(new Object[]{Field.optionExtValue.name(), optionExtValue});
		
		fields.add(new Object[]{Field.product.name(), product});
		
		
		
		return fields;
	
		
		
	}

	@Override
	public void initialize(Object... objects) {
		
		   int i = 0;
			
	       this.optionName =  (String) objects[i++];
	       this.optionValue = (String) objects[i++];
	       this.optionExtValue = (String) objects[i++];
		   this.product = (Product) objects[i++];
		   
		
	}


	

	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public void setKey(ProductOptionKey key) {
		this.key = key;
	}




	public String getoptionExtValue() {
		return optionExtValue;
	}


	public void setoptionExtValue(String optionExtValue) {
		this.optionExtValue = optionExtValue;
	}


	public String getDataType() {
		return dataType;
	}


	public void setDataType(String dataType) {
		this.dataType = dataType;
	}





}