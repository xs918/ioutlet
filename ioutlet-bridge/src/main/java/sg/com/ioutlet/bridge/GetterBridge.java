package sg.com.ioutlet.bridge;

import java.util.List;

import sg.com.ioutlet.model.Depart;
import sg.com.ioutlet.model.outlet.Outlet;
import sg.com.ioutlet.model.role.Role;
import sg.com.ioutlet.model.user.User;


public interface GetterBridge {

	public String getMemberData(long id);
	public String getDepartData(long id);
	public List<Depart> getAllDeparts();
	
	public List<Role> getAllRoles();
	public Role getRoleById(String id);
	
	
	public User getUserById(String id);
	public List<User> getAllUsers();
	public List<User> getAllUsersByRoleId(String roleId);
	
	
	
	public List<Outlet> getAllOutlets();
	public Outlet getOutletById(String outletId);


}
