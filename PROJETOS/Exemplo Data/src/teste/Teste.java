package teste;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import utilitarios.Console;
import utilitarios.LtpLib;

public class Teste {

	static String[] diasSemana = { "Domingo", "Segunda", "Terça", "Quarta",
			"Quinta", "Sexta", "Sábado" };

	// 1 - Domingo
	// 7 - Sábado

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("\n** Datas **");

		diaCorrente();
		diaDataQualquer();
		diaDataQualquer2();
		diferencaDatas();
		diferencaHoras();
		calcularData();	
		System.out.println("\n** Final dos Testes **");
		System.exit(0);
	}

	private static void diaCorrente() {
		System.out.println("\n** Dia Corrente **\n");

		GregorianCalendar dtCorrente = new GregorianCalendar();

		System.out.println("Dia da Semana : "
				+ diasSemana[dtCorrente.get(GregorianCalendar.DAY_OF_WEEK) - 1]);

	}

	private static void diaDataQualquer() {
		System.out.println("\n** Data Qualquer **\n");

		int dia = Console.readInt("Dia: ");
		int mes = Console.readInt("Mês: ");
		int ano = Console.readInt("Ano: ");
		GregorianCalendar data = new GregorianCalendar(ano, mes - 1, dia);

		System.out.println("\nDia da Semana : "
				+ diasSemana[data.get(GregorianCalendar.DAY_OF_WEEK) - 1]);
	}

	private static void diaDataQualquer2() {
		System.out.println("\n** Data Qualquer Com Consistência **\n");

		GregorianCalendar data = new GregorianCalendar();
		String dt = Console.readLine("Data (d/m/aa): ");
		if (!LtpLib.validarData(dt, data)) {
			System.out.println("Data Inválida");
		} else {
			System.out.println("\nDia da Semana : "
					+ diasSemana[data.get(GregorianCalendar.DAY_OF_WEEK) - 1]);
		}
	}

	private static void diferencaDatas() {
		System.out.println("\n** Teste de diferença de data/dias **\n");

		System.out.println("Data 1\n");
		int dia = Console.readInt("Dia: ");
		int mes = Console.readInt("Mês: ");
		int ano = Console.readInt("Ano: ");
		GregorianCalendar objData1 = new GregorianCalendar(ano, mes - 1, dia);

		System.out.println("\nData 2\n");
		int dia2 = Console.readInt("Dia: ");
		int mes2 = Console.readInt("Mês: ");
		int ano2 = Console.readInt("Ano: ");
		GregorianCalendar objData2 = new GregorianCalendar(ano2, mes2 - 1, dia2);

		long dias = (objData2.getTimeInMillis() - objData1.getTimeInMillis()) / 3600000 / 24;
		// 1h = (1000 x 60 x 60)ms

		System.out.println("\nResposta: Data 2 - Data 1: " + dias + " dias");
	}

	private static void diferencaHoras() {
		System.out.println("\n** Teste de diferença de data/hora **\n");

		GregorianCalendar objData1 = new GregorianCalendar(2017, 3 - 1, 17, 7,
				40, 0);
		GregorianCalendar objData2 = new GregorianCalendar(2017, 3 - 1, 17, 9,
				20, 0);

		double horas = (objData2.getTimeInMillis() - objData1.getTimeInMillis()) / 3600000.;
		// '.' Ponto retorna double

		// Sem formatação
		// System.out.println("Resposta: Data 2 - Data 1: " + horas + " horas");

		// Com formatação
		System.out.println("Resposta: "
				+ new DecimalFormat("##0.00").format(horas) + " horas");

		System.out.println("Diferença Formatada: "
				+ LtpLib.formatarMilisegundos(objData2.getTimeInMillis()
						- objData1.getTimeInMillis(), LtpLib.RETORNAR_SEGUNDOS));
	}

	private static void calcularData() {
		System.out.println("\n** Teste de calculo de data **\n");
		
		String data;
		GregorianCalendar objData = new GregorianCalendar();
		//objData Data atual
		
		while(true){
			data = Console.readLine("Data (dd/mm/aaaa) : ");
			if (LtpLib.validarData(data,objData))break;
			//objData é atualizado para a Data digitada na String
			System.out.println("Data Inválida");
		}
		
		int dias = Console.readInt("Dias: ");
		GregorianCalendar objDataFinal = (GregorianCalendar)objData.clone();
		objDataFinal.add(GregorianCalendar.DAY_OF_MONTH, dias);
		System.out.println("\nResposta : " + new SimpleDateFormat("dd/MM/yyyy").format(objDataFinal.getTime()));
		
	}
}