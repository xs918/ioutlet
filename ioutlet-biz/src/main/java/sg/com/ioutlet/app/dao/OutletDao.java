package sg.com.ioutlet.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.commons.lang.Validate;

import sg.com.ioutlet.bas.CommonPojoKey;
import sg.com.ioutlet.model.outlet.Outlet;
import sg.com.ioutlet.model.outlet.OutletKey;

public class OutletDao extends IoutletDao {

	public OutletDao(EntityManager entityManager) {
		super(entityManager);
	}



	
	public Outlet get(OutletKey key)
	{
		return get((CommonPojoKey) key);
	}

	

	@Override
	public Outlet get(CommonPojoKey key) {
		
		
		logger.trace("get");
		Validate.isTrue(key instanceof OutletKey, "'key' must be an instance of 'OutletKey'.", key);

		return get(Outlet.class, key);

		
	}
	
	
	@Override
	public Outlet getByKey(CommonPojoKey key) {
		
		
		logger.trace("get");
		Validate.isTrue(key instanceof OutletKey, "'key' must be an instance of 'OutletKey'.", key);

		return get(Outlet.class, key);

		
	}


	

	@SuppressWarnings("unchecked")
	public List<Outlet> getByOutletName(String outletName, int startPosition, int maxResult)
	{
		logger.trace("Outlet.getByOutletKey");
		Validate.notNull(outletName, "'outletName' must not be null.");

		Map<String, Object> m = new HashMap<String, Object>();
		m.put("OUTLET_NAME", outletName);

		String queryName = "Outlet.getByOutletName.String";
		
		
		
		if (isMultiResultLists(startPosition, maxResult))
		{
			return (List<Outlet>) getListByQueryName(queryName, m);
		}
		else
		{
			return (List<Outlet>) getListByQueryName(queryName, m, startPosition, maxResult);
		}
	}

	public List<Outlet> getByOutletName(String outletName)
	{
		return getByOutletName(outletName, 0, Integer.MAX_VALUE);
	}

	
	
	public Outlet getByOutletUuid(String uuid)
	{
		logger.trace("getByOutletUuid");
		
		Validate.notNull(uuid);
		
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("UUID", uuid);
		
		String queryName = "Outlet.getByOutletUuid.String";
		return (Outlet)getByQueryName(queryName, m);
		
	}

	@SuppressWarnings("unchecked")
	public List<Outlet> getAll(int startPosition,int maxResult) {
		
		String queryName = "Outlet.getAll";

		
		if (isMultiResultLists(startPosition, maxResult))
		{
			return (List<Outlet>) getListByQueryName(queryName);
		}
		else
		{
			return (List<Outlet>) getListByQueryName(queryName, startPosition, maxResult);
		}
		
		
	}
	
	public  List<Outlet> getAll()
	{
		return this.getAll(0,Integer.MAX_VALUE);
	}
	

}
