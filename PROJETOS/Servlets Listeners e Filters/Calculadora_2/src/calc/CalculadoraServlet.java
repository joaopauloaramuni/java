package calc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculadoraServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
    private String resposta = "";
    
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
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	
    	PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		resposta = "";
		out.println(Formulario());
		out.close();
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Obten��o do dado informado pelo usu�rio
		try{
			int x = Integer.parseInt(request.getParameter("x"));
			int y = Integer.parseInt(request.getParameter("y"));
			String op = request.getParameter("operador");
			
			if(x < 0 || y < 0)
				resposta = "Favor informar inteiros n�o negativos";
			else{
				if(op.equals("soma")){
					resposta = "Soma = " + soma(x,y);
				}else if(op.equals("sub")){
					resposta = "Subtra��o = " + sub(x,y);
				}
				else if(op.equals("mult")){
					resposta = "Multiplica��o = " + mult(x,y);
				}
				else if(op.equals("div")){
					resposta = "Divis�o = " + div(x,y);
				}
			}
		}
		catch(NumberFormatException e){
			resposta = "Favor informar valores num�ricos";
		}
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
	
		out.println(Formulario());
		out.close();
	}
   
    private String Formulario(){
    	String form = "<html><head><title>" + 
    	"Calculadora</title></head><body> " + 
    	"<h1>Calculadora</h1>" +
    	"<form method='post'> " +
    	"<input type='text' name='x'/>" +
    	"<br><input type='text' name='y'/><br><br>" +
    	"<select name='operador'><option value='soma'>Somar</option> " + 
    	"<option value='sub'>Subtrair</option> " +
    	"<option value='mult'>Multiplicar</option>" + 
    	"<option value='div'>Dividir</option>" + 
    	"</select><br><br>" +
    	"<br><br>"+
    	"<input type='submit' value='Calcular'/>" +
    	"</form> </body></html>" + resposta;
    	
    	return form;
    }
}
