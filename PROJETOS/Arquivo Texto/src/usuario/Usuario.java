package usuario;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.GregorianCalendar;

import cadastro.Cadastro;
import dados.Produto;
import utilitarios.Console;
import utilitarios.LtpLib;

public class Usuario {

	public static void main(String[] args) {
		menu();
		System.out.println("Final do Teste.");
		System.exit(0);
	}

	private static void menu() {
		int opcao = 0;
		do {
			System.out.println("Menu Arquivo Texto");
			System.out.println("1-Cadastrar Produto");
			System.out.println("2-Gravar Arquivo Texto");
			System.out.println("0-sair");
			opcao = Console.readInt("Opção: ");
			switch (opcao) {
			case 1:
				incluirProd();
				break;

			case 2:
				gravarArqTexto();
				break;

			case 0:
				break;

			default:
				System.out.println("Opção Inválida.");
				break;
			}

		} while (opcao != 0);

	}

	private static void gravarArqTexto() {
		System.out.println("\nGravar Arquivo Texto\n");
		
		//Abertura do arquivo para gravação
		
		try {
			BufferedWriter objArq = new BufferedWriter(new FileWriter("TabProdutos.txt"));
			for(Produto obj : Cadastro.listaProd){
				String codigo = String.valueOf(obj.getCodigo());
				int zeroEsq = 5 - codigo.length();
				for(int z = 1; z<=zeroEsq; z++)
					codigo = "0" + codigo;
				String nome = obj.getNome();
				int espacosDir = 40-nome.length();
				for(int b = 1; b<=espacosDir;b++)
					nome+=" ";
				String preco = LtpLib.formatarValor(obj.getPreco(),"00000.00");
				preco = preco.replace(",","");
				String data = LtpLib.formatarData(obj.getData(), "ddMMyyyy");
				//Gravar Linha
				objArq.write(codigo+nome+preco+data+"\n");
			}
			//Fechar Arquivo
			objArq.close();
			System.out.println("Arquivo texto foi gravado.");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void incluirProd() {
		System.out.println("\nCadastrar Produto\n");
		int codigo = 0;
		if (Cadastro.listaProd.isEmpty()) {
			codigo = 1;
		} else {
			codigo = Cadastro.listaProd.lastElement().getCodigo() + 1;
		}
		String nome = Console.readLine("Nome: ");
		double preco = Console.readDouble("Preço: ");
		GregorianCalendar data = new GregorianCalendar();
		while (true) {
			String dt = Console.readLine("Data: ");
			if (LtpLib.validarData(dt, data))
				break;
			System.out.println("Data inválida.");
		}
		Cadastro.incluirProd(new Produto(codigo, nome, preco, data));
		System.out.println("Produto cadastrado.");
	}

}
