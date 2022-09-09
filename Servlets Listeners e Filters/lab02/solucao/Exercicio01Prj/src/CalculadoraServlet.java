import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 public class CalculadoraServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
	public CalculadoraServlet() {
		super();
	}   	 	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html><head><title>");
		out.println("Calculadora");
		out.println("</title></head><body>");
		
		out.println("<h1>Resultado</h1>");
		
		String operando1 = request.getParameter("operando1");

		double oper1 = 0.0;
		
		try {
			if(operando1 != null)
				oper1 = Double.parseDouble(operando1);
			else {
				out.println("Favor informar o primeiro operando<br>");
				operando1 = null;
			}
		}
		catch(NumberFormatException e) {
			out.println("Operando 1 inválido<br>");
			operando1 = null;
		}
		
		String operando2 = request.getParameter("operando2");

		double oper2 = 0.0;
		
		try {
			if(operando2 != null)
				oper2 = Double.parseDouble(operando2);
			else {
				out.println("Favor informar o segundo operando<br>");
				operando2 = null;
			}
		}
		catch(NumberFormatException e) {
			out.println("Operando 2 inválido<br>");
			operando2 = null;
		}
		
		String operador = request.getParameter("operador");
		
		if(!("+".equals(operador) || "-".equals(operador) || "*".equals(operador) || "/".equals(operador))) {
			out.println("Operador inválido<br>");
			operador = null;
		}
		
		if("/".equals(operador) && oper2 == 0.0) {
			out.println("Divisão inválida<br>");
			operando2 = null;
		}
		
		
		if(operando1 != null && operando2 != null && operador != null) {
			out.println(oper1 + " " + operador + " " + oper2 + " = ");
			if("+".equals(operador))
				out.println(oper1 + oper2);
			else if("-".equals(operador))
				out.println(oper1 - oper2);
			else if("*".equals(operador))
				out.println(oper1 * oper2);
			else 
				out.println(oper1 / oper2);
			out.println("<br>");
		}
		
		out.println("<br><a href='calculadora.html'>Voltar</a>");
		out.println("</body></html>");
		
	}   	  	    
}