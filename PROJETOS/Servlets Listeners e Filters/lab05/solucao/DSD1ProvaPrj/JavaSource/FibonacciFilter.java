import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FibonacciFilter implements Filter {

	public void init(FilterConfig config) throws ServletException {
		System.out.println("Filtro inicializado");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String par = request.getParameter("chave");
		HttpServletRequest req = (HttpServletRequest)request;
		String chave = (String)req.getSession().getAttribute("chave");
		System.out.println("Filtrado: " + chave + "/" + par);
		if (chave != null && chave.equals(par))
			chain.doFilter(request, response);
		else {
			RequestDispatcher rd = req.getRequestDispatcher("erro.jsp");
			rd.forward(request,response);
		}
	}

	public void destroy() {
		System.out.println("Filtro destruído");
	}

}
