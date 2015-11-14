package sg.com.ioutlet.model.role;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import sg.com.ioutlet.bas.CommonPojoKey;

public class RoleKey extends CommonPojoKey {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String ENTITY_NAME = "RoleKey";


	public String entityName()
	{
		return ENTITY_NAME;
	}
	
	public enum Field
	{
		uuid;
		public int length = 255;
	
		private Field()
		{
		}
		
		private Field(int length)
		{
			this.length = length;
		}
	}
	
	
   private String uuid;
	
	public RoleKey()
	{
	
		this.uuid = RandomStringUtils.randomAlphabetic(10);
	}
	public RoleKey(String uuid)
	{
		this.uuid = uuid;
	}
	public List<Object[]> getFields()
	{
		//logger.trace("getFields");
		List<Object[]> fields = new ArrayList<Object[]>();
		fields.add(new Object[] { Field.uuid.name(), uuid });
		return fields;
		
	}

	
	public String getUuid()
	{
		return uuid;
	}

	public void setUuid(String uuid)
	{
		this.uuid = uuid;
	}
	
	@Override
	public final boolean equals(Object obj)
	{
	  return	super.equals(obj);
	}
	@Override
	public final int hashCode()
	{
		return super.hashCode();
	}
	
}
