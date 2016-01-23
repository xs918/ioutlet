package sg.com.ioutlet.bridge;

import java.util.List;

import sg.com.ioutlet.model.outlet.Outlet;
import sg.com.ioutlet.model.product.Product;


public interface GetterBridge {

	public List<Outlet> getAllOutlets();
	public List<Product> getAllProducts();
	public Outlet getOutletById(String outletId);
	public Product getProductById(String productId);

}
