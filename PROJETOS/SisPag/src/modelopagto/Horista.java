package modelopagto;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Vector;

import utilitarios.LtpLib;

public class Horista extends Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	private double valorHora;
	private Vector<Horas> listaHoras = new Vector<Horas>();
	
	
	public Horista(String cpf, String nome, double valorHora) {
		super(cpf, nome);
		this.valorHora = valorHora;
	}

	
	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public Vector<Horas> getListaHoras() {
		return listaHoras;
	}

	@Override
	public int getTipo() {
		// TODO Auto-generated method stub
		return Funcionario.HORISTA;
	}

	@Override
	public double obterSalarioMensal(int mes, int ano) {
		double totHoras = 0;
		for (Horas objHoras : listaHoras) {
			if (objHoras.getDataTrab().get(GregorianCalendar.YEAR)==ano 
				&& objHoras.getDataTrab().get(GregorianCalendar.MONTH)== (mes - 1)){
				totHoras += objHoras.getQteHoras();
			}
		}
		return valorHora * totHoras;
	}
	
	public void addHoras (Horas objHoras) throws PagtoException {
		for (Horas objHorasLista : listaHoras) {
			if (objHorasLista.getDataTrab().equals(objHoras.getDataTrab())){
				throw new PagtoException("Já existe registro de hora trabalhada para a data informada.");
			}
		}
		listaHoras.add(objHoras);
	}
	
	public String toString() {
		return
		  super.toString() +
		  "Valor Hora : " + LtpLib.formatarValor(valorHora, "#0.00") + "\n";
	}

}







