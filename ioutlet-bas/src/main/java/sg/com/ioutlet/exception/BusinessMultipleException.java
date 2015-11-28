package sg.com.ioutlet.exception;

import java.util.Map;

public class BusinessMultipleException extends BusinessException {
	public Map<String, String[]> exceptionMessages;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessMultipleException(Map<String, String[]> exceptionMessages)
	{
		super(exceptionMessages.toString());
		this.exceptionMessages = exceptionMessages;
	}

	public Map<String, String[]> getExceptionMessages()
	{
		return exceptionMessages;
	}

	public void setExceptionMessages(Map<String, String[]> exceptionMessages)
	{
		this.exceptionMessages = exceptionMessages;
	}
}
