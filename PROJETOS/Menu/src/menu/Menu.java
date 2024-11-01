package menu;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.GregorianCalendar;

import utilitarios.Console;

public class Menu {

	public static void main(String[] args) {
		menu();
		System.out.println("\nFinal do Aplicativo");
		System.exit(0);
	}

	private static void menu() {
		int opcao = 0; // opção do menu
		do {
			System.out.println("\nExemplo de Menu");
			System.out.println("1-Exponenciação");
			System.out.println("2-Ultima palavra do texto");
			System.out.println("3-Padronizar espaços no texto");
			System.out.println("4-Listar as palavras do texto");
			System.out.println("5-Consultar a data e hora do sistema");
			System.out.println("6-Consultar o calendário do mes corrente");
			System.out.println("7-Consultar os domingos do ano especificado");
			System.out.println("8-Calcular a diferença em dias entre duas datas");			
			System.out.println("9-Criar um array com a quantidade de dias de cada mes do ano");
			System.out.println("10-Classificar uma lista de nomes");
			System.out.println("11-Pesquisa Binária");
			System.out.println("0-Sair");
			opcao = Console.readInt("Opção: ");
			switch (opcao) {
				case 1:
					exponencial();
					break;
				case 2:
					ultimaPalavra();
					break;
				case 3:
					padronizarTexto();
					break;		
				case 4:
					palavrasTexto();
					break;	
				case 5:
					consultarDataSistema();
					break;	
				case 6:
					consultarCalendarioMesCorrente();
					break;		
				case 7:
					consultarDomingosDoAno();
					break;	
				case 8:
					diferencaDatas();
					break;	
				case 9:
					int ano = Console.readInt("Ano : ");
					int [] arrayDiasMesAno = criarArrayDias(ano);
					for (int i=0; i < 12 ; i++) {
						System.out.println(arrayDiasMesAno[i]);
					}
					Console.readLine("Pressionar ENTER para continuar.");
					break;					
				case 10:
					classificarNomes();
					break;	
				case 11:
					pesquisaBinaria();
					break;	
						
				case 0:
					break;
				default:
					System.out.println("Opção inválida.");
					break;
			}
		} while (opcao!=0);

	}

	private static void pesquisaBinaria() {
		System.out.println("\nPesquisa Binaria\n");
		int [] numeros = new int[10000];
		for (int i=0; i<10000; i++) numeros[i] = i;
		while (true) {
			if (Console.readLine("Quer Pesquisar? (s/n)").equalsIgnoreCase("n")) break;
			int posPesquisa = Arrays.binarySearch(numeros, Console.readInt("Chave para pesquisa: "));
			if (posPesquisa < 0) {
				System.out.println("Não existe no array o valor da chave.");
			} else {
				System.out.println("Chave localizada na posição: " + posPesquisa);
			}
		}
		
	}

	private static void classificarNomes() {
		System.out.println("\nClassificar Nomes\n");
		String [] nomes = {"Jair Souza",
						   "Antonio Silva",
						   "Jose Carlos",
						   "Jose Antonio",
						   "Francisco Alves"};
		Arrays.sort(nomes);
		for (String objNome : nomes) {
			System.out.println(objNome);
		}
		Console.readLine("Pressionar ENTER para continuar.");
	}

	private static int[] criarArrayDias(int ano) {
		int [] resposta = new int[12];
		GregorianCalendar objData = new GregorianCalendar(ano,0,1);
		for (int i=0; i < 12 ; i++) {
			objData.add(GregorianCalendar.MONTH, 1);
			GregorianCalendar objDataCopia = (GregorianCalendar)objData.clone();
			objDataCopia.add(GregorianCalendar.DAY_OF_MONTH, -1);
			resposta[i] = objDataCopia.get(GregorianCalendar.DAY_OF_MONTH);
		}
		return resposta;
	}

	private static void diferencaDatas() {
		System.out.println("\nDiferença entre datas\n");
		System.out.println("Informe a primeira data");
		int dia1 = Console.readInt("Dia-1 : ");
		int mes1 = Console.readInt("Mes-1 : ");
		int ano1 = Console.readInt("Ano-1 : ");
		System.out.println("Informe a segunda data");
		int dia2 = Console.readInt("Dia-2 : ");
		int mes2 = Console.readInt("Mes-2 : ");
		int ano2 = Console.readInt("Ano-2 : ");
		// Criar os objetos GregorianCalendar
		GregorianCalendar objData1 = new GregorianCalendar(ano1, --mes1, dia1);
		GregorianCalendar objData2 = new GregorianCalendar(ano2, --mes2, dia2);
		long diferenca = (objData2.getTimeInMillis() - objData1.getTimeInMillis()) 
		                  / (1000*60*60*24);
		System.out.println("Diferença em dias: " + diferenca);
		Console.readLine("Pressionar ENTER para continuar.");
		
	}

	private static void consultarDomingosDoAno() {
		System.out.println("\nConsultar os Domingos do ano selecionado\n");
		int ano = Console.readInt("Informe o ano: ");
		GregorianCalendar dtBase = new GregorianCalendar(ano,0,1);
		while (dtBase.get(GregorianCalendar.YEAR)==ano) {
			if (dtBase.get(GregorianCalendar.DAY_OF_WEEK)==1) {
						new SimpleDateFormat("dd/MM/yyyy - EEEE").format(dtBase.getTime());
			}
			dtBase.add(GregorianCalendar.DAY_OF_MONTH, 1);
		}
		Console.readLine("Pressionar ENTER para continuar.");
		
	}

	private static void consultarCalendarioMesCorrente() {
		System.out.println("\nConsultar o Calendário do mês corrente\n");
		GregorianCalendar dtSistema = new GregorianCalendar();
		dtSistema.set(GregorianCalendar.DAY_OF_MONTH, 1);
		int mesCoorente = dtSistema.get(GregorianCalendar.MONTH);
		while (dtSistema.get(GregorianCalendar.MONTH)==mesCoorente) {
			System.out.println("Data do Sistema : " + 
					new SimpleDateFormat("dd/MM/yyyy - EEEE").format(dtSistema.getTime()));
			dtSistema.add(GregorianCalendar.DAY_OF_MONTH, 1);
		}
		Console.readLine("Pressionar ENTER para continuar.");
	}

	private static void consultarDataSistema() {
		System.out.println("\nConsultar a Data do Sistema\n");
		GregorianCalendar dtSistema = new GregorianCalendar();
		System.out.println("Data do Sistema : " + 
			new SimpleDateFormat("EEE dd/MMM/yyyy HH:mm:ss").format(dtSistema.getTime()));
		Console.readLine("Pressionar ENTER para continuar.");
	}

	private static void palavrasTexto() {
		System.out.println("\nPalavras do texto\n");
		String texto = Console.readLine("Texto para teste : ");
		texto = texto.trim(); // Retirar espaços nas extremidades do texto
		// retirar espacos em excesso entre palavras
		while (texto.indexOf("  ") != -1) {
			texto = texto.replaceAll("  ", " ");
		}
		String [] palavras = texto.split(" ");
		for (int i=0; i < palavras.length ; i++) {
			System.out.println("Posição : " + (i+1) + " - " + 
					            palavras[i]);
		}
		System.out.println("Total de Palavras : " + palavras.length);
		Console.readLine("Pressionar ENTER para continuar.");
	}

	private static void padronizarTexto() {
		System.out.println("\nPadronizar texto\n");
		String texto = Console.readLine("Texto para teste : ");
		texto = texto.trim(); // Retirar espaços nas extremidades do texto
		// retirar espacos em excesso entre palavras
		while (texto.indexOf("  ") != -1) {
			texto = texto.replaceAll("  ", " ");
		}
		System.out.println("Texto padronizado: " + texto);
		Console.readLine("Pressionar ENTER para continuar.");
	}

	private static void ultimaPalavra() {
		System.out.println("\nUltima palavra do texto\n");
		String texto = " " + Console.readLine("Texto para teste : ").trim();
		//texto = texto.trim(); retirar espaços nas extremidades
		String ultPalavra = "";
		for (int i = texto.length()-1; i>=0; i--) {
			if (texto.charAt(i)==' ') {
				ultPalavra = texto.substring(i+1);
				break;
			}
		}
		System.out.println("Última palavra: " + ultPalavra);
		Console.readLine("Pressionar ENTER para continuar.");
	}

	private static void exponencial() {
		System.out.println("\nExemplo Exponencial\n");
		double base = Console.readDouble("Base : ");
		double exponte = Console.readDouble("Expoente : ");
		double resposta = Math.pow(base, exponte);
		System.out.println("Resposta : " + resposta);
        Console.readLine("Pressionar ENTER para prosseguir"); // <ENTER>		
	}

}







