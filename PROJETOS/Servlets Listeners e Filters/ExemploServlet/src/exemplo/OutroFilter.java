package exemplo;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class OutroFilter implements Filter {

    public OutroFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Filtro 'outro' interceptou uma requisição.");
		chain.doFilter(request, response);
		System.out.println("Filtro 'outro' interceptou uma resposta.");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
