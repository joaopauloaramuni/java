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
 
    // Handler para os eventos de cria��o do contexto
    public void contextInitialized(ServletContextEvent ev) {
    	//ev - refer�ncia para a fonte do evento
    	System.out.println("Contexto inicializado");
    	ServletContext context = ev.getServletContext();
    	context.setAttribute("requisicoes",0);
    }

    // Handler para os eventos de destrui��o do contexto
    public void contextDestroyed(ServletContextEvent ev) {
    	System.out.println("Contexto destru�do");
    }
    
    // Handler para os eventos de cria��o da sess�o
	@Override
	public void sessionCreated(HttpSessionEvent ev) {
		System.out.println("Sess�o criada");
    	HttpSession session = ev.getSession();
    	session.setAttribute("requisicoes", 0);
	}
	
	// Handler para os eventos de destrui��o da sess�o
	@Override
	public void sessionDestroyed(HttpSessionEvent ev) {
		System.out.println("Sess�o destru�da");
	}
	
}
