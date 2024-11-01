package model;

public class Empregado extends Pessoa {

	private double salario;
	private String matricula;

	public Empregado() {
	}

	public Empregado(double salario, String matricula) {
		super();
		this.salario = salario;
		this.matricula = matricula;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Empregado [salario=" + salario + ", matricula=" + matricula + "]";
	}

	
}
