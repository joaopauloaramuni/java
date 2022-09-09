

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 public class AlertaServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;
	private static final int MAX_SESSAO = 1;

	public AlertaServlet() {
		super();
	}   	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out;
		response.setContentType("text/html");
		out = response.getWriter();
		out.println("<html><head><title>");
		out.println("Servlet Alerta");
		out.println("</title></head><body>");
		out.println("<h1>Alerta!</h1>");
		
		HttpSession session = request.getSession();
		int sessoes = ((Integer) session.getServletContext().getAttribute("sessoes")).intValue();
		if (sessoes > MAX_SESSAO) {
			out.println("Número máximo de usuários atingido");
			session.invalidate();
		}
		else {
			int cor = ((Integer) session.getAttribute("cor")).intValue();
			cor = (cor+1) % 3;
			switch (cor) {
			case 0: out.println("<font color=\"green\">Alerta verde</font>"); break;
			case 1: out.println("<font color=\"yellow\">Alerta amarelo</font>"); break;
			case 2: out.println("<font color=\"red\">Alerta vermelho</font>"); break;
			default: out.println("Cor inválida");
			}
			session.setAttribute("cor",new Integer(cor));
		}
		
		out.println("</body></html>");
		out.close();
	}  	  	  	    
}