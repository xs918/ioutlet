package sg.com.ioutlet.ejb.bean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sg.com.ioutlet.framework.model.TransactionInfo;
import sg.com.ioutlet.framework.trxhelper.TransactionControl;

public class EjbEntityManager {
	@PersistenceContext(unitName = "primary")
	protected   EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	protected void setTrxInfo(TransactionInfo ti)
	{
	
		TransactionControl.setTransactionInfo(ti);
	}

}
