package trilhasbrasil.com.persistencia.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import trilhasbrasil.com.persistencia.beans.Trilheiro;
import trilhasbrasil.com.persistencia.dao.TrilheiroDao;

@Stateless
public class TrilheiroDaoImpl extends GenericoDaoImpl<Trilheiro> implements TrilheiroDao {

	public List<Trilheiro> procurarPorQueryPaginado(Integer start, Integer limit, String query) {
		return null;
	}

	@Override
	protected Boolean isPersistente(Trilheiro entity) {
		return entity.getId() != null && !entity.getId().equals(0);
	}

	@SuppressWarnings("unchecked")
	public List<Trilheiro> procurarTrilheirosPorGrupo(Long grupoDeTrilheirosId) {
		Query query = this.getEntityManager().createNamedQuery("Trilheiro.procurarTrilheirosPorGrupo");
		query.setParameter("grupoDeTrilheirosId", grupoDeTrilheirosId);
		return (List<Trilheiro>) query.getResultList();
	}
	
}
