package modelo;

public class Pessoa {
	// Constantes
	public static final int PESSOA = 1;
	public static final int PESSOA_FISICA = 2;
	public static final int PESSOA_JURIDICA = 3;
	public static final int FUNCIONARIO = 4;
	public static final int GERENTE = 5;
	//
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
	public int getTipo() {
		return PESSOA;
	}
}
