package modelo;

import utilitarios.LtpLib;

public class PessoaJuridica extends Pessoa {
	private String cnpj;
	private String razaoSocial;
	public PessoaJuridica(String nome, String telefone, String cnpj,
			String razaoSocial) {
		super(nome, telefone);
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String toString() {
		return
			super.toString() +
			"CNPJ : " + LtpLib.formatarCNPJ(cnpj) + "\n" +
			"R.Social : " + razaoSocial + "\n";
	}
}



