/**
 * DSD - Desenvolvimento de Sistemas Distribuídos
 * Cap 3
 * Data: 15/10/2013
 * @author João Paulo Aramuni
 *
 */
public class Panela {

	private int porcoesDeMissionarios;

	public Panela() {
		porcoesDeMissionarios = 10;

	}

	public synchronized void ColocarMissionarios() throws InterruptedException {
		while (porcoesDeMissionarios != 0) {
			System.out.println("Cozinheiro esperando.");
			this.wait();

		}

		porcoesDeMissionarios = 10;
		System.out.println("Cozinheiro encheu a panela.");
		this.notifyAll();
	}

	public synchronized void comerMissionarios() throws InterruptedException {
		while (porcoesDeMissionarios == 0) {
			System.out.println("Canibais esperando.");
			this.wait();
		}
		porcoesDeMissionarios -= 1;
		System.out.println("Canibal comeu.");
		this.notifyAll();
	}

}
