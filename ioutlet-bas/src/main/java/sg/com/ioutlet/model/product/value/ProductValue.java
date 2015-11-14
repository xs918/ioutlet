package sg.com.ioutlet.model.product.value;

import java.util.ArrayList;
import java.util.List;

import sg.com.ioutlet.bas.CommonPojo;
import sg.com.ioutlet.bas.CommonPojoKey;
import sg.com.ioutlet.model.category.attribute.CategoryAttribute;
import sg.com.ioutlet.model.product.Product;

public class ProductValue extends CommonPojo  {
	private static final long serialVersionUID = 1L;
	
	public static final String ENTITY_NAME = "ProductValue";
	
	
	private ProductValueKey key;

	private CategoryAttribute attribute;

	private String attributeValue;

	private Product product;
	
	private String attributeExtValue;
	
	
	public enum Field
	{
		 key,
		 attributeName,
		 attributeValue,
		 product,
		 attributeExtValue;
        
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

	
	

	public ProductValue() {
		
		key = new ProductValueKey();
	}

	
	public ProductValue(ProductValueKey productValueKey) {
		this.key = productValueKey;
	}


	public String getAttributeValue() {
		return this.attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	

	@Override
	public String entityName() {
		
		return ENTITY_NAME;
	}

	@Override
	public ProductValueKey getKey() {
		return key;
	}

	@Override
	public void setKey(CommonPojoKey key) {
		setKey((ProductValueKey) key);
		
	}

	@Override
	public List<Object[]> getFields() {
	
		

		List<Object[]> fields = new ArrayList<Object[]>();
		fields.add(new Object[]{Field.attributeName.name(), attribute});
		fields.add(new Object[]{Field.attributeValue.name(), attributeValue});
		fields.add(new Object[]{Field.attributeExtValue.name(), attributeExtValue});
		
		fields.add(new Object[]{Field.product.name(), product});
		
		
		
		return fields;
	
		
		
	}

	@Override
	public void initialize(Object... objects) {
		
		   int i = 0;
			
	       this.attribute =  (CategoryAttribute) objects[i++];
	       this.attributeValue = (String) objects[i++];
	       this.attributeExtValue = (String) objects[i++];
		   this.product = (Product) objects[i++];
		   
		
	}


	

	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public void setKey(ProductValueKey key) {
		this.key = key;
	}


	public CategoryAttribute getAttribute() {
		return attribute;
	}


	public void setAttribute(CategoryAttribute attribute) {
		this.attribute = attribute;
	}


	public String getAttributeExtValue() {
		return attributeExtValue;
	}


	public void setAttributeExtValue(String attributeExtValue) {
		this.attributeExtValue = attributeExtValue;
	}





}