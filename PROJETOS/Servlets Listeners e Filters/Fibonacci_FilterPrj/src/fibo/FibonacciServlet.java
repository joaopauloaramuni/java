package fibo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FibonacciServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FibonacciServlet() {
		super();
	}

	private void exibe(HttpServletResponse response,
			String chave) throws IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.println("<html><head><title>Fibonacci Servlet</title></head>");
		out.println("<body><h1>Fibonacci</h1>");
		out.println("<form method='post'>");
		out.println("<table><tr><td>Elemento da Série:</td><td><input type='text' name='elemento' size='5'/></td></tr>");
		out.println("<tr><td>Chave:</td><td><input type='text' name='chave' size='5'/></td><td>"
				+ chave + "</td></tr>");
		out.println("<tr><td><br><input type='submit' value='Calcular'/></td></tr></table></form>");
		out.println("</body></html>");

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String chave = (int) (Math.random() * 100000) + "";
		session.setAttribute("chave", chave);
		exibe(response, chave);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String mensagem = "";
		
		try {
			int valor = Integer.parseInt(request.getParameter("elemento"));

			if (valor < 1) {
				mensagem = "Elemento Inválido.";
			} else {
				mensagem = "Resultado = " + fibonacci(valor);
		}
		} catch (Exception e) {
			mensagem = "Elemento Inválido.";
		}

		out.println("<html><head><title>");
		out.println("Resultado");
		out.println("</title></head><body>");
		out.println("<h1>Resultado</h1>");
		out.println(mensagem + "<br>");
		out.println("<br><a href='fibonacci'>Voltar</a>");
		out.println("</body></html>");

		out.close();
	}

	private int fibonacci (int elemento) {
		int v1=0, v2=1, v3=0, i;
		
		if (elemento == 1) return 0;
		if (elemento == 2) return 1;
		
		for (i=3; i<=elemento; i++) {
			v3 = v1+v2;
			v1 = v2;
			v2 = v3;
		}
		
		return v3;
	}

}
