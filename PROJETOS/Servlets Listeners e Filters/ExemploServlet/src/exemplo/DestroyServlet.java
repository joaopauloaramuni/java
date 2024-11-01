package exemplo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DestroyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DestroyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Servlet auxiliar para destruir a sess�o do usu�rio
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		session.invalidate(); // Inv�lida a sess�o do usu�rio
		
		out.println("Sess�o do usu�rio invalidada.");
	}

}
