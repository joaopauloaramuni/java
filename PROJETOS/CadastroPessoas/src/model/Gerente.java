package model;

public class Gerente extends Pessoa{
	
	private String nomeGerencia;

	public Gerente() {
	}
	
	public Gerente(String nomeGerencia) {
		super();
		this.nomeGerencia = nomeGerencia;
	}

	public String getNomeGerencia() {
		return nomeGerencia;
	}

	public void setNomeGerencia(String nomeGerencia) {
		this.nomeGerencia = nomeGerencia;
	}

}
