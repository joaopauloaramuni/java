/***
 * DSD - Noite 
 * Nome: João Paulo C. Aramuni 
 * Peterson para N threads 
 * Data: 07/09/2013
 */
public class Peterson extends Thread {

	/**
	 * Variáveis privadas
	 */
	private int id;
	private PetersonLock lock;

	/***
	 * Construtor
	 * 
	 * @param id
	 * @param lock
	 */
	public Peterson(int id, PetersonLock lock) {
		this.id = id;
		this.lock = lock;
	}

	/***
	 * Método run
	 */
	public void run() {
		while (true) {
			lock.requestCS(this.id);
			this.sessaoCriticaIn();
			lock.releaseCS(this.id);
			this.sessaoCriticaOut();
		}
	}

	/***
	 * Métodos de exibição
	 */
	private void sessaoCriticaIn() {
		System.out.println(this.id + " entrou na sessão crítica.");
		System.out.println(this.id + " saiu da sessão crítica");
	}

	private void sessaoCriticaOut() {
		System.out.println(this.id + " não está na sessão crítica");
	}
}
