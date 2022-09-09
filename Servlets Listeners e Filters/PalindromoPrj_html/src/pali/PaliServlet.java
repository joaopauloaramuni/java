package pali;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PaliServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PaliServlet() {
		super();
	}

	private void exibe(HttpServletResponse response, String resposta)
			throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.println("<html><head><title>Palindromo</title></head>");
		out.println("<body><h1>Palíndromo - Resposta</h1>");
		out.println(resposta);
		out.println("<p><a href='html/Palindromo.html'>Voltar</a></p>");
		out.println("</body></html>");

		out.close();

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String texto = request.getParameter("texto");
		String resposta = "";
		Palindromo palindromo = new Palindromo();
		
		if(texto.equals("")){
			resposta = "Favor informar o texto a ser verificado.";
			exibe(response, resposta);
			return;
		}
		try {
			if(palindromo.pali(texto)){
				resposta = "É palíndromo!";
			}else resposta = "Não é palíndromo!";

		} catch (Exception e) {
			resposta = "Texto inválido.";
		}
		exibe(response, resposta);
	}

}
