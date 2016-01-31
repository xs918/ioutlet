package sg.com.ioutlet.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

public class ProductDao extends IoutletDao {
	
	public ProductDao(EntityManager entityManager) {
		super(entityManager);
	}
	
	public ProductDao get(ProductKey key) {
		return get((CommonPojoKey) key);
	}
	
	@Override
	public Product get(CommonPojoKey key) {

		logger.trace("get");
		Validate.isTrue(key instanceof ProductDao,
				"'key' must be an instance of 'ProductDao'.", key);

		return get(Product.class, key);

	}
	
	@Override
	public Product getByKey(CommonPojoKey key) {

		logger.trace("get");
		Validate.isTrue(key instanceof ProductKey,
				"'key' must be an instance of 'ProductKey'.", key);

		return get(Product.class, key);

	}
	
	public Product getByUuid(String uuid) {
		logger.trace("getByUuid");
		Validate.notNull(uuid, "'ProductUUID' must not be null.");
		ProductKey key = new ProductKey(uuid);
		return getByKey(key);

		
	}
	
	public List<Product> getAll() {
		logger.trace("getAll");

		return getAll(0, Integer.MAX_VALUE);

	}

	@SuppressWarnings("unchecked")
	public List<Product> getAll(int startPosition, int maxResult) {
		logger.trace("getAll");

		String queryName = "Product.getAll";
		if (isMultiResultLists(startPosition, maxResult)) {
			return (List<Product>) getListByQueryName(queryName);
		} else {
			return (List<Product>) getListByQueryName(queryName, startPosition,
					maxResult);
		}
	}
	
}
