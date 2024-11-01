package mountyhall;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MountyListener implements HttpSessionListener,
		ServletContextListener {

	public MountyListener() {
	}

	public void contextInitialized(ServletContextEvent ev) {
		System.out.println("Servlet inicializado");
		ServletContext context = ev.getServletContext();
		context.setAttribute("recorde", new Integer(0));
	}

	public void contextDestroyed(ServletContextEvent ev) {
		System.out.println("Contexto destruído");
	}

	public void sessionCreated(HttpSessionEvent ev) {
		ev.getSession().setAttribute("acesso", new Integer(1));
		ev.getSession().setAttribute("pontos", new Integer(0));
		ev.getSession().setAttribute("portas", "1 2 3");
	}

	public void sessionDestroyed(HttpSessionEvent ev) {
		System.out.println("Sessão destruída");
	}

}
