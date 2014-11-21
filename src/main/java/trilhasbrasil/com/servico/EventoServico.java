package trilhasbrasil.com.servico;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import trilhasbrasil.com.persistencia.beans.Evento;
import trilhasbrasil.com.persistencia.dao.EventoDao;
import trilhasbrasil.com.xml.adapter.EventoXmlAdapter;
import trilhasbrasil.com.xml.type.EventoXmlType;

@Stateless
public class EventoServico {

	@EJB
	private EventoDao eventoDao;
	
	@Transactional(value = TxType.REQUIRES_NEW)
	public EventoXmlType salvar(EventoXmlType eventoXmlType) throws Exception {
		Evento eventoParaSalvar = EventoXmlAdapter.getInstance().unmarshal(eventoXmlType);
		eventoDao.salvar(eventoParaSalvar);
		return EventoXmlAdapter.getInstance().marshal(eventoParaSalvar);
	}
	
	@Transactional(value = TxType.REQUIRED)
	public List<EventoXmlType> procurarTodosEventos() throws Exception {
		List<Evento> eventos = this.eventoDao.procurarTodos();
		List<EventoXmlType> eventosXmlTypes = new ArrayList<EventoXmlType>();
		for(Evento evento : eventos) 
			eventosXmlTypes.add(EventoXmlAdapter.getInstance().marshal(evento));
		return eventosXmlTypes;
	}
	
	@Transactional(value = TxType.REQUIRED)
	public EventoXmlType procurarEventoPorId(Long id) throws Exception {
		return EventoXmlAdapter.getInstance().marshal(this.eventoDao.procurarPeloId(id));
	}
	
	@Transactional(value = TxType.REQUIRED)
	public List<EventoXmlType> procurarEventosEntreAsDatas(Date initDate, Date endDate) throws Exception {
		List<Evento> eventos = this.eventoDao.procurarProximosEventosEntre(initDate, endDate);
		List<EventoXmlType> eventosXmlTypes = new ArrayList<EventoXmlType>();
		for(Evento evento : eventos) 
			eventosXmlTypes.add(EventoXmlAdapter.getInstance().marshal(evento));
		return eventosXmlTypes;
	}
	
	@Transactional(value = TxType.REQUIRES_NEW)
	public Boolean deletarEvento(Long eventoId, Long grupoDeTrilheirosId) {
		Evento eventoParaDeletar = this.eventoDao.procurarPeloId(eventoId);
		if(eventoParaDeletar != null && grupoDeTrilheirosId != null && eventoParaDeletar.getGrupoDeTrilheiros().getId().equals(grupoDeTrilheirosId)) {
			this.eventoDao.remove(eventoId);
			return true;
		} else {
			return false;
		}
	}
	
	@Transactional(value = TxType.REQUIRED)
	public List<EventoXmlType> procurarTodosAPartirDeHoje() throws Exception {
		List<Evento> eventos = this.eventoDao.procurarProximosEventos();
		List<EventoXmlType> eventosXmlTypes = new ArrayList<EventoXmlType>();
		for(Evento evento : eventos) 
			eventosXmlTypes.add(EventoXmlAdapter.getInstance().marshal(evento));
		return eventosXmlTypes;
	}
	
}


