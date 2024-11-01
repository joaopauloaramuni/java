package modelo;

import java.io.Serializable;
import java.util.GregorianCalendar;

import utilitarios.LtpLib;

public class Divida implements Serializable{
	
	private Estabelecimento empresa;
	private String codDividaEmpresa;
	private GregorianCalendar vencimento;
	private double valor;
	private GregorianCalendar dataRegistro;
	
	public Divida(Estabelecimento empresa, String codDividaEmpresa,
			GregorianCalendar vencimento, double valor,
			GregorianCalendar dataRegistro) {
		this.empresa = empresa;
		this.codDividaEmpresa = codDividaEmpresa;
		this.vencimento = vencimento;
		this.valor = valor;
		this.dataRegistro = dataRegistro;
	}
	
	public Estabelecimento getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Estabelecimento empresa) {
		this.empresa = empresa;
	}
	public String getCodDividaEmpresa() {
		return codDividaEmpresa;
	}
	public void setCodDividaEmpresa(String codDividaEmpresa) {
		this.codDividaEmpresa = codDividaEmpresa;
	}
	public GregorianCalendar getVencimento() {
		return vencimento;
	}
	public void setVencimento(GregorianCalendar vencimento) {
		this.vencimento = vencimento;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public GregorianCalendar getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(GregorianCalendar dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	public String toString() {
		return 
			"Empresa : " + empresa.getNomeEmpresa() + "\n" +
			"Código  : " + codDividaEmpresa + "\n" +
			"Vencimento : " + LtpLib.formatarData(vencimento, "dd/MM/yyyy") + "\n" +
			"Valor : " + LtpLib.formatarValor(valor, "R$##,##0.00") + "\n" +
			"Data Registro : " + LtpLib.formatarData(dataRegistro, "dd/MM/yyyy") + "\n";
	}
}







