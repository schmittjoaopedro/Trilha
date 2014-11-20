package trilhasbrasil.com.persistencia.dao.impl;

import java.util.List;

import javax.ejb.Stateless;

import trilhasbrasil.com.persistencia.beans.Trilha;
import trilhasbrasil.com.persistencia.dao.TrilhaDao;

@Stateless
public class TrilhaDaoImpl extends GenericoDaoImpl<Trilha> implements TrilhaDao {

	public List<Trilha> procurarPorQueryPaginado(Integer start, Integer limit, String query) {
		return null;
	}

	@Override
	protected Boolean isPersistente(Trilha entity) {
		return entity.getId() != null && !entity.getId().equals(0L);
	}

}
