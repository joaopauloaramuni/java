package exemplo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ExemploServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int MINIMO;

	// ERRO: estado de usuário não é guardado como atributo do servlet
	// private int requisicoes = 0;

	public ExemploServlet() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("Init");

		// Recuperação de parâmetros de inicialização
		try {
			MINIMO = Integer.parseInt(config.getInitParameter("minimo"));
		} catch (NumberFormatException e) {
			MINIMO = 0;
		}
	}

	@Override
	public void destroy() {
		System.out.println("Destroy");
	}

	/*
	 * protected void service(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * System.out.println("Service"); //request.getMethod().equals("GET");
	 * 
	 * if("GET".equals(request.getMethod())){
	 * System.out.println("Tratamento de requisições GET"); } else
	 * if("POST".equals(request.getMethod())){
	 * System.out.println("Tratamento de requisições POST"); } else{
	 * System.out.println("Tratamento das demais requisições"); } }
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Método doGet sobreposto");

		// requisicoes++;

		// ******************** SESSÃO DO USUÁRIO (Objeto Sessão)
		// ******************** //

		// Obtenção da sessão do usuário
		// Recupera a sessão do usuário sem criar uma nova
		/*
		 * HttpSession session = req.getSession(false);
		 * 
		 * // Verificar se é uma nova sessão (Função transferida para o
		 * Listener) if(session == null){ // Novo usuário cria a sessão session
		 * = req.getSession(); // Inicializa os atributos necessários
		 * session.setAttribute("requisicoes", 0); }
		 */

		// Recupera a sessão do usuário (cria uma nova se não existir)
		// O listener garante a existência do atributo
		HttpSession session = req.getSession();

		// Recupera, atualiza e regrava o atributo da sessão
		// Recuperar o atributo da sessão (session.getAttribute) e NÃO da
		// requisição (req.getAttribute)
		int requisicoes = (Integer) session.getAttribute("requisicoes");
		// requisicoes++;
		session.setAttribute("requisicoes", ++requisicoes);

		// ******************** SESSÃO DO USUÁRIO (Objeto Contexto)
		// ******************** //

		// Objeto Contexto - Representa a Aplicação // Criado automaticamente //
		// Características - Guardar informações da aplicação // Objeto único
		// dentro do container //
		// Recuperar o contexto da aplicação :
		ServletContext context = getServletContext();
		// Atributos em escopos diferentes // Contexto e Sessão // Podem ter
		// nomes diferentes //
		// Testar se o contexto já tem o atributo necessário :

		/*
		 * Object reqs = context.getAttribute("requisicoes"); (Função
		 * transferida para o Listener) if(reqs == null){ //Atributo não existe;
		 * inicializa context.setAttribute("requisicoes", 0); }
		 */

		// Recupera o atributo (já inicializado)
		int requisicoesTotais = (Integer) context.getAttribute("requisicoes");
		context.setAttribute("requisicoes", ++requisicoesTotais);

		// ******************** SESSÃO DO USUÁRIO (FIM) ******************** //

		// Obtenção do parâmetro de inicialização (web.xml)
		int MAXIMO = Integer.parseInt(getInitParameter("maximo"));

		String resposta = "";

		try {
			int valor = Integer.parseInt(req.getParameter("valor"));
			if (valor < MINIMO || valor > MAXIMO)
				resposta = "Valor deve estar entre " + MINIMO + " e " + MAXIMO;
			else
				resposta = "Valor = " + valor;
		} catch (NumberFormatException e) {
			resposta = "Favor informar dados numéricos";
		}

		// Geração da resposta
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");

		out.println("<html><head><title>");
		out.println("Exemplo - resposta");
		out.println("</title></head><body>");
		out.println("<h1>Exemplo - resposta</h1>");
		out.println(resposta);

		// getParameterNames() // Retorno: Coleção de todos os nomes de
		// parâmetros da requisição // API enumeration do Java
		out.println("<p>Listagem dos parâmetros da requisição</p>");
		Enumeration<String> names = req.getParameterNames();
		// Uma forma de percorrer uma coleção do tipo Enumeration
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			out.println("Parâmetro: " + name + "conteúdo: "
					+ req.getParameter(name));
		}

		out.println("<p>Requisições enviadas: " + requisicoes + "</p>");
		out.println("<p>Requisições totais: " + requisicoesTotais + "</p>");

		// Redirecionamento da requisição
		// Obtenção do RequestDispatcher (informar a url do destino do
		// redirecionamento)
		req.setAttribute("teste", "teste"); // Grava atributo para teste do
											// resultado
		RequestDispatcher rd = req.getRequestDispatcher("include");
		// Faz redirecionamento include (a requisição volta para o servlet
		// original)
		rd.include(req, resp);

		out.println("<p>Saída gerada pelo servlet original");

		out.println("</body></html>");

		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Método doPost sobreposto");
	}
}
