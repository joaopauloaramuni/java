package cadastrocliente;

import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;

import erros.ClientesException;

import modelo.Cliente;

/**
 * Gerenciar a lista de Clientes do tipo HashMap
 * acesso via cpf
 */
public class CadastroClientes {
	private HashMap<String, Cliente> cadClientes = new HashMap<String, Cliente>();

	public HashMap<String, Cliente> getCadClientes() {
		return cadClientes;
	}

	public void setCadClientes(HashMap<String, Cliente> cadClientes) {
		this.cadClientes = cadClientes;
	}
	
	public void incluirCliente(Cliente objCli) throws ClientesException {
		if (cadClientes.containsKey(objCli.getCpf())) {
			throw new ClientesException("Cliente já cadastrado.");
		} else {
			cadClientes.put(objCli.getCpf(), objCli);
		}
	}
	/**
	 * Consultar o cliente pelo CPF
	 * @param cpf do cliente a ser consultado
	 * @return objeto de dados do cliente
	 * @throws ClientesException "Não existe cliente para o cpf informado."
	 */
	public Cliente consultarCliente (String cpf) throws ClientesException {
		if (cadClientes.containsKey(cpf)) {
			return cadClientes.get(cpf);
		} else throw new ClientesException("Não existe cliente para o cpf informado.");
	}
	public void excluirCliente(String cpf) throws ClientesException {
		if (cadClientes.containsKey(cpf)) {
			cadClientes.remove(cpf);
		} else throw new ClientesException("Não existe cliente para o cpf informado.");
	}
	public Vector<Cliente> consultarNome(String nome) throws ClientesException {
		Vector<Cliente> resp = new Vector<Cliente>();
		for (Cliente obj : cadClientes.values()) {
			if (obj.getNome().toUpperCase().indexOf(nome.toUpperCase())!=-1) {
				resp.add(obj);
			}
		}
		if (resp.isEmpty()) 
			throw new ClientesException("Não existe cliente para o nome informado.");
		Collections.sort(resp);
		return resp;
	}
	
	public Vector<Cliente> getClientes() {
		Vector<Cliente> resp = new Vector<Cliente>();
		for (Cliente obj : cadClientes.values() ) {
			resp.add(obj);
		}
		return resp;
	}
	
	public void setCadClientes(Vector<Cliente> listaClientes) {
		for (Cliente obj : listaClientes) {
			cadClientes.put(obj.getCpf(), obj);
		}
	}
	
}







