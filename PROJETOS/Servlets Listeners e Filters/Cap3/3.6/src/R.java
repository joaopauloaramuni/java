/**
 * DSD - Desenvolvimento de Sistemas Distribuídos
 * Cap 3
 * Data: 15/10/2013
 * @author João Paulo Aramuni
 *
 */
public class R extends Thread {

	private Recursos r;

	public R(Recursos initr) {
		r = initr;
	}

	public void run() {
		try {
			while (true) {
				r.comecaEscreverR();
				System.out.println("R");
			}
		} catch (InterruptedException e) {
		}
	}
}
