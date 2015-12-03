package sg.com.ioutlet.framework.web.interceptor;

import java.util.Map;
import java.util.Set;

import sg.com.ioutlet.bas.SystemException;
import sg.com.ioutlet.framework.authorization.Authorizor;
import sg.com.ioutlet.framework.authorization.model.AccessFunction;
import sg.com.ioutlet.framework.authorization.model.AuthenticationInfo;
import sg.com.ioutlet.framework.web.WebConstants;
import sg.com.ioutlet.framework.web.action.awareness.AuthorizationAware;
import sg.com.ioutlet.framework.web.authentiaction.AclFactory;
import sg.com.ioutlet.framework.web.authentiaction.Authenticator;
import sg.com.ioutlet.framework.web.model.EntityInfo;
import sg.com.ioutlet.framework.web.model.UserInfo;

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
			
			UserInfo userInfo = (UserInfo) getSession().get(WebConstants.LOGGED_IN_USER_INFO.toString());
			Set<String> availableFunctions = (Set<String>) getSession().get(WebConstants.USER_DOMAIN_FUNCTIONS.toString()+domainId);
			
			//check the one stored in the session is the same as the one requesting
			if(userInfo!=null){
				if(!userInfo.getUserId().equalsIgnoreCase(userId)){
					
					logger.info("The current user in the Session is different from the authenticated user from the request.Invalidating the existing session...");
					userInfo=null; //need to reload the user
					availableFunctions=null;//need to reload the functions
				}
			}
			
			
			if((availableFunctions == null || availableFunctions.isEmpty()) || userInfo == null)
			{
				Authorizor auth=AclFactory.getAuthorizor(domainId);
				
				if(auth == null)
				{
					throw new SystemException("authenticatorImpl Class defined for this interceptor is not available");
				}
				
				if(availableFunctions == null || availableFunctions.isEmpty())
				{		
					
					Map<String, AccessFunction> accessfuncs = auth.getAuthorizationInfo(userId).getFunctionAccess(domainId);
					availableFunctions = accessfuncs.keySet();
					if(availableFunctions == null)
					{
						if(logger.isDebugEnabled())
						{
							logger.debug("No functions available for this user in this domain");
						}
						return UNATHORIZED;
					}
					
					getSession().put(WebConstants.USER_DOMAIN_FUNCTIONS.toString()+domainId, availableFunctions);						
					if(logger.isDebugEnabled())
					{
						logger.debug(availableFunctions.size()+" functions available for this user in this domain");
					}
				
				}
				if(userInfo == null)
				{
					
					//Authenticator atn = AuthenticatorFactory.getAuthenticator();
					Authenticator atn = AclFactory.getAuthenticator(domainId);
					AuthenticationInfo ai = atn.getAuthenticationInfo(getRequest(), userId);
					userInfo = new UserInfo();
					userInfo.setUserId(userId);
					userInfo.setUserUuid(ai.getUserUuid());
					userInfo.setLastLoginTime(ai.getLastLoginTime());
					userInfo.setAccountExpired(ai.isAccountExpired());
					userInfo.setAccountLocked(ai.isAccountLocked());
					userInfo.setChangePwdRequried(ai.isChangePwdRequired());
					userInfo.setUserName(ai.getUserName());
					//Set ENTITY INFO
					if(ai.getUserInfo()!=null)
						userInfo.setEntityInfo((EntityInfo)ai.getUserInfo().get(EntityInfo.ENTITY_INFO));
					
					getSession().put(WebConstants.LOGGED_IN_USER_INFO.toString(), userInfo);
					if(logger.isDebugEnabled())
					{
						logger.debug("User Name: "+userInfo.getUserName()+"\n" +
								"User uuid: "+userInfo.getUserUuid()+"\n" +
								"Acc Expired: "+userInfo.isAccountExpired()+"\n " +
								"Account Locked: "+userInfo.isAccountLocked()+"\n" +
								"ChangePwd Required: "+userInfo.isChangePwdRequried());
					}
				}
			}
			else
			{
				if(getSession().get(WebConstants.RELOAD_USER) != null)
				{
					Authenticator atn = AclFactory.getAuthenticator(domainId);
					AuthenticationInfo ai = atn.getAuthenticationInfo(getRequest(), userId);
					userInfo = new UserInfo();
					userInfo.setUserId(userId);
					userInfo.setUserUuid(ai.getUserUuid());
					userInfo.setLastLoginTime(ai.getLastLoginTime());
					userInfo.setAccountExpired(ai.isAccountExpired());
					userInfo.setAccountLocked(ai.isAccountLocked());
					userInfo.setChangePwdRequried(ai.isChangePwdRequired());
					userInfo.setUserName(ai.getUserName());
					//Set ENTITY INFO
					if(ai.getUserInfo()!=null)
						userInfo.setEntityInfo((EntityInfo)ai.getUserInfo().get(EntityInfo.ENTITY_INFO));
					
					getSession().put(WebConstants.LOGGED_IN_USER_INFO.toString(), userInfo);
					getSession().remove(WebConstants.RELOAD_USER);
				}
			}

			

			
			if(!availableFunctions.contains(functionId) && !availableFunctions.contains("*") )
		
			  	return UNATHORIZED;
			
			
			if(userInfo != null)
			{
				if(userInfo.isChangePwdRequried() && !functionId.equals("CHANGE_USERPROFILE_PASSWORD"))
				{
					return CHANGE_PASSWORD;
				}
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