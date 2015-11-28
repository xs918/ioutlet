package sg.com.ioutlet.web.common.action;

import java.util.Date;

import sg.com.ioutlet.framework.trxhelper.TransactionControl;
import sg.com.ioutlet.framework.web.action.awareness.FormAware;
import sg.com.ioutlet.framework.web.form.CommonForm;

public abstract class IoutletAction extends IoutletDisplayAction implements FormAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DOMAIN_ID = "IOLT";

	protected String formScope = SCOPE_FORM_SESSION;

	protected CommonForm model;	
	protected String formScopeKey;

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
				// model = constructForm();
				removeFromAllScope(key);
				removeFromAllScope(CLEAR_FORM_FLAG);
			} else {
				// model = constructForm();
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


	protected CommonForm constructForm() {
		logger.trace("constructForm");
		return null;
	}

	@Override
	public String getDomainId() {
		return DOMAIN_ID;
	}



}
