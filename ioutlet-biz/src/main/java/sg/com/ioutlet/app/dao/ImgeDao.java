package sg.com.ioutlet.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.commons.lang.Validate;

import sg.com.ioutlet.bas.CommonPojoKey;
import sg.com.ioutlet.model.img.Imge;
import sg.com.ioutlet.model.img.ImgeKey;


public class ImgeDao extends IoutletDao {

	public ImgeDao(EntityManager entityManager) {
		super(entityManager);
	}


	public Imge get(ImgeKey key) {
		return get((CommonPojoKey) key);
	}

	@Override
	public Imge get(CommonPojoKey key) {

		logger.trace("get");
		Validate.isTrue(key instanceof ImgeKey,
				"'key' must be an instance of 'ImgeKey'.", key);

		return get(Imge.class, key);

	}

	@Override
	public Imge getByKey(CommonPojoKey key) {

		logger.trace("get");
		Validate.isTrue(key instanceof ImgeKey,
				"'key' must be an instance of 'ImgeKey'.", key);

		return get(Imge.class, key);

	}

	public Imge getByUuid(String uuid) {
		logger.trace("getByUuid");
		Validate.notNull(uuid, "'userImgeName' must not be null.");
		ImgeKey key = new ImgeKey(uuid);
		return getByKey(key);

		
	}

	public Imge getByRoleUuid(String roleUuid) {
		logger.trace("getByRoleUuid");

		Validate.notNull(roleUuid);

		Map<String, Object> m = new HashMap<String, Object>();
		m.put("UUID", roleUuid);

		String queryName = "Imge.getByRoleUuid.String";
		return (Imge) getByQueryName(queryName, m);

	}

	public List<Imge> getAll() {
		logger.trace("getAll");

		return getAll(0, Integer.MAX_VALUE);

	}

	@SuppressWarnings("unchecked")
	public List<Imge> getAll(int startPosition, int maxResult) {
		logger.trace("getAll");

		String queryName = "Imge.getAll";
		if (isMultiResultLists(startPosition, maxResult)) {
			return (List<Imge>) getListByQueryName(queryName);
		} else {
			return (List<Imge>) getListByQueryName(queryName, startPosition,
					maxResult);
		}
	}


	public List<Imge> getAllImgesByRoleId(String roleId) {
		logger.trace("getAllImgesByRoleId");
		Validate.notNull(roleId);

		
		return getAllImgesByRoleId(roleId, 0, Integer.MAX_VALUE);

	}
	@SuppressWarnings("unchecked")
	public List<Imge> getAllImgesByRoleId(String roleId, int startPosition, int maxResult)
	{
		logger.trace("getAll");
		Validate.notNull(roleId);
	
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("ROLE_UUID", roleId);

		String queryName = "Imge.getByRoleUuid.String";
		if (isMultiResultLists(startPosition, maxResult)) {
			return (List<Imge>) getListByQueryName(queryName,m);
		} else {
			return (List<Imge>) getListByQueryName(queryName,m, startPosition,
					maxResult);
		}
		
	}


	public Imge getByUsrId(String userId) {
		logger.trace("getByUsrId");
		Validate.notNull(userId, "'userId' must not be null.");

		Map<String, Object> m = new HashMap<String, Object>();
		m.put("USER_ID", userId);
		
		
		String queryName = "Imge.getByUsrId.String";
		return (Imge) getByQueryName(queryName, m);
		}


}
