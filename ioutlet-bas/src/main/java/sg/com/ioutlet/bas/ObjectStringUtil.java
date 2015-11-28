
package sg.com.ioutlet.bas;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.StandardToStringStyle;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * The utility class for String processing customised for IOUTLET project.
 */
public class ObjectStringUtil
{

	public static String IOUTLET_CONTENT_STARTER = "(";

	public static String IOUTLET_CONTENT_ENDER = ")";

	public static String DEFAULT_CONTENT_STARTER = "[";

	public static String DEFAULT_CONTENT_ENDER = "]";

	public static String FIELD_SEPERATOR = "|";

	
	
	/**
	 * Generate a customised ToStringStyle used in toString() method.
	 * 
	 * @return customised ToStringStyle
	 */
	public static StandardToStringStyle createToStringStyle()
	{
		StandardToStringStyle style = new StandardToStringStyle();
		style.setFieldSeparator(FIELD_SEPERATOR);
		style.setUseShortClassName(true);
		style.setUseIdentityHashCode(false);
		style.setUseFieldNames(false);
		style.setContentStart(IOUTLET_CONTENT_STARTER);
		style.setContentEnd(IOUTLET_CONTENT_ENDER);
		return style;
	}
	

	public static String toStringOfPojoKeyObject(CommonPojoKey pojoKey)
	{
		List<Object[]> fieldList = pojoKey.getFields();
		ToStringBuilder tsb = new ToStringBuilder(pojoKey, ObjectStringUtil.createToStringStyle());
		for (Object[] field : fieldList)
		{
			tsb.append((String) field[0], toStringOfObject(field[1]));
		}
		return tsb.toString();
	}
	
	
	
	

	public static String toStringOfObject(Object object)
	{
		if (object instanceof java.util.Calendar || object instanceof java.util.GregorianCalendar)
		{
			// if calendar object, date string needs to be formatted
			// add in if else to check for other object types and get formatted
			// string
			Calendar calendar = (Calendar) object;
			return DateUtil.toStringFromDate(calendar.getTime());
		}
		else if(object instanceof CommonPojoKey)
		{
			return toFormattedFieldsValuesString((CommonPojoKey)object, false);
		}
		else
		{
			return object.toString();
		}
	}
	
	
	

	public static String toFormattedFieldsValuesString(CommonPojoKey key, boolean needsContentStarterEnder)
	{
		String fieldValues = toFormattedFieldsValuesString(key);
		if( needsContentStarterEnder )
			return fieldValues;
		else
			return StringUtils.substringBetween(fieldValues, ObjectStringUtil.IOUTLET_CONTENT_STARTER, ObjectStringUtil.IOUTLET_CONTENT_ENDER);
	}

	
	
	
	/**
	 * Generate a formatted string for business exception. Retrieve out only
	 * fields' values and put it within "(" and ")" seperated by space between
	 * values
	 * 
	 * @param key
	 *            CommonPojoKey object for which a formatted string to
	 *            be generated for its feilds' values
	 * @return Formatted string
	 */
	public static String toFormattedFieldsValuesString(CommonPojoKey key)
	{
		List<Object[]> fieldList = key.getFields();
		StringBuffer fieldValues = new StringBuffer(ObjectStringUtil.IOUTLET_CONTENT_STARTER + ObjectStringUtil.FIELD_SEPERATOR);

		for (Object[] eachField : fieldList)
		{
			if(eachField[1] instanceof CommonPojoKey)
				fieldValues.append(toFormattedFieldsValuesString((CommonPojoKey)eachField[1], false));
			else 
				fieldValues.append(ObjectStringUtil.toStringOfObject(eachField[1])  + ObjectStringUtil.FIELD_SEPERATOR);

			

		}
		fieldValues.append(ObjectStringUtil.IOUTLET_CONTENT_ENDER);
		return fieldValues.toString();
	}
	
	
}
