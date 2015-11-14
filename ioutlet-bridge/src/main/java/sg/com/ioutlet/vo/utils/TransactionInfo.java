package sg.com.ioutlet.vo.utils;

import java.io.Serializable;
import java.util.Locale;

public class TransactionInfo implements Serializable {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String requestIp;

	private String requestUser;

	private Locale requestLocale;

	private String functionId;
	
	
	public TransactionInfo()
	{}
	
	public TransactionInfo(String requestIp,String requestUser,Locale requestLocale,String functionId)
	{
		this.functionId = functionId;
		this.requestIp = requestIp;
		this.requestUser =requestUser;
		this.requestLocale = requestLocale;
	}
	
	
	public String getRequestIp() {
		return requestIp;
	}

	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}

	public String getRequestUser() {
		return requestUser;
	}

	public void setRequestUser(String requestUser) {
		this.requestUser = requestUser;
	}

	public Locale getRequestLocale() {
		return requestLocale;
	}

	public void setRequestLocale(Locale requestLocale) {
		this.requestLocale = requestLocale;
	}

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}


	
	
	
}


