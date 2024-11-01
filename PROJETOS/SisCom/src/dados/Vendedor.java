package dados;

import java.io.Serializable;
import java.util.GregorianCalendar;

import utilitarios.LtpLib;

/**
 * Descrição: Classe Vendedor, contém os dados do vendedor. 
 * Pacote: dados 
 * @author João Paulo Aramuni 
 * @version 1.0 - Maio 2011
 * */
@SuppressWarnings("serial")
public class Vendedor extends Pessoa implements Serializable{
	
	private String cpf;
	private double metaMensal;
	
	/**
	 * Descrição: Método Construtor - Herda parâmetros e atributos da Classe Pessoa.
	 * @param codigo , nome, telefones, email, dataCad, cpf, metaMensal
	 */
	public Vendedor(int codigo, String nome, String telefones, String email,
			GregorianCalendar dataCad, String cpf, double metaMensal) {
		super(codigo, nome, telefones, email, dataCad);
		this.cpf = cpf;
		this.metaMensal = metaMensal;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getMetaMensal() {
		return metaMensal;
	}

	public void setMetaMensal(double metaMensal) {
		this.metaMensal = metaMensal;
	}
	
	/**
	 * Descrição: Método para retornar o tipo de Pessoa.
     * @return String com o tipo de Pessoa.
	 */
	@Override
	public int tipoPessoa() {
		return Pessoa.VENDEDOR;
	}
	
	/**
	 * Descrição: Dados do Vendedor Cadastrado no Sistema.
     * @return String com os dados do Vendedor.
	 */
	public String toString() {
		
		return super.toString() + "CPF: " + LtpLib.formatarCPF(cpf)+ "\n" + "Meta Mensal: " + metaMensal;
	}
	
}
