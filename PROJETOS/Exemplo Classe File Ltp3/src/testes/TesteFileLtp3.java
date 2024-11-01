package testes;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Vector;

import utilitarios.Console;
import utilitarios.LtpLib;


public class TesteFileLtp3 {
	
	private static int tamanhoBytes = 0;	
	private static double totKbytesArquivosPasta = 0;
	private static int totArq = 0;
	private static Vector<ArquivoSelecionado> listaArq = new Vector<ArquivoSelecionado>();
	private static int totPesq = 0;
	
	public static void main(String[] args) {
		menu();
		System.out.println("\nFinal do Aplicativo");
		System.exit(0);
	}

	private static void menu() {
		int opcao=0;
		do {
			System.out.println("Menu - Teste java.io.File");
			System.out.println("1-Listar nome dos arquivos e pastas do diretório Home");
			System.out.println("2-Listar nome dos arquivos e outros atributos e pastas do diretório especificado");
			System.out.println("3-Listar arquivos da pasta com tamanho acima do especificado");
			System.out.println("4-Listar arvore de pasta especifica");
			System.out.println("5-Pesquisar arquivo em arvore de diretório especificado");
			System.out.println("0-Sair");
			opcao = Console.readInt("Opção: ");
			switch (opcao) {
				case 1:
					listarDirHome();
					break;
				case 2:
					listarDirEspecifico();
					break;
				case 3:
					listarArqGrandesDirEspecifico();
					break;
				case 4:
					String pasta = Console.readLine("Nome da Pasta : ");
					File objFile;
					do {
						objFile = new File(pasta);
						if (objFile.exists() && objFile.isDirectory()) break;
						System.out.println("Diretorio não existe ou não é diretório.");
					} while (true);
					listarArvoreDirEspecifico(objFile);
					Console.readLine();
					break;
				case 5:
					System.out.println("\nPesquisar arquivo em arvore de diretório especificado\n");
					String pastaPesq = "";
					File objFilePesq;
					do {
						pastaPesq = Console.readLine("Nome da Pasta : ");
						objFilePesq = new File(pastaPesq);
						if (objFilePesq.exists() && objFilePesq.isDirectory()) break;
						System.out.println("Diretorio não existe ou não é diretório.");
					} while (true);
					
					String arquivo = Console.readLine("Arquivo: ");
					totPesq = 0;
					pesquisarArvoreDirEspecifico(objFilePesq, arquivo);
					System.out.println("Total de arquivos que atenderam a pesquisa : " + totPesq);
					System.out.println("Pesquisa concluida.");
					Console.readLine();
					break;
				case 0:
					break;
				default:
					System.out.println("Opção inválida.");
					break;
			}
		} while (opcao!=0);

	}


	private static void listarDirHome() {
		System.out.println("\nNome dos arquivos e pastas do diretório home\n");
		File objFile = new File(System.getProperty("user.home"));
		System.out.println("\nHOME: " + objFile.getAbsolutePath() + "\n");
		for (String objStr : objFile.list()) {
			System.out.println(objStr);
		}
		System.out.println("\nTotal de pastas e arquivos : " +
				            objFile.list().length + "\n");
		Console.readLine();
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


	private static void listarArqGrandesDirEspecifico() {
		System.out.println("\nArquivos da pasta com tamanho acima do especificado\n");
		File objFile;
		tamanhoBytes = 0;
		do {
			objFile = new File(Console.readLine("Nome do diretório : "));
			if (objFile.exists() && objFile.isDirectory()) {
				tamanhoBytes = Console.readInt("Tamanho minimo do arquivos em Kbytes: ");
				if (tamanhoBytes >= 0) break;
				System.out.println("Tamanho minimo do arquivos em bytes inválido.");
				continue;
			}
			else System.out.println("Diretorio não existe ou não é diretório.");
		} while (true);
		tamanhoBytes *= 1024; 
		totKbytesArquivosPasta = 0;
		totArq = 0;
		listaArq.clear();
		criarLista(objFile);
		Collections.sort(listaArq, new Comparator<ArquivoSelecionado>() {

			@Override
			public int compare(ArquivoSelecionado o1, ArquivoSelecionado o2) {
					return String.valueOf(o2.getTamanho()).compareTo(String.valueOf(o1.getTamanho()));
			} });
		System.out.println("\nListagem dos arquivos\n");
		for (ArquivoSelecionado objArq : listaArq) {
			System.out.println(objArq.toString());
		}
		System.out.println("\nTotal de arquivos : " + 
		          LtpLib.formatarValor(totArq, "###,##0"));
		System.out.println("\nTotal de espaço ocupado pelos arquivos da pasta : " + 
		          LtpLib.formatarValor(totKbytesArquivosPasta/1024.0, "###,##0.0Kb"));
		Console.readLine();		
	}

	/**
	 * Criar lista de arquivos via filtro - Recursivo
	 * @param objFileDir - Diretório
	 */
	private static void criarLista(File objFileDir) {
		for (File obj : objFileDir.listFiles()) {
			if (obj.isFile()  && obj.length() >= tamanhoBytes) {
				GregorianCalendar dt = new GregorianCalendar();
				dt.setTimeInMillis(obj.lastModified());
				listaArq.add(new ArquivoSelecionado(obj.getAbsolutePath() ,obj.length(),dt));
				totKbytesArquivosPasta += obj.length();
				totArq++;
				System.out.println("Quantidade acumulada localizada até o momento : " + totArq);
			} else if (obj.isDirectory()) criarLista(obj);		
		}
	}
	
	private static void listarArvoreDirEspecifico(File objFile) {
		System.out.println("\nNome dos arquivos e pastas do diretório especifico : " + objFile.getName() +"\n");
		double totKbytesArquivosPasta = 0;
		for (File obj : objFile.listFiles()) {
			if (obj.isFile()) {
				System.out.println(obj.getName() + " , " + LtpLib.formatarValor(obj.length()/1024.0, "##,##0.0Kb"));
				totKbytesArquivosPasta += obj.length();
			} else if (obj.isDirectory()) {
				listarArvoreDirEspecifico(obj);//System.out.println(obj.getName());
			} else System.out.println(obj.getName());

		}
		System.out.println("\nTotal de espaço ocupado pelos arquivos da pasta : " + objFile.getName() + " - " +
				          LtpLib.formatarValor(totKbytesArquivosPasta/1024.0, "###,##0.0Kb"));

	}	
	/**
	 * Pesquisar arquivo em arvore de pasta especificada - Recursivo
	 * @param objFilePesq
	 * @param arquivo
	 */
	private static void pesquisarArvoreDirEspecifico(File objFilePesq, String arquivo) {

		for (File obj : objFilePesq.listFiles()) {
			if (obj.isFile()) {                    //.equalsIgnoreCase(arquivo)) {
				if (obj.getName().toUpperCase().indexOf(arquivo.toUpperCase())!=-1) {
					System.out.println(obj.getAbsolutePath()  + " , " + LtpLib.formatarValor(obj.length()/1024.0, "##,##0.0Kb"));
					totPesq++;
				}
			} else if (obj.isDirectory()) {
				pesquisarArvoreDirEspecifico(obj, arquivo);
			}
		}

	}


}

class ArquivoSelecionado {
	private String nome;
	private long tamanho;
	private GregorianCalendar dataUltimaModificacao;
	public ArquivoSelecionado(String nome, long tamanho, GregorianCalendar dataUltimaModificacao) {
		this.dataUltimaModificacao = dataUltimaModificacao;
		this.nome = nome;
		this.tamanho = tamanho;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getTamanho() {
		return tamanho;
	}
	public void setTamanho(long tamanho) {
		this.tamanho = tamanho;
	}
	public GregorianCalendar getDataUltimaModificacao() {
		return dataUltimaModificacao;
	}
	public void setDataUltimaModificacao(GregorianCalendar dataUltimaModificacao) {
		this.dataUltimaModificacao = dataUltimaModificacao;
	}
	public String toString() {
		return
			"Nome arquivo  : " + nome + "\n" +
			"Tamanho (kb)  : " + LtpLib.formatarValor(tamanho/1024.0, "##,##0.0Kb") + "\n" +
			"Data ult.mod. : " + LtpLib.formatarData(dataUltimaModificacao, "dd/MM/yyyy HH:mm:ss") + "\n";
	}

}







