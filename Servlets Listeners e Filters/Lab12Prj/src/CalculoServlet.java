import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calculo")
public class CalculoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CalculoServlet() {
		super();
	}
	
	private void exibe(HttpServletRequest request,
			HttpServletResponse response, String resposta) throws ServletException,
			IOException {

		request.setAttribute("resposta", resposta);
		RequestDispatcher rd = request
				.getRequestDispatcher("WEB-INF/calculo.jsp");
		rd.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		exibe(request, response, "");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		exibe(request, response, resposta(request));
	}

	private int calcular(int n) {

		if (n == 1) {
			return 0;
		} else if (n == 2 || n == 3) {
			return 1;
		} else {
			return calcular(n - 1) + 2 * calcular(n - 3);
		}

	}
	
	private String resposta(HttpServletRequest request) throws ServletException, IOException{
		
		HttpSession session = request.getSession();
		String resp = "";
		int cont;
		if (session.getAttribute("cont") == null) {
			session.setAttribute("cont", 1);
		}
		if (session.getAttribute("acerto") == null) {
			session.setAttribute("acerto", 0);
		}
		if (session.getAttribute("errado") == null) {
			session.setAttribute("errado", 0);
		}
		int certo = Integer.parseInt(session.getAttribute("acerto").toString());
		int errado = Integer.parseInt(session.getAttribute("errado").toString());
		
		try {
			cont = Integer.parseInt(session.getAttribute("cont").toString());
			
			int termo = Integer.parseInt(request.getParameter("termo"));

			if (calcular(cont) == termo) {
				resp = "Correto!";
				session.setAttribute("acerto", ++certo);
				session.setAttribute("cont", ++cont);
			} else{
				resp = "Incorreto!";
				session.setAttribute("errado", ++errado);
			}
		} catch (Exception e) {
			e.getMessage();
		}

		resp = resp + "<br>Número de acertos: " + session.getAttribute("acerto") + "<br>Número de erros: " + session.getAttribute("errado");
		
		return resp;
	}
}
