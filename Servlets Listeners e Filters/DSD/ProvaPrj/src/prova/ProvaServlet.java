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
	private int K;
	private int APROVACAO;
	
    public ProvaServlet() {
        super();

    }
    @Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		
		//Recuperação de parâmetros de inicialização
		try{
			K = Integer.parseInt(config.getInitParameter("k"));	
			APROVACAO = Integer.parseInt(config.getInitParameter("Aprovação"));	
			
		}catch(NumberFormatException e){
			K = 1;
			APROVACAO = 60;
		}
	}
    
	private void exibe(HttpServletResponse response, String resposta)
			throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.println("<html><head><title>Nota Final</title></head>");
		out.println("<body><h1>Cálculo de Nota Final</h1>");
		out.println("<form method='post'><table><tr>");
		out.println("<td><font face='Arial'>Primeira prova:</font></td>");
		out.println("<td><input type='text' name='texto1' /></td></tr>");
		out.println("<tr><td><font face='Arial'>Segunda prova prova:</font></td>");
		out.println("<td><input type='text' name='texto2' /></td></tr>");
		out.println("<tr><td><font face='Arial'>Considerar prova especial?</font></td>");
		out.println("<td><input type='checkbox' name='especial' value='true'/></td></tr>");
		out.println("<tr><td><font face='Arial'>Prova Especial:</font></td>");
		out.println("<td><input type='text' name='texto3' /></td></tr>");
		out.println("<tr><td><br><input type='submit' value='Enviar' /></td></tr>");
		out.println("</table></form>");
		out.println(resposta);
		out.println("</body></html>");

		out.close();

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		exibe(response, "");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prova1 = request.getParameter("texto1");
		String prova2 = request.getParameter("texto2");
		String resposta = "";
		if(prova1.equals("") || prova2.equals("")){
			resposta = "Favor informar as notas.";
			exibe(response,resposta);
			return;
		}
		if(!prova1.matches("[0-9]*") || !prova2.matches("[0-9]*")){
			resposta = "Informe apenas valores numéricos.";
			exibe(response,resposta);
			return;
		}
		try{
			//Obtenção do dado informado pelo usuário
			int p1 = Integer.parseInt(prova1);
			int p2 = Integer.parseInt(prova2);
			String especial = request.getParameter("especial");
			
			//Nota Final
			int nf = 0;
			//Nota Especial
			int ne = 0;
			
			//Consistir nota da primeira prova
			if(p1 < 0 || p1 > 100){
				resposta = "Nota da primeira prova deve estar entre 0 e 100.";
				exibe(response,resposta);
				return;
			}
			//Consistir nota da segunda prova
			if(p2 < 0 || p2 > 100){
				resposta = "Nota da segunda prova deve estar entre 0 e 100.";
				exibe(response,resposta);
				return;
			}
			//Função para calcular nota final
			nf = calcularNotaFinal(p1,p2);
			
			//Verificar se a caixa de prova especial está marcada
			if(especial != null){
				String notaEspecial = request.getParameter("texto3");
				if(notaEspecial.equals("")){
					resposta = "Favor informar a nota especial.";
					exibe(response,resposta);
					return;
				}
				if(!notaEspecial.matches("[0-9]*")){
					resposta = "Informe apenas valores numéricos na nota especial.";
					exibe(response,resposta);
					return;
				}
				//Obter nota do exame especial do usuário
				int esp = Integer.parseInt(notaEspecial);
				if(esp < 0 || esp > 100){
					resposta = "Nota da especial deve estar entre 0 e 100.";
					exibe(response,resposta);
					return;
				}else{
					//Função para calcular nota especial
					ne = calcularNotaEspecial(nf,esp);
					if(ne >= APROVACAO){
						resposta = "Aprovado!";
					}else resposta = "Reprovado!";
				}
			}else{
				if(nf >= APROVACAO){
					resposta = "Aprovado!";
				}else resposta = "Reprovado!";
			}
			
			//Exibir resultado
			exibe(response,resposta);
			
		}catch(Exception e){
			resposta = "Dados inválidos.";
		}
	}
	
	private int calcularNotaFinal(int p1, int p2){
		return (p1 + (K * p2)) / (K+1);
	}
	
	private int calcularNotaEspecial(int nf, int esp){
		return (nf + esp) / 2;
	}
}
