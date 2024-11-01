package fibo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ErroServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html><head><title>");
		out.println("Erro");
		out.println("</title></head><body>");
		out.println("<h1>Erro</h1>");
		out.println("<p>Erro de Chave!</p>");
		out.println("<br><a href='fibonacci'>Voltar</a>");
		out.println("</body></html>");

		out.close();
	}

}
