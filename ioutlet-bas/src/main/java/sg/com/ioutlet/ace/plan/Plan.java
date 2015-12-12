package sg.com.ioutlet.ace.plan;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import sg.com.ioutlet.ace.role.Role;
import sg.com.ioutlet.bas.CommonPojo;
import sg.com.ioutlet.bas.CommonPojoKey;



public class Plan extends CommonPojo {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String ENTITY_NAME = "Plan";

	private PlanKey key;

	private String planName;
	
	private String planDesc;
	
	private Role role;
	
	private BigDecimal price;
	
	public Role getRole()
	{
		return role;
	}
	
	@Override
	public String entityName() {
	
		return ENTITY_NAME;
	}
	@Override
	public CommonPojoKey getKey() {
	 return this.key;
	}
	@Override
	public void setKey(CommonPojoKey key) {
		this.key  = (PlanKey) key;
		
	}
	
	
	public enum Field {
		key,planName(100),planDesc(255),price(16,2),role;
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
	
	
	@Override
	public List<Object[]> getFields() {
		List<Object[]> fields = new ArrayList<Object[]>();
		fields.add(new Object[] { Field.key.name(), key });
		
		fields.add(new Object[] { Field.planName.name(), planName });
		fields.add(new Object[] { Field.planDesc.name(), planDesc });
		fields.add(new Object[] { Field.price.name(), price });
		fields.add(new Object[] { Field.role.name(), role });
		
		return fields;
	}
	@Override
	public void initialize(Object... objects) {
	
		
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanDesc() {
		return planDesc;
	}

	public void setPlanDesc(String planDesc) {
		this.planDesc = planDesc;
	}

}
