/**
 * DSD - Desenvolvimento de Sistemas Distribuídos
 * Cap 3
 * Data: 15/10/2013
 * @author João Paulo Aramuni
 *
 */
public class Cliente extends Thread {

	private BarbeiroMonitor bd = null;
	private int id = 0;

	public Cliente(int id, BarbeiroMonitor bd) {
		this.id = id;
		this.bd = bd;
	}

	@Override
	public void run() {
		if (bd.entraBarbearia(this.id)) {
			System.out.println("Cliente " + id + " cortando o cabelo");
			bd.saiBarbearia(this.id);
		}
	}

}
