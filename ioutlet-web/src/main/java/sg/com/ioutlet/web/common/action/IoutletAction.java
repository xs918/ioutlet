package sg.com.ioutlet.web.common.action;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import sg.com.ioutlet.framework.trxhelper.TransactionControl;
import sg.com.ioutlet.framework.web.action.CommonActionSupport;
import sg.com.ioutlet.framework.web.form.CommonForm;
import sg.com.ioutlet.model.IoutletFunction;
import sg.com.ioutlet.web.main.menu.MenuFactory;
import sg.com.ioutlet.web.main.menu.MenuGroup;
import sg.com.ioutlet.web.main.menu.MenuLink;

public abstract class IoutletAction extends CommonActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DOMAIN_ID = "IOLT";

	

	public List<MenuGroup> getMenuItems() {
		MenuFactory mf = new MenuFactory();
		if (accessControl == null) {
			Set<IoutletFunction> availableFunctionIds = new HashSet<IoutletFunction>();
			availableFunctionIds.add(IoutletFunction.ALL_FUNC);

			accessControl = new AccessController(availableFunctionIds);
		}
		List<MenuGroup> m1 = mf.generateMenus(
				IoutletFunction.IOLT_SIDE_MENU.inModule(), getAccessControl());
		return m1;

	}

	public Map<String, MenuLink> getMenuLinks() {
		List<MenuGroup> mg;
		Map<String, MenuLink> menumMap = new HashMap<String, MenuLink>();
		MenuFactory mf = new MenuFactory();

		mg = mf.generateMenus(IoutletFunction.IOLT_SIDE_MENU.inModule(),
				getAccessControl());

		if (mg != null && mg.size() > 0) {
			Collection<MenuLink> mNL = mg.get(0).getMenus().values();
			Iterator<MenuLink> i = mNL.iterator();
			menumMap.put(IoutletFunction.IOLT_SIDE_MENU.inModule(), i.next());
		}

		return menumMap;

	}

	public String getPageContentHeader() {

		return EMPTY;
	}

	public String getPageOptionaldescription() {

		return EMPTY;
	}

	public String getImagePath() {
		return IMG_PATH;
	}

	public String getUserProfileImageLink() {
		return IMG_PATH + "/" + "user3-128x128.jpg";
	}

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
		return null;
		
	}

	@Override
	protected CommonForm constructForm() {
		logger.trace("constructForm");
		return null;
	}

	@Override
	protected String onSubmit() {
		logger.trace("onSubmit");
		return null;
	}

	@Override
	public String getDomainId() {
		return DOMAIN_ID;
	}



}
