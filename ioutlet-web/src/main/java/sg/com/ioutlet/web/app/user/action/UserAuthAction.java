package sg.com.ioutlet.web.app.user.action;

import sg.com.ioutlet.ace.user.User;
import sg.com.ioutlet.framework.authorization.model.IoltFunction;
import sg.com.ioutlet.framework.web.WebConstants;
import sg.com.ioutlet.framework.web.action.awareness.UnAuthorizationAware;
import sg.com.ioutlet.framework.web.form.CommonForm;
import sg.com.ioutlet.web.app.user.form.UserAuthForm;
import sg.com.ioutlet.web.app.user.handler.UserActionActionHandler;
import sg.com.ioutlet.web.common.action.IoutletAction;

public class UserAuthAction extends IoutletAction implements UnAuthorizationAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected CommonForm constructForm() {
		return new UserAuthForm();
	}
	@Override
	protected String onLoad() {
		   return INPUT;
	}
	
	
	
	@Override
	protected String onSubmit() {
		
		UserAuthForm form = (UserAuthForm) getModel();
		UserActionActionHandler handler = new UserActionActionHandler(this);
		User loginUser =  handler.userLogin(form.getUserId(),form.getPassword());
    	if(loginUser==null)
    	{
    		this.addActionError(getText("user.id.or.password.incorrect"));
    		return INPUT;
    	}
		this.session.put(WebConstants.LOGGED_IN_USER_INFO.toString(), loginUser);
   		return SUCCESS;
	}

	@Override
	public String getFunctionId() {
		return IoltFunction.IOLT_USER_AUTH.toString();
	}

}
