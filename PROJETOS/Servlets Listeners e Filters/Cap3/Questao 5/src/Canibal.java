/**
 * DSD - Desenvolvimento de Sistemas Distribuídos
 * Cap 3
 * Data: 15/10/2013
 * @author João Paulo Aramuni
 *
 */
public class Canibal implements Runnable {
	
	private Panela panela;

	public Canibal(Panela panela) {
		this.panela = panela;
	}

	public void run() {
		while (true) {
			try {
				panela.comerMissionarios();
				System.out.println("Canibal comeu o missionario");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
