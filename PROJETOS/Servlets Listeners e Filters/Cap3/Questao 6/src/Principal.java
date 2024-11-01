import java.util.ArrayList;

/**
 * DSD - Desenvolvimento de Sistemas Distribuídos
 * Cap 3
 * Data: 15/10/2013
 * @author João Paulo Aramuni
 *
 */
public class Principal {

	public static void main(String[] args) {
		Panela panela = new Panela();
		Cozinheiro cozinheiro = new Cozinheiro(panela);
		ArrayList<Thread> canibais = new ArrayList<Thread>();

		for (int i = 0; i < 10; i++) {
			Canibal c = new Canibal(panela);
			Thread t = new Thread(c);
			canibais.add(t);
		}
		Thread treadCozinheiro = new Thread(cozinheiro);

		// startar threads
		for (Thread t : canibais) {
			t.start();
		}
		treadCozinheiro.start();

		try {
			for (Thread t : canibais) {
				t.join();
			}
			treadCozinheiro.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
