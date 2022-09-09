package PrjPraticaRmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Hashtable;

public abstract class Locadora {
	
	protected static Hashtable<String, Float> clientes = new Hashtable<String, Float>();
	private static ServidorCentralService servidor = null;
	
	public Locadora(){
		try {
			servidor = (ServidorCentralService)Naming.lookup("rmi://localhost:1099/Locadora");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void RemoverCliente(String nomeCliente) throws RemoteException{
		if (clientes.containsKey(nomeCliente)){
			clientes.remove(nomeCliente);
			servidor.RemoverCliente(nomeCliente);
		}
	}
	
	public static void InserirCliente(String nomeCliente){
		try {		
			if (!clientes.containsKey(nomeCliente)){
				clientes.put(nomeCliente, 0.0f);
				servidor.AdicionarCliente(nomeCliente);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void AtualizarDebitoCliente(String nomeCliente, Float novoDebito) throws RemoteException{
		if(clientes.containsKey(nomeCliente)){
			clientes.put(nomeCliente, novoDebito);
			servidor.AtualizarDebitoCliente(nomeCliente, novoDebito);
		}
	}
	
	public static Float ConsultarDebito(String nomeCliente) throws RemoteException{
		Float debito;
		if(clientes.containsKey(nomeCliente)){
			debito =  clientes.get(nomeCliente);
		}
		else{
			debito = servidor.ConsultarDebito(nomeCliente);
		}
		return debito;
	}
	


}
