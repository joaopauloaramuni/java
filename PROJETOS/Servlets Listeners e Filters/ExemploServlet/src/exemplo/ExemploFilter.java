package exemplo;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ExemploFilter implements Filter {

	public ExemploFilter() {

	}

	public void destroy() {
		// Destrui��o do filtro
		System.out.println("Filtro destru�do");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		// Regi�o de intercepta��o da requisi��o
		// Executada antes da requisi��o chegar ao servlet
		System.out.println("Requisi��o interceptada");
		
		// Passa a requisi��o para o elemento seguinte da cadeia
		chain.doFilter(request, response);
		
		// Regi�o de intercepta��o da resposta
		// Executada ap�s a resposta voltar do servlet
		System.out.println("Resposta interceptada");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// Inicicializa��o do filtro
		System.out.println("Filtro Inicializado: " + fConfig.getFilterName());

		// Obt�m dinamicamente todos os par�metros de inicializa��o
		System.out.println("Par�metros de Inicializa��o");
		Enumeration<String> names = fConfig.getInitParameterNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			String value = fConfig.getInitParameter(name);
			System.out.println(name + "/" + value);
		}
	}

}
