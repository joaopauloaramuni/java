package lab04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 public class ResultadoServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	public ResultadoServlet() {
		super();
	}   	 	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = null;
		response.setContentType("text/html");
		out = response.getWriter();
		
		out.println("<html><head><title>");
		out.println("Resultado");
		out.println("</title></head><body>");
		out.println("<h2>Nome informado</h2>");
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		out.println("Nome: " + nome + " " + sobrenome +
				" (tamanho: " + (nome.length() + sobrenome.length()) + ")");
		
		out.println("<h2>Nome modificado</h2>");
		String nomemod = (String)request.getAttribute("nome");
		String sobrenomemod = (String)request.getAttribute("sobrenome");
		out.println("Nome: " + nomemod + " " + sobrenomemod +
				" (tamanho: " + (nomemod.length() + sobrenomemod.length()) + ")");
		
		out.println("<br><a href=\"entrada\">Voltar</a>");
	}   	  	    
}