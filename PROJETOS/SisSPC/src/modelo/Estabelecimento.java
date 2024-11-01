package modelo;

import java.io.Serializable;

import utilitarios.LtpLib;

public class Estabelecimento implements Serializable{
	
	private String cnpj;
	private String nomeEmpresa;
	
	public Estabelecimento(String cnpj, String nomeEmpresa) {
		this.cnpj = cnpj;
		this.nomeEmpresa = nomeEmpresa;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	public String toString() {
		return
			"CNPJ : " + LtpLib.formatarCNPJ(cnpj) + "\n" +
			"Nome : " + nomeEmpresa + "\n";
	}
}
