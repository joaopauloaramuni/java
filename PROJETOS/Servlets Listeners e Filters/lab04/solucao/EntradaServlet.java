

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 public class EntradaServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	public EntradaServlet() {
		super();
	}   	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = null;
		response.setContentType("text/html");
		out = response.getWriter();
		
		out.println("<html><head><title>");
		out.println("Entrada de dados");
		out.println("</title></head><body>");
		out.println("<h2>Favor informar seu nome</h2>");

		out.println("<form method=\"post\" action=\"resultado\">");
		out.println("Nome: <input type=\"text\" name=\"nome\"/>");
		out.println("<br>Sobrenome: <input type=\"text\" name=\"sobrenome\"/>");
		out.println("<br><input type=\"submit\" value=\"Ok\"/>");
		out.println("</form>");
	}  	  	  	    
}