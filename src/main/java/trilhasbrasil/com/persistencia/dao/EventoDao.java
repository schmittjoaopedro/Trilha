package trilhasbrasil.com.persistencia.dao;

import java.util.List;

import trilhasbrasil.com.persistencia.beans.Evento;

public interface EventoDao extends GenericoDao<Evento> {

	public List<Evento> buscarEventosProximosEventos();
}
