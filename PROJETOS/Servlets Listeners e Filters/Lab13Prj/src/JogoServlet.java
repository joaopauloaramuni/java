

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/jogo")
public class JogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JogoServlet() {
        super();
    }
    
	private void exibe(HttpServletRequest request,
			HttpServletResponse response, String resposta) throws ServletException,
			IOException {
		
		request.setAttribute("resposta", resposta);
		
		RequestDispatcher rd = request
				.getRequestDispatcher("WEB-INF/jogo.jsp");
		rd.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		HttpSession session = request.getSession();
		
		//Recria a sessão
		session.invalidate();
		session = request.getSession();
		//
		int numero = (int)(Math.random()*1023)+1;
		session.setAttribute("num", numero);
		System.out.println(numero);
		exibe(request, response, "");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resposta = "";
		HttpSession session = request.getSession();
		
		int contMenor = Integer.parseInt(session.getAttribute("contMenor").toString());
		int contMaior = Integer.parseInt(session.getAttribute("contMaior").toString());
		
		try{
			String lance = request.getParameter("lance");
			if(lance.equals("") ||  !lance.matches("[0-9]*")){
				resposta = "Lance inválido!";
			}else{
				int num = Integer.parseInt(session.getAttribute("num").toString());
				int numLance = Integer.parseInt(lance);
				if(numLance < num){
					resposta = "O número informado é inferior ao escolhido.";
					contMenor = contMenor +1;
					session.setAttribute("contMenor", contMenor);
				}else if (numLance > num){
					resposta = "O número informado é superior ao escolhido.";
					contMaior = contMaior +1;
					session.setAttribute("contMaior", contMaior);
				}
				else if (numLance == num){
					int tentativa = contMenor + contMaior + 1;
					int tentativaAnterior = Integer.parseInt(session.getAttribute("numMenor").toString());
					
					if (tentativa <= tentativaAnterior){
						session.setAttribute("numMenor", tentativa);
					}
					
					resposta = "Sucesso! O jogador adivinhou o número escolhido." +
							" Número de Tentativas: " + (tentativa);
				}
			}
			
		}catch(Exception e){
			e.getMessage();
		}
		
		exibe(request, response, resposta);
	}

}
