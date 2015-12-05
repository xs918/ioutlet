package sg.com.ioutlet.framework.web.interceptor;

import java.util.Map;
import java.util.Set;

import sg.com.ioutlet.ace.user.User;
import sg.com.ioutlet.bas.SystemException;
import sg.com.ioutlet.framework.authorization.model.AccessFunction;
import sg.com.ioutlet.framework.authorization.model.AuthorizationInfo;
import sg.com.ioutlet.framework.web.WebConstants;
import sg.com.ioutlet.framework.web.action.awareness.AuthorizationAware;
import com.opensymphony.xwork2.ActionInvocation;

public class AuthorizationCheckInterceptor extends CommonInterceptor {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String UNATHORIZED = "unathorized";
	
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
		if (action instanceof AuthorizationAware)
		{
			
						
			AuthorizationAware aa = (AuthorizationAware) action;
			String domainId = aa.getDomainId();
			String functionId = aa.getFunctionId();
			String userId = aa.getUserId();
			
			
			
			if(domainId == null || functionId == null || userId == null)
			{
				throw new SystemException("The mandatory information : domainId/functionId/userId ["+domainId+"/"+functionId+"/"+userId+"] not defined");
			}
			
			User userInfo = (User) getSession().get(WebConstants.LOGGED_IN_USER_INFO.toString());
		
			Set<String> availableFunctions = (Set<String>) getSession().get(WebConstants.USER_DOMAIN_FUNCTIONS.toString()+domainId);
			
			if(userInfo!=null){
				if(!userInfo.getUserId().equalsIgnoreCase(userId)){
					
					logger.info("The current user in the Session is different from the authenticated user from the request.Invalidating the existing session...");
					userInfo=null; //need to reload the user
					availableFunctions=null;//need to reload the functions
				}
			}
			
			if(availableFunctions == null || availableFunctions.isEmpty()) 
			{
				AuthorizationInfo auth =  this.getAce().getAuthenticationInfo(userId);
				if(auth == null)
				{
					throw new SystemException("Can not load the Authorization Info ");
				}
				Map<String, AccessFunction> accessfuncs = auth.getFunctionAccess(domainId);
				availableFunctions = accessfuncs.keySet();
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
				getSession().put(WebConstants.USER_DOMAIN_FUNCTIONS.toString()+domainId, availableFunctions);						
				
				
			}
			
			if(userInfo == null)
			{
				userInfo =  this.getAce().getUserById(userId);	
				if(userInfo == null)
			    {
					throw new SystemException("Can not load the user:"+userId);
			    }
				
				getSession().put(WebConstants.LOGGED_IN_USER_INFO.toString(), userInfo);
				
			}
			
			if(getSession().get(WebConstants.RELOAD_USER) != null)
			{
				
				userInfo =  this.getAce().getUserById(userId);		
				getSession().put(WebConstants.LOGGED_IN_USER_INFO.toString(), userInfo);
				getSession().remove(WebConstants.RELOAD_USER);
			}
			if(!availableFunctions.contains(functionId) && !availableFunctions.contains("*") )
			  	return UNATHORIZED;
			
			
		
		     if(functionId.equals("CHANGE_USERPROFILE_PASSWORD"))
             {
                   return CHANGE_PASSWORD;
             }

			String result;
			
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