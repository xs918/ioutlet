package sg.com.ioutlet.model.category.attribute;

import java.util.ArrayList;
import java.util.List;

import sg.com.ioutlet.bas.CommonPojo;
import sg.com.ioutlet.bas.CommonPojoKey;
import sg.com.ioutlet.model.DataType;
import sg.com.ioutlet.model.YesNo;
import sg.com.ioutlet.model.category.Category;

public class CategoryAttribute   extends CommonPojo {
	private static final long serialVersionUID = 1L;
	private static final  String ENTITY_NAME = "CategoryAttribute";

	public enum Field
	{
		 key,
		 name(50),
		 dataType,
		 description(200),
		 category,
		 mandatory;
		
		 

	



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

	
	private CategoryAttributeKey key;

	private Category category;

	private String description;

	private String name;
	
	private DataType  dataType;
	
	private YesNo mandatory;

	public CategoryAttribute() {
		
			key = new CategoryAttributeKey();
		

		
	}

	
	

	public CategoryAttribute(CategoryAttributeKey key) {
		this.key  = key;
		
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

	@Override
	public String entityName() {

		return ENTITY_NAME;
	}

	@Override
	public CategoryAttributeKey getKey() {
		return  key;
	}

	@Override
	public void setKey(CommonPojoKey key) {
		this.setKey((CategoryAttributeKey) key);
		
	}
	
	
	


	@Override
	public List<Object[]> getFields() {
		
		List<Object[]> fields = new ArrayList<Object[]>();
		fields.add(new Object[]{Field.name.name(), name});
		fields.add(new Object[]{Field.dataType.name(), dataType});
		fields.add(new Object[]{Field.description.name(), description});
		fields.add(new Object[]{Field.category.name(), category});
		fields.add(new Object[]{Field.mandatory.name(), mandatory});
		
		return fields;

	}

	@Override
	public void initialize(Object... objects) {
    	   	int i = 0;
		   this.name = (String) objects[i++];
		   this.dataType = (DataType) objects[i++];
		   this.description = (String) objects[i++];
		   this.category = (Category) objects[i++];
		   this.mandatory = (YesNo) objects[i++];
			
		
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}




	public void setKey(CategoryAttributeKey key) {
		this.key = key;
	}




	public YesNo getMandatory() {
		return mandatory;
	}




	public void setMandatory(YesNo mandatory) {
		this.mandatory = mandatory;
	}




	public DataType getDataType() {
		return dataType;
	}




	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}







}