/**
 * DSD - Desenvolvimento de Sistemas Distribuídos
 * Cap 3
 * Data: 15/10/2013
 * @author João Paulo Aramuni
 *
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("Exercicio Leitor e Escritor");
		Auxilio a = new Auxilio();
		for (int i = 1; i <= 5; i++)
			new Leitor(i, a).start();
		for (int i = 1; i <= 2; i++)
			new Escritor(i, a).start();
	}

}
