package prova;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProvaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int GASOLINA;
	private int ALCOOL;
	private int DIESEL;
	
    public ProvaServlet() {
        super();
    }
	
    @Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		
		//Recuperação de parâmetros de inicialização
		try{
			GASOLINA = Integer.parseInt(config.getInitParameter("Gasolina"));	
			ALCOOL = Integer.parseInt(config.getInitParameter("Álcool"));
			DIESEL = Integer.parseInt(config.getInitParameter("Diesel"));
			
		}catch(NumberFormatException e){
			GASOLINA = 2;
			ALCOOL = 1;
			DIESEL = 3;
		}
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String resposta = "";
		//Obtenção do dado informado pelo usuário
		try{
			int distancia = Integer.parseInt(request.getParameter("distancia"));
			int velocidade = Integer.parseInt(request.getParameter("velocidade"));
			int sair = 0;
			int calcular = 0;
			int consumo = 1;
			int custo = 0;
			String preco = request.getParameter("combustivel");
			
			if(distancia < 0 || velocidade < 0){
				resposta = "Favor informar inteiros não negativos";
				sair = 1;
			}
			else if(request.getParameter("calcular") != null){
	
				consumo = Integer.parseInt(request.getParameter("consumo"));
				if(consumo < 0){
					resposta = "Favor informar inteiros não negativos";
					sair = 1;
				}else calcular = 1;
			}

			if(sair == 0){
				double tempo = distancia/velocidade;
				resposta = "<p>Tempo : " + tempo + " hora(s)";
				if(calcular == 1){
					if (preco.equals("G")){
						custo = (distancia/consumo) * GASOLINA;
					}else if(preco.equals("A")){
						custo = (distancia/consumo) * ALCOOL;
					}else if(preco.equals("D")){
						custo = (distancia/consumo) * DIESEL;
					}
					resposta = resposta + "<p>Custo com combustível : " + custo + " reais";
				}
			}
		}
		catch(NumberFormatException e){
			resposta = "Favor informar valores numéricos";
		}
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html><head><title>");
		out.println("Prova Resposta");
		out.println("</title></head><body>");
		out.println("<h1>Prova - Resposta</h1>");
		out.println(resposta);
		out.println("<p><a href='html/viagem.html'>Voltar</a></p>");
		out.println("</body></html>");
		
		out.close();
	}

}
