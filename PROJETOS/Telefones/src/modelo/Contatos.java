package modelo;

public class Contatos {
	private String telefone;
	private String nome;
	public Contatos(String telefone, String nome) {
		this.telefone = telefone;
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
