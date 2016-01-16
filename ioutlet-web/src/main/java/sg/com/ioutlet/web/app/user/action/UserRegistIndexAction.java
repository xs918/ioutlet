package sg.com.ioutlet.web.app.user.action;

import org.apache.commons.lang.StringUtils;

import sg.com.ioutlet.ace.role.Role;
import sg.com.ioutlet.framework.authorization.model.IoltFunction;
import sg.com.ioutlet.framework.web.action.awareness.UnAuthorizationAware;
import sg.com.ioutlet.framework.web.form.CommonForm;
import sg.com.ioutlet.web.app.user.form.UserRegistForm;
import sg.com.ioutlet.web.app.user.handler.UserActionActionHandler;
import sg.com.ioutlet.web.common.action.IoutletAction;

public class UserRegistIndexAction extends IoutletAction implements UnAuthorizationAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 
	 
	@Override
	protected CommonForm constructForm() {
	
		CommonForm  form =  new UserRegistForm();
		return  form;
	}

	@Override
	protected String onSubmit() {
		UserRegistForm form = (UserRegistForm) getModel();
		UserActionActionHandler handler = new UserActionActionHandler(this);
		System.out.println("onSubmit:"+form.getActionType() + " button type:"+form.getButtonType());
		System.out.println("form:"+ form.getSelectedRoleName());
		Role selectedRole = form.getRolesMap().get(form.getSelectedRoleName());
		form.setSelectedRole(selectedRole);
		
		
		boolean result = handler.registeUserProfile(form);
		if(!result)
		{
			return INPUT; 
		}
		this.addActionMessage(this.getText("registration.successful"));
		return SUCCESS;
	}



	public  String json()
	{
		System.out.println("jsonCall*********");
		UserRegistForm form = (UserRegistForm) getModel();
		System.out.println("ajaxSelectRoles:"+form.getSelectedRoleName());
		Role selectedRole = form.getRolesMap().get(form.getSelectedRoleName());
		form.setSelectedRole(selectedRole);
		form.populateSelectedFunctionName();

	
		return SUCCESS;
	}
	
	
	@Override
	protected String onLoad() {
		System.out.println("onLoad  regist");
		UserRegistForm form = (UserRegistForm) getModel();
		UserActionActionHandler handler = new UserActionActionHandler(this);
		handler.loadDefaultValue(form);
		return INPUT;
	}
	
	@Override
	public String getFunctionId() {
		
		return IoltFunction.IOLT_USER_REG.toString();
		
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
