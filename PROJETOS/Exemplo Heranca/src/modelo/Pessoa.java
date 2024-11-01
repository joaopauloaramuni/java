package modelo;

public class Pessoa {
	public static final int PESSOA = 1;
	public static final int PESSOA_JURIDICA = 2;
	public static final int PESSOA_FISICA = 3;
	public static final int FUNCIONARIO = 4;
	public static final int GERENTE = 5;
	
	private String nome;
	private String telefone;
	private int tipo;

	public Pessoa(String nome, String telefone, int tipo) {
		this.nome = nome;
		this.telefone = telefone;
		this.tipo = tipo;
	}

	public int getTipo() {
		return tipo;
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
		return "Nome: " + nome + "\n" + "Telefone: " + telefone + "\n";
	}
}
