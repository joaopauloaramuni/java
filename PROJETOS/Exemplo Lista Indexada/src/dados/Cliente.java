package dados;

import java.util.GregorianCalendar;

public class Cliente {
	private String cpf;
	private String nome;
	private String email;
	private String telefone;
	private GregorianCalendar nascimento;
	public Cliente(String cpf, String nome, String email, String telefone,
			GregorianCalendar nascimento) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.nascimento = nascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public GregorianCalendar getNascimento() {
		return nascimento;
	}
	public void setNascimento(GregorianCalendar nascimento) {
		this.nascimento = nascimento;
	}
	
}
