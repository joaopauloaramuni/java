package validacao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ValidarServlet() {
		super();
	}

	private void exibe(HttpServletResponse response, String resposta)
			throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.println("<html><head><title>Validar Servlet</title></head>");
		out.println("<body><h1>Validar</h1>");
		out.println("<form method='post'>");
		out.println("<table><tr><td><input type='text' name='texto'/></td>");
		out.println("<td><select name='tipo'><option value='cpf'>CPF</option>");
		out.println("<option value='cnpj'>CNPJ</option>");
		out.println("<option value='pis'>PIS</option>");
		out.println("<option value='email'>EMAIL</option>");
		out.println("</select></td></tr>");
		out.println("<tr><td><input type='submit' value='Validar'/></td></tr></table></form>");
		out.println(resposta);
		out.println("</body></html>");

		out.close();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		exibe(response, "");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String resposta = "";
		Validar validar = new Validar();

		String texto = request.getParameter("texto");
		if (texto.trim().isEmpty()) {
			resposta = "Favor informar o número a ser verificado.";
			exibe(response, resposta);
			return;
		}
		try {
			String tipo = request.getParameter("tipo");
			if (tipo.equals("cpf")) {
				resposta = validar.validarCPF(texto);
			} else if (tipo.equals("cnpj")) {
				resposta = validar.validarCNPJ(texto);
			} else if (tipo.equals("pis")) {
				resposta = validar.validarPIS(texto);
			} else if (tipo.equals("email")) {
				resposta = validar.validarEMAIL(texto);
			}
		} catch (Exception e) {
			resposta = "Valores incorretos.";
		}
		exibe(response, resposta);
	}

}
