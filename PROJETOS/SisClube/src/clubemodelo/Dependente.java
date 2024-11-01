package clubemodelo;

import java.io.Serializable;
import java.util.GregorianCalendar;

import utilitarios.LtpLib;

@SuppressWarnings("serial")
public class Dependente implements Serializable{
	// Atributos
	private String nome;
	private GregorianCalendar nascimento;
	private String tipoDependencia;
	/**
	 * Construtor Dependente
	 * @param nome
	 * @param nascimento
	 * @param tipoDependencia
	 */
	public Dependente(String nome, GregorianCalendar nascimento,
			String tipoDependencia) {
		this.nome = nome;
		this.nascimento = nascimento;
		this.tipoDependencia = tipoDependencia;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the nascimento
	 */
	public GregorianCalendar getNascimento() {
		return nascimento;
	}
	/**
	 * @param nascimento the nascimento to set
	 */
	public void setNascimento(GregorianCalendar nascimento) {
		this.nascimento = nascimento;
	}
	/**
	 * @return the tipoDependencia
	 */
	public String getTipoDependencia() {
		return tipoDependencia;
	}
	/**
	 * @param tipoDependencia the tipoDependencia to set
	 */
	public void setTipoDependencia(String tipoDependencia) {
		this.tipoDependencia = tipoDependencia;
	}
	public String toString() {
		return 
		  "Nome       : " + nome + "\n" +
		  "Nascimento : " + LtpLib.formatarData(nascimento, "dd/MM/yyyy") + "\n" +
		  "Desc. Dep. : " + tipoDependencia + "\n";
	}
	
}







