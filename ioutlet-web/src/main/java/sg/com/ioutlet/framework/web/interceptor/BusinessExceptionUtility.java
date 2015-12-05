package sg.com.ioutlet.framework.web.interceptor;

import org.apache.commons.lang.exception.ExceptionUtils;

import sg.com.ioutlet.exception.BusinessException;
import sg.com.ioutlet.exception.BusinessMultipleException;
import sg.com.ioutlet.framework.web.action.CommonActionSupport;

public class BusinessExceptionUtility
{
	/**
	 * Get the business exception
	 * if any of the exception stack is business exception then return that so that proper message can be displayed
	 * @param th
	 * @return
	 */
	public static BusinessException getBusinessException(Throwable th)
	{
		if (th == null) return null;
		Throwable[] ths = ExceptionUtils.getThrowables(th);

		for (Throwable ath : ths)
		{
			if (ath instanceof BusinessException) return (BusinessException) ath;
		}
		return null;

	}
	
	/**
	 * Get the root cause, if no cause, return the exception itself
	 * @param th
	 * @return
	 */
	public static Throwable getRootCause(Throwable th){
		if(th.getCause()!=null){
			return ExceptionUtils.getRootCause(th);
		}
		return th;
	}
	
	
	/**
	 * Add action error message to action
	 * @param be
	 * @param aas
	 */
	public static void addBusinessActionError(BusinessException be,CommonActionSupport aas){
		if(be instanceof BusinessMultipleException)
		{
			aas.addMultipleBusinessExceptionMessage((BusinessMultipleException)be);						
		}
		else
		{
			aas.addActionError(aas.getBusinessExceptionMessage(be));
		}
	}
}