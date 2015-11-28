package sg.com.ioutlet.app.dao;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.Query;

import org.apache.commons.lang.Validate;
import org.hibernate.LockMode;
import org.hibernate.internal.SessionImpl;

import sg.com.ioutlet.app.comm.log.LogHelper;
import sg.com.ioutlet.bas.CommonPojo;
import sg.com.ioutlet.bas.CommonPojoKey;
import sg.com.ioutlet.framework.model.TransactionInfo;
import sg.com.ioutlet.framework.trxhelper.TransactionControl;

public abstract class IoutletDao extends CommonDao {

	public IoutletDao(EntityManager entityManager) {
		super(entityManager);
		entityManager.setFlushMode(FlushModeType.COMMIT);
	}

	protected transient LogHelper logger = LogHelper.getInstance(getClass()
			.getName());

	


	public Object create(CommonPojo pojo) {
		Validate.isTrue(!isFound(pojo), "'pojo' must not be found.", pojo);
		prepareCreation(pojo);
		em.persist(pojo);
		return pojo;
	}

	public Object update(CommonPojo pojo) {
		return save(pojo);
	}

	public Object save(CommonPojo pojo) {
		prepareSave(pojo);
		em.merge(pojo);
		return pojo;
	}

	/**
	 * To update the Necessary Fields before updating to Database
	 * 
	 * @param pojo
	 */
	public void prepareSave(CommonPojo pojo) {
		pojo.prepareUpdate();

	}

	public abstract CommonPojo get(CommonPojoKey key);

	/**
	 * Can be overwritten if there is a need to use {@link EjbQuery} to load the
	 * pojo in steadof loading from EM
	 * 
	 * @param key
	 * @return
	 */
	public CommonPojo getByKey(CommonPojoKey key) {
		return get(key);
	}

	/**
	 * Call this method to get the record with the pessimistic write lock with
	 * Wait option
	 * 
	 * @param key
	 * @return
	 */
	public CommonPojo getByKeyWithLock(CommonPojoKey key) {
		CommonPojo pojo = getByKey(key);
		lock(pojo);
		return pojo;

	}

	/**
	 * Lock the pojo with Pessimistic write lock (i.e. Select .. For Update)
	 * 
	 * @param pojo
	 */
	@SuppressWarnings("deprecation")
	public void lock(CommonPojo pojo) {
		if (pojo != null) {

			/**
			 * Too bad, we have to use the Hibernate since em.lock is
			 * generationg "SELECT .. FOR UPDATE NOWAIT" But what we want is
			 * "SELECT..FOR UPDATE".
			 */
			SessionImpl session = (SessionImpl) em.getDelegate();
			session.lock(pojo, LockMode.UPGRADE);

		}
	}

	public String getNamedQueryString(String queryName) {
		String queryString = null;
		SessionImpl session = (SessionImpl) em.getDelegate();
		queryString = session.getNamedQuery(queryName).getQueryString();
		return queryString;
	}

	public void delete(boolean physical, CommonPojo pojo) {
		Validate.isTrue(isFound(pojo), "'pojo' must be found.", pojo);
		em.remove(pojo);

	}

	public void delete(CommonPojo pojo) {
		delete(true, pojo);
	}

	/**
	 * For better memory management if working with huge collection, detach the
	 * object from cache(EntityManager). Since JPA does not have the detach
	 * method "YET"!, use the underlying Hibernate.This will not work for other
	 * JPA provider
	 * 
	 * @param pojo
	 */
	public void detach(CommonPojo pojo) {

		SessionImpl session = (SessionImpl) em.getDelegate();
		session.evict(pojo);

	}

	public Query getDynamicQuery(String namedQuery, String ejbDynamicQuery) {
		Query query = em.createQuery(namedQuery + ejbDynamicQuery);
		return query;
	}

	@SuppressWarnings("unchecked")
	public <T> T executeNativeQuerySingleResult(String query,
			String resultType, Object... parameters) {
		Query q = em.createNativeQuery(query, resultType);
		for (int i = 1; i <= parameters.length; i++) {
			q.setParameter(i, parameters[i - 1]);
		}
		return (T) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public <T> T executeEjbQuerySingleResult(String query,
			Map<String, Object> parameters) {
		Query q = em.createQuery(query);
		if (parameters != null) {
			for (Map.Entry<String, Object> each : parameters.entrySet()) {
				q.setParameter(each.getKey(), each.getValue());
			}
		}
		return (T) q.getSingleResult();
	}

	public void prepareCreation(CommonPojo pojo) {
		TransactionInfo trxInfo = TransactionControl.getTransactionInfo();
		pojo.setCreationPgm(trxInfo.getFunctionId());
		pojo.setCreationUser(trxInfo.getRequestUser());
		pojo.setLudPgm(trxInfo.getFunctionId());
		pojo.setCreationUser(trxInfo.getRequestUser());

		pojo.prepareCreate();
	}

	public void prepareUpdating(CommonPojo pojo) {
		TransactionInfo trxInfo = TransactionControl.getTransactionInfo();
		if (pojo.getCreationPgm() == null)
			pojo.setCreationPgm(trxInfo.getFunctionId());

		if (pojo.getCreationUser() == null)
			pojo.setCreationUser(trxInfo.getRequestUser());

		pojo.setLudPgm(trxInfo.getFunctionId());
		pojo.setCreationUser(trxInfo.getRequestUser());

		pojo.prepareUpdate();
	}
}
