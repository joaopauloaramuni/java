package modelo;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Vector;

import utilitarios.LtpLib;

public class Mensalista extends Funcionario implements Serializable {
	private double salario;
	private Vector<Faltas> listaFaltas = new Vector<Faltas>();
	
	public Mensalista(String cpf, String nome, double salario) {
		super(cpf, nome);
		this.salario = salario;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Vector<Faltas> getListaFaltas() {
		return listaFaltas;
	}
    public String toString() {
    	return
    		"Tipo Mensalista" + "\n" +
    	    super.toString() +
    		"Salário Mensal : " + LtpLib.formatarValor(salario, "R$##,##0.00") + "\n";
    }
	@Override
	public int getTipo() {
		// TODO Auto-generated method stub
		return Funcionario.MENSALISTA;
	}

	@Override
	public double obterSalarioMensal(int mes, int ano) {
		int totFaltas = 0;
		for (Faltas obj : listaFaltas) {
			if (obj.getDataFalta().get(GregorianCalendar.MONTH)==mes &&
				obj.getDataFalta().get(GregorianCalendar.YEAR)==ano	) {
				totFaltas++;
			}
		}
		return salario - (salario / 30 * totFaltas);
	}
	public void incluirFalta(Faltas objFalta) throws Exception {
		for (Faltas obj : listaFaltas) {
			if (obj.getDataFalta().equals(objFalta.getDataFalta())) {
				throw new Exception("Já existe falta lançada para a data informada.");
			}
		}
		listaFaltas.add(objFalta);
	}
	public void excluirFalta(GregorianCalendar dataFalta) throws Exception {
		for (Faltas obj : listaFaltas) {
			if (obj.getDataFalta().equals(dataFalta)) {
				listaFaltas.remove(obj);
				return;
			}
		}
		throw new Exception("Não existe falta para a data informada.");
	}
	
}





