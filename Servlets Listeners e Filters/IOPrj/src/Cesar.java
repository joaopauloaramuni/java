
public class Cesar {

	private static final char[] caracteres = {
			'a','b','c','d','e','f','g','h','i','j','k','l','m','n',        
			'o','p','q','r','s','t','u','v','w','x','y','z','A','B',
			'C','D','E','F','G','H','I','J','K','L','M','N','O','P',
			'Q','R','S','T','U','V','W','X','Y','Z','á','à','â','ã',
			'Á','À','Â','Ã','é','ê','É','Ê','í','Í','ó','ô','õ','Ó',
			'Ô','Õ','ú','Ú','0','1','2','3','4','5','6','7','8','9',
			'0','?','!',' ','.',',',';',':'
	};

	private static final char[] caracreverso = new char[caracteres.length];


	static {
		for(int i = 0; i < caracteres.length; i++)
			caracreverso[caracteres.length - i -1] = caracteres[i];
	}

	public static String converte (String texto, int deslocamento, boolean decodifica) {
		char[] vetcar = decodifica ? caracreverso : caracteres;
		StringBuilder resultado = new StringBuilder(texto.length());

		for (int i = 0; i < texto.length(); i++) {
			int pos = posicao(vetcar,texto.charAt(i));
			if(pos < 0) return "Texto com caracter inválido: " + texto.charAt(i);
			resultado.append(vetcar[(pos + deslocamento) % vetcar.length]);
		}

		return resultado.toString();
	}

	private static int posicao (char[] vet, char c) {
		for(int i = 0; i < vet.length; i++)
			if(c == vet[i]) {
				return i;
			}
		return -1;
	}

}
