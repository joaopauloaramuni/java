package PrjServidor;

import java.util.HashMap;

/**
 * DSD - Desenvolvimento de Sistemas Distribu�dos
 * Cap 6
 * Data: 24/11/2013
 * @author Jo�o Paulo Aramuni
 *
 */
public class TabelaClienteServidor {

	private HashMap<String, String> clients = new HashMap<String, String>();

	public HashMap<String, String> getClients() {
		return clients;
	}

	public void setClients(HashMap<String, String> clients) {
		this.clients = clients;
	}

}
