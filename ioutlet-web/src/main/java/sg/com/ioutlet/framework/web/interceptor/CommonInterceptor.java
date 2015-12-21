package sg.com.ioutlet.framework.web.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import sg.com.ioutlet.bridge.AceBridge;
import sg.com.ioutlet.common.logging.LogHelper;
import sg.com.ioutlet.framework.web.common.IoutletBridgerLookup;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public abstract class CommonInterceptor extends MethodFilterInterceptor
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
			
			
	protected LogHelper logger = LogHelper.getInstance(getClass().getName());
	
	protected HttpServletRequest getRequest()
	{
		return ServletActionContext.getRequest();
	}
	protected HttpServletResponse getResponse()
	{
		return ServletActionContext.getResponse();
	}
	protected Map<String, Object> getSession()
	{
		return ActionContext.getContext().getSession();
		
	}
	public AceBridge getAce() {
		return IoutletBridgerLookup.lookupAceBridge();
	}


	

}
