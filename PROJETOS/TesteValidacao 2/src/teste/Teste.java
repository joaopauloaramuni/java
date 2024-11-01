package teste;

import java.util.GregorianCalendar;

import utilitarios.Console;
import utilitarios.LtpLib;

public class Teste {

	public static void main(String[] args) {
		menu();
		System.out.println("Saida do teste.");
		System.exit(0);
	}

	private static void menu() {
		int opcao = 0;
		do {
			System.out.println("\nMenu - Testes");
			System.out.println("1-Validar CPF");
			System.out.println("2-Validar Data");
			System.out.println("3-Diferen�a de Hor�rios");
			System.out.println("0-Sair");
			opcao = Console.readInt("Op��o: ");
			switch (opcao) {
				case 1:
					validarCPF();
					break;
				case 2:
					validarData();
					break;
				case 3:
					difHorarios();
					break;					
				case 0 :
					break;
				default:
					System.out.println("Op��o Inv�lida.");
					break;
			}
			
		} while (opcao!=0);
	}

	private static void difHorarios() {
		System.out.println("\nDiferen�a Hor�rios\n");
		String dataHora1 = Console.readLine("Data/Hora1 : ");
		GregorianCalendar dt1 = new GregorianCalendar();
		if (!LtpLib.validarDataHora(dataHora1, dt1)) return;
		String dataHora2 = Console.readLine("Data/Hora2 : ");
		GregorianCalendar dt2 = new GregorianCalendar();
		if (!LtpLib.validarDataHora(dataHora2, dt2)) return;
		System.out.println("Diferen�a dos Hor�rios : " + 
			LtpLib.formatarMilisegundos((long)LtpLib.subtrairHoras(dt1, dt2, LtpLib.RETORNAR_MILISEGUNDOS),LtpLib.RETORNAR_SEGUNDOS));
		
	}

	private static void validarData() {
		System.out.println("\nValidar Data\n");
		String data = Console.readLine("Data (dd/mm/aaaa) : " );
		GregorianCalendar dt = new GregorianCalendar();
		if (LtpLib.validarData(data, dt)) {
			System.out.println("Data " +
					LtpLib.formatarData(dt, "dd/MM/yyyy") +
					" V�lida.");
		} else System.out.println("Data inv�lida.");
	}

	private static void validarCPF() {
		System.out.println("\nValidar CPF\n");
		String cpf = Console.readLine("CPF : ");
		if (LtpLib.validarCPF(cpf)) {
			System.out.println("CPF " +
				LtpLib.formatarCPF(cpf) +	
				" V�lido.");
		} else System.out.println("CFP Inv�lido.");
	}

}







