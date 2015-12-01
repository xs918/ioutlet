package sg.com.ioutlet.web.common.form;

import java.util.Date;

import sg.com.ioutlet.framework.web.form.CommonForm;

public abstract class IoutletForm implements CommonForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7131274958764150293L;

	public static final int MAX_PASSWORD_LENGTH = 12;

	public static final int MIN_PASSWORD_LENGTH = 6;

	public static final int MAX_INPUT_LENGTH = 255;

	public static final String ALL = "(ALL)";

	public static final String YES = "Y";

	public static final String YES_STRING = "Yes";

	public static final String NO = "N";

	public static final String EMPTY = "";

	public static final String NO_STRING = "No";
	
	public static final String FORMAT_162_ZERO_STRING = "0.00";
	
	public static final String FORMAT_96_ZERO_STRING = "0.000000";
	
	private String buttonType;
	
	private String actionType;
	
	private Date formLoadingDate;
	

	public String getButtonType() {
		return buttonType;
	}

	public void setButtonType(String buttonType) {
		this.buttonType = buttonType;
	}

	public String getValidationType() {
		return validationType;
	}

	public void setValidationType(String validationType) {
		this.validationType = validationType;
	}


	private String validationType;


	
	
	private String uuid;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}




	public Date getFormLoadingDate() {
		return formLoadingDate;
	}

	public void setFormLoadingDate(Date formLoadingDate) {
		this.formLoadingDate = formLoadingDate;
	}







	


}
