package model;

public class Cliente extends Pessoa{

	private double valorDivida;
	private int anoNascim;

	public Cliente() {
	}

	public Cliente(double valorDivida, int anoNascim) {
		super();
		this.valorDivida = valorDivida;
		this.anoNascim = anoNascim;
	}

	public double getValorDivida() {
		return valorDivida;
	}

	public void setValorDivida(double valorDivida) {
		this.valorDivida = valorDivida;
	}

	public int getAnoNascim() {
		return anoNascim;
	}

	public void setAnoNascim(int anoNascim) {
		this.anoNascim = anoNascim;
	}

	@Override
	public String toString() {
		return "Cliente [valorDivida=" + valorDivida + ", anoNascim=" + anoNascim + "]";
	}
	

}
