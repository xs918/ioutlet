package sg.com.ioutlet.framework.web.handler;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import sg.com.ioutlet.bridge.AceBridge;
import sg.com.ioutlet.bridge.GetterBridge;
import sg.com.ioutlet.bridge.SetterBridge;
import sg.com.ioutlet.common.logging.LogHelper;
import sg.com.ioutlet.framework.web.action.CommonActionSupport;
import sg.com.ioutlet.framework.web.common.IoutletBridgerLookup;

public abstract class CommonActionHandler {
	protected LogHelper logger = LogHelper.getInstance((getClass().getName()));

	public static String BUCKET_NAME ="iolt";
	
	private ActionSupport action;
	
	protected GetterBridge getterBridge;
	
	protected SetterBridge setterBridge;
	
	protected AceBridge aceBridge;
	
	

	public CommonActionHandler(ActionSupport action)
	{
		initializeBridge();
		this.action = action;
	}

	
	protected  void initializeBridge()
	{
		getterBridge =IoutletBridgerLookup.lookupGetterBridge();
		setterBridge=IoutletBridgerLookup.lookupSetterBridge();
	    aceBridge =IoutletBridgerLookup.lookupAceBridge();
	}
	
	protected void addFieldError(String fieldName, String errorKey)
	{
		action.addFieldError(fieldName, errorKey);
	}

	protected void addActionError(String errorKey)
	{
		action.addActionError(action.getText(errorKey));
	}

	protected void addActionMessage(String messageKey)
	{
		action.addActionMessage(messageKey);
	}

	protected String getText(String key)
	{
		return action.getText(key);
	}

	protected String getText(String key, String[] args)
	{
		return action.getText(key, args);
	}
	
	protected void addActionMessageInSession(String message)
	{
		if (action instanceof CommonActionSupport)
			((CommonActionSupport) action).addActionMessageInSession(message);
		else
		{
			logger.warn("The action is not type of CommonActionSupport: " + action.getClass().getName());
		
		}
	}
	protected void addActionMessageInSession(String message, String[] params)
	{
		if (action instanceof CommonActionSupport)
			((CommonActionSupport) action).addActionMessageInSession(message, params);
		else
		{
			logger.warn("The action is not type of CommonActionSupport: " + action.getClass().getName());
		
		}
	}
	
	protected void addActionErrorInSession(String message)
	{
		if (action instanceof CommonActionSupport)
			((CommonActionSupport) action).addActionErrorInSession(message);
		else
		{
			logger.warn("The action is not type of CommonActionSupport: " + action.getClass().getName());
		
		}
	}
	
	protected Map<?, ?> getSession()
	{
		return ((CommonActionSupport) action).getSession();
	}
}
