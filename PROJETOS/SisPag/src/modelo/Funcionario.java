package modelo;

import java.io.Serializable;

import utilitarios.LtpLib;

public abstract class Funcionario implements Comparable<Funcionario> , Serializable{
    public static final int MENSALISTA = 1;
    public static final int HORARISTA = 2;
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
    /**
     * Obter tipo 
     * @return tipo
     */
	public abstract int getTipo();
	/**
	 *  Obter salario mensal
	 * @param mes
	 * @param ano
	 * @return salario mensal
	 */
    public abstract double obterSalarioMensal(int mes, int ano);
    public String toString() {
    	return
    		"CPF   : " + LtpLib.formatarCPF(cpf) + "\n" +
    		"Nome : " + nome + "\n";
    }
	@Override
	public int compareTo(Funcionario o) {
		return nome.compareTo(o.getNome());
	}

}
