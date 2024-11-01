package clientesmodelo;

import java.io.Serializable;
import java.util.GregorianCalendar;

import utilitarios.LtpLib;

public class Cliente implements Serializable{
	// Atributos
	private int codigo;
	private String nome;
	private String telefone;
	private GregorianCalendar nascimento;
	private String email;
	public Cliente(int codigo, String nome, String telefone,
			GregorianCalendar nascimento, String email) {
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.nascimento = nascimento;
		this.email = email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String toString() {
		return
			"Código     : " + codigo + "\n" +
			"Nome       : " + nome + "\n" +
			"Telefone   : " + telefone + "\n" +
			"Nascimento : " + (nascimento==null ? "" : LtpLib.formatarData(nascimento, "dd/MM/yyyy")) + "\n" +
			"Email      : " + email + "\n";
	}
	public Cliente clone() {
		return new Cliente(codigo,nome,telefone,nascimento,email);
	}
	public boolean equals(Cliente objCliente) {
		return nome.equalsIgnoreCase(objCliente.getNome())&&
			   telefone.equals(objCliente.telefone) &&
			   email.equals(objCliente.email) &&
			   nascimento.equals(objCliente.nascimento); 
	}
	
}






