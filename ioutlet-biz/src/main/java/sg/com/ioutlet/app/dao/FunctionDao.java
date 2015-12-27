package sg.com.ioutlet.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.commons.lang.Validate;

import sg.com.ioutlet.ace.function.Function;
import sg.com.ioutlet.ace.function.FunctionKey;
import sg.com.ioutlet.bas.CommonPojoKey;


public class FunctionDao extends IoutletDao {

	public FunctionDao(EntityManager entityManager) {
		super(entityManager);
	}


	public Function get(FunctionKey key) {
		return get((CommonPojoKey) key);
	}

	@Override
	public Function get(CommonPojoKey key) {

		logger.trace("get");
		Validate.isTrue(key instanceof FunctionKey,
				"'key' must be an instance of 'FunctionKey'.", key);

		return get(Function.class, key);

	}

	@Override
	public Function getByKey(CommonPojoKey key) {

		logger.trace("get");
		Validate.isTrue(key instanceof FunctionKey,
				"'key' must be an instance of 'FunctionKey'.", key);

		return get(Function.class, key);

	}

	public Function getByFunctionName(String userFunctionName) {
		logger.trace("getByFunctionName");
		Validate.notNull(userFunctionName, "'userFunctionName' must not be null.");

		Map<String, Object> m = new HashMap<String, Object>();
		m.put("ROLE_NAME", userFunctionName);

		String queryName = "Function.getByFunctionName.String";

		return (Function) getByQueryName(queryName, m);

	}

	public Function getByFunctionUuid(String uuid) {
		logger.trace("getByFunctionUuid");

		Validate.notNull(uuid);

		Map<String, Object> m = new HashMap<String, Object>();
		m.put("UUID", uuid);

		String queryName = "Function.getByFunctionUuid.String";
		return (Function) getByQueryName(queryName, m);

	}

	public List<Function> getAll() {
		logger.trace("getAll");

		return getAll(0, Integer.MAX_VALUE);

	}

	@SuppressWarnings("unchecked")
	public List<Function> getAll(int startPosition, int maxResult) {
		logger.trace("getAll");

		String queryName = "Function.getAll";
		if (isMultiResultLists(startPosition, maxResult)) {
			return (List<Function>) getListByQueryName(queryName);
		} else {
			return (List<Function>) getListByQueryName(queryName, startPosition,
					maxResult);
		}
	}
	public List<Function> getAllWithFunction() {
		logger.trace("getAll");

		return getAllWithFunction(0, Integer.MAX_VALUE);

	}
	
	@SuppressWarnings("unchecked")
	public List<Function> getAllWithFunction(int startPosition, int maxResult) {
		logger.trace("getAll");

		String queryName = "Function.getAllWithFunction";
		if (isMultiResultLists(startPosition, maxResult)) {
			return (List<Function>) getListByQueryName(queryName);
		} else {
			return (List<Function>) getListByQueryName(queryName, startPosition,
					maxResult);
		}
	}



}
