package sg.com.ioutlet.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang.Validate;
import sg.com.ioutlet.bas.CommonPojoKey;
import sg.com.ioutlet.model.product.Product;
import sg.com.ioutlet.model.product.option.ProductOption;
import sg.com.ioutlet.model.product.option.ProductOptionKey;

public class ProductOptionDao extends IoutletDao {

	public ProductOptionDao(EntityManager entityManager) 
	{
		super(entityManager);
	}

	@Override
	public ProductOption get(CommonPojoKey key)
	{
		logger.trace("get");
		Validate.isTrue(key instanceof ProductOptionKey,
				"'key' must be an instance of 'ProductOptionDao'.", key);

		return get(ProductOption.class, key);
	}

	public ProductOption get(ProductOptionKey key) 
	{
		return get((CommonPojoKey) key);
	}
	
	@Override
	public ProductOption getByKey(CommonPojoKey key) 
	{
		logger.trace("get");
		Validate.isTrue(key instanceof ProductOptionKey,
				"'key' must be an instance of 'ProductOptionKey'.", key);

		return get(ProductOption.class, key);
	}
	
	public ProductOption getByUuid(String uuid)
	{
		logger.trace("getByUuid");
		Validate.notNull(uuid, "'ProductOptionUUID' must not be null.");
		ProductOptionKey key = new ProductOptionKey(uuid);
		return getByKey(key);
	}
	
	public List<ProductOption> getAll()
	{
		logger.trace("getAll");
		return getAll(0, Integer.MAX_VALUE);

	}

	@SuppressWarnings("unchecked")
	public List<ProductOption> getAll(int startPosition, int maxResult) 
	{
		logger.trace("getAll");

		String queryName = "ProductOption.getAll";
		if (isMultiResultLists(startPosition, maxResult)) {
			return (List<ProductOption>) getListByQueryName(queryName);
		} else {
			return (List<ProductOption>) getListByQueryName(queryName, startPosition,
					maxResult);
		}
	}
	
}
