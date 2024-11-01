package funcao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/funcao")
public class FuncaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FuncaoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Servlet");
		try {
			HttpSession session = request.getSession();
			String precisao = session.getAttribute("precisao").toString(); 
			System.out.println("Precisao: " + precisao);
		}catch(Exception e){
			e.getMessage();
		}
	}

}
