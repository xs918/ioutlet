package sg.com.ioutlet.web.app.product.handler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import com.opensymphony.xwork2.ActionSupport;

import sg.com.ioutlet.model.category.Category;
import sg.com.ioutlet.model.product.Product;
import sg.com.ioutlet.web.app.product.form.ProductForm;
import sg.com.ioutlet.web.common.handler.IoutletActionHandler;

public class ProductActionHandler extends IoutletActionHandler {

	public ProductActionHandler(ActionSupport action) {
		super(action);

	}

	public void getProducts(String string) {

	}

	public List<Product> getAllProducts() {
		return simulateData();
	}

	public List<Product> simulateData() {
		List<Product> firstProducts = new ArrayList<Product>();
		for(int i =0;i<=50;i++)
		{
			Product p = new Product();
		
			p.setId(RandomStringUtils.randomAlphanumeric(20));
			p.setName(RandomStringUtils.randomAlphabetic(20));
			p.setBalance( 100+i *i);
			p.setUnitPrice( new BigDecimal(2*i+1.2));
			firstProducts.add(p);
		}

		
		
	
		return firstProducts;

	}

	public List<Product> intialProductDetail(ProductForm form) {
		Category c1 = new Category();
		Category c2 = new Category();
		c1.setName("fashion");
		c2.setName("food");
		List<Category> clist = new ArrayList<Category> ();
		clist.add(c1);
		clist.add(c2);
		form.setCatlist(clist);
		
		return null;
	}

}
