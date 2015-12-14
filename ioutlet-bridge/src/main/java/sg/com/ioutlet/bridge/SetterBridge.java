package sg.com.ioutlet.bridge;

import java.util.List;

import sg.com.ioutlet.ace.user.User;
import sg.com.ioutlet.model.img.Imge;
import sg.com.ioutlet.model.outlet.Outlet;
import sg.com.ioutlet.vo.OutletVo;

public interface SetterBridge {

	Outlet addOutlet(OutletVo userVo);

	Outlet updateOutlet(OutletVo outletVo);

	void deleteOutlet(String outletId);

	boolean registeUserProfile(User regUser, List<Imge> usrImgs);


}
