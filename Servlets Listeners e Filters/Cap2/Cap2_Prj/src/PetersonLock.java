/***
 * DSD - Noite 
 * Nome: João Paulo C. Aramuni 
 * Peterson para N threads 
 * Data: 07/09/2013
 */
public class PetersonLock {

	/***
	 * Variáveis privadas
	 */
	private final int numThreads;
	private volatile boolean wantCS[];
	private volatile int[][] turn;

	/***
	 * Construtor
	 * 
	 * @param numProc
	 */
	public PetersonLock(int numProc) {
		this.numThreads = numProc;
		wantCS = new boolean[this.numThreads];
		turn = new int[this.numThreads][this.numThreads];
		for (int j = 0; j < this.numThreads; j++) {
			wantCS[j] = false;
			for (int x = 0; x < this.numThreads; x++) {
				turn[j][x] = 1;
			}
		}
	}

	/**
	 * Método requestCS
	 * 
	 * @param i
	 */
	public void requestCS(int i) {
		int p1;
		int p2;
		wantCS[i] = true;
		for (int j = 0; j < this.numThreads; j++) {
			if (i != j) {
				p1 = (i < j) ? i : j;
				p2 = (i >= j) ? j : i;

				while (wantCS[j] && (turn[p1][p2] == j))
					;
			}
		}
	}

	/***
	 * Método releaseCS
	 * 
	 * @param i
	 */
	public void releaseCS(int i) {
		wantCS[i] = false;
	}
}
