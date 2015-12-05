package sg.com.ioutlet.framework.web.interceptor;

import sg.com.ioutlet.framework.trxhelper.TransactionControl;
import sg.com.ioutlet.framework.web.action.CommonActionSupport;
import sg.com.ioutlet.framework.web.action.awareness.FormAware;
import sg.com.ioutlet.web.common.action.IoutletAction;
import sg.com.ioutlet.web.common.action.IoutletDisplayAction;

import com.opensymphony.xwork2.ActionInvocation;

public final class FormLoadingInterceptor extends CommonInterceptor
{

	
	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception
	{
		logger.trace("doIntercept");
		//long start = System.currentTimeMillis();
		logger.trace("setting form loading timestamp");
		String result = null;
		if (actionInvocation.getAction() instanceof CommonActionSupport)
		{
//			 INVOKE PRE ONLOAD
			IoutletDisplayAction fas = ((IoutletDisplayAction) actionInvocation.getAction());			
			fas.loadMessageFromSession();
			fas.loadErrorFromSession();
			result = fas.preOnLoad();
		}
			
		// CHECK IF IT IS 
		if (actionInvocation.getAction() instanceof FormAware)
		{
			// RETRIEVE ACTION
			IoutletAction fas = ((IoutletAction) actionInvocation.getAction());

			// LOAD FORM FROM SCOPE
			fas.loadForm();
			if(logger.isDebugEnabled())
			{
				logger.debug("FORM LOAD DATE: "+TransactionControl.getTransactionInfo().getFormLoadingDate());
			}

			
			if (!IoutletAction.ERROR.equals(result))
			{				
				// INVOKE ACTION INPUT METHOD
				result = actionInvocation.invoke();
			}
			else
			{
				if (logger.isDebugEnabled()) logger.debug("PRE ON LOAD RETURN UNEXPECTED VALUE OTHER THAN INPUT: FORWARDING TO " + result);
			}
			// INVOKE POST ONLOAD
			fas.postOnLoad();
			
			// IT IS NOT CLEARING THE FORM. SO DO NOT SAVE IT
				
			// SAVE FORM TO THE SCOPE
			fas.saveForm();

			//long end = System.currentTimeMillis();
			//logger.performance(getClass().getName(), start, end);

			return result;
		}
		else
		{
			logger.debug("THE FORM LOADING INTERCEPTION IS ABANDONED since it is invalid type of action class.\n" + 
            "The action must be child of FormActionSupport to load the form.\n" + 
			"You may want to double confirm that it is the intention to avoid the form submit interception");
			return actionInvocation.invoke();
		}
	}
}