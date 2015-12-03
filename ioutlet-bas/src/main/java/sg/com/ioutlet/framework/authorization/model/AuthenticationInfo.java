package sg.com.ioutlet.framework.authorization.model;

import java.util.Date;
import java.util.Map;

public interface AuthenticationInfo {
	public boolean isAccountExpired();
	public void setAccountExpired(boolean accountExpired);
	
	public boolean isChangePwdRequired();
	public void setChangePwdRequired(boolean changePwdReq);
	
	public String getUserName();
	public void setUserName(String userName);
	
	public String getUserUuid();
	public void setUserUuid(String userUuid);
	
	public boolean isAccountLocked();
	public void setAccountLocked(boolean accountLocked);
	
	public Date getLastLoginTime();
	public void setLastLoginTime(Date lastLoginTime);
	
	public String getUserId();
	public void setUserId(String userId);
	
	public Date getLoginTime();
	public void setLoginTime(Date loginTime);
	
	public String getLoginSessionId();
	public void setLoginSessionId(String loginSessionId);
	
	public String getLoginIp();
	public void setLoginIp(String loginIp);
	
	public Map<String, Object> getUserInfo();
	public void setUserInfo(Map<String, Object> userInfo);
	
	public int getLoginFailureAttempts();
	public void setLoginFailureAttempts(int loginFailureAttempts);
}
