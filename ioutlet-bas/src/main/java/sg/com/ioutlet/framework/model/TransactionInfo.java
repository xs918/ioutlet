package sg.com.ioutlet.framework.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class TransactionInfo implements Serializable {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String requestIp;
	
	private String requestId;

	private String requestUser;

	private Locale requestLocale;

	private String functionId;
	
	private String domainId;
	// from the form
	private Date formLoadingDate;
	
	public TransactionInfo()
	{}
	
	public TransactionInfo(String requestIp,String requestUser,Locale requestLocale,String functionId,String domainId )
	{
		this.functionId = functionId;
		this.requestIp = requestIp;
		this.requestUser =requestUser;
		this.requestLocale = requestLocale;
		this.domainId=domainId;
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

	public Date getFormLoadingDate() {
		return formLoadingDate;
	}

	public void setFormLoadingDate(Date formLoadingDate) {
		this.formLoadingDate = formLoadingDate;
	}

	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = UUID.randomUUID().toString().toUpperCase();
	}

	public Date getTransactionStartDate() {
		// TODO Auto-generated method stub
		return null;
	}




	
	
	
}


