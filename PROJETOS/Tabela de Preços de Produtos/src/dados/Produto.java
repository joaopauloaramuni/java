package dados;

import java.io.Serializable;
import java.util.GregorianCalendar;

import utilitarios.LtpLib;

@SuppressWarnings("serial")
public class Produto implements Serializable{

	private int codigo;
	private String descricao;
	private double preco;
	private GregorianCalendar data;

	public Produto(int codigo, String descricao, double preco,
			GregorianCalendar data) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
		this.data = data;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public GregorianCalendar getData() {
		return data;
	}

	public void setData(GregorianCalendar data) {
		this.data = data;
	}

	public Produto clone() {
		return new Produto(codigo, descricao, preco, data);
	}

	public boolean equals(Produto obj) {
		if (codigo == obj.getCodigo()
				&& descricao.equalsIgnoreCase(obj.getDescricao())
				&& data.equals(obj.getData())) {
			return true;
		} else
			return false;
	}

	public String toString(){
		return "Código: " + codigo + "\n" + "Descrição: " + descricao + "\n" + "Preço: " + LtpLib.formatarValor(preco, "R$#,##0.00")
		+ "\n" + "Data: " + LtpLib.formatarData(data,"dd/MM/yyyy") + "\n";
	}
}
