package trilhasbrasil.com.recursos.seguranca;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ResourceMethodInvoker;
import org.jboss.resteasy.core.ServerResponse;

import trilhasbrasil.com.persistencia.beans.GrupoDeTrilheiros;


@Provider
public class SegurancaInterceptor implements ContainerRequestFilter {

	@Context
	private HttpServletRequest httpServletRequest;
	
	private static final ServerResponse ACCESS_DENIED = new ServerResponse("Access denied for this resource", 401, new Headers<Object>());;
	
	public void filter(ContainerRequestContext requestContext) throws IOException {
		ResourceMethodInvoker methodInvoker = (ResourceMethodInvoker) requestContext.getProperty("org.jboss.resteasy.core.ResourceMethodInvoker");
		Method method = methodInvoker.getMethod();
		if(method.isAnnotationPresent(RolesAllowed.class)) {
			GrupoDeTrilheiros grupoDeTrilheiros = (GrupoDeTrilheiros) httpServletRequest.getSession().getAttribute("user");
			if(grupoDeTrilheiros == null) {
				requestContext.abortWith(ACCESS_DENIED);
				return; 
			}
			String[] roles = method.getAnnotation(RolesAllowed.class).value();
			Boolean haveAccess = false;
			for(String role : roles) {
				if(role.equals(grupoDeTrilheiros.getAccessRoles().name())) {
					haveAccess = true;
					break;
				}
			}
			if(!haveAccess) {
				requestContext.abortWith(ACCESS_DENIED);
				return;
			}
		}
	}
	
}
