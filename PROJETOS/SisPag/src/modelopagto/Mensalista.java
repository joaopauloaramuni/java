package modelopagto;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Vector;

import utilitarios.LtpLib;

public class Mensalista extends Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Atributos
	private double salarioMensal;
	private Vector<Faltas> listaFaltas = new Vector<Faltas>();
	
	
	
	public Mensalista(String cpf, String nome, double salarioMensal) {
		super(cpf, nome);
		this.salarioMensal = salarioMensal;
	}

	
	public double getSalarioMensal() {
		return salarioMensal;
	}


	public void setSalarioMensal(double salarioMensal) {
		this.salarioMensal = salarioMensal;
	}

	public Vector<Faltas> getListaFaltas() {
		return listaFaltas;
	}

	@Override
	public int getTipo() {
		// TODO Auto-generated method stub
		return Funcionario.MENSALISTA;
	}

	@Override
	public double obterSalarioMensal(int mes, int ano) {
		int totFaltas = 0;
		for (Faltas objFalta : listaFaltas) {
			if (objFalta.getDataFalta().get(GregorianCalendar.YEAR) == ano &&
				objFalta.getDataFalta().get(GregorianCalendar.MONTH) == (mes - 1) ) {
				totFaltas++;
			}
		}
		return salarioMensal - ( totFaltas*salarioMensal/30);
	}
	
	/**
	 * Registrar falta do mensalista
	 * @param objFalta
	 * @throws PagtoException - Já existe registro de falta para a data.
	 */
	public void addFalta(Faltas objFalta) throws PagtoException {
		for (Faltas registroFalta : listaFaltas) {
			if (registroFalta.getDataFalta().equals(objFalta.getDataFalta())){
				throw new PagtoException("Já existe registro de falta para a data.");
			}
		}
		listaFaltas.add(objFalta);
		
	}
	public String toString() {
		return
			super.toString() +
			"Salario Mensal : " + LtpLib.formatarValor(salarioMensal, "R$#,##0.00") + "\n";
	}

}









