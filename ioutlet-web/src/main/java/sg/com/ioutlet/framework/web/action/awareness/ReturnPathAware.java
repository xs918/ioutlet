package sg.com.ioutlet.framework.web.action.awareness;

public interface ReturnPathAware {
	public static final String BACK_BUTTON = "backAct";
	public static final String CANCEL_BUTTON = "cancelAct";
	public static final String SUBMIT_BUTTON = "submitAct";
	public static final String RESET_BUTTON = "resetAct";
	
	public static final String RETURN_BACK = "back";
	public static final String RETURN_CANCEL = "cancel";

	public String doCancel();
	public String doBack();
	public String doCustom();
}
