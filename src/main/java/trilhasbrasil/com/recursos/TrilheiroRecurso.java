package trilhasbrasil.com.recursos;

import java.io.IOException;
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
import trilhasbrasil.com.servico.TrilheiroServico;
import trilhasbrasil.com.xml.type.GrupoDeTrilheirosXmlType;
import trilhasbrasil.com.xml.type.TrilheiroXmlType;

@Path("/trilheiro")
public class TrilheiroRecurso {

	@EJB
	private TrilheiroServico trilheiroServico;

	@Context
	private HttpServletRequest httpServletRequest;

	@Context
	private HttpServletResponse httpServletResponse;
	
	/*
	 * var evento = {
	 *   nome: 'Luis Felipe Schmitt',
	 *   email: 'luis@gmail.com',
	 *   telefone: "33791302",
	 *   imagems: [
	 *     {
	 *       url: 'http://www.itanatrilha.com.br/inicio/wp-content/uploads/2013/06/8_Bicho_na_trilha_Massaranduba.jpg'
	 *     }
	 *   ]
	 * };
	 * $.ajax({
	 *   url: '/Trilha/resources/trilheiro',
	 *   type: 'POST',
	 *   data: JSON.stringify(evento),
	 *   contentType: 'application/json; charset=utf-8',
	 *   dataType: 'json'
	 * });
	 */
	@POST
	@RolesAllowed({"Grupo","Administrador"})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public TrilheiroXmlType salvar(TrilheiroXmlType trilheiroXmlType) throws Exception {
		GrupoDeTrilheiros grupoDeTrilheiros = (GrupoDeTrilheiros) httpServletRequest.getSession().getAttribute("user");
		if(grupoDeTrilheiros == null) {
			httpServletResponse.sendError(401);
			return null;
		} else {
			trilheiroXmlType.setGrupoDeTrilheirosXmlType(new GrupoDeTrilheirosXmlType());
			trilheiroXmlType.getGrupoDeTrilheirosXmlType().setId(grupoDeTrilheiros.getId());
			return this.trilheiroServico.salvar(trilheiroXmlType);
		}
	}

	@POST
	@Path("/grupo")
	@RolesAllowed("Administrador")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public TrilheiroXmlType salvarComGrupo(TrilheiroXmlType trilheiroXmlType) throws Exception {
		return this.trilheiroServico.salvar(trilheiroXmlType);
	}
	
	@GET
	@Path("/all")
	@RolesAllowed("Administrador")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<TrilheiroXmlType> procurarTodosTrilheiros() throws Exception {
		return this.trilheiroServico.procurarTodosTrilheiros();
	}
	
	@GET
	@RolesAllowed({"Administrador","Grupo"})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<TrilheiroXmlType> procurarTodosTrilheirosPorGrupo() throws Exception {
		GrupoDeTrilheiros grupoDeTrilheiros = (GrupoDeTrilheiros) httpServletRequest.getSession().getAttribute("user");
		if(grupoDeTrilheiros == null) {
			httpServletResponse.sendError(401);
			return null;
		} else {
			return this.trilheiroServico.procurarTrilheirosPorGrupo(grupoDeTrilheiros.getId());
		}
	}
	
	@DELETE
	@Path("/{id}")
	@RolesAllowed({"Administrador","Grupo"})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Boolean deletarTrilheiro(@PathParam("id") Long id) throws IOException {
		GrupoDeTrilheiros grupoDeTrilheiros = (GrupoDeTrilheiros) httpServletRequest.getSession().getAttribute("user");
		if(grupoDeTrilheiros == null) {
			httpServletResponse.sendError(401);
			return null;
		} else {
			return this.trilheiroServico.deletarTrilheiro(id, grupoDeTrilheiros.getId());
		}
	}
	
}


