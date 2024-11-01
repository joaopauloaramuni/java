package modelo;

import java.util.GregorianCalendar;

import utilitarios.LtpLib;

public class Funcionario extends PessoaFisica {

	private String cTrab;
	private GregorianCalendar admissao;
	private double salario;

	public Funcionario(String nome, String telefone, int tipo, String cpf,
			String identidade, String sexo, String cTrab,
			GregorianCalendar admissao, double salario) {
		super(nome, telefone, tipo, cpf, identidade, sexo);
		this.cTrab = cTrab;
		this.admissao = admissao;
		this.salario = salario;
	}

	public String getcTrab() {
		return cTrab;
	}

	public void setcTrab(String cTrab) {
		this.cTrab = cTrab;
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
		return super.toString() + "C.Trab.: " + "cTrab" + "\n" + "Admissão: " + LtpLib.formatarData(admissao, "dd/MM/yyyy") + 
		"\n" + "Salário: " + LtpLib.formatarValor(salario, "R$#,##0.00") + "\n";
	}
}
