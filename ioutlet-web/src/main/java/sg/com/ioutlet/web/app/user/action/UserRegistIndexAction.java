package sg.com.ioutlet.web.app.user.action;

import org.apache.commons.lang.StringUtils;

import sg.com.ioutlet.framework.authorization.model.IoutletFunction;
import sg.com.ioutlet.framework.web.form.CommonForm;
import sg.com.ioutlet.web.app.user.form.UserRegistForm;
import sg.com.ioutlet.web.app.user.handler.UserActionActionHandler;
import sg.com.ioutlet.web.common.action.IoutletAction;

public class UserRegistIndexAction extends IoutletAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected CommonForm constructForm() {
		return new UserRegistForm();
	}

	@Override
	protected String onSubmit() {
		System.out.println("call onsubmit");
		UserRegistForm form = (UserRegistForm) getModel();
		UserActionActionHandler handler = new UserActionActionHandler(this);
		boolean result = handler.registeUserProfile(form);
		
		
	
		
		if(StringUtils.equalsIgnoreCase(form.getButtonType(),"delete"))
		{
			
		}
		if(!result)
		{
			return INPUT; 
		}
		return SUCCESS;
	}

	@Override
	protected String onLoad() {
		UserRegistForm form = (UserRegistForm) getModel();
		UserActionActionHandler handler = new UserActionActionHandler(this);
		handler.loadDefaultValue(form);
		return INPUT;
	}
	
	@Override
	public String getFunctionId() {
		
		return IoutletFunction.IOLT_USER_REG.toString();
		
	}
	@Override
	public String getPageContentHeader()
	{
		return getText("register.a.new.membership");
	}
	
	@Override
	public String getPageOptionaldescription()
	{
		return getText("register u account here");
	}
}
