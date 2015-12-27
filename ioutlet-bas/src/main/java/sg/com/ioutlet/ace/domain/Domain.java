package sg.com.ioutlet.ace.domain;

import java.util.ArrayList;
import java.util.List;

import sg.com.ioutlet.bas.CommonPojo;
import sg.com.ioutlet.bas.CommonPojoKey;
import sg.com.ioutlet.framework.authorization.model.DomainAccess;

public class Domain extends CommonPojo implements DomainAccess {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String ENTITY_NAME = "Domain";
	
	private DomainKey key;
	
	private String id;

	private String name;

	private String description;

	private String url;
	
	public Domain(DomainKey key)
	{
		this.key =key;
	}
	
	public Domain()
	{
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String entityName() {
	 return	ENTITY_NAME;
	}

	@Override
	public CommonPojoKey getKey() {
	  return key;
	}

	@Override
	public void setKey(CommonPojoKey key) {
	  this.key = (DomainKey) key;
		
	}




	public void setKey(DomainKey key) {
		this.key = key;
	}

	@Override
	public String getUrl() {
		
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public enum Field {
		key,
        id(200),
        name(100),
		description(100),
		url(255);	
		
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
		fields.add(new Object[] { Field.id.name(), id });
		fields.add(new Object[] { Field.name.name(), name });
		fields.add(new Object[] { Field.description.name(), description });
		fields.add(new Object[] { Field.url.name(), url });
	
		return fields;

	}

	@Override
	public void initialize(Object... objects) {
		
		
	}






}
