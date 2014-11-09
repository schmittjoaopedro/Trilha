package trilhasbrasil.com.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import trilhasbrasil.com.persistence.beans.GrupoDeTrilheiros;
import trilhasbrasil.com.persistence.dao.GrupoDeTrilheirosDao;

@Stateless
public class GrupoDeTrilheirosDaoImpl implements GrupoDeTrilheirosDao {

	@PersistenceContext(unitName = "trilhasbr")
	private EntityManager entityManager;
	
	protected EntityManager getEntityManager() {
		return this.entityManager;
	}

	public void save(GrupoDeTrilheiros grupoDeTrilheiros) {
		this.getEntityManager().persist(grupoDeTrilheiros);
	}

}
