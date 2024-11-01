package modelo;

import java.util.GregorianCalendar;

public class Gerente extends Funcionario {
	private Funcionario secretaria;

	public Gerente(String nome, String telefone, String cpf, String identidade,
			String sexo, String caProf, GregorianCalendar admissao,
			double salario, Funcionario secretaria) {
		super(nome, telefone, cpf, identidade, sexo, caProf, admissao, salario);
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
			super.toString() + "\n" +
			"Nome da Secretaria: " + secretaria.getNome() + "\n";
			
	}
}
