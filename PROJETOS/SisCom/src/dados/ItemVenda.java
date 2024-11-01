package dados;

import java.io.Serializable;

/**
 * Descri��o: Classe ItemVenda, cont�m os dados do produto a venda. 
 * Pacote: dados 
 * @author Jo�o Paulo Aramuni 
 * @version 1.0 - Maio 2011
 * */
@SuppressWarnings("serial")
public class ItemVenda implements Serializable{

	private Produto produto;
	private int quantVenda;
	private double valorVenda;

	/**
	 * Descri��o: M�todo Construtor
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
	 * Descri��o: Dados do Item � Venda.
     * @return String com os dados do Item � Venda.
	 */
	public String toString() {
		return "Produto: " + produto + "\n" + "Quantidade de Venda: " + quantVenda + "\n" + "Valor da Venda: " + valorVenda;
	}
}
