package sg.com.ioutlet.bas;

public class SystemException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SystemException()
	{
		super();
		
	}

	
	public SystemException(Exception e)
	{
		super(e);
		
	}
	
	
	public SystemException(String message, Throwable cause)
	{
		super(message, cause);
		
	}

	public SystemException(String message)
	{
		super(message);
		
	}

	public SystemException(Throwable cause)
	{
		super(cause);
		
	}
}
