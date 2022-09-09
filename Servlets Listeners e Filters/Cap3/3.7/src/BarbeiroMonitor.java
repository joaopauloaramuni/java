/**
 * DSD - Desenvolvimento de Sistemas Distribuídos
 * Cap 3
 * Data: 15/10/2013
 * @author João Paulo Aramuni
 *
 */
public class BarbeiroMonitor {

	private volatile int maximoClientes = 0;
	private volatile int clientes = 0;
	private volatile boolean barbeiroDisponivel = false;
	private volatile boolean fimCorte = false;

	public BarbeiroMonitor(int maximo) {
		maximoClientes = maximo;
	}

	public synchronized void inicioCorte() {
		System.out.println("Barbeiro esperando clientes");
		while (clientes < 1)
			try {
				this.wait();
			} catch (InterruptedException e) {
			}

		System.out.println("Barbeiro acordado");

		clientes--;
		barbeiroDisponivel = true;

		this.notifyAll();
		System.out.println("Barbeiro chamando cliente");
	}

	public synchronized void fimcorte() {
		System.out.println("Barbeiro terminou corte");
		fimCorte = true;
		this.notifyAll();
	}

	public synchronized boolean entraBarbearia(int id) {
		System.out.println("Cliente " + id + " entrou na barbearia");
		if (clientes >= maximoClientes) {
			System.out.println("Barbearia cheia: cliente " + id + " saiu");
			return false;
		}

		System.out.println("Cliente " + id + " aguardando");
		clientes++;
		this.notifyAll();

		while (!barbeiroDisponivel)
			try {
				this.wait();
			} catch (InterruptedException e) {
			}

		barbeiroDisponivel = false;

		System.out.println("Cliente " + id + " chamado pelo barbeiro");

		return true;
	}

	public synchronized void saiBarbearia(int id) {
		while (!fimCorte) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}

		fimCorte = false;
		System.out.println("Cliente " + id + " encerrou");
	}

}
