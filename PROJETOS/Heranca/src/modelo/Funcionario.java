package modelo;

import java.util.GregorianCalendar;

import utilitarios.LtpLib;

public class Funcionario extends PessoaFisica {
	private String caProf;
	private GregorianCalendar admissao;
	private double salario;
	public Funcionario(String nome, String telefone, String cpf,
			String identidade, String sexo, String caProf,
			GregorianCalendar admissao, double salario) {
		super(nome, telefone, cpf, identidade, sexo);
		this.caProf = caProf;
		this.admissao = admissao;
		this.salario = salario;
	}
	public String getCaProf() {
		return caProf;
	}
	public void setCaProf(String caProf) {
		this.caProf = caProf;
	}
	public GregorianCalendar getAdmissao() {
		return admissao;
	}
	public void setAdmissao(GregorianCalendar admissao) {
		this.admissao = admissao;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String toString() {
		return
			super.toString() +
			"Cart. Prof. : " + caProf + "\n" +
			"Admissão    : " + LtpLib.formatarData(admissao, "dd/MM/yyyy") + "\n" +
			"Salário     : " + LtpLib.formatarValor(salario, "R$##,##0.00") + "\n";
	}
}



