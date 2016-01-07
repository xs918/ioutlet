package sg.com.ioutlet.framework.web.action.awareness;

import sg.com.ioutlet.ace.user.User;

public interface AuthorizationAware {

	
	/**
	 * @return the domain id of the system
	 */
	public abstract String getDomainId();

	/**
	 * @return the function id of the system
	 */
	public abstract String getFunctionId();
	public abstract void setUserProfile(User user);

}
