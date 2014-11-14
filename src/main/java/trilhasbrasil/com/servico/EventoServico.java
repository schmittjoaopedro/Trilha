package trilhasbrasil.com.servico;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import trilhasbrasil.com.persistencia.dao.EventoDao;

@Stateless
public class EventoServico {

	@EJB
	private EventoDao eventoDao;
	
	
}
