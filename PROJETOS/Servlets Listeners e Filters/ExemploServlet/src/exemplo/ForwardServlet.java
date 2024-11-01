package exemplo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ForwardServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// N�o � permitido redirecionar com forward ap�s a gera��o
		// de qualquer sa�da para o cliente
		// PrintWriter out = response.getWriter();
		// out.println("Sa�da gerada pelo servlet Forward");
		// out.flush();

		// Grava atributo para teste do redirecionamento
		request.setAttribute("redirecionado", 1);

		// Redireciona (definitivamente) a requisi��o para outro componente
		RequestDispatcher rd = request.getRequestDispatcher("exemplo");
		rd.forward(request, response);
	}

}
