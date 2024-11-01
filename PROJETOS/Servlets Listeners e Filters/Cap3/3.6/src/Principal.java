/**
 * DSD - Desenvolvimento de Sistemas Distribuídos
 * Cap 3
 * Data: 15/10/2013
 * @author João Paulo Aramuni
 *
 */
public class Principal {

	public static void main(String[] args) {
		Recursos r = new Recursos();

		new R(r).start();
		new PQ(r, "P").start();
		new PQ(r, "Q").start();
	}
}
