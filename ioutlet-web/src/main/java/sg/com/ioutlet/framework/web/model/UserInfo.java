package sg.com.ioutlet.framework.web.model;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String userName;
	private String userUuid;
	private boolean changePwdRequried;
	private boolean accountExpired;
	private boolean accountLocked;
	private Date lastLoginTime;
		public UserInfo()
	{}
	public UserInfo(String userId, String userName, String userUuid, boolean changePwdRequried, boolean accountExpired, boolean accountLocked,Date lastLoginTime)
	{
		super();
		this.userId = userId;
		this.userName = userName;
		this.userUuid = userUuid;
		this.changePwdRequried = changePwdRequried;
		this.accountExpired = accountExpired;
		this.accountLocked = accountLocked;
		this.lastLoginTime = lastLoginTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public boolean isChangePwdRequried() {
		return changePwdRequried;
	}
	public void setChangePwdRequried(boolean changePwdRequried) {
		this.changePwdRequried = changePwdRequried;
	}
	public boolean isAccountExpired() {
		return accountExpired;
	}
	public void setAccountExpired(boolean accountExpired) {
		this.accountExpired = accountExpired;
	}
	public boolean isAccountLocked() {
		return accountLocked;
	}
	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	
}
