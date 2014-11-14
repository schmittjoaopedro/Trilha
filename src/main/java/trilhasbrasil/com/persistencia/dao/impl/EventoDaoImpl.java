package trilhasbrasil.com.persistencia.dao.impl;

import java.util.List;

import javax.ejb.Stateless;

import trilhasbrasil.com.persistencia.beans.Evento;
import trilhasbrasil.com.persistencia.dao.EventoDao;

@Stateless
public class EventoDaoImpl extends GenericoDaoImpl<Evento> implements EventoDao {

	public List<Evento> procurarPorQueryPaginado(Integer start, Integer limit, String query) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Evento> buscarEventosProximosEventos() {
		return null;
	}

	@Override
	protected Boolean isPersistente(Evento entity) {
		return entity.getId() != null;
	}

}
