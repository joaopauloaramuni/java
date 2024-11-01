package model;

public class Vendedor extends Pessoa {

	private double valorVendas;
	private int qntVendas;

	public Vendedor() {
	}

	public Vendedor(double valorVendas, int qntVendas) {
		super();
		this.valorVendas = valorVendas;
		this.qntVendas = qntVendas;
	}

	public double getValorVendas() {
		return valorVendas;
	}

	public void setValorVendas(double valorVendas) {
		this.valorVendas = valorVendas;
	}

	public int getQntVendas() {
		return qntVendas;
	}

	public void setQntVendas(int qntVendas) {
		this.qntVendas = qntVendas;
	}

}
