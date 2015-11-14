package sg.com.ioutlet.model.user;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sg.com.ioutlet.bas.CommonPojo;
import sg.com.ioutlet.bas.CommonPojoKey;
import sg.com.ioutlet.bas.Gender;
import sg.com.ioutlet.model.role.Role;



public class User extends CommonPojo {
	private static final long serialVersionUID = 1L;
	public static final String ENTITY_NAME = "User";

	private UserKey key;
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
	private Role role;
	BigDecimal rewardPoint;

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
		key, emailId(50), password(200), profilePic(50), name(200),gender,birthDay, otherDetail(
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
		fields.add(new Object[] { Field.password.name(), password });
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
		this.password = (String) objects[i++];
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



}