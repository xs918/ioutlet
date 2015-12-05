package sg.com.ioutlet.framework.web.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;

import sg.com.ioutlet.framework.web.action.awareness.ReturnPathAware;
import sg.com.ioutlet.framework.web.form.CommonForm;
import sg.com.ioutlet.web.common.action.IoutletAction;

import com.opensymphony.xwork2.ActionInvocation;

public final class FormSubmitInterceptor extends CommonInterceptor
{

	private static final long serialVersionUID = 1L;
	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception
	{
		logger.trace("doIntercept");
		if(actionInvocation.getAction() instanceof IoutletAction)
		{
			IoutletAction fas = ((IoutletAction)actionInvocation.getAction());
			// RETRIEVE FORM OBJECT
			CommonForm form =  fas.getModel();
			if(fas instanceof ReturnPathAware)
			{
				// DETERMINE THE ACTION TYPE. WHICH BUTTON THE USER PRESS
				String actionType = form.getActionType();
				if(ReturnPathAware.BACK_BUTTON.equals(actionType))
				{
					// THE USER PRESS BACK BUTTON.
					if(logger.isDebugEnabled())
						logger.debug("User click back. Fordwading back to BACK result");
					return fas.doBack();
				}
				else if(ReturnPathAware.CANCEL_BUTTON.equals(actionType))
				{
					//THE USER CANCEL BACK BUTTON.
					if(logger.isDebugEnabled())
						logger.debug("User click cancel. Fordwading back to CANCEL result");
					return fas.doCancel();
				}
				else if(ReturnPathAware.SUBMIT_BUTTON.equals(actionType))
				{
					//THE USER CLICK SUBMIT
					if(logger.isDebugEnabled())
						logger.debug("User click submit button. Processing with form submission");
					return processFormSubmission(actionInvocation, fas, form);
				}
				else if(ReturnPathAware.RESET_BUTTON.equals(actionType))
				{
					//THE USER CANCEL BACK BUTTON.
					if(logger.isDebugEnabled())
						logger.debug("User click reset. Fordwading back to INPUT result");
					return fas.doReset();
				}
				else
				{
					//THE USER CLICK UNKNOWN BUTTON
					if(logger.isDebugEnabled())
						logger.debug("There is a special action type user made. I do not udnerstand how to do so I will assume as going for doCustom() [actionType:"+actionType+"]");
					return fas.doCustom();
				}
			}
			else
			{
				if(logger.isDebugEnabled())
					logger.debug("The action don't care about flows. Just ignoring and processing with sumbission ");
				return processFormSubmission(actionInvocation, fas, form);
			}
		}
		else
		{
			logger.warn("THE FORM SUBMIT INTERCEPTION IS ABANDONED since it is invalid type of action class.\n" +
					"The action must be child of FormActionSupport to submit the form.\n" +
					"You may want to double confirm that it is the intention to avoid the form submit interception");
			return actionInvocation.invoke();
		}		
	}
	
	private String processFormSubmission(ActionInvocation actionInvocation,IoutletAction fas ,CommonForm form ) throws Exception
	{
		if(fas.requiredValidationOnSubmit())
		{
				// Check if the checkboxes are unchecked. If unchecked, set the property to null
				String[] listSelectionParams = fas.getCheckboxRadioParams();
				if(listSelectionParams != null)
				{
					HttpServletRequest request = getRequest();
					for(String param: listSelectionParams)
					{
						// does not contain the check box
						if(logger.isDebugEnabled())
							logger.debug("peeking into the request with parameter: "+param+" returns :"+request.getParameter(param));
						if(request.getParameter(param) == null)
						{
							PropertyUtils.setProperty(fas, param, null);
						}
					}
				}
				// Perform before Validate Method
				String result = fas.preValidate();
				if(!IoutletAction.SUCCESS.equals(result))
				{
					// IF NOT SUCCESS
					if(logger.isDebugEnabled())
						logger.debug("PRE VALIDATE RETURN NON SUCCESS VALUE : FORWARDING TO "+result);
					return result;
				}
				
			    Map<String, String> errors = null;;
				boolean success = true;
				
				// Validate the form
				if(CommonForm.VALIDATION_TYPE_CUSTOM.equals(form.getValidationType()))
				{
					success = form.validate(fas);
				}
				else
				{
					errors = form.validate();
				}
				// FORM VALIDATION IS FAIL
				if((errors != null && !errors.isEmpty()) || !success)
				{
					if(errors != null && !errors.isEmpty())
					{
						//FORM VALIDATION HAS ERROR
						if(logger.isDebugEnabled())
							logger.debug("form validation fail");
						fas.processFieldValidation(errors);
					}
					fas.saveForm();
				
					return IoutletAction.INPUT;
				}
				// no error in drop down value check
				else
				{
					if(logger.isDebugEnabled())
						logger.debug("form validation pass continue processing");
					result = fas.preOnSubmit();
					if(IoutletAction.SUCCESS.equals(result))
					{
						
						result = actionInvocation.invoke(); 
					}
					else
					{
						if(logger.isDebugEnabled())
							logger.debug("PRE ON SUBMIT RETURN NON SUCCESS VALUE : FORWARDING TO "+result);
					}
					fas.postOnSubmit();
					fas.saveForm();
					return result;
				}
	
		}
		else
		{
			if(logger.isDebugEnabled())
				logger.debug("FORM SUBMIT VALIDATION IS DISABLED. SKIPPING VALIDITY CHECK.");
			logger.warn("preOnSubmit and postOnSubmit IS NOT EXECUTED because the validation check on submit is turned off. Well, it is not recommended but there may be a reason to do so");
			String result = actionInvocation.invoke();
			fas.saveForm();
			return result;
		}
	}


}