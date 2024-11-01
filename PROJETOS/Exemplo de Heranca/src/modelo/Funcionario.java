package modelo;

import java.util.GregorianCalendar;

import utilitarios.LtpLib;

public class Funcionario extends PessoaFisica {
	private String cartProf;
	private GregorianCalendar admissao;
	private double salario;
	public Funcionario(String nome, String telefone, String sexo,
			String identidade, String cpf, String cartProf,
			GregorianCalendar admissao, double salario) {
		super(nome, telefone, sexo, identidade, cpf);
		this.cartProf = cartProf;
		this.admissao = admissao;
		this.salario = salario;
	}
	public String getCartProf() {
		return cartProf;
	}
	public void setCartProf(String cartProf) {
		this.cartProf = cartProf;
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
			"Cart. Prof. : " + cartProf + "\n" +
			"Admiss�o : " + LtpLib.formatarData(admissao, "dd/MM/yyyy") + "\n" +
			"Sal�rio : " + LtpLib.formatarValor(salario, "R$ ###,##0.00") + "\n";
	}
	public int getTipo() {
		return FUNCIONARIO;
	}
	
}
