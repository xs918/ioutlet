package sg.com.ioutlet.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang.Validate;

import sg.com.ioutlet.bas.CommonPojoKey;
import sg.com.ioutlet.model.category.Category;
import sg.com.ioutlet.model.category.CategoryKey;

public class CategoryDao extends IoutletDao {
	
	public CategoryDao(EntityManager entityManager) {
		super(entityManager);
	}
	
	public Category get(CategoryKey key) {
		return get((CommonPojoKey) key);
	}
	
	@Override
	public Category get(CommonPojoKey key) {

		logger.trace("get");
		Validate.isTrue(key instanceof CategoryKey,
				"'key' must be an instance of 'CategoryKey'.", key);

		return get(Category.class, key);

	}
	
	@Override
	public Category getByKey(CommonPojoKey key) {

		logger.trace("get");
		Validate.isTrue(key instanceof CategoryKey,
				"'key' must be an instance of 'CategoryKey'.", key);

		return get(Category.class, key);

	}
	
	public Category getByUuid(String uuid) {
		logger.trace("getByUuid");
		Validate.notNull(uuid, "'Category' must not be null.");
		CategoryKey key = new CategoryKey(uuid);
		return getByKey(key);

		
	}
	
	public List<Category> getAll() {
		logger.trace("getAll");

		return getAll(0, Integer.MAX_VALUE);

	}

	@SuppressWarnings("unchecked")
	public List<Category> getAll(int startPosition, int maxResult) {
		logger.trace("getAll");

		String queryName = "Category.getAll";
		if (isMultiResultLists(startPosition, maxResult)) {
			return (List<Category>) getListByQueryName(queryName);
		} else {
			return (List<Category>) getListByQueryName(queryName, startPosition,
					maxResult);
		}
	}

	
	
	
}
