package rmi;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

//import javax.naming.Context;
//import javax.naming.InitialContext;

public class NameServer {
	public static void main(String args[]) {
		//create security manager
		System.setProperty("java.security.policy", "server.policy");
		if (System.getSecurityManager() == null)
			System.setSecurityManager(new RMISecurityManager());
		try {
			NameService obj = new NameServiceImpl();
			// Usar se estiver utilizando JNDI: http://java.sun.com/j2se/1.5.0/docs/guide/jndi/jndi-rmi.html
			//Context namingContext = new InitialContext();  
			//namingContext.rebind("MyNameServer", obj); 
			Naming.rebind("MyNameServer", obj);
			System.out.println("MyNameServer bound in registry");
		} catch (Exception e) {
			System.out.println("NameServiceImpl err: " + e.getMessage());
		}
	}
}
