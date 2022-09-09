import java.util.concurrent.Semaphore;

/**
 * DSD - Desenvolvimento de Sistemas Distribuídos
 * Cap 3
 * Data: 15/10/2013
 * @author João Paulo Aramuni
 *
 */
public class SleepingBarber {

	private int cadeiras = 0;
	private int ocupadas = 0;
	int clientes = 0;

	private final Semaphore mutex = new Semaphore(1);

	public SleepingBarber(int cadeiras) {
		this.cadeiras = cadeiras;
		clientes = 0;
	}

	public void runBarber() throws InterruptedException {
		while (true) {
			System.out.println("Esperando cliente dormindo...");
			while (ocupadas == 0)
				Thread.sleep(2000);
			System.out.println("Cliente entrou e se sentou na cadeira ...");

			mutex.acquire();
			ocupadas--;
			System.out
					.println("Cliente acaba de se levantar para ser atendido...");
			mutex.release();

			System.out.println("Cortando cabelo do cliente ...");
			Thread.sleep(4000);
			System.out.println("Corte terminado...");

		}
	}

	public void Corte() throws InterruptedException {
		mutex.acquire();
		System.out
				.println("Entra na barbearia e está verificando se está cheio...");
		Thread.currentThread().getName();
		if (ocupadas < cadeiras) {
			ocupadas++;
			System.out.println("Tem vaga e acaba de se sentar na cadeira...");
			Thread.currentThread().getName();
		} else {
			System.out.println("Barbearia cheia!");
			Thread.currentThread().getName();
			mutex.release();
			return;
		}

		mutex.release();

	}
}
