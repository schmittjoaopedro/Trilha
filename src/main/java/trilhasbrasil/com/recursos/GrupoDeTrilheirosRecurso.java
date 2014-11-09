package trilhasbrasil.com.recursos;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import trilhasbrasil.com.persistencia.beans.GrupoDeTrilheiros;
import trilhasbrasil.com.servico.GrupoDeTrilheirosServico;

@Path("/grupodetrilheiros")
public class GrupoDeTrilheirosRecurso {

	@EJB
	private GrupoDeTrilheirosServico grupoDeTrilheirosService;
	
	@Context
	private HttpServletRequest httpServletRequest;
	
	
	@GET
	@RolesAllowed("ADMIN")
	public void save() {
		GrupoDeTrilheiros grupoDeTrilheiros = new GrupoDeTrilheiros();
		grupoDeTrilheiros.setLogin("joao");
		grupoDeTrilheiros.setNome("Joao Pedro Schmitt");
		grupoDeTrilheiros.setSenha("asd123");
		grupoDeTrilheiros.setCidade("Massaranduba");
		grupoDeTrilheiros.setEstado("Santa Catarina");
		this.grupoDeTrilheirosService.save(grupoDeTrilheiros);
	}
	
	@GET
	@Path("/login")
	public void login(@QueryParam("user") String user) {
		httpServletRequest.getSession().setAttribute("roles", "ADMIN");
	}
	
}
