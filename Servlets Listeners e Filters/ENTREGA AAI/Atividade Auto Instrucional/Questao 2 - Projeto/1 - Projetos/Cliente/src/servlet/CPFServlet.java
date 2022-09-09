package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cliente.ValidadorCPF;
import cliente.ValidadorCPFImplService;

/**
 * Servlet implementation class CPFServlet
 */
public class CPFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//localHost
	static {
	    javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
	    new javax.net.ssl.HostnameVerifier(){
 
	        public boolean verify(String hostname,
	                javax.net.ssl.SSLSession sslSession) {
	            if (hostname.equals("localhost")) {
	                return true;
	            }
	            return false;
	        }
	    });
	}
	
	/**
	 * Default constructor.
	 */
	public CPFServlet() {
		super();
	}

	private void exibe(HttpServletRequest request,
			HttpServletResponse response, String resposta)
			throws ServletException, IOException {

		request.setAttribute("resposta", resposta);

		RequestDispatcher rd = request
				.getRequestDispatcher("WEB-INF/Aplicacao.jsp");
		rd.forward(request, response);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		exibe(request, response, "");
	}

	protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		ValidadorCPFImplService service = new ValidadorCPFImplService();
		ValidadorCPF validaObj = service.getValidadorCPFImplPort();
		String cpf = request.getParameter("cpf");
		exibe(request, response, validaObj.validaCPF(cpf));
	}
}
