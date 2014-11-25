package trilhasbrasil.com.recursos;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import trilhasbrasil.com.persistencia.beans.GrupoDeTrilheiros;
import trilhasbrasil.com.servico.EventoServico;
import trilhasbrasil.com.xml.adapter.GrupoDeTrilheirosXmlAdapter;
import trilhasbrasil.com.xml.type.EventoXmlType;

@Path("/evento")
public class EventoRecurso {

	@EJB
	private EventoServico eventoServico;
	
	@Context
	private HttpServletRequest httpServletRequest;
	
	@Context
	private HttpServletResponse httpServletResponse;
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
		GrupoDeTrilheiros grupoDeTrilheiros = (GrupoDeTrilheiros) httpServletRequest.getSession().getAttribute("user");
		if(grupoDeTrilheiros != null) {
			eventoXmlType.setGrupoDeTrilheiros(GrupoDeTrilheirosXmlAdapter.getInstance().marshal(grupoDeTrilheiros));
			return eventoServico.salvar(eventoXmlType);
		} else {
			httpServletResponse.sendError(401);
			return null;
		}
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<EventoXmlType> procurarTodosEventos() throws Exception {
		GrupoDeTrilheiros grupoDeTrilheiros = (GrupoDeTrilheiros) httpServletRequest.getSession().getAttribute("user");
		if(grupoDeTrilheiros != null) {
			return eventoServico.procurarTodosAPartirDeHoje(grupoDeTrilheiros.getId());
		} else {
			return eventoServico.procurarTodosAPartirDeHoje();
		}
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public EventoXmlType procurarEventoPeloId(@PathParam("id") Long id) throws Exception {
		return this.eventoServico.procurarEventoPorId(id);
	}
	
	@GET
	@Path("/entre/{initdate}/{enddate}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<EventoXmlType> procurarEventosEntreAsDatas(@PathParam("initdate") Long initdate, @PathParam("enddate") Long enddate) throws Exception {
		return this.eventoServico.procurarEventosEntreAsDatas(new Date(initdate), new Date(enddate));
	}
	
	@DELETE
	@Path("/{id}")
	@RolesAllowed({"Grupo","Administrador"})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Boolean deletarEventoPeloId(@PathParam("id") Long id) throws IOException {
		GrupoDeTrilheiros grupoDeTrilheiros = (GrupoDeTrilheiros) httpServletRequest.getSession().getAttribute("user");
		if(grupoDeTrilheiros == null) {
			httpServletResponse.sendError(401);
			return false;
		} else {
			return this.eventoServico.deletarEvento(id, grupoDeTrilheiros.getId());
		}
	}
	
}
