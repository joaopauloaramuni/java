package gerar;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GerarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String cpf = "";
	private String cnpj = "";
	private String pis = "";

	public GerarServlet() {
		super();
	}

	private void exibe(HttpServletResponse response, String resposta)
			throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.println("<html><head><title>Gerar Servlet</title></head>");
		out.println("<body><h1>Gerar</h1>");
		out.println("<form method='post'>");
		out.println("<table><tr><td>CPF:</td><td><input type='text' name='cpf' value='" + cpf + "'/></td></tr>");
		out.println("<tr><td>CNPJ:</td><td><input type='text' name='cnpj' value='" + cnpj + "'/></td></tr>");
		out.println("<tr><td>PIS:</td><td><input type='text' name='pis' value='" + pis + "'/></td></tr>");
		out.println("<tr><td><br><input type='submit' value='Gerar'/></td></tr></table></form>");
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

		Gerar gerar = new Gerar();
		Constantes constantes = new Constantes();
		String resposta = "";
		try {
			cpf = gerar.gerarDados(constantes.VALIDA_CPF, constantes.CPF_LENGTH);
			cnpj = gerar.gerarDados(constantes.VALIDA_CNPJ, constantes.CNPJ_LENGTH);
			pis = gerar.gerarDados(constantes.VALIDA_PIS, constantes.PIS_LENGTH);

		} catch (Exception ex) {
			resposta = "Valores incorretos.";
		}
		exibe(response, resposta);
	}

}
