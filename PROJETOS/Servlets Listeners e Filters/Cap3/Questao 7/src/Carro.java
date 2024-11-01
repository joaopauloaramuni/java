
public class Carro extends Thread{

	MontanhaMonitor montanha;
	
	public Carro(MontanhaMonitor montanha) {
		this.montanha = montanha;
	}
	
	@Override
	public void run() {
		
		while(true) {

			montanha.carregar();

			montanha.andar();
			
			montanha.descarregar();
		}
	}

}
