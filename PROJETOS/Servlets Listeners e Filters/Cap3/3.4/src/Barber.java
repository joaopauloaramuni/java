/**
 * DSD - Desenvolvimento de Sistemas Distribu�dos
 * Cap 3
 * Data: 15/10/2013
 * @author Jo�o Paulo Aramuni
 *
 */
public class Barber extends Thread {

	SleepingBarber barbeiro = null;

	public Barber(SleepingBarber slpBarber) {
		barbeiro = slpBarber;
	}

	@Override
	public void run() {
		try {
			barbeiro.runBarber();
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}
}
