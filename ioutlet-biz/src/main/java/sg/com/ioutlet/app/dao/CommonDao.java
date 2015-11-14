package sg.com.ioutlet.app.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import sg.com.ioutlet.app.comm.log.LogHelper;
import sg.com.ioutlet.bas.CommonPojo;



public class CommonDao
{
	protected EntityManager em;

	protected boolean validateStale;
	
	protected LogHelper logger = LogHelper.getInstance(getClass().getName());

	public CommonDao(EntityManager entityManager)
	{
		this.em = entityManager;
	}


	public EntityManager getEntityManager()
	{
		return em;
	}

	protected boolean isMultiResultLists(int startPosition, int maxResult)
	{
		return startPosition == 0 && maxResult == Integer.MAX_VALUE;
	}

	public Object save(CommonPojo pojo)
	{	
		pojo.prepareCreate();
		em.persist(pojo);
		return pojo;
	}

	public Object reload(CommonPojo pojo)
	{
		em.refresh(pojo);
		return pojo;
	}
	public void delete(CommonPojo pojo)
	{
		em.remove(pojo);
	}
	
	public boolean isFound(CommonPojo pojo)
	{
		return this.em.contains(pojo);
	}

	public <T> T get(Class<T> clazz, Object id)
	{
		return em.find(clazz, id);
	}
	
	public Object get(String ejbql, Map<String, Object> m)
	{
		Object o = null;
		try
		{
			Query q = em.createQuery(ejbql);
			if (m != null)
			{
				for (Map.Entry<String, Object> each : m.entrySet())
				{
					q.setParameter(each.getKey(), each.getValue());
				}
			}
			o = q.getSingleResult();
		}
		catch (NoResultException e)
		{
			if(logger.isDebugEnabled())
			logger.debug("No result found:" + e.getMessage());
		}
		return o;
	}

	public Object get(String ejbql)
	{
		return get(ejbql, null);
	}

	protected Object getByQueryName(String queryName, Map<String, Object> m)
	{
		Query q = em.createNamedQuery(queryName);
		if (m != null)
		{
			for (Map.Entry<String, Object> each : m.entrySet())
			{
				q.setParameter(each.getKey(), each.getValue() != null && each.getValue().equals("") ? null : each.getValue());
			}
		}
		Object o = null;
		try
		{
			o = q.getSingleResult();
		}
		catch (NoResultException e)
		{			
			if(logger.isDebugEnabled())
				logger.debug("No result found:" + e.getMessage());
		}
		return o;
	}

	protected Object getByQueryName(String queryName)
	{
		return getByQueryName(queryName, null);
	}

	public List<?> getList(String ejbql, Map<String, Object> m)
	{
		Query q = em.createQuery(ejbql);
		if (m != null)
		{
			for (Map.Entry<String, Object> each : m.entrySet())
			{
				q.setParameter(each.getKey(), each.getValue());
			}
		}
		return q.getResultList();
	}

	public List<?> getList(String ejbql)
	{
		/*
		 * Query q = em.createQuery(ejbql); return q.getResultList();
		 */
		return getList(ejbql, null);
	}
	
	protected List<?> getListByQueryName(String queryName, Map<String, Object> m, int startPosition, int maxResult)
	{
		Query q = em.createNamedQuery(queryName);
		if (m != null)
		{
			for (Map.Entry<String, Object> each : m.entrySet())
			{
				// q.setParameter(each.getKey(), each.getValue());
				q.setParameter(each.getKey(), each.getValue() != null && each.getValue().equals("") ? null : each.getValue());
			}
		}
		q.setFirstResult(startPosition);
		q.setMaxResults(maxResult);
		return q.getResultList();
	}

	protected List<?> getListByQueryName(String queryName, Map<String, Object> m)
	{
		return getListByQueryName(queryName, m, 0, Integer.MAX_VALUE);
	}

	protected List<?> getListByQueryName(String queryName, int startPosition, int maxResult)
	{
		return getListByQueryName(queryName, null, startPosition, maxResult);
	}

	protected List<?> getListByQueryName(String queryName)
	{
		return  getListByQueryName(queryName, null, 0, Integer.MAX_VALUE);
	}
	

	
	
	protected boolean isValidateStale()
	{
		return validateStale;
	}
	
	public void setValidateStale(boolean validateStale){
		this.validateStale=validateStale;
	}
	
	
	
	

}
