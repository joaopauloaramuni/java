/**
 * DSD - Desenvolvimento de Sistemas Distribuídos
 * Cap 3
 * Data: 15/10/2013
 * @author João Paulo Aramuni
 *
 */
public class Leitor extends Thread {

	private int id = 1;
	private Auxilio a = null;

	public Leitor(int id, Auxilio a) {
		this.a = a;
		this.id = id;
	}

	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("Leitor fora da Condição");
				Thread.sleep(100);
				a.inicioLeitura();
				System.out.println("Leitor " + id + " lendo");
				Thread.sleep(10);
				a.finalLeitura();
				System.out.println("Leitor termina leitura");
			}
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}

}
