package modelo;

import java.util.GregorianCalendar;

public class Gerente extends Funcionario {
	private Funcionario secretaria;

	public Gerente(String nome, String telefone, String sexo,
			String identidade, String cpf, String cartProf,
			GregorianCalendar admissao, double salario, Funcionario secretaria) {
		super(nome, telefone, sexo, identidade, cpf, cartProf, admissao,
				salario);
		this.secretaria = secretaria;
	}

	public Funcionario getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(Funcionario secretaria) {
		this.secretaria = secretaria;
	}
	public String toString() {
		return 
			super.toString() +
			"Secretária : " + secretaria.getNome() + "\n";
	}
	public int getTipo() {
		return GERENTE;
	}
}
