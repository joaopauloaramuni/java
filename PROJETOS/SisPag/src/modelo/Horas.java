package modelo;

import java.io.Serializable;
import java.util.GregorianCalendar;

import utilitarios.LtpLib;

public class Horas implements Serializable {
	private GregorianCalendar dataTrab;
	private double horas;
	public Horas(GregorianCalendar dataTrab, double horas) {
		this.dataTrab = dataTrab;
		this.horas = horas;
	}
	public GregorianCalendar getDataTrab() {
		return dataTrab;
	}
	public void setDataTrab(GregorianCalendar dataTrab) {
		this.dataTrab = dataTrab;
	}
	public double getHoras() {
		return horas;
	}
	public void setHoras(double horas) {
		this.horas = horas;
	}
	public String toString() {
		return
			"Data Trab. : " + LtpLib.formatarData(dataTrab, "dd/MM/yyyy") + "\n" +
			"Qt. Horas  : " + LtpLib.formatarValor(horas, "#0.0") + "\n"; 
	}
}





