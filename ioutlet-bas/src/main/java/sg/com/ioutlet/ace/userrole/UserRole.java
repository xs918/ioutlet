/**
 * Copyright (C) 2009 KPMG Business Advisory Singapore . All Rights Reserved. 
 * 
 * This software is the proprietary information of KPMG Business Advisory Singapore. 
 * Use is subjected to license terms. 
 *
 * @since 27/02/2009 11:56:48 AM
 * @author asanusi
 * @ace-base
 *
 * Version Control Info
 *
 * $Id$
 * $Revision$
 * $Date$
 */
package sg.com.ioutlet.ace.userrole;

import java.util.ArrayList;
import java.util.List;

import sg.com.ioutlet.ace.role.Role;
import sg.com.ioutlet.ace.user.User;
import sg.com.ioutlet.bas.CommonPojo;
import sg.com.ioutlet.bas.CommonPojoKey;



public class UserRole extends CommonPojo {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String ENTITY_NAME = "UserRole";

	private UserRoleKey key;

	private User user;

	private Role role;
	
	public Role getRole()
	{
		return role;
	}
	public String getRoleName()
	{
		if(role != null)
			return role.getName();
		return null;
	}
	public void setRole(Role role)
	{
		this.role = role;
	}


	@Override
	public String entityName() {
	
		return ENTITY_NAME;
	}
	@Override
	public CommonPojoKey getKey() {
	 return this.key;
	}
	@Override
	public void setKey(CommonPojoKey key) {
		this.key  = (UserRoleKey) key;
		
	}
	
	
	public enum Field {
		user,role;
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
		fields.add(new Object[] { Field.user.name(), user });
		fields.add(new Object[] { Field.role.name(), role });
		
		return fields;
	}
	@Override
	public void initialize(Object... objects) {
	
		
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
