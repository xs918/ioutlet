package sg.com.ioutlet.rest.exception;

import java.io.Serializable;

public class DataNotAcceptableException extends RuntimeException implements Serializable {
	private static final long serialVersionUID = 1L;

	public DataNotAcceptableException()
	{
		super();
	}
	
	public DataNotAcceptableException(String msg)
	{
		super(msg);
	}
	
	public DataNotAcceptableException(String msg, Exception e)
	{
		super(msg, e);
	}
}
