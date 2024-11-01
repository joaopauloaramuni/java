package clientesinterface;

import java.io.File;
import java.util.GregorianCalendar;
import java.util.Vector;

import utilitarios.Console;
import utilitarios.LtpLib;
import clientescadastro.CadastroClientes;
import clientesmodelo.Cliente;

public class ClientesUsuario {

    // Atributos
	private static CadastroClientes objCadastro = new CadastroClientes();
	
	public static void main(String[] args) {
		// Ler Arquivo de Objetos e Criar a lista de clientes
		try {
			if (new File("Clientes.obj").exists()){
				Vector<Cliente> listaClientes = (Vector<Cliente>)LtpLib.lerArquivoObjetos("Clientes.obj");
				objCadastro.setListaClientes(listaClientes);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		menu();
		
		// Gravar objetos da lista de clientes no arquivo
		try {
			LtpLib.gravarArquivoObjetos("Clientes.obj", objCadastro.getListaClientes());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		System.out.println("\nFinal da aplicação");
		System.exit(0);
	}

	private static void menu() {
		int opcao= 0;
		do {
			System.out.println("\nCadastro de Clientes");
			System.out.println("1-Incluir Cliente");
			System.out.println("2-Alterar Cliente");
			System.out.println("3-Excluir Cliente");
			System.out.println("4-Consultar Cliente por código");
			System.out.println("5-Consultar Clientes por nome");
			System.out.println("6-Consultar Clientes por mes de nascimento");
			System.out.println("0-Sair");
			opcao = Console.readInt("Opção: ");
			switch (opcao) {
				case 1:
					incluirCliente();
					break;
				case 2:
					alterarCliente();
					break;
				case 3:
					excluirCliente();
					break;
				case 4:
					consultarClienteCodigo();
					break;
				case 5:
					consultarClienteNome();
					break;
				case 6:
					consultarClienteMesNasc();
					break;					
				case 0:
					break;
				default:
					System.out.println("Opção Inválida.");
					break;
			}
		} while (opcao!=0);
	}

	private static void alterarCliente() {
		System.out.println("\nAlterar Cliente\n");
		int codigo = Console.readInt("Código: ");
		try {
			Cliente objCliente = objCadastro.consultarCodigo(codigo);
			Cliente objClienteCopia = objCliente.clone();
			System.out.println(objCliente.toString());
			String nome = "";
			String telefone = "";
			GregorianCalendar nascimento = new GregorianCalendar();
			String email = "";
			int campo = 0;
			do {
				campo = Integer.parseInt(Console.readLine("\nMenu Campo Alteração\n"+ 
										 "1-NOME\n"+
										 "2-TELEFONE\n"+
										 "3-NASCIMENTO\n"+
										 "4-EMAIL\n"+
										 "0-Finalizar\n"));
				switch (campo) {
					case 1:
						do {
							nome = Console.readLine("Nome: ");
							if (nome.trim().equals(""))
								System.out.println("Falta informar o nome.");
							else break;
						} while (true);
						objCliente.setNome(nome);
						break;
					case 2:
						do {
							telefone = Console.readLine("Telefone: ");
							if (telefone.trim().equals(""))
								System.out.println("Falta informar o telefone.");
							else break;
						} while (true);	
						objCliente.setTelefone(telefone);
						break;
					case 3:
						do {
							String nasc = Console.readLine("Nascimento: ");
							if (!LtpLib.validarData(nasc, nascimento))
								System.out.println("Nascimento inválido.");
							else break;
						} while (true);
						objCliente.setNascimento(nascimento);
						break;
					case 4:
						email = Console.readLine("Email: ");
						objCliente.setEmail(email);
						break;
					case 0 :
						break;
					default:
						System.out.println("Campo inválido.");
						break;
				}
										 
			} while (campo!=0);
			if (!objCliente.equals(objClienteCopia))
				System.out.println("Cliente Alterado.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Console.readLine("\n<ENTER>");
		
	}

	private static void excluirCliente() {
		System.out.println("\nExcluir Cliente\n");
		int codigo = Console.readInt("Código: ");
		try {
			Cliente objCliente = objCadastro.consultarCodigo(codigo);
			System.out.println(objCliente.toString());
			if (Console.readLine("Confirmar a exclusão(s/n)? ").equalsIgnoreCase("s")) {
				objCadastro.excluirCliente(objCliente);
				System.out.println("Cliente excluído.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Console.readLine("\n<ENTER>");
		
	}

	private static void consultarClienteMesNasc() {
		System.out.println("\nConsultar Cliente por Mes Nascimento\n");
		int mes = Console.readInt("Mes: ");
		try {
			for (Cliente objCliente : objCadastro.consultarMesNascimento(mes)) {
				System.out.println(objCliente.toString());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Console.readLine("\n<ENTER>");
		
	}

	private static void consultarClienteNome() {
		System.out.println("\nConsultar Cliente por Nome\n");
		String nome = Console.readLine("Nome: ");
		try {
			for (Cliente objCliente : objCadastro.consultarNome(nome)) {
				System.out.println(objCliente.toString());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Console.readLine("\n<ENTER>");
		
	}

	private static void consultarClienteCodigo() {
		System.out.println("\nConsultar Cliente por Código\n");
		int codigo = Console.readInt("Código : ");
		try {
			System.out.println(objCadastro.consultarCodigo(codigo).toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Console.readLine("\n<ENTER>");
		
	}

	private static void incluirCliente() {
		System.out.println("\nInclusão de Cliente\n");
		int codigo = 0;
		String nome = "";
		String telefone = "";
		GregorianCalendar nascimento = new GregorianCalendar();
		String email = "";
		codigo = (objCadastro.getListaClientes().isEmpty() ? 1 :
			      objCadastro.getListaClientes().lastElement().getCodigo()+1);
		do {
			nome = Console.readLine("Nome: ");
			if (nome.trim().equals(""))
				System.out.println("Falta informar o nome.");
			else break;
		} while (true);
		do {
			telefone = Console.readLine("Telefone: ");
			if (telefone.trim().equals(""))
				System.out.println("Falta informar o telefone.");
			else break;
		} while (true);	
		do {
			String nasc = Console.readLine("Nascimento: ");
			if (!LtpLib.validarData(nasc, nascimento))
				System.out.println("Nascimento inválido.");
			else break;
		} while (true);
		email = Console.readLine("Email: ");
		
		try {
			objCadastro.incluirCliente(new Cliente(codigo,nome,telefone,nascimento,email));
			System.out.println("\nCliente Cadastrado com código " + codigo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Console.readLine("\n<ENTER>");
	}

}












