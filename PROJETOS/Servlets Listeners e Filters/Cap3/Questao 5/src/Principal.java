/**
 * DSD - Desenvolvimento de Sistemas Distribu�dos
 * Cap 3
 * Data: 15/10/2013
 * @author Jo�o Paulo Aramuni
 *
 */
public class Principal {

	public static void main(String[] args) {

		Panela panela = new Panela();
		Canibal canibal = new Canibal(panela);
		Cozinheiro cozinheiro = new Cozinheiro(panela);
		Thread t0 = new Thread(canibal);
		Thread t1 = new Thread(cozinheiro);

		t0.start();
		t1.start();
		try {
			t1.join();
			t0.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
