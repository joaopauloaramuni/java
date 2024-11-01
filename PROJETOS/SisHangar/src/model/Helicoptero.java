package model;

import java.util.Date;

public class Helicoptero extends Aeronave {

	private String cpfPilotoPrivado;
	private String tipoCombustivel;
	private String qtdAssentos;
	private int velocidadeMax;
	private boolean helicopteroNoHangar;

	public Helicoptero() {}
	
	public String getCpfPilotoPrivado() {
		return cpfPilotoPrivado;
	}

	public void setCpfPilotoPrivado(String cpfPilotoPrivado) {
		this.cpfPilotoPrivado = cpfPilotoPrivado;
	}

	public String getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public String getQtdAssentos() {
		return qtdAssentos;
	}

	public void setQtdAssentos(String qtdAssentos) {
		this.qtdAssentos = qtdAssentos;
	}

	public int getVelocidadeMax() {
		return velocidadeMax;
	}

	public void setVelocidadeMax(int velocidadeMax) {
		this.velocidadeMax = velocidadeMax;
	}

	public boolean isHelicopteroNoHangar() {
		return helicopteroNoHangar;
	}

	public void setHelicopteroNoHangar(boolean helicopteroNoHangar) {
		this.helicopteroNoHangar = helicopteroNoHangar;
	}

	@Override
	public String toString() {
		return super.toString() + "Helicoptero [cpfPilotoPrivado=" + cpfPilotoPrivado + ", tipoCombustivel="
				+ tipoCombustivel + ", qtdAssentos=" + qtdAssentos + ", velocidadeMax=" + velocidadeMax
				+ ", helicopteroNoHangar=" + helicopteroNoHangar + "]";
	}

	@Override
	public void informarSaidaAeronave() {
		super.setDataSaida(new Date());
		setHelicopteroNoHangar(false);
		//System.out.println("Helicoptero fora do Hangar.");
	}

}
