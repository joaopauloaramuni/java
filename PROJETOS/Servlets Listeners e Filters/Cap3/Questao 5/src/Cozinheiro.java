/**
 * DSD - Desenvolvimento de Sistemas Distribu�dos
 * Cap 3
 * Data: 15/10/2013
 * @author Jo�o Paulo Aramuni
 *
 */
public class Cozinheiro implements Runnable {

	private Panela panela;

	public Cozinheiro(Panela panela) {
		this.panela = panela;
	}

	public void run() {
		while (true) {
			try {
				panela.ColocarMissionarios();
				System.out.println("Missionario encheu a panela.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
