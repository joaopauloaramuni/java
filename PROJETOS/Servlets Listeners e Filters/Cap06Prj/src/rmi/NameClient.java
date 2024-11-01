package rmi;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
public class NameClient {
    public static void main(String args[]) {
		System.setProperty("java.security.policy", "client.policy");
		if (System.getSecurityManager() == null)
			System.setSecurityManager(new RMISecurityManager());
        try {
            NameService r = (NameService) 
                           Naming.lookup("rmi://localhost:1099/MyNameServer");
            r.insert("p1", "tick.ece", 2058);
            int j = r.search("p1");
            if (j != -1)
               System.out.println(r.getHostName(j) +":" + r.getPort(j));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
