package cadastro;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Vector;
import dados.Cliente;
import dados.Compra;
import dados.Fornecedor;
import dados.ItemCompra;
import dados.ItemVenda;
import dados.Pessoa;
import dados.Produto;
import dados.Venda;
import dados.Vendedor;

/**
 * Descrição: Classe Comercial, contém as listas. 
 * Pacote: cadastro
 * @author João Paulo Aramuni 
 * @version 1.0 - Maio 2011
 * */
@SuppressWarnings("serial")
public class Comercial implements Serializable {

	private static Vector<Pessoa> pessoas = new Vector<Pessoa>();
	private static Vector<Produto> produtos = new Vector<Produto>();
	private static Vector<Compra> compras = new Vector<Compra>();
	private static Vector<Venda> vendas = new Vector<Venda>();

	public static Vector<Pessoa> getPessoas() {
		return pessoas;
	}

	public static void setPessoas(Vector<Pessoa> pessoas) {
		Comercial.pessoas = pessoas;
	}

	public static Vector<Produto> getProdutos() {
		return produtos;
	}

	public static void setProdutos(Vector<Produto> produtos) {
		Comercial.produtos = produtos;
	}

	public static Vector<Compra> getCompras() {
		return compras;
	}

	public static void setCompras(Vector<Compra> compras) {
		Comercial.compras = compras;
	}

	public static Vector<Venda> getVendas() {
		return vendas;
	}

	public static void setVendas(Vector<Venda> vendas) {
		Comercial.vendas = vendas;
	}
	
	/**
	 * Decrição: Incluir Pessoa
	 * @param objPes
	 * @throws SisComException
	 *             "Cliente Já Cadastrado!","Fornecedor Já Cadastrado!",
	 *             "Vendedor Já Cadastrado!","Meta Mensal Inválida!"
	 */
	public static void incluirPessoa(Pessoa objPes) throws SisComException {
		for (Pessoa obj : pessoas) {
			if (obj.tipoPessoa() == Pessoa.CLIENTE
					&& objPes.tipoPessoa() == Pessoa.CLIENTE) {
				if (((Cliente) obj).getCpf()
						.equals(((Cliente) objPes).getCpf())) {
					throw new SisComException("\nCPF Já Cadastrado!");
				}
			} else if (obj.tipoPessoa() == Pessoa.VENDEDOR
					&& objPes.tipoPessoa() == Pessoa.CLIENTE) {
				if (((Vendedor) obj).getCpf().equals(
						((Cliente) objPes).getCpf())) {
					throw new SisComException("\nCPF Já Cadastrado!");
				}
			} else if (obj.tipoPessoa() == Pessoa.VENDEDOR
					&& objPes.tipoPessoa() == Pessoa.VENDEDOR) {
				if (((Vendedor) obj).getCpf().equals(
						((Vendedor) objPes).getCpf())) {
					throw new SisComException("\nCPF Já Cadastrado!");
				}
			} else if (obj.tipoPessoa() == Pessoa.CLIENTE
					&& objPes.tipoPessoa() == Pessoa.VENDEDOR) {
				if (((Cliente) obj).getCpf().equals(
						((Vendedor) objPes).getCpf())) {
					throw new SisComException("\nCPF Já Cadastrado!");
				}
			}else if (obj.tipoPessoa() == Pessoa.FORNECEDOR
					&& objPes.tipoPessoa() == Pessoa.FORNECEDOR) {
				if (((Fornecedor) obj).getCnpj().equals(
						((Fornecedor) objPes).getCnpj())) {
					throw new SisComException("\nFornecedor Já Cadastrado!");
				}
			}
		}
		pessoas.add(objPes);
	}

	/**
	 * Descrição: Cadastrar Produto
	 * @param produto
	 * @throws SisComException
	 *             "Produto já cadastrado"
	 */
	public static void inserirProduto(Produto obj) throws SisComException {
		for (Produto objPro : produtos) {
			if (obj.getNome().equals(objPro.getNome())) {
				throw new SisComException("\nProduto já cadastrado.");
			}
		}
		produtos.add(obj);
	}

	/**
	 * Descrição: Excluir Produto
	 * @param codigo
	 * @throws SisComException
	 *             "Compra já registrada para este produto.",
	 *             "Venda já registrada para este produto.",
	 *             "Produto Não Encontrado."
	 */
	public static void excluirProduto(int codigo) throws SisComException {
			for (Compra obj : compras) {
				for (ItemCompra objCompra : obj.getCompraItens()) {
					if (objCompra.getProduto().getCodigo() == codigo) {
						throw new SisComException(
								"\nCompra já registrada para este produto.");
					}
				}
			}
			for (Venda obj : vendas) {
				for (ItemVenda objVenda : obj.getVendaItens()) {
					if (objVenda.getProduto().getCodigo() == codigo) {
						throw new SisComException(
								"\nVenda já registrada para este produto.");
					}
				}
			}
		for (Produto objProduto : produtos) {
			if (objProduto.getCodigo() == codigo) {
				produtos.remove(objProduto);
				return;
			}
		}
		throw new SisComException("\nProduto Não Encontrado.");
	}

	/**
	 * Descrição: Buscar Cliente ou Vendedor pelo CPF
	 * @param cpf
	 * @throws SisComException
	 *             "CPF não encontrado."
	 */
	public static Pessoa consultarCPF(String cpf, int tipo)
			throws SisComException {
		for (Pessoa obj : pessoas) {
			if (obj.tipoPessoa() == Pessoa.CLIENTE && tipo == 1) {
				if (((Cliente) obj).getCpf().equals(cpf)) {
					return obj;
				}
			} else if (obj.tipoPessoa() == Pessoa.VENDEDOR && tipo == 2) {
				if (((Vendedor) obj).getCpf().equals(cpf)) {
					return obj;
				}
			}
		}
		throw new SisComException("CPF não encontrado.");
	}

	/**
	 * Descrição: Buscar Fornecedor pelo CNPJ
	 * @param cnpj
	 * @throws SisComException
	 *             "Não existe fornecedor para o CNPJ."
	 */
	public static Pessoa consultarCNPJ(String cnpj) throws SisComException {
		for (Pessoa obj : pessoas) {
			if (obj.tipoPessoa() == Pessoa.FORNECEDOR) {
				if (((Fornecedor) obj).getCnpj().equals(cnpj)) {
					return obj;
				}
			}
		}
		throw new SisComException("\nNão existe fornecedor para o CNPJ.");
	}

	/**
	 * Descrição: Excluir Pessoa
	 * @param obj
	 * @throws SisComException
	 *             "Já existe venda para este Cliente."
	 *             "Já existe venda para este Vendedor."
	 *             "Já existe compra para este Fornecedor."
	 */
	public static void excluirPessoa(Pessoa obj) throws SisComException {

		if (obj.tipoPessoa() == Pessoa.CLIENTE) {

			for (Venda objVenda : vendas) {
				if (objVenda.getCliente().getCpf().equals(
						((Cliente) obj).getCpf())) {
					throw new SisComException(
							"Já existe venda para este Cliente.");
				}
			}
			pessoas.remove(obj);
			return;

		} else if (obj.tipoPessoa() == Pessoa.VENDEDOR) {

			for (Venda objVenda : vendas) {
				if (objVenda.getVendedor().getCpf().equals(
						((Vendedor) obj).getCpf())) {
					throw new SisComException(
							"Já existe venda para este Vendedor.");
				}
			}
			pessoas.remove(obj);
			return;

		} else if (obj.tipoPessoa() == Pessoa.FORNECEDOR) {

			for (Compra objCompra : compras) {
				if (objCompra.getFornecedor().getCnpj().equals(
						((Fornecedor) obj).getCnpj())) {
					throw new SisComException(
							"Já existe compra para este Fornecedor.");
				}
			}
			pessoas.remove(obj);
			return;

		}
	}

	/**
	 * Descrição: Consultar Produto pelo Código
	 * @param codigo
	 * @return obj
	 * @throws SisComException
	 *             "Produto Não Localizado"
	 */
	public static Produto consultarProdutoCod(int codigo)
			throws SisComException {

		for (Produto obj : produtos) {
			if (obj.getCodigo() == codigo) {
				return obj;
			}
		}
		throw new SisComException("\nProduto Não Localizado");
	}
	
	/**
	 * Descrição: Cadastrar Produto
	 * @param produto
	 */
	public static void incluirProduto(Produto produto) {
		produtos.add(produto);
	}

	/**
	 * Descrição: Listar Pessoas
	 * @return resposta
	 * @throws SisComException "Lista Não Existente."
	 */
	@SuppressWarnings("unchecked")
	public static Vector<Pessoa> listarPessoas() throws SisComException {
		
		Vector<Pessoa> resposta = (Vector<Pessoa>)pessoas.clone();
		
		Collections.sort(resposta, new Comparator<Pessoa>() {

			@Override
			public int compare(Pessoa o1, Pessoa o2) {
				return o1.getNome().compareTo(o2.getNome());
			}
		});
		
		if(!resposta.isEmpty()){
			return resposta;
		}
		throw new SisComException("Lista Não Existente.");
	}
	
	/**
	 * Descrição: Listar Compras por Ordem de Fornecedor e Data da Compra Decrescente
	 * @return resposta
	 * @throws SisComException "Lista Não Existente."
	 */
	@SuppressWarnings("unchecked")
	public static Vector<Compra> listarComprasForne() throws SisComException {
		
		Vector<Compra> resposta = (Vector<Compra>)compras.clone();
		
		Collections.sort(resposta, new Comparator<Compra>() {

			@Override
			public int compare(Compra o1, Compra o2) {
				int chavePrincipal = o1.getFornecedor().compareTo(o2.getFornecedor());
				if(chavePrincipal!=0) return chavePrincipal;
				if (o1.getDataCompra().compareTo(o2.getDataCompra()) == 1)
					return -1;
				else if (o1.getDataCompra().compareTo(o2.getDataCompra()) == 0)
					return 0;
				else
					return 1;
			}
		});
		
		if(!resposta.isEmpty()){
			return resposta;
		}
		throw new SisComException("Lista Não Existente.\n");
	}
	
	/**
	 * Descrição: Listar Produtos
	 * @return resposta
	 * @throws SisComException "Lista Não Existente."
	 */
	@SuppressWarnings("unchecked")
	public static Vector<Produto> listarProdutos() throws SisComException {
		
		Vector<Produto> resposta = (Vector<Produto>)produtos.clone();
		
		Collections.sort(resposta, new Comparator<Produto>() {

			@Override
			public int compare(Produto o1, Produto o2) {
				return o1.getNome().compareTo(o2.getNome());
			}
		});
		
		if(!resposta.isEmpty()){
			return resposta;
		}
		throw new SisComException("Lista Não Existente.\n");
	}
	
	/**
	 * Descrição: Consultar Pessoa pelo Código
	 * @return obj
	 * @throws SisComException "Código não encontrado."
	 */
	public static Pessoa consultarCodigo(int codigo,int tipo) throws SisComException{
		
		for (Pessoa obj : pessoas) {
			if (obj.tipoPessoa() == Pessoa.CLIENTE && tipo == 1) {
				if (((Cliente) obj).getCodigo() == codigo) {
					return obj;
				}
			} else if (obj.tipoPessoa() == Pessoa.VENDEDOR && tipo == 2) {
				if (((Vendedor) obj).getCodigo() == codigo) {
					return obj;
				}
			} else if (obj.tipoPessoa() == Pessoa.FORNECEDOR && tipo == 3) {
				if (((Fornecedor) obj).getCodigo() == codigo) {
					return obj;
				}
			}
		}
		throw new SisComException("\nCódigo não encontrado.");
	}

	/**
	 * Descrição: Comprar Produto de Fornecedor
	 * @param objFor, compraItens
	 */
	public static void comprarProdForne(Fornecedor objFor,
			Vector<ItemCompra> compraItens) {

		// Número da Compra
		int numCompra = (Comercial.getCompras().isEmpty() ? 1 : Comercial
				.getCompras().lastElement().getNumCompra() + 1);
		
		compras.add(new Compra(numCompra, objFor, compraItens, new GregorianCalendar()));
	}
	
	/**
	 * Descrição: Excluir Compra de Fornecedor
	 * @param numCompra
	 * @throws SisComException "Número da Compra não encontrado."
	 */
	public static void excluirCompraForne(int numCompra)throws SisComException {
		
		for (Compra comp : compras) {
			if(comp.getNumCompra() == numCompra){
				compras.remove(comp);
				return;
			}
		}
		throw new SisComException("\nNúmero da Compra não encontrado.");
	}

	/**
	 * Descrição: Vender Produto para Cliente
	 * @param objCli,objVen,formaPagto,vendaItens
	 */
	public static void venderProdCliente(int numVenda,Cliente objCli, Vendedor objVen,
			int formaPagto, Vector<ItemVenda> vendaItens) {
		
		vendas.add(new Venda(numVenda, objCli, objVen, vendaItens, formaPagto, new GregorianCalendar()));
		
	}

	/**
	 * Descrição: Excluir Venda para Cliente
	 * @param numVenda
	 * @throws SisComException "Número da Compra não encontrado."
	 */
	public static void excluirVendaCliente(int numVenda) throws SisComException {
		
		for (Venda vend : vendas) {
			if(vend.getNumVenda() == numVenda){
				vendas.remove(vend);
				return;
			}
		}
		throw new SisComException("\nNúmero da Compra não encontrado.");
	}

	/**
	 * Descrição: Listar Vendas por Ordem de Cliente e Data da Venda Decrescente
	 * @return resposta
	 * @throws SisComException "Lista Não Existente."
	 */
	@SuppressWarnings("unchecked")
	public static Vector<Venda> listarVendasCliente() throws SisComException {
		
		Vector<Venda> resposta = (Vector<Venda>)vendas.clone();
		
		Collections.sort(resposta, new Comparator<Venda>() {

			@Override
			public int compare(Venda o1, Venda o2) {
				int chavePrincipal = o1.getCliente().compareTo(o2.getCliente());
				if (chavePrincipal != 0)
					return chavePrincipal;
				if (o1.getDataVenda().compareTo(o2.getDataVenda()) == 1)
					return -1;
				else if (o1.getDataVenda().compareTo(o2.getDataVenda()) == 0)
					return 0;
				else
					return 1;
			}
		});
		
		if(!resposta.isEmpty())
			return resposta;
			
			throw new SisComException("Lista Não Existente.\n");
	}

	/**
	 * Descrição: Listar Vendas por Ordem de Vendedor e Data da Venda Decrescente
	 * @return resposta
	 * @throws SisComException "Lista Não Existente."
	 */
	@SuppressWarnings("unchecked")
	public static Vector<Venda> listarVendasVendedor() throws SisComException {
		
		Vector<Venda> resposta = (Vector<Venda>)vendas.clone();
		
		Collections.sort(resposta, new Comparator<Venda>() {

			@Override
			public int compare(Venda o1, Venda o2) {
				int chavePrincipal = o1.getVendedor().compareTo(o2.getVendedor());
				if(chavePrincipal!=0) return chavePrincipal;
				if (o1.getDataVenda().compareTo(o2.getDataVenda()) == 1)
					return -1;
				else if (o1.getDataVenda().compareTo(o2.getDataVenda()) == 0)
					return 0;
				else
					return 1;
			}
		});
		
		if(!resposta.isEmpty())
		return resposta;
		
		throw new SisComException("Lista Não Existente.\n");
	}

	/**
	 * Descrição: Estatística de Vendas - Agrupado por Cliente por Período de Vendas
	 * @apram Período - Data1 até Data2
	 * @return estatisticaCliente
	 * @throws SisComException "Não existe lista para a data informada." 
	 */
	public static Vector<String> estatisticaCli(GregorianCalendar data1, GregorianCalendar data2) throws SisComException {

		Vector<String> estatisticaClientes = new Vector<String>();
		int cont;
		double valorTot;
		for (Pessoa obj : pessoas) {
			if (obj.tipoPessoa() == Pessoa.CLIENTE) {
				cont = 0;
				valorTot = 0;
				for (Venda objVendas : vendas) {
					if (objVendas.getCliente().getCpf() == ((Cliente) obj).getCpf() && objVendas.getDataVenda().compareTo(data1)>=0 && objVendas.getDataVenda().compareTo(data2)<=0) {
						cont++;
						for (ItemVenda objItem : objVendas.getVendaItens()) {
							valorTot = valorTot + objItem.getValorVenda();
						}
					}
				}
				if(cont>0)
				estatisticaClientes.add("\nNome do Cliente: "
						+ obj.getNome() + "\n" + "Quantas Vezes Comprou: "
						+ cont + "\n" + "Valor Total em Compras: " + valorTot);
			}
		}
		if(!estatisticaClientes.isEmpty())
			return estatisticaClientes;
	
		throw new SisComException("Não existe lista para a data informada.\n");
	}

	/**
	 * Descrição: Estatística de Vendas - Agrupado por Vendedor por Período de Vendas
	 * @param Período - Data1 até Data2
	 * @return estatisticaVendedores
	 * @throws SisComException "Não existe lista para a data informada."
	 */
	public static Vector<String> estatisticaVen(GregorianCalendar data1, GregorianCalendar data2) throws SisComException {
		Vector<String> estatisticaVendedores = new Vector<String>();
		int cont = 0;
		double valorTot;
		for (Pessoa obj : pessoas) {
			if (obj.tipoPessoa() == Pessoa.VENDEDOR) {
				cont = 0;
				valorTot = 0;
				for (Venda objVendas : vendas) {
					if (objVendas.getVendedor().getCpf() == ((Vendedor) obj)
							.getCpf() && objVendas.getDataVenda().compareTo(data1)>=0 && objVendas.getDataVenda().compareTo(data2)<=0) {
						cont++;
						for (ItemVenda objItem : objVendas.getVendaItens()) {
							valorTot = valorTot + objItem.getValorVenda();
						}
					}
				}
				if(cont>0)
				estatisticaVendedores.add("\nNome do Vendedor: "
						+ obj.getNome() + "\n" + "Quantas Vezes Vendeu: "
						+ cont + "\n" + "Valor Total em Vendas: " + valorTot);

			}
		}
		if(!estatisticaVendedores.isEmpty()){
			return estatisticaVendedores;
		}
		throw new SisComException("Não existe lista para a data informada.\n");
	}

	/**
	 * Descrição: Estatística de Compras - Agrupado por Fornecedor por Período de Compras
	 * @param Período - Data1 até Data2
	 * @return estatisticaFornecedores
	 * @throws SisComException "Não existe lista para a data informada."
	 */
	public static Vector<String> estatisticaFor(GregorianCalendar data1,
			GregorianCalendar data2) throws SisComException {
		Vector<String> estatisticaFornecedores = new Vector<String>();
		int cont = 0;
		double valorTot;
		for (Pessoa obj : pessoas) {
			if (obj.tipoPessoa() == Pessoa.FORNECEDOR) {
				cont = 0;
				valorTot = 0;
				for (Compra objCompras : compras) {
					if (objCompras.getFornecedor().getCnpj() == ((Fornecedor) obj)
							.getCnpj() && objCompras.getDataCompra().compareTo(data1)>=0 && objCompras.getDataCompra().compareTo(data2)<=0) {
						cont++;
						for (ItemCompra objItem : objCompras.getCompraItens()){
							valorTot = valorTot + objItem.getValorCompra();
						}
					}
				}
				if(cont>0)
				estatisticaFornecedores.add("\nNome do Fornecedor: "
						+ obj.getNome() + "\n" + "Quantas Vezes Vendeu: "
						+ cont + "\n" + "Valor Total em Vendas: " + valorTot);

			}
		}
		if(!estatisticaFornecedores.isEmpty()){
			return estatisticaFornecedores;
		}
		throw new SisComException("Não existe lista para a data informada.\n");
	}
	/**
	 * Descrição: (Dado Auxiliar) PROVA - Estatística de Vendas - Agrupado por Vendedor por Mes/Ano
	 * @param mes,ano
	 * @return estatisticaVendedores
	 * @throws SisComException "Não existe lista para a data informada."
	 */
	public static Vector<Venda> estatisticaVenProva(int mes, int ano)
			throws SisComException {
		Vector<Venda> vend = new Vector<Venda>();
		double valorTot;
		for (Pessoa obj : pessoas) {
			if (obj.tipoPessoa() == Pessoa.VENDEDOR) {
				valorTot = 0;
				for (Venda objVendas : vendas) {
					if (objVendas.getVendedor().getCpf() == ((Vendedor) obj)
							.getCpf()
							&& objVendas.getDataVenda().get(
									GregorianCalendar.MONTH) == mes - 1
							&& objVendas.getDataVenda().get(
									GregorianCalendar.YEAR) == ano) {
						for (ItemVenda objItem : objVendas.getVendaItens()) {
							valorTot = valorTot + objItem.getValorVenda();
						}
						vend.add(objVendas);
					}
				}

			}
		}
		if (!vend.isEmpty()) {

			Collections.sort(vend, new Comparator<Venda>() {

				@Override
				public int compare(Venda o1, Venda o2) {
					if (o1.getDataVenda().get(GregorianCalendar.MONTH) < o2
							.getDataVenda().get(GregorianCalendar.MONTH)) {
						return 1;
					} else if (o1.getDataVenda().get(GregorianCalendar.MONTH) > o2
							.getDataVenda().get(GregorianCalendar.MONTH)) {
						return -1;
					} else
						return 0;
				}
			});

			return vend;
		}
		throw new SisComException("Não existe lista para a data informada.\n");
	}
	/**
	 * Descrição: PROVA - Estatística de Vendas - Agrupado por Vendedor por Mes/Ano
	 * @param vend
	 * @return resposta
	 */
	public static Vector<String> EstatisticaVendasProva(Vector<Venda> vend) {
		double valorTot = 0;
		Vector<String> resposta = new Vector<String>();
		for (Venda obj : vend) {
			for (ItemVenda objItem : obj.getVendaItens()) {
				valorTot = valorTot + objItem.getValorVenda();
			}
			resposta.add("\nNome do Vendedor: " + obj.getVendedor().getNome()
					+ "\nMeta Mensal: " + obj.getVendedor().getMetaMensal()
					+ "\nValot Total: " + valorTot + "\nSaldo: "
					+ (valorTot - obj.getVendedor().getMetaMensal()));
		}
		return resposta;
		
	}
}