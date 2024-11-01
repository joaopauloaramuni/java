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

	// ERRO: estado de usu�rio n�o � guardado como atributo do servlet
	// private int requisicoes = 0;

	public ExemploServlet() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("Init");

		// Recupera��o de par�metros de inicializa��o
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
	 * System.out.println("Tratamento de requisi��es GET"); } else
	 * if("POST".equals(request.getMethod())){
	 * System.out.println("Tratamento de requisi��es POST"); } else{
	 * System.out.println("Tratamento das demais requisi��es"); } }
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("M�todo doGet sobreposto");

		// requisicoes++;

		// ******************** SESS�O DO USU�RIO (Objeto Sess�o)
		// ******************** //

		// Obten��o da sess�o do usu�rio
		// Recupera a sess�o do usu�rio sem criar uma nova
		/*
		 * HttpSession session = req.getSession(false);
		 * 
		 * // Verificar se � uma nova sess�o (Fun��o transferida para o
		 * Listener) if(session == null){ // Novo usu�rio cria a sess�o session
		 * = req.getSession(); // Inicializa os atributos necess�rios
		 * session.setAttribute("requisicoes", 0); }
		 */

		// Recupera a sess�o do usu�rio (cria uma nova se n�o existir)
		// O listener garante a exist�ncia do atributo
		HttpSession session = req.getSession();

		// Recupera, atualiza e regrava o atributo da sess�o
		// Recuperar o atributo da sess�o (session.getAttribute) e N�O da
		// requisi��o (req.getAttribute)
		int requisicoes = (Integer) session.getAttribute("requisicoes");
		// requisicoes++;
		session.setAttribute("requisicoes", ++requisicoes);

		// ******************** SESS�O DO USU�RIO (Objeto Contexto)
		// ******************** //

		// Objeto Contexto - Representa a Aplica��o // Criado automaticamente //
		// Caracter�sticas - Guardar informa��es da aplica��o // Objeto �nico
		// dentro do container //
		// Recuperar o contexto da aplica��o :
		ServletContext context = getServletContext();
		// Atributos em escopos diferentes // Contexto e Sess�o // Podem ter
		// nomes diferentes //
		// Testar se o contexto j� tem o atributo necess�rio :

		/*
		 * Object reqs = context.getAttribute("requisicoes"); (Fun��o
		 * transferida para o Listener) if(reqs == null){ //Atributo n�o existe;
		 * inicializa context.setAttribute("requisicoes", 0); }
		 */

		// Recupera o atributo (j� inicializado)
		int requisicoesTotais = (Integer) context.getAttribute("requisicoes");
		context.setAttribute("requisicoes", ++requisicoesTotais);

		// ******************** SESS�O DO USU�RIO (FIM) ******************** //

		// Obten��o do par�metro de inicializa��o (web.xml)
		int MAXIMO = Integer.parseInt(getInitParameter("maximo"));

		String resposta = "";

		try {
			int valor = Integer.parseInt(req.getParameter("valor"));
			if (valor < MINIMO || valor > MAXIMO)
				resposta = "Valor deve estar entre " + MINIMO + " e " + MAXIMO;
			else
				resposta = "Valor = " + valor;
		} catch (NumberFormatException e) {
			resposta = "Favor informar dados num�ricos";
		}

		// Gera��o da resposta
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");

		out.println("<html><head><title>");
		out.println("Exemplo - resposta");
		out.println("</title></head><body>");
		out.println("<h1>Exemplo - resposta</h1>");
		out.println(resposta);

		// getParameterNames() // Retorno: Cole��o de todos os nomes de
		// par�metros da requisi��o // API enumeration do Java
		out.println("<p>Listagem dos par�metros da requisi��o</p>");
		Enumeration<String> names = req.getParameterNames();
		// Uma forma de percorrer uma cole��o do tipo Enumeration
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			out.println("Par�metro: " + name + "conte�do: "
					+ req.getParameter(name));
		}

		out.println("<p>Requisi��es enviadas: " + requisicoes + "</p>");
		out.println("<p>Requisi��es totais: " + requisicoesTotais + "</p>");

		// Redirecionamento da requisi��o
		// Obten��o do RequestDispatcher (informar a url do destino do
		// redirecionamento)
		req.setAttribute("teste", "teste"); // Grava atributo para teste do
											// resultado
		RequestDispatcher rd = req.getRequestDispatcher("include");
		// Faz redirecionamento include (a requisi��o volta para o servlet
		// original)
		rd.include(req, resp);

		out.println("<p>Sa�da gerada pelo servlet original");

		out.println("</body></html>");

		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("M�todo doPost sobreposto");
	}
}
