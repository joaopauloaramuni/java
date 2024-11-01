
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(servletNames = { "ProvaServlet" })
public class ProvaFilter implements Filter {

	public ProvaFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		if ("POST".equals(((HttpServletRequest) request).getMethod())) {

			HttpSession session = ((HttpServletRequest) request).getSession();
			HttpServletRequest req = (HttpServletRequest) request;

			int nivel = (Integer) req.getSession().getAttribute("nivel");
			int acertos = (Integer) req.getSession().getAttribute("acertos");
			int erros = (Integer) req.getSession().getAttribute("erros");

			if (erros == 2 && nivel > 1) {
				nivel--;
				session.setAttribute("nivel", nivel);
			}
			if (acertos == 2 && nivel < 3) {
				nivel++;
				session.setAttribute("nivel", nivel);
			}
			if (acertos == 3 && nivel == 3) {
				// Recria a sessão
				session.invalidate();
				((HttpServletResponse) response)
						.sendRedirect("paginaAcerto.jsp");
				return;
			}
			if (erros == 3 && nivel == 1) {
				// Recria a sessão
				session.invalidate();
				((HttpServletResponse) response).sendRedirect("paginaErro.jsp");
				return;
			}
		}
		chain.doFilter(request, response);

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
