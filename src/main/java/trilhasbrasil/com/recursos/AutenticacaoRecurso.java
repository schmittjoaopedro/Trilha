package trilhasbrasil.com.recursos;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import trilhasbrasil.com.servico.GrupoDeTrilheirosServico;
import trilhasbrasil.com.xml.type.GrupoDeTrilheirosXmlType;

@Path("/autenticacao")
public class AutenticacaoRecurso {

	@Context
	private HttpServletRequest httpServletRequest;
	
	@EJB
	private GrupoDeTrilheirosServico grupoDeTrilheirosServico;
	
	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.MULTIPART_FORM_DATA})
	public GrupoDeTrilheirosXmlType autenticar(@QueryParam("login") String login, @QueryParam("senha") String senha) throws Exception {
		return this.grupoDeTrilheirosServico.autenticarUsuario(login, senha, httpServletRequest);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, })
	public Boolean estaAutenticado() {
		return !httpServletRequest.getSession().getAttribute("user").equals(null);
	}
	
}