
package sg.com.ioutlet.framework.web.action.awareness;

import sg.com.ioutlet.framework.web.form.CommonForm;

import com.opensymphony.xwork2.ModelDriven;

public interface FormAware extends ModelDriven
{
	public static final String SCOPE_FORM_APPLICATION = "application";
	public static final String SCOPE_FORM_SESSION = "session";
	public static final String SCOPE_FORM_REQUEST = "request";
	public static final String SKIP_FORM_LOADING_PARAM = "sfld";
	public static final String CLEAR_FORM_FLAG = "CLEAR_FORM_FLAG";
	/**
	 * Save the form in the session
	 */
	public void saveForm();
	
	/**
	 * Load the form from the session
	 */
	public void loadForm();
	
	/**
	 * Clear the form
	 */
	public void clearForm();
	
	/**
	 * Set the model class.
	 * @param model
	 */
	public void setModel(CommonForm model);
	
	/**
	 * Return where should the form should be loaded.<br/>
	 * Possible parameters see the static values. <br>
	 * SCOPE_FORM_APPLICATION, SCOPE_FORM_SESSION, SCOPE_FORM_REQUEST <br/>
	 * @return
	 */
	public String getFormScope();
	public void setFormScope(String formScope);
}
