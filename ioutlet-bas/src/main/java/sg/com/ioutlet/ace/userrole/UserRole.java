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

import sg.com.ioutlet.ace.role.Role;
import sg.com.ioutlet.ace.user.User;



public class UserRole
{

	private User userProfile;

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

	public User getUserProfile()
	{
		return userProfile;
	}

}
