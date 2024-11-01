package modelopagto;

import java.io.Serializable;

import utilitarios.LtpLib;

public abstract class Funcionario implements Serializable, Comparable<Funcionario>{

	private static final long serialVersionUID = 1L;
	
	// Constantes
	
	public static final int HORISTA = 1;
	public static final int MENSALISTA = 2;

	// Atributos
		
	private String cpf;
	private String nome;
	
	public Funcionario(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
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
	
	public abstract int getTipo();
	
	public abstract double obterSalarioMensal(int mes,int ano);
	
	public int compareTo(Funcionario objFunc) {
		return nome.compareTo(objFunc.getNome()) ;
	}
	
	public String toString() {
		return
			"CPF  : " + LtpLib.formatarCPF(cpf) + "\n" +
			"Nome : " + nome + "\n";
	}
	
	
	
}
