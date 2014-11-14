package trilhasbrasil.com.recursos.seguranca;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/home")
public class HomeFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) req).getSession();
		if(session.getAttribute("user") == null) {
			((HttpServletResponse) res).sendRedirect("/Trilha");
		} else {
			fc.doFilter(req, res);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}




