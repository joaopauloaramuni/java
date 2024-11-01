

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
	
	private void exibeTela(HttpServletResponse response, String msg) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html><head><title>");
		out.println("Calculadora");
		out.println("</title></head><body>");
		out.println("<h1>Calculadora</h1>");
		out.println("<form action='calculadora' method='post'>");
		out.println("<input type='text' name='operando1'>");
		out.println("<select name='operador'>");
		out.println("<option>+</option>");
		out.println("<option>-</option>");
		out.println("<option>*</option>");
		out.println("<option>/</option>");
		out.println("</select>");
		out.println("<input type='text' name='operando2'>");
		out.println("<input type='submit'>");
		out.println("</form><br>");
		out.println(msg);
		out.println("</body></html>");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		exibeTela(response, "");
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operando1 = request.getParameter("operando1");

		double oper1 = 0.0;
		
		try {
			if(operando1 != null)
				oper1 = Double.parseDouble(operando1);
			else {
				exibeTela(response, "Favor informar o primeiro operando");
				return;
			}
		}
		catch(NumberFormatException e) {
			exibeTela(response, "Operando 1 inválido<br>");
			return;
		}

		String operando2 = request.getParameter("operando2");

		double oper2 = 0.0;
		
		try {
			if(operando2 != null)
				oper2 = Double.parseDouble(operando2);
			else {
				exibeTela(response, "Favor informar o segundo operando<br>");
				return;
			}
		}
		catch(NumberFormatException e) {
			exibeTela(response, "Operando 2 inválido<br>");
			return;
		}
		
		String operador = request.getParameter("operador");
		
		if(!("+".equals(operador) || "-".equals(operador) || "*".equals(operador) || "/".equals(operador))) {
			exibeTela(response, "Operador inválido<br>");
			return;
		}
		
		if("/".equals(operador) && oper2 == 0.0) {
			exibeTela(response, "Divisão inválida<br>");
			return;
		}

		String resultado = oper1 + " " + operador + " " + oper2 + " = ";
		if("+".equals(operador))
			resultado += (oper1 + oper2);
		else if("-".equals(operador))
			resultado += (oper1 - oper2);
		else if("*".equals(operador))
			resultado += (oper1 * oper2);
		else 
			resultado += (oper1 / oper2);
		
		exibeTela(response, resultado);
	}   	  	    
}