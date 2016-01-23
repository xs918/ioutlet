package sg.com.ioutlet.web.app.user.form;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.json.annotations.JSON;

import sg.com.ioutlet.ace.functionaccess.FunctionAccess;
import sg.com.ioutlet.ace.role.Role;
import sg.com.ioutlet.ace.user.User;
import sg.com.ioutlet.bas.DateUtil;
import sg.com.ioutlet.model.img.Image;
import sg.com.ioutlet.web.common.form.IoutletForm;

import com.opensymphony.xwork2.ActionSupport;

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
	private String gender;
	private String dayOfBirth;
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
	

	private Map<String,Role> rolesMap;
	
	private Role selectedRole;
	private String selectedRoleName;
	
	private TreeMap<String,String> langMap;
	private TreeMap<String,String> locMap;
	private TreeMap<String,String> genderMap;
    private  Map<Role,List<FunctionAccess>> allRoleFunctionAccessMap=new HashMap<Role,List<FunctionAccess>>();
	
	
	private String[] userImageFilesFileName;
	
	private String[] userImageFilesContentType;
	
	private File[] userImageFiles;
	
	private List<String> selectedFunction;
	
	public List<FunctionAccess> getFunctionAccess(Role role)
	{
		return allRoleFunctionAccessMap.get(role);
	}
	
	
	
	private List<Image> usrImages;
	
	private String saveDirectory ="/tmp/iolt/Test/Upload";

	@Override
	public void reset() {
		userId = EMPTY;
		emailId = EMPTY;
		password = EMPTY;
		retypePassword=EMPTY;
		name = EMPTY;
		gender =EMPTY;
		dayOfBirth =  EMPTY;
		description = EMPTY;
		postCode = EMPTY;
		langCode = EMPTY;
		currLoc = EMPTY;
		address1=EMPTY;
		address2=EMPTY;
		address3=EMPTY;
		
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
			as.addFieldError("userId", as.getText("user.id.is.required"));
		}
		
		if (StringUtils.isBlank(emailId)) {
			as.addFieldError("emailId", as.getText("email.is.required"));
		}
		else if(!isValidEmailAddress(emailId))
		{
			as.addFieldError("emailId", as.getText("email.is.invalid"));
		}
		if(StringUtils.isBlank(password))
		{
			as.addFieldError("password", as.getText("password.is.required"));
		}else if(!isAcceptablePassword(password))
		{
			
			as.addFieldError("password", as.getText("password.is.invalid"));
		}
		if(!StringUtils.equalsIgnoreCase(retypePassword, password))
		{
			as.addFieldError("retypePassword", as.getText("retype.password.dont.match"));
		}
		if(StringUtils.isBlank(name))
		{
			as.addFieldError("name", as.getText("full.name.is.required"));
		}
		
		
		if(StringUtils.isBlank(regNoOfCompany))
		{

			as.addFieldError("regNoOfCompany", as.getText("reg.no.of.company.is.required"));
		}
		
		
		if(StringUtils.isBlank(nameOfCompany))
		{

			as.addFieldError("nameOfCompany", as.getText("name.of.company.is.required"));
		}
		
		
		if(StringUtils.isBlank(telephone))
		{

			as.addFieldError("telephone", as.getText("telephone.no.of.company.is.required"));
		}
		
		if(StringUtils.isBlank(dayOfBirth))
		{

			as.addFieldError("dayOfBirth", as.getText("day.of.birth.is.required"));
		}
		else if(!DateUtil.isValidDate(this.dayOfBirth))
		{

			as.addFieldError("dayOfBirth", as.getText("day.of.birth.is.invalid"));
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(String dayOfBirth) {
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

	public void setLangMap(TreeMap<String,String> langMap) {
		this.langMap = langMap;
	}

	public Map<String,String> getLocMap() {
		return locMap;
	}

	public void setLocMap(TreeMap<String,String> locMap) {
		this.locMap = locMap;
	}

	public TreeMap<String,String> getGenderMap() {
		return genderMap;
	}

	public void setGenderMap(TreeMap<String,String> genderMap) {
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



	public File[] getUserImageFiles() {
		return userImageFiles;
	}

	public void setUserImageFiles(File[] userImageFiles) {
		this.userImageFiles = userImageFiles;
	}

	public List<Image> getUsrImages() {
		return usrImages;
	}

	public void setUsrImages(List<Image> usrImages) {
		this.usrImages = usrImages;
	}

	public String[] getUserImageFilesFileName() {
		return userImageFilesFileName;
	}

	public void setUserImageFilesFileName(String[] userImageFilesFileName) {
		this.userImageFilesFileName = userImageFilesFileName;
	}

	public String[] getUserImageFilesContentType() {
		return userImageFilesContentType;
	}

	public void setUserImageFilesContentType(String[] userImageFilesContentType) {
		this.userImageFilesContentType = userImageFilesContentType;
	}




	@JSON(serialize=false)
	public Map<Role,List<FunctionAccess>> getAllRoleFunctionAccessMap() {
		return allRoleFunctionAccessMap;
	}

	public void setAllRoleFunctionAccessMap(Map<Role,List<FunctionAccess>> allRoleFunctionAccessMap) {
		this.allRoleFunctionAccessMap = allRoleFunctionAccessMap;
	}
	@JSON(serialize=false)
	public Role getSelectedRole() {
		return selectedRole;
	}

	public void setSelectedRole(Role selectedRole) {
		this.selectedRole = selectedRole;
	}


	public String getSelectedRoleName() {
		return selectedRoleName;
	}

	public void setSelectedRoleName(String selectedRoleName) {
		this.selectedRoleName = selectedRoleName;
	}
	

	@JSON(serialize=false)
	public Map<String,Role> getRolesMap() {
		return rolesMap;
	}

	public void setRolesMap(Map<String,Role> rolesMap) {
		this.rolesMap = rolesMap;
	}

	public List<String> getSelectedFunction() {
		return selectedFunction;
	}

	public void setSelectedFunction(List<String> selectedFunction) {
		this.selectedFunction = selectedFunction;
	}

	public void populateSelectedFunctionName()
	{
		if(getRolesMap()!=null)
		{
			List<String>accessFunction=  new ArrayList<String>();
		    for(FunctionAccess a:selectedRole.getAccessFunctions())
		    {
		    	accessFunction.add(a.getName());
		    	
		    }
		    setSelectedFunction(accessFunction);
		}
	}
}
