package fibo;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FibonacciFilter implements Filter {

	public FibonacciFilter() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filtro inicializado");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		if (req.getMethod().equals("POST")) {
			String chaveUsuario = request.getParameter("chave");
			String chaveSistema = (String) req.getSession().getAttribute(
					"chave");
			System.out.println("Filtrado: " + "\n Chave do Usuário:"
					+ chaveUsuario + "\n Chave do Sistema:" + chaveSistema);
			if (!chaveSistema.equals(chaveUsuario)) {
				//Redirecionar o usuário para página de Erro (ErroServlet)
				
				// Faz um redirecionamento externo para o servlet de erro
				HttpServletResponse resp = (HttpServletResponse)response;
				resp.sendRedirect("erro");
				
			} else {
				chain.doFilter(request, response);
			}
		} else {
			chain.doFilter(request, response);
		}

	}

	public void destroy() {
		System.out.println("Filtro destruído");
	}
}
