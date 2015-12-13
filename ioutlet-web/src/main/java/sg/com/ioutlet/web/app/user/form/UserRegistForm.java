package sg.com.ioutlet.web.app.user.form;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionSupport;

import sg.com.ioutlet.ace.user.User;
import sg.com.ioutlet.ace.user.img.Imge;
import sg.com.ioutlet.bas.Gender;
import sg.com.ioutlet.web.common.form.IoutletForm;

public class UserRegistForm extends IoutletForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String emailId;
	private String password;
	private String retypePassword;
	private String name;
	private Gender gender = Gender.O;
	private Date dayOfBirth;
	private String description;
	private String address1;
	private String address2;
	private String address3;
	private String postCode;
	private String langCode;
	private String currLoc;
	private String address;
	private String regNoOfCompany;
	private String nameOfCompany;
	private String telephone;
	private BigDecimal rewardPoint;
	private boolean locked;
	private int loginFailureAttempt;
	private Date lastLoginTime;
	private Date activeTime;
	private Date lastPasswordChangedTime;
	private Date lastLockedTime;
	
	private User regUser;
	
	private Map<String,String> langMap;
	private Map<String,String> locMap;
	private Map<String,String> genderMap;
	
	
	
	private String[] userImgFilesFileName;
	
	private String[] userImgFilesContentType;
	
	private File[] userImgFiles;
	
	
	
	private List<Imge> usrImgs;
	
	private String saveDirectory ="C:/Test/Upload";

	@Override
	public void reset() {
		userId = EMPTY;
		emailId = EMPTY;
		password = EMPTY;
		retypePassword=EMPTY;
		name = EMPTY;
		gender = Gender.O;
		dayOfBirth = null;
		description = EMPTY;
		postCode = EMPTY;
		langCode = EMPTY;
		currLoc = EMPTY;

		rewardPoint = null;
		locked = false;
		loginFailureAttempt = 0;
		lastLoginTime = null;
		activeTime = null;
		lastPasswordChangedTime = null;
		lastLockedTime = null;

	}

	@Override
	public Map<String, String> validate() {
			return null;
	}
    public String	getValidationType()
	{
		return VALIDATION_TYPE_CUSTOM;
	}
	
	@Override
	public boolean validate(ActionSupport as) {
	
		
		if (StringUtils.isBlank(userId)) {
			as.addFieldError("userId", as.getText("username.required"));
		}
		
		if (as.getFieldErrors().size() > 0)
		{
			return false;
		}
		return true;
		
		

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(Date dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}

	public String getDescription() {
		return description;
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

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	public String getCurrLoc() {
		return currLoc;
	}

	public void setCurrLoc(String currLoc) {
		this.currLoc = currLoc;
	}

	public BigDecimal getRewardPoint() {
		return rewardPoint;
	}

	public void setRewardPoint(BigDecimal rewardPoint) {
		this.rewardPoint = rewardPoint;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public int getLoginFailureAttempt() {
		return loginFailureAttempt;
	}

	public void setLoginFailureAttempt(int loginFailureAttempt) {
		this.loginFailureAttempt = loginFailureAttempt;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Date getActiveTime() {
		return activeTime;
	}

	public void setActiveTime(Date activeTime) {
		this.activeTime = activeTime;
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


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRetypePassword() {
		return retypePassword;
	}

	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}

	public String getRegNoOfCompany() {
		return regNoOfCompany;
	}

	public void setRegNoOfCompany(String regNoOfCompany) {
		this.regNoOfCompany = regNoOfCompany;
	}

	public String getNameOfCompany() {
		return nameOfCompany;
	}

	public void setNameOfCompany(String nameOfCompany) {
		this.nameOfCompany = nameOfCompany;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Map<String,String> getLangMap() {
		return langMap;
	}

	public void setLangMap(Map<String,String> langMap) {
		this.langMap = langMap;
	}

	public Map<String,String> getLocMap() {
		return locMap;
	}

	public void setLocMap(Map<String,String> locMap) {
		this.locMap = locMap;
	}

	public Map<String,String> getGenderMap() {
		return genderMap;
	}

	public void setGenderMap(Map<String,String> genderMap) {
		this.genderMap = genderMap;
	}


	public String getSaveDirectory() {
		return saveDirectory;
	}

	public void setSaveDirectory(String saveDirectory) {
		this.saveDirectory = saveDirectory;
	}

	public User getRegUser() {
		return regUser;
	}

	public void setRegUser(User regUser) {
		this.regUser = regUser;
	}



	public File[] getUserImgFiles() {
		return userImgFiles;
	}

	public void setUserImgFiles(File[] userImgFiles) {
		this.userImgFiles = userImgFiles;
	}

	public List<Imge> getUsrImgs() {
		return usrImgs;
	}

	public void setUsrImgs(List<Imge> usrImgs) {
		this.usrImgs = usrImgs;
	}

	public String[] getUserImgFilesFileName() {
		return userImgFilesFileName;
	}

	public void setUserImgFilesFileName(String[] userImgFilesFileName) {
		this.userImgFilesFileName = userImgFilesFileName;
	}

	public String[] getUserImgFilesContentType() {
		return userImgFilesContentType;
	}

	public void setUserImgFilesContentType(String[] userImgFilesContentType) {
		this.userImgFilesContentType = userImgFilesContentType;
	}

	
	
}
