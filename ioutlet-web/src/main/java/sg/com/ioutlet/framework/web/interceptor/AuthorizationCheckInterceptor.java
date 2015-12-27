package sg.com.ioutlet.framework.web.interceptor;

import java.util.Map;
import java.util.Set;

import sg.com.ioutlet.ace.functionaccess.FunctionAccess;
import sg.com.ioutlet.ace.user.User;
import sg.com.ioutlet.bas.SystemException;
import sg.com.ioutlet.framework.authorization.model.AuthorizationInfo;
import sg.com.ioutlet.framework.authorization.model.IoltFunction;
import sg.com.ioutlet.framework.web.WebConstants;
import sg.com.ioutlet.framework.web.action.awareness.AuthorizationAware;
import sg.com.ioutlet.framework.web.action.awareness.UnAuthorizationAware;

import com.opensymphony.xwork2.ActionInvocation;

public class AuthorizationCheckInterceptor extends CommonInterceptor {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String UNATHORIZED = "unathorized";
	
	private static final String LOGIN = "login";
	
	private static final String CHANGE_PASSWORD = "changepassword";

	
	/**
	 * 
	 */


	 @Override
	 public void destroy() {
	        //release resources here
	 }
	 
	    @Override
	 public void init() {
	        // create resources here
	}

	@SuppressWarnings("unchecked")
	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		logger.trace("doIntercept");
		long start = System.currentTimeMillis();
		Object action = actionInvocation.getAction();
		
		if(action instanceof UnAuthorizationAware)
		{
			
			return actionInvocation.invoke();
		}

		if (action instanceof AuthorizationAware)
		{
						
			AuthorizationAware aa = (AuthorizationAware) action;
			String domainId = aa.getDomainId();
			String functionId = aa.getFunctionId();
		 	
			User userInfo = (User) getSession().get(WebConstants.LOGGED_IN_USER_INFO.toString());
			if(userInfo==null)
			{
				return LOGIN;
			}
		
			
			
			
			if(domainId == null || functionId == null)
			{
				throw new SystemException("The mandatory information : domainId/functionId ["+domainId+"/"+functionId+"] not defined");
			}
			
		
			Set<IoltFunction> availableFunctions = (Set<IoltFunction>) getSession().get(WebConstants.USER_DOMAIN_FUNCTIONS.toString()+userInfo.getUserId());
			
			
			if(availableFunctions == null || availableFunctions.isEmpty()) 
			{
				AuthorizationInfo auth =  this.getAce().getAuthenticationInfo(userInfo.getUserId());
				if(auth == null)
				{
					throw new SystemException("Can not load the Authorization Info ");
				}
				Map<IoltFunction, FunctionAccess> accessfuncs = auth.getFunctionAccess(domainId);
			
				if(accessfuncs!=null)
				{
				  availableFunctions = accessfuncs.keySet();
				}
				if(availableFunctions == null||availableFunctions.isEmpty())
				{
					
					if(logger.isDebugEnabled())
					{
						logger.debug("No functions available for this user in this domain");
					}
					return UNATHORIZED;
				}
				
				if(auth.getUser()==null)
				{
						return UNATHORIZED;
				}
				getSession().put(WebConstants.USER_DOMAIN_FUNCTIONS.toString()+domainId+auth.getUser().getUserId(), availableFunctions);						
				
				
			}
			
			
			
				
			if(!availableFunctions.contains(functionId) && !availableFunctions.contains(IoltFunction.ALL_FUNC) )
			{
				getSession().clear();
			  	return UNATHORIZED;
			}
			
		
		     if(functionId.equals("CHANGE_USERPROFILE_PASSWORD"))
             {
                   return CHANGE_PASSWORD;
             }

			String result=null;
			
			result = actionInvocation.invoke();
			return result;
		}
		else
		{
			if (logger.isDebugEnabled()) logger.debug("The action [" + action.getClass().getName() + "] is not instance of Authorization Aware.Skipping...");
			long end = System.currentTimeMillis();
			logger.performance(getClass().getName(), start, end);

			return actionInvocation.invoke();
		}
	
	}
	
}