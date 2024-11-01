/**
 * DSD - 8NA - 12/08/2013
 * 
 * 1.2. Write a Java class that allows parallel search in an array of integer. 
 * It provides the following static method:
 * public static int parallelSearch (int x, int[ ] A ,int numThreads)
 * 
 * @author João Paulo C. Aramuni
 */

package garg;

import java.util.Arrays;
import java.util.Scanner;

public class ParallelSearch extends Thread {

	/**
	 * Variáveis Globais
	 */
	private ParallelSearch arrayThreads[];
	private int search;
	private int allParts;
	private int thisPart;
	private int arrayQuest[];
	private int position = -1;

	/**
	 * Constructor
	 * 
	 * @param array
	 * @param search
	 * @param allParts
	 * @param thisPart
	 */
	public ParallelSearch(int array[], int search, int allParts, int thisPart) {
		this.arrayQuest = array;
		this.search = search;
		this.allParts = allParts;
		this.thisPart = thisPart;
	}

	/**
	 * Getters and Setters
	 */
	public int getPosicao() {
		return position;
	}

	public void setPosicao(int posicao) {
		this.position = posicao;
	}

	public int getSearch() {
		return search;
	}

	public void setSearch(int search) {
		this.search = search;
	}

	public int[] getArrayPesq() {
		return arrayQuest;
	}

	public void setArrayPesq(int arrayPesq[]) {
		this.arrayQuest = arrayPesq;
	}

	public ParallelSearch[] getArrayThreads() {
		return arrayThreads;
	}

	public void setArrayThreads(ParallelSearch arrayThreads[]) {
		this.arrayThreads = arrayThreads;
	}

	public int getThisPart() {
		return thisPart;
	}

	public void setThisPart(int thisPart) {
		this.thisPart = thisPart;
	}

	public int getAllParts() {
		return allParts;
	}

	public void setAllParts(int allParts) {
		this.allParts = allParts;
	}

	/**
	 * Método para inicializar as threads
	 */
	public void run() {
		int finish;
		int parteLength = arrayQuest.length / allParts;
		int start = (thisPart - 1) * parteLength;

		if (thisPart == allParts) {
			finish = arrayQuest.length;
		} else {
			finish = start + parteLength;
		}

		for (int i = start; i < finish; i++) {
			if (Thread.currentThread().isInterrupted()) {
				break;
			}
			if (arrayQuest[i] == search) {
				position = i;
				for (ParallelSearch thread : arrayThreads) {
					thread.interrupt();
				}
				break;
			}
		}
	}

	/**
	 * Método estático de pesquisa
	 * 
	 * @param elemento
	 * @param arraySearch
	 * @param threads
	 * @return
	 */
	public static int[] parallelSearch(int[] arraySearch, int elemento,
			int threads) {
		int[] resposta = null;
		int cont = 1;
		ParallelSearch array[] = new ParallelSearch[threads];
		while (threads >= cont) {
			array[cont - 1] = new ParallelSearch(arraySearch, elemento,
					threads, cont);
			cont++;
		}

		// Percorrendo array para disparar as threads
		for (ParallelSearch pesqPar : array) {
			pesqPar.setArrayThreads(array);
			pesqPar.start();
		}

		for (ParallelSearch pesqPar : array) {
			try {
				pesqPar.join();
			} catch (Exception e) {
				e.getMessage();
			}
		}

		for (ParallelSearch pesqPar : array) {
			if (pesqPar.getPosicao() >= 0) {
				resposta = new int[] { pesqPar.getPosicao(),
						pesqPar.getThisPart() };
				return resposta;
			}
		}
		return resposta;
	}

	/**
	 * Método main para executar a pesquisa
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("** ParallelSearch **\n");
		try {
			// Variáveis de pesquisa
			int arraySize;
			int elemento;
			int threads;
			int[] resposta;
			String str;

			// Entrada de dados
			Scanner s = new Scanner(System.in);

			System.out.print("Digite o número de elementos do array: ");
			str = s.nextLine(); // Ler dados
			arraySize = Integer.parseInt(str);

			// Criação e população de array de pesquisa
			int[] arraySearch = new int[arraySize];
			for (int i = 0; i < arraySize; i++) {
				arraySearch[i] = i;
			}
			System.out.println(Arrays.toString(arraySearch));

			System.out.print("Digite o elemento a ser procurado: ");
			str = s.nextLine(); // Ler dados
			elemento = Integer.parseInt(str);

			System.out.print("Digite o número de threads: ");
			str = s.nextLine(); // Ler dados
			threads = Integer.parseInt(str);

			// Fechar Scanner
			s.close();

			// Chamada de método de pesquisa para obtenção de resposta
			resposta = parallelSearch(arraySearch, elemento, threads);

			// Exibição de Resultado
			if (resposta != null)
				System.out.println("\nEncontrado! \nPosição : " + resposta[0]
						+ "\nParte: " + resposta[1]);
			else
				System.out.println("Elemento não encontrado!");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
