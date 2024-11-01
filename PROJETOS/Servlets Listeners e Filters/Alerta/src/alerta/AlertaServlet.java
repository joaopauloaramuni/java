package alerta;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AlertaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final int MAXIMO_USUARIOS = 5;
	private int maximoUsuarios = 0;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		try {
			maximoUsuarios = Integer.parseInt(config
					.getInitParameter("maximoUsuarios"));
			if (maximoUsuarios < 1)
				maximoUsuarios = MAXIMO_USUARIOS;
		} catch (NumberFormatException e) {
			maximoUsuarios = MAXIMO_USUARIOS;
		}
	}

	public AlertaServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out;
		response.setContentType("text/html");
		out = response.getWriter();
		out.println("<html><head><title>");
		out.println("Servlet Alerta");
		out.println("</title></head><body>");
		out.println("<h1>Alerta!</h1>");

		HttpSession session = request.getSession();

		int sessoes = (Integer) getServletContext().getAttribute("sessoes");

		if (sessoes > maximoUsuarios) {
			// out.println("Sessões = " + sessoes);
			out.println("Número máximo de usuários atingido");
			session.invalidate();
		} else {
			int cor = (Integer) session.getAttribute("cor");
			cor = (cor + 1) % 3;
			session.setAttribute("cor", cor);

			switch (cor) {
			case 0: {
				out.println("<font color='green'>Alerta verde</font>");
				break;
			}
			case 1: {
				out.println("<font color='yellow'>Alerta amarelo</font>");
				break;
			}
			default:
				out.println("<font color='red'>Alerta vermelho</font>");
				break;
			}
		}
		out.println("</body></html>");
		out.close();

	}

}
