package PrjPraticaRmi;

import java.rmi.RemoteException;
import java.util.Hashtable;

public class ServidorCentral implements ServidorCentralService {
	
	private Hashtable<String, Float> clientes = new Hashtable<String, Float>();

	public void RemoverCliente(String nomeCliente) throws RemoteException {
		if (clientes.containsKey(nomeCliente)){
			clientes.remove(nomeCliente);
		}
	}
	public void AdicionarCliente(String nomeCliente) throws RemoteException {
		if (!clientes.containsKey(nomeCliente)){
			clientes.put(nomeCliente, 0.0f);
		}
	}


	public void AtualizarDebitoCliente(String nomeCliente, float novoDebito)
			throws RemoteException {
		clientes.put(nomeCliente, novoDebito);
	}

	public Float ConsultarDebito(String nomeCliente) throws RemoteException {
		if (clientes.containsKey(nomeCliente)) {
			return clientes.get(nomeCliente);
		} else {
			return -1.0f;
}
}
}
