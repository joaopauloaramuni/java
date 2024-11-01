package dados;

import java.io.Serializable;
import java.util.GregorianCalendar;

import cadastro.SisComException;

import utilitarios.LtpLib;

/**
 * Descrição: Classe Produto, contém os dados do Produto. 
 * Pacote: dados 
 * @author João Paulo Aramuni 
 * @version 1.0 - Maio 2011
 * */

@SuppressWarnings("serial")
public class Produto implements Comparable<Produto>,Serializable{

	private int codigo;
	private String nome;
	private double precoUnitario;
	private int estoque;
	private int estoqueMinimo;
	private GregorianCalendar dataCad;
	
	/**
	 * Descrição: Método Construtor
	 * @param codigo , nome, precoUnitario, estoque, estoqueMinimo, dataCad
	 */
	public Produto(int codigo, String nome, double precoUnitario, int estoque,
			int estoqueMinimo, GregorianCalendar dataCad) {
		this.codigo = codigo;
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.estoque = estoque;
		this.estoqueMinimo = estoqueMinimo;
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

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public int getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(int estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public GregorianCalendar getDataCad() {
		return dataCad;
	}

	public void setDataCad(GregorianCalendar dataCad) {
		this.dataCad = dataCad;
	}
	
	/**
	 * Descrição: Método para adicionar quantidade do produto no estoque
	 * @param quant - Quantidade a ser incrementada.
	 */
	public void quantProdEstoqueIncre(int quant){
		setEstoque(estoque + quant);
	}

	/**
	 * Descrição: Método para decrementar quantidade do produto no estoque
	 * @param quant
	 * @throws SisComException "Nome do Produto: " + nome + "\n" + "Estoque: "
					+ estoque + "\n" + "Estoque Insuficiente."
	 */
	public void quantProdEstoqueDecre(int quant) throws SisComException {

		if (estoque - quant >= 0) {
			setEstoque(estoque - quant);
		} else
			throw new SisComException("Nome do Produto: " + nome + "\n" + "Estoque: "
					+ estoque + "\n" + "\nEstoque Insuficiente.");
	}
	
	/**
	 * Descrição: Comparar dois nomes de produtos.
	 * @param obj
	 * @return zero caso os nomes sejam iguais, 1 para maior e -1 para menor.
	 */
	public int compareTo(Produto obj) {
		return nome.compareTo(obj.getNome());
	}

	/**
	 * Descrição: Dados do Produto.
     * @return String com os dados do Produto à Venda.
	 */
	public String toString() {
		return "Código: " + codigo + "\n" + "Nome: " + nome + "\n" + "Preço Unitário: " + precoUnitario + "\n" + "Estoque: " + estoque + "\n" + 
		"Estoque Mínimo: " + estoqueMinimo + "\n" + "Data de Cadastro: " + LtpLib.formatarData(dataCad, "dd/MM/yyyy");
	}

}
