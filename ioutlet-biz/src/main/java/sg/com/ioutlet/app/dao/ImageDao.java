package sg.com.ioutlet.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.commons.lang.Validate;

import sg.com.ioutlet.bas.CommonPojoKey;
import sg.com.ioutlet.model.image.Image;
import sg.com.ioutlet.model.image.ImageKey;


public class ImageDao extends IoutletDao {

	public ImageDao(EntityManager entityManager) {
		super(entityManager);
	}


	public Image get(ImageKey key) {
		return get((CommonPojoKey) key);
	}

	@Override
	public Image get(CommonPojoKey key) {

		logger.trace("get");
		Validate.isTrue(key instanceof ImageKey,
				"'key' must be an instance of 'ImageKey'.", key);

		return get(Image.class, key);

	}

	@Override
	public Image getByKey(CommonPojoKey key) {

		logger.trace("get");
		Validate.isTrue(key instanceof ImageKey,
				"'key' must be an instance of 'ImageKey'.", key);

		return get(Image.class, key);

	}

	public Image getByUuid(String uuid) {
		logger.trace("getByUuid");
		Validate.notNull(uuid, "'userImageName' must not be null.");
		ImageKey key = new ImageKey(uuid);
		return getByKey(key);

		
	}

	public Image getByRoleUuid(String roleUuid) {
		logger.trace("getByRoleUuid");

		Validate.notNull(roleUuid);

		Map<String, Object> m = new HashMap<String, Object>();
		m.put("UUID", roleUuid);

		String queryName = "Image.getByRoleUuid.String";
		return (Image) getByQueryName(queryName, m);

	}

	public List<Image> getAll() {
		logger.trace("getAll");

		return getAll(0, Integer.MAX_VALUE);

	}

	@SuppressWarnings("unchecked")
	public List<Image> getAll(int startPosition, int maxResult) {
		logger.trace("getAll");

		String queryName = "Image.getAll";
		if (isMultiResultLists(startPosition, maxResult)) {
			return (List<Image>) getListByQueryName(queryName);
		} else {
			return (List<Image>) getListByQueryName(queryName, startPosition,
					maxResult);
		}
	}


	public List<Image> getAllImagesByRoleId(String roleId) {
		logger.trace("getAllImagesByRoleId");
		Validate.notNull(roleId);

		
		return getAllImagesByRoleId(roleId, 0, Integer.MAX_VALUE);

	}
	@SuppressWarnings("unchecked")
	public List<Image> getAllImagesByRoleId(String roleId, int startPosition, int maxResult)
	{
		logger.trace("getAll");
		Validate.notNull(roleId);
	
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("ROLE_UUID", roleId);

		String queryName = "Image.getByRoleUuid.String";
		if (isMultiResultLists(startPosition, maxResult)) {
			return (List<Image>) getListByQueryName(queryName,m);
		} else {
			return (List<Image>) getListByQueryName(queryName,m, startPosition,
					maxResult);
		}
		
	}


	public Image getByUsrId(String userId) {
		logger.trace("getByUsrId");
		Validate.notNull(userId, "'userId' must not be null.");

		Map<String, Object> m = new HashMap<String, Object>();
		m.put("USER_ID", userId);
		
		
		String queryName = "Image.getByUsrId.String";
		return (Image) getByQueryName(queryName, m);
		}


}
