package exceptions;

/**
 * DSD - Desenvolvimento de Sistemas Distribuídos
 * Cap 6
 * Data: 24/11/2013
 * @author João Paulo Aramuni
 *
 */
public class InsertException extends Exception {

	private static final long serialVersionUID = 1L;

	public InsertException(String logicName) {
		super(String.format(" O nome \" %s \" já está registrado.", logicName));
	}

}
