
public class Principal {

	public static void main(String[] args) {
	
		MontanhaMonitor montanha = new MontanhaMonitor();
		
		new Carro(montanha).start();
		
		for(int i = 1; i <= 20; i++)
		{
			new Passageiro(montanha, i).start();
			try {Thread.sleep(100);} catch (InterruptedException e) {}
		}		
		
	}

}
