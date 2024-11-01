import java.util.LinkedList;
import java.util.List;


public class Principal {

	public static void main(String[] args) {
		
		final int TAMANHO = 100000;
		
		List<Integer> lista = new LinkedList<>();
		
		for(int i = 0; i < TAMANHO; i++)
			lista.add(i);
		
		int elemento = 99995;
		
		Pesquisa direto = new Pesquisa(lista, elemento, true);
		Pesquisa reverso = new Pesquisa(lista, elemento, false);
		
		direto.setColega(reverso);
		reverso.setColega(direto);
		
		direto.start();
		reverso.start();
		
		try {
			direto.join();
			reverso.join();
		}
		catch (InterruptedException e) {}
		
		boolean diretoEncontrou = direto.isEncontrado();
		boolean reversoEncontrou = reverso.isEncontrado();
		
//		if(diretoEncontrou)
//			System.out.println("Elemento encontrado (thread direta)");
//		else
//		if(reversoEncontrou)
//			System.out.println("Elemento encontrado (thread reversa)");
//		else
//			System.out.println("Elemento não encontrado");
		
		if(diretoEncontrou || reversoEncontrou)
			System.out.println("Elemento encontrado");
		else
			System.out.println("Elemento não encontrado");
	}

}
