package usuario;

import java.io.File;
import java.util.GregorianCalendar;

import cadastro.Cadastro;
import dados.Produto;
import utilitarios.Console;
import utilitarios.LtpLib;

public class Usuario {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// LER ARQUIVO DE OBJETOS DA CLASSE PRODUTO
		if (new File("Produtos.obj").exists()) {
			try {
				Cadastro.cadProd = LtpLib.lerArquivoObjetosArray("Produtos.obj");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(1);
			}
		}
		menu();
		// GRAVAR ARQUIVOS DE OBJETOS DA CLASSE PRODUTO
		try {
			LtpLib.gravarArquivoObjetosArray("Produtos.obj", Cadastro.cadProd);
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
			System.out.println("\nMenu Produto");
			System.out.println("1-Incluir Produto");
			System.out.println("2-Alterar Produto");
			System.out.println("3-Excluir Produto");
			System.out.println("4-Consultar Produto pelo C�digo");
			System.out.println("5-Consultar Produto pelo Nome");
			System.out.println("0-Sair do aplicativo");
			opcao = Console.readInt("Op��o: ");
			switch (opcao) {
			case 1:
				incluirProduto();
				break;
			case 2:
				alterarProduto();
				break;
			case 3:
				excluirProduto();
				break;
			case 4:
				consultarProdutoCodigo();
				break;
			case 5:
				consultarProdutoNome();
				break;
			case 0: // Sair

				break;

			default:
				System.out.println("Op��o Inv�lida.");

				break;
			}
		} while (opcao != 0);

	}

	private static void alterarProduto() {
		System.out.println("\nAlterar Produto\n");
		try {
			int codigo = Console.readInt("C�digo: ");
			Produto obj = Cadastro.consultarProdCodigo(codigo);
			System.out.println("\n" + obj.toString());
			int campo = 0;
			Produto obj1 = obj.clone();
			do {
				System.out.println("1 - Alterar descri��o");
				System.out.println("2 - Alterar pre�o");
				System.out.println("0 - Sair");
				campo = Console.readInt("Campo: ");
				switch (campo) {
				case 1:
					String descricao ="";
					while (true) {
						descricao = Console.readLine("Descri��o: ").trim();
						if (!descricao.equals(""))
							break;
						System.out.println("Falta informar a descri��o.");
					}
					obj.setDescricao(descricao);
					break;
				case 2:
					double preco = 0;
					while (true) {
						preco = Console.readDouble("Pre�o: ");
						if (preco > 0)
							break;
						System.out.println("Falta informar o pre�o.");
					}
					obj.setPreco(preco);
					break;
				case 0:
					break;
					
				default:
					System.out.println("Campo inv�lido.");
					break;
				}
			} while (campo != 0);
			if(!obj.equals(obj1)){
				obj.setData(new GregorianCalendar());
				System.out.println("Produto alterado.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void consultarProdutoNome() {
		System.out.println("\nConsultar produto pelo nome\n");
		try {
			for (Produto obj : Cadastro.consultarProdNome(Console.readLine("Nome: "))) {
				System.out.println(obj.toString());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void excluirProduto() {
		System.out.println("\nExcluir produto pelo c�digo\n");
		try {
			Produto obj = Cadastro.consultarProdCodigo(Console.readInt("C�digo: "));
			System.out.println("\n" + obj.toString());
			if (Console.readLine("Confirmar Exclus�o (S/N) ?").trim().equalsIgnoreCase("S")) {
				Cadastro.excluirProduto(obj);
				System.out.println("Produto Excluido.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void consultarProdutoCodigo() {
		System.out.println("\nConsultar produto pelo c�digo\n");
		try {
			Produto obj = Cadastro.consultarProdCodigo(Console.readInt("C�digo: "));
			System.out.println(obj.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void incluirProduto() {
		System.out.println("\nIncluir Produto\n");
		int codigo = (Cadastro.cadProd.isEmpty() ? 1 : Cadastro.cadProd.size() + 1);
		String descricao = "";
		while (true) {
			descricao = Console.readLine("Descri��o: ").trim();
			if (!descricao.equals(""))
				break;
			System.out.println("Falta informar a descri��o.");
		}
		double preco = 0;
		while (true) {
			preco = Console.readDouble("Pre�o: ");
			if (preco > 0)
				break;
			System.out.println("Falta informar o pre�o.");
		}
		GregorianCalendar data = new GregorianCalendar();
		try {
			Cadastro.incluirProduto(new Produto(codigo, descricao, preco, data));
			System.out.println("Produto cadastrado.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
