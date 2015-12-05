
package sg.com.ioutlet.ace.function;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import sg.com.ioutlet.ace.domain.Domain;
import sg.com.ioutlet.ace.functionaccess.FunctionAccess;
import sg.com.ioutlet.bas.CommonPojo;
import sg.com.ioutlet.bas.CommonPojoKey;
import sg.com.ioutlet.framework.authorization.model.AccessFunction;

public class Function   extends CommonPojo implements AccessFunction
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String ENTITY_NAME = "Function";

	private FunctionKey key;
	
	private String id;

	
	private String name;

	
	private String description;

	
	private String action;

	
	private String namespace;

	
	private Domain domain;


	
	private Collection<FunctionAccess> functionAccesses;
	
	
	
	public enum Field {
		key,
        id(200),
        name(100),
		description(100),
		action(255),
		namespace(255),
		domain;
		
		
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
	
	

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getAction()
	{
		return action;
	}

	public void setAction(String action)
	{
		this.action = action;
	}

	public String getNamespace()
	{
		return namespace;
	}

	public void setNamespace(String namespace)
	{
		this.namespace = namespace;
	}



	
	public Domain getDomain()
	{
		return domain;
	}

	public void setDomain(Domain domain)
	{
		this.domain = domain;
	}

	
	public Collection<FunctionAccess> getFunctionAccesses()
	{
		return functionAccesses;
	}

	public void setFunctionAccesses(Collection<FunctionAccess> functionAccesses)
	{
		this.functionAccesses = functionAccesses;
	}


	
	public String getRecordReference()
	{
		return domain.getId()+"."+id;		
	}

	public FunctionKey getKey() {
		return key;
	}

	public void setKey(FunctionKey key) {
		this.key = key;
	}

	@Override
	public String entityName() {
	
		return ENTITY_NAME;
	}

	@Override
	public void setKey(CommonPojoKey key) {
		this.key =(FunctionKey) key;
		
	}

	@Override
	public List<Object[]> getFields() {
		List<Object[]> fields = new ArrayList<Object[]>();
		fields.add(new Object[] { Field.id.name(), id });
		fields.add(new Object[] { Field.name.name(), name });
		fields.add(new Object[] { Field.description.name(), description });
		fields.add(new Object[] { Field.action.name(), action });
		fields.add(new Object[] { Field.namespace.name(), namespace });
		fields.add(new Object[] { Field.domain.name(), domain });
		
		return fields;

	}

	@Override
	public void initialize(Object... objects) {
	
		
	}

	@Override
	public String getUuid() {
		 return key.getUuid();
	}
}
