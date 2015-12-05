package sg.com.ioutlet.framework.web.authentication.impl;

import java.util.Date;
import java.util.Map;

import sg.com.ioutlet.framework.authorization.model.AuthenticationInfo;

public class AceAuthenticationInfo  implements AuthenticationInfo
{
	private boolean accountExpired;
	private boolean changePwdRequired;
	private boolean accountLocked;
	private String userName;
	private String userUuid;
	private String userId;
	private Date lastLoginTime;
	private Date loginTime;
	private String loginSessionId;
	private String loginIp;
	private Map<String, Object> userInfo;
	private int loginFailureAttempts;
	public boolean isAccountExpired() {
		return accountExpired;
	}
	public void setAccountExpired(boolean accountExpired) {
		this.accountExpired = accountExpired;
	}
	public boolean isChangePwdRequired() {
		return changePwdRequired;
	}
	public void setChangePwdRequired(boolean changePwdRequired) {
		this.changePwdRequired = changePwdRequired;
	}
	public boolean isAccountLocked() {
		return accountLocked;
	}
	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserUuid() {
		return userUuid;
	}
	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public String getLoginSessionId() {
		return loginSessionId;
	}
	public void setLoginSessionId(String loginSessionId) {
		this.loginSessionId = loginSessionId;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public Map<String, Object> getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(Map<String, Object> userInfo) {
		this.userInfo = userInfo;
	}
	public int getLoginFailureAttempts() {
		return loginFailureAttempts;
	}
	public void setLoginFailureAttempts(int loginFailureAttempts) {
		this.loginFailureAttempts = loginFailureAttempts;
	}
	
	

}
