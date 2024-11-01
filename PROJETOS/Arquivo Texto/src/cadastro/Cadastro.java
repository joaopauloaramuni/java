package cadastro;

import java.util.Vector;

import dados.Produto;

public class Cadastro {
	public static Vector<Produto> listaProd = new Vector<Produto>();
	public static void incluirProd(Produto obj){
		listaProd.add(obj);
	}
}
