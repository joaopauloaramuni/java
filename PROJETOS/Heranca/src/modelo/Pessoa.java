package modelo;

public class Pessoa {
	private String nome;
	private String telefone;
	public Pessoa(String nome, String telefone) {
		this.nome = nome;
		this.telefone = telefone;
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
	public String toString() {
		return 
			"Nome : " + nome + "\n" +
			"Telefone : " + telefone + "\n";
	}
}
