package sg.com.ioutlet.framework.web.interceptor;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;

import org.apache.commons.lang.SystemUtils;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;

import sg.com.ioutlet.common.logging.LogHelper;
import sg.com.ioutlet.exception.BusinessException;
import sg.com.ioutlet.framework.model.TransactionInfo;
import sg.com.ioutlet.framework.trxhelper.TransactionControl;
import sg.com.ioutlet.web.common.action.IoutletAction;

public final class BusinessExceptionInterceptor extends CommonInterceptor
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LogHelper logger = LogHelper.getInstance(getClass().getName());

	private boolean gotException = false;

	private boolean isBusinessException = false;

	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception
	{
		logger.trace("doIntercept");
		// addPreResultListener(actionInvocation);

		if (actionInvocation.getAction() instanceof IoutletAction)
		{
			IoutletAction action = (IoutletAction) actionInvocation.getAction();
			action.setErrorReport(null);
		}

		gotException = false;
		String resultCode = ActionSupport.INPUT;

		try
		{
			resultCode = actionInvocation.invoke();
		}
		catch (Exception e)
		{
			gotException = true;
			if (actionInvocation.getAction() instanceof IoutletAction)
			{
				if (logger.isDebugEnabled())
				{
					logger.debug("The action is type of CommonActionSupport Handling Exception Gracefully");
				}
				IoutletAction aas = ((IoutletAction) actionInvocation.getAction());

				BusinessException be = BusinessExceptionUtility.getBusinessException(e);
				if (be != null)
				{
					if (logger.isDebugEnabled()) logger.debug("The exception is type of Business Exception ");

					BusinessExceptionUtility.addBusinessActionError(be, aas);

					isBusinessException = true;
					logger.bizError("Business Exception Occurs: ", be);
				}
				else if (e instanceof RuntimeException || e.getCause() instanceof RuntimeException)
				{
					if (logger.isDebugEnabled()) logger.debug("The exception is type of Business Exception ");
					RuntimeException se;

					if (e instanceof RuntimeException)
						se = (RuntimeException) e;
					else
						se = (RuntimeException) e.getCause();

					aas.addActionError(se.toString());

					isBusinessException = true;
					logger.bizError("Stale Update Exception Occurred: ", se);
				}
				else
				{

					Throwable re = BusinessExceptionUtility.getRootCause(e);
					// display the root cause, which is always better
					if (logger.isDebugEnabled())
					{
						logger.debug("The exception is not Business Exception: " + re == null ? re.toString() : "null");
					}
					// System Exception Occurs
					String message = (re != null && re.getMessage() != null) ? re.getMessage() : "Unknown Exception has Occurred, please check the log";
					aas.addActionError(message);
					logger.error("Unknown Exception Occurred: ", e);
				}

				if (actionInvocation.getAction() instanceof IoutletAction)
				{
					IoutletAction action = (IoutletAction) actionInvocation.getAction();
					StringBuffer sb = new StringBuffer();

					sb.append("System Datetime: " + Calendar.getInstance().getTime());
					sb.append("\nOS Architecture: " + SystemUtils.OS_ARCH);
					sb.append("\nOS Name: " + SystemUtils.OS_NAME);
					sb.append("\nOS Version: " + SystemUtils.OS_VERSION);
					sb.append("\nJava Version: " + SystemUtils.JAVA_VERSION);

					try
					{
						InetAddress inetAddress = InetAddress.getLocalHost();
						sb.append("\nHost Address: " + inetAddress.getHostAddress());
						sb.append("\nHost Name: " + inetAddress.getHostName());
					}
					catch (UnknownHostException e2)	{}
					
					TransactionInfo ti = TransactionControl.getTransactionInfo();
					if (ti != null)
					{
						sb.append("\nUser: " + ti.getRequestUser());
					    sb.append("\nLocale: " + ti.getRequestLocale());
					}

				
					sb.append("\n\nStack Trace:\n");
					action.setErrorReport(sb.toString());
				}
			}
			else
			{
				logger.warn("Exception occurred, the caller action is not child of AbstractActionSupport.\n" + "unable to set the error message and returning to error");
			}
			if (gotException)
			{
				if (isBusinessException)
				{
					resultCode = ((IoutletAction) actionInvocation.getAction()).onBusinessErrorGoTo();
				}
				else
				{
					resultCode = ActionSupport.ERROR;
				}
			}
		}

		return resultCode;
	}
}