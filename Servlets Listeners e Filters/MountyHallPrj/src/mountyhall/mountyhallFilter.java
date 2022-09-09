package mountyhall;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class mountyhallFilter implements Filter {

	public mountyhallFilter() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filtro inicializado");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		//Região de Tratamento da Requisição
		
		chain.doFilter(request, response);
		
		//Região de Tratamento da Resposta
		
		HttpSession session = ((HttpServletRequest) request).getSession();
		ServletContext context = session.getServletContext();
		HttpServletRequest req = (HttpServletRequest) request;

		int recorde = (Integer) context.getAttribute("recorde");
		int pontos = (Integer) req.getSession().getAttribute("pontos");

		if (pontos > recorde) {
			context.setAttribute("recorde", pontos);
		}
		
		PrintWriter out = response.getWriter();
		out.close();
	}

	public void destroy() {
		System.out.println("Filtro destruído");
	}

}
