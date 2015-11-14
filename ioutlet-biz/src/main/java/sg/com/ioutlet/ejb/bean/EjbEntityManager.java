package sg.com.ioutlet.ejb.bean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EjbEntityManager {
	@PersistenceContext(unitName = "primary")
	protected   EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}


}
