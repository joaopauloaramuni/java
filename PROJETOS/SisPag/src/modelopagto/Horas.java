package modelopagto;

import java.io.Serializable;
import java.util.GregorianCalendar;

import utilitarios.LtpLib;

public class Horas implements Serializable, Comparable<Horas> {

	private static final long serialVersionUID = 1L;
	
	private GregorianCalendar dataTrab;
	private double qteHoras;
	
	public Horas(GregorianCalendar dataTrab, double qteHoras) {
		this.dataTrab = dataTrab;
		this.qteHoras = qteHoras;
	}
	
	public GregorianCalendar getDataTrab() {
		return dataTrab;
	}
	public void setDataTrab(GregorianCalendar dataTrab) {
		this.dataTrab = dataTrab;
	}
	public double getQteHoras() {
		return qteHoras;
	}
	public void setQteHoras(double qteHoras) {
		this.qteHoras = qteHoras;
	}
	
	public String toString() {
		return
			"Data      : " + LtpLib.formatarData(dataTrab, "dd/MM/yyyy") + "\n" +
			"Qde.Horas : " + LtpLib.formatarValor(qteHoras, "#0.0") + "\n";
	}

	@Override
	public int compareTo(Horas o) {
		// TODO Auto-generated method stub
		return dataTrab.compareTo(o.getDataTrab());
	}
}





