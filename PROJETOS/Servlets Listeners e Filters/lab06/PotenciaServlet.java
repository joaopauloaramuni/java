

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: PotenciaServlet
 *
 */
 public class PotenciaServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

	private static final long serialVersionUID = 1L;

	public PotenciaServlet() {
		super();
	}   	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.exibeTela(request,response,"");
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String baseStr = request.getParameter("base");
		String expoenteStr = request.getParameter("expoente");
		double base = 0.0;
		int expoente = 0;
		String mensagem = "";
		if (baseStr != null && expoenteStr != null)
			try {
				base = Double.parseDouble(baseStr);
				expoente = Integer.parseInt(expoenteStr);
				mensagem = "Resultado = " + potencia(base,expoente);
			} catch (NumberFormatException e) {
				mensagem = "Informações incorretas";
			}
		
		this.exibeTela(request, response, mensagem);
	}
	
	private void exibeTela(HttpServletRequest request, HttpServletResponse response, String mensagem) 
		throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html><head><title>");
		out.println("Cálculo de potência");
		out.println("</title></head><body>");
		out.println("<h1>Cálculo de Potência</h1>");
		
		out.println("<form method=\"post\">");
		out.println("Base (real): <input type=\"text\" name=\"base\">");
		out.println("<br>Expoente (inteiro): <input type=\"text\" name=\"expoente\">");
		out.println("<br><input type=\"submit\">");
		out.println("</form>");
		out.println(mensagem);
		
		out.println("<a href=\"login\">Sair</a>");
		out.println("</body></html>");
		out.close();
	}
	
	private double potencia (double base, int expoente) {
		
		if (expoente == 0)
			return 1.0;
		
		if (expoente < 0) 
			return 1.0 / potencia (base, -expoente);
		
		if (expoente % 2 == 0) {
			double d = potencia (base, expoente / 2);
			return d*d;
		}
		
		return base * potencia (base, expoente-1);
	}
}