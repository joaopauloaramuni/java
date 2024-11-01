package teste;

import java.util.Scanner;
public class Leitura {
	public static void main(String[] args) {
		// crie a variável de leitura dos dados
		Scanner s = new Scanner(System.in);
		// use os métodos de leitura específicos do tipo desejado
		System.out.print("digite uma linha: ");
		String linha = s.nextLine(); // le a linha
		System.out.print("digite um numero inteiro: ");
		int i = s.nextInt(); // le um inteiro
		System.out.print("digite um numero real: ");
		double d = s.nextDouble(); // le um ponto-flutuante
		System.out.println("Linha : " + linha + "\n" +
				           "Numero Inteiro : " + i + "\n" +
				           "Numero Real : " + d);
	}
}
