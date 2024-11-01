package dados;

import utilitarios.LtpLib;

public class Cliente implements Comparable<Cliente>{
	
	private int codigo;
	private double limCredito;
	private String nome;
	private String cidade;
	private String telefone;
	
	public Cliente(int codigo, String nome, String cidade, String telefone,double limCredito) {
		this.codigo = codigo;
		this.nome = nome;
		this.cidade = cidade;
		this.telefone = telefone;
		this.limCredito = limCredito;
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
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public double getLimCredito() {
		return limCredito;
	}
	public void setLimCredito(double limCredito) {
		this.limCredito = limCredito;
	}
	public String toString() {
		return
			"Codigo: " + codigo + "\n" +
			"Nome: " + nome + "\n" +
			"Cidade: " + cidade + "\n" +
			"Telefone: " + telefone + "\n" +
			"Limite Crédito: " + LtpLib.formatarValor(limCredito, "R$##,##0.00") + "\n";
	}
	@Override
	public int compareTo(Cliente o) {
		// TODO Auto-generated method stub
		return nome.compareTo(o.getNome());
	}

}
