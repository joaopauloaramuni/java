package menu;

import utilitarios.Console;

public class Menu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		menu();
		System.out.println("Final dos Testes.");
		System.exit(0);
	}

	private static void menu() {
		int opcao = 0; // Sair do menu opcao = 0
		do {
			System.out.println("Cadastro de Clientes");
			System.out.println("1 - Incluir novo cliente");
			System.out.println("2 - Alterar");
			System.out.println("3 - Excluir Cliente");
			System.out.println("4 - Consultar cliente pelo código");
			System.out.println("0 - Sair");

			opcao = Console.readInt("Opção: ");
			switch (opcao) {
			case 1:
				// Chamar o Método Correspondente
				break;
			case 2:
				// Chamar o Método Correspondente
				break;
			case 3:
				// Chamar o Método Correspondente
				break;
			case 4:
				// Chamar o Método Correspondente
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

}
