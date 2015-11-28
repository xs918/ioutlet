package sg.com.ioutlet.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.commons.lang.Validate;

import sg.com.ioutlet.bas.CommonPojoKey;
import sg.com.ioutlet.model.user.User;
import sg.com.ioutlet.model.user.UserKey;

public class UserDao extends IoutletDao {

	public UserDao(EntityManager entityManager) {
		super(entityManager);
	}


	public User get(UserKey key) {
		return get((CommonPojoKey) key);
	}

	@Override
	public User get(CommonPojoKey key) {

		logger.trace("get");
		Validate.isTrue(key instanceof UserKey,
				"'key' must be an instance of 'UserKey'.", key);

		return get(User.class, key);

	}

	@Override
	public User getByKey(CommonPojoKey key) {

		logger.trace("get");
		Validate.isTrue(key instanceof UserKey,
				"'key' must be an instance of 'UserKey'.", key);

		return get(User.class, key);

	}

	public User getByUuid(String uuid) {
		logger.trace("getByUuid");
		Validate.notNull(uuid, "'userUserName' must not be null.");
		UserKey key = new UserKey(uuid);
		return getByKey(key);

		
	}

	public User getByRoleUuid(String roleUuid) {
		logger.trace("getByRoleUuid");

		Validate.notNull(roleUuid);

		Map<String, Object> m = new HashMap<String, Object>();
		m.put("UUID", roleUuid);

		String queryName = "User.getByRoleUuid.String";
		return (User) getByQueryName(queryName, m);

	}

	public List<User> getAll() {
		logger.trace("getAll");

		return getAll(0, Integer.MAX_VALUE);

	}

	@SuppressWarnings("unchecked")
	public List<User> getAll(int startPosition, int maxResult) {
		logger.trace("getAll");

		String queryName = "User.getAll";
		if (isMultiResultLists(startPosition, maxResult)) {
			return (List<User>) getListByQueryName(queryName);
		} else {
			return (List<User>) getListByQueryName(queryName, startPosition,
					maxResult);
		}
	}


	public List<User> getAllUsersByRoleId(String roleId) {
		logger.trace("getAllUsersByRoleId");
		Validate.notNull(roleId);

		
		return getAllUsersByRoleId(roleId, 0, Integer.MAX_VALUE);

	}
	@SuppressWarnings("unchecked")
	public List<User> getAllUsersByRoleId(String roleId, int startPosition, int maxResult)
	{
		logger.trace("getAll");
		Validate.notNull(roleId);
	
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("ROLE_UUID", roleId);

		String queryName = "User.getByRoleUuid.String";
		if (isMultiResultLists(startPosition, maxResult)) {
			return (List<User>) getListByQueryName(queryName,m);
		} else {
			return (List<User>) getListByQueryName(queryName,m, startPosition,
					maxResult);
		}
		
	}


}
