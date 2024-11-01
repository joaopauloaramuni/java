package modelo;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Vector;

import utilitarios.LtpLib;

public class Horista extends Funcionario implements Serializable {
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

	public String toString() {
		return
		     "Tipo Horista " + "\n" + 
		     super.toString() +
		     "Valor Hora : " + LtpLib.formatarValor(valorHora, "R$##0.00") + "\n";
	}
	
	@Override
	public int getTipo() {
		return Funcionario.HORARISTA;
	}

	@Override
	public double obterSalarioMensal(int mes, int ano) {
        double totHoras  = 0;
        for (Horas obj : listaHoras) {
        	if (obj.getDataTrab().get(GregorianCalendar.MONTH)==mes-1 &&
        		obj.getDataTrab().get(GregorianCalendar.YEAR)==ano) {
        		totHoras += obj.getHoras();
        	}
        }
		return valorHora * totHoras;
	}
	/**
	 * Incluir horas de Trabalho
	 * @param objHoras
	 * @throws Exception "Já existe lançamento de horas para a data informada."
	 */
    public void incluirHoras(Horas objHoras) throws Exception {
    	for (Horas obj : listaHoras ) {
    		if (obj.getDataTrab().equals(objHoras.getDataTrab())) {
    			throw new Exception("Já existe lançamento de horas para a data informada.");
    		}
    	}
    	listaHoras.add(objHoras);
    }
    /**
     * Exluir hoas de trabalho
     * @param dataTrab
     * @throws Exception "Não existe lançamento para a data informada."
     */
    public void excluirHoras(GregorianCalendar dataTrab) throws Exception {
    	for (Horas obj : listaHoras ) {
    		if (obj.getDataTrab().equals(dataTrab)) {
    			listaHoras.remove(obj);
    			return;
    		}
    	}
    	throw new Exception("Não existe lançamento para a data informada.");
    }
}





