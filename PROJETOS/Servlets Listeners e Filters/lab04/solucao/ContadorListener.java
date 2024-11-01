import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSession;

public class ContadorListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent ev) {
		System.out.println("Sess�o criada: " + ev);
		HttpSession session = ev.getSession();
		session.setAttribute("cont",new Integer(0));
	}

	public void sessionDestroyed(HttpSessionEvent ev) {
		System.out.println("Sess�o destru�da: " + ev);
	}

}
