package sg.com.ioutlet.ejb.bean;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import sg.com.ioutlet.app.dao.OutletDao;
import sg.com.ioutlet.app.dao.PojoUtils;
import sg.com.ioutlet.app.dao.RoleDao;
import sg.com.ioutlet.app.dao.UserDao;
import sg.com.ioutlet.bridge.SetterBridge;
import sg.com.ioutlet.model.outlet.Outlet;
import sg.com.ioutlet.model.outlet.OutletKey;
import sg.com.ioutlet.model.role.Role;
import sg.com.ioutlet.model.role.RoleKey;
import sg.com.ioutlet.model.user.User;
import sg.com.ioutlet.model.user.UserKey;
import sg.com.ioutlet.vo.OutletVo;
import sg.com.ioutlet.vo.RoleVo;
import sg.com.ioutlet.vo.UserVo;

@Stateless
@Remote(SetterBridge.class)
public class IoutletSetter extends EjbEntityManager implements SetterBridge {

	@Override
	public Role addRole(RoleVo roleVo) {
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
	public Role updateRole(RoleVo roleVo) {
		RoleDao dao = new RoleDao(this.getEntityManager());
		Role role = dao.get(new RoleKey(roleVo.getId()));
		if (null == role) {
			return null;
		}

		PojoUtils.updateRoleFromVo(role, roleVo);
		return (Role) dao.update(role);

	}

	@Override
	public User addUser(UserVo userVo) {
		UserDao dao = new UserDao(this.getEntityManager());

		User newUsr = new User();
		PojoUtils.updateUserFromVo(newUsr, userVo);
		return (User) dao.create(newUsr);

	}
	
	@Override
	public User updateUser(UserVo userVo) {
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
	public Outlet addOutlet(OutletVo outletVo) {
		OutletDao dao = new OutletDao(this.getEntityManager());

		Outlet newOut = new Outlet();
		PojoUtils.updateOutletFromVo(newOut, outletVo);
		return (Outlet) dao.create(newOut);
		
	

	}

	@Override
	public Outlet updateOutlet(OutletVo outletVo) {
		OutletDao dao = new OutletDao(this.getEntityManager());
		Outlet updateOutlet = dao.getByOutletUuid(outletVo.getId());
        if(null == updateOutlet)
        {
        	return null;
        }
        
		PojoUtils.updateOutletFromVo(updateOutlet, outletVo);
		return (Outlet) dao.update(updateOutlet);
	}

	@Override
	public void deleteOutlet(String outletId) {
		OutletDao dao = new OutletDao(this.getEntityManager());
		Outlet outlet =  dao.getByKey(new OutletKey(outletId));
	    if(null == outlet)
	    {
	    	return;
	    }
	    
	    dao.delete(outlet);
	    
		
	}

	

}
