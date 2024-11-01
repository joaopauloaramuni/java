package usuario;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import utilitarios.Console;

import dados.Cliente;

public class Usuario {

	private Vector<Cliente> listaClientes = new Vector<Cliente>();
	
	public static void main(String[] args) {
		Usuario objUsuario = new Usuario();
		objUsuario.menu();
		System.out.println("\nFinal dos testes.");
		System.exit(0);

	}

	private void menu() {
		int opcao = 0;
		do {
			System.out.println("\nMenu Clientes");
			System.out.println("1-Cadastrar cliente");
			System.out.println("2-Listar clientes pelo nome - Interface Comparable");
			System.out.println("3-Listar clientes pelo nome - Interface Comparator - C.Interna");
			System.out.println("4-Listar clientes pelo nome - Interface Comparator - C.Interna anonima");
			System.out.println("5-Listar clientes por cidade e nome");
			System.out.println("6-Listar clientes por Código (Descendete)");
			System.out.println("7-Listar clientes por Cidade (Asc) e Limite de Crédito(Desc) - CIA");
			System.out.println("0-Sair");
			opcao=Console.readInt("Opcao: ");
			switch (opcao) {
				case 1:
					incluirCliente();
					break;
				case 2:
					listarClientesComparable();
					break;
				case 3:
					listarClientesComparatorCI();
					break;	
				case 4:
					listarClientesComparatorCIA();
					break;
				case 5:
					listarCidadeNome();
					break;
				case 6:
					listarClientesCodigoDescCi();
					break;
				case 7:
					listarClientes2();
					break;
				case 0 : break;
				default:
					System.out.println("Opção Inválida.");
					break;
			}
		} while (opcao!=0);
		
	}

	@SuppressWarnings("unchecked")
	private void listarClientes2() {
		
			System.out
					.println("\nLista de Clientes por Cidade(Asc) e Limite de Crédito(Desc)\n");
			Vector<Cliente> clientesCopia = (Vector<Cliente>) listaClientes.clone();
			Collections.sort(clientesCopia, new Comparator<Cliente>() {

				@Override
				public int compare(Cliente o1, Cliente o2) {
					int chavePrincipal = o1.getCidade().compareTo(o2.getCidade());
					if (chavePrincipal != 0)
						return chavePrincipal;
					if (o1.getLimCredito() == o2.getLimCredito())
						return 0;
					else if (o1.getLimCredito() < o2.getLimCredito())
						return 1;
					else
						return -1;
				}
			});
			for (Cliente obj : clientesCopia)
				System.out.println(obj.toString());
		
		
	}

	@SuppressWarnings("unchecked")
	private void listarClientesCodigoDescCi() {
		System.out.println("\nLista de Clientes - usando Comparator - Classe Interna Anonima\n");
		Vector<Cliente> clientesCopia = (Vector<Cliente>)listaClientes.clone();
		Collections.sort(clientesCopia,new Usuario.CliCodigoDesc());
		for (Cliente obj : clientesCopia) 
			System.out.println(obj.toString());	
	}

	@SuppressWarnings("unchecked")
	private void listarCidadeNome() {
		System.out.println("\nLista de clientes por cidade e nome\n");
		Vector<Cliente> clientesCopia = (Vector<Cliente>)listaClientes.clone();
		Collections.sort(clientesCopia, new Comparator<Cliente>() {

			@Override
			public int compare(Cliente o1, Cliente o2) {
				// TODO Auto-generated method stub
				int chavePrincipal = o1.getCidade().compareTo(o2.getCidade());
				if (chavePrincipal!=0) return chavePrincipal;
				return o1.getNome().compareTo(o2.getNome());
			}
		});
		for (Cliente obj : clientesCopia) 
			System.out.println(obj.toString());	
		
	}

	@SuppressWarnings("unchecked")
	private void listarClientesComparatorCIA() {
		System.out.println("\nLista de Clientes - usando Comparator - Classe Interna Anonima\n");
		Vector<Cliente> clientesCopia = (Vector<Cliente>)listaClientes.clone();
		Collections.sort(clientesCopia, new Comparator<Cliente>() {

			@Override
			public int compare(Cliente o1, Cliente o2) {
				// TODO Auto-generated method stub
				return o1.getNome().compareTo(o2.getNome());
			}
		});
		for (Cliente obj : clientesCopia) 
			System.out.println(obj.toString());	
	}

	@SuppressWarnings("unchecked")
	private void listarClientesComparatorCI() {
		System.out.println("\nLista de Clientes - usando Comparator - Classe Interna\n");
		Vector<Cliente> clientesCopia = (Vector<Cliente>)listaClientes.clone();
		Collections.sort(clientesCopia, new Usuario.CliNome());
		for (Cliente obj : clientesCopia) 
			System.out.println(obj.toString());		
	}

	@SuppressWarnings("unchecked")
	private void listarClientesComparable() {
		System.out.println("Lista de clientes - usando Comparable\n");
		Vector<Cliente> clientesCopia = (Vector<Cliente>)listaClientes.clone();
		Collections.sort(clientesCopia);
		for (Cliente obj : clientesCopia) 
			System.out.println(obj.toString());
		
	}

	private void incluirCliente() {
		System.out.println("\nCadastrar Cliente\n");
		int codigo=0;
		String nome;
		String cidade;
		String telefone;
		codigo = (listaClientes.isEmpty()) ? 1 
				     : listaClientes.lastElement().getCodigo()+1;
		nome = Console.readLine("Nome: ");
		cidade = Console.readLine("Cidade: ");
		telefone = Console.readLine("Telefone: ");
		double limCredito = Console.readDouble("Limite de Crédito: ");
		listaClientes.add(new Cliente(codigo, nome, cidade, telefone,limCredito));
		System.out.println("Cliente cadastrado.");
	}
	
	// Classe Interna.
	
	class CliNome implements Comparator<Cliente> {

		@Override
		public int compare(Cliente o1, Cliente o2) {
			// TODO Auto-generated method stub
			return o1.getNome().compareTo(o2.getNome());
		}
		
	}
	
	//Classe Interna.
	
	class CliCodigoDesc implements Comparator<Cliente>{
		@Override
		public int compare(Cliente o1, Cliente o2) {
			// TODO Auto-generated method stub
			if(o1.getCodigo() == o2.getCodigo())return 0;
			else if(o1.getCodigo()<o2.getCodigo())return 1;
			else return -1;
		}
	}

} // final da classe Usuário
