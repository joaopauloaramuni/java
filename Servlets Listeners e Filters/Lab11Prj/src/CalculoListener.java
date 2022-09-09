

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class CalculoListener implements HttpSessionListener {

    public CalculoListener() {
    }

    public void sessionCreated(HttpSessionEvent ev) {
    	HttpSession session = ev.getSession();
    	session.setAttribute("termos", 0);
    }

    public void sessionDestroyed(HttpSessionEvent ev) {
    }
	
}
