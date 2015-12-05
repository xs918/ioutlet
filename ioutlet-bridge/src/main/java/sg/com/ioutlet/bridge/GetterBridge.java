package sg.com.ioutlet.bridge;

import java.util.List;

import sg.com.ioutlet.model.outlet.Outlet;


public interface GetterBridge {

	public List<Outlet> getAllOutlets();
	public Outlet getOutletById(String outletId);


}
