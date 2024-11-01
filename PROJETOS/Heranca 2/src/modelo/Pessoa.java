package modelo;

import java.util.GregorianCalendar;

import utilitarios.LtpLib;

public class Pessoa implements Comparable<Pessoa>{
	private String nome;
	private String telefone;
	private GregorianCalendar data;
	public Pessoa(String nome, String telefone) {
		this.nome = nome;
		this.telefone = telefone;
		data = new GregorianCalendar();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public GregorianCalendar getData() {
		return data;
	}
	public void setData(GregorianCalendar data) {
		this.data = data;
	}
	public String toString(){
		return
			"Nome : " + nome + "\n" +
			"Telefone : " + telefone + "\n" +
			"Data : " + LtpLib.formatarData(data, "dd/MM/yyyy") + "\n";
	}
	@Override
	public int compareTo(Pessoa o) {
		return nome.compareTo(o.nome);
	}


}



