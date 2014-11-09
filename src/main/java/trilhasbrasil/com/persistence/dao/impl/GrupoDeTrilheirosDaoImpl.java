package trilhasbrasil.com.persistence.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import trilhasbrasil.com.persistencia.beans.GrupoDeTrilheiros;
import trilhasbrasil.com.persistencia.dao.GrupoDeTrilheirosDao;

@Stateless
public class GrupoDeTrilheirosDaoImpl implements GrupoDeTrilheirosDao {

	@PersistenceContext(unitName = "trilhasbr")
	private EntityManager entityManager;
	
	protected EntityManager getEntityManager() {
		return this.entityManager;
	}

	public GrupoDeTrilheiros save(GrupoDeTrilheiros entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean remove(GrupoDeTrilheiros entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<GrupoDeTrilheiros> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<GrupoDeTrilheiros> findByQueryAndPaginate(Integer start,
			Integer limit, String query) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean adicionarTrilha(Integer grupoId, Integer trilhaId) {
		// TODO Auto-generated method stub
		return null;
	}

}
