import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FatorialServlet extends HttpServlet {
  private static final String ERRO = "Favor informar um inteiro positivo";
  
  private long fat (int n) {
    if (n <= 1)
      return 1;
      
    long res = 1;
    for (int i=n; i >=2; i--)
      res *= i;
      
    return res;
  }
  
  public void doPost (HttpServletRequest request,
                     HttpServletResponse response) 
              throws ServletException, IOException {

    PrintWriter out;
    response.setContentType("text/html");
    out = response.getWriter();
    
    String resposta = "";
    int n=0;
    String numero = request.getParameter("entrada");
    if (numero == null)
      resposta = ERRO;
    else
      try {
        n = Integer.parseInt(numero);
	if (n < 0)
	  resposta = ERRO;
	else
	  resposta = "Resultado: " + fat(n);
      }
      catch (NumberFormatException e) {
        resposta = ERRO;
      }
      
    out.println("<html><head><title>");
    out.println("Calculo de Fatorial");
    out.println("</title></head><body>");
    out.println("<h1>Calculo de Fatorial</h1>");
    out.println("<p>" + resposta + "</p>");
    out.println("<a href=\"../fatorial.html\">Voltar</a>");
    out.println("</body></html>");
    out.close();
  }
}