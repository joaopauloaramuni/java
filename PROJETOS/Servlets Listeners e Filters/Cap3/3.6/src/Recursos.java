import java.util.concurrent.Semaphore;

/**
 * DSD - Desenvolvimento de Sistemas Distribuídos
 * Cap 3
 * Data: 15/10/2013
 * @author João Paulo Aramuni
 *
 */
public class Recursos {

	private volatile int qtdPQ = 0;
	private volatile int qtdR = 0;
	private volatile int qtd = 0;

	private Semaphore escrita = new Semaphore(0);
	private Semaphore mutex = new Semaphore(1);

	public void comecaEscreverR() throws InterruptedException {
		mutex.acquire();
		qtdR++;
		if (qtdR > qtdPQ) {
			qtd++;
			mutex.release();
			escrita.acquire();
		} else {
			mutex.release();
		}
	}

	public void comecaEscreverPOuQ() throws InterruptedException {
		mutex.acquire();
		qtdPQ++;
		mutex.release();
	}

	public void terminaEscreverPOuQ() throws InterruptedException {
		mutex.acquire();
		if (qtd > 0 && qtdR <= qtdPQ) {
			escrita.release();
			qtd = 0;
		}
		mutex.release();
	}
}
