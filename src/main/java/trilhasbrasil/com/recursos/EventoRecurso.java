package trilhasbrasil.com.recursos;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import trilhasbrasil.com.servico.EventoServico;
import trilhasbrasil.com.xml.type.EventoXmlType;

@Path("/evento")
public class EventoRecurso {

	@EJB
	private EventoServico eventoServico;
	
	/**
	 * 
	 * Contract: call
	 * 
	 * var evento = {
	 *   nome: 'Bicho da trila 16',
	 *   descricao: 'Maior evento de Massaranduba de todos os anos',
	 *   custo: 51.5,
	 *   imagems: [{
	 *     url: 'http://www.itanatrilha.com.br/inicio/wp-content/uploads/2013/06/8_Bicho_na_trilha_Massaranduba.jpg'
	 *   }],
	 *   grupoDeTrilheiros: {
	 *     id: 3
	 *   }
	 * };
	 * $.ajax({
	 *   url: '/Trilha/resources/evento',
	 *   type: 'POST',
	 *   data: JSON.stringify(evento),
	 *   contentType: 'application/json; charset=utf-8',
	 *   dataType: 'json'
	 * });
	 * 
	 * @param eventoXmlType
	 * 
	 * @return eventoXmlType
	 * 
	 * @throws Exception
	 */
	@POST
	@RolesAllowed({"Grupo","Administrador"})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public EventoXmlType salvarEvento(EventoXmlType eventoXmlType) throws Exception {
		return eventoServico.salvar(eventoXmlType);
	}
	
}
