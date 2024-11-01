package teste;

import utilitarios.Console;
import modelo.Cliente;

public class Teste {

	private static Cliente[] clientes = new Cliente[3]; 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		cadastrarClientes();
		listarClientes();
		consultarTelClienteCodigo();
		alterarEmailClienteCodigo();
		consultarClientesNome();
		System.out.println("Final do teste");
		System.exit(0);
	}
	private static void consultarClientesNome() {
		System.out.println("\nConsultar clientes pelo nome\n");
		String nome = "";
		do {
			nome = Console.readLine("Informe o nome para pesquisa? ");
			if (nome.trim().equals("")){
				System.out.println("Falta informa o nome.");
			} else break;
		} while (true);
		int totCliPesq = 0;
		for (Cliente objCliente : clientes) {
			if (objCliente.getNome().toUpperCase().indexOf(nome.toUpperCase()) >= 0) {
				System.out.println(objCliente.toString());
				totCliPesq++;
			}
		}
		if (totCliPesq==0) {
			System.out.println("Não foi encontrado nenhum cliente.");
		} else {
			System.out.println("Total de clientes encontrados: " + totCliPesq);
		}
		
	}
	private static void alterarEmailClienteCodigo() {
		int codigo = Console.readInt("\nCodigo do cliente para email: ");
		for (Cliente objCliente : clientes) {
			if (objCliente.getCodigo()==codigo) {
				System.out.println(objCliente.toString());
				if (Console.readLine("Deseja alterar o email: ").equalsIgnoreCase("s")) {
					String email = Console.readLine("Informe o novo email? ");
					objCliente.setEmail(email);
					System.out.println("Email foi alterado\n" + objCliente.toString());
					return;
				} else return;
			}
		}
		System.out.println("Não existe cliente para o código: " + codigo);
		
	}
	private static void consultarTelClienteCodigo() {
		int codigo = Console.readInt("Código: ");
		for (Cliente objCliente : clientes) {
			if (objCliente.getCodigo()==codigo) {
				System.out.println("Telef.: " + objCliente.getTelefone());
				return;
			}
		}
		System.out.println("Não existe cliente para o codigo " + codigo);
		
	}
	private static void listarClientes() {
		for (Cliente objCli : clientes) {
			System.out.println(objCli.toString());
		}
		
	}
	private static void cadastrarClientes() {
		clientes[0] = new Cliente(1, "Jose Carlos", "2222-3333", "jcarlos@gmail.com");
		clientes[1] = new Cliente(2, "Antonio Carlos", "3433-3333", "acarlos@gmail.com");
		clientes[2] = new Cliente(3, "Cintia Silva", "2322-3333", "cintia@gmail.com");
	}

}
