package dados;

import java.io.Serializable;

/**
 * Descri��o: Classe ItemCompra, cont�m os dados de um item da compra. 
 * Pacote: dados 
 * @author Jo�o Paulo Aramuni 
 * @version 1.0 - Maio 2011
 * */
@SuppressWarnings("serial")
public class ItemCompra implements Serializable{

	private Produto produto;
	private int quantCompra;
	private double valorCompra;

	/**
	 * Descri��o: M�todo Construtor
	 * @param produto , quantCompra, valorCompra
	 */
	public ItemCompra(Produto produto, int quantCompra, double valorCompra) {
		this.produto = produto;
		this.quantCompra = quantCompra;
		this.valorCompra = valorCompra;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantCompra() {
		return quantCompra;
	}

	public void setQuantCompra(int quantCompra) {
		this.quantCompra = quantCompra;
	}

	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}
	
	/**
	 * Descri��o: Dados do Item da Compra.
     * @return String com os dados do Item da Compra.
	 */
	public String toString() {
		return "Produto: " + produto + "\n" + "Quantidade na Compra: " + quantCompra + "\n" + "Valor da Compra" + valorCompra;
	}
}
