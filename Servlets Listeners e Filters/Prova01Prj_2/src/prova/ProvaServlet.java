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
	String resposta = "";
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
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	
    	PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		resposta = "";
		out.println(Cabecalho());
		out.println(Entrada());
		out.println(Rodape());
		out.close();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		out.println(Cabecalho());
		out.println(Saida(resposta));
		out.println(Rodape());
		
		out.close();
	}
	
	private String Cabecalho(){

		String cab = "<html><head><title>" + 
		"Viagem</title></head><body> " + 
		"<h1>Entrada de dados</h1>" +
		"<form method='post'> ";
		
		return cab;
	}
	private String Rodape(){

		String rod = "</form></body></html>";
		
		return rod;
	}
	private String Entrada(){
		String ent = "Diatância (km): <input type='text' name='distancia'/>" +
    	"<br>Velocidade média (km/h): <input type='text' name='velocidade'/>" +
    	"<p>Calcular consumo? <input type='checkbox' name='calcular'/>" +
    	"<br>Consumo médio (km/l): <input type='text' name='consumo'/>" +
    	"<br>Tipo de combustível:" +
    	"<select name='combustivel'>" +
    	"<option value='G'>Gasolina</option>" +
    	"<option value='A'>Álcool</option>" +
    	"<option value='D'>Diesel</option>" +
    	"</select><p><input type='submit'/></p>";
		
		return ent;
	}
	private String Saida(String resposta){
		String resp = resposta + "<br>" + 
		"<p><a href='ProvaServlet'>Voltar</a></p>";
		return resp;
	}
}
