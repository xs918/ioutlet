
package sg.com.ioutlet.ace.functionaccess;

import sg.com.ioutlet.ace.function.Function;
import sg.com.ioutlet.ace.role.Role;


public class FunctionAccess
{
	private Function function;

	private Role role;

	public Function getFunction()
	{
		return function;
	}
	public String getFunctionId()
	{
		if(function != null)
			return function.getId();
		return null;
	}
	public void setFunction(Function function)
	{
		this.function = function;
	}

	public Role getRole()
	{
		return role;
	}

	public void setRole(Role role)
	{
		this.role = role;
	}

	public String getRecordReference()
	{
		return role.getName()+"."+function.getId();		
	}
}
