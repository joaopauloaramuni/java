
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calculo")
public class CalculoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CalculoServlet() {
		super();
	}

	private void exibe(HttpServletRequest request,
			HttpServletResponse response, String msg) throws ServletException,
			IOException {

		request.setAttribute("msg", msg);
		RequestDispatcher rd = request
				.getRequestDispatcher("WEB-INF/calculo.jsp");
		rd.forward(request, response);
	}

	private Resultado exponencial(double x, double precisao){
		
		double expo = 1.0;
		double numerador = x;
		double denominador = 1;
		int cont = 1;
		double termo = numerador / denominador;
		
		while(termo > precisao){
			expo += termo;
			numerador *= x;
			denominador *= ++cont;
			termo = numerador / denominador;
		}
		
		return new Resultado(expo, cont);
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		exibe(request, response, "");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		double precisao = (Double)session.getAttribute("precisao");
		
		String msg = "";
		
		try {
			double x = Double.parseDouble(request.getParameter("x"));
			if(x < 0.0){
				msg = "Valor inválido (deve ser não negativo)";
			}else {
				Resultado r = exponencial(x, precisao);
				int termos = (Integer)session.getAttribute("termos");
				session.setAttribute("termos", termos+r.getTermos());
				msg = "Exp(" + x + ") = " + r.getExpo() + " (Número de termos = " + r.getTermos() + ")";
			}
			
		} catch (NumberFormatException e) {
			msg = "Favor informar um número real não negativo";
		}

		exibe(request, response, msg);
	}

}

class Resultado{
	private double expo;
	private int termos;
	
	public Resultado(double expo, int termos) {
		super();
		this.expo = expo;
		this.termos = termos;
	}

	public double getExpo() {
		return expo;
	}

	public int getTermos() {
		return termos;
	}
	
}