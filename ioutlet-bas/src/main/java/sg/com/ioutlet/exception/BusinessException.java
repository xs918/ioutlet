package sg.com.ioutlet.exception;

import org.apache.commons.lang.Validate;

import sg.com.ioutlet.util.Seperator;

public class BusinessException  extends RuntimeException {
private static final long serialVersionUID = 1L;
	
	public BusinessException()
	{
	}

	public BusinessException(String arg0)
	{
		super(arg0);
	}

	public BusinessException(String arg0, String... params)
	{
		super(getMessageString(arg0, params));
	}
	
	public BusinessException(Throwable arg0)
	{
		super(arg0);
	}
	
	public BusinessException(String arg0, Throwable arg1)
	{
		super(arg0, arg1);
	}

	public BusinessException(String arg0, Throwable arg1, String... params)
	{
		super(getMessageString(arg0, params), arg1);
	}
	
	private static String getMessageString(String messageId, String... params)
	{
		StringBuilder sb = new StringBuilder(messageId);
		for (String param: params)
		{
			Validate.isTrue(!param.contains(Seperator.EXCEPTION_MESSAGE_SEPERATOR.toString()), "'param' must not contain '" + Seperator.EXCEPTION_MESSAGE_SEPERATOR + "'.", param);
			sb.append(Seperator.EXCEPTION_MESSAGE_SEPERATOR + param);
		}
		return sb.toString();
	}
}
