package model;

import java.util.Date;

public class Carro extends Veiculo {

	private static final long serialVersionUID = 1L;

	private String cpfDono;
	private String telefoneDono;
	private String quilometragem;
	private int cavalos;
	private boolean carroNaOficina;

	public Carro(String cpfDono, String telefoneDono, String quilometragem,
			int cavalos, boolean carroNaOficina, String placa, String chassi,
			String marca, String modelo, int anoModelo, int anoFabricacao,
			Date dataEntrada) {
		super(placa, chassi, marca, modelo, anoModelo, anoFabricacao,
				dataEntrada);
		this.cpfDono = cpfDono;
		this.telefoneDono = telefoneDono;
		this.quilometragem = quilometragem;
		this.cavalos = cavalos;
		this.carroNaOficina = carroNaOficina;

	}

	public String getCpfDono() {
		return cpfDono;
	}

	public void setCpfDono(String cpfDono) {
		this.cpfDono = cpfDono;
	}

	public String getTelefoneDono() {
		return telefoneDono;
	}

	public void setTelefoneDono(String telefoneDono) {
		this.telefoneDono = telefoneDono;
	}

	public String getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(String quilometragem) {
		this.quilometragem = quilometragem;
	}

	public int getCavalos() {
		return cavalos;
	}

	public void setCavalos(int cavalos) {
		this.cavalos = cavalos;
	}

	public boolean isCarroNaOficina() {
		return carroNaOficina;
	}

	public void setCarroNaOficina(boolean carroNaOficina) {
		this.carroNaOficina = carroNaOficina;
	}



	@Override
	public String toString() {
		return super.toString() + "Carro [cpfDono=" + cpfDono + ", telefoneDono=" + telefoneDono
				+ ", quilometragem=" + quilometragem + ", cavalos=" + cavalos
				+ ", carroNaOficina=" + carroNaOficina + "]";
	}

	@Override
	public void informarSaidaVeiculo() {
		super.setDataSaida(new Date());
		setCarroNaOficina(false);
		System.out.println("Carro fora da oficina.");
	}

}
