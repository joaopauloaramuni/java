/**
 * DSD - Desenvolvimento de Sistemas Distribu�dos
 * Cap 3
 * Data: 15/10/2013
 * @author Jo�o Paulo Aramuni
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
