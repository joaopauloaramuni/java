package fibo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FibonacciServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FibonacciServlet() {
		super();
	}

	private void exibe(HttpServletResponse response, String resposta)
			throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.println("<html><head><title>Fibonacci Servlet</title></head>");
		out.println("<body><h1>Fibonacci</h1>");
		out.println("<form method='post'>");
		out.println("<table><tr><td>Número:</td><td><input type='text' name='texto' size='5'/></td></tr>");
		out.println("<tr><td><br><input type='submit' value='Calcular'/></td></tr></table></form>");
		out.println(resposta);
		out.println("</body></html>");

		out.close();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		exibe(response, "");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String resposta = "";
		String numero = request.getParameter("texto");
		if (numero.trim().isEmpty() || !numero.matches("[0-9]*")) {
			resposta = "Valor inválido.";
			exibe(response, resposta);
			return;
		}
		try {
			int num = Integer.parseInt(numero);
			int resultado;
			resultado = fib(num);
			resposta = "Fibonacci de " + num + " é " + resultado + " .";
		} catch (Exception e) {
			resposta = "";
		}
		exibe(response, resposta);

	}

	private int fib(int n) {

		if (n == 0)
			return (0);
		else if (n == 1)
			return (1);
		else
			return (fib(n - 1) + fib(n - 2));
	}

}
