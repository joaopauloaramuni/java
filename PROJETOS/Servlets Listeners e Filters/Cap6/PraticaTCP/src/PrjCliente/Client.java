package PrjCliente;

/**
 * DSD - Desenvolvimento de Sistemas Distribu�dos
 * Cap 6
 * Data: 24/11/2013
 * @author Jo�o Paulo Aramuni
 *
 */
public class Client {

	private String name;
	private int debit;

	public Client(String name, int debit) {
		this.name = name;
		this.debit = debit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDebit() {
		return debit;
	}

	public void setDebit(int debit) {
		this.debit = debit;
	}

}
