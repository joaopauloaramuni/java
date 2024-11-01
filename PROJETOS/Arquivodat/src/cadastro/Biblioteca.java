package cadastro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;

import cadastro.BibException;
import dados.Livro;

@SuppressWarnings("serial")
public class Biblioteca implements Serializable {

	public static ArrayList<Livro> livros = new ArrayList<Livro>();

	public static ArrayList<Livro> getLivros() {
		return livros;
	}

	public static void setLivros(ArrayList<Livro> livros) {
		Biblioteca.livros = livros;
	}

	public static void incluirLivro(Livro objLivro) throws BibException {
		for (Livro obj : livros) {
			if (obj.getTitulo().equalsIgnoreCase(objLivro.getTitulo())) {
				throw new BibException("Livro já esta cadastrado!!");
			}

		}
		livros.add(objLivro);

	}

	public static Livro consultarLivro(int codigo) throws BibException {
		for (Livro obj : livros) {
			if (obj.getCodigo() == codigo) {
				return obj;

			}

		}
		throw new BibException("Livro não encontrado!");
	}
	
	public static Livro consultarTitulo(String titulo) throws BibException {
		for (Livro obj : livros) {
			if (obj.getTitulo() == titulo) {
				return obj;

			}

		}
		throw new BibException("Livro não encontrado!");
	}

	public static Livro consultarData(GregorianCalendar data) throws BibException {
		for (Livro obj : livros) {
			if (obj.getData() == data) {
				return obj;

			}

		}
		throw new BibException("Livro não encontrado!");
	}
	
	/**
	 * 
	 * @param objLivro
	 * @throws BibException
	 */
	public static void excluirLivro(Livro objLivro) throws BibException {
		livros.remove(objLivro);
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Livro> listaOrdem(String titulo)
			throws BibException {

		ArrayList<Livro> resposta = (ArrayList<Livro>) livros.clone();

		Collections.sort(resposta, new Comparator<Livro>() {

			public int compare(Livro o1, Livro o2) {
				return o1.getTitulo().compareTo(o2.getTitulo());
			}
		});
		if (!resposta.isEmpty()) {
			return resposta;
		}
		throw new BibException("Lista Nao Existente!");
	}

	public static ArrayList<Livro> listaOrdem() throws BibException {

		@SuppressWarnings("unchecked")
		ArrayList<Livro> resposta = (ArrayList<Livro>) livros.clone();

		Collections.sort(resposta, new Comparator<Livro>() {

			public int compare(Livro o1, Livro o2) {
				int chavePrincipal = o1.getTitulo().compareTo(o2.getTitulo());
				if (chavePrincipal != 0)
					return chavePrincipal;
				if (o1.getData().compareTo(o2.getData()) == 1)
					return -1;
				else if (o1.getData().compareTo(o2.getData()) == 0)
					return 0;
				else
					return 1;
			}
		});

		if (!resposta.isEmpty()) {
			return resposta;
		}
		throw new BibException("Não existe para o período informado!");
	}

}
