/***
 * DSD - Noite 
 * Nome: Jo�o Paulo C. Aramuni 
 * Peterson para N threads 
 * Data: 07/09/2013
 */
public class Peterson extends Thread {

	/**
	 * Vari�veis privadas
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
	 * M�todo run
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
	 * M�todos de exibi��o
	 */
	private void sessaoCriticaIn() {
		System.out.println(this.id + " entrou na sess�o cr�tica.");
		System.out.println(this.id + " saiu da sess�o cr�tica");
	}

	private void sessaoCriticaOut() {
		System.out.println(this.id + " n�o est� na sess�o cr�tica");
	}
}
