package exemplo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// É possível utilizar mais de um listener para o mesmo tipo de evento
// Os listeners são criados e destruídos em ordem de pilha

/* Listener para evento de ciclo de vida do contexto */
/* Ouvinte de eventos de contexto */
public class OutroListener implements ServletContextListener {


    public OutroListener() {
    }

    public void contextInitialized(ServletContextEvent ev) {
    	//ev - referência para a fonte do evento
    	System.out.println("Outro listener: contexto inicializado");
    }

    public void contextDestroyed(ServletContextEvent ev) {
    	System.out.println("Outro listener: contexto destruído");
    }
	
}
