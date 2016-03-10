package sg.com.ioutlet.ejb.bean;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import sg.com.ioutlet.app.dao.CategoryDao;
import sg.com.ioutlet.app.dao.OutletDao;
import sg.com.ioutlet.app.dao.ProductDao;
import sg.com.ioutlet.bridge.GetterBridge;
import sg.com.ioutlet.model.category.Category;
import sg.com.ioutlet.model.category.CategoryKey;
import sg.com.ioutlet.model.outlet.Outlet;
import sg.com.ioutlet.model.outlet.OutletKey;
import sg.com.ioutlet.model.product.Product;
import sg.com.ioutlet.model.product.ProductKey;

@Stateless
@Remote(GetterBridge.class)
public class IoutletGetter extends EjbEntityManager implements GetterBridge {





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
	
	/*------------Product start-----------*/
	@Override
	public List<Product> getAllProducts()
	{
		ProductDao dao =new ProductDao(em);
		return dao.getAll();
	}
	
	@Override
	public Product getProductById(String productId) {
		
		ProductDao dao =new ProductDao(em);
		return dao.getByKey( new ProductKey(productId));	
	}
	
	/*------------Product end-------------*/
	
	/*----------Category Start------------*/
	@Override
	public List<Category> getAllCategories()
	{
		CategoryDao dao =new CategoryDao(em);
		return dao.getAll();
	}
	
	@Override
	public Category getCategoryById(String CategoryId) {
		
		CategoryDao dao =new CategoryDao(em);
		return dao.getByKey( new CategoryKey(CategoryId));	
	}
	
	/*----------Category End------------*/
	
}
