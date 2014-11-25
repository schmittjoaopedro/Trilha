package trilhasbrasil.com.persistencia.dao.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import trilhasbrasil.com.persistencia.beans.Evento;
import trilhasbrasil.com.persistencia.dao.EventoDao;

@Stateless
public class EventoDaoImpl extends GenericoDaoImpl<Evento> implements EventoDao {

	public List<Evento> procurarPorQueryPaginado(Integer start, Integer limit, String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Evento> procurarProximosEventosEntre(Date initDate, Date endDate) {
		Query query = this.getEntityManager().createNamedQuery("Evento.procurarProximosEventosEntre");
		query.setParameter("initdate", initDate);
		query.setParameter("enddate", endDate);
		return (List<Evento>) query.getResultList();
	}

	@Override
	protected Boolean isPersistente(Evento entity) {
		return entity.getId() != null && !entity.getId().equals(0);
	}

	@SuppressWarnings("unchecked")
	public List<Evento> procurarProximosEventos() {
		Query query = this.getEntityManager().createNamedQuery("Evento.procurarProximosEventosAPartirDe");
		query.setParameter("initdate", new Date(), TemporalType.DATE);
		return (List<Evento>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Evento> procurarProximosEventosPorDono(Long grupoId) {
		Query query = this.getEntityManager().createNamedQuery("Evento.procurarProximosEventosPorDono");
		query.setParameter("initdate", new Date(), TemporalType.DATE);
		query.setParameter("grupoId", grupoId);
		return (List<Evento>) query.getResultList();
	}

}
