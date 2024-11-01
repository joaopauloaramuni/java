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
		// Destruição do filtro
		System.out.println("Filtro destruído");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		// Região de interceptação da requisição
		// Executada antes da requisição chegar ao servlet
		System.out.println("Requisição interceptada");
		
		// Passa a requisição para o elemento seguinte da cadeia
		chain.doFilter(request, response);
		
		// Região de interceptação da resposta
		// Executada após a resposta voltar do servlet
		System.out.println("Resposta interceptada");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// Inicicialização do filtro
		System.out.println("Filtro Inicializado: " + fConfig.getFilterName());

		// Obtém dinamicamente todos os parâmetros de inicialização
		System.out.println("Parâmetros de Inicialização");
		Enumeration<String> names = fConfig.getInitParameterNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			String value = fConfig.getInitParameter(name);
			System.out.println(name + "/" + value);
		}
	}

}
