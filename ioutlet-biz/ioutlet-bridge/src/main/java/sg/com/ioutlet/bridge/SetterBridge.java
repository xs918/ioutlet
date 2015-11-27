package sg.com.ioutlet.bridge;

import sg.com.ioutlet.model.outlet.Outlet;
import sg.com.ioutlet.model.role.Role;
import sg.com.ioutlet.model.user.User;
import sg.com.ioutlet.vo.OutletVo;
import sg.com.ioutlet.vo.RoleVo;
import sg.com.ioutlet.vo.UserVo;

public interface SetterBridge {

	Role addRole(RoleVo roleVo);

	void deleteRole(String id);

	Role updateRole(RoleVo roleVo);
	
	User addUser(UserVo userVo);

	User updateUser(UserVo userVo);

	void deleteUser(String userId);

	Outlet addOutlet(OutletVo userVo);

	Outlet updateOutlet(OutletVo outletVo);

	void deleteOutlet(String outletId);


}
