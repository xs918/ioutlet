package sg.com.ioutlet.model.img;

import java.util.ArrayList;
import java.util.List;

import sg.com.ioutlet.ace.user.User;
import sg.com.ioutlet.bas.CommonPojo;
import sg.com.ioutlet.bas.CommonPojoKey;

public class Image extends CommonPojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ENTITY_NAME = "UserImage";
	private ImageKey key;
	private User user;
	private String imgName;
	private String fullPath;
	private String imgUrl;
	
	
	public Image()
	{
		key = new ImageKey();
	}
	@Override
	public String entityName() {
		return ENTITY_NAME;
	}

	@Override
	public ImageKey getKey() {

		return this.key;
	}

	@Override
	public void setKey(CommonPojoKey key) {
	   this.key  =  (ImageKey) key;

	}
	public enum Field {
		key, user, imgName(50), fullPath(255),imgUrl(510);
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
		fields.add(new Object[] { Field.key.name(), key });
		fields.add(new Object[] { Field.user.name(), user });
		fields.add(new Object[] { Field.imgName.name(), imgName });
		fields.add(new Object[] { Field.fullPath.name(), fullPath });
		fields.add(new Object[] { Field.imgUrl.name(), imgUrl });
		
		
		return fields;
	}



	@Override
	public void initialize(Object... objects) {
		int i = 0;
		this.user = (User) objects[i++];
		this.imgName = (String) objects[i++];
		this.fullPath = (String) objects[i++];
		this.imgUrl = (String) objects[i++];
	
		

	}


	public String getImageName() {
		return imgName;
	}

	public void setImageName(String imgName) {
		this.imgName = imgName;
	}

	public String getImageUrl() {
		return imgUrl;
	}

	public void setImageUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	public void setKey(ImageKey key) {
		this.key = key;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String getFullPath() {
		return fullPath;
	}
	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}



}
