/**
 * DSD - Desenvolvimento de Sistemas Distribuídos
 * Cap 3
 * Data: 15/10/2013
 * @author João Paulo Aramuni
 *
 */
public class Escritor extends Thread {
	private Auxilio aux = null;
	private int id = 1;

	public Escritor(int id, Auxilio aux) {
		this.id = id;
		this.aux = aux;
	}

	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("Escritor fora da CONDIÇAO");
				Thread.sleep(100);
				aux.inicioEscrita();
				System.out.println("Escritor " + id + " escrevendo");
				Thread.sleep(800);
				aux.finalEscrita();
				System.out.println("Escritor parou de escrever");
			}
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}

}
