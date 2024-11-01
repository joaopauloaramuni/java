package cadastro;

import java.util.ArrayList;

import dados.Produto;

public class Cadastro {
	// Atributos
	public static ArrayList<Produto> cadProd = new ArrayList<Produto>();

	// M�todos
	/**
	 * Incluir Produto
	 * 
	 * @param obj
	 *            produto
	 * @throws Esception
	 *             "Produto j� cadastrado"
	 */
	public static void incluirProduto(Produto obj) throws Exception {
		for (Produto objCad : cadProd) {
			if (objCad.getDescricao().equalsIgnoreCase(obj.getDescricao())) {
				throw new Exception("Produto j� Cadastrado - "
						+ objCad.getCodigo());
			}
		}

		cadProd.add(obj);
	}

	/**
	 * Consultar - Produto pelo c�digo
	 * 
	 * @param codigo
	 * @return o produto
	 * @throws Exception
	 *             "N�o existe o produto"
	 */
	public static Produto consultarProdCodigo(int codigo) throws Exception {
		for (Produto objCad : cadProd) {
			if (objCad.getCodigo() == codigo)
				return objCad;
		}
		throw new Exception("N�o existe produto para o Codigo.");
	}

	/**
	 * excluir o produto
	 * 
	 * @param obj
	 */
	public static void excluirProduto(Produto obj) {
		cadProd.remove(obj);
	}

	/**
	 * Consultar produtos pelo nome
	 * 
	 * @param nome
	 * @return lista de produtos selecionados
	 * @throws Exception
	 *             "N�o existe produto para o nome"
	 */
	public static ArrayList<Produto> consultarProdNome(String nome)
			throws Exception {
		ArrayList<Produto> resposta = new ArrayList<Produto>();
		for (Produto objCad : cadProd) {
			if (objCad.getDescricao().toUpperCase().indexOf(nome.toUpperCase()) != -1) {
				resposta.add(objCad);
			}
		}
		if (resposta.isEmpty()) {
			throw new Exception("N�o existe produto para o nome");
		} else
			return resposta;
	}
}
