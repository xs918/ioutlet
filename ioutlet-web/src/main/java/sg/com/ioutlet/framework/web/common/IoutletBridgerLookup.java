package sg.com.ioutlet.framework.web.common;

import java.util.Hashtable;

import javax.ejb.EJBAccessException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import sg.com.ioutlet.bridge.GetterBridge;
import sg.com.ioutlet.bridge.SetterBridge;

public class IoutletBridgerLookup {

	public static GetterBridge lookupGetterBridge() {
		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES,
				"org.jboss.ejb.client.naming");

		String appName = "ioutlet-ear";
		String moduleName = "ioutlet-biz";
		String distinctName = "";
		String beanName = "IoutletGetter";
		String viewClassName = GetterBridge.class.getName();

		String lookName = "ejb:" + appName + "/" + moduleName + "/"
				+ distinctName + "/" + beanName + "!" + viewClassName;

		Context context = null;

		try {
			context = new InitialContext(jndiProperties);
		} catch (NamingException e) {
			throw new EJBAccessException("Initial ejb Context failed");
		}

		try {

			return (GetterBridge) context.lookup(lookName);
		} catch (NamingException e) {
			throw new EJBAccessException("look up ejb -" + lookName
					+ " failed");
		}

	}

	public static SetterBridge lookupSetterBridge() {
		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES,
				"org.jboss.ejb.client.naming");

		String appName = "ioutlet-ear";
		String moduleName = "ioutlet-biz";
		String distinctName = "";
		String beanName = "IoutletSetter";
		String viewClassName = SetterBridge.class.getName();

		String lookName = "ejb:" + appName + "/" + moduleName + "/"
				+ distinctName + "/" + beanName + "!" + viewClassName;

		Context context = null;

		try {
			context = new InitialContext(jndiProperties);
		} catch (NamingException e) {
			throw new EJBAccessException("Initial ejb Context failed");
		}

		try {

			return (SetterBridge) context.lookup(lookName);
		} catch (NamingException e) {
			throw new EJBAccessException("look up ejb -" + lookName
					+ " failed");
		}

	}

}
