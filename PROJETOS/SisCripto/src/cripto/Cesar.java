package cripto;

public class Cesar {

	// Vetor auxiliar
	char[] caracteres = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
			'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z', 'á', 'à', 'â', 'ã', 'Á', 'À', 'Â', 'Ã', 'é', 'ê',
			'É', 'Ê', 'í', 'Í', 'ó', 'ô', 'õ', 'Ó', 'Ô', 'Õ', 'ú', 'Ú', '0',
			'1', '2', '3', '4', '5', '6', '7', '8', '9', '?', '!', ' ', '.',
			',', ';', ':' };

	// Variável Global
	private String resposta = "";

	public String criptografar(String texto, int desloc) {
		resposta = "";
		int desc_aux = 0;
		for (int i = 0; i < texto.length(); i++) {
			for (int j = 0; j < caracteres.length; j++) {
				if (texto.charAt(i) == (caracteres[j])) {
					desc_aux = desloc;
					if ((desloc + j) > caracteres.length) {
						desloc = desloc - (caracteres.length - j);
						j = 0;
					}
					resposta = resposta + caracteres[j + desloc];
					desloc = desc_aux;
					break;
				}
			}
		}
		return resposta;
	}

	// Imcompleto
	public String descriptografar(String texto, int desloc) {
		resposta = "";
		for (int i = 0; i < texto.length(); i++) {
			for (int j = 0; j < caracteres.length; j++) {
				if (texto.charAt(i) == (caracteres[j])) {
					resposta = resposta + caracteres[j - desloc];
				}
			}
		}
		return resposta;
	}

	public boolean validarTexto(String texto, String deslocamento) {
		if (!texto.equals("") && !deslocamento.equals("")) {
			// Verficar se o texto é válido
			for (int i = 0; i < texto.length(); i++) {
				for (int j = 0; j < caracteres.length; j++) {
					if (texto.charAt(i) == (caracteres[j])) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean validarDesloc(int desloc) {

		if (desloc < 1 || desloc > 91) {
			return false;
		}

		return true;
	}
}
