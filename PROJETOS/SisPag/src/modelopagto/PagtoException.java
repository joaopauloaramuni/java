package modelopagto;


@SuppressWarnings("serial")
public class PagtoException extends Exception {

	public PagtoException(String mensagemErro) {
		super(mensagemErro);
	}
}
