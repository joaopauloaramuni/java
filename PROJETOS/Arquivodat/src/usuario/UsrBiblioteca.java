package usuario;

import java.io.File;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import dados.Livro;
import cadastro.BibException;
import cadastro.Biblioteca;

import utilitarios.Console;
import utilitarios.LtpLib;

public class UsrBiblioteca {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// Leitura do cadastro
		if (new File("Cadastro.dat").exists()) {
			try {
				Biblioteca.livros = LtpLib
						.lerArquivoObjetosArray("Cadastro.dat");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(1);
			}
		}
		menu();
		try {
			LtpLib.gravarArquivoObjetosArray("Cadastro.dat", Biblioteca.livros);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(2);
		}
		System.out.println("Finalizaciones do aplicativo.");
		System.exit(0);
	}

	private static void menu() {
		int opcao = 0;
		do {

			System.out
					.println("Sistema Comercial de Controle de Compras e Vendas");
			System.out.println("1 - Cadastrar livro");
			System.out.println("2 - Excluir Livro");
			System.out.println("3 - Consultar por códido");
			System.out.println("4 - Consultar por título");
			System.out.println("5 - Consultar por período");
			System.out.println("6 - Listar livro ordem alfabética");
			System.out.println("0 - Exit ");
			opcao = Console.readInt("Digite a opção desejada: ");
			switch (opcao) {
			case 1:
				incluirLivro();

				break;
			case 2:
				excruirLivro();
				break;
			case 3:
				consultarCod();
				break;
			case 4:
				consultarTitulo();
				break;
			case 5:
				consultarData();
				break;
			case 6:
				listarLivro();
				break;
			case 0:
				break;
			default:
				System.out.println("Opção inválida");
				break;
			}

		} while (opcao != 0);

	}

	private static void incluirLivro() {
		try {
			// Codigo
			int codigo = (Biblioteca.getLivros().isEmpty() ? 1 : Biblioteca
					.getLivros().size() + 1);

			String titulo = Console.readLine("titulo");
			String autor = Console.readLine("Autor");
			String editora = Console.readLine("Editora");
			int ano = Console.readInt("Ano");
			GregorianCalendar dt = new GregorianCalendar();
			while (true) {
				String data = Console.readLine("Data");
				if (LtpLib.validarData(data, dt)) {
					break;
				} else {
					System.out.println("Data invalidê!");
				}
			}
			Biblioteca.incluirLivro(new Livro(codigo, titulo, autor, editora,
					ano, dt));

		} catch (BibException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void excruirLivro() {
		int codigo = Console
				.readInt("Por favor, digite o codigo do seu livro para que eu possa fazer a pesquisa e"
						+ "solicitar confirmação de exclusão: ");

		try {
			Livro obj = Biblioteca.consultarLivro(codigo);
			String resp = Console.readLine("Deseja excluir?");
			if (resp.equals("s") || resp.equals("sim")) {
				Biblioteca.excluirLivro(obj);
				System.out.println("Livro excluido");
			}
		} catch (BibException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void consultarCod() {
		int codigo = Console
				.readInt("Por favor, digite o codigo do seu livro para que eu possa fazer a pesquisa: ");
		try {
			Livro obj = Biblioteca.consultarLivro(codigo);
			System.out.println(obj.toString());
		} catch (BibException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void consultarTitulo() {
		String titulo = Console
				.readLine("Por favor, digite o titulo do seu livro para que eu possa fazer a pesquisa: ");
		try {
			Livro obj = Biblioteca.consultarTitulo(titulo);
			System.out.println(obj.toString());
		} catch (BibException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void consultarData() {

		try {
			GregorianCalendar dt = new GregorianCalendar();
			while (true) {
				String data = Console
						.readLine("Por favor, digite a data do seu livro para que eu possa fazer a pesquisa: ");
				if (LtpLib.validarData(data, dt)) {
					break;
				} else
					System.out.println("Data invalidê!");
			}
			Livro obj = Biblioteca.consultarData(dt);
			System.out.println(obj.toString());
		} catch (BibException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void listarLivro() {
		ArrayList<Livro> resposta = new ArrayList<Livro>();
		try {
			resposta = Biblioteca.listaOrdem();
			for (Livro livro : resposta) {
				System.out.println(livro.toString());
			}
		} catch (BibException e) {
			System.out.println(e.getMessage());
		}
	}
}
