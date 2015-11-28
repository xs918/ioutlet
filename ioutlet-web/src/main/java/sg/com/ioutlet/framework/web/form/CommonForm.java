package sg.com.ioutlet.framework.web.form;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public interface  CommonForm extends Serializable {
	public static final String VALIDATION_TYPE_DEFAULT = "VD";
	public static final String VALIDATION_TYPE_CUSTOM = "VC";
	
	public abstract void reset();
	public Map<?, ?> validate();
	public boolean validate(ActionSupport as);
	public String getValidationType();
	public String getActionType();
	public void setActionType(String actionType);
	public Date getFormLoadingDate();
	public void setFormLoadingDate(Date formLoadingDate);
}
