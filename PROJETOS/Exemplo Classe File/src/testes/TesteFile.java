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
			System.out.println("1-Listar nome dos arquivos e pastas do diret�rio Home");
			System.out.println("2-Listar nome dos arquivos e outros atributos e pastas do diret�rio especificado");			
			System.out.println("0-Sair");
			opcao = Console.readInt("Op��o: ");
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
					System.out.println("Op��o inv�lida.");
					break;
			}
		} while (opcao!=0);
		
	}

	private static void listarDirEspecifico() {
		System.out.println("\nNome dos arquivos e pastas do diret�rio especifico\n");
		File objFile;
		do {
			objFile = new File(Console.readLine("Nome do diret�rio : "));
			if (objFile.exists() && objFile.isDirectory()) break;
			System.out.println("Diretorio n�o existe ou n�o � diret�rio.");
		} while (true);
		double totKbytesArquivosPasta = 0;
		for (File obj : objFile.listFiles()) {
			if (obj.isFile()) {
				System.out.println(obj.getName() + " , " + LtpLib.formatarValor(obj.length()/1024.0, "##,##0.0Kb"));
				totKbytesArquivosPasta += obj.length();
			} else System.out.println(obj.getName());
		}
		System.out.println("\nTotal de espa�o ocupado pelos arquivos da pasta : " + 
				          LtpLib.formatarValor(totKbytesArquivosPasta/1024.0, "###,##0.0Kb"));
		Console.readLine();
		
	}

	private static void listarDirHome() {
		System.out.println("\nNome dos arquivos e pastas do diret�rio home\n");
		File objFile = new File(System.getProperty("user.home"));
		try {
			System.out.println("\nDiret�rio Home: " + objFile.getCanonicalPath() + "\n");			
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







