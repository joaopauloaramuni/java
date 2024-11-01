package clientescadastro;

import java.util.GregorianCalendar;
import java.util.Vector;

import clientesmodelo.Cliente;

public class CadastroClientes {
   // Atributos
	private Vector<Cliente> listaClientes = new Vector<Cliente>();
	
	// get e set
	
	public Vector<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(Vector<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	public void incluirCliente(Cliente objCliente) throws Exception {
		for (Cliente obj : listaClientes) {
			if (obj.equals(objCliente))
				throw new Exception("Já existe o cliente no cadastro - " 
						+ obj.getCodigo());
		}
		listaClientes.add(objCliente);
	}

	public Cliente consultarCodigo(int codigo) throws Exception {
		for (Cliente obj : listaClientes) {
			if (obj.getCodigo()==codigo) return obj;
		}
		throw new Exception("Não existe cliente para o codigo informado.");
	}
	
	public Vector<Cliente> consultarMesNascimento(int mes) throws Exception {
		Vector<Cliente> resposta = new Vector<Cliente>();
		for (Cliente obj : listaClientes) {
			if (obj.getNascimento().get(GregorianCalendar.MONTH)==mes-1){
				resposta.add(obj);
			}
		}
		if (resposta.isEmpty()) {
			throw new Exception("Não existe cliente para o mes informado.");
		} else return resposta;
	}
	public Vector<Cliente> consultarNome (String nome) throws Exception {
		Vector<Cliente> resposta = new Vector<Cliente>();
		for (Cliente obj : listaClientes) {
			if (obj.getNome().toUpperCase().indexOf(nome.toUpperCase()) != -1) {
				resposta.add(obj);
			}
		}
		if (resposta.isEmpty()) {
			throw new Exception("Não existe cliente para o nome informado.");
		} else return resposta;		
	}
	public void excluirCliente(Cliente objCliente) {
		listaClientes.remove(objCliente);
	}
	
}





