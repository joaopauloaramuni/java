package dados;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Vector;

import utilitarios.LtpLib;

/**
 * Descrição: Classe Venda, contém os dados da Venda. 
 * Pacote: dados 
 * @author João Paulo Aramuni 
 * @version 1.0 - Maio 2011
 * */
@SuppressWarnings("serial")
public class Venda implements Serializable{

	private int numVenda;
	private Cliente cliente;
	private Vendedor vendedor;
	private Vector<ItemVenda> vendaItens;
	private int formaPagto;
	private GregorianCalendar dataVenda;
	
	/**
	 * Descrição: Método Construtor
	 * @param numVenda , cliente, vendedor, vendaItens, formaPagto, dataVenda
	 */
	public Venda(int numVenda, Cliente cliente, Vendedor vendedor,
			Vector<ItemVenda> vendaItens, int formaPagto,
			GregorianCalendar dataVenda) {
		this.numVenda = numVenda;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.vendaItens = vendaItens;
		this.formaPagto = formaPagto;
		this.dataVenda = dataVenda;
	}

	public int getNumVenda() {
		return numVenda;
	}

	public void setNumVenda(int numVenda) {
		this.numVenda = numVenda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Vector<ItemVenda> getVendaItens() {
		return vendaItens;
	}

	public void setVendaItens(Vector<ItemVenda> vendaItens) {
		this.vendaItens = vendaItens;
	}

	public int getFormaPagto() {
		return formaPagto;
	}

	public void setFormaPagto(int formaPagto) {
		this.formaPagto = formaPagto;
	}

	public GregorianCalendar getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(GregorianCalendar dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	/**
	 * Descrição: Dados do Item da Compra.
     * @return String com os dados do Item da Compra.
	 */
	public String toString() {
		return "Número da Venda: " + numVenda + "\n" + "Cliente: " + cliente + "\n" + "Vendedor: " + vendedor + "\n" + "Forma de Pagamento: " + formaPagto + "\n" + "Data da Venda: " + LtpLib.formatarData(dataVenda, "dd/MM/yyyy");
	}
}
