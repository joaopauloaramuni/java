package dados;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Livro implements Serializable {

	private int codigo;
	private String titulo;
	private String autor;
	private String editora;
	private int ano;
	private GregorianCalendar data;

	public Livro(int codigo, String titulo, String autor, String editora,
			int ano, GregorianCalendar data) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.ano = ano;
		this.data = data;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public GregorianCalendar getData() {
		return data;
	}

	public void setData(GregorianCalendar data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Codigo: " + codigo + "Titulo: " + titulo + "Autor: " + autor
				+ "Editora: " + editora + "Ano: " + ano + "Data: " + data;
	}

	public boolean igual(Livro objLivro) {

		if (objLivro.getTitulo().equals(this.titulo)
				&& objLivro.getAutor().equals(this.autor)
				&& objLivro.getEditora().equals(this.editora)
				&& objLivro.getAno() == this.ano) {
			return true;
		}
		return false;
	}

}
