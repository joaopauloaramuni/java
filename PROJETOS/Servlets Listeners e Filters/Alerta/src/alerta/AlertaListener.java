package alerta;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class AlertaListener implements ServletContextListener,
		HttpSessionListener {

	public AlertaListener() {

	}

	public void contextInitialized(ServletContextEvent ev) {
		System.out.println("Servlet inicializado");
		ServletContext context = ev.getServletContext();
		context.setAttribute("sessoes", 0);
	}

	public void contextDestroyed(ServletContextEvent ev) {
	}

	public void sessionCreated(HttpSessionEvent ev) {
		System.out.println("Sessão criada");
		HttpSession session = ev.getSession();
		session.setAttribute("cor", 2);
		incrementaSessoes(session);
	}

	public void sessionDestroyed(HttpSessionEvent ev) {
		System.out.println("Sessão destruída");
		HttpSession session = ev.getSession();
		decrementaSessoes(session);
	}
	
	private synchronized void incrementaSessoes(HttpSession session){
		ServletContext context = session.getServletContext();
		int sessoes = (Integer) context.getAttribute("sessoes");
		context.setAttribute("sessoes", ++sessoes);
		System.out.println("Sessões = " + sessoes);
	}
	
	private synchronized void decrementaSessoes(HttpSession session){
		ServletContext context = session.getServletContext();
		int sessoes = (Integer) context.getAttribute("sessoes");
		context.setAttribute("sessoes", --sessoes);
		System.out.println("Sessões = " + sessoes);
	}

}
