
public class Passageiro extends Thread {

	MontanhaMonitor montanha;
	private int idPassageiro;
	private boolean estouEmbarcado;

	public boolean isEstouEmbarcado() {
		return estouEmbarcado;
	}

	public void setEstouEmbarcado(boolean estouEmbarcado) {
		this.estouEmbarcado = estouEmbarcado;
	}

	public int getIdPassageiro() {
		return idPassageiro;
	}

	public void setIdPassageiro(int idPassageiro) {
		this.idPassageiro = idPassageiro;
	}

	public Passageiro(MontanhaMonitor montanha, int idPassageiro) {
		this.montanha = montanha;
		this.idPassageiro = idPassageiro;
	}

	@Override
	public void run() {

		while(true)
		{
			System.out.println("Passageiro " + idPassageiro + " entrou na fila");
			while(!montanha.embarcar(idPassageiro))
			{
				try {Thread.sleep(500);} catch (Exception e) {}
			}

			montanha.desembarcar(this.idPassageiro);
		}
	}
}
