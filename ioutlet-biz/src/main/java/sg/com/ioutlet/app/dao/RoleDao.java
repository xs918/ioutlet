package sg.com.ioutlet.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.Validate;

import sg.com.ioutlet.bas.CommonPojoKey;
import sg.com.ioutlet.model.role.Role;
import sg.com.ioutlet.model.role.RoleKey;

public class RoleDao extends IoutletDao {

	public RoleDao(EntityManager entityManager) {
		super(entityManager);
	}


	public Role get(RoleKey key) {
		return get((CommonPojoKey) key);
	}

	@Override
	public Role get(CommonPojoKey key) {

		logger.trace("get");
		Validate.isTrue(key instanceof RoleKey,
				"'key' must be an instance of 'RoleKey'.", key);

		return get(Role.class, key);

	}

	@Override
	public Role getByKey(CommonPojoKey key) {

		logger.trace("get");
		Validate.isTrue(key instanceof RoleKey,
				"'key' must be an instance of 'RoleKey'.", key);

		return get(Role.class, key);

	}

	public Role getByRoleName(String userRoleName) {
		logger.trace("getByRoleName");
		Validate.notNull(userRoleName, "'userRoleName' must not be null.");

		Map<String, Object> m = new HashMap<String, Object>();
		m.put("ROLE_NAME", userRoleName);

		String queryName = "Role.getByRoleName.String";

		return (Role) getByQueryName(queryName, m);

	}

	public Role getByRoleUuid(String uuid) {
		logger.trace("getByRoleUuid");

		Validate.notNull(uuid);

		Map<String, Object> m = new HashMap<String, Object>();
		m.put("UUID", uuid);

		String queryName = "Role.getByRoleUuid.String";
		return (Role) getByQueryName(queryName, m);

	}

	public List<Role> getAll() {
		logger.trace("getAll");

		return getAll(0, Integer.MAX_VALUE);

	}

	@SuppressWarnings("unchecked")
	public List<Role> getAll(int startPosition, int maxResult) {
		logger.trace("getAll");

		String queryName = "Role.getAll";
		if (isMultiResultLists(startPosition, maxResult)) {
			return (List<Role>) getListByQueryName(queryName);
		} else {
			return (List<Role>) getListByQueryName(queryName, startPosition,
					maxResult);
		}
	}



}
