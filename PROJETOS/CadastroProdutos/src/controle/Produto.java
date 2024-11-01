package controle;

import java.io.Serializable;
import java.util.GregorianCalendar;

import utilitarios.LtpLib;

@SuppressWarnings("serial")
public class Produto implements Serializable {

// Atributos

	private static int ultimoCodigo;
	private int codigo;
	private String produto;
	private double preco;
	private GregorianCalendar data;

	/** Construtor
	 * @param codigo
	 * @param preco
	 * @param produto
	 * @param data
	 */
	public Produto(String produto, double preco, GregorianCalendar data) {
		// TODO Auto-generated constructor stub
		ultimoCodigo++;
		this.codigo = ultimoCodigo;
		this.preco = preco;
		this.produto = produto;
		this.data = data;
	}

	public static int getUltimoCodigo() {
		return ultimoCodigo;
	}

	public static void setUltimoCodigo(int ultimoCodigo) {
		Produto.ultimoCodigo = ultimoCodigo;
	}

	/**
	 * @return Returns the codigo.
	 */
	public int getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo The codigo to set.
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return Returns the preco.
	 */
	public double getPreco() {
		return preco;
	}
	/**
	 * @param preco The preco to set.
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}
	/**
	 * @return Returns the produto.
	 */
	public String getProduto() {
		return produto;
	}
	/**
	 * @param produto The produto to set.
	 */
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public GregorianCalendar getData() {
		return data;
	}
	public void setData(GregorianCalendar data) {
		this.data = data;
	}

	public String toString () {
		return 	"Código      : " + this.codigo  + "\n" +
		        "Produto     : " + this.produto + "\n" +
		        "Preço       : " + LtpLib.formatarValor(Double.valueOf(this.preco),"R$##,##0.00") +
		        "\n";
	}

}
