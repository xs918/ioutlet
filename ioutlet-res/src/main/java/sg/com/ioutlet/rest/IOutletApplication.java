package sg.com.ioutlet.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import sg.com.ioutlet.rest.endpoint.OutletEndpoint;
import sg.com.ioutlet.rest.endpoint.RoleEndpoint;
import sg.com.ioutlet.rest.endpoint.ExceptionTestEndpoint;
import sg.com.ioutlet.rest.endpoint.UserEndpoint;
import sg.com.ioutlet.rest.exception.DataNotAcceptableExceptionHandler;
import sg.com.ioutlet.rest.exception.EjbExceptionHandler;
import sg.com.ioutlet.rest.exception.EjbUnavailableException;
import sg.com.ioutlet.rest.exception.GenericExceptionHandler;
import sg.com.ioutlet.rest.exception.DataNotFoundExceptionHandler;

@ApplicationPath("/rest")
public class IOutletApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	private Set<Class<?>> classes = new HashSet<Class<?>>();

	public IOutletApplication() throws EjbUnavailableException {
		addExceptionClass();
		addConfiguration();
		singletons.add(new ExceptionTestEndpoint());
		singletons.add(new RoleEndpoint());
		singletons.add(new UserEndpoint());
		singletons.add(new OutletEndpoint());
	}

	private void addConfiguration() {
		classes.add(JacksonConfig.class);
		
	}

	public void addExceptionClass() {
		classes.add(EjbExceptionHandler.class);
		classes.add(DataNotFoundExceptionHandler.class);
		classes.add(GenericExceptionHandler.class);
		classes.add(DataNotAcceptableExceptionHandler.class);
		

	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
