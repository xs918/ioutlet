package sg.com.ioutlet.model.product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import sg.com.ioutlet.bas.CommonPojoKey;

public class ProductKey extends CommonPojoKey  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	public static final String ENTITY_NAME = "ProductKey";

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
	
	public ProductKey()
	{
		this.uuid = UUID.randomUUID().toString();
	}
	public ProductKey(String uuid)
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
