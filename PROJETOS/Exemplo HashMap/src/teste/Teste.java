package teste;

import java.io.File;

import modelo.Cliente;
import utilitarios.Console;
import utilitarios.LtpLib;
import cadastrocliente.CadastroClientes;
import erros.ClientesException;

public class Teste {

	private static CadastroClientes cadastro = new CadastroClientes();
	
	public static void main(String[] args) {
		// Ler Cadastro de Clientes
		if (new File("CadClientes.obj").exists()) {
			try {
				cadastro.setCadClientes(LtpLib.lerArquivoObjetos("CadClientes.obj"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(1);
			}
		}
		menu();
		// Gravar cadastro de clientes
		try {
			LtpLib.gravarArquivoObjetos("CadClientes.obj", cadastro.getClientes());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		System.out.println("\nFinal dos testes.");
		System.exit(0);
	}

	private static void menu() {
		int opcao = 0;
		do {
			System.out.println("Cadastro de Clientes");
			System.out.println("1-Incluir Cliente");
			System.out.println("2-Consultar Cliente pelo CPF");
			System.out.println("3-Excluir Cliente");
			System.out.println("4-Consultar Cliente pelo Nome");
			System.out.println("0-Sair");
			opcao = Console.readInt("Opção: ");
			switch (opcao) {
				case 1:
					incluir();
					break;
				case 2:
					consultarCpf();
					break;
				case 4:
					consultarNome();
					break;
				case 0:
					break;
				default:
					System.out.println("Opção Inválida.");
					break;
			}
		} while (opcao!=0);
		
	}


	private static void consultarCpf() {
		System.out.println("\nConsultar Cliente pelo CPF\n");
		try {
			System.out.println(cadastro.consultarCliente(Console.readLine("CPF : ")).toString());
			
		} catch (ClientesException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void incluir() {
		System.out.println("\nIncluir Cliente\n");
		String cpf = Console.readLine("CPF : ");
		String nome = Console.readLine("Nome : ");
		String email = Console.readLine("Email : ");
		String telefone = Console.readLine("Telefone : ");
		try {
			cadastro.incluirCliente(new Cliente(cpf,nome,email,telefone));
			System.out.println("\nCliente Cadastrado\n");
		} catch (ClientesException e) {
			System.out.println(e.getMessage());
		}
	}
	private static void consultarNome() {
		System.out.println("\nConsultar Cliente pelo Nome\n");
		try {
			for (Cliente obj : cadastro.consultarNome(Console.readLine("Nome : "))) {
				System.out.println(obj.toString());
			}
		} catch (ClientesException e) {
			System.out.println(e.getMessage());
		}
	}	

}







