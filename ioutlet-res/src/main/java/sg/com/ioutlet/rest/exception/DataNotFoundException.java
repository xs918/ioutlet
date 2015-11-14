package sg.com.ioutlet.rest.exception;

import java.io.Serializable;

public class DataNotFoundException extends RuntimeException implements Serializable
{
	private static final long serialVersionUID = 1L;

	public DataNotFoundException()
	{
		super();
	}
	
	public DataNotFoundException(String msg)
	{
		super(msg);
	}
	
	public DataNotFoundException(String msg, Exception e)
	{
		super(msg, e);
	}
}
