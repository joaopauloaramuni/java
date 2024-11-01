package cadastro;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Vector;

import dados.Cliente;
import erros.ClienteException;

public class Cadastro {
	public static HashMap<String, Cliente> listaClientes = new HashMap<String, Cliente>();
	
	public static void incluirCliente(Cliente objCli) throws ClienteException{
		{
			if (listaClientes.containsKey(objCli.getCpf())) {
				throw new ClienteException("Cliente já cadastrado.");
			} else
				listaClientes.put(objCli.getCpf(), objCli);
		}
	}
	
	public static Cliente consClienteCPF(String cpf) throws ClienteException{
		if(listaClientes.containsKey(cpf)){
			return listaClientes.get(cpf);
		}else{
			throw new ClienteException("Cliente não existe.");
		}
	}
	public static Vector<Cliente> consClienteNome(String nome)throws ClienteException{
	Vector<Cliente> resp  = new Vector<Cliente>();
	for (Cliente obj : listaClientes.values()) {
		if(obj.getNome().toUpperCase().indexOf(nome.toUpperCase()) != -1  ){
			resp.add(obj);
		}
	}
	if(resp.isEmpty()){
		throw new ClienteException("Não existe cliente para o nome");
	}
	Collections.sort(resp,new Comparator<Cliente>() {

		@Override
		public int compare(Cliente o1, Cliente o2) {
			// TODO Auto-generated method stub
			return o1.getNome().compareTo(o2.getNome());
		}
	});
	return resp;
	
	}
	public static Vector<Cliente>clienteHashToVector(){
		Vector<Cliente>resp = new Vector<Cliente>();
		for(Cliente obj : listaClientes.values()){
			resp.add(obj);
		}
		return resp;
	}
	public static void clienteVectorToHash(Vector<Cliente> listaCli){
		for(Cliente obj : listaCli){
			listaClientes.put(obj.getCpf(),obj);
		}
		}
	public static void excluirCliente(Cliente obj){
		listaClientes.remove(obj.getCpf());
	}
	public static Vector<Cliente> listaClientesNasc(int mes) throws ClienteException{
		Vector<Cliente>resp = new Vector<Cliente>();
		
		for (Cliente obj : listaClientes.values()) {
			if(obj.getNascimento().get(GregorianCalendar.MONTH) == mes-1){
				resp.add(obj);
			}
		}
		if(resp.isEmpty()){
			throw new ClienteException("Não existe cliente p/ o mês de nasc.");
		}
		Collections.sort(resp, new Comparator<Cliente>() {

			@Override
			public int compare(Cliente o1, Cliente o2) {
				if(o1.getNascimento().get(GregorianCalendar.DAY_OF_MONTH)< o2.getNascimento().get(GregorianCalendar.DAY_OF_MONTH)){
					return -1;
				}else if(o1.getNascimento().get(GregorianCalendar.DAY_OF_MONTH)> o2.getNascimento().get(GregorianCalendar.DAY_OF_MONTH)){
					return 1;
				}
				return o1.getNome().compareTo(o2.getNome());
			}
		});
		return resp;
	}
}

