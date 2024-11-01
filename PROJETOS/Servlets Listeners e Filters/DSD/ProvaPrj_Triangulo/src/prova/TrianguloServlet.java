package prova;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TrianguloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Variável Global
	private String resposta = "";

	public TrianguloServlet() {
		super();
	}

	private void exibe(HttpServletResponse response, String resposta)
			throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.println("<html><head><title>Triangulo</title></head>");
		out.println("<body><h1>Triangulo</h1>");
		out.println("<form method='post'>");
		out.println("<table><tr><td><font face='Courier New'>Lado ( A ) - </font><input type='text' name='Lado_A'/></td></tr>");
		out.println("<tr><td><font face='Courier New'>Lado ( B ) - </font><input type='text' name='Lado_B'/></td></tr>");
		out.println("<tr><td><font face='Courier New'>Lado ( C ) - </font><input type='text' name='Lado_C'/></td></tr></table>");
		out.println("<br><input type='checkbox' name='isosceles' value='true'/><font face='Courier New'>Verificar Isosceles</font><br>");
		out.println("<input type='checkbox' name='equilatero' value='true'/><font face='Courier New'>Verificar Equilatero</font><br>");
		out.println("<input type='checkbox' name='escaleno' value='true'/><font face='Courier New'>Verificar Escaleno</font><br><br>");
		out.println("<input type='submit' value='Processar'/></form>");
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
		resposta = "";
		
		//Lados do triângulo
		int lado_A;
		int lado_B;
		int lado_C;

		try {
			lado_A = Integer.parseInt(request.getParameter("Lado_A"));
			lado_B = Integer.parseInt(request.getParameter("Lado_B"));
			lado_C = Integer.parseInt(request.getParameter("Lado_C"));

			if (lado_A < 0 || lado_B < 0 || lado_C < 0) {
				resposta = "Favor informar inteiros não negativos";
			} else {
				//Definir tipos de verificação
				boolean verificarIsosceles = request.getParameter("isosceles") != null;
				boolean verificarEquilatero = request.getParameter("equilatero") != null;
				boolean verificarEscaleno = request.getParameter("escaleno") != null;
				
				//Processar resultado
				resposta = ""
						+ triangulo(lado_A, lado_B, lado_C, verificarIsosceles,
								verificarEquilatero, verificarEscaleno);
			}
		} catch (NumberFormatException e) {
			resposta = "Valores incorretos.";
		}
		exibe(response, resposta);
	}

	private String triangulo(int lado_A, int lado_B, int lado_C,
			boolean verificarIsosceles, boolean verificarEquilatero,
			boolean verificarEscaleno) {
		
		//Verificar se os lados formam um triângulo
		if (lado_A < (lado_B + lado_C) && lado_B < (lado_A + lado_C)
				&& lado_C < (lado_A + lado_B)) {
			resposta = "Os valores " + lado_A + ", " + lado_B + ", " + lado_C
					+ " formam um triângulo.";
			//Verificar Tipo de Triângulo
			if (verificarIsosceles
					&& ((lado_A == lado_B) || (lado_B == lado_C) || (lado_A == lado_C))) {
				resposta = resposta + "<br>Triângulo Isósceles.";
			}
			if (verificarEquilatero && (lado_A == lado_B) && (lado_B == lado_C)) {
				resposta = resposta + "<br>Triângulo Equilátero.";
			}
			if (verificarEscaleno
					&& (lado_A != lado_B && lado_B != lado_C && lado_A != lado_C)) {
				resposta = resposta + "<br>Triângulo Escaleno.";
			}
			//Fim da verificação
		} else {
			resposta = "Os valores " + lado_A + ", " + lado_B + ", " + lado_C
					+ " não formam um triângulo.";
		}
		return resposta;
	}
}
