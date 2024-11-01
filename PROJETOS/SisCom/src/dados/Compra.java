package dados;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Vector;

import utilitarios.LtpLib;

/**
 * Descrição: Classe Compra, contém os dados da compra. 
 * Pacote: dados 
 * @author João Paulo Aramuni 
 * @version 1.0 - Maio 2011
 * */
@SuppressWarnings("serial")
public class Compra implements Serializable{

	private int numCompra;
	private Fornecedor fornecedor;
	private Vector<ItemCompra> compraItens;
	private GregorianCalendar dataCompra;
	
	/**
	 * Descrição: Método Construtor
	 * @param numCompra , fornecedor, compraItens, dataCompra
	 */
	public Compra(int numCompra, Fornecedor fornecedor,
			Vector<ItemCompra> compraItens, GregorianCalendar dataCompra) {
		this.numCompra = numCompra;
		this.fornecedor = fornecedor;
		this.compraItens = compraItens;
		this.dataCompra = dataCompra;
	}

	public int getNumCompra() {
		return numCompra;
	}

	public void setNumCompra(int numCompra) {
		this.numCompra = numCompra;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Vector<ItemCompra> getCompraItens() {
		return compraItens;
	}

	public void setCompraItens(Vector<ItemCompra> compraItens) {
		this.compraItens = compraItens;
	}

	public GregorianCalendar getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(GregorianCalendar dataCompra) {
		this.dataCompra = dataCompra;
	}

	/**
	 * Descrição: Dados da Compra.
     * @return String com os dados da Compra.
	 */
	
	public String toString() {
		return "Número da Compra: " + numCompra + "\n" + "Fornecedor: " + fornecedor + "\n" 
		+ "Data da Compra: " + LtpLib.formatarData(dataCompra, "dd/MM/yyyy");
	}
}
