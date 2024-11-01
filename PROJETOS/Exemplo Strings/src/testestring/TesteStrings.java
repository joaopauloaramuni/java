package testestring;

import utilitarios.Console;

public class TesteStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		listarCaractersTexto();

	}

	private static void listarCaractersTexto() {
		String texto = Console.readLine("Texto : ");
		for (int i = 0; i < texto.length(); i++) {
			System.out.println(texto.substring(i, i + 1));
		}
		System.out.println("--------------------");
		for (int i = texto.length() - 1; i >= 0; i--) {
			System.out.println(texto.substring(i, i + 1));
		}
		System.out.println("--------------------");
		for (int i = 0; i < texto.length(); i++) {
			System.out.println(texto.substring(0, i + 1));
		}
		System.out.println("--------------------");
		String palavras[] = texto.trim().split(" ");
		for (int i = 0; i < palavras.length; i++) {
			System.out.println(palavras[i]);
		}

	}
}