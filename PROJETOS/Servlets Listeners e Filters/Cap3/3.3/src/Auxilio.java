import java.util.concurrent.Semaphore;

/**
 * DSD - Desenvolvimento de Sistemas Distribuídos
 * Cap 3
 * Data: 15/10/2013
 * @author João Paulo Aramuni
 *
 */
public class Auxilio {

	private volatile int leitoresAtivos = 0;
	private volatile int leitoresEspera = 0;
	private volatile int escritoresAtivos = 0;
	private volatile int escritoresEspera = 0;

	private Semaphore leitor = new Semaphore(0);
	private Semaphore escritor = new Semaphore(0);
	private Semaphore mutex = new Semaphore(1);

	public void inicioEscrita() throws InterruptedException {

		mutex.acquire();
		if (escritoresAtivos > 0 || escritoresEspera > 0 || leitoresAtivos > 0
				|| leitoresEspera > 0) {
			escritoresEspera++;
			mutex.release();
			escritor.acquire();
			mutex.acquire();
			escritoresEspera--;
		}
		escritoresAtivos++;
		mutex.release();
	}

	public void finalEscrita() throws InterruptedException {
		mutex.acquire();
		escritoresAtivos--;
		if (leitoresEspera > 0) {
			for (int i = 0; i < leitoresEspera; i++)
				leitor.release();
		} else if (escritoresEspera > 0)
			escritor.release();
		mutex.release();

	}

	public void inicioLeitura() throws InterruptedException {

		mutex.acquire();
		if (escritoresAtivos > 0 || escritoresEspera > 0) {
			leitoresEspera++;
			mutex.release();
			leitor.acquire();
			mutex.acquire();
			leitoresEspera--;
		}
		leitoresAtivos++;
		mutex.release();
	}

	public void finalLeitura() throws InterruptedException {
		mutex.acquire();
		leitoresAtivos--;
		if (leitoresAtivos == 0 && escritoresEspera > 0) {
			escritor.release();
		}
		mutex.release();
	}

}
