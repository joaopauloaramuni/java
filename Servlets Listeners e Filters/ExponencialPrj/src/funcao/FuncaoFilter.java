package funcao;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(servletNames = { "FuncaoServlet" })
public class FuncaoFilter implements Filter {

    public FuncaoFilter() {

    }

	public void destroy() {

	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		if (req.getMethod().equals("POST")) {
			
			HttpSession session = req.getSession();
		
		}
		
		
		chain.doFilter(request, response);
	
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filtro Inicializado");
	}

}
