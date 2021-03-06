package modelopagto;

import java.io.Serializable;
import java.util.GregorianCalendar;

import utilitarios.LtpLib;

public class Faltas implements Serializable{

	private static final long serialVersionUID = 1L;
	// Atributos
	private GregorianCalendar dataFalta;
	private String motivo;
	
	public Faltas(GregorianCalendar dataFalta, String motivo) {
		this.dataFalta = dataFalta;
		this.motivo = motivo;
	}

	public GregorianCalendar getDataFalta() {
		return dataFalta;
	}

	public void setDataFalta(GregorianCalendar dataFalta) {
		this.dataFalta = dataFalta;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	public String toString() {
		return
			"Data   : " + LtpLib.formatarData(dataFalta, "dd/MM/yyyy") + "\n" +
			"Motivo : " + motivo + "\n";
	}
	
}










