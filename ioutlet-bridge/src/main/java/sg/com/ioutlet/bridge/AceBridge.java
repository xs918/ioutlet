package sg.com.ioutlet.bridge;

import java.util.List;
import java.util.Map;

import sg.com.ioutlet.ace.function.Function;
import sg.com.ioutlet.ace.role.Role;
import sg.com.ioutlet.ace.user.User;
import sg.com.ioutlet.framework.authorization.model.AccessFunction;
import sg.com.ioutlet.framework.authorization.model.AuthorizationInfo;
import sg.com.ioutlet.framework.model.TransactionInfo;
import sg.com.ioutlet.vo.RoleVo;
import sg.com.ioutlet.vo.UserVo;


public interface AceBridge 
{
	/**************************getter*****************************/
	
	
	public boolean login(String userId, String password, String requestIp, String requestId, String functionId, String domainId, String sessionId);


	public List<Function> getFunctionsByUserProfile(
			String loginUserId, TransactionInfo transactionInfo);
	public User getUserProfileById(String userid,TransactionInfo ti);
	public List<Role> getAllRoles();
	public Role getRoleById(String id);
	public User getUserById(String id);
	public List<User> getAllUsers();
	public List<User> getAllUsersByRoleId(String roleId);
	
/**********************setter***********************/
	Role addRole(RoleVo roleVo);

	void deleteRole(String id);

	Role updateRole(RoleVo roleVo);
	
	User addUser(UserVo userVo);

	User updateUser(UserVo userVo);

	void deleteUser(String userId);


	public Map<String, AccessFunction> getFunctionAccess(String domainId);


	public AuthorizationInfo getAuthenticationInfo(String userId);


}
