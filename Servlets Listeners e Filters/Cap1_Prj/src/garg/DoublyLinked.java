/**
 * DSD - 8NA - 12/08/2013
 * 
 * 1.5. Write a program in Java that uses two threads to search for a given element
 * in a doubly linked list. One thread traverses the list in the forward direction
 * and the other. in the backward direction.
 * 
 * @author João Paulo C. Aramuni
 */

package garg;

import java.util.Arrays;
import java.util.Scanner;

public class DoublyLinked extends Thread {

	/**
	 * Variáveis Globais
	 */
	private int arrayPesq[];
	private int partToSearch;
	private int result = -1;
	private int toPesq;
	private DoublyLinked arrayThreads[];

	/**
	 * Constructor
	 * 
	 * @param arrayPesq
	 * @param valor
	 */
	public DoublyLinked(int arrayPesq[], int valor) {
		this.arrayPesq = arrayPesq;
		this.toPesq = valor;
		this.result = -1;
	}

	/**
	 * Constructor com sobrecarga de direcionamento
	 * 
	 * @param arrayPesq
	 * @param valor
	 * @param partToSearch
	 */
	public DoublyLinked(int arrayPesq[], int valor, int partToSearch) {
		this.arrayPesq = arrayPesq;
		this.toPesq = valor;
		this.partToSearch = partToSearch;
		this.result = -1;
	}

	/**
	 * Retorna o valor a ser pesquisado
	 * 
	 * @return toPesq
	 */
	public int getToPesq() {
		return this.toPesq;
	}

	/**
	 * Retornar o resultado final
	 * 
	 * @return result
	 */
	public int getResult() {
		return this.result;
	}

	/**
	 * Método para inicializar as threads
	 */
	public void run() {
		int begin;
		int end;
		int position;
		int tamanhoArray = this.arrayPesq.length;
		int metadeArray = tamanhoArray / 2;

		// Posição inicial de pesquisa
		if (partToSearch == 1) {
			begin = 0;
			end = metadeArray;
			position = 0;
		} else {
			begin = metadeArray + 1;
			end = tamanhoArray;
			position = end;
		}

		for (int i = begin; i < end; i++) {
			if (Thread.currentThread().isInterrupted()) {
				break;
			}

			if (partToSearch == 1)
				position++;
			else
				position--;

			if (this.arrayPesq[position] == this.getToPesq()) {
				this.result = position;
				for (DoublyLinked busca : arrayThreads) {
					busca.interrupt();
				}
				break;
			}
		}
	}

	/**
	 * Método que dispara as threads
	 * 
	 * @throws Exception
	 */
	public int pesquisar() throws Exception {
		DoublyLinked busca1 = new DoublyLinked(this.arrayPesq,
				this.getToPesq(), 1);
		DoublyLinked busca2 = new DoublyLinked(this.arrayPesq,
				this.getToPesq(), 2);
		DoublyLinked arrayThreads[] = new DoublyLinked[] { busca1, busca2 };

		for (DoublyLinked busca : arrayThreads) {
			busca.arrayThreads = arrayThreads;
		}

		for (DoublyLinked busca : arrayThreads) {
			busca.start();
		}
		
		try {
			for (DoublyLinked busca : arrayThreads) {
				busca.join();
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		//boolean achou = false;
		//System.out.println("\nNúmero Pesquisado: " + this.getToPesq());
		for (DoublyLinked busca : arrayThreads) {
			if (busca.getResult() != -1) {
				//System.out.println("A thread '" + busca.partToSearch+ "' encontrou o elemento procurado na posição '"+ busca.getResult() + "'");
				return busca.getResult();
				//achou = true;
			}
		}
		//if (!achou) {
		    return -1;
			//throw new Exception("As threads não encontraram o elemento procurado.");
			//System.out.println("As threads não encontraram o elemento procurado.");
		//}
	}

	
	
	/**
	 * Método main
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("** DoublyLinked **\n");
		try {
			// Variáveis de pesquisa
			int arraySize;
			int elemento;
			String str;

			// Entrada de dados
			Scanner s = new Scanner(System.in);

			System.out
					.print("Digite o número de elementos do array:"
							+ "\nObs: O array será duplicado para melhor demonstrar o sistema de busca.\n");
			str = s.nextLine(); // Ler dados
			arraySize = Integer.parseInt(str);

			// Criação e população de array de pesquisa
			int[] arraySearch = new int[arraySize * 2];
			for (int i = 0; i < arraySize; i++) {
				arraySearch[i] = i;
			}
			// Replicar o array para melhor demonstrar o sistema de busca
			int cont = 0;
			for (int j = arraySize; j < arraySize * 2; j++) {
				arraySearch[j] = cont;
				cont++;
			}
			System.out.println(Arrays.toString(arraySearch));

			System.out.print("Digite o elemento a ser procurado: ");
			str = s.nextLine(); // Ler dados
			elemento = Integer.parseInt(str);

			// Fechar Scanner
			s.close();

			// Chamada de método de pesquisa para obtenção de resposta
			int resposta = 	new DoublyLinked(arraySearch, elemento).pesquisar();
			
			System.out.println("A thread encontrou o elemento " + elemento + " na posição " + resposta);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
