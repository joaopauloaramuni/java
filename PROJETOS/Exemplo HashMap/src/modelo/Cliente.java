package modelo;

import java.io.Serializable;

import utilitarios.LtpLib;

public class Cliente implements Comparable<Cliente>, Serializable{
	private String cpf;
	private String nome;
	private String email;
	private String telefone;
	

	public Cliente(String cpf, String nome, String email, String telefone) {
		this.cpf = cpf;
		this.email = email;
		this.nome = nome;
		this.telefone = telefone;
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
	public String toString() {
		return
			"CPF     : " + LtpLib.formatarCPF(cpf) + "\n" +
			"NOME    : " + nome + "\n" +
			"Email   : " + email + "\n" +
			"Telefone: " + telefone + "\n";
	}
	@Override
	public int compareTo(Cliente obj) {
		return nome.compareTo(obj.nome);
	}
}
