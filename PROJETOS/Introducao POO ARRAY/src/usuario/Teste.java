package usuario;

import utilitarios.Console;
import dados.Cliente;

public class Teste {

    private static Cliente[] cadClientes = new Cliente[3];
	
	public static void main(String[] args) {
		cadastrarClientes();
		listarClientes();
		consultarClienteNome();
		//consultarTelClienteCodigo();
		//alterarEmailClienteCodigo();
		System.out.println("Final do teste");
		System.exit(0);
	}

	private static void consultarClienteNome() {
		String nome = "";
		do {
			nome = Console.readLine("Nome: ");
			if (nome.trim().equals("")) {
				System.out.println("Falta informar nome.");
			} else break;
		} while (true);
		
		int totClientes = 0;
		for (Cliente objCliente : cadClientes) {
			if (objCliente.getNome().toUpperCase().indexOf(nome.toUpperCase()) != -1) {
				System.out.println(objCliente.toString());
				totClientes++;
			}
		}
		if (totClientes==0) {
			System.out.println("Não existe cliente para o nome informado.");
		} else {
			System.out.println("Foram encontrados " + totClientes + " clientes.");
		}
	}

	private static void alterarEmailClienteCodigo() {
		int codigo = Console.readInt("Codigo: ");
		for (Cliente objCliente : cadClientes) {
			if (objCliente.getCodigo()==codigo) {
				System.out.println(objCliente.toString());
				if (Console.readLine("Deseja alterar o email?").equalsIgnoreCase("s")) {
					String email = Console.readLine("E-mail: ");
					objCliente.setEmail(email);
					System.out.println("E-mail foi alterado.");
					System.out.println(objCliente.toString());
					return;
				} else return;
			}
		}
		System.out.println("Não existe cliente para o codigo informado");
		
	}

	private static void consultarTelClienteCodigo() {
		int codigo = Console.readInt("Codigo do Cliente: ");
		for (Cliente objCliente : cadClientes) {
			if (objCliente.getCodigo()==codigo) {
				System.out.println("Telefone: " + objCliente.getTelefone());
				Console.readLine("ENTER");
				return;
			}
		}
		System.out.println("Não existe cliente para o codigo informado.");
		Console.readLine("ENTER");
	}

	private static void listarClientes() {
		for (Cliente objCliente : cadClientes) {
			System.out.println(objCliente.toString());
		}
		
	}

	private static void cadastrarClientes() {
		cadClientes[0] = new Cliente(1, "Jose Carlos", "2222-3333", "jcarlos@gmail.com");
		cadClientes[1] = new Cliente(2, "Antonio Carlos", "4444-3333", "acarlos@gmail.com");
		cadClientes[2] = new Cliente(3, "Jose Maria", "3322-3333", "jmaria@gmail.com");
	}

}







