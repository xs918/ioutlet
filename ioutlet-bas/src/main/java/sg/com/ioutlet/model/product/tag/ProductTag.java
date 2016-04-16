package sg.com.ioutlet.model.product.tag;

import java.util.ArrayList;
import java.util.List;

import sg.com.ioutlet.bas.CommonPojo;
import sg.com.ioutlet.bas.CommonPojoKey;
import sg.com.ioutlet.model.outlet.Outlet;
import sg.com.ioutlet.model.product.Product;

public class ProductTag extends CommonPojo {

	private static final long serialVersionUID = 1L;
	public static final String ENTITY_NAME = "ProductTag";

	private ProductTagKey key;
	private String productTagName;
	private String prodectDesc;
	//relationships with other tables
	private Product product;
	private Outlet outlet;
	
	
	public enum Field
	{
		 key,productTagName,prodectDesc,product,outlet;
        
		 public int length = 255;
		 public int precision;
		 public int scale;
		private Field()
		{
		
		}
		
		private Field(int length)
		{
			this.length = length;
		}
		
		private Field(int precision, int scale)
		{
			this.precision = precision;
			this.scale = scale;
		}
	}

	@Override
	public String entityName() 
	{
		return ENTITY_NAME;
	}

	@Override
	public CommonPojoKey getKey()
	{
		return key;
	}

	@Override
	public void setKey(CommonPojoKey key) 
	{
		setKey((ProductTagKey)key);
	}

	@Override
	public List<Object[]> getFields() 
	{

		List<Object[]> fields = new ArrayList<Object[]>();
		fields.add(new Object[]{Field.productTagName.name(), productTagName});
		fields.add(new Object[]{Field.prodectDesc.name(), prodectDesc});
		fields.add(new Object[]{Field.outlet.name(), outlet});
		fields.add(new Object[]{Field.product.name(), product});
		
		return fields;
	}

	@Override
	public void initialize(Object... objects) 
	{
		   int i = 0;
			
	       this.productTagName =  (String) objects[i++];
	       this.prodectDesc = (String) objects[i++];
	       this.outlet = (Outlet) objects[i++];
		   this.product = (Product) objects[i++];
	}
	
	// constructor and getter,setter methods
	public ProductTag() 
	{
		super();
		key=new ProductTagKey();
	}
	
	public ProductTag(ProductTagKey key)
	{
		super();
		this.key = key;
	}

	public Product getProduct()
	{
		return product;
	}

	public void setProduct(Product product) 
	{
		this.product = product;
	}

	public Outlet getOutlet() 
	{
		return outlet;
	}

	public void setOutlet(Outlet outlet) 
	{
		this.outlet = outlet;
	}

	public String getProductTagName() 
	{
		return productTagName;
	}

	public void setProductTagName(String productTagName) 
	{
		this.productTagName = productTagName;
	}

	public String getProdectDesc() 
	{
		return prodectDesc;
	}

	public void setProdectDesc(String prodectDesc) 
	{
		this.prodectDesc = prodectDesc;
	}

}
