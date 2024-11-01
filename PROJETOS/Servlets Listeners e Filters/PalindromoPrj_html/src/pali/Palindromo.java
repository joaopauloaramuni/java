package pali;

public class Palindromo {

	public boolean pali(String palavra) {

		String palavra_invertida = "";
		for (int i = palavra.length() - 1; i >= 0; --i) {
			palavra_invertida += palavra.charAt(i);
		}

		return (palavra.equalsIgnoreCase(palavra_invertida));
	}
}
