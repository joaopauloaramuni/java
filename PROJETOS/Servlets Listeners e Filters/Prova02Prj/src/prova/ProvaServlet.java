package prova;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProvaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Inicialização das Variáveis
	String texto = "";
	String decifrar = "";
	String exibe = "";
	String deslocamento = "";

	// Variável Global
	private String resposta = "";

	// Objeto da classe Cesar
	private Cesar cript = new Cesar();

	// Construtor
	public ProvaServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			// Entrada de Dados
			getData(request);
			int desloc = Integer.parseInt(deslocamento);

			if (cript.validarTexto(texto, deslocamento)
					&& cript.validarDesloc(desloc)) {

				if (decifrar == null) {
					// Criptografar
					resposta = cript.criptografar(texto, desloc);
					if (exibe == null) {
						resposta = "Criptografado com Sucesso!";
					}
				} else if (decifrar != null) {
					// Descriptografar
					resposta = cript.descriptografar(texto, desloc);
					if (exibe == null) {
						resposta = "Descriptografado com Sucesso!";
					}
				}

			} else {
				resposta = "Preencher campos em branco.";
			}
		} catch (NumberFormatException e) {
			resposta = "Valores incorretos.";
		}

		// Impressão do Resultado
		exibirResultado(response, resposta);
	}

	private void getData(HttpServletRequest request) {
		texto = request.getParameter("texto");
		decifrar = request.getParameter("decifrar");
		exibe = request.getParameter("exibe");
		deslocamento = request.getParameter("deslocamento");
	}

	private static void exibirResultado(HttpServletResponse response,
			String resposta) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");

			out.println("<html><head><title>");
			out.println("Prova Resultado");
			out.println("</title></head><body>");
			out.println("<h1>Prova - Resultado</h1>");
			out.println(resposta);
			out.println("<p><a href='html/cripto.html'>Voltar</a></p>");
			out.println("</body></html>");

			out.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
