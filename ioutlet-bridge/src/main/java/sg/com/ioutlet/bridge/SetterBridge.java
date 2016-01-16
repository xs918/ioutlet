package sg.com.ioutlet.bridge;

import sg.com.ioutlet.framework.model.TransactionInfo;
import sg.com.ioutlet.model.outlet.Outlet;
import sg.com.ioutlet.vo.OutletVo;

public interface SetterBridge {

	Outlet addOutlet(OutletVo userVo,TransactionInfo ti);

	Outlet updateOutlet(OutletVo outletVo,TransactionInfo ti);

	void deleteOutlet(String outletId);

	

}
