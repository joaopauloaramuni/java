

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class JogoListener implements HttpSessionListener, ServletContextListener {

    public JogoListener() {
    }

    public void contextInitialized(ServletContextEvent ev) {
		ServletContext context = ev.getServletContext();
		context.setAttribute("recordeMenor", Integer.MAX_VALUE);
    }
    
    public void contextDestroyed(ServletContextEvent ev) {

    }
    public void sessionCreated(HttpSessionEvent ev) {
    	HttpSession session = ev.getSession();
    	session.setAttribute("contMenor", new Integer(0));
    	session.setAttribute("contMaior", new Integer(0));
    	session.setAttribute("numMenor", Integer.MAX_VALUE);
    }

    public void sessionDestroyed(HttpSessionEvent ev) {
    }
	
}
