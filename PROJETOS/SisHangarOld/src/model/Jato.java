package model;

import java.util.Date;

public class Jato extends Aeronave {

	private String cpfComandante;
	private String cpfCopiloto;
	private String nomeEmpresa;
	private Double valorAluguel;
	private boolean jatoNoHangar;

	public Jato() {
	}

	public String getCpfComandante() {
		return cpfComandante;
	}

	public void setCpfComandante(String cpfComandante) {
		this.cpfComandante = cpfComandante;
	}

	public String getCpfCopiloto() {
		return cpfCopiloto;
	}

	public void setCpfCopiloto(String cpfCopiloto) {
		this.cpfCopiloto = cpfCopiloto;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public Double getValorAluguel() {
		return valorAluguel;
	}

	public void setValorAluguel(Double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}

	public boolean isJatoNoHangar() {
		return jatoNoHangar;
	}

	public void setJatoNoHangar(boolean jatoNoHangar) {
		this.jatoNoHangar = jatoNoHangar;
	}

	@Override
	public String toString() {
		return super.toString() + "Jato [cpfComandante=" + cpfComandante + ", cpfCopiloto=" + cpfCopiloto
				+ ", nomeEmpresa=" + nomeEmpresa + ", valorAluguel=" + valorAluguel + ", jatoNoHangar=" + jatoNoHangar
				+ "]";
	}

	@Override
	public void informarSaidaAeronave() {
		super.setDataSaida(new Date());
		setJatoNoHangar(false);
		// System.out.println("Jato fora do Hangar.");

	}

}
