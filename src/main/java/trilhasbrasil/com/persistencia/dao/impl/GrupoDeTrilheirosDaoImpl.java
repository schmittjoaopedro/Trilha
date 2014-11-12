package trilhasbrasil.com.persistencia.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import trilhasbrasil.com.persistencia.beans.GrupoDeTrilheiros;
import trilhasbrasil.com.persistencia.dao.GrupoDeTrilheirosDao;

@Stateless
public class GrupoDeTrilheirosDaoImpl extends GenericoDaoImpl<GrupoDeTrilheiros> implements GrupoDeTrilheirosDao {

	@SuppressWarnings("unchecked")
	public List<GrupoDeTrilheiros> procurarPorQueryPaginado(Integer start, Integer limit, String query) {
		Query sqlQuery = this.getEntityManager().createNamedQuery("GrupoDeTrilheiros.findAll");
		sqlQuery.setFirstResult(start);
		sqlQuery.setMaxResults(limit);
		sqlQuery.setParameter("nome", "%" + query + "%");
		return sqlQuery.getResultList();
	}

	@Override
	protected Boolean isPersistente(GrupoDeTrilheiros entity) {
		return entity.getId() != null && !entity.getId().equals(0L);
	}

	public GrupoDeTrilheiros procurarPorLoginESenha(String login, String senha) {
		Query query = this.getEntityManager().createNamedQuery("GrupoDeTrilheiros.procurarPorLoginESenha");
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		return (GrupoDeTrilheiros) query.getSingleResult();
	}

}
