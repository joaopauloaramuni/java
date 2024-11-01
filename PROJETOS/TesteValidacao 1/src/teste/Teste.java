package teste;

import java.util.GregorianCalendar;

import utilitarios.Console;
import utilitarios.LtpLib;

public class Teste {

	public static void main(String[] args) {
		menu();
		System.out.println("Fim dos Testes.");
		System.exit(0); // Final 
	}

	private static void menu() {
		int opcao = 0;
		do {
			System.out.println("\nTeste Menu");
			System.out.println("1-Validar CPF");
			System.out.println("2-Valor por Extenso");
			System.out.println("3-Calcular as datas de vencimento");
			System.out.println("4-Calcular as datas para domingos do ano");
			System.out.println("0-Sair");
			opcao = Console.readInt("Opção: ");
			switch (opcao) {
				case 1:
					validarCPF();
					break;
				case 2:
					valorExtenso();
					break;
				case 3:
					datasVencimento();
					break;					
				case 0:
					break; 
				default:
					System.out.println("Opção Inválida.");
					break;
			}
		} while (opcao!=0);
		
	}

	private static void datasVencimento() {
		System.out.println("\nCalcular as datas de vencimento\n");
		int numParc = Console.readInt("Nº de Parcelas: ");
		// Data Base
		GregorianCalendar dataBase = new GregorianCalendar();
		do {
			if ( ! LtpLib.validarData(
				 Console.readLine("Data: "), 
				 dataBase)) {
					System.out.println("Data Inválida.");
			} else {
				if (dataBase.compareTo(new GregorianCalendar())>0) {
					System.out.println("Data Base maior que a data corrente.");
				} else break;
			}
		} while (true);
		for (GregorianCalendar objData : LtpLib.datasVencimento(numParc, dataBase)) {
			System.out.println(LtpLib.formatarData(objData,"dd/MM/yyyy"));
		}
		Console.readLine("Pressionar ENTER para continuar");
	}

	private static void valorExtenso() {
		System.out.println("\nValor por Extenso\n");
		double valor = Console.readDouble("Valor: ");
		System.out.println("Valor: " + 
				LtpLib.formatarValor(valor, "R$###,##0.00 ") +
				LtpLib.valorExtenso(valor));
		Console.readLine("Pressionar ENTER para continuar");
		
	}

	private static void validarCPF() {
		System.out.println("\nValidar CPF\n");
		String cpf = Console.readLine("CPF: ");
		if (LtpLib.validarCPF(cpf)) {
			System.out.println(" CPF " + 
					LtpLib.formatarCPF(cpf) + " Válido.");
		} else System.out.println("CPF Inválido.");
		Console.readLine("Pressionar ENTER para continuar");
		
	}

}




