package data;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DataServlet
 */
@WebServlet("/data")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String erro = "";

	public DataServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Redireciona (definitivamente) a requisição para outro componente
		request.setAttribute("redirecao", "Redirecionado via forward - GET");
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/data.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			int dia = Integer.parseInt(request.getParameter("dia"));
			int mes = Integer.parseInt(request.getParameter("mes"));
			int ano = Integer.parseInt(request.getParameter("ano"));

			if (CalculoDatas.valida(dia, mes, ano)) {

				GregorianCalendar posterior = new GregorianCalendar(ano, mes,
						dia);
				GregorianCalendar auxiliar = new GregorianCalendar();

				ano = auxiliar.get(GregorianCalendar.YEAR);
				mes = auxiliar.get(GregorianCalendar.MONTH) + 1;
				dia = auxiliar.get(GregorianCalendar.DAY_OF_MONTH);

				GregorianCalendar anterior = new GregorianCalendar(ano, mes, dia);

				int valor = CalculoDatas.diferenca(posterior, anterior);

				request.setAttribute("mensagem", "Dias até a formatura: "
						+ valor);
				request.setAttribute("redirecao",
						"Redirecionado via forward - POST");

				// Redireciona (definitivamente) a requisição para outro
				// componente
				RequestDispatcher rd = request
						.getRequestDispatcher("WEB-INF/data.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			erro = e.getMessage();
		}
		if (erro.equals("")) {
			request.setAttribute("redirecao",
					"Redirecionado via forward - POST");
		} else {
			request.setAttribute("erro", erro);
			// Redireciona (definitivamente) a requisição para outro componente
			RequestDispatcher rd = request
					.getRequestDispatcher("WEB-INF/erro.jsp");
			rd.forward(request, response);
		}

	}
}
