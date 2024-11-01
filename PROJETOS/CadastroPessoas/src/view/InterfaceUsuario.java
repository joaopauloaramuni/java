package view;

import java.io.File;
import java.util.ArrayList;

import controller.Cadastro;
import model.Cliente;
import model.Empregado;
import model.Gerente;
import model.Pessoa;
import model.Vendedor;
import utilitarios.Console;
import utilitarios.LtpLib;

public class InterfaceUsuario {
	
	public static void main(String[] args) {

		// LER ARQUIVO DE OBJETOS DA CLASSE PRODUTO
		if (new File("Pessoas.obj").exists()) {
			try {
				Cadastro.pessoas = LtpLib.lerArquivoObjetosArray("Pessoas.obj");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(1);
			}
		}
		menu();
		// GRAVAR ARQUIVOS DE OBJETOS DA CLASSE PRODUTO
		try {
			LtpLib.gravarArquivoObjetosArray("Pessoas.obj", Cadastro.pessoas);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(2);
		}
		System.out.println("\nFinal do aplicativo.");
		System.exit(0);
	}
	
	private static void menu() {
		int opcao = 0;
		do {
			System.out.println("\nMenu Pessoas");
			System.out.println("1-Cadastrar Cliente");
			System.out.println("2-Cadastrar Empregado");
			System.out.println("3-Cadastrar Gerente");
			System.out.println("4-Cadastrar Vendedor");
			System.out.println("0-Sair do aplicativo");
			opcao = Console.readInt("Opção: ");
			switch (opcao) {
			case 1:
				Cliente cliente = new Cliente();
				//Leitura dos dados do usuário
				
				
				Cadastro.cadastrarCliente(cliente);
				break;
			case 2:
				Empregado empregado = new Empregado();
				//Leitura dos dados do usuário
				
				Cadastro.cadastrarEmpregado(empregado);
				break;
			case 3:
				Gerente gerente = new Gerente();
				//Leitura dos dados do usuário
				
				Cadastro.cadastrarGerente(gerente);
				break;
			case 4:
				Vendedor vendedor = new Vendedor();
				//Leitura dos dados do usuário
				
				Cadastro.cadastrarVendedor(vendedor);
				break;
			case 0: // Sair

				break;

			default:
				System.out.println("Opção Inválida.");

				break;
			}
		} while (opcao != 0);

	}
}
