

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter(
		initParams = { 
				@WebInitParam(name = "maxtermos", value = "10")
		}, 
		servletNames = { "CalculoServlet" })
public class CalculoFilter implements Filter {
	
	private int maxtermos = 0;
	
    public CalculoFilter() {

    }

	public void destroy() {
	
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpSession session = ((HttpServletRequest)request).getSession();
		if(session.getAttribute("precisao") == null){
			((HttpServletResponse)response).sendRedirect("precisao.jsp");
			return;
		}
		
		int termos = (Integer)session.getAttribute("termos");
		
		if(termos > maxtermos){
			session.setAttribute("termos", 0);
			((HttpServletResponse)response).sendRedirect("precisao.jsp");
			return;
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		try{
			maxtermos = Integer.parseInt(fConfig.getInitParameter("maxtermos"));
			if(maxtermos < 1){
				maxtermos = 50;
			}
			
		}catch(NumberFormatException e){
			maxtermos = 50;
		}
	}

}
