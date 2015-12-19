package sg.com.ioutlet.model.bizinfo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.Validate;

import sg.com.ioutlet.bas.CommonPojo;
import sg.com.ioutlet.bas.CommonPojoKey;

public class BizInfo extends CommonPojo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ENTITY_NAME = "BizInfo";

	public BizInfo(BizInfoKey key) {
		this.key = key;
	}

	public enum Field {
		key, id(50),name(150), telPhone(50), addr1(
				200), addr2(200), addr3(200), postCode(
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
		fields.add(new Object[] { Field.telPhone.name(), telPhone });
			
			fields.add(new Object[] { Field.addr1.name(), addr1 });
		fields.add(new Object[] { Field.addr2.name(), addr2 });
		fields.add(new Object[] { Field.addr3.name(), addr3 });
		fields.add(new Object[] { Field.postCode.name(), postCode });
	
		return fields;
	}

	public BizInfoKey getKey() {
		return key;
	}

	public void setKey(BizInfoKey key) {
		this.key = key;
	}

	BizInfoKey key;

	private String addr1;

	private String addr2;

	private String addr3;


	private String name;
	private String telPhone;

	private String postCode;


//	private List<Product> products;

	public BizInfo() {
		key = new BizInfoKey();
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
		this.key = (BizInfoKey) key;

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
		this.name = (String) objects[i++];
		this.telPhone = (String) objects[i++];
		
		this.addr1 = (String) objects[i++];
		this.addr2 = (String) objects[i++];
		this.addr3 = (String) objects[i++];
		this.postCode = (String) objects[i++];
		}





	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}



}