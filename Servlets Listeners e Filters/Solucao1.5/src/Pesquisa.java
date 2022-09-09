import java.util.List;
import java.util.ListIterator;


public class Pesquisa extends Thread {
	
	private List<Integer> lista;
	private int elemento;
	private boolean direto;
	private Pesquisa colega;
	
	private boolean encontrado;
	
	public Pesquisa(List<Integer> lista, int elemento, boolean direto) {
		this.lista = lista;
		this.elemento = elemento;
		this.direto = direto;
	}
	
	public void setColega(Pesquisa colega) {
		this.colega = colega;
	}
	
	public boolean isEncontrado() {
		return encontrado;
	}
	
	@Override
	public void run() {
		
		ListIterator<Integer> it = lista.listIterator(direto ? 0 : lista.size());
		
		encontrado = false;
		
		if(direto) {
			while(it.hasNext()) {
				if(Thread.currentThread().isInterrupted())
					break;
				
				int e = it.next();
				
				if(e == elemento) {
					colega.interrupt();
					encontrado = true;
//					System.out.println("Thread direta encontrou");
					break;
				}
			}
		}
		else {
			while(it.hasPrevious()) {
				if(Thread.currentThread().isInterrupted())
					break;

				int e = it.previous();
				
				if(e == elemento) {
					colega.interrupt();
					encontrado = true;
//					System.out.println("Thread reversa encontrou");
					break;
				}
			}
		}
	}

}
