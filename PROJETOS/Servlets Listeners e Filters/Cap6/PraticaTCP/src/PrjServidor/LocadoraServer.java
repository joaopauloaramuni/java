package PrjServidor;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Vector;

/**
 * DSD - Desenvolvimento de Sistemas Distribuídos
 * Cap 6
 * Data: 24/11/2013
 * @author João Paulo Aramuni
 *
 */
public class LocadoraServer {

	public static void main(String[] args) throws Exception {
		HashMap<String, String> clientes = new HashMap<String, String>();
		Vector<TabelaConexao> fil = new Vector<TabelaConexao>();
		ServerSocket serverSocket = new ServerSocket(2018);
		try{
		while (true) {
			final Socket socketMain = serverSocket.accept();
			final Socket socketAux = serverSocket.accept();
			TabelaConexao listenerConection = new TabelaConexao(socketMain,
					socketAux, clientes, fil);
			fil.add(listenerConection);
			new Thread(listenerConection).start();
		}
		}catch(Exception e){
			serverSocket.close();
		}
	}

}
