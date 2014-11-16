package trilhasbrasil.com.xml.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import trilhasbrasil.com.persistencia.beans.Evento;
import trilhasbrasil.com.persistencia.beans.Imagens;
import trilhasbrasil.com.xml.type.EventoXmlType;
import trilhasbrasil.com.xml.type.ImagemXmlType;

public final class EventoXmlAdapter extends XmlAdapter<EventoXmlType, Evento> {

	private static final EventoXmlAdapter EVENTO_XML_ADAPTER = new EventoXmlAdapter();

	private EventoXmlAdapter() {
		super();
	}

	public static EventoXmlAdapter getInstance() {
		return EventoXmlAdapter.EVENTO_XML_ADAPTER;
	}
	
	@Override
	public EventoXmlType marshal(Evento evento) throws Exception {
		EventoXmlType eventoXmlType = new EventoXmlType();
		eventoXmlType.setId(evento.getId());
		eventoXmlType.setDate(evento.getDate());
		eventoXmlType.setDescricao(evento.getDescricao());
		eventoXmlType.setNome(evento.getNome());
		eventoXmlType.setCusto(evento.getCusto());
		if(evento.getGrupoDeTrilheiros() != null)
			eventoXmlType.setGrupoDeTrilheiros(GrupoDeTrilheirosXmlAdapter.getInstance().marshal(evento.getGrupoDeTrilheiros()));
		if(evento.getImagems() != null)
			for(Imagens imagens : evento.getImagems()) 
				eventoXmlType.getImagems().add(ImagemXmlAdapter.getInstance().marshal(imagens));
		return eventoXmlType;
	}

	@Override
	public Evento unmarshal(EventoXmlType eventoXmlType) throws Exception {
		Evento evento = new Evento();
		evento.setId(eventoXmlType.getId());
		evento.setDate(eventoXmlType.getDate());
		evento.setDescricao(eventoXmlType.getDescricao());
		evento.setNome(eventoXmlType.getNome());
		evento.setCusto(eventoXmlType.getCusto());
		if(eventoXmlType.getGrupoDeTrilheiros() != null)
			evento.setGrupoDeTrilheiros(GrupoDeTrilheirosXmlAdapter.getInstance().unmarshal(eventoXmlType.getGrupoDeTrilheiros()));
		if(eventoXmlType.getImagems() != null)
			for(ImagemXmlType imagemXmlType : eventoXmlType.getImagems())
				evento.getImagems().add(ImagemXmlAdapter.getInstance().unmarshal(imagemXmlType));
		return evento;
	}

}
