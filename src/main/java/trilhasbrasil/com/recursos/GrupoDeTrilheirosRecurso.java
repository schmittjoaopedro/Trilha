package trilhasbrasil.com.recursos;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import trilhasbrasil.com.persistencia.beans.GrupoDeTrilheiros;
import trilhasbrasil.com.servico.GrupoDeTrilheirosServico;

@Path("/grupodetrilheiros")
public class GrupoDeTrilheirosRecurso {

	@EJB
	private GrupoDeTrilheirosServico grupoDeTrilheirosService;
	
	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public GrupoDeTrilheiros save(GrupoDeTrilheiros grupoDeTrilheiros) {
		return this.grupoDeTrilheirosService.salvar(grupoDeTrilheiros);
	}
	
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Boolean remover(@PathParam("id") Long id) {
		return this.grupoDeTrilheirosService.remover(id);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<GrupoDeTrilheiros> procurarTodos() {
		return this.grupoDeTrilheirosService.procurarTodos();
	}
	
}
