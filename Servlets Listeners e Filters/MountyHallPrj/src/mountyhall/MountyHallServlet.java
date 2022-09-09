package mountyhall;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Random;

public class MountyHallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MountyHallServlet() {
		super();
	}

	private void inicializa(HttpServletRequest request) {

		HttpSession session = request.getSession();
		session.setAttribute("acesso", new Integer(1));
		session.setAttribute("portas", "1 2 3");
	}

	private void atualiza(HttpServletRequest request, String portas,
			int portaUsuario, int portaSistema, int portaNaoEscolhida) {

		HttpSession session = request.getSession();
		session.setAttribute("acesso", new Integer(2));
		session.setAttribute("portas", portas);
		session.setAttribute("portaUsuario", portaUsuario);
		session.setAttribute("portaSistema", portaSistema);
		session.setAttribute("portaNaoEscolhida", portaNaoEscolhida);
	}

	private int getRecord(HttpServletRequest request) {
		ServletContext context = request.getServletContext();
		return (Integer) context.getAttribute("recorde");
	}

	private void setRecord(HttpServletRequest request, int pontos) {
		ServletContext context = request.getServletContext();
		context.setAttribute("recorde", pontos);
	}

	private int getPontos(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return ((Integer) session.getAttribute("pontos")).intValue();
	}

	private void exibe(HttpServletResponse response, String portas, int pontos,
			String info, int recorde) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.println("<html><head><title>Mounty Hall Servlet</title></head>");
		out.println("<body><h1>Jogo de Mounty Hall</h1>");
		out.println("<form method='post'>");

		out.println("<table><tr><td>Portas " + portas + "</td></tr>");
		out.println("<tr><td>Escolha: <input type='text' name='escolha'/></td></tr>");
		out.println("<tr><td><input type='submit' value='Enviar Dados'/></td></tr>");
		out.println("<tr><td><br>Pontuação: " + pontos + "</td></tr>");
		out.println("<tr><td><a href='mounty'>Reiniciar</a></td></tr>");
		out.println("<tr><td><br>" + info + "</td></tr>");
		out.println("<tr><td>Recorde Geral: " + recorde + "</td></tr>");
		out.println("</table></form></body></html>");
	}

	private void exibePortas(int portaUsuario, int portaSistema,
			int portaNaoEscolhida) {
		System.out.println("Porta do Usuário: " + portaUsuario);
		System.out.println("Porta do Sistema: " + portaSistema);
		System.out.println("Porta não Escolhida: " + portaNaoEscolhida);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		inicializa(request);
		exibe(response, "1 2 3", getPontos(request), "", getRecord(request));
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		mountyHall(request, response);

	}

	private void mountyHall(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String escolha = request.getParameter("escolha");
		String info = "";

		HttpSession session = request.getSession();
		int acesso = ((Integer) session.getAttribute("acesso")).intValue();
		int pontos = getPontos(request);
		int recorde = getRecord(request);
		String portas = (String) session.getAttribute("portas");

		// Validar Escolha
		if (escolha.equals("")) {
			info = "Favor preencher o campo escolha.";
			exibe(response, portas, pontos, info, recorde);
			return;
		}
		if (!escolha.matches("[1-3]")) {
			info = "Informe apenas valores numéricos de 1 a 3.";
			exibe(response, portas, pontos, info, recorde);
			return;
		}

		if (acesso == 1) {

			try {
				int portaSistema = sortPort();
				int portaUsuario = Integer.parseInt(escolha);
				int portaNaoEscolhida;

				// Reconhecer Porta Não Escolhida
				do {
					portaNaoEscolhida = sortPort();
				} while (portaNaoEscolhida == portaSistema
						|| portaNaoEscolhida == portaUsuario);

				// Abrir Porta
				portas = abrePorta(portaNaoEscolhida);

				atualiza(request, portas, portaUsuario, portaSistema,
						portaNaoEscolhida);

				// Exibição
				exibePortas(portaUsuario, portaSistema, portaNaoEscolhida);
				exibe(response, portas, pontos, "Realizar escolha final!",
						recorde);

			} catch (Exception e) {
				e.getMessage();
				exibe(response, "1 2 3", 0, "erro!", recorde);
			}
		} else if (acesso == 2) {
			System.out.println("Escolha Final Realizada!");
			try {
				int portaNaoEscolhida = ((Integer) session
						.getAttribute("portaNaoEscolhida")).intValue();

				if (Integer.parseInt(escolha) == portaNaoEscolhida) {
					exibe(response, portas, pontos,
							"A porta ja aberta não pode ser escolhida!",
							recorde);
					return;
				}

				int portaUsuario = Integer.parseInt(escolha);
				int portaSistema = ((Integer) session
						.getAttribute("portaSistema")).intValue();
				if (portaUsuario == portaSistema) {
					pontos = pontos + 10;
					info = "10 Pontos !!! Sucesso !";

				} else {
					pontos = pontos / 2;
					info = "Fracasso !!!";
				}
				session.setAttribute("acesso", new Integer(1));
				session.setAttribute("pontos", pontos);
				portas = "1 2 3";

				if (pontos > recorde) {
					setRecord(request, pontos);
				}
				exibePortas(portaUsuario, portaSistema, portaNaoEscolhida);
				exibe(response, portas, pontos, info, getRecord(request));

			} catch (Exception e) {
				e.getMessage();
				exibe(response, "1 2 3", 0, "erro!", getRecord(request));
			}

		}
	}

	private String abrePorta(int portaNaoEscolhida) {
		String portas = "";
		switch (portaNaoEscolhida) {
		case 1:
			portas = "* 2 3";
			break;
		case 2:
			portas = "1 * 3";
			break;

		case 3:
			portas = "1 2 *";
			break;

		default:
			portas = "1 2 3";
			break;
		}
		return portas;
	}

	private int sortPort() {
		Random r = new Random();
		return (r.nextInt(3) + 1);
	}
}
