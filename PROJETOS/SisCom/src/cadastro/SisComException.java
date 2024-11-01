package cadastro;

/**
 * Descrição: Classe SisComException (Herança da Classe Exception)
 * Pacote: cadastro
 * @author João Paulo Aramuni 
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
