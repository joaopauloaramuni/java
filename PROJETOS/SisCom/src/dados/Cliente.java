package dados;

import java.io.Serializable;
import java.util.GregorianCalendar;

import utilitarios.LtpLib;

/**
 * Descrição: Classe Cliente (Herança da Classe Pessoa) 
 * Pacote: dados 
 * @author João Paulo Aramuni 
 * @version 1.0 - Maio 2011
 * */
@SuppressWarnings("serial")
public class Cliente extends Pessoa implements Serializable{

	private String cpf;
	private double limiteCredito;

	/**
	 * Descrição: Método Construtor - Herda parâmetros e atributos da Classe Pessoa.
	 * @param codigo , nome, telefones, email, dataCad, cpf, limiteCredito
	 */
	public Cliente(int codigo, String nome, String telefones, String email,
			GregorianCalendar dataCad, String cpf, double limiteCredito) {
		super(codigo, nome, telefones, email, dataCad);
		this.cpf = cpf;
		this.limiteCredito = limiteCredito;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	
	/**
	 * Descrição: Método para retornar o tipo de Pessoa.
     * @return String com o tipo de Pessoa.
	 */
	@Override
	public int tipoPessoa() {
		return Pessoa.CLIENTE;
	}
	
	/**
	 * Descrição: Dados de Cliente Cadastrado no Sistema.
	 * @return String com os dados do Cliente.
	 */
	public String toString() {
		return super.toString() + "CPF: " + LtpLib.formatarCPF(cpf) + "\n" + "Limite de Crédito: " + limiteCredito;
	}

}
