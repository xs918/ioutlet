package sg.com.ioutlet.app.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.apache.commons.lang.Validate;
import sg.com.ioutlet.bas.CommonPojoKey;
import sg.com.ioutlet.model.product.tag.ProductTag;
import sg.com.ioutlet.model.product.tag.ProductTagKey;

public class ProductTagDao extends IoutletDao
{

	public ProductTagDao(EntityManager entityManager) {
		super(entityManager);
	}

	public ProductTag get(ProductTagKey key) 
	{
		return get((CommonPojoKey) key);
	}
	
	@Override
	public ProductTag get(CommonPojoKey key) 
	{
		logger.trace("get");
		Validate.isTrue(key instanceof ProductTagKey,
				"'key' must be an instance of 'ProductTagDao'.", key);

		return get(ProductTag.class, key);
	}
	
	@Override
	public ProductTag getByKey(CommonPojoKey key) 
	{
		logger.trace("get");
		Validate.isTrue(key instanceof ProductTagKey,
				"'key' must be an instance of 'ProductTagKey'.", key);

		return get(ProductTag.class, key);
	}
	
	public ProductTag getByUuid(String uuid)
	{
		logger.trace("getByUuid");
		Validate.notNull(uuid, "'ProductTagUUID' must not be null.");
		ProductTagKey key = new ProductTagKey(uuid);
		return getByKey(key);
	}
	
	public List<ProductTag> getAll() 
	{
		logger.trace("getAll");
		return getAll(0, Integer.MAX_VALUE);
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductTag> getAll(int startPosition, int maxResult) {
		logger.trace("getAll");

		String queryName = "ProductTag.getAll";
		if (isMultiResultLists(startPosition, maxResult)) {
			return (List<ProductTag>) getListByQueryName(queryName);
		} else {
			return (List<ProductTag>) getListByQueryName(queryName, startPosition,
					maxResult);
		}
	}

}
