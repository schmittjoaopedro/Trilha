package trilhasbrasil.com.servico;

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
	
}
