

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(servletNames = { "JogoServlet" })
public class JogoFilter implements Filter {

    public JogoFilter() {
    
    }

	public void destroy() {
		System.out.println("Filtro destruído");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		chain.doFilter(request, response);
		
		//Região de Tratamento da Resposta
		HttpSession session = ((HttpServletRequest) request).getSession();
		ServletContext context = session.getServletContext();
		HttpServletRequest req = (HttpServletRequest) request;

		int numMenor = (Integer) req.getSession().getAttribute("numMenor");
		int recordeMenor = (Integer) context.getAttribute("recordeMenor");
		
		if (numMenor <= recordeMenor) {
			context.setAttribute("recordeMenor", numMenor);
			System.out.println("Recorde quebrado! = " + numMenor);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filtro inicializado");
	}

}
