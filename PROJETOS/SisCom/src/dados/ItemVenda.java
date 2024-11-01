package dados;

import java.io.Serializable;

/**
 * Descrição: Classe ItemVenda, contém os dados do produto a venda. 
 * Pacote: dados 
 * @author João Paulo Aramuni 
 * @version 1.0 - Maio 2011
 * */
@SuppressWarnings("serial")
public class ItemVenda implements Serializable{

	private Produto produto;
	private int quantVenda;
	private double valorVenda;

	/**
	 * Descrição: Método Construtor
	 * @param produto , quantVenda, valorVenda
	 */
	public ItemVenda(Produto produto, int quantVenda, double valorVenda) {
		this.produto = produto;
		this.quantVenda = quantVenda;
		this.valorVenda = valorVenda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantVenda() {
		return quantVenda;
	}

	public void setQuantVenda(int quantVenda) {
		this.quantVenda = quantVenda;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	/**
	 * Descrição: Dados do Item à Venda.
     * @return String com os dados do Item à Venda.
	 */
	public String toString() {
		return "Produto: " + produto + "\n" + "Quantidade de Venda: " + quantVenda + "\n" + "Valor da Venda: " + valorVenda;
	}
}
