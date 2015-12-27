
package sg.com.ioutlet.ace.functionaccess;

import java.util.ArrayList;
import java.util.List;

import sg.com.ioutlet.ace.function.Function;
import sg.com.ioutlet.ace.role.Role;
import sg.com.ioutlet.bas.CommonPojo;
import sg.com.ioutlet.bas.CommonPojoKey;
import sg.com.ioutlet.framework.authorization.model.AccessFunction;
import sg.com.ioutlet.framework.authorization.model.IoltFunction;


public class FunctionAccess  extends CommonPojo implements AccessFunction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ENTITY_NAME = "FunctionAccess";
	private FunctionAccessKey  key;
	
	private Function function;

	private Role role;
	
	private int maxLimit;

	public FunctionAccess(FunctionAccessKey key)
	{
		this.key =key;
	}
	
	public FunctionAccess()
	{
		
	}
	
	
	public Function getFunction()
	{
		return function;
	}
	public IoltFunction getFunctionId()
	{
		if(function != null)
			return function.getId();
		return null;
	}
	public void setFunction(Function function)
	{
		this.function = function;
	}

	public Role getRole()
	{
		return role;
	}

	public void setRole(Role role)
	{
		this.role = role;
	}

	public String getRecordReference()
	{
		return role.getName()+"."+function.getId();		
	}
	@Override
	public String entityName() {
		
		return ENTITY_NAME;
	}
	@Override
	public CommonPojoKey getKey() {
		
		return key;
	}
	@Override
	public void setKey(CommonPojoKey key) {
		this.key  = (FunctionAccessKey) key;
		
	}

	public enum Field {
		function,role;
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
		fields.add(new Object[] { Field.function.name(), function });
		fields.add(new Object[] { Field.role.name(), role });
		
		return fields;
	}
	
	
	@Override
	public void initialize(Object... objects) {
		
		
	}
	public int getMaxLimit() {
		return maxLimit;
	}
	public void setMaxLimit(int maxLimit) {
		this.maxLimit = maxLimit;
	}
	@Override
	public String getUuid() {
		if(function != null)
			return function.getKey().getUuid();
		return null;
		
	}
	@Override
	public String getId() {
		return this.getFunctionId().toString();
	}
	@Override
	public String getName() {
		if(function != null)
			return function.getName();
		return null;
		
		
	}
	@Override
	public String getNamespace() {
		if(function != null)
			return function.getNamespace();
		return null;
	}
	@Override
	public String getAction() {
		if(function != null)
			return function.getAction();
		return null;
	}

}
