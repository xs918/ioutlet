package sg.com.ioutlet.bas;


import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public abstract class CommonPojoKey implements Comparable<CommonPojoKey>, Serializable
{
	private static final long serialVersionUID = 1L;



	protected CommonPojoKey()
	{
	}

	public abstract String entityName();

	@Override
	public boolean equals(Object obj)
	{
		try
		{
			if (!getClass().isInstance(obj))
			{
				return false;
			}

			if (this == obj)
			{
				return true;
			}

			List<Object[]> fields = getFields();
			EqualsBuilder eb = new EqualsBuilder();
			for (Object[] field : fields)
			{
				Method method = obj.getClass().getMethod("get" + StringUtils.capitalize((String) field[0]));
				Object obj1 = method.invoke(this);
				Object obj2 = method.invoke(obj);
				eb.append(obj1, obj2);
			}

			return eb.isEquals();
		}
		
		catch (IllegalAccessException e)
		{
			throw new SystemException(e);
		}
		catch (InvocationTargetException e)
		{
			throw new SystemException(e);
		}
		catch (NoSuchMethodException e)
		{
			throw new SystemException(e);
		}
	}

	@Override
	public final String toString()
	{
		return ObjectStringUtil.toStringOfPojoKeyObject(this);
	
	}


	/**
	 * Allow override of the equals method by concrete classes 
	 * Using Reflection has huge overhead
	 */
	public int compareTo(CommonPojoKey key)
	{
		try
		{
			getClass().cast(key);

			List<Object[]> fields = getFields();
			CompareToBuilder ctb = new CompareToBuilder();
			for (Object[] field : fields)
			{
				Method method = key.getClass().getDeclaredMethod("get" + StringUtils.capitalize((String) field[0]));
				Object obj1 = method.invoke(this);
				Object obj2 = method.invoke(key);
				ctb.append(obj1, obj2);
			}
			return ctb.toComparison();
		}
		catch (IllegalAccessException e)
		{
			throw  new SystemException(e);
		}
		catch (InvocationTargetException e)
		{
			throw new SystemException(e);
		}
		catch (NoSuchMethodException e)
		{
			throw new SystemException(e);
		}
	}

	public abstract List<Object[]> getFields();
	
	@Override
	public int hashCode()
	{
		List<Object[]> fields = getFields();
		HashCodeBuilder hcb = new HashCodeBuilder();
		for (Object[] field : fields)
		{
			hcb.append(field[1]);
		}

		return hcb.toHashCode();
	}

	
	

}