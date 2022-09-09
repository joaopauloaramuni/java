package alerta;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class AlertaListener implements ServletContextListener,
		HttpSessionListener {

	ServletContext context = null;

	public void contextInitialized(ServletContextEvent ev) {
		System.out.println("Servlet inicializado");
		context = ev.getServletContext();
		context.setAttribute("sessoes", new Integer(0));
	}

	public void contextDestroyed(ServletContextEvent ev) {
	}

	public void sessionCreated(HttpSessionEvent ev) {
		System.out.println("Sessão criada");
		this.incrementaContador();
		ev.getSession().setAttribute("cor", new Integer(2));
	}

	public void sessionDestroyed(HttpSessionEvent ev) {
		System.out.println("Sessão destruída");
		this.decrementaContador();
	}

	private synchronized void incrementaContador() {
		int sessoes = ((Integer) context.getAttribute("sessoes")).intValue();
		sessoes++;
		context.setAttribute("sessoes", new Integer(sessoes));
		System.out.println("Sessões = " + sessoes);
	}

	private synchronized void decrementaContador() {
		int sessoes = ((Integer) context.getAttribute("sessoes")).intValue();
		sessoes--;
		context.setAttribute("sessoes", new Integer(sessoes));
		System.out.println("Sessões = " + sessoes);
	}
}
