package menu;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.GregorianCalendar;

import utilitarios.Console;

public class TesteMenu {

	public static void main(String[] args) {
		menu();
		System.out.println("\nFinal do aplicativo.");
		System.exit(0); // finalização
	}
	private static void menu() {
		int opcao = 0;
		do {
			System.out.println("\nExemplo Menu");
			System.out.println("1-Exponenciação");
			System.out.println("2-Ultima palavra do texto");
			System.out.println("3-Padronizar texto");
			System.out.println("4-Listar as palavras do texto");
			System.out.println("5-Data do Sistema");
			System.out.println("6-Ajustar data de final de semana");
			System.out.println("7-Listar o calendario mensal");
			System.out.println("8-Listar todos os domingos do ano");
			System.out.println("9-Diferença em dias entre uma data e a data corrente");
			System.out.println("10-Criar um array com o número de dias do ano");
			System.out.println("11-Classificar um array");
			System.out.println("12-Pesquisa Binária");
			System.out.println("0-Sair");
			opcao = Console.readInt("Opção: ");
			switch (opcao) {
				case 1:
					exponenciação();
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
					dataSistema();
					break;						
				case 6:
					finalSemana();
					break;	
				case 7:
					calendarioMesAno();
					break;	
				case 8:
					listarDomingosAno();
					break;	
				case 9:
					diferencaDatas();
					break;	
				case 10:
					int ano = Console.readInt("Ano: ");
					int[] diasMesAno = calcDiasMesAno(ano); 
					for (int i=0; i<12; i++) {
						System.out.println(diasMesAno[i]);
					}
					Console.readLine("Tecle <ENTER> para continuar");
					break;					
				case 11:
					classificarArray();
					break;	
				case 12:
					pesquisaBinaria();
					break;						
				case 0 :
					break;
				default:
					System.out.println("opção inválida.");
					break;
			}
		} while (opcao!=0);
		
	}
	private static void pesquisaBinaria() {
		System.out.println("\nPesquisa Binária\n");
		int [] numeros = new int[10000];
		for (int i=0; i<9999; i++) numeros[i] = i;
		while (true) {
			if (Console.readLine("Quer pesquisar? (s/n)").equalsIgnoreCase("n")) break;
			int chavePesquisa = Console.readInt("Chave Pesquisa: ");
			int posicao = Arrays.binarySearch(numeros, chavePesquisa);
			if (posicao>=0) {
				System.out.println("Chave encontrada na posição: " + posicao);
			} else System.out.println("Não existe a chave no array");
		}
		Console.readLine("Tecle <ENTER> para continuar");
		
	}
	private static void classificarArray() {
		System.out.println("\nClassificar Array\n");
		String [] nomes = {"Jose Eduardo","Jose Antonio","Carlos","Eduardo","Antonio"};
		Arrays.sort(nomes);
		for (String objNome : nomes) {
			System.out.println(objNome);
		}
		Console.readLine("Tecle <ENTER> para continuar");
	}
	private static int[] calcDiasMesAno(int ano) {
		GregorianCalendar dtBase = new GregorianCalendar(ano,0,1);
		int [] resposta = new int[12];
		for (int i=0; i < 12 ; i++) {
			dtBase.add(GregorianCalendar.MONTH, 1);
			GregorianCalendar dtAux = (GregorianCalendar)dtBase.clone();
			dtAux.add(GregorianCalendar.DAY_OF_MONTH, -1);
			resposta[i] = dtAux.get(GregorianCalendar.DAY_OF_MONTH);
		}
		return resposta;
	}
	private static void diferencaDatas() {
		System.out.println("\nDiferença em dias entre uma data e a data corrente\n");
		GregorianCalendar dtCorrente = new GregorianCalendar();
		int dia = Console.readInt("Dia: ");
		int mes = Console.readInt("Mês: ") - 1;
		int ano = Console.readInt("Ano: ");
		GregorianCalendar dtBase = new GregorianCalendar();
		dtBase.set(GregorianCalendar.DAY_OF_MONTH, dia);
		dtBase.set(GregorianCalendar.MONTH, mes);
		dtBase.set(GregorianCalendar.YEAR, ano);
		long diferenca = Math.abs( dtBase.getTimeInMillis() - dtCorrente.getTimeInMillis() );
		System.out.println("Diferença em dias : " + 
			(diferenca/(1000*60*60*24)));
		Console.readLine("Tecle <ENTER> para continuar");
	}
	private static void listarDomingosAno() {
		System.out.println("\nLista de Domingos do Ano\n");
		int ano = Console.readInt("Ano: ");
		int totDiasAno = 0;
		int totDomingosAno = 0;
		GregorianCalendar dtBase = new GregorianCalendar(ano,0,1);
		while (dtBase.get(GregorianCalendar.YEAR)==ano) {
			totDiasAno++;
			if (dtBase.get(GregorianCalendar.DAY_OF_WEEK)==1) {
				totDomingosAno++;
				System.out.println("Data : " + 
						  new SimpleDateFormat("dd/MM/yyyy - EEEE").format(dtBase.getTime()));
			}
			dtBase.add(GregorianCalendar.DAY_OF_MONTH, 1);
		}
		System.out.println("Quant. Dias do Ano : " + totDiasAno + "\n" +
				           "Quant. de Domingos : " + totDomingosAno);
		Console.readLine("Tecle <ENTER> para continuar");
	}
	private static void calendarioMesAno() {
		System.out.println("\nCalendário Mensal\n");
		int mes = Console.readInt("Mês: ");
		int ano = Console.readInt("Ano: ");
		GregorianCalendar dtBase = new GregorianCalendar(ano, --mes, 1);
		while (dtBase.get(GregorianCalendar.MONTH)==mes) {
			System.out.println("Data : " + 
			  new SimpleDateFormat("dd/MM/yyyy - EEEE").format(dtBase.getTime()));
			dtBase.add(GregorianCalendar.DAY_OF_MONTH, 1);
		}
		Console.readLine("Tecle <ENTER> para continuar");
	}
	private static void finalSemana() {
		System.out.println("\nAjustar data de final de semana");
		String dataTeste = Console.readLine("Data (d/m/aaaa) : ");
		String[] itensData = dataTeste.split("/");
		int dia = Integer.parseInt(itensData[0]);
		int mes = Integer.parseInt(itensData[1])-1;
		int ano = Integer.parseInt(itensData[2]);
		GregorianCalendar objData = new GregorianCalendar(ano,mes,dia);
		int diaSemana = objData.get(GregorianCalendar.DAY_OF_WEEK);
		if (diaSemana==1) objData.add(GregorianCalendar.DAY_OF_MONTH, 1);
		if (diaSemana==7) objData.add(GregorianCalendar.DAY_OF_MONTH, 2);
		System.out.println( 
				new SimpleDateFormat("EEEE dd/MM/yyyy").format(objData.getTime()) );
			Console.readLine("Tecle <ENTER> para continuar");		
	}
	private static void dataSistema() {
		System.out.println("\nData do Sistema");
		GregorianCalendar dtSistema = new GregorianCalendar();
		System.out.println( 
			new SimpleDateFormat("EEEE dd/MM/yyyy HH:mm:ss,S").format(dtSistema.getTime()) );
		Console.readLine("Tecle <ENTER> para continuar");
	}
	private static void palavrasTexto() {
		System.out.println("\nPalavras do Texto");
		String texto = Console.readLine("Informe o texto para teste: ");
		texto = texto.trim(); // retirar espaços na extremidade
		while ( texto.indexOf("  ") != -1 ) {
			texto = texto.replaceAll("  ", " "); // substituir 2 espaços por 1 espaço no texto
		}
		String [] palavras = texto.split(" ");
		for (int i=0; i<palavras.length; i++) {
			System.out.println("Num.Ordem: " + (i+1) + " - " +
					           palavras[i]);
		}
		System.out.println("Total de Palavras: " + palavras.length);
		Console.readLine("Tecle <ENTER> para continuar");
		
	}
	private static void padronizarTexto() {
		System.out.println("\nPadronizar Texto");
		String texto = Console.readLine("Informe o texto para teste: ");
		texto = texto.trim(); // retirar espaços na extremidade
		while ( texto.indexOf("  ") != -1 ) {
			texto = texto.replaceAll("  ", " "); // substituir 2 espaços por 1 espaço no texto
		}
		System.out.println("Texto padronizado : " + texto);
		Console.readLine("Tecle <ENTER> para continuar");
	}
	private static void ultimaPalavra() {
		System.out.println("\nUltima Palavra do Texto");
		String texto = " " + Console.readLine("Texto: ").trim();
		String ultPalavra = "";
		for (int i = texto.length()-1; i < texto.length(); i--) {
			if (texto.charAt(i) == ' ') {
				ultPalavra = texto.substring(i+1);
				break;
			}
		}
		System.out.println("Ultima Palavra : " + ultPalavra);
		
	}
	private static void exponenciação() {
		System.out.println("\nCalcular a Exponencial");
		double base = Console.readDouble("Base : ");
		double expoente = Console.readDouble("Expoente : ");
		double resultado = Math.pow(base, expoente);
		System.out.println("Resultado : " + resultado);
		Console.readLine("Pressionar ENTER para continuar");
	}

}






