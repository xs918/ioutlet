package sg.com.ioutlet.ejb.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import sg.com.ioutlet.ace.domain.Domain;
import sg.com.ioutlet.ace.function.Function;
import sg.com.ioutlet.ace.functionaccess.FunctionAccess;
import sg.com.ioutlet.ace.password.PasswordUtil;
import sg.com.ioutlet.ace.role.Role;
import sg.com.ioutlet.ace.role.RoleKey;
import sg.com.ioutlet.ace.user.User;
import sg.com.ioutlet.ace.user.UserKey;
import sg.com.ioutlet.app.dao.BizInfoDao;
import sg.com.ioutlet.app.dao.ImgeDao;
import sg.com.ioutlet.app.dao.PojoUtils;
import sg.com.ioutlet.app.dao.RoleDao;
import sg.com.ioutlet.app.dao.UserDao;
import sg.com.ioutlet.bridge.AceBridge;
import sg.com.ioutlet.common.logging.LogHelper;
import sg.com.ioutlet.framework.authorization.model.AccessFunction;
import sg.com.ioutlet.framework.authorization.model.AuthorizationInfo;
import sg.com.ioutlet.framework.authorization.model.IoltFunction;
import sg.com.ioutlet.framework.model.TransactionInfo;
import sg.com.ioutlet.framework.trxhelper.TransactionControl;
import sg.com.ioutlet.model.img.Imge;
import sg.com.ioutlet.vo.RoleVo;
import sg.com.ioutlet.vo.UserVo;
@Stateless
@Remote(AceBridge.class)
public class AceBean extends EjbEntityManager implements AceBridge  {
	protected LogHelper logger = LogHelper.getInstance(AceBean.class.getName());

	/*******************************getter******************************/
	/*----------role start---------------*/
	@Override
	public Role getRoleById(String id) {
		RoleDao dao = new RoleDao(em);
		RoleKey key = new RoleKey(id);
		return dao.getByKey(key);
		
	}
	@Override
	public List<Role> getAllRoles() {
		RoleDao dao = new RoleDao(em);
		return dao.getAll();

	}
	@Override
	public Map<Role,List<FunctionAccess>> getAllRolesWithFunction()
	{
		RoleDao dao = new RoleDao(em);
		Map<Role,List<FunctionAccess>> functionMap = new HashMap<Role,List<FunctionAccess>> ();
		List<Role> roles =dao.getAllWithFunction();
		for(Role r:roles)
		{
			 functionMap.put(r, r.getAccessFunctions());
		}
		return functionMap;
	}
	
	
	/*----------role end---------------*/
	
	
	/*----------User start---------------*/
	@Override
	public User getUserById(String userId) {
		UserDao dao = new UserDao(em);
		return dao.getByUsrId(userId);
		
	}
	@Override
	public List<User> getAllUsers() {
		UserDao dao = new UserDao(em);
		return dao.getAll();

	}
	
	@Override
	public List<User> getAllUsersByRoleId(String roleId) {
		UserDao dao = new UserDao(em);
		return dao.getAllUsersByRoleId(roleId);
	}

	
	/**********************************setter*************************************/
	
	@Override
	public boolean registeUserProfile(User regUser, List<Imge> usrImgs,TransactionInfo ti) {
		UserDao uDao =  new UserDao(this.getEntityManager());
		this.setTrxInfo(ti);
		uDao.create(regUser);
		if(usrImgs!=null)
		{
			ImgeDao iDao =  new ImgeDao(this.getEntityManager());
			for(Imge i:usrImgs)
			{
				i.setUser(regUser);
				iDao.create(i);
			}
		}

		if(regUser.getBizinfo()!=null)
		{
			BizInfoDao bDao =  new BizInfoDao(this.getEntityManager());
			
			bDao.create(regUser.getBizinfo());
		}
		return true;
	}

	
	
	@Override
	public Role addRole(RoleVo roleVo,TransactionInfo ti) {
		this.setTrxInfo(ti);
		RoleDao dao = new RoleDao(this.getEntityManager());

		Role existRole = dao.getByRoleName(roleVo.getName());
		if (null != existRole) {
			return null;
		}

		Role role = new Role();
		PojoUtils.updateRoleFromVo(role, roleVo);
		return (Role) dao.create(role);

	}

	@Override
	public void deleteRole(String id) {
		RoleDao dao = new RoleDao(this.getEntityManager());
		Role role = dao.get(new RoleKey(id));
		if (null == role) {
			return;
		}
		dao.delete(role);

	}

	@Override
	public Role updateRole(RoleVo roleVo,TransactionInfo ti) {
		this.setTrxInfo(ti);
		RoleDao dao = new RoleDao(this.getEntityManager());
		Role role = dao.get(new RoleKey(roleVo.getId()));
		if (null == role) {
			return null;
		}

		PojoUtils.updateRoleFromVo(role, roleVo);
		return (Role) dao.update(role);

	}

	@Override
	public User addUser(UserVo userVo,TransactionInfo ti) {
		this.setTrxInfo(ti);
		UserDao dao = new UserDao(this.getEntityManager());

		User newUsr = new User();
		PojoUtils.updateUserFromVo(newUsr, userVo);
		return (User) dao.create(newUsr);

	}
	
	@Override
	public User updateUser(UserVo userVo,TransactionInfo ti) {
		this.setTrxInfo(ti);
		UserDao dao = new UserDao(this.getEntityManager());
        User updateUsr = dao.getByUuid(userVo.getId());
        if(null == updateUsr)
        {
        	return null;
        }
        
		PojoUtils.updateUserFromVo(updateUsr, userVo);
		return (User) dao.update(updateUsr);

	}

	@Override
	public void deleteUser(String userId) {
		UserDao dao = new UserDao(this.getEntityManager());
	    User usr =  dao.getByKey(new UserKey(userId));
	    if(null == usr)
	    {
	    	return;
	    }
	    
	    dao.delete(usr);
	    
	    
      
		
	}


	@Override
	public  User getUserProfileById(String userid,
			TransactionInfo ti) {
			return null;
	}
	@Override
	public boolean login(String userId, String inPassword, 
			String requestIp, String requestId, String functionId,
			String domainId, String sessionId) {
	
		logger.debug("LOGIN IS CALLED");
		
		TransactionInfo ti = TransactionControl.getTransactionInfo();
		ti.setRequestIp(requestIp);
		ti.setRequestUser(userId);
		ti.setRequestLocale(Locale.getDefault());
		ti.setRequestId(requestId);
		ti.setFunctionId(functionId);
		ti.setDomainId(domainId);
		ti.setFormLoadingDate(new Date());
        UserDao dao = new UserDao(em);
        User uspf =  dao.getByUsrId(userId);
        if (uspf == null)
		{
			return false;
		}

        try
		{
        	

			if (uspf.isLocked())
			{
				return false;
				
			}
		
			
			
			if (PasswordUtil.isPasswordMatched(inPassword, uspf.getStoredPassword()))
			{
				
				
				// LOGIN SUCCESS

				uspf.setLastLoginTime(TransactionControl.getTransactionInfo().getTransactionStartDate());
				uspf.setLoginFailureAttempt(0);
				dao.update(uspf);
				logger.info("Login Successful:" + userId);
				return true;
			}
			else
			{
				// LOGIN FAIL
				if (logger.isDebugEnabled())
				{
					logger.debug("Login Fail: Invalid Credential | " + userId);
				}
				int failCounts = uspf.getMaxFailCount();
				failCounts++;
				uspf.setLoginFailureAttempt(failCounts);	
				if (failCounts >= uspf.getMaxFailCount())
				{
					// LOCK ACCOUNT
					uspf.setLocked(true);
					uspf.setLastLockedTime(TransactionControl.getTransactionInfo().getTransactionStartDate());
				}					
				dao.update(uspf);
				return false;
			}
			
		}
        catch (Exception e)
		{
			if(logger.isDebugEnabled())
				logger.debug("Exception when checking password: | " + userId);
			return false;
		}
        
			
		
		
	}

//	@Override
//	public List<Function> getFunctionsByUserProfile(String loginUserId,
//			TransactionInfo transactionInfo) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	public Map<String, AccessFunction> getFunctionAccess(String domainId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	@Override
	public AuthorizationInfo getAuthenticationInfo(String userId) {
		AuthorizationInfo auth = new AuthorizationInfo();
		UserDao dao = new UserDao(this.getEntityManager());
		User loginUser=dao.getByUsrId(userId);
		auth.setUser(loginUser);
		Role role = loginUser.getRole();
		
		Map<String,Map<IoltFunction, FunctionAccess>> domainAceFunMap = new HashMap<String,Map<IoltFunction, FunctionAccess>>();
		
		Map<IoltFunction, FunctionAccess> functionMap = new HashMap<IoltFunction, FunctionAccess> ();
		
		for(FunctionAccess fac:role.getAccessFunctions())
		{
			Domain domain = fac.getFunction().getDomain();
			IoltFunction ioltf=	fac.getFunctionId();
			System.out.println("**domain:"+domain.getId()+ " getFunctionId:"+fac.getFunctionId() + " ioltf: "+ioltf.toString());
			
			functionMap.put(fac.getFunctionId(), fac);
			domainAceFunMap.put(domain.getId(), functionMap);
		}
		auth.setAccessibleFunctions(domainAceFunMap);
			
		return auth;
	}



}
