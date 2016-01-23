package sg.com.ioutlet.model.image;

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
	private String imageName;
	private String fullPath;
	private String imageUrl;
	
	
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
		key, user, imageName(50), fullPath(255),imageUrl(510);
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
		fields.add(new Object[] { Field.imageName.name(), imageName });
		fields.add(new Object[] { Field.fullPath.name(), fullPath });
		fields.add(new Object[] { Field.imageUrl.name(), imageUrl });
		
		
		return fields;
	}



	@Override
	public void initialize(Object... objects) {
		int i = 0;
		this.user = (User) objects[i++];
		this.imageName = (String) objects[i++];
		this.fullPath = (String) objects[i++];
		this.imageUrl = (String) objects[i++];
	
		

	}


	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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
