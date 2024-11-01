package exemplo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RedirectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Grava atributo de requisição para teste do redirecionamento
		// Este atributo *não* chegará ao servlet exemplo
		request.setAttribute("sendredirect", 1);
		
		// Faz um redirecionamento externo para o servlet de exemplo
		response.sendRedirect("exemplo");
	}

}
