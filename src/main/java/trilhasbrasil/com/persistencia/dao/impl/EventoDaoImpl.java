package trilhasbrasil.com.persistencia.dao.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import trilhasbrasil.com.persistencia.beans.Evento;
import trilhasbrasil.com.persistencia.dao.EventoDao;

@Stateless
public class EventoDaoImpl extends GenericoDaoImpl<Evento> implements EventoDao {

	public List<Evento> procurarPorQueryPaginado(Integer start, Integer limit, String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Evento> procurarProximosEventos(Date initDate, Date endDate) {
		Query query = this.getEntityManager().createNamedQuery("Evento.procurarProximosEventos");
		query.setParameter("initdate", initDate);
		query.setParameter("enddate", endDate);
		return (List<Evento>) query.getResultList();
	}

	@Override
	protected Boolean isPersistente(Evento entity) {
		return entity.getId() != null && !entity.getId().equals(0);
	}

}
