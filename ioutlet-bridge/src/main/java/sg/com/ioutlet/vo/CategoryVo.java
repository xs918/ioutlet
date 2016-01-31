package sg.com.ioutlet.vo;

import java.util.List;

import sg.com.ioutlet.model.category.Category;
import sg.com.ioutlet.model.category.attribute.CategoryAttribute;
import sg.com.ioutlet.model.product.Product;

public class CategoryVo {
	
	private String id;
	 
	private Category  parent;
	
	private String description;

    private String name;
	
    private List<CategoryAttribute > attributes;
    
    private List<Product> products;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CategoryAttribute > getAttributes() {
		return attributes;
	}

	public void setAttributes(List<CategoryAttribute > attributes) {
		this.attributes = attributes;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
