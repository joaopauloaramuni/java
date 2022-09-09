import java.util.ArrayList;


public class MontanhaMonitor {
	
	private final int VAGAS = 10;
	private int cont = 0;
	private boolean podeDesembarcar = false;
	private boolean podeEmbarcar = false;
	private boolean andando = false;
	
	ArrayList<Passageiro> passageiros;
	Carro carro;
	
	public MontanhaMonitor() {

	}

	public void setPassageiros(ArrayList<Passageiro> passageiros) {
		this.passageiros = passageiros;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Carro getCarro() {
		return this.carro;
	}
	
	public synchronized boolean embarcar(int idPassageiro)
	{				
		if(this.cont >= this.VAGAS) {
			System.out.println("Carro está cheio: passageiro " + idPassageiro + " aguardando");
			return false;
		}
		
		while(this.cont >= this.VAGAS || !podeEmbarcar) {
			try {this.wait();} catch (InterruptedException e) {}
		}
		
		this.notifyAll();
			
		System.out.println("Passageiro " + idPassageiro + " embarcou");
				
		this.cont++;
		return true;				
	}
	
	public synchronized void desembarcar(int idPassageiro)
	{
		while(!podeDesembarcar) {
			try {this.wait();} 
			catch (InterruptedException e) {}
		}
				
		this.cont--;
		
		System.out.println("Passageiro " + idPassageiro + "  desembarcou");
		
		this.notifyAll();		
	}

	public synchronized void andar()
	{				
		while(this.cont < this.VAGAS)
		{
			try {this.wait();} catch (InterruptedException e) {}
		}
		
		andando = true;
		podeEmbarcar = false;
		System.out.println("carro andando...");
		
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			
		}
		
		andando = false;
		this.notifyAll();
	}
	
	public synchronized void carregar()
	{
		while (this.cont > 0) {
			try {this.wait();} catch (InterruptedException e) {}			
		}
		
		System.out.println("Carro carregando");
		podeEmbarcar = true;
		podeDesembarcar = false;
		this.notifyAll();
	}
	
	public synchronized void descarregar()
	{
		while(andando)
		{
			try {this.wait();} catch (InterruptedException e) {}
		}
		
		System.out.println("Descarregar - Carro terminou a volta");
		podeDesembarcar = true;
		podeEmbarcar = false;
		this.notifyAll();
	}
	
}
