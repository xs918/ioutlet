package sg.com.ioutlet.web.common.action;

import java.util.Date;

import sg.com.ioutlet.framework.trxhelper.TransactionControl;
import sg.com.ioutlet.framework.web.action.awareness.FormAware;
import sg.com.ioutlet.framework.web.action.awareness.ReturnPathAware;
import sg.com.ioutlet.framework.web.form.CommonForm;
import sg.com.ioutlet.web.common.message.GlobalMessages;

public abstract class IoutletAction extends IoutletDisplayAction implements  FormAware, ReturnPathAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DOMAIN_ID = "IOLT";

	protected String formScope = SCOPE_FORM_SESSION;

	protected CommonForm model;	
	protected String formScopeKey;
	
	
	private String errorReport;
	

	
	protected abstract CommonForm constructForm();

	@Override
	public void saveForm() {

		logger.trace("saveForm");
		CommonForm form = getModel();
		if (logger.isDebugEnabled()) {
			logger.debug("Printing Form Information that is gonna be saved");
			logger.debug(form.toString());
			logger.debug(form.getActionType());
			logger.debug(form.getValidationType());

		}
		String key = getFormClassName();
		if (SCOPE_FORM_REQUEST.equals(formScope)) {
			request.setAttribute(key, form);
		} else if (SCOPE_FORM_SESSION.equals(formScope)) {
			session.put(key, form);
		} else if (SCOPE_FORM_APPLICATION.equals(formScope)) {
			application.put(key, form);
		}
		if (logger.isDebugEnabled())
			logger.debug("Form saved to scope [" + formScope + "] with key ["
					+ key + "]");

	}

	private String getFormClassName() {
		if (model != null)
			return model.getClass().getName();
		else
			return constructForm().getClass().getName();
	}

	@Override
	public void loadForm() {

		logger.trace("loadForm");
		CommonForm form = null;
		String key = getFormClassName();
     	if (getSfld() != null) {
			if (logger.isDebugEnabled())
				logger.debug("Form loading ignored as the skip form loading parameter sfld["
						+ getSfld() + "] is present");
			model = constructForm();
			saveForm();
			return;
		}
		String cfkey = (String) findStringFromAllScope(CLEAR_FORM_FLAG);
		
	
		
		
		if (cfkey != null) {
			if (logger.isDebugEnabled())
				logger.debug("Form loading ignored as the skip form loading parameter ["
						+ CLEAR_FORM_FLAG + "] is present");
			if (cfkey.equals(key)) {
				removeFromAllScope(key);
				removeFromAllScope(CLEAR_FORM_FLAG);
			} else {
				removeFromAllScope(cfkey);
				removeFromAllScope(key);
				removeFromAllScope(CLEAR_FORM_FLAG);
			}
			return;
		}

		if (SCOPE_FORM_REQUEST.equals(formScope)) {
			form = (CommonForm) request.getAttribute(key);
		} else if (SCOPE_FORM_SESSION.equals(formScope)) {
			form = (CommonForm) session.get(key);
		} else if (SCOPE_FORM_APPLICATION.equals(formScope)) {
			form = (CommonForm) application.get(key);
		}
		if (form != null) {
			if (logger.isDebugEnabled())
				logger.debug("Form loaded from scope [" + formScope
						+ "] from key [" + key + "]");
			setModel(form);

		} else {
			if (logger.isDebugEnabled())
				logger.debug("Form not loaded from scope [" + formScope
						+ "] from key [" + key + "]");

		}

	}

	@Override
	public void clearForm() {
		logger.trace("clearForm");
		String key = getFormClassName();
		session.put(CLEAR_FORM_FLAG, key);

		if (logger.isDebugEnabled())
			logger.debug("Form clearing flag is set. It will be cleared when the next time load the form. ["
					+ formScope + "] from key [" + key + "]");

	}

	/**
	 * Reset the form
	 */
	public void resetForm()
	{
		logger.trace("resetForm");
		Date fld = new Date();
		model.setFormLoadingDate(fld);
		TransactionControl.getTransactionInfo().setFormLoadingDate(fld);
		model.reset();
		saveForm();
	}
	
	
	// ReturnPathAware Implementations 

		/**
		 * When user click cancel, clear the form. Go back to result 'cancel'
		 */
		public String doCancel()
		{
			logger.trace("doCancel");
			Object m = getModel();
			if(m instanceof CommonForm && m !=null)
			{
				clearForm();
				((CommonForm)m).reset();
				if(logger.isDebugEnabled())
					logger.debug("form resetted");
			}
			addActionMessage(GlobalMessages.ACTION_CANCEL_AS_REQUEST.toString());
			return RETURN_CANCEL;
		}
		/**
		 * When user click back, no clearing of form. Go back to result 'back'
		 */
		public String doBack()
		{
			logger.trace("doBack");
			saveForm();
			if(logger.isDebugEnabled())
				logger.debug("form saved");
			return RETURN_BACK;
		}
		/**
		 * When user click reset, clear the form. Go back to result 'input'
		 */
		public String doReset()
		{
			logger.trace("doReset");
			Object m = getModel();
			if(m instanceof CommonForm && m !=null)
			{
				// reset form
				resetForm();
				if(logger.isDebugEnabled())
					logger.debug("form resetted");
			}
			return INPUT;
		}
		/**
		 * If there is special button required, implementation class required to overide this method.
		 * 
		 */
		public String doCustom()
		{
			logger.trace("doCustom");
			if(logger.isDebugEnabled())
				logger.debug("DOING CUSTOM");
			logger.warn("Do custom is called without overwriting by implementation class. Going to 'error' result");
			return ERROR;
		}
		
		
	
	

	public String execute()
	{
		logger.trace("execute");
		
		if(model != null)
		{
			if(model.getFormLoadingDate() != null)
				TransactionControl.getTransactionInfo().setFormLoadingDate(model.getFormLoadingDate());
			else
			{
				TransactionControl.getTransactionInfo().setFormLoadingDate(new Date());
				model.setFormLoadingDate(TransactionControl.getTransactionInfo().getFormLoadingDate());
			}
		}
		return onSubmit();
	}	
	
	
	public String preOnSubmit()
	{
		logger.trace("preOnSubmit");
		//if there is a requirement to perform some actions before onSubmit, override this method
		return SUCCESS;
	}
	protected abstract String onSubmit();
	public void postOnSubmit()
	{
		logger.trace("postOnSubmit");
		// if there is a requirement to perform post onload, override this method
	}	
	
	
	
	@Override
	public CommonForm getModel() {
		if (model == null) {
			loadForm();
		}
		if (model == null) {
			model = constructForm();
			Date fld = new Date();
			model.setFormLoadingDate(fld);
			TransactionControl.getTransactionInfo().setFormLoadingDate(fld);
		}
		
		return model;
	}
	
	public void setModel(CommonForm model)
	{
		logger.trace("setModel");
		this.model = model;
	}
	
	

	public String getFormScope() {
		return formScope;
	}
	public void setFormScope(String formScope) {
		this.formScope = formScope;
	}


	protected String validateOnSubmit = TRUE;
	
	public String getValidateOnSubmit()
	{
		return this.validateOnSubmit;
	}
	public void setValidateOnSubmit(String validateOnSubmit)
	{
		this.validateOnSubmit = validateOnSubmit;
	}

	
	@Override
	public boolean requiredValidationOnSubmit()
	{
		return TRUE.equals(validateOnSubmit);
	}
	
	

	@Override
	protected String onLoad() {

		logger.trace("onLoad");
		return INPUT;
		
	}




	@Override
	public String getDomainId() {
		return DOMAIN_ID;
	}

	public String getErrorReport() {
		return errorReport;
	}

	public void setErrorReport(String errorReport) {
		this.errorReport = errorReport;
	}



}
