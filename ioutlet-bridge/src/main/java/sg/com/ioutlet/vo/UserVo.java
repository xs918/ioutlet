package sg.com.ioutlet.vo;

import java.math.BigDecimal;
import java.util.Date;

import sg.com.ioutlet.bas.Gender;

public class UserVo  extends CommonVo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String emailId;

	private String password;

	private String profilePic;
	private String name;
	private Gender gender=Gender.U;
	private Date birthDay;
	private String otherDetail;
	private String address1;
	private String address2;
	private String address3;
	private String address4;
	private String address5;
	private String postCode;
	private String langCode;
	private String currLoc;
	private String roleId;
	private BigDecimal rewardPoint;
	
	public UserVo()
	{
		
	}
	

	public UserVo(String id, String emailId, String password,
			String profilePic, String name, Gender gender, Date birthDay,
			String otherDetail, String address1, String address2,
			String address3, String address4, String address5, String postCode,
			String langCode, String roleId, BigDecimal rewardPoint) {
	
		this.id = id;
		this.emailId = emailId;
		this.password = password;
		this.profilePic = profilePic;
		this.name = name;
		this.gender = gender;
		this.birthDay = birthDay;
		this.otherDetail = otherDetail;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.address4 = address4;
		this.address5 = address5;
		this.postCode = postCode;
		this.langCode = langCode;
		this.roleId = roleId;
		this.rewardPoint = rewardPoint;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
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
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getOtherDetail() {
		return otherDetail;
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
	public String getLangCode() {
		return langCode;
	}
	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}
	public BigDecimal getRewardPoint() {
		return rewardPoint;
	}
	public void setRewardPoint(BigDecimal rewardPoint) {
		this.rewardPoint = rewardPoint;
	}


	public String getRoleId() {
		return roleId;
	}


	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}


	public String getCurrLoc() {
		return currLoc;
	}


	public void setCurrLoc(String currLoc) {
		this.currLoc = currLoc;
	}




	
	

}
