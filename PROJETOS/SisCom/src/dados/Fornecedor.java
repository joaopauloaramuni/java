package dados;

import java.io.Serializable;
import java.util.GregorianCalendar;

import utilitarios.LtpLib;

/**
 * Descrição: Classe Fornecedor, contém os dados do Fornecedor. 
 * Pacote: dados 
 * @author João Paulo Aramuni 
 * @version 1.0 - Maio 2011
 * */
@SuppressWarnings("serial")
public class Fornecedor extends Pessoa implements Serializable{

	private String cnpj;
	private String nomeContato;
	
	/**
	 * Descrição: Método Construtor - Herda parâmetros e atributos da Classe Pessoa.
	 * @param codigo , nome, telefones, email, dataCad, cpf, metaMensal
	 */
	public Fornecedor(int codigo, String nome, String telefones, String email,
			GregorianCalendar dataCad, String cnpj, String nomeContato) {
		super(codigo, nome, telefones, email, dataCad);
		this.cnpj = cnpj;
		this.nomeContato = nomeContato;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeContato() {
		return nomeContato;
	}

	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}
	
	/**
	 * Descrição: Método para retornar o tipo de Pessoa.
     * @return String com o tipo de Pessoa.
	 */
	@Override
	public int tipoPessoa() {
		return Pessoa.FORNECEDOR;
	}
	
	/**
	 * Descrição: Dados do Fornecedor Cadastrado no Sistema.
     * @return String com os dados do Fornecedor.
	 */
	public String toString() {
		
		return super.toString() + "CNPJ: " + LtpLib.formatarCNPJ(cnpj) + "\n" + "Nome Contato: " + nomeContato;
	}
}
