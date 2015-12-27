package sg.com.ioutlet.framework.authorization.model;

import java.io.Serializable;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import sg.com.ioutlet.ace.functionaccess.FunctionAccess;
import sg.com.ioutlet.ace.user.User;
import sg.com.ioutlet.bas.SystemException;
import sg.com.ioutlet.common.logging.LogHelper;

public class AuthorizationInfo   implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 5291991280711766718L;


	protected LogHelper logger = LogHelper.getInstance(getClass().getName());
	private DomainAccess domains;
	private User user;
	private Map<String,Map<IoltFunction, FunctionAccess>> accessibleFunctions;
	
	public Map<String, Map<IoltFunction, FunctionAccess>> getAccessibleFunctions()
	{
		return accessibleFunctions;
	}
	
	public void setAccessibleFunctions(Map<String, Map<IoltFunction, FunctionAccess>> accessibleFunctions)
	{
		this.accessibleFunctions = accessibleFunctions;
	}
	
	
	public AccessFunction getFunction(String domainId, String functionId)
	{
		Map<IoltFunction,FunctionAccess> flist = getFunctionAccess(domainId);
		return flist.get(functionId);
	}
	
	
	public Map<IoltFunction,FunctionAccess> getFunctionAccess(String domainId)
	{
		return accessibleFunctions.get(domainId);
	}
	
	public boolean isAccessible(String domainId, String functionId)
	{
		if(StringUtils.isEmpty(domainId) || StringUtils.isEmpty(functionId))
			throw new SystemException("Domain ID and Function ID must present");

		Map<IoltFunction, FunctionAccess> functionAccess = accessibleFunctions.get(domainId);
		if(functionAccess == null)
				return false;
		if(functionAccess.containsKey(functionId))
		{
			return true;
		}
		else if(functionAccess.containsKey("*"))
		{
			if(logger.isDebugEnabled())
			{
				logger.debug("Skipping the authorization check. The wild card * present in domain list.");
			}
			return true;
		}
		else
		{
			if(logger.isDebugEnabled())
			{
				logger.debug("The user does not have function access for : "+functionId);
				logger.debug("Total function user can access : "+functionAccess.size());
			}
		}
			
		return false;		
	}

	public DomainAccess getDomains() {
		return domains;
	}

	public void setDomains(DomainAccess domains) {
		this.domains = domains;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
