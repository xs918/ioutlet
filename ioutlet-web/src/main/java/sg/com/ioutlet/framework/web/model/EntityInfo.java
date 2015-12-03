package sg.com.ioutlet.framework.web.model;

import java.io.Serializable;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang.LocaleUtils;

public class EntityInfo   implements Serializable{
	
	private static final long serialVersionUID = -8146443077740672253L;

	public static final String ENTITY_INFO = "ENTITY_INFO_KEY";

	private String entityCode;

	private String entityName;

	private TimeZone entityTimeZone;

	private Locale entityDefaultLocale;
	
	public EntityInfo()
	{
		
	}

	public EntityInfo(String entityCode,String name, String timeZoneId, String defaultLocale)
	{

		this.entityCode=entityCode;
		this.entityName=name;
		this.entityTimeZone=(timeZoneId!=null)?TimeZone.getTimeZone(timeZoneId):TimeZone.getDefault();
		this.entityDefaultLocale=(defaultLocale!=null)?LocaleUtils.toLocale(defaultLocale):Locale.getDefault();
		
	}

	public String getEntityCode()
	{
		return entityCode;
	}

	public void setEntityCode(String entityCode)
	{
		this.entityCode = entityCode;
	}

	public String getEntityName()
	{
		return entityName;
	}

	public void setEntityName(String entityName)
	{
		this.entityName = entityName;
	}

	public TimeZone getEntityTimeZone()
	{
		return entityTimeZone;
	}

	public void setEntityTimeZone(TimeZone entityTimeZone)
	{
		this.entityTimeZone = entityTimeZone;
	}

	public Locale getEntityDefaultLocale()
	{
		return entityDefaultLocale;
	}

	public void setEntityDefaultLocale(Locale entityDefaultLocale)
	{
		this.entityDefaultLocale = entityDefaultLocale;
	}

	public static long getSerialVersionUID()
	{
		return serialVersionUID;
	}

}
