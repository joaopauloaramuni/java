
public class Cesar {
	
	private final char[] caracteres = 
		   {'a','b','c','d','e','f','g','h','i','j','k','l','m','n',        
			'o','p','q','r','s','t','u','v','w','x','y','z','A','B',
		    'C','D','E','F','G','H','I','J','K','L','M','N','O','P',
		    'Q','R','S','T','U','V','W','X','Y','Z','á','à','â','ã',
		    'Á','À','Â','Ã','é','ê','É','Ê','í','Í','ó','ô','õ','Ó',
		    'Ô','Õ','ú','Ú','0','1','2','3','4','5','6','7','8','9',
		    '0','?','!',' ','.',',',';',':'
		};
	
	public int getLength() {
		return caracteres.length;
	}
	
	public String converte(String texto, int deslocamento, boolean decifrar) {
		
		if(decifrar)
			deslocamento = caracteres.length - deslocamento;
		
		StringBuilder resultado = new StringBuilder();
		
		for(int i = 0; i < texto.length(); i++) {
			int pos = posicao(texto.charAt(i));
			if(pos < 0)
				return "Texto com caracter inválido: " + texto.charAt(i);
			resultado.append(caracteres[(pos+deslocamento) % caracteres.length]);
		}
		
		return resultado.toString();
	}
	
	private int posicao(char c) {
		for(int i = 0; i < caracteres.length; i++)
			if(c == caracteres[i])
				return i;
		return -1;
	}
}
