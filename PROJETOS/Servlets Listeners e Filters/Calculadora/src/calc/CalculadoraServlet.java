package calc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculadoraServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    public CalculadoraServlet() {
        super();
       
    }
    private long soma(int x, int y){
    	
    	return x + y;
    }
    private long sub(int x, int y){
    	
    	return x - y;
    }
    private long mult(int x, int y){
    	
    	return x * y;
    }
    private long div(int x, int y){
    	
    	return x / y;
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String resposta = "";
		
		//Obtenção do dado informado pelo usuário
		try{
			int x = Integer.parseInt(request.getParameter("x"));
			int y = Integer.parseInt(request.getParameter("y"));
			String op = request.getParameter("operador");
			
			if(x < 0 || y < 0)
				resposta = "Favor informar inteiros não negativos";
			else{
				if(op.equals("soma")){
					resposta = "Soma = " + soma(x,y);
				}else if(op.equals("sub")){
					resposta = "Subtração = " + sub(x,y);
				}
				else if(op.equals("mult")){
					resposta = "Multiplicação = " + mult(x,y);
				}
				else if(op.equals("div")){
					resposta = "Divisão = " + div(x,y);
				}
			}
		}
		catch(NumberFormatException e){
			resposta = "Favor informar valores numéricos";
		}
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html><head><title>");
		out.println("Calculadora");
		out.println("</title></head><body>");
		out.println("<h1>Calculadora</h1>");
		out.println(resposta);
		out.println("<p><a href='html/calc.html'>Voltar</a></p>");
		out.println("</body></html>");
		
		out.close();
	}
}
