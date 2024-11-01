package model;

import java.io.Serializable;
import java.util.Date;

public abstract class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	public abstract void informarSaidaVeiculo();

	private String placa;
	private String chassi;
	private String marca;
	private String modelo;
	private int anoModelo;
	private int anoFabricacao;
	private Date dataEntrada;
	private Date dataSaida;

	public Veiculo(String placa, String chassi, String marca, String modelo,
			int anoModelo, int anoFabricacao, Date dataEntrada) {
		super();
		this.placa = placa;
		this.chassi = chassi;
		this.marca = marca;
		this.modelo = modelo;
		this.anoModelo = anoModelo;
		this.anoFabricacao = anoFabricacao;
		this.dataEntrada = dataEntrada;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
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
		return "Veiculo [placa=" + placa + ", chassi=" + chassi + ", marca="
				+ marca + ", modelo=" + modelo + ", anoModelo=" + anoModelo
				+ ", anoFabricacao=" + anoFabricacao + ", dataEntrada="
				+ dataEntrada + ", dataSaida="
				+ (dataSaida == null ? "" : dataSaida) + "]";
	}

}
