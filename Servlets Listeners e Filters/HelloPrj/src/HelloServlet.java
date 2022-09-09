

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HelloServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		if(nome == null || nome.trim().isEmpty()) {
			nome = "Mundo";
		}
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html><head><title>");
		out.println("Servlet exemplo - resposta");
		out.println("</title></head><body>");
		out.println("<h1>Resposta exemplo</h1>");
		out.println("Olá " + nome);
		out.println("<p><a href='hello.html'>Voltar</a>");
		out.println("</body></html>");
		
		out.close();
	}

}
