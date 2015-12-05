package sg.com.ioutlet.ace.user;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sg.com.ioutlet.ace.password.PasswordUtil;
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
	private Date dayOfBirth;
	private String description;
	private String postCode;
	private String langCode;
	private String currLoc;

	private BigDecimal rewardPoint;	
	private boolean locked;
	private int loginFailureAttempt;
	private Date lastLoginTime;
	private Date activeTime;
    private Date lastPasswordChangedTime;
	private Date lastLockedTime;


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


	@Override
	public void initialize(Object... objects) {
		int i = 0;

		this.userId = (String) objects[i++];
		this.emailId = (String) objects[i++];
		this.storedPassword = (String) objects[i++];
		this.name = (String) objects[i++];
		this.gender =(Gender) objects[i++];
		this.dayOfBirth =(Date) objects[i++];
		this.description = (String) objects[i++];
		this.postCode = (String) objects[i++];
		this.langCode = (String) objects[i++];
		this.currLoc = (String) objects[i++];
		this.rewardPoint = (BigDecimal) objects[i++];
		this.locked = (boolean) objects[i++];
		this.loginFailureAttempt = (int) objects[i++];
		this.lastLoginTime = (Date) objects[i++];
		this.lastLoginTime = (Date) objects[i++];
		this.activeTime = (Date) objects[i++];
		this.lastPasswordChangedTime = (Date) objects[i++];
		this.lastLockedTime = (Date) objects[i++];
		

	

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



	


	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	
	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
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


	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
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

	
	
	public int getMaxFailCount()
	{
		return MAX_FAIL_COUNT;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(Date dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}

	public int getLoginFailureAttempt() {
		return loginFailureAttempt;
	}

	public void setLoginFailureAttempt(int loginFailureAttempt) {
		this.loginFailureAttempt = loginFailureAttempt;
	}

	public Date getActiveTime() {
		return activeTime;
	}

	public void setActiveTime(Date activeTime) {
		this.activeTime = activeTime;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public enum Field {
		key, userId(100), emailId(100), storedPassword(50), name(50), gender,dayOfBirth,
		description(200),postCode(10),langCode(10),currLoc(50),rewardPoint,
		locked(1),loginFailureAttempt,lastLoginTime,activeTime,lastPasswordChangedTime,lastLockedTime;
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
		fields.add(new Object[] { Field.userId.name(), userId });
		fields.add(new Object[] { Field.emailId.name(), emailId });
		fields.add(new Object[] { Field.storedPassword.name(), storedPassword });
		fields.add(new Object[] { Field.storedPassword.name(), storedPassword });
		fields.add(new Object[] { Field.gender.name(), gender });
			
		fields.add(new Object[] { Field.dayOfBirth.name(), dayOfBirth });
		fields.add(new Object[] { Field.description.name(), description });
		fields.add(new Object[] { Field.description.name(), description });
		fields.add(new Object[] { Field.langCode.name(), langCode });
		fields.add(new Object[] { Field.langCode.name(), langCode });
		fields.add(new Object[] { Field.rewardPoint.name(), rewardPoint });
		fields.add(new Object[] { Field.loginFailureAttempt.name(), loginFailureAttempt });
		fields.add(new Object[] { Field.loginFailureAttempt.name(), loginFailureAttempt });
		fields.add(new Object[] { Field.loginFailureAttempt.name(), loginFailureAttempt });
		fields.add(new Object[] { Field.lastPasswordChangedTime.name(), lastPasswordChangedTime });
		fields.add(new Object[] { Field.lastLockedTime.name(), lastLockedTime });
		
		return fields;
	}



}