package exemplo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IncludeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public IncludeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Servlet de teste: exibe os atributos da requisição
		
		PrintWriter out = response.getWriter();
		out.println("<p>Incluído pelo servlet Include");
		out.println("Parâmetros da requisição");
		Enumeration<String> names = request.getAttributeNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			Object value = request.getAttribute(name);
			out.println("<br>" + name + "/" + value);
		}
	}

}
