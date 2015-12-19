package sg.com.ioutlet.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.commons.lang.Validate;

import sg.com.ioutlet.bas.CommonPojoKey;
import sg.com.ioutlet.model.bizinfo.BizInfo;
import sg.com.ioutlet.model.bizinfo.BizInfoKey;


public class BizInfoDao extends IoutletDao {

	public BizInfoDao(EntityManager entityManager) {
		super(entityManager);
	}


	public BizInfo get(BizInfoKey key) {
		return get((CommonPojoKey) key);
	}

	@Override
	public BizInfo get(CommonPojoKey key) {

		logger.trace("get");
		Validate.isTrue(key instanceof BizInfoKey,
				"'key' must be an instance of 'BizInfoKey'.", key);

		return get(BizInfo.class, key);

	}

	@Override
	public BizInfo getByKey(CommonPojoKey key) {

		logger.trace("get");
		Validate.isTrue(key instanceof BizInfoKey,
				"'key' must be an instance of 'BizInfoKey'.", key);

		return get(BizInfo.class, key);

	}

	public BizInfo getByUuid(String uuid) {
		logger.trace("getByUuid");
		Validate.notNull(uuid, "'userBizInfoName' must not be null.");
		BizInfoKey key = new BizInfoKey(uuid);
		return getByKey(key);

		
	}

	public BizInfo getByRoleUuid(String roleUuid) {
		logger.trace("getByRoleUuid");

		Validate.notNull(roleUuid);

		Map<String, Object> m = new HashMap<String, Object>();
		m.put("UUID", roleUuid);

		String queryName = "BizInfo.getByRoleUuid.String";
		return (BizInfo) getByQueryName(queryName, m);

	}

	public List<BizInfo> getAll() {
		logger.trace("getAll");

		return getAll(0, Integer.MAX_VALUE);

	}

	@SuppressWarnings("unchecked")
	public List<BizInfo> getAll(int startPosition, int maxResult) {
		logger.trace("getAll");

		String queryName = "BizInfo.getAll";
		if (isMultiResultLists(startPosition, maxResult)) {
			return (List<BizInfo>) getListByQueryName(queryName);
		} else {
			return (List<BizInfo>) getListByQueryName(queryName, startPosition,
					maxResult);
		}
	}


	public List<BizInfo> getAllBizInfosByRoleId(String roleId) {
		logger.trace("getAllBizInfosByRoleId");
		Validate.notNull(roleId);

		
		return getAllBizInfosByRoleId(roleId, 0, Integer.MAX_VALUE);

	}
	@SuppressWarnings("unchecked")
	public List<BizInfo> getAllBizInfosByRoleId(String roleId, int startPosition, int maxResult)
	{
		logger.trace("getAll");
		Validate.notNull(roleId);
	
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("ROLE_UUID", roleId);

		String queryName = "BizInfo.getByRoleUuid.String";
		if (isMultiResultLists(startPosition, maxResult)) {
			return (List<BizInfo>) getListByQueryName(queryName,m);
		} else {
			return (List<BizInfo>) getListByQueryName(queryName,m, startPosition,
					maxResult);
		}
		
	}


	public BizInfo getByUsrId(String userId) {
		logger.trace("getByUsrId");
		Validate.notNull(userId, "'userId' must not be null.");

		Map<String, Object> m = new HashMap<String, Object>();
		m.put("USER_ID", userId);
		
		
		String queryName = "BizInfo.getByUsrId.String";
		return (BizInfo) getByQueryName(queryName, m);
		}


}
