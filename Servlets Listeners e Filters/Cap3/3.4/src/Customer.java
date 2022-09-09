/**
 * DSD - Desenvolvimento de Sistemas Distribuídos
 * Cap 3
 * Data: 15/10/2013
 * @author João Paulo Aramuni
 *
 */
public class Customer extends Thread {

	private SleepingBarber barbearia = null;

	public Customer(SleepingBarber barbearia, String name) {
		super(name);
		this.barbearia = barbearia;
	}

	public void run() {
		try {
			barbearia.Corte();
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}
}
