package dados;

import java.util.GregorianCalendar;

public class Produto {
	private int codigo;
	private String nome;
	private double preco;
	private GregorianCalendar data;
	public Produto(int codigo, String nome, double preco, GregorianCalendar data) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.data = data;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public GregorianCalendar getData() {
		return data;
	}
	public void setData(GregorianCalendar data) {
		this.data = data;
	}
	
}
