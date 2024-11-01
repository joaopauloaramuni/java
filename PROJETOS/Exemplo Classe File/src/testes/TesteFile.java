package testes;

import java.io.File;
import java.io.IOException;

import utilitarios.Console;
import utilitarios.LtpLib;

public class TesteFile {

	public static void main(String[] args) {
		menu();
		System.out.println("\nFinal dos testes");
		System.exit(0);
	}

	private static void menu() {
		int opcao=0;
		do {
			System.out.println("Menu - Teste java.io.File");
			System.out.println("1-Listar nome dos arquivos e pastas do diretório Home");
			System.out.println("2-Listar nome dos arquivos e outros atributos e pastas do diretório especificado");			
			System.out.println("0-Sair");
			opcao = Console.readInt("Opção: ");
			switch (opcao) {
				case 1:
					listarDirHome();
					break;
				case 2:
					listarDirEspecifico();
					break;					
				case 0:
					break;
				default:
					System.out.println("Opção inválida.");
					break;
			}
		} while (opcao!=0);
		
	}

	private static void listarDirEspecifico() {
		System.out.println("\nNome dos arquivos e pastas do diretório especifico\n");
		File objFile;
		do {
			objFile = new File(Console.readLine("Nome do diretório : "));
			if (objFile.exists() && objFile.isDirectory()) break;
			System.out.println("Diretorio não existe ou não é diretório.");
		} while (true);
		double totKbytesArquivosPasta = 0;
		for (File obj : objFile.listFiles()) {
			if (obj.isFile()) {
				System.out.println(obj.getName() + " , " + LtpLib.formatarValor(obj.length()/1024.0, "##,##0.0Kb"));
				totKbytesArquivosPasta += obj.length();
			} else System.out.println(obj.getName());
		}
		System.out.println("\nTotal de espaço ocupado pelos arquivos da pasta : " + 
				          LtpLib.formatarValor(totKbytesArquivosPasta/1024.0, "###,##0.0Kb"));
		Console.readLine();
		
	}

	private static void listarDirHome() {
		System.out.println("\nNome dos arquivos e pastas do diretório home\n");
		File objFile = new File(System.getProperty("user.home"));
		try {
			System.out.println("\nDiretório Home: " + objFile.getCanonicalPath() + "\n");			
			for (String objStr : objFile.list()) {
				System.out.println(objStr);
			}
			System.out.println("\nTotal de pastas e arquivos : " +
					            objFile.list().length + "\n");

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		Console.readLine();
	}

}







