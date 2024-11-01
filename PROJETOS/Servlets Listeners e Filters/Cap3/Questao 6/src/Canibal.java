/**
 * DSD - Desenvolvimento de Sistemas Distribu�dos
 * Cap 3
 * Data: 15/10/2013
 * @author Jo�o Paulo Aramuni
 *
 */
public class Canibal implements Runnable {
	
	Panela panela;
	
	public Canibal (Panela panela){
		this.panela = panela;
	}
	
	@Override
	public void run() {
	while (true){
		try {
			panela.comer();
		} catch (InterruptedException e) {
			
		}
	}
		
	}

}
