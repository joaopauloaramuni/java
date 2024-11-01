package cadastro;

/**
 * Descri��o: Classe SisComException (Heran�a da Classe Exception)
 * Pacote: cadastro
 * @author Jo�o Paulo Aramuni 
 * @version 1.0 - Maio 2011
 * */

@SuppressWarnings("serial")
public class SisComException extends Exception{

	public SisComException() {
		super();
	}

	public SisComException(String message, Throwable cause) {
		super(message, cause);
	}

	public SisComException(String message) {
		super(message);
	}

	public SisComException(Throwable cause) {
		super(cause);
	}
	
}
