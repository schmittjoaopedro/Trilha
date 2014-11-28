package trilhasbrasil.com.persistencia.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import trilhasbrasil.com.persistencia.beans.Trilha;
import trilhasbrasil.com.persistencia.dao.TrilhaDao;

@Stateless
public class TrilhaDaoImpl extends GenericoDaoImpl<Trilha> implements TrilhaDao {

	public List<Trilha> procurarPorQueryPaginado(Integer start, Integer limit, String query) {
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Trilha> procurarTrilhasPorEstado(String nomeDoEstado) {
		Query query = getEntityManager().createNamedQuery("Trilha.procurarTrilhasPorEstado");
		query.setParameter("nomeDoEstado", "%" + nomeDoEstado + "%");
		return (List<Trilha>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Trilha> procurarTrilhasPorGrupoDeTrilheiros(String nomeDoGrupo) {
		Query query = getEntityManager().createNamedQuery("Trilha.procurarTrilhasPorEstado");
		query.setParameter("nomeDoGrupo", "%" + nomeDoGrupo + "%");
		return (List<Trilha>) query.getResultList();
	}

	@Override
	protected Boolean isPersistente(Trilha entity) {
		return entity.getId() != null && !entity.getId().equals(0L);
	}
}
