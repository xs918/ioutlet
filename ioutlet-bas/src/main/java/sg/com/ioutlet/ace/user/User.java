package sg.com.ioutlet.ace.user;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sg.com.ioutlet.ace.password.PasswordUtil;
import sg.com.ioutlet.ace.role.Role;
import sg.com.ioutlet.ace.user.img.UserImg;
import sg.com.ioutlet.bas.Address;
import sg.com.ioutlet.bas.CommonPojo;
import sg.com.ioutlet.bas.CommonPojoKey;
import sg.com.ioutlet.bas.Gender;




public class User extends CommonPojo {
	private static final long serialVersionUID = 1L;
	public static final String ENTITY_NAME = "User";
	public static final int MAX_FAIL_COUNT = 10;

	private UserKey key;
	private String userId;
	private String emailId;

	private String storedPassword;

	private String name;
	private Gender gender=Gender.U;
	private Date birthDay;
	private String otherDetail;
	private String postCode;
	private String langCode;
	private String currLoc;

	private BigDecimal rewardPoint;
	
	private boolean locked;
	
	private int loginFailureAttempts;

	private int loginFailureAttemptsHistory;

	private Date lastLoginTime;

	private Date lastLoginTimeHistory;

	private Date accountActivateTime;


	private Date lastPasswordChangedTime;

	private Date lastLockedTime;

	private boolean changePasswordRequired;
	
	private List<UserImg> imges;
	private List<Address> address;
	private List<Role> roles;

	public User() {

		this.key = new UserKey();
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	public User(UserKey key) {
		this.key = key;
	}

	public enum Field {
		key, emailId(50), storedPassword(200), profilePic(50), name(200),gender,birthDay, otherDetail(
				500), address1(200), address2(200), address3(200), address4(200), address5(
				200), postCode(10), langCode,currLoc,role, rewardPoint(16, 2);

		public int length = 255;
		public int precision;
		public int scale;

		private Field() {
		}

		private Field(int length) {
			this.length = length;
		}

		private Field(int precision, int scale) {
			this.precision = precision;
			this.scale = scale;
		}
	}

	@Override
	public List<Object[]> getFields() {

		List<Object[]> fields = new ArrayList<Object[]>();
		fields.add(new Object[] { Field.emailId.name(), emailId });
		fields.add(new Object[] { Field.storedPassword.name(), storedPassword });
		fields.add(new Object[] { Field.profilePic.name(), profilePic });
		fields.add(new Object[] { Field.name.name(), name });
		fields.add(new Object[] { Field.gender.name(), gender });
		fields.add(new Object[] { Field.birthDay.name(), birthDay });
		fields.add(new Object[] { Field.otherDetail.name(), otherDetail });
		fields.add(new Object[] { Field.address1.name(), address1 });
		fields.add(new Object[] { Field.address2.name(), address2 });
		fields.add(new Object[] { Field.address3.name(), address3 });
		fields.add(new Object[] { Field.address4.name(), address4 });
		fields.add(new Object[] { Field.address5.name(), address5 });
		fields.add(new Object[] { Field.postCode.name(), postCode });
		fields.add(new Object[] { Field.langCode.name(), langCode });
		fields.add(new Object[] { Field.currLoc.name(), currLoc });
			
		fields.add(new Object[] { Field.role.name(), role });
		fields.add(new Object[] { Field.rewardPoint.name(), rewardPoint });

		return fields;

	}

	@Override
	public void initialize(Object... objects) {
		int i = 0;

		this.emailId = (String) objects[i++];
		this.storedPassword = (String) objects[i++];
		this.profilePic = (String) objects[i++];
		this.name = (String) objects[i++];
		this.gender =(Gender) objects[i++];
		this.birthDay =(Date) objects[i++];
		this.otherDetail = (String) objects[i++];
		this.address1 = (String) objects[i++];
		this.address2 = (String) objects[i++];
		this.address3 = (String) objects[i++];
		this.address4 = (String) objects[i++];
		this.address5 = (String) objects[i++];
		this.postCode = (String) objects[i++];
		this.role = (Role) objects[i++];
		this.rewardPoint = (BigDecimal) objects[i++];

	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String entityName() {

		return ENTITY_NAME;
	}
	public void setKey(UserKey key) {
		this.key = key;
	}





	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return storedPassword;
	}



	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getOtherDetail() {
		return otherDetail;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public void setOtherDetail(String otherDetail) {
		this.otherDetail = otherDetail;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getAddress4() {
		return address4;
	}

	public void setAddress4(String address4) {
		this.address4 = address4;
	}

	public String getAddress5() {
		return address5;
	}

	public void setAddress5(String address5) {
		this.address5 = address5;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public  Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public BigDecimal getRewardPoint() {
		return rewardPoint;
	}

	public void setRewardPoint(BigDecimal rewardPoint) {
		this.rewardPoint = rewardPoint;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getEntityName() {
		return ENTITY_NAME;
	}

	@Override
	public void setKey(CommonPojoKey key) {
	 this.setKey(key);
		
	}

	@Override
	public UserKey getKey() {
	
		return this.key;
	}

	public String getCurrLoc() {
		return currLoc;
	}

	public void setCurrLoc(String currLoc) {
		this.currLoc = currLoc;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public int getLoginFailureAttempts() {
		return loginFailureAttempts;
	}

	public void setLoginFailureAttempts(int loginFailureAttempts) {
		this.loginFailureAttempts = loginFailureAttempts;
	}

	public int getLoginFailureAttemptsHistory() {
		return loginFailureAttemptsHistory;
	}

	public void setLoginFailureAttemptsHistory(int loginFailureAttemptsHistory) {
		this.loginFailureAttemptsHistory = loginFailureAttemptsHistory;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Date getLastLoginTimeHistory() {
		return lastLoginTimeHistory;
	}

	public void setLastLoginTimeHistory(Date lastLoginTimeHistory) {
		this.lastLoginTimeHistory = lastLoginTimeHistory;
	}

	public Date getAccountActivateTime() {
		return accountActivateTime;
	}

	public void setAccountActivateTime(Date accountActivateTime) {
		this.accountActivateTime = accountActivateTime;
	}

	public Date getLastPasswordChangedTime() {
		return lastPasswordChangedTime;
	}

	public void setLastPasswordChangedTime(Date lastPasswordChangedTime) {
		this.lastPasswordChangedTime = lastPasswordChangedTime;
	}

	public Date getLastLockedTime() {
		return lastLockedTime;
	}

	public void setLastLockedTime(Date lastLockedTime) {
		this.lastLockedTime = lastLockedTime;
	}

	public boolean isChangePasswordRequired() {
		return changePasswordRequired;
	}

	public void setChangePasswordRequired(boolean changePasswordRequired) {
		this.changePasswordRequired = changePasswordRequired;
	}

	
	public void setPassword(String password)
	{
		try
		{
			this.storedPassword = PasswordUtil.encodePassword(password, null);
		}
		catch (UnsupportedEncodingException ex)
		{

		}
		catch (NoSuchAlgorithmException ex)
		{

		}
		catch (NullPointerException e)
		{

		}
		catch (Exception e)
		{

		}
	}

	public String getStoredPassword()
	{
		return this.storedPassword;
	}

	public void setStoredPassword(String storedPassword)
	{
		this.storedPassword = storedPassword;
	}

	
	public boolean isPasswordMatch(String userInputPassword)
	{
		try
		{
			if (PasswordUtil.isPasswordMatched(userInputPassword, storedPassword))
			{
				return true;
			}
		}
		catch (Exception ex)
		{

		}
		return false;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isAccountExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	}

	public Object getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public UserConfig getUserConfig() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getMaxFailCount()
	{
		return MAX_FAIL_COUNT;
	}



}