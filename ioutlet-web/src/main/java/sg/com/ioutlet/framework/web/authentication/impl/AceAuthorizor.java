package sg.com.ioutlet.framework.web.authentication.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sg.com.ioutlet.ace.domain.Domain;
import sg.com.ioutlet.ace.function.Function;
import sg.com.ioutlet.bridge.AceBridge;
import sg.com.ioutlet.framework.authorization.Authorizor;
import sg.com.ioutlet.framework.authorization.model.AccessFunction;
import sg.com.ioutlet.framework.authorization.model.AuthorizationInfo;
import sg.com.ioutlet.framework.authorization.model.DomainAccess;
import sg.com.ioutlet.framework.trxhelper.TransactionControl;
import sg.com.ioutlet.framework.web.common.IoutletBridgerLookup;

public class AceAuthorizor implements Authorizor{
	public AuthorizationInfo getAuthorizationInfo(String loginUserId)
	{		
		AuthorizationInfo ai = new AuthorizationInfo();
		ai.setDomains(getDomainAccess(loginUserId));
		
		Map<String, Map<String, AccessFunction>> domainFunctionAccess = new HashMap<String, Map<String, AccessFunction>>();
		for(DomainAccess da : ai.getDomains())
		{
			domainFunctionAccess.put(da.getId(), getFunctionAccess(loginUserId, da.getId()));
		}
		ai.setAccessibleFunctions(domainFunctionAccess);
		return ai;
	}
	
	
	public DomainAccess[] getDomainAccess(String loginUserId)
	{
		//AceServiceBridge bridge = (AceServiceBridge)PortableRemoteObject.narrow(EjbBridgeFinder.getBridge(AceServiceBridge.NAME_SPACE),AceServiceBridge.class);
		AceBridge bridge = IoutletBridgerLookup.lookupAceBridge();
		List<Domain> domainList = bridge.getDomains(loginUserId,TransactionControl.getTransactionInfo());
		DomainAccess[] domains = new DomainAccess[domainList.size()];
		Domain domain; 
		for(int i =0;i<domainList.size();i++)
		{
			domain = domainList.get(i);
			domains[i] = (DomainAccess) domain;
		}
		return domains;
	}
	
	public Map<String, AccessFunction> getFunctionAccess(String loginUserId, String domainId)
	{
		//AceServiceBridge bridge = (AceServiceBridge)PortableRemoteObject.narrow(EjbBridgeFinder.getBridge(AceServiceBridge.NAME_SPACE),AceServiceBridge.class);
		AceBridge bridge = IoutletBridgerLookup.lookupAceBridge();
		List<Function> functions = bridge.getFunctionsByUserProfileAndDomainId(loginUserId, domainId, TransactionControl.getTransactionInfo());
		Map<String, AccessFunction> ma = new HashMap<String, AccessFunction>();
		for(Function f: functions)
		{			
			ma.put(f.getId(),(AccessFunction) f);
		}		
		return ma;
	}
	

}
