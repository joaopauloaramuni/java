package modelo;

import utilitarios.LtpLib;

public class PessoaFisica extends Pessoa {
	
	private String cpf;
	private String identidade;
	private String sexo;

	public PessoaFisica(String nome, String telefone, int tipo, String cpf,
			String identidade, String sexo) {
		super(nome, telefone, tipo);
		this.cpf = cpf;
		this.identidade = identidade;
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String toString() {
		return super.toString() + "CPF: " + LtpLib.formatarCPF(cpf) + "\n"
				+ "Identidade: " + identidade + "\n" + "Sexo: " + sexo + "\n";
	}

}
