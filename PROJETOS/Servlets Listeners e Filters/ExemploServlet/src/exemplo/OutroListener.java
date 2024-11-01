package exemplo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// � poss�vel utilizar mais de um listener para o mesmo tipo de evento
// Os listeners s�o criados e destru�dos em ordem de pilha

/* Listener para evento de ciclo de vida do contexto */
/* Ouvinte de eventos de contexto */
public class OutroListener implements ServletContextListener {


    public OutroListener() {
    }

    public void contextInitialized(ServletContextEvent ev) {
    	//ev - refer�ncia para a fonte do evento
    	System.out.println("Outro listener: contexto inicializado");
    }

    public void contextDestroyed(ServletContextEvent ev) {
    	System.out.println("Outro listener: contexto destru�do");
    }
	
}
