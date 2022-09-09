package exemplo;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/* Listener para evento de ciclo de vida do contexto */
/* Ouvinte de eventos de contexto */
public class InicializaListener implements ServletContextListener, HttpSessionListener{

    public InicializaListener() {
    }
 
    // Handler para os eventos de criação do contexto
    public void contextInitialized(ServletContextEvent ev) {
    	//ev - referência para a fonte do evento
    	System.out.println("Contexto inicializado");
    	ServletContext context = ev.getServletContext();
    	context.setAttribute("requisicoes",0);
    }

    // Handler para os eventos de destruição do contexto
    public void contextDestroyed(ServletContextEvent ev) {
    	System.out.println("Contexto destruído");
    }
    
    // Handler para os eventos de criação da sessão
	@Override
	public void sessionCreated(HttpSessionEvent ev) {
		System.out.println("Sessão criada");
    	HttpSession session = ev.getSession();
    	session.setAttribute("requisicoes", 0);
	}
	
	// Handler para os eventos de destruição da sessão
	@Override
	public void sessionDestroyed(HttpSessionEvent ev) {
		System.out.println("Sessão destruída");
	}
	
}
