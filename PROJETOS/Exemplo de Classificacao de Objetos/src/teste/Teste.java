package teste;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import modelo.Pessoa;
import modelo.PessoaNomeDescIsolado;

public class Teste {
	
	private  Vector<Pessoa> cadPessoas = new Vector<Pessoa>();
	
	public static void main(String[] args) {
		
		Teste x = new Teste();
		x.teste();

	}
	
	private void teste() {
		
		cadPessoas.add(new Pessoa(1, "Jose Eduardo", "SABARA"));
		cadPessoas.add(new Pessoa(2, "Carlos Eduardo", "BH"));
		cadPessoas.add(new Pessoa(3, "Antonio Eduardo", "BH"));
		cadPessoas.add(new Pessoa(4, "Karla Silva", "SABARA"));
		cadPessoas.add(new Pessoa(5, "Cristiano Dias", "BH"));		
		
        System.out.println("\nPessoas em ordem de Código (Original)\n");
		for(Pessoa obj : cadPessoas) System.out.println(obj.toString());
		
		listarPessoasCidadeNomeComparable();
		listarPessoasNomeClasseInterna();
		listarPessoasNomeClasseInternaAnonima();
		listarPessoasCidadeClasseInterna();
		listarPessoasCidadeCodigoClasseInternaAnonima();
		listarPessoasNomeDescOutraClasseNoArquivo();
		listarPessoasNomeDescOutraClasseNooutroArquivo();
		
	}


	private  void listarPessoasCidadeNomeComparable() {
		Vector<Pessoa> cadPessoasCopia = (Vector<Pessoa>)cadPessoas.clone();
		Collections.sort(cadPessoasCopia);
        System.out.println("\nPessoas em ordem de Cidade e Nome - Interface Comparable\n");		
		for(Pessoa obj : cadPessoasCopia) System.out.println(obj.toString());
	}

	private  void listarPessoasNomeClasseInterna() {
		Vector<Pessoa> cadPessoasCopia = (Vector<Pessoa>)cadPessoas.clone();
		Collections.sort(cadPessoasCopia, new Teste.PessoasNome());
        System.out.println("\nPessoas em ordem de Nome - Interface Comparator - Classe Interna\n");		
		for(Pessoa obj : cadPessoasCopia) System.out.println(obj.toString());
	}
	
	private  void listarPessoasNomeClasseInternaAnonima() {
		Vector<Pessoa> cadPessoasCopia = (Vector<Pessoa>)cadPessoas.clone();
		
		Collections.sort(cadPessoasCopia, new Comparator<Pessoa>() {

			@Override
			public int compare(Pessoa o1, Pessoa o2) {
				// TODO Auto-generated method stub
				return o1.getNome().compareTo(o2.getNome());
			}
		});
		
        System.out.println("\nPessoas em ordem de Nome - Interface Comparator (Classe Interna Anonima)\n");		
		for(Pessoa obj : cadPessoasCopia) System.out.println(obj.toString());
		
	}
	
	private  void listarPessoasCidadeClasseInterna() {
		Vector<Pessoa> cadPessoasCopia = (Vector<Pessoa>)cadPessoas.clone();
		Collections.sort(cadPessoasCopia, new Teste.PessoasCidade());
        System.out.println("\nPessoas em ordem de Cidade - Interface Comparator - Classe Interna\n");
		for(Pessoa obj : cadPessoasCopia) System.out.println(obj.toString());
	}	
	
	private  void listarPessoasCidadeCodigoClasseInternaAnonima() {
		Vector<Pessoa> cadPessoasCopia = (Vector<Pessoa>)cadPessoas.clone();
		
		Collections.sort(cadPessoasCopia, new Comparator<Pessoa>() {

			@Override
			public int compare(Pessoa o1, Pessoa o2) {
				if (o1.getCidade().equals(o2.getCidade())) {
					if (o1.getCodigo()==o2.getCodigo()) return 0;
					if (o1.getCodigo()<o2.getCodigo()) return -1;
					return 1;
				} else {
					return o1.getCidade().compareTo(o2.getCidade());
				}
			}
		});
		
        System.out.println("\nPessoas em ordem de Cidade e Código  - Interface Comparator (Classe Interna Anonima)\n");		
		for(Pessoa obj : cadPessoasCopia) System.out.println(obj.toString());
		
	}
	
	private void listarPessoasNomeDescOutraClasseNoArquivo() {
		Vector<Pessoa> cadPessoasCopia = (Vector<Pessoa>)cadPessoas.clone();
		Collections.sort(cadPessoasCopia, new PessoaNomeDesc());
        System.out.println("\nPessoas em ordem de Nome  Descendente  - Interface Comparator - Outra classe no mesmo arquivo\n");		
		for(Pessoa obj : cadPessoasCopia) System.out.println(obj.toString());
		
	}


	private void listarPessoasNomeDescOutraClasseNooutroArquivo() {
		
		Vector<Pessoa> cadPessoasCopia = (Vector<Pessoa>)cadPessoas.clone();
		Collections.sort(cadPessoasCopia, new PessoaNomeDescIsolado());
        System.out.println("\nPessoas em ordem de Nome Descendente - Interface Comparator - Outra classe em outro arquivo\n");		
		for(Pessoa obj : cadPessoasCopia) System.out.println(obj.toString());
		
	}
	
	
    // Classes Internas
	
	class PessoasNome implements Comparator<Pessoa> {

		@Override
		public int compare(Pessoa o1, Pessoa o2) {
			// TODO Auto-generated method stub
			return o1.getNome().compareTo(o2.getNome());
		}
	}
	
	class PessoasCidade implements Comparator<Pessoa> {

		@Override
		public int compare(Pessoa o1, Pessoa o2) {
			// TODO Auto-generated method stub
			return o1.getCidade().compareTo(o2.getCidade());
		}	
	
	}
	
}

// Outra classe no mesmo arquivo

class PessoaNomeDesc implements Comparator<Pessoa> {

	@Override
	public int compare(Pessoa o1, Pessoa o2) {
		// TODO Auto-generated method stub
		return o1.getNome().compareTo(o2.getNome()) * -1;
	}
}