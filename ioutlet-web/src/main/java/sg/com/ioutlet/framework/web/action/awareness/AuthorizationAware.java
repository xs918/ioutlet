package sg.com.ioutlet.framework.web.action.awareness;

public interface AuthorizationAware {

	
	/**
	 * @return the domain id of the system
	 */
	public abstract String getDomainId();

	/**
	 * @return the function id of the system
	 */
	public abstract String getFunctionId();

}
