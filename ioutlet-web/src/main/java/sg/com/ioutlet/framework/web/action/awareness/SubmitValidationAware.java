package sg.com.ioutlet.framework.web.action.awareness;

public interface SubmitValidationAware {
	public String getValidateOnSubmit();
	public void setValidateOnSubmit(String validateOnSubmit);
	public boolean requiredValidationOnSubmit();

}
