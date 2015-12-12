package sg.com.ioutlet.ace.role;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sg.com.ioutlet.ace.functionaccess.FunctionAccess;
import sg.com.ioutlet.ace.plan.Plan;
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
	private Date endDate;
	private String name;
	private Date startDate;
	private String description;
	
	private List<Plan> plans;
	
	private List<FunctionAccess> functionAccesses;
	

	public Role() {

		this.key = new RoleKey();
	}

	public Role(RoleKey key) {
		this.key = key;
	}

	public enum Field {
		key, name(50), description(200), startDate, endDate;

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
		fields.add(new Object[] { Field.startDate.name(), startDate });
		fields.add(new Object[] { Field.endDate.name(), endDate });
		return fields;

	}

	
	public void initialize(Object... objects) {
		int i = 0;

		this.name = (String) objects[i++];
		this.description = (String) objects[i++];
		this.startDate = (Date) objects[i++];
		this.endDate = (Date) objects[i++];

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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

	public List<Plan> getPlans() {
		return plans;
	}

	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}

	public List<FunctionAccess> getFunctionAccesses() {
		return functionAccesses;
	}

	public void setFunctionAccesses(List<FunctionAccess> functionAccesses) {
		this.functionAccesses = functionAccesses;
	}



}