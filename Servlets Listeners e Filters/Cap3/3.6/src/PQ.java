/**
 * DSD - Desenvolvimento de Sistemas Distribuídos
 * Cap 3
 * Data: 15/10/2013
 * @author João Paulo Aramuni
 *
 */
public class PQ extends Thread {

	private Recursos r;
	private String tipo;

	public PQ(Recursos initr, String initTipo) {
		r = initr;
		tipo = initTipo;
	}

	public void run() {
		try {
			while (true) {
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				r.comecaEscreverPOuQ();
				System.out.println(tipo);
				r.terminaEscreverPOuQ();
			}
		} catch (InterruptedException e) {
		}
	}
}
