import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private void sendLoginForm(HttpServletResponse response,
			boolean withErrorMessage) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Login</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Login</h1>");

		if (withErrorMessage)
			out.println("<br>Login falhou. Tente novamente.");

		out.println("<br>Informe seu código e senha.");
		out.println("<br><form method=post>");
		out.println("<br>Código: <input type=text name=userName>");
		out.println("<br>Senha: <input type=password name=password>");
		out.println("<br><input type=submit>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null)
			session.invalidate();
		sendLoginForm(response, false);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if (userName != null && password != null && userName.equals("flavio")
				&& password.equals("1234")) {
			HttpSession session = request.getSession();
			session.setAttribute("logado", new Boolean(true));
			response.sendRedirect("potencia");
		} else {
			sendLoginForm(response, true);
		}

	}
}
