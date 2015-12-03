package sg.com.ioutlet.framework.web.action.awareness;

public interface AuthorizationAware {

	/**
	 * @return the logged in userid
	 */
	public abstract String getUserId();

	/**
	 * @return the domain id of the system
	 */
	public abstract String getDomainId();

	/**
	 * @return the function id of the system
	 */
	public abstract String getFunctionId();

}
