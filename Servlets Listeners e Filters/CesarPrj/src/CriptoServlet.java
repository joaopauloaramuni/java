

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CriptoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CriptoServlet() {
        super();
    }
    
    private void exibe(HttpServletResponse response, String resposta) throws IOException {
    	PrintWriter out = response.getWriter();
    	response.setContentType("text/html");
    	
    	out.println("<html><head><title>Criptografia</title></head>");
    	out.println("<body><h1>Criptografia</h1>");
    	out.println("<form method='post'><table><tr><td>Texto a criptografar</td>");
    	out.println("<td><textarea name='texto' cols=40 rows=10/></textarea></td></tr>");
    	out.println("<tr><td>Deslocamento</td>");
    	out.println("<td><input type='text' name='deslocamento'/></td></tr>");
    	out.println("<tr><td>Decifrar?</td>");
    	out.println("<td><input type='checkbox' name='decifrar' value='true'/></td></tr>");
        out.println("<tr><td>Exibe texto?</td>");
    	out.println("<td><input type='checkbox' name='exibe' value='true'/></td></tr>");
    	out.println("</table><br><input type='submit'></form>");
        out.println(resposta);
    	out.println("</body></html>");
    	
    	out.close();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		exibe(response, "");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String resposta = "";
		Cesar cesar = new Cesar();
		
		String texto = request.getParameter("texto");
		if(texto.trim().isEmpty()) {
			resposta = "Favor informar o texto a criptografar";
			exibe(response, resposta);
			return;
		}
		
		int deslocamento;
		try {
			deslocamento = Integer.parseInt(request.getParameter("deslocamento"));
			if(deslocamento < 1 || deslocamento > cesar.getLength()-1) {
				resposta = "Deslocamento deve estar entre 1 e " + (cesar.getLength()-1);
				exibe(response, resposta);
				return;
			}
		}
		catch (NumberFormatException e) {
			resposta = "Deslocamento deve ser numérico";
			exibe(response, resposta);
			return;
		}
		
		boolean exibe = request.getParameter("exibe") != null;
		boolean decifrar = request.getParameter("decifrar") != null;
		
		if(exibe)
			resposta = "Texto original: " + texto + "<br>";
		
		resposta += cesar.converte(texto, deslocamento, decifrar);
		
		exibe(response, resposta);
	}

}
