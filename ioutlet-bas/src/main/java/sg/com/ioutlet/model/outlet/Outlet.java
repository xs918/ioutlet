package sg.com.ioutlet.model.outlet;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.Validate;

import sg.com.ioutlet.bas.CommonPojo;
import sg.com.ioutlet.bas.CommonPojoKey;

public class Outlet extends CommonPojo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ENTITY_NAME = "Outlet";

	public Outlet(OutletKey key) {
		this.key = key;
	}

	public enum Field {
		key, name(50), logo(100), telPhone(50), faxNo(50), email(100), addr1(
				200), addr2(200), addr3(200), addr4(200), addr5(200), postCode(
				10), description(200);

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
		fields.add(new Object[] { Field.name.name(), name });
		fields.add(new Object[] { Field.logo.name(), logo });
		fields.add(new Object[] { Field.telPhone.name(), telPhone });
		fields.add(new Object[] { Field.faxNo.name(), faxNo });
		fields.add(new Object[] { Field.email.name(), email });
			
		fields.add(new Object[] { Field.description.name(), description });
		fields.add(new Object[] { Field.addr1.name(), addr1 });
		fields.add(new Object[] { Field.addr2.name(), addr2 });
		fields.add(new Object[] { Field.addr3.name(), addr3 });
		fields.add(new Object[] { Field.addr4.name(), addr4 });
		fields.add(new Object[] { Field.addr5.name(), addr5 });
		fields.add(new Object[] { Field.postCode.name(), postCode });
	
		return fields;
	}

	public OutletKey getKey() {
		return key;
	}

	public void setKey(OutletKey key) {
		this.key = key;
	}

	OutletKey key;

	private String addr1;

	private String addr2;

	private String addr3;

	private String addr4;

	private String addr5;

	private String description;
	
	private String weekDayWorkingTime;
	private String saturdayWorkingTime;
	private String sundayWorkingTime;
	private String publicHolidayWorkingTime;
	

	private String name;
	private String logo;
	private String telPhone;
	private String faxNo;
	private String email;

	private String postCode;


//	private List<Product> products;

	public Outlet() {
		key = new OutletKey();
	}

	public String getAddr1() {
		return this.addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return this.addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getAddr3() {
		return this.addr3;
	}

	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}

	public String getAddr4() {
		return this.addr4;
	}

	public void setAddr4(String addr4) {
		this.addr4 = addr4;
	}

	public String getAddr5() {
		return this.addr5;
	}

	public void setAddr5(String addr5) {
		this.addr5 = addr5;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWeekDayWorkingTime() {
		return weekDayWorkingTime;
	}

	public void setWeekDayWorkingTime(String weekDayWorkingTime) {
		this.weekDayWorkingTime = weekDayWorkingTime;
	}

	public String getSaturdayWorkingTime() {
		return saturdayWorkingTime;
	}

	public void setSaturdayWorkingTime(String saturdayWorkingTime) {
		this.saturdayWorkingTime = saturdayWorkingTime;
	}

	public String getSundayWorkingTime() {
		return sundayWorkingTime;
	}

	public void setSundayWorkingTime(String sundayWorkingTime) {
		this.sundayWorkingTime = sundayWorkingTime;
	}

	public String getPublicHolidayWorkingTime() {
		return publicHolidayWorkingTime;
	}

	public void setPublicHolidayWorkingTime(String publicHolidayWorkingTime) {
		this.publicHolidayWorkingTime = publicHolidayWorkingTime;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@Override
	public String entityName() {

		return ENTITY_NAME;
	}

	@Override
	public void setKey(CommonPojoKey key) {
		Validate.notNull(key);
		this.key = (OutletKey) key;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void initialize(Object... objects) {

		int i = 0;

		this.name = (String) objects[i++];
		this.logo = (String) objects[i++];
		this.name = (String) objects[i++];
		this.telPhone = (String) objects[i++];
		this.faxNo = (String) objects[i++];
		this.email = (String) objects[i++];
		
		this.description = (String) objects[i++];
		this.addr1 = (String) objects[i++];
		this.addr2 = (String) objects[i++];
		this.addr3 = (String) objects[i++];
		this.addr4 = (String) objects[i++];
		this.addr5 = (String) objects[i++];
		this.postCode = (String) objects[i++];
		}



	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	public String getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}