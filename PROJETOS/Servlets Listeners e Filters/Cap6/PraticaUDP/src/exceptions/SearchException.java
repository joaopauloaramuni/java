package exceptions;

/**
 * DSD - Desenvolvimento de Sistemas Distribu�dos
 * Cap 6
 * Data: 24/11/2013
 * @author Jo�o Paulo Aramuni
 *
 */
public class SearchException  extends Exception{

	private static final long serialVersionUID = 1L;
	
	public SearchException(String logicName) {
		super(String.format("O nome %s n�o encontrado.", logicName));
	}

}
