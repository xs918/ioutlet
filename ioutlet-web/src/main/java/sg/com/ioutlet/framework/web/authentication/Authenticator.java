package sg.com.ioutlet.framework.web.authentication;

import javax.servlet.http.HttpServletRequest;

import sg.com.ioutlet.framework.authorization.model.AuthenticationInfo;

public interface Authenticator {
	public AuthenticationInfo getAuthenticationInfo(HttpServletRequest request, String userid);
	public String getUserId(HttpServletRequest request);
}
