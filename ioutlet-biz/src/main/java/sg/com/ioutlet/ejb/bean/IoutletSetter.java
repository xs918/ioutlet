package sg.com.ioutlet.ejb.bean;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import sg.com.ioutlet.ace.user.User;
import sg.com.ioutlet.app.dao.ImgeDao;
import sg.com.ioutlet.app.dao.OutletDao;
import sg.com.ioutlet.app.dao.PojoUtils;
import sg.com.ioutlet.app.dao.UserDao;
import sg.com.ioutlet.bridge.SetterBridge;
import sg.com.ioutlet.model.img.Imge;
import sg.com.ioutlet.model.outlet.Outlet;
import sg.com.ioutlet.model.outlet.OutletKey;
import sg.com.ioutlet.vo.OutletVo;

@Stateless
@Remote(SetterBridge.class)
public class IoutletSetter extends EjbEntityManager implements SetterBridge {

	

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

	@Override
	public boolean registeUserProfile(User regUser, List<Imge> usrImgs) {
		UserDao uDao =  new UserDao(this.getEntityManager());
		ImgeDao iDao =  new ImgeDao(this.getEntityManager());
		uDao.create(regUser);
		for(Imge i:usrImgs)
		{
			i.setUser(regUser);
			iDao.create(i);
		}

		
		return true;
	}

	

}
