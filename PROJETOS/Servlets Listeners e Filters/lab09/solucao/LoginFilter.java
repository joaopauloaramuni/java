import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	public void init(FilterConfig config) throws ServletException {
		System.out.println("Filtro criado");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest)request).getSession(false);
		if (session == null) {
			String url = ((HttpServletRequest)request).getRequestURI();
			RequestDispatcher rd = null;
			if (url.endsWith("jsp"))
			  rd = request.getRequestDispatcher("login.jsp");
			else
              rd = request.getRequestDispatcher("login");
			rd.forward(request,response);
		}
		else
			chain.doFilter(request,response);
	}

	public void destroy() {
		System.out.println("Filtro destruído");
	}

}
