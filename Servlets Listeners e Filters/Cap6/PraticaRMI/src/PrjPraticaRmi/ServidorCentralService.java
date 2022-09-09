package PrjPraticaRmi;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServidorCentralService extends Remote {
	public void AdicionarCliente(String nomeCliente) throws RemoteException;
	public void RemoverCliente(String nomeCliente) throws RemoteException;
	public Float ConsultarDebito(String nomeCliente) throws RemoteException;
	public void AtualizarDebitoCliente(String nomeCliente, float novoDebito) throws RemoteException;

}