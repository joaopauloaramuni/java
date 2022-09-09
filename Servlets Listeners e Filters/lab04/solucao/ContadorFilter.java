import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ContadorFilter implements Filter {
	
	private int maximo = 0;

	public void init(FilterConfig config) throws ServletException {
		System.out.println("Filtro contador criado");
		this.maximo = Integer.parseInt(config.getInitParameter("maximo"));
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpSession session = ((HttpServletRequest)request).getSession();
		int cont = ((Integer)session.getAttribute("cont")).intValue() + 1;
		
		if (cont > this.maximo) {
			PrintWriter out = response.getWriter();
			out.println("<p>Servlet utilizado " + cont + " vezes");
			out.println("<br>Sessão invalidada");
			session.invalidate();
			out.println("<br><a href=\"entrada\">Voltar</a>");			
		}
		else {
			session.setAttribute("cont", new Integer(cont));
			chain.doFilter(request,response);
		}
	}

	public void destroy() {
		System.out.println("Filtro contador destruído");
	}

}
