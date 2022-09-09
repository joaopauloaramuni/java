import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RodapeFilter implements Filter {
	
	public void init(FilterConfig config) throws ServletException {
		System.out.println("Filtro de rodapé criado");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request,response);
		PrintWriter out = response.getWriter();
		out.println("<p>" + new Date());
		out.println("</body></html>");
	}

	public void destroy() {
		System.out.println("Fitro de Rodapé destruído");
	}

}
