package modelo;

import utilitarios.LtpLib;

public class PessoaFisica extends Pessoa {
	private String sexo;
	private String identidade;
	private String cpf;
	public PessoaFisica(String nome, String telefone, String sexo,
			String identidade, String cpf) {
		super(nome, telefone);
		this.sexo = sexo;
		this.identidade = identidade;
		this.cpf = cpf;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getIdentidade() {
		return identidade;
	}
	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String toString() {
		return 
			super.toString() + 
			"Sexo : " + sexo + "\n" +
			"Identidade : " + identidade + "\n" +
			"CPF : " + LtpLib.formatarCPF(cpf) + "\n";
	}
	public int getTipo() {
		return PESSOA_FISICA;
	}
}
