package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtils {

	public static void main(String[] args) {
		menu();
	}

	private static void menu() {
		int opcao = 0;
		do {
			System.out.println("\nData �tils");
			System.out.println("1 � Validar data do usu�rio");
			System.out.println("2 � Calcular diferen�a entre datas");
			System.out.println("3 � Calcular diferen�a entre datas em horas");
			System.out.println("4 � Ajustar fim de semana");
			System.out.println("5 � Calcular data");
			System.out.println("6 � Informar dia da semana");
			System.out.println("7 � Informar quantidade de dias do m�s");
			System.out.println("8 � Exibir calend�rio completo do m�s");
			System.out.println("9 � Verificar se o ano � bissexto");
			System.out.println("10 � Informar primeiro dia �til do m�s");
			System.out.println("0-Sair da aplica��o");
			opcao = Console.readInt("Op��o: ");
			switch (opcao) {
			case 1:
				validarDataUsuario();
				break;
			case 2:
				diferencaDatas();
				break;
			case 3:
				diferencaDatasHoras();
				break;
			case 4:
				ajustarFimSemana();
				break;
			case 5:
				calcularData();
				break;
			case 6:
				informarDiaSemana();
				break;
			case 7:
				informarQtdDiasMes();
				break;
			case 8:
				exibirCalendario();
				break;
			case 9:
				verificarBissexto();
				break;
			case 10:
				informarPrimeiroDiaUtilMes();
				break;
			case 0:
				break;
			default:
				System.out.println("Op��o inv�lida.");
				break;
			}
		} while (opcao != 0);
	}

	/**
	 * M�todo para informar o primeiro dia �til do m�s
	 * 
	 * @author Jo�o Paulo Aramuni
	 * @date 15/03/2018
	 * @version 1.0
	 */
	private static void informarPrimeiroDiaUtilMes() {
		String mes = Console.readLine("Entre com um m�s:");

		int mesNumber = -1;

		switch (mes) {
		case "Janeiro":
			mesNumber = 0;
			break;
		case "Fevereiro":
			mesNumber = 1;
			break;
		case "Mar�o":
			mesNumber = 2;
			break;
		case "Abril":
			mesNumber = 3;
			break;
		case "Maio":
			mesNumber = 4;
			break;
		case "Junho":
			mesNumber = 5;
			break;
		case "Julho":
			mesNumber = 6;
			break;
		case "Agosto":
			mesNumber = 7;
			break;
		case "Setembro":
			mesNumber = 8;
			break;
		case "Outubro":
			mesNumber = 9;
			break;
		case "Novembro":
			mesNumber = 10;
			break;
		case "Dezembro":
			mesNumber = 11;
			break;
		}

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, mesNumber);

		int primeiroDia = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, primeiroDia);

		int diaDaSemana = cal.get(Calendar.DAY_OF_WEEK);

		// Caso caia no s�bado ou no domingo
		switch (diaDaSemana) {
		case 7:
			cal.add(Calendar.DAY_OF_YEAR, 2);
			break;
		case 1:
			cal.add(Calendar.DAY_OF_YEAR, 1);
			break;
		}

		System.out.println("Resultado: " + cal.getTime().toString());
	}

	/**
	 * M�todo para verificar se o ano � bissexto
	 * 
	 * @author Jo�o Paulo Aramuni
	 * @date 15/03/2018
	 * @version 1.0
	 */
	private static void verificarBissexto() {
		int ano = Console.readInt("Entre com um ano:");
		boolean calculo = (ano % 400 == 0) || (ano % 4 == 0 && ano % 100 != 0);
		if (calculo) {
			System.out.println("O ano " + ano + " � bissexto.");
		} else {
			System.out.println("O ano " + ano + " n�o � bissexto.");
		}
	}

	/**
	 * M�todo para exibir calend�rio completo
	 * 
	 * @author Jo�o Paulo Aramuni
	 * @date 15/03/2018
	 * @version 1.0
	 */
	private static void exibirCalendario() {
		String mes = Console.readLine("Entre com um m�s:");
		int mesNumber = -1;

		switch (mes) {
		case "Janeiro":
			mesNumber = 0;
			break;
		case "Fevereiro":
			mesNumber = 1;
			break;
		case "Mar�o":
			mesNumber = 2;
			break;
		case "Abril":
			mesNumber = 3;
			break;
		case "Maio":
			mesNumber = 4;
			break;
		case "Junho":
			mesNumber = 5;
			break;
		case "Julho":
			mesNumber = 6;
			break;
		case "Agosto":
			mesNumber = 7;
			break;
		case "Setembro":
			mesNumber = 8;
			break;
		case "Outubro":
			mesNumber = 9;
			break;
		case "Novembro":
			mesNumber = 10;
			break;
		case "Dezembro":
			mesNumber = 11;
			break;
		}

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, mesNumber);

		int actualMinimum = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
		int actualMaximum = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		// Resetar para primeiro dia do m�s
		cal.set(Calendar.DAY_OF_MONTH, actualMinimum);
		// Zerar hora
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);

		while (actualMinimum <= actualMaximum) {
			System.out.println(cal.getTime().toString());
			cal.add(Calendar.DAY_OF_YEAR, 1);
			actualMinimum++;
		}
	}

	/**
	 * M�todo para informar quantidade de dias no m�s
	 * 
	 * @author Jo�o Paulo Aramuni
	 * @date 15/03/2018
	 * @version 1.0
	 */
	private static void informarQtdDiasMes() {
		String mes = Console.readLine("Entre com um m�s:");
		int mesNumber = -1;

		switch (mes) {
		case "Janeiro":
			mesNumber = 0;
			break;
		case "Fevereiro":
			mesNumber = 1;
			break;
		case "Mar�o":
			mesNumber = 2;
			break;
		case "Abril":
			mesNumber = 3;
			break;
		case "Maio":
			mesNumber = 4;
			break;
		case "Junho":
			mesNumber = 5;
			break;
		case "Julho":
			mesNumber = 6;
			break;
		case "Agosto":
			mesNumber = 7;
			break;
		case "Setembro":
			mesNumber = 8;
			break;
		case "Outubro":
			mesNumber = 9;
			break;
		case "Novembro":
			mesNumber = 10;
			break;
		case "Dezembro":
			mesNumber = 11;
			break;
		}

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, mesNumber);

		int ultimoDia = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		System.out.println("Quantidade de dias no m�s de " + mes + ": "
				+ ultimoDia);
	}

	/**
	 * M�todo para informar dia da semana
	 * 
	 * @author Jo�o Paulo Aramuni
	 * @date 15/03/2018
	 * @version 1.0
	 */
	private static void informarDiaSemana() {
		String data = Console.readLine("Entre com uma data:");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataFormatada = null;
		try {
			dataFormatada = sdf.parse(data);
			System.out.println("Data v�lida!!!");
			System.out.println(dataFormatada.toString());
		} catch (Exception e) {
			System.out.println("Data inv�lida!!!");
			System.out.println(e.getMessage());
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(dataFormatada);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

		switch (dayOfWeek) {
		case 1:
			System.out.println("Domingo");
			break;
		case 2:
			System.out.println("Segunda-feira");
			break;
		case 3:
			System.out.println("Ter�a-feira");
			break;
		case 4:
			System.out.println("Quarta-feira");
			break;
		case 5:
			System.out.println("Quinta-feira");
			break;
		case 6:
			System.out.println("Sexta-feira");
			break;
		case 7:
			System.out.println("S�bado");
			break;
		}

	}

	/**
	 * M�todo para calcular data
	 * 
	 * @author Jo�o Paulo Aramuni
	 * @date 15/03/2018
	 * @version 1.0
	 */
	private static void calcularData() {
		String data = Console.readLine("Entre com uma data:");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataFormatada = null;
		try {
			dataFormatada = sdf.parse(data);
			System.out.println("Data v�lida!!!");
			System.out.println(dataFormatada.toString());
		} catch (Exception e) {
			System.out.println("Data inv�lida!!!");
			System.out.println(e.getMessage());
		}

		int dias = Console.readInt("Entre com uma quantidade de dias:");

		// Adicionar dias usando a classe Calendar
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataFormatada);
		cal.add(Calendar.DAY_OF_YEAR, dias);

		System.out.println("Resultado: " + cal.getTime().toString());
	}

	/**
	 * M�todo para ajustar final de semana
	 * 
	 * @author Jo�o Paulo Aramuni
	 * @date 15/03/2018
	 * @version 1.0
	 */
	private static void ajustarFimSemana() {
		String data = Console.readLine("Entre com uma data:");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataFormatada = null;
		try {
			dataFormatada = sdf.parse(data);
			System.out.println("Data v�lida!!!");
			System.out.println(dataFormatada.toString());
		} catch (Exception e) {
			System.out.println("Data inv�lida!!!");
			System.out.println(e.getMessage());
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(dataFormatada);
		int diaDaSemana = cal.get(Calendar.DAY_OF_WEEK);

		switch (diaDaSemana) {
		case 7:
			cal.add(Calendar.DAY_OF_YEAR, 2);
			break;
		case 1:
			cal.add(Calendar.DAY_OF_YEAR, 1);
			break;
		}

		System.out.println("Nova data ajustada: " + cal.getTime());
	}

	/**
	 * M�todo para calcular a diferen�a entre datas em horas
	 * 
	 * @author Jo�o Paulo Aramuni
	 * @date 15/03/2018
	 * @version 1.0
	 */
	private static void diferencaDatasHoras() {
		String data1 = Console.readLine("Entre com a data 1:");
		String data2 = Console.readLine("Entre com a data 2:");
		String hora1 = Console.readLine("Entre com a hora 1:");
		String hora2 = Console.readLine("Entre com a hora 2:");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataFormatada1 = null;
		Date dataFormatada2 = null;
		try {
			dataFormatada1 = sdf.parse(data1);
			System.out.println("Data 1 v�lida!!!");
			System.out.println(dataFormatada1.toString());

		} catch (Exception e) {
			System.out.println("Data 1 inv�lida!!!");
			System.out.println(e.getMessage());
		}

		try {
			dataFormatada2 = sdf.parse(data2);
			System.out.println("Data 2 v�lida!!!");
			System.out.println(dataFormatada2.toString());

		} catch (Exception e) {
			System.out.println("Data 2 inv�lida!!!");
			System.out.println(e.getMessage());
		}

		// Validar se data 1 maior que data 2
		if (dataFormatada1.compareTo(dataFormatada2) > 0) {
			System.out.println("Data 1 n�o pode ser maior que data 2");
			return;
		}

		// Inserir hora na data 1
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(dataFormatada1);
		cal1.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hora1.substring(0, 2)));
		cal1.set(Calendar.MINUTE, Integer.parseInt(hora1.substring(3, 5)));
		cal1.set(Calendar.SECOND, Integer.parseInt(hora1.substring(6, 8)));

		// Inserir hora na data 2
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(dataFormatada2);
		cal2.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hora2.substring(0, 2)));
		cal2.set(Calendar.MINUTE, Integer.parseInt(hora2.substring(3, 5)));
		cal2.set(Calendar.SECOND, Integer.parseInt(hora2.substring(6, 8)));

		Date dataFinal1 = cal1.getTime();
		Date dataFinal2 = cal2.getTime();

		System.out.println("\n" + dataFinal1);
		System.out.println(dataFinal2);

		// Subtrair duas datas
		long diferencaHoras = (dataFinal2.getTime() - dataFinal1.getTime())
				/ (1000 * 60 * 60);

		System.out.println("\nDiferen�a em horas:" + diferencaHoras);
	}

	/**
	 * M�todo para calcular a diferen�a entre datas
	 * 
	 * @author Jo�o Paulo Aramuni
	 * @date 15/03/2018
	 * @version 1.0
	 */
	private static void diferencaDatas() {
		String data1 = Console.readLine("Entre com a data 1:");
		String data2 = Console.readLine("Entre com a data 2:");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataFormatada1 = null;
		Date dataFormatada2 = null;
		try {
			dataFormatada1 = sdf.parse(data1);
			System.out.println("Data 1 v�lida!!!");
			System.out.println(dataFormatada1.toString());

		} catch (Exception e) {
			System.out.println("Data 1 inv�lida!!!");
			System.out.println(e.getMessage());
		}

		try {
			dataFormatada2 = sdf.parse(data2);
			System.out.println("Data 2 v�lida!!!");
			System.out.println(dataFormatada2.toString());

		} catch (Exception e) {
			System.out.println("Data 2 inv�lida!!!");
			System.out.println(e.getMessage());
		}

		// Validar se data 1 maior que data 2
		if (dataFormatada1.compareTo(dataFormatada2) > 0) {
			System.out.println("Data 1 n�o pode ser maior que data 2");
			return;
		}
		// Subtrair duas datas
		long diferencaDias = (dataFormatada2.getTime() - dataFormatada1
				.getTime()) / (1000 * 60 * 60 * 24);
		long diferencaMeses = (dataFormatada2.getTime() - dataFormatada1
				.getTime()) / (1000 * 60 * 60 * 24) / 30;
		long diferencaAnos = ((dataFormatada2.getTime() - dataFormatada1
				.getTime()) / (1000 * 60 * 60 * 24) / 30) / 12;

		System.out.println("Diferen�a em dias:" + diferencaDias);
		System.out.println("Diferen�a em meses:" + diferencaMeses);
		System.out.println("Diferen�a em anos:" + diferencaAnos);
	}

	/**
	 * M�todo para validar data do usu�rio
	 * 
	 * @author Jo�o Paulo Aramuni
	 * @date 15/03/2018
	 * @version 1.0
	 */
	private static void validarDataUsuario() {
		String data = Console.readLine("Entre com uma data:");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date dataFormatada = sdf.parse(data);
			System.out.println("Data v�lida!!!");
			System.out.println(dataFormatada.toString());
		} catch (Exception e) {
			System.out.println("Data inv�lida!!!");
			System.out.println(e.getMessage());
		}
	}
}
