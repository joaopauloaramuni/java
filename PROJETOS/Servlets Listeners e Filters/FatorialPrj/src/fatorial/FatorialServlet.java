package fatorial;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FatorialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    
	public FatorialServlet() {
        super();
       
    }
    
    private long fatorial(int n){
    	if(n < 2)
    		return 1;
    	
    	long resultado = 1;
    	
    	for(int i = n; i>=2; i--)
    		resultado *= i;
    	
    	return resultado;
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String resposta = "";
		
		//Obten��o do dado informado pelo usu�rio
		try{
			int numero = Integer.parseInt(request.getParameter("numero"));
			
			if(numero < 0)
				resposta = "Favor informar inteiros n�o negativos";
			else
				resposta = "Fatorial = " + fatorial(numero);
		}
		catch(NumberFormatException e){
			resposta = "Favor informar valores num�ricos";
		}
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html><head><title>");
		out.println("Fatorial - resposta");
		out.println("</title></head><body>");
		out.println("<h1>Fatorial - resposta</h1>");
		out.println(resposta);
		out.println("<p><a href='html/fat.html'>Voltar</a></p>");
		out.println("</body></html>");
		
		out.close();
	}

}
