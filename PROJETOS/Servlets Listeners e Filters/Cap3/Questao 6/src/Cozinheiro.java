/**
 * DSD - Desenvolvimento de Sistemas Distribuídos
 * Cap 3
 * Data: 15/10/2013
 * @author João Paulo Aramuni
 *
 */
public class Cozinheiro implements Runnable {
	
	private Panela panela;
	
	public Cozinheiro (Panela panela){
		this.panela = panela;
	}

	@Override
	public void run() {
		while (true){
			try {
				panela.cozinhar();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
