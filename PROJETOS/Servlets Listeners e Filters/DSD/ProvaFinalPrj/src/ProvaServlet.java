
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/prova")
public class ProvaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProvaServlet() {
		super();

	}

	private void exibe(HttpServletRequest request,
			HttpServletResponse response, String resposta)
			throws ServletException, IOException {

		request.setAttribute("resposta", resposta);

		RequestDispatcher rd = request
				.getRequestDispatcher("WEB-INF/prova.jsp");
		rd.forward(request, response);
	}
	
	private void gerarExpressao(HttpServletRequest request , int nivel)  throws ServletException, IOException{
		Expressao e = new Expressao();
		e.generatePuzzleExpression(nivel);
		String expr = e.getPuzzleExpression();
		
		HttpSession session = request.getSession();
		session.setAttribute("e", e);	
		session.setAttribute("exp", expr);	
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Recria a sess�o
		HttpSession session = request.getSession();
		session.invalidate();
		session = request.getSession();
		//

		int nivel = Integer.parseInt(session.getAttribute("nivel").toString());
		gerarExpressao(request, nivel);
		String expr = session.getAttribute("exp").toString();
		
		exibe(request, response, expr + " <br>N�vel: " + nivel);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String resposta = "";
		try {
			HttpSession session = request.getSession();
			Expressao e = (Expressao)session.getAttribute("e");

			String operador = request.getParameter("operador");
			boolean resultado = e.isCorrect(operador);

			int acertos = Integer.parseInt(session.getAttribute("acertos")
					.toString());
			int erros = Integer.parseInt(session.getAttribute("erros")
					.toString());

			if (resultado) {
				acertos++;
				session.setAttribute("acertos", acertos);
				resposta = "Correto ! <br>";
			} else {
				erros++;
				session.setAttribute("erros", erros);
				resposta = "Incorreto ! <br>";
			}
			
			// Exibir Acertos e Erros
			resposta = resposta + " Acertos: " + acertos + " Erros: " + erros;
			
			// Gerar nova express�o
			int nivel = Integer.parseInt(session.getAttribute("nivel").toString());
			
			// Atualizando nivel para gera��o de nova express�o
			if(erros == 2 && nivel > 1){
				nivel--;
			}
			if(acertos == 2 && nivel < 3){
				nivel++;
			}
			gerarExpressao(request, nivel);
			String expr = session.getAttribute("exp").toString();
			
			// Exibir nova Express�o
			resposta = resposta + "<br><br>Nova Express�o: " + expr;
			
			// Exibir nivel
			resposta = resposta + "<br>N�vel: " + nivel;

		} catch (Exception e) {
			resposta = e.getMessage();
		}

		exibe(request, response, resposta);
	}

}
