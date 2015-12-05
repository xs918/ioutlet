package sg.com.ioutlet.rest.common;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import sg.com.ioutlet.bridge.AceBridge;
import sg.com.ioutlet.bridge.GetterBridge;
import sg.com.ioutlet.bridge.SetterBridge;
import sg.com.ioutlet.rest.exception.EjbUnavailableException;

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
			throw new EjbUnavailableException("Initial ejb Context failed");
		}

		try {

			return (GetterBridge) context.lookup(lookName);
		} catch (NamingException e) {
			throw new EjbUnavailableException("look up ejb -" + lookName
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
			throw new EjbUnavailableException("Initial ejb Context failed");
		}

		try {

			return (SetterBridge) context.lookup(lookName);
		} catch (NamingException e) {
			throw new EjbUnavailableException("look up ejb -" + lookName
					+ " failed");
		}

	}
	
	
	public static AceBridge lookupAceBridge() {
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
			throw new EjbUnavailableException("Initial ejb Context failed");
		}

		try {

			return (AceBridge) context.lookup(lookName);
		} catch (NamingException e) {
			throw new EjbUnavailableException("look up ejb -" + lookName
					+ " failed");
		}

	}

}
