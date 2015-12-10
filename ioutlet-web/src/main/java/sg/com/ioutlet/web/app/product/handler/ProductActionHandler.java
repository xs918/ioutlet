package sg.com.ioutlet.web.app.product.handler;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import sg.com.ioutlet.model.product.Product;
import sg.com.ioutlet.web.common.handler.IoutletActionHandler;

public class ProductActionHandler extends  IoutletActionHandler{



	public ProductActionHandler(ActionSupport action) {
		super(action);
	
	}

	public void getProducts(String string) {
		
	}
	
	public List<Product> getAllProducts(){
		return simulateData();
	}
	
	public List<Product> simulateData(){
		List<Product> firstProducts=new ArrayList<Product>();
		
		Product p1 = new Product();
		p1.setId("1");
		p1.setDescription("1description");
		
		Product p2=new Product();
		p2.setId("2");
		p2.setDescription("2description");
		
		Product p3=new Product();
		p3.setId("3");
		p3.setDescription("3description");
		
		Product p4=new Product();
		p4.setId("4");
		p4.setDescription("4description");
		
		firstProducts.add(p1);
		firstProducts.add(p2);
		firstProducts.add(p3);
		firstProducts.add(p4);
		
		return firstProducts;
		
	}

}
