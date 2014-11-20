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

import trilhasbrasil.com.servico.TrilhaServico;
import trilhasbrasil.com.xml.type.TrilhaXmlType;

@Path("/trilha")
public class TrilhaRecurso {

	@EJB
	private TrilhaServico trilhaServico;
	
	@POST
	@RolesAllowed({"Grupo","Administrador"})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public TrilhaXmlType salvar(TrilhaXmlType trilhaXmlType) throws Exception {
		return this.trilhaServico.salvar(trilhaXmlType);
	}
	
	@GET
	@RolesAllowed({"Grupo","Administrador"})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<TrilhaXmlType> procurarTodasTrilhas() throws Exception {
		return this.trilhaServico.procurarTodasAsTrilhas();
	}
	
	@GET
	@Path("/{id}")
	@RolesAllowed({"Grupo","Administrador"})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public TrilhaXmlType procurarTrilhaPorId(@PathParam("id") Long id) throws Exception {
		return this.trilhaServico.procurarTrilhaPorId(id);
	}
	
	@DELETE
	@Path("/{id}")
	@RolesAllowed({"Administrador","Grupo"})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Boolean removerPorId(@PathParam("id") Long id) {
		return this.trilhaServico.removerTrilhaPorId(id);
	}
	
	
}
