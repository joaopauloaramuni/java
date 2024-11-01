package usuario;

import java.io.File;
import java.util.GregorianCalendar;

import cadastro.Cadastro;
import dados.Cliente;
import erros.ClienteException;

import utilitarios.Console;
import utilitarios.LtpLib;

public class Usuario {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		if (new File("CadClientes").exists()) {
			try {
				Cadastro.clienteVectorToHash(LtpLib
						.lerArquivoObjetos("CadClientes.obj"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println(1);
			}
		}
		menu();
		try {
			LtpLib.gravarArquivoObjetos("CadClientes.obj", Cadastro
					.clienteHashToVector());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(2);
		}
	}

	private static void menu() {
		int opcao = 0;
		do {
			System.out.println("\nMenu Cliente");
			System.out.println("1-Incluir Cliente");
			System.out.println("2-Consultar pelo CPF");
			System.out.println("3-Consultar pelo Nome");
			System.out.println("4-Consultar pelo Mês de Nascimento");
			System.out.println("5-Excluir Cliente");
			System.out.println("0-Sair do Aplicativo");
			opcao = Console.readInt("Opção: ");
			switch (opcao) {
			case 1:
				incluirCliente();
				break;
			case 2:
				consultarCPF();
				break;
			case 3:
				consultarNome();
				break;
			case 4:
				consultarMesNasc();
				break;
			case 5:
				excluirCliente();
				break;
			case 0:
				// Sair
				break;

			default:
				System.out.println("Opção Inválida.");
				break;
			}
		} while (opcao != 0);

	}

	private static void incluirCliente() {
		System.out.println("\nIncluir Cliente");
		// CPF
		String cpf = "";
		while (true) {
			Console.readLine("CPF: ");
			if (LtpLib.validarCPF(cpf)
					&& !Cadastro.listaClientes.containsKey(cpf))
				break;
			System.out.println("CPF inválido ou já cadastrado.");
		}
		//Nome
		String nome = "";
		while(true){
			nome = Console.readLine("Nome: ").trim();
			if(!nome.isEmpty() && LtpLib.contarPalavras(nome)>1)
				break;
			System.out.println("Falta nome ou nome com uma palavra");
			
		}
		//E-mail
		String email="";
		while(true){
			email = Console.readLine("E-mail: ");
			if(LtpLib.validarEmail(email))break;
			System.out.println("E-mail inválido.");
		}
		//Telefone
		String telefone ="";
		while(true){
			telefone = Console.readLine("Telefone: ");
			if(!telefone.isEmpty())break;
			System.out.println("Telefone Inválido.");
		}
		//Nascimento
		GregorianCalendar nascimento = new GregorianCalendar();
		String nasc = "";
		while(true){
			nasc = Console.readLine("Nascimento: ");
			if(LtpLib.validarData(nasc,nascimento) && nascimento.compareTo(new GregorianCalendar())<0)
				break;
			System.out.println("Data inválida ou maior que a data corrente.");
		}
		//Cadastrar Cliente
		try {
			Cadastro.incluirCliente(new Cliente(cpf, nome, email, telefone, nascimento));
			System.out.println("Cliente Incluído.");
		} catch (ClienteException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void consultarCPF() {
		System.out.println("\nConsultar Cliente pelo CPF");
		try {
			String cpf = Console.readLine("CPF: ");
			System.out.println(Cadastro.consClienteCPF(cpf).toString());
		} catch (ClienteException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void consultarNome() {
		System.out.println("\nConsultar Cliente pelo Nome");

	}

	private static void consultarMesNasc() {

	}

	private static void excluirCliente() {
		System.out.println("\nExcluir Cliente");

	}
}
