package sg.com.ioutlet.model.category;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sg.com.ioutlet.bas.CommonPojo;
import sg.com.ioutlet.bas.CommonPojoKey;
import sg.com.ioutlet.model.product.Product;


public class Category  extends CommonPojo  {
	private static final long serialVersionUID = 1L;
	private static final  String ENTITY_NAME = "Category";

	
	public Category(CategoryKey key)
	{
		this.setKey(key);
	}
	
	
	public enum Field
	{
		 key,
		 parent,
		 name(50),
		 industry,
		 description(200);
		 

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

	
	
	
	private CategoryKey key;
	private Category  parent;
	private String description;
    private String name;
   
    private List<Product> products;

	public Category() {
		key = new CategoryKey();
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public CategoryKey getKey() {
		return key;
	}


	public void setKey(CategoryKey key) {
		this.key = key;
	}

	@Override
	public String entityName() {
			return ENTITY_NAME;
	}


	@Override
	public void setKey(CommonPojoKey key) {
		setKey((CategoryKey) key );
		
	}


	@Override
	public List<Object[]> getFields() {
	
		List<Object[]> fields = new ArrayList<Object[]>();
		fields.add(new Object[]{Field.name.name(), name});
		fields.add(new Object[]{Field.description.name(), description});
		return fields;

	}


	@Override
	public void initialize(Object... objects) {
	     	int i = 0;
		
	       this.name = (String) objects[i++];
		   this.description = (String) objects[i++];
		
		
	}





	public Category getParent() {
		return parent;
	}


	public void setParent(Category parent) {
		this.parent = parent;
	}




	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}





}