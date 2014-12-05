package trilhasbrasil.com.recursos;

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
import trilhasbrasil.com.servico.TrilhaServico;
import trilhasbrasil.com.xml.adapter.GrupoDeTrilheirosXmlAdapter;
import trilhasbrasil.com.xml.type.TrilhaXmlType;

@Path("/trilha")
public class TrilhaRecurso {

	@EJB
	private TrilhaServico trilhaServico;
	
	@Context
	private HttpServletRequest httpServletRequest;

	@Context
	private HttpServletResponse httpServletResponse;
	
	/**
	 * var data = [];
	 * overlayobj.overlay.getPath().getArray().forEach(function (item) {
	 *   data.push({
	 *     latitude: item.k,
	 *     longitude: item.B
	 *   });
	 * });
	 * data
	 * var evento = {
  	 *   id: 1,
	 *   nome: 'Primeiro Braco',
	 *   cidade: 'Massaranduba',
	 *   estado: 'SC',
	 *   localizacaoGeograficas: data
	 * };
	 * $.ajax({
	 *   url: '/Trilha/resources/trilha',
	 *   type: 'POST',
	 *   data: JSON.stringify(evento),
	 *   contentType: 'application/json; charset=utf-8',
	 *   dataType: 'json'
	 * });
	 * 
	 * @param trilhaXmlType
	 * @return
	 * @throws Exception
	 */
	@POST
	@RolesAllowed({"Grupo","Administrador"})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public TrilhaXmlType salvar(TrilhaXmlType trilhaXmlType) throws Exception {
		GrupoDeTrilheiros grupoDeTrilheiros = (GrupoDeTrilheiros) httpServletRequest.getSession().getAttribute("user");
		if(grupoDeTrilheiros != null) {
			trilhaXmlType.setGrupoDeTrilheirosXmlType(GrupoDeTrilheirosXmlAdapter.getInstance().marshal(grupoDeTrilheiros));
			return this.trilhaServico.salvar(trilhaXmlType);
		} else {
			httpServletResponse.sendError(401);
			return null;
		}
	}
	
	@GET	
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
	
	@GET
	@Path("/estado/{estado}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<TrilhaXmlType> procurarTrilhasPorEstado(@PathParam("estado") String nomeDoEstado) throws Exception {
		return this.trilhaServico.procurarTrilhasPorEstado(nomeDoEstado);
	}
	
	@GET
	@Path("/nome/{nome}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<TrilhaXmlType> procurarTrilhasPorGrupoDeTrilheiro(@PathParam("nome") String nome) throws Exception {
		return this.trilhaServico.procurarTrilhasPorGrupo(nome);
	}
	
}
