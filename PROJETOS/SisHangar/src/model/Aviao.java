package model;

import java.util.Date;

public class Aviao extends Aeronave {

	private String cpfPiloto;
	private String telefonePiloto;
	private String brevePiloto;
	private String linhaAerea;
	private int horasVoo;
	private boolean aviaoNoHangar;

	public Aviao() {}
	
	public String getCpfPiloto() {
		return cpfPiloto;
	}

	public void setCpfPiloto(String cpfPiloto) {
		this.cpfPiloto = cpfPiloto;
	}

	public String getTelefonePiloto() {
		return telefonePiloto;
	}

	public void setTelefonePiloto(String telefonePiloto) {
		this.telefonePiloto = telefonePiloto;
	}

	public String getBrevePiloto() {
		return brevePiloto;
	}

	public void setBrevePiloto(String brevePiloto) {
		this.brevePiloto = brevePiloto;
	}

	public String getLinhaAerea() {
		return linhaAerea;
	}

	public void setLinhaAerea(String linhaAerea) {
		this.linhaAerea = linhaAerea;
	}

	public int getHorasVoo() {
		return horasVoo;
	}

	public void setHorasVoo(int horasVoo) {
		this.horasVoo = horasVoo;
	}

	public boolean isAviaoNoHangar() {
		return aviaoNoHangar;
	}

	public void setAviaoNoHangar(boolean aviaoNoHangar) {
		this.aviaoNoHangar = aviaoNoHangar;
	}

	@Override
	public String toString() {
		return super.toString() + "Aviao [cpfPiloto=" + cpfPiloto + ", telefonePiloto=" + telefonePiloto
				+ ", brevePiloto=" + brevePiloto + ", linhaAerea=" + linhaAerea + ", horasVoo=" + horasVoo
				+ ", aviaoNoHangar=" + aviaoNoHangar + "]";
	}

	@Override
	public void informarSaidaAeronave() {
		super.setDataSaida(new Date());
		setAviaoNoHangar(false);
		//System.out.println("Aviao fora do Hangar.");
	}

}
