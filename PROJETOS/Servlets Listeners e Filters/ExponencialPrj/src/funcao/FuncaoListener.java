package funcao;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class FuncaoListener implements HttpSessionListener {

    public FuncaoListener() {

    }

    public void sessionCreated(HttpSessionEvent arg0) {
      
    }

    public void sessionDestroyed(HttpSessionEvent arg0) {

    }
	
}
