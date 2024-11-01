package model;

import java.util.Date;

public class Moto extends Veiculo {

	private static final long serialVersionUID = 1L;

	private String nomeMotoboy;
	private String telefoneMotoboy;
	private String modeloCapacete;
	private int cilindradas;
	private boolean motoNaOficina;

	public Moto(String nomeMotoboy, String telefoneMotoboy,
			String modeloCapacete, int cilindradas, boolean motoNaOficina,
			String placa, String chassi, String marca, String modelo,
			int anoModelo, int anoFabricacao, Date dataEntrada) {
		super(placa, chassi, marca, modelo, anoModelo, anoFabricacao,
				dataEntrada);
		this.nomeMotoboy = nomeMotoboy;
		this.telefoneMotoboy = telefoneMotoboy;
		this.modeloCapacete = modeloCapacete;
		this.cilindradas = cilindradas;
		this.motoNaOficina = motoNaOficina;
	}

	public String getNomeMotoboy() {
		return nomeMotoboy;
	}

	public void setNomeMotoboy(String nomeMotoboy) {
		this.nomeMotoboy = nomeMotoboy;
	}

	public String getTelefoneMotoboy() {
		return telefoneMotoboy;
	}

	public void setTelefoneMotoboy(String telefoneMotoboy) {
		this.telefoneMotoboy = telefoneMotoboy;
	}

	public String getModeloCapacete() {
		return modeloCapacete;
	}

	public void setModeloCapacete(String modeloCapacete) {
		this.modeloCapacete = modeloCapacete;
	}

	public int getCilindradas() {
		return cilindradas;
	}

	public void setCilindradas(int cilindradas) {
		this.cilindradas = cilindradas;
	}

	@Override
	public String toString() {
		return super.toString() + "Moto [nomeMotoboy=" + nomeMotoboy + ", telefoneMotoboy="
				+ telefoneMotoboy + ", modeloCapacete=" + modeloCapacete
				+ ", cilindradas=" + cilindradas + ", motoNaOficina="
				+ motoNaOficina + "]";
	}

	public boolean isMotoNaOficina() {
		return motoNaOficina;
	}

	public void setMotoNaOficina(boolean motoNaOficina) {
		this.motoNaOficina = motoNaOficina;
	}

	@Override
	public void informarSaidaVeiculo() {
		super.setDataSaida(new Date());
		setMotoNaOficina(false);
		System.out.println("Moto fora da oficina.");
	}

}
