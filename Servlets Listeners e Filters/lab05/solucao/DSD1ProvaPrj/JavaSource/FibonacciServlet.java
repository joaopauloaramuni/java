

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 public class FibonacciServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

	private static final long serialVersionUID = 1L;

	public FibonacciServlet() {
		super();
	}   	 	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String mensagem = "";
		
		try {
			int valor = Integer.parseInt(request.getParameter("elemento"));
			mensagem = valor < 1 ? "Elemento inválido" : "Resultado = " + fibonacci(valor);			
		}
		catch (Exception e) {
			mensagem = "Elemento inválido";
		}
		
		out.println("<html><head><title>");
		out.println("Resultado");
		out.println("</title></head><body>");
		out.println("<h1>Resultado</h1>");
		out.println(mensagem + "<br>");
		out.println("<a href=\"fib.jsp\">Voltar</a>");
		out.println("</body></html>");
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