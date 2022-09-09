

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class ProvaListener implements HttpSessionListener {
    public ProvaListener() {
      
    }

    public void sessionCreated(HttpSessionEvent ev) {
    	HttpSession session = ev.getSession();
    	session.setAttribute("acertos", new Integer(0));
    	session.setAttribute("erros", new Integer(0));
     	session.setAttribute("nivel", new Integer(1));
    }

    public void sessionDestroyed(HttpSessionEvent ev) {
        
    }
	
}
