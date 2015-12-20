package sg.com.ioutlet.web.app.user.form;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionSupport;

import sg.com.ioutlet.web.common.form.IoutletForm;

public class UserAuthForm extends IoutletForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String password;
	

	@Override
	public void reset() {
		
	}

	@Override
	public Map<String, String> validate() {
			return null;
	}

	
	 public String	getValidationType()
		{
			return VALIDATION_TYPE_CUSTOM;
		}
	 
	 
	@Override
	public boolean validate(ActionSupport as) {
		if (StringUtils.isBlank(userId)) {
			as.addFieldError("userId", as.getText("user.id.is.required"));
		}
		if(StringUtils.isBlank(password))
		{
			as.addFieldError("password", as.getText("password.is.required"));
		}
		if (as.getFieldErrors().size() > 0)
		{
			return false;
		}
		return true;
		
	
		
	
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
