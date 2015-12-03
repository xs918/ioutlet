package sg.com.ioutlet.framework.web.action;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import sg.com.ioutlet.bas.DateUtil;
import sg.com.ioutlet.common.logging.LogHelper;
import sg.com.ioutlet.exception.BusinessException;
import sg.com.ioutlet.exception.BusinessMultipleException;
import sg.com.ioutlet.framework.web.action.awareness.AuthorizationAware;
import sg.com.ioutlet.framework.web.action.awareness.SubmitValidationAware;
import sg.com.ioutlet.model.IoutletFunction;
import sg.com.ioutlet.model.user.User;
import sg.com.ioutlet.util.NumberUtil;
import sg.com.ioutlet.web.common.action.AccessController;

import com.opensymphony.xwork2.ActionSupport;


public abstract class CommonActionSupport extends ActionSupport implements AuthorizationAware, SubmitValidationAware, ApplicationAware, SessionAware, ServletRequestAware, ParameterAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5684238414755689886L;

	public static final String TRUE = "true";

	public static final String FALSE = "false";
	
	protected LogHelper logger = LogHelper.getInstance((getClass().getName()));
	private String title = "application.title";
	

	
	protected Map<String,Object>  application ;


	protected Map<String,Object> session  ;


	protected Map<String, String[]> parameters ;
	

	protected HttpServletRequest request;
	
	
	public  static final String EMPTY = ""; 
	public static final String BUCKET="ioutlet";
	

	public static final String IMG_PATH =  "http://ioutlet.oss-cn-hangzhou.aliyuncs.com/img";
			
	
	
	public CommonActionSupport()
	{
		super();
		doInit();
	}
	protected void doInit()
	{
		
	}
	
	


		
		

	public String input()
	{
		return onLoad();
	}
	public String preOnLoad()
	{
		// if there is a requirement to perform some action before onload, override this method
		return INPUT;
	}
	protected abstract String onLoad();
	public void postOnLoad()
	{
		// if there is a requirement to perform post onload, override this method
	}
	

	
	
	
	public String preValidate()
	{
		return SUCCESS;
	}
	

	public String preOnSubmit()
	{
		logger.trace("preOnSubmit");
		//if there is a requirement to perform some actions before onSubmit, override this method
		return SUCCESS;
	}
	protected abstract String onSubmit();
	public void postOnSubmit()
	{
		logger.trace("postOnSubmit");
		// if there is a requirement to perform post onload, override this method
	}
	

	

	

	public String onBusinessErrorGoTo()
	{
		if (logger.isDebugEnabled()) logger.debug("BUSINESS ERROR OCCOURS");
		return INPUT;
	}


	public void setApplication( Map<String,Object>  application)
	{
		logger.trace("setApplication");
		this.application = application;
	}


	public void setSession( Map<String,Object>  session)
	{
		logger.trace("setSession");
		this.session = session;
	}




	public void setServletRequest(HttpServletRequest request)
	{
		logger.trace("setServletRequest");
		this.request = request;
	}
	protected String sfld;
	
	public String getSfld()
	{
		return sfld;
	}
	public void setSfld(String sfld)
	{
		
		System.out.println("Setter:"+sfld);
		this.sfld = sfld;
	}
	
	
	/**
	 * 
	 * @param map
	 */

	public void processFieldValidation(Map<String,Object> map)
	{
		Set<String> keys = map.keySet();
		if (!keys.isEmpty())
		{
			Iterator<String> it = keys.iterator();
			String key;
			String value;
			while (it.hasNext())
			{
				key = (String) it.next();
				value = (String) map.get(key);
				addFieldError(key, getText(value));
			}
		}
	}

	/**
	 * @return
	 */
	public String[] getCheckboxRadioParams()
	{
		return null;
	}

	/**
	 * Find the object from all scope (parameter, session and application)
	 * 
	 * @param key
	 * @return
	 */
	protected Object findFromAllScope(String key)
	{
		Object obj = parameters.get(key);
		if (obj != null) return obj;

		obj = session.get(key);
		if (obj != null) return obj;

		obj = application.get(key);
		if (obj != null) return obj;
		return null;
	}

	/**
	 * Remove from all scope (parameter, session and application)
	 * 
	 * @param key
	 * @return
	 */
	protected void removeFromAllScope(String key)
	{
		parameters.remove(key);
		session.remove(key);
		application.remove(key);
	}

	/**
	 * @param key
	 * @return
	 */
	protected String findStringFromAllScope(String key)
	{

		Object obj = findFromAllScope(key);
		if (obj != null)
		{
			if (obj instanceof String)
			{
				return (String) obj;
			}
			else if (obj instanceof String[])
			{
				return ((String[]) obj)[0];
			}
			else
			{
				return obj.toString();
			}
		}
		else
		{
			return null;
		}
	}

	/**
	 * Authentication & Authorization
	 */

	public String getUserId()
	{
		return request.getRemoteUser();
	}
	
	




	public abstract String getDomainId();

	public abstract String getFunctionId();

	protected Set<IoutletFunction> availableFunctionIds;

	protected AccessController accessControl;

	public Set<IoutletFunction> getAvailableFunctionIds()
	{
		return this.availableFunctionIds;
	}

	public void setAvailableFunctionIds(Set<IoutletFunction> availableFunctionIds)
	{
		this.availableFunctionIds = availableFunctionIds;
	}

	public boolean getAuthorizedToAccess(String functionId)
	{
		if (availableFunctionIds == null)
		{
		 	return false;
		}
		availableFunctionIds.contains(functionId);
		return false;
	}


	public AccessController getAccessControl()
	{
		return this.accessControl;
	}
	
	


	/**
	 * Sub Function Aware & FunctionCaller Aware
	 */
	public static final String SESSION_SUB_FUNC_RET_ACTION = "dynamic_result_action";

	public static final String SESSION_SUB_FUNC_RET_NAMESPACE = "dynamic_result_namespace";

	public static final String SESSION_SUB_FUNC_BACK_ACTION = "dynamic_back_action";

	public static final String SESSION_SUB_FUNC_BACK_NAMESPACE = "dynamic_back_namespace";

	public static final String SESSION_SUB_FUNC_RESULT_OBJ = "subfunction_return_result";

	public static final String SESSION_SUB_FUNC_INPUT_OBJ = "subfunction_input";

	public static final String DYNAMIC = "dynamic";

	public static final String DYNAMIC_BACK = "dynamic_back";

	public String getDynamicResultAction()
	{
		logger.trace("getDynamicResultAction");
		if (logger.isDebugEnabled())
		{
			logger.debug("Dyanmic Result Aciton: " + session.get(SESSION_SUB_FUNC_RET_ACTION));
			logger.debug("Dyanmic Result Namespace: " + session.get(SESSION_SUB_FUNC_RET_NAMESPACE));
		}
		return (String) session.get(SESSION_SUB_FUNC_RET_ACTION);
	}

	public String getDynamicResultNameSpace()
	{
		logger.trace("getDynamicResultNameSapce");
		return (String) session.get(SESSION_SUB_FUNC_RET_NAMESPACE);
	}

	public String getDynamicBackAction()
	{
		logger.trace("getDynamicBackAction");
		return (String) session.get(SESSION_SUB_FUNC_BACK_ACTION);

	}

	public String getDynamicBackNameSpace()
	{
		logger.trace("getDynamicBackNameSapce");
		return (String) session.get(SESSION_SUB_FUNC_BACK_NAMESPACE);
	}

	

	public static String SESSION_ACTION_MESSAGE_LIST = "session_action_message_list";

	public static String SESSION_ACTION_ERROR_LIST = "session_action_error_list";


	@SuppressWarnings("unchecked")
	public void addActionMessageInSession(String message)
	{
		Collection<String> actionMessages = (Collection<String>) session.get(SESSION_ACTION_MESSAGE_LIST);
		if (actionMessages == null) actionMessages = new ArrayList<String>();
		actionMessages.add(getText(message));
		session.put(SESSION_ACTION_MESSAGE_LIST, actionMessages);
	}

	@SuppressWarnings("unchecked")
	public void addActionMessageInSession(String message, String[] params)
	{
		Collection<String> actionMessages = (Collection<String>) session.get(SESSION_ACTION_MESSAGE_LIST);
		if (actionMessages == null) actionMessages = new ArrayList<String>();
		actionMessages.add(getText(message, params));
		session.put(SESSION_ACTION_MESSAGE_LIST, actionMessages);
	}

	@SuppressWarnings("unchecked")
	public void loadMessageFromSession()
	{
		Collection<String> actionMessages = (Collection<String>) session.get(SESSION_ACTION_MESSAGE_LIST);
		if (actionMessages != null)
		{
			for (String msg : actionMessages)
			{
				addActionMessage(msg);
			}
			session.remove(SESSION_ACTION_MESSAGE_LIST);
		}
	}

	@SuppressWarnings("unchecked")
	public void addActionErrorInSession(String message)
	{
		Collection<String> actionMessages = (Collection<String>) session.get(SESSION_ACTION_ERROR_LIST);
		if (actionMessages == null) actionMessages = new ArrayList<String>();
		actionMessages.add(message);
		session.put(SESSION_ACTION_ERROR_LIST, actionMessages);
	}

	@SuppressWarnings("unchecked")
	public void loadErrorFromSession()
	{
		Collection<String> actionError = (Collection<String>) session.get(SESSION_ACTION_ERROR_LIST);
		if (actionError != null)
		{
			for (String err : actionError)
			{
				addActionError(err);
			}
			session.remove(SESSION_ACTION_ERROR_LIST);
		}
	}

	public String getTitle()
	{
		return this.title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	
	/**
	 * Translate business exception to user friendly message
	 * 
	 * @param be
	 * @return
	 */
	public String getBusinessExceptionMessage(BusinessException be)
	{
		return getText(be.getMessage());
	}

	/**
	 * Translate business exception to user friendly message
	 * 
	 * @param be
	 * @return
	 */
	public void addMultipleBusinessExceptionMessage(BusinessMultipleException be)
	{
		if (be != null)
		{
			Map<String, String[]> exceptionMessages = be.getExceptionMessages();
			Iterator<String> it = exceptionMessages.keySet().iterator();
			String key = null;
			String[] params = null;
			while (it.hasNext())
			{
				key = (String) it.next();
				if (key != null)
				{
					params = exceptionMessages.get(key);
					if (params != null)
						addActionError(getText(key, params));
					else
						addActionError(getText(key));

				}
			}
		}
	}

	/**
	 * Translate business exception to user friendly message
	 * 
	 * @param be
	 * @return
	 */
	public void addActionError(String key, String[] params)
	{
		if (!StringUtils.isEmpty(key))
		{
			if (params != null)
				addActionError(getText(key, params));
			else
				addActionError(getText(key));

		}
	}

	/**************************************************************
	 * Utility Methods
	 **************************************************************/
	
	/**
	 * Format to Decimal Format 2 decimal
	 * @param value
	 * @return
	 */
	public String formatDecimal(String value)
	{
		logger.trace("formatDecimal");		
		return NumberUtil.formatNumberToStr162(value);
	}
	
	/**
	 * Format Decimal without Comma
	 * @param value
	 * @return
	 */
	public String formatDecimalWoComma(String value)
	{
		logger.trace("formatDecimalWoComma");
		DecimalFormat df = new DecimalFormat("###############0.00");
		if (value != null && !StringUtils.isEmpty(value))
			return df.format(Double.parseDouble(value));
		return value;
	}
	
	/**
	 * Format to Default Date Format
	 * @param value
	 * @return
	 */
	public String formatDate(Date value)
	{
		logger.trace("formatDate");
		if(value == null)
			return "-";
		return DateUtil.toFormattedDateString(value, DateUtil.DATE_FORMAT);
	}
	

	/**
	 * Format to 9 number, 6 decimal
	 * @param value
	 * @return
	 */
	public String formatRate(String value)
	{
		logger.trace("formatRate");
		return NumberUtil.formatNumberToStr96(value);
	}
	
	/**
	 * Format to boolean String (Y/N)
	 * @param value
	 * @return
	 */
	public String formatBoolean(boolean value)
	{
		logger.trace("formatBoolean");
		if (value == true)
		{
			return getText("Y");
		}
		else
		{
			return getText("N");
		}
	}

	/**
	 * Format if the String is empty or null, the system will return a dash '-'
	 * @param value
	 * @return
	 */
	public String formatString(String value)
	{
		logger.trace("formatDate");
		if(StringUtils.isEmpty(value))
			return "-";
		return value;
	}
	

	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public Map<String, Object> getApplication() {
		return application;
	}
	public Map<String, Object> getSession() {
		return session;
	}

	public void setAccessControl(AccessController accessControl) {
		this.accessControl = accessControl;
	}


	public Map<String, String[]> getParameters() {
		return parameters;
	}
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
	}
	
	public User getLoggedUser()
	{
		return null;
		
	}
}
