package sg.com.ioutlet.web.main;

import sg.com.ioutlet.model.IoutletFunction;
import sg.com.ioutlet.web.common.action.IoutletDisplayAction;

public class MainPageDisplayAction extends IoutletDisplayAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private String message;
    public static final String MESSAGE = "HelloWorld.message";
	@Override
	protected String onLoad() {
		
		String msg = getText(MESSAGE);
		message =msg;
		System.out.println("messagesss:"+message);
		return INPUT;
	}


	@Override
	public String getFunctionId() {
		
		return IoutletFunction.IOLT_MAIN_PAGE.inModule();
	}
	
	@Override
	public String getPageContentHeader()
	{

		
		
		return getText("dash.board");
	}
	
	@Override
	public String getPageOptionaldescription()
	{
		return getText("control.panel");
	}
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	protected String onSubmit() {
	return SUCCESS;
	}

}
