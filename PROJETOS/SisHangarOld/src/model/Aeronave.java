package model;

import java.util.Date;

/**
 * 
 */
public abstract class Aeronave {

	// Atributos
	private String idAeronave;
	private String chassi;
	private String marca;
	private String modelo;
	private int anoModelo;
	private int anoFabricacao;
	private Date dataEntrada;
	private Date dataSaida;

	//Método abstrato
	public abstract void informarSaidaAeronave();
	
	public String getIdAeronave() {
		return idAeronave;
	}

	public void setIdAeronave(String idAeronave) {
		this.idAeronave = idAeronave;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	@Override
	public String toString() {
		return "Aeronave [idAeronave=" + idAeronave + ", chassi=" + chassi + ", marca=" + marca + ", modelo=" + modelo
				+ ", anoModelo=" + anoModelo + ", anoFabricacao=" + anoFabricacao + ", dataEntrada=" + dataEntrada
				+ ", dataSaida=" + dataSaida + "]";
	}

}
