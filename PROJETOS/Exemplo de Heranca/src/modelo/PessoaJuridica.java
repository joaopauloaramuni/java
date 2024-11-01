package modelo;

import utilitarios.LtpLib;

public class PessoaJuridica extends Pessoa {
	private String cnpj;
	private String razSocial;
	public PessoaJuridica(String nome, String telefone, String cnpj,
			String razSocial) {
		super(nome, telefone);
		this.cnpj = cnpj;
		this.razSocial = razSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazSocial() {
		return razSocial;
	}
	public void setRazSocial(String razSocial) {
		this.razSocial = razSocial;
	}
	public String toString() {
		return 
			super.toString() + 
			"CNPJ : " + LtpLib.formatarCNPJ(cnpj) + "\n" +
			"Raz. Social : " + razSocial + "\n";
	}
	public int getTipo() {
		return PESSOA_JURIDICA;
	}
	
}
