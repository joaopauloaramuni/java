/**
 * DSD - Desenvolvimento de Sistemas Distribu�dos
 * Cap 3
 * Data: 15/10/2013
 * @author Jo�o Paulo Aramuni
 *
 */
public class Barbeiro extends Thread {

	private BarbeiroMonitor bd = null;

	public Barbeiro(BarbeiroMonitor bd) {
		this.bd = bd;
	}

	@Override
	public void run() {
		while (true) {
			bd.inicioCorte();

			System.out.println("Barbeiro cortando cabelo");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}

			bd.fimcorte();
		}
	}

}
