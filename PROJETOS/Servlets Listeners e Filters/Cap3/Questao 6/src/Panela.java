import java.util.concurrent.Semaphore;

/**
 * DSD - Desenvolvimento de Sistemas Distribuídos
 * Cap 3
 * Data: 15/10/2013
 * @author João Paulo Aramuni
 *
 */
public class Panela {
	
	private Semaphore PermissaoUsarAPanela = new Semaphore (1);
	
	private Semaphore porcoesDeMissionario = new Semaphore(5);
	private Semaphore EncherPanelaComMissionarios = new Semaphore (0);
	private int missionariosNaPanela = 5;
	 
	
	public void acordaCozinheiroParaEncherPanela (){
		System.out.println("acordando o cozinheiro!!");
		EncherPanelaComMissionarios.release();
		System.out.println("Cozinheiro acordado");
	} 
	
	public void comer() throws InterruptedException{
		porcoesDeMissionario.acquire();
		System.out.println("vou verificar a panela");
		PermissaoUsarAPanela.acquire();
		
		if(missionariosNaPanela <= 0){
			System.out.println("Acabaram-se os missionarios... hora de acordar o cozinheiro");
			acordaCozinheiroParaEncherPanela();
			porcoesDeMissionario.release();
		}else{
			System.out.println("HMMM comendo missionarios deleciosos");
			missionariosNaPanela--;
			System.out.println("ainda Existem " +porcoesDeMissionario+" na panela" );
		}
		PermissaoUsarAPanela.release();
		porcoesDeMissionario.release();
		
	}
	
	public void cozinhar() throws InterruptedException{
		EncherPanelaComMissionarios.acquire();
		PermissaoUsarAPanela.acquire();
		missionariosNaPanela = 5;
		for(int i = 0 ; i< 5; i++ ){
			porcoesDeMissionario.release();
		}
		
		System.out.println("Panela Cheia de Missionarios");
		PermissaoUsarAPanela.release();
	}
}
