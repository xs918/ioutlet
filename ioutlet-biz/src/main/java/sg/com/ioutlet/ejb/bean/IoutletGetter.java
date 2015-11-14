package sg.com.ioutlet.ejb.bean;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import sg.com.ioutlet.app.dao.OutletDao;
import sg.com.ioutlet.app.dao.RoleDao;
import sg.com.ioutlet.app.dao.UserDao;
import sg.com.ioutlet.bridge.GetterBridge;
import sg.com.ioutlet.model.Depart;
import sg.com.ioutlet.model.Member;
import sg.com.ioutlet.model.outlet.Outlet;
import sg.com.ioutlet.model.outlet.OutletKey;
import sg.com.ioutlet.model.role.Role;
import sg.com.ioutlet.model.role.RoleKey;
import sg.com.ioutlet.model.user.User;
import sg.com.ioutlet.model.user.UserKey;

@Stateless
@Remote(GetterBridge.class)
public class IoutletGetter extends EjbEntityManager implements GetterBridge {

	@Override
	public String getMemberData(long id) {

		Member m = em.find(Member.class, id);
		return "m name:" + m.getName();
	}

	@Override
	public String getDepartData(long id) {
		Depart d;
		String ret = "is null";
		d = em.find(Depart.class, id);
		if (d != null)
			ret = d.getName();

		return "test**:" + ret;
	}


	@Override
	public List<Depart> getAllDeparts() {

		List<Depart> departs = em.createQuery("SELECT e FROM Depart e")
				.getResultList();
		return departs;

	}
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
	/*----------role end---------------*/
	
	
	/*----------User start---------------*/
	@Override
	public User getUserById(String id) {
		UserDao dao = new UserDao(em);
		UserKey key = new UserKey(id);
		return dao.getByKey(key);
		
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


	/*----------User end---------------*/
	
	
	/*----------outlet start---------------*/
	@Override
	public List<Outlet> getAllOutlets() {
		
		OutletDao dao = new OutletDao(em);
		return dao.getAll();
		
		
	
	}

	@Override
	public Outlet getOutletById(String outletId) {
		
		OutletDao dao = new OutletDao(em);
		return dao.getByKey( new OutletKey(outletId));
		
		
	}
	


	/*----------outlet end---------------*/
	
}
