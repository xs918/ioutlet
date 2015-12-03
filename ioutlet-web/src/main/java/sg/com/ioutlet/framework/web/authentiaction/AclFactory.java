package sg.com.ioutlet.framework.web.authentiaction;

import com.opensymphony.xwork2.ObjectFactory;

import sg.com.ioutlet.common.logging.LogHelper;
import sg.com.ioutlet.framework.authorization.Authorizor;

public class AclFactory {
	private static LogHelper logger = LogHelper.getInstance(AclFactory.class.getName());

	public static final String ACL_KEY = "ACL";

	public static final String AUTHEN_PROVIDER = "AUTHENTICATOR";

	public static final String AUTHORIZOR_PROVIDER = "AUTHORIZOR";


	public static Authorizor getAuthorizor(String domainId)
	{
		App defApp = AppEnv.getApp(ACL_KEY);
		App acl = AppEnv.getApp(domainId);
		if (acl == null && defApp == null)
		{
			logger.warn("ACL app is not configured in configuration file. Ignoring acl checkings");
			return null;
		}

		String authorizor = null;
		if(acl != null)
			authorizor = acl.getOptional(ACL_KEY+"."+AUTHORIZOR_PROVIDER);
		if(authorizor == null && defApp != null)
			authorizor = defApp.getOptional(ACL_KEY+"."+AUTHORIZOR_PROVIDER);
		
		if (authorizor == null)
		{
			logger.warn("ACL AUTHENTICATOR is not configured in configuration file. Ignoring authenticator checkings");
			return null;
		}
		if (logger.isDebugEnabled())
		{
			logger.debug("Authorizor is loaded using: " + authorizor);
		}
		Authorizor a = (Authorizor) ObjectFactory.getObjectFactory();
		return a;
	}


	public static Authenticator getAuthenticator(String domainId) {
		// TODO Auto-generated method stub
		return null;
	}

}
