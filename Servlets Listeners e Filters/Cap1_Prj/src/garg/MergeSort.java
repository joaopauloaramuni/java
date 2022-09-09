/**
 * DSD - 8NA - 12/08/2013
 * 
 * 1.4. Write a multithreaded program in Java that sorts an array using recursive
 * merge sort. The main thread forks two threads to sort the two halves of
 * arrays, which are then merged.
 * 
 * @author João Paulo C. Aramuni
 */

package garg;

public class MergeSort extends Thread {

	/**
	 * Variáveis Globais
	 */
	private int start;
	private int middle;
	private int finish;
	private int arrayPesq[];

	/**
	 * Constructor
	 * 
	 * @param arrayPesq
	 */
	public MergeSort(int arrayPesq[]) {
		this.setArrayPesq(arrayPesq);
	}

	/**
	 * Constructor com sobrecarga
	 * 
	 * @param arrayPesq
	 */
	public MergeSort(int arrayPesq[], int start, int finish) {
		this.arrayPesq = arrayPesq;
		this.start = start;
		this.finish = finish;
	}

	/**
	 * Getters and Setters
	 */
	public int getMiddle() {
		return middle;
	}

	public void setMiddle(int middle) {
		this.middle = middle;
	}

	public int getFinish() {
		return finish;
	}

	public void setFinish(int finish) {
		this.finish = finish;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int[] getArrayPesq() {
		return arrayPesq;
	}

	public void setArrayPesq(int arrayPesq[]) {
		this.arrayPesq = arrayPesq;
	}

	/**
	 * Método para inicializar as threads
	 */
	public void run() {
		if (this.getStart() < this.getFinish()) {
			this.setMiddle(this.getSoma() / 2);

			MergeSort ms1 = new MergeSort(this.getArrayPesq(), this.getStart(),
					this.getMiddle());
			MergeSort ms2 = new MergeSort(this.arrayPesq, this.getMiddle() + 1,
					this.getFinish());

			ms1.start();
			ms2.start();

			try {
				ms1.join();
				ms2.join();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			mergeResult(this.getStart(), this.getMiddle(), this.getFinish());
		}
	}
	
	/**
	 * Método mergeResult
	 * @param start
	 * @param middle
	 * @param finish
	 */
	private void mergeResult(int start, int middle, int finish) {
		int totalSize = finish - start + 1;
		int temporary[] = new int[totalSize];
		int cont = 0;
		int cont2 = (middle - start) + 1;

		for (int pos = 0; pos < totalSize; pos++) {
			temporary[pos] = this.arrayPesq[start + pos];
		}

		for (int pos = 0; pos < totalSize; pos++) {
			if (cont2 <= totalSize - 1) {
				if (cont <= middle - start) {
					if (temporary[cont] < temporary[cont2]) {
						this.arrayPesq[start + pos] = temporary[cont++];
					} else {
						this.arrayPesq[start + pos] = temporary[cont2++];
					}
				} else {
					this.arrayPesq[start + pos] = temporary[cont2++];

				}
			} else {
				this.arrayPesq[start + pos] = temporary[cont++];
			}
		}
	}

	/**
	 * Método para obter a soma inicial com o final a ser procurado
	 * 
	 * @return resultado da soma
	 */
	public int getSoma() {
		int result = this.getStart() + this.getFinish();
		return result;
	}

	/**
	 * Método main
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("** MergeSort **\n");
		int t = 50;
		int value;
		int arrayPesq[];
		arrayPesq = new int[t];
		for (int i = 0; i < t; i++) {
			value = 1 + (int) (Math.random() * 250);
			arrayPesq[i] = value;
		}

		System.out.println("Vetor Original:");
		for (int valor : arrayPesq) {
			System.out.print(valor + ", ");
		}
		System.out.println("\n");

		MergeSort ms = new MergeSort(arrayPesq);
		ms.setStart(0);
		ms.setFinish(arrayPesq.length - 1);

		ms.start();
		ms.join();

		System.out.println("Vetor Ordenado:");
		for (int valor : ms.arrayPesq) {
			System.out.print(valor + ", ");
		}
	}
}
