package sg.com.ioutlet.framework.authorization.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import sg.com.ioutlet.bas.SystemException;
import sg.com.ioutlet.common.logging.LogHelper;

public class AuthorizationInfo {
	protected LogHelper logger = LogHelper.getInstance(getClass().getName());
	private DomainAccess[] domains;
	private Map<String,Map<String, AccessFunction>> accessibleFunctions;
	public DomainAccess[] getDomains()
	{
		return domains;
	}
	
	public void setDomains(DomainAccess[] domains)
	{
		this.domains = domains;
	}
	
	public Map<String, Map<String, AccessFunction>> getAccessibleFunctions()
	{
		return accessibleFunctions;
	}
	
	public void setAccessibleFunctions(Map<String, Map<String, AccessFunction>> accessibleFunctions)
	{
		this.accessibleFunctions = accessibleFunctions;
	}
	
	public Collection<AccessFunction> getFunctions(String domainId, String[] filterFunctions)
	{
		Map<String,AccessFunction> flist = getFunctionAccess(domainId);
		Collection<AccessFunction> result = new ArrayList<AccessFunction>();
		AccessFunction af;
		if(filterFunctions != null)
		{
		
			for(String functionId : filterFunctions)
			{
				af = flist.get(functionId);
				if(af !=null)
					result.add(af);
			}
			
		}
		return result;
	}
	
	public AccessFunction getFunction(String domainId, String functionId)
	{
		Map<String,AccessFunction> flist = getFunctionAccess(domainId);
		return flist.get(functionId);
	}
	
	
	public Map<String,AccessFunction> getFunctionAccess(String domainId)
	{
		return accessibleFunctions.get(domainId);
	}
	
	public boolean isAccessible(String domainId, String functionId)
	{
		if(StringUtils.isEmpty(domainId) || StringUtils.isEmpty(functionId))
			throw new SystemException("Domain ID and Function ID must present");

		Map<String, AccessFunction> functionAccess = accessibleFunctions.get(domainId);
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
}
