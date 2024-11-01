package modelo;

import java.util.GregorianCalendar;

public class Gerente extends Funcionario {
	
	private Funcionario secretaria;

	public Gerente(String nome, String telefone, int tipo, String cpf,
			String identidade, String sexo, String cTrab,
			GregorianCalendar admissao, double salario, Funcionario secretaria) {
		super(nome, telefone, tipo, cpf, identidade, sexo, cTrab, admissao,
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
		return super.toString() + "Secretária: " + (secretaria == null ? "" : secretaria.getNome()) + "\n";
	}
}
