package trilhasbrasil.com.recursos;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import trilhasbrasil.com.servico.GrupoDeTrilheirosServico;
import trilhasbrasil.com.xml.type.GrupoDeTrilheirosXmlType;

@Path("/autenticacao")
public class AutenticacaoRecurso {

	@Context
	private HttpServletRequest httpServletRequest;
	@Context
	private HttpServletResponse httpServletResponse;
	
	@EJB
	private GrupoDeTrilheirosServico grupoDeTrilheirosServico;
	
	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public GrupoDeTrilheirosXmlType autenticar(@FormParam("login") String login, @FormParam("senha") String senha) throws Exception {
		try {
			return this.grupoDeTrilheirosServico.autenticarUsuario(login, senha, httpServletRequest);
		} catch (Exception ex) {
			httpServletResponse.sendError(401);
			return null;
		}
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, })
	public Boolean estaAutenticado() {
		return !httpServletRequest.getSession().getAttribute("user").equals(null);
	}
	
	@DELETE
	public Boolean logout() {
		try {
			httpServletRequest.getSession().setAttribute("user", null);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
}
