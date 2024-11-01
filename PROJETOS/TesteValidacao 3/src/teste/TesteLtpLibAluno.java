package teste;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import servicos.LtpLibAluno;
import utilitarios.Console;
import utilitarios.LtpLib;

public class TesteLtpLibAluno {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		menu();
		System.out.println("\nFinal dos Testes.");
		System.exit(0);

	}

	private static void menu() {
		int opcao = 0;

		do {
			System.out.println("\nMenu de Testes");
			System.out.println("1-Validar CPF");
			System.out.println("2-Validar CNPJ");
			System.out.println("3-Validar PIS");
			System.out.println("4-Validar Email");
			System.out.println("5-Padronizar Texto");
			System.out.println("6-Contar Palavras do Texto");
			System.out.println("7-Verificar ocorrência no texto");
			System.out.println("8-Verificar Última palavra do texto");
			System.out.println("9-Ajustar Fim de Semana");
			System.out.println("10-Quantidades de dias dos meses do ano");
			System.out.println("11-Calendário Mensal");
			System.out.println("0-Sair dos testes");
			opcao = Console.readInt("Opção: ");
			switch (opcao) {
			case 1:
				validacaoCPF();
				break;
			case 2:
				validacaoCNPJ();
				break;
			case 3:
				validacaoPIS();
				break;
			case 4:
				validacaoEmail();
				break;
			case 5:
				padronizacaoTexto();
				break;
			case 6:
				contarPalavrasTexto();
				break;
			case 7:
				verificacaoPalavra();
				break;
			case 8:
				verificacaoUltimaPalavra();
				break;
			case 9:
				ajustarFds();
				break;
			case 10:
				quantDiasCadaMesAno();
				break;
			case 11:
				calendarioMes();
				break;
			case 0:
				break;
			default:
				System.out.println("Opção Inválida.");
				break;
			}

		} while (opcao != 0);
	}

	private static void validacaoCPF() {
		System.out.println("\nValidação de CPF\n");
		String cpf = Console.readLine("CPF : ");
		System.out.println(LtpLibAluno.validarCPF(cpf) ? "CPF VÁLIDO."
				: "CPF INVÁLIDO.");
	}

	private static void validacaoCNPJ() {
		System.out.println("\nValidação do CNPJ\n");
		String cnpj = Console.readLine("CNPJ : ");
		System.out.println(LtpLibAluno.validarCNPJ(cnpj) ? "CNPJ VÁLIDO."
				: "CNPJ INVÁLIDO.");
	}

	private static void validacaoPIS() {
		System.out.println("\nValidação do PIS\n");
		String pis = Console.readLine("PIS : ");
		System.out.println(LtpLibAluno.validarPIS(pis) ? "PIS VÁLIDO."
				: "PIS INVÁLIDO.");
	}

	private static void validacaoEmail() {
		System.out.println("\nValidação de Email\n");
		String email = Console.readLine("Email : ");
		System.out.println(LtpLibAluno.validarEmail(email) ? "EMAIL VÁLIDO."
				: "EMAIL INVÁLIDO.");
	}

	private static void padronizacaoTexto() {
		System.out.println("\nPadronizar Texto\n");
		String texto = Console.readLine("Texto : ");
		System.out.println("Texto Padronizado: "
				+ LtpLibAluno.padronizarTexto(texto));

	}

	private static void contarPalavrasTexto() {
		System.out.println("\nContagem de Palavras\n");
		String texto = Console.readLine("Texto : ");
		System.out.println("Quantidade de palavras do Texto: "
				+ LtpLibAluno.contarPalavras(texto) + " - Método 1");
		System.out.println("Quantidade de palavras do Texto: "
				+ LtpLibAluno.contarPalavras2(texto) + " - Método 2");
	}

	private static void verificacaoPalavra() {
		System.out.println("\nVerifica a ocorrência de uma palavra no texto\n");
		String texto = Console.readLine("Texto : ");
		String palavra = Console.readLine("Palavra : ");
		System.out.println("Ocorrência no Texto: "
				+ LtpLibAluno.verificaPalavra(texto, palavra));
	}
	private static void verificacaoUltimaPalavra() {
		System.out.println("\nVerifica Última palavra do texto\n");
		String texto = Console.readLine("Texto : ");
		System.out.println("Última palavra do Texto: "
				+ LtpLibAluno.verificaUltimaPalavra(texto));
	}
	private static void ajustarFds(){
		System.out.println("\nAjustar Fim de Semana\n");
	    int dia = Console.readInt("Dia : ");
	    int mes = Console.readInt("Mes : ");
	    int ano = Console.readInt("Ano : ");
		
	    GregorianCalendar objdata = new GregorianCalendar(ano, mes - 1, dia);
		
		System.out.println("\n" + LtpLib.formatarData(LtpLibAluno.ajustarFimSemana(objdata),"dd/MM/yyyy - EEEE"));
		
		//Outra maneira pelo SimpleDataFormat
		//System.out.println(new SimpleDateFormat("dd/MM/yyyy - EEEE").format(LtpLibAluno.ajustarFimSemana(objdata).getTime()));
	}

	private static void quantDiasCadaMesAno() {

		System.out.println("\nQuantidades de dias de cada mês do ano\n");

		int ano = Console.readInt("Ano : ");
		
		for (int i = 0; i < LtpLibAluno.quantDiasCadaMesDoAno(ano).length; i++) {
			System.out.print(LtpLibAluno.quantDiasCadaMesDoAno(ano)[i] + " ");
		}
		System.out.println("");
	}
	
	private static void calendarioMes() {

		System.out.println("\nCalendário Mensal\n");

		int mes = Console.readInt("Mês: ");
		int ano = Console.readInt("Ano: ");

		for (GregorianCalendar objData : LtpLibAluno.calendarioMensal(mes, ano)) {

			System.out.println(new SimpleDateFormat("dd/MM/yyyy - EEEE").format(objData.getTime()));

			// Formatar data pelo LtpLib
			// System.out.println(LtpLib.formatarData(objData,"dd/MM/yyyy - EEEE"));
		}
	}
}
