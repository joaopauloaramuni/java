package dados;

import java.io.Serializable;
import java.util.GregorianCalendar;

import utilitarios.LtpLib;

/**
 * Descrição: Classe Pessoa, contém os dados da pessoa. 
 * Pacote: dados 
 * @author João Paulo Aramuni 
 * @version 1.0 - Maio 2011
 * */

@SuppressWarnings("serial")
public abstract class Pessoa implements Comparable<Pessoa>,Serializable {
	
	//CONSTANTES
	public static final int CLIENTE = 1;
	public static final int VENDEDOR = 2;
	public static final int FORNECEDOR = 3;
	
	//ATRIBUTOS
	private int codigo;
	private String nome;
	private String telefones;
	private String email;
	private GregorianCalendar dataCad;

	/**
	 * Descrição: Método Construtor
	 * @param codigo, nome, telefones, email, dataCad
	 */
	public Pessoa(int codigo, String nome, String telefones, String email,
			GregorianCalendar dataCad) {
		this.codigo = codigo;
		this.nome = nome;
		this.telefones = telefones;
		this.email = email;
		this.dataCad = dataCad;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefones() {
		return telefones;
	}

	public void setTelefones(String telefones) {
		this.telefones = telefones;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public GregorianCalendar getDataCad() {
		return dataCad;
	}

	public void setDataCad(GregorianCalendar dataCad) {
		this.dataCad = dataCad;
	}

	/**
	 * Descrição: Método abstrato.
	 */
	public abstract int tipoPessoa();
	
	/**
	 * Descrição: Comparar dois nomes de pessoas.
	 * @param obj
	 * @return zero caso os nomes sejam iguais, 1 para maior e -1 para menor.
	 */
	public int compareTo(Pessoa obj) {
		return nome.compareTo(obj.getNome());
	}

	/**
	 * Descrição: Dados de Pessoa Cadastrada no Sistema.
     * @return String com todos os dados da Pessoa.
	 */
	public String toString() {
		return "Código: " + codigo + "\n" + "Nome: " + nome + "\n"
				+ "Telefones: " + telefones + "\n" + "Email: " + email + "\n"
				+ "Data de Cadastro: "
				+ LtpLib.formatarData(dataCad, "dd/MM/yyyy") + "\n";
	}
}
