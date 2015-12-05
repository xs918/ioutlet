package sg.com.ioutlet.framework.trxhelper;

import java.util.Locale;

import org.jboss.logging.NDC;

import sg.com.ioutlet.framework.model.TransactionInfo;

public class TransactionControl {


	private static final ThreadLocal<TransactionInfo> processThreadSession = new ThreadLocal<TransactionInfo>();
	private static final String GUEST = "guest";
	
	public static void setTransactionInfo(TransactionInfo trxInfo)
	{
		processThreadSession.set(trxInfo);
	}

	public static TransactionInfo getTransactionInfo()
	{
		TransactionInfo ti = processThreadSession.get();
		if(ti == null)
		{
			ti = new TransactionInfo();
			setTransactionInfo(ti);
		}
		return ti;		
	}
	
	public static void initTrxInfo(String requestIp, String requestUser, Locale requestLocale, String requestId, String functionId,String domainId)
	{
		if(requestUser == null)
			requestUser = GUEST;
		
		TransactionInfo ti = new TransactionInfo(requestIp, requestUser, requestLocale, functionId, domainId);
		setTransactionInfo(ti);
		
		NDC.push(functionId);
		NDC.push(requestIp);
		NDC.push(requestId);
		NDC.push(requestUser);
	}
	public static void clearTrxInfo()
	{
		processThreadSession.remove();
		NDC.pop();
		NDC.pop();
		NDC.pop();
		NDC.pop();
	}
}
