import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TrimFilter implements Filter {
	
	private FilterConfig config = null;

	public void init(FilterConfig config) throws ServletException {
		System.out.println("Filtro Trim criado");
		this.config = config;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		Enumeration param = request.getParameterNames();
		while (param.hasMoreElements()) {
			String parName = (String) param.nextElement();
			String parValue = request.getParameter(parName);
			String caso = config.getInitParameter("caso");
			if (caso != null && "upper".equals(caso))
				parValue = parValue.toUpperCase();
			request.setAttribute(parName,parValue.trim());
		}
		
		chain.doFilter(request,response);
	}

	public void destroy() {
		System.out.println("Filtro Trim destruído");
	}

}
