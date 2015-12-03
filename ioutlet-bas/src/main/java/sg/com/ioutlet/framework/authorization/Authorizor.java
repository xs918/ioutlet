package sg.com.ioutlet.framework.authorization;

import sg.com.ioutlet.framework.authorization.model.AuthorizationInfo;

public interface Authorizor {
	public AuthorizationInfo getAuthorizationInfo(String loginUserId);
}
