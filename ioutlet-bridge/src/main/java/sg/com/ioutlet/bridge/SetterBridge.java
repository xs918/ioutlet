package sg.com.ioutlet.bridge;

import sg.com.ioutlet.model.outlet.Outlet;
import sg.com.ioutlet.vo.OutletVo;

public interface SetterBridge {

	Outlet addOutlet(OutletVo userVo);

	Outlet updateOutlet(OutletVo outletVo);

	void deleteOutlet(String outletId);

	

}
