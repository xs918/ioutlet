package sg.com.ioutlet.web.common.action;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import sg.com.ioutlet.framework.trxhelper.TransactionControl;
import sg.com.ioutlet.framework.web.action.CommonActionSupport;
import sg.com.ioutlet.framework.web.form.CommonForm;
import sg.com.ioutlet.model.IoutletFunction;
import sg.com.ioutlet.web.main.menu.MenuFactory;
import sg.com.ioutlet.web.main.menu.MenuGroup;
import sg.com.ioutlet.web.main.menu.MenuLink;

public abstract  class IoutletDisplayAction extends CommonActionSupport {

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
	protected String onSubmit() {
		logger.trace("onSubmit");
		return SUCCESS;
	}

	@Override
	public String getDomainId() {
		return DOMAIN_ID;
	}





}
