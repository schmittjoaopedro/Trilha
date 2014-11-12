package trilhasbrasil.com.recursos;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import trilhasbrasil.com.servico.GrupoDeTrilheirosServico;
import trilhasbrasil.com.xml.type.GrupoDeTrilheirosXmlType;

@Path("/grupodetrilheiros")
public class GrupoDeTrilheirosRecurso {

	@EJB
	private GrupoDeTrilheirosServico grupoDeTrilheirosService;
	
	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public GrupoDeTrilheirosXmlType save(GrupoDeTrilheirosXmlType grupoDeTrilheiros) throws Exception {
		return this.grupoDeTrilheirosService.salvar(grupoDeTrilheiros);
	}
	
	@DELETE
	@Path("/{id}")
	@RolesAllowed("Administrador")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Boolean remover(@PathParam("id") Long id) {
		return this.grupoDeTrilheirosService.remover(id);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<GrupoDeTrilheirosXmlType> procurarTodos() throws Exception {
		return this.grupoDeTrilheirosService.procurarTodos();
	}
	
	@GET
	@Path("/{start}/{limit}/{query}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<GrupoDeTrilheirosXmlType> procurarTodosPaginadosPorQuery(@PathParam("start") Integer start, 
			@PathParam("limit") Integer limit, @PathParam("query") String query) throws Exception {
		return this.grupoDeTrilheirosService.procurarTodosComFiltroPaginado(start, limit, query);
	}
}
