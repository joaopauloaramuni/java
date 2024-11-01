package cadastro;

import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;

import erro.ClienteException;

import modelo.Cliente;

public class Cadastro {
	private HashMap<String, Cliente> cadClientes = new HashMap<String, Cliente>();

	public HashMap<String, Cliente> getCadClientes() {
		return cadClientes;
	}

	public void setCadClientes(HashMap<String, Cliente> cadClientes) {
		this.cadClientes = cadClientes;
	}
	/**
	 * Incluir o cliente na lista
	 * @param objeto da classe Cliente 
	 * @throws ClienteException - "Já existe cliente para o CPF informado."
	 */
	public void incluirCliente(Cliente obj) throws ClienteException {
		if (cadClientes.containsKey(obj.getCpf())) {
			throw new ClienteException("Já existe cliente para o CPF informado.");
		} else {
			cadClientes.put(obj.getCpf(), obj);
		}
	}
	public Cliente consultarCliCpf(String cpf) throws ClienteException{
		if (cadClientes.containsKey(cpf)){
			return cadClientes.get(cpf);
		} else {
			throw new ClienteException("Não existe cliente para o CPF informado.");
		}
	}
	public void excluirCliente(String cpf) throws ClienteException {
		if (cadClientes.containsKey(cpf)) {
			cadClientes.remove(cpf);
		} else {
			throw new ClienteException("Não existe cliente para o CPF informado.");		
		}
	}
	/**
	 * Consulta de clientes pelo nome
	 * @param nome do cliente para seleção
	 * @return lista de clientes em ordem do nome
	 * @throws ClienteException - "Não existe cliente para o nome informado."
	 */
	public Vector<Cliente> consultarCliNome(String nome) throws ClienteException{
		Vector<Cliente> resp = new Vector<Cliente>();
		for (Cliente obj : cadClientes.values()) {
			if (obj.getNome().toUpperCase().indexOf(nome.toUpperCase())!=-1) {
				resp.add(obj);
			}
		}
		if (resp.isEmpty())
			throw new ClienteException("Não existe cliente para o nome informado.");
		Collections.sort(resp);
		return resp;
	}
	
}







