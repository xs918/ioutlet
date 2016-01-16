package sg.com.ioutlet.ace.role;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import sg.com.ioutlet.ace.functionaccess.FunctionAccess;
import sg.com.ioutlet.bas.CommonPojo;
import sg.com.ioutlet.bas.CommonPojoKey;

/**
 * The persistent class for the depart database table.
 * 
 */
public class Role extends CommonPojo  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ENTITY_NAME = "Role";
	private RoleKey key;
	private String name;
	private String description;
	private BigDecimal price;
	private List<FunctionAccess> accessFunctions;
	private boolean isDefault;
	
	public Role() {

		this.key = new RoleKey();
	}

	public Role(RoleKey key) {
		this.key = key;
	}

	public enum Field {
		key, name(50), description(200), price(16,2),isDefault(1);

		public int length = 255;
		public int precision;
		public int scale;

		private Field() {
		}

		private Field(int length) {
			this.length = length;
		}

		private Field(int precision, int scale) {
			this.precision = precision;
			this.scale = scale;
		}
	}


	public List<Object[]> getFields() {

		List<Object[]> fields = new ArrayList<Object[]>();
		fields.add(new Object[] { Field.name.name(), name });
		fields.add(new Object[] { Field.description.name(), description });
		fields.add(new Object[] { Field.price.name(), price });
		fields.add(new Object[] { Field.isDefault.name(), isDefault });
		return fields;

	}

	
	public void initialize(Object... objects) {
		int i = 0;

		this.name = (String) objects[i++];
		this.description = (String) objects[i++];
	
	}

	public String getDescription() {
		return description;
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

	
	public String entityName() {

		return ENTITY_NAME;
	}

	
	public RoleKey getKey() {

		return key;
	}

	
	public void setKey(CommonPojoKey key) {
		setKey((RoleKey) key);

	}

	public void setKey(RoleKey key) {
		this.key = key;
		
	}

	
	


	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<FunctionAccess> getAccessFunctions() {
		return accessFunctions;
	}

	public void setAccessFunctions(List<FunctionAccess> accessFunctions) {
		this.accessFunctions = accessFunctions;
	}


	public boolean isDefault() {
		
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	


}