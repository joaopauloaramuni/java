package usuario;

import java.io.File;
import java.util.GregorianCalendar;
import java.util.Vector;
import cadastro.Comercial;
import cadastro.SisComException;
import dados.Cliente;
import dados.Compra;
import dados.Fornecedor;
import dados.ItemCompra;
import dados.ItemVenda;
import dados.Pessoa;
import dados.Produto;
import dados.Venda;
import dados.Vendedor;

import utilitarios.Console;
import utilitarios.LtpLib;

/**
 * Descri��o: Classe InterfComercial 
 * Pacote: usuario 
 * @author Jo�o Paulo Aramuni 
 * @version 1.0 - Maio 2011
 * */
public class InterfComercial {

	/**
	 * Descri��o: M�todo main
	 * @param args
	 */
	public static void main(String[] args) {
		lerArquivo();
		menu();
		gravarArquivo();
		System.out.println("\nFinal do aplicativo.");
		System.exit(0);
	}
	
	/**
	 * Descri��o: M�todo Para Leitura de Arquivos de Objetos
	 */
	@SuppressWarnings("unchecked")
	private static void lerArquivo(){
		if (new File("Pessoas.obj").exists()) {
			try {
				Comercial.setPessoas(LtpLib.lerArquivoObjetos("Pessoas.obj"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(1);
			}
		}
		if (new File("Produtos.obj").exists()) {
			try {
				Comercial.setProdutos(LtpLib.lerArquivoObjetos("Produtos.obj"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(2);
			}
		}
		if (new File("Compras.obj").exists()) {
			try {
				Comercial.setCompras(LtpLib.lerArquivoObjetos("Compras.obj"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(3);
			}
		}
		if (new File("Vendas.obj").exists()) {
			try {
				Comercial.setVendas(LtpLib.lerArquivoObjetos("Vendas.obj"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(4);
			}
		}
	}
	
	/**
	 * Descri��o: M�todo Para Gravar Arquivos de Objetos
	 */
	private static void gravarArquivo(){
		try {
			LtpLib.gravarArquivoObjetos("Pessoas.obj", Comercial.getPessoas());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(5);
		}
		try {
			LtpLib.gravarArquivoObjetos("Produtos.obj", Comercial.getProdutos());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(6);
		}
		try {
			LtpLib.gravarArquivoObjetos("Compras.obj", Comercial.getCompras());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(7);
		}
		try {
			LtpLib.gravarArquivoObjetos("Vendas.obj", Comercial.getVendas());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(8);
		}
	}
	
	/**
	 * Descri��o: M�todo menu - Faz a conex�o com o usu�rio
	 */
	private static void menu() {
		int opcao,opcao2 = 0;
		
		do {
			System.out.println("\nSISCOM\n");

			System.out.println("1-Menu Cliente");
			System.out.println("2-Menu Vendedor");
			System.out.println("3-Menu Fornecedor");
			System.out.println("4-Menu Produto");
			System.out.println("5-Compras");
			System.out.println("6-Vendas");
			System.out.println("7-Estatisticas");
			System.out.println("8-Prova");
			System.out.println("0-Sair do aplicativo");

			opcao = Console.readInt("\nOp��o: ");

			switch (opcao) {
			case 1:
				do {
					System.out.println("\nMenu Cliente\n");
					System.out.println("1-Incluir Cliente");
					System.out.println("2-Excluir Cliente");
					System.out.println("3-Consultar Cliente por CPF");
					System.out.println("4-Listar Clientes");
					System.out.println("0-Voltar ao Menu Principal");

					opcao2 = Console.readInt("\nOp��o: ");
					switch (opcao2) {
					case 1:
						incluirPessoa(1);
						break;
					case 2:
						excluirPessoa(1);
						break;
					case 3:
						consultarCPF(1);
						break;
					case 4:
						listarPessoas(1);
						break;
					case 0:
						break;
					default:
						System.out.println("\nOp��o Inv�lida.");
						break;
					}

				} while (opcao2 != 0);

				break;

			case 2:
				do {
					System.out.println("\nMenu Vendedor\n");
					System.out.println("1-Incluir Vendedor");
					System.out.println("2-Excluir Vendedor");
					System.out.println("3-Consultar Vendedor por CPF");
					System.out.println("4-Listar Vendedores");
					System.out.println("0-Voltar ao Menu Principal");

					opcao2 = Console.readInt("\nOp��o: ");

					switch (opcao2) {
					case 1:
						incluirPessoa(2);
						break;
					case 2:
						excluirPessoa(2);
						break;
					case 3:
						consultarCPF(2);
						break;
					case 4:
						listarPessoas(2);
						break;
					case 0:
						break;

					default:
						System.out.println("\nOp��o Inv�lida.");
						break;
					}

				} while (opcao2 != 0);

				break;

			case 3:
				do {
					System.out.println("\nMenu Fornecedor\n");
					System.out.println("1-Incluir Fornecedor");
					System.out.println("2-Excluir Fornecedor");
					System.out.println("3-Consultar Fornecedor por CNPJ");
					System.out.println("4-Listar Fornecedores");
					System.out.println("0-Voltar ao Menu Principal");

					opcao2 = Console.readInt("\nOp��o: ");

					switch (opcao2) {
					case 1:
						incluirPessoa(3);
						break;
					case 2:
						excluirPessoa(3);
						break;
					case 3:
						consultarForneCNPJ();
						break;
					case 4:
						listarPessoas(3);
						break;
					case 0:
						break;
					default:
						System.out.println("\nOp��o Inv�lida.");
						break;
					}
				} while (opcao2 != 0);

				break;

			case 4:
				do {
					System.out.println("\nMenu Produto\n");
					System.out.println("1-Incluir Produto");
					System.out.println("2-Excluir Produto");
					System.out.println("3-Consultar Produto pelo C�digo");
					System.out.println("4-Listar Produtos");
					System.out.println("5-Listar Produtos com estoque abaixo do m�nimo");
					System.out.println("0-Voltar ao Menu Principal");

					opcao2 = Console.readInt("\nOp��o: ");

					switch (opcao2) {
					case 1:
						incluirProduto();
						break;
					case 2:
						excluirProduto();
						break;
					case 3:
						consultarProdutoCod();
						break;
					case 4:
						listarProdutos();
						break;
					case 5:
						listarProdEstoMin();
						break;
					case 0:
						break;
					default:
						System.out.println("\nOp��o Inv�lida.");
						break;
					}
				} while (opcao2 != 0);

				break;

			case 5:
				do {
					System.out.println("\nMenu Compras\n");
					System.out.println("1-Comprar Produto - Fornecedor");
					System.out.println("2-Excluir Compra - Fornecedor");
					System.out.println("3-Listar Compras por Ordem de Fornecedor e Data da Compra Decrescente");
					System.out.println("0-Voltar ao Menu Principal");

					opcao2 = Console.readInt("\nOp��o: ");

					switch (opcao2) {
					case 1:
						comprarProdForne();
						break;
					case 2:
						excluirCompraForne();
						break;
					case 3:
						listarComprasForne();
						break;
					case 0:
						break;
					default:
						System.out.println("\nOp��o Inv�lida.");
						break;
					}
				} while (opcao2 != 0);

				break;

			case 6:
				do {
					System.out.println("\nMenu Vendas\n");
					System.out.println("1-Vender Produto - Cliente");
					System.out.println("2-Excluir Venda - Cliente");
					System.out.println("3-Listar Vendas por Ordem de Cliente e Data da Venda Decrescente");
					System.out.println("4-Listar Vendas por Ordem de Vendedor Data da Venda Decrescente");
					System.out.println("0-Voltar ao Menu Principal");

					opcao2 = Console.readInt("\nOp��o: ");

					switch (opcao2) {
					case 1:
						venderProdCliente();
						break;
					case 2:
						excluirVendaCliente();
						break;
					case 3:
						listarVendas(1);
						break;
					case 4:
						listarVendas(2);
						break;
					case 0:
						break;
					default:
						System.out.println("\nOp��o Inv�lida.");
						break;
					}
				} while (opcao2 != 0);

				break;

			case 7:
				do {
					System.out.println("\nMenu Estat�stica\n");
					System.out.println("1-Estat�stica de Vendas - Agrupado por Cliente por Per�odo de Vendas");
					System.out.println("2-Estat�stica de Vendas - Agrupado por Vendedor por Per�odo de Vendas");
					System.out.println("3-Estat�stica de Compras - Agrupado por Fornecedor por Per�odo de Compras");
					System.out.println("0-Voltar ao Menu Principal");

					opcao2 = Console.readInt("\nOp��o: ");

					switch (opcao2) {
					case 1:
						estatisticaVendas(1);
						break;
					case 2:
						estatisticaVendas(2);
						break;
					case 3:
						estatisticaCompras();
						break;
					case 0:
						break;
					default:
						System.out.println("\nOp��o Inv�lida.");
						break;
					}
				} while (opcao2 != 0);

				break;
			case 8:
				estatisticaProva();
				break;

			case 0:
				break;

			default:
				System.out.println("\nOp��o Inv�lida.");
				break;
			}
		} while (opcao != 0);
	}

	/**
	 * Decri��o: PROVA - Estat�stica de Vendas - Agrupado por Vendedor por M�s/Ano
	 * Dado Auxilar - Vendas naquele M�s,Ano
	 * Resultado - Estat�stica
	 */
	private static void estatisticaProva() {
		System.out.println("\nEstat�stica de Vendas - Agrupado por Vendedor por M�s/Ano\n");
		
		int mes = Console.readInt("Digite o M�s: ");
		int ano = Console.readInt("Digite o Ano: ");

		try {
			for (String resp : Comercial.EstatisticaVendasProva(Comercial.estatisticaVenProva(mes, ano))) {
				System.out.println(resp);
			}
		} catch (SisComException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Decri��o: Estat�stica de Compras - Agrupado por Fornecedor por Per�odo de Compras
	 */
	private static void estatisticaCompras() {

		System.out.println("\nEstat�stica de Compras - Agrupado por Fornecedor por Per�odo de Compras\n");
		
		GregorianCalendar dt = new GregorianCalendar();
		GregorianCalendar dt2 = new GregorianCalendar();
		String data1, data2;

		while (true) {
			data1 = Console.readLine("Per�odo - Data In�cio: (dd/MM/yyyy) ");
			if (LtpLib.validarData(data1,dt))
				break;
			System.out.println("\nData Inv�lida.");
		}
		while (true) {
			data2 = Console.readLine("Per�odo - Data Fim: (dd/MM/yyyy) ");
			if (LtpLib.validarData(data2,dt2))
				break;
			System.out.println("\nData Inv�lida.");
		}

		try {
			for (String estatisticaFornecedores : Comercial.estatisticaFor(
					dt, dt2)) {
				System.out.println(estatisticaFornecedores);
			}
		} catch (SisComException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Decri��o: Estat�stica de Vendas - Agrupado por Cliente ou Vendedor por
	 * Per�odo de Vendas
	 */
	private static void estatisticaVendas(int tipo) {
		if (tipo == 1)
			System.out.println("\nEstat�stica de Vendas - Agrupado por Cliente por Per�odo de Vendas\n");
		else
			System.out.println("\nEstat�stica de Vendas - Agrupado por Vendedor por Per�odo de Vendas\n");
		
		GregorianCalendar dt = new GregorianCalendar();
		GregorianCalendar dt2 = new GregorianCalendar();
		String data1, data2;

		while (true) {
			data1 = Console.readLine("Per�odo - Data In�cio: (dd/MM/yyyy) ");
			if (LtpLib.validarData(data1,dt))
				break;
			System.out.println("\nData Inv�lida.");
		}
		while (true) {
			data2 = Console.readLine("Per�odo - Data Fim: (dd/MM/yyyy) ");
			if (LtpLib.validarData(data2,dt2))
				break;
			System.out.println("\nData Inv�lida.");
		}
		if (tipo == 1) {
			try {
				for (String estatisticaClientes : Comercial.estatisticaCli(
						dt, dt2)) {
					System.out.println(estatisticaClientes);
				}
			} catch (SisComException e) {
				System.out.println(e.getMessage());
			}
		} else if (tipo == 2) {
			try {
				for (String estatisticaVendedores : Comercial.estatisticaVen(
						dt, dt2)) {
					System.out.println(estatisticaVendedores);
				}
			} catch (SisComException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	/**
	 * Decri��o: Listar Vendas por Ordem de Cliente ou Vendedor e Data da Venda Decrescente
	 */
	private static void listarVendas(int tipo) {
		if (tipo == 1) {
			System.out.println("\nListar Vendas por Ordem de Cliente e Data da Venda Decrescente\n");

			try {
				for (Venda obj : Comercial.listarVendasCliente()) {
					System.out.println(obj.toString() + "\n");
				}
			} catch (SisComException e) {
				System.out.println(e.getMessage());
			}

		} else if (tipo == 2) {
			System.out.println("\nListar Vendas por Ordem de Vendedor e Data da Venda Decrescente\n");

			try {
				for (Venda obj : Comercial.listarVendasVendedor()) {
					System.out.println(obj.toString() + "\n");
				}
			} catch (SisComException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * Decri��o: Listar Produtos com Estoque Abaixo do M�nimo
	 */
	private static void listarProdEstoMin() {

		System.out.println("\nListar Produtos com Estoque Abaixo do M�nimo\n");
		try {
			for (Produto obj : Comercial.listarProdutos()) {
				if (obj.getEstoque() < obj.getEstoqueMinimo()) {
					System.out.println(obj.toString() + "\n");
				}
			}
		} catch (SisComException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Decri��o: Excluir Venda para Cliente
	 */
	private static void excluirVendaCliente() {
		System.out.println("\nExcluir Venda para Cliente\n");
		if (!Comercial.getVendas().isEmpty()) {
			listarVendas(1);
			int numVenda = Console.readInt("Digite o n�mero da venda: ");
			for (Venda vend : Comercial.getVendas()) {
				if (vend.getNumVenda() == numVenda) {
					for (ItemVenda itemVenda : vend.getVendaItens()) {
						itemVenda.getProduto().quantProdEstoqueIncre(
								itemVenda.getQuantVenda());
					}
				}
			}
			try {
				Comercial.excluirVendaCliente(numVenda);
				System.out.println("\nVenda Exclu�da com Sucesso.");
			} catch (SisComException e) {
				System.out.println(e.getMessage());
			}
		} else
			System.out.println("N�o existem vendas cadastradas no sistema.");
	}

	/**
	 * Decri��o: Vender Produto Para Cliente
	 */
	private static void venderProdCliente() {
		System.out.println("\nVenda de Produtos\n");

		if (!Comercial.getProdutos().isEmpty()) {

			Vector<Pessoa> resposta = new Vector<Pessoa>();
			Vector<Pessoa> resposta2 = new Vector<Pessoa>();

			for (Pessoa obj : Comercial.getPessoas()) {
				if (obj.tipoPessoa() == Pessoa.CLIENTE) {
					resposta.add(obj);
				}
			}
			for (Pessoa obj : Comercial.getPessoas()) {
				if (obj.tipoPessoa() == Pessoa.VENDEDOR) {
					resposta2.add(obj);
				}
			}
			if (!resposta.isEmpty()) {
				if (!resposta2.isEmpty()) {
					Pessoa objCli, objVen;
					Produto obj;
					int formaPagto, codigoP, controle = 0, controleLimite = 0, quant, codigo, numVenda = 0;
					double valor, totVenda = 0;
					Vector<ItemVenda> vendaItens = new Vector<ItemVenda>();

					formaPagto = Console.readInt("Digite a forma de pagamento: (1 - � vista/ 2 - � prazo)");
					if (formaPagto == 2) {
						System.out.println("\nA Venda n�o pode ser efetuada.");
					} else {
						// Cliente
						while (true) {
							listarPessoas(1);
							codigo = Console.readInt("Digite o C�digo do Cliente: ");
							try {
								objCli = Comercial.consultarCodigo(codigo, 1);
								break;
							} catch (SisComException e) {
								System.out.println(e.getMessage());
							}
						}
						// Produto
						while (true) {
							while (true) {
								listarProdutos();
								codigoP = Console.readInt("Digite o C�digo do Produto: ");
								try {
									obj = Comercial.consultarProdutoCod(codigoP);
									break;
								} catch (SisComException e) {
									System.out.println(e.getMessage());
								}
							}
							// Verificando exist�ncia do produto na lista
							for (ItemVenda itemVenda : vendaItens) {
								if (itemVenda.getProduto().getNome().equals(
										obj.getNome())) {
									System.out.println("\nProduto j� inclu�do na lista.");
									controle = 1;
									break;
								}
							}
							if (controle == 0) {
								// Quantidade de Produto
								while (true) {
									quant = Console.readInt("\nQuantidade: ");
									if (quant > 0)
										break;
									System.out.println("\nQuantidade Incorreta.\n");
								}

								valor = obj.getPrecoUnitario() * quant;

								totVenda = totVenda + valor;

								if (((Cliente) objCli).getLimiteCredito() < totVenda) {
									System.out.println("\nLimite de Cr�dito Insuficiente para Compra.\n");
									if (!vendaItens.isEmpty()) {
										String resp = Console.readLine("Deseja retirar �ltimo produto da lista? S/N");
										if (resp.equals("S")) {
											totVenda = totVenda - valor;
											System.out.println("\nItem Retirado.");
											break;
										}
									} else {
										controleLimite = 1;
										break;
									}
								} else {
									vendaItens.add(new ItemVenda(obj, quant,valor));
									System.out.println("\nProduto adicionado � lista.");
								}
							}

							String sair = Console.readLine("\nDeseja adicionar outro item � lista? S/N");
							if (sair.equals("N"))
								break;
						}
						if (controleLimite == 0) {
							// Vendedor
							while (true) {
								listarPessoas(2);
								codigo = Console.readInt("Digite o C�digo do Vendedor: ");
								try {
									objVen = Comercial.consultarCodigo(codigo,2);
									break;
								} catch (SisComException e) {
									System.out.println(e.getMessage());
								}
							}
							// N�mero da Venda
							numVenda = (Comercial.getVendas().isEmpty() ? 1
							: Comercial.getVendas().lastElement().getNumVenda() + 1);

							Comercial.venderProdCliente(numVenda,
									(Cliente) objCli, (Vendedor) objVen,
									formaPagto, vendaItens);

							System.out.println("\nVenda Efetuada com Sucesso.");

							// Decrementando no Estoque
							for (Venda vend : Comercial.getVendas()) {
								if (vend.getNumVenda() == numVenda) {
									for (ItemVenda itemVenda : vend.getVendaItens()) {
										try {
											itemVenda.getProduto().quantProdEstoqueDecre(itemVenda.getQuantVenda());
										} catch (SisComException e) {
											System.out.println(e.getMessage());

										}
									}
								}
							}
						}
					}
				} else
					System.out.println("N�o existem vendedores cadastrados no sistema.");
			} else
				System.out.println("N�o existem clientes cadastrados no sistema.");
		} else
			System.out.println("N�o existem produtos cadastrados no sistema.");
	}

	/**
	 * Decri��o: Excluir Compra de Fornecedor
	 */
	private static void excluirCompraForne() {
		System.out.println("\nExcluir Compra de Fornecedor\n");
		if (!Comercial.getCompras().isEmpty()) {
			listarComprasForne();
			int numCompra = Console.readInt("\nN�mero da Compra: ");
			for (Compra comp : Comercial.getCompras()) {
				if (comp.getNumCompra() == numCompra) {
					for (ItemCompra itemCompra : comp.getCompraItens()) {
						try {
							itemCompra.getProduto().quantProdEstoqueDecre(
									itemCompra.getQuantCompra());
						} catch (SisComException e) {
							System.out.println(e.getMessage());
						}
					}
				}
			}
			try {
				Comercial.excluirCompraForne(numCompra);
				System.out.println("\nCompra Exclu�da com Sucesso.");
			} catch (SisComException e) {
				System.out.println(e.getMessage());
			}
		} else
			System.out.println("N�o existem compras cadastradas no sistema.");
	}

	/**
	 * Decri��o: Comprar Produto de Fornecedor
	 */
	private static void comprarProdForne() {
		System.out.println("\nComprar Produtos de Fornecedor\n");
		if (!Comercial.getProdutos().isEmpty()) {
			Vector<Pessoa> resposta = new Vector<Pessoa>();
			for (Pessoa obj : Comercial.getPessoas()) {
				if (obj.tipoPessoa() == Pessoa.FORNECEDOR) {
					resposta.add(obj);
				}
			}
			if (!resposta.isEmpty()) {
				Produto obj;
				Fornecedor objFor;
				Vector<ItemCompra> compraItens = new Vector<ItemCompra>();
				int quant, codigoP, codigoF, controle;
				double valor;

				// Produto
				while (true) {
					while (true) {
						listarProdutos();
						codigoP = Console.readInt("Digite o C�digo do Produto: ");
						try {
							obj = Comercial.consultarProdutoCod(codigoP);
							break;
						} catch (SisComException e) {
							System.out.println(e.getMessage());
						}
					}
					// Verificando exist�ncia do produto na lista
					controle = 0;
					for (ItemCompra itemCompra : compraItens) {
						if (itemCompra.getProduto().getNome().equals(obj.getNome())) {
							System.out.println("\nProduto j� inclu�do na lista.\n");
							controle = 1;
							break;
						}
					}
					if (controle == 0) {
						// Quantidade de Produto
						while (true) {
							quant = Console.readInt("\nQuantidade: ");
							if (quant > 0)
								break;
							System.out.println("\nQuantidade Incorreta.\n");
						}

						valor = obj.getPrecoUnitario() * quant;

						compraItens.add(new ItemCompra(obj, quant, valor));

						System.out.println("\nProduto adicionado � lista.");

						// Incrementando no Estoque
						obj.quantProdEstoqueIncre(quant);

						System.out.println("\nQuantidade de " + obj.getNome()
										+ " no Estoque Atualmente: "
										+ obj.getEstoque());

					}
					String sair = Console
							.readLine("\nDeseja adicionar outro item � lista? S/N");
					if (sair.equals("N"))
						break;
				}
				// Fornecedor
				while (true) {
					listarPessoas(3);
					codigoF = Console.readInt("Digite o C�digo do Fornecedor: ");
					try {
						objFor = (Fornecedor) Comercial.consultarCodigo(codigoF, 3);
						break;
					} catch (SisComException e) {
						System.out.println(e.getMessage());
					}
				}

				Comercial.comprarProdForne(objFor, compraItens);

				System.out.println("\nCompra Efetuada com Sucesso.");
			} else
				System.out.println("N�o existem fornecedores cadastrados no sistema.");
		} else
			System.out.println("N�o existem produtos cadastrados no sistema.");
	}

	/**
	 * Decri��o: Listar Produtos
	 */
	private static void listarProdutos() {

		System.out.println("\nListar Produtos\n");

		try {
			for (Produto obj : Comercial.listarProdutos()) {
				System.out.println(obj.toString() + "\n");
			}
		} catch (SisComException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Decri��o: Listar Compras por Ordem de Fornecedor e Data da Compra Decrescente
	 */
	private static void listarComprasForne() {

		System.out.println("\nListar Compras por Ordem de Fornecedor e Data da Compra Decrescente\n");

		try {
			for (Compra obj : Comercial.listarComprasForne()) {
				System.out.println(obj.toString() + "\n");
			}
		} catch (SisComException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Decri��o: Listar Pessoas
	 * @param tipo
	 */
	private static void listarPessoas(int tipo) {

		if (tipo == 1) {
			System.out.println("\nListar Clientes\n");
			try {
				for (Pessoa obj : Comercial.listarPessoas()) {
					if (obj.tipoPessoa() == Pessoa.CLIENTE)
						System.out.println(obj.toString() + "\n");
				}
			} catch (SisComException e) {
				System.out.println(e.getMessage());
			}

		} else if (tipo == 2) {
			System.out.println("\nListar Vendedores\n");
			try {
				for (Pessoa obj : Comercial.listarPessoas()) {
					if (obj.tipoPessoa() == Pessoa.VENDEDOR)
						System.out.println(obj.toString() + "\n");
				}
			} catch (SisComException e) {
				System.out.println(e.getMessage());
			}
		} else if (tipo == 3) {
			System.out.println("\nListar Fornecedores\n");
			try {
				for (Pessoa obj : Comercial.listarPessoas()) {
					if (obj.tipoPessoa() == Pessoa.FORNECEDOR)
						System.out.println(obj.toString() + "\n");
				}
			} catch (SisComException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	/**
	 * Decri��o: Excluir Produto
	 */
	private static void excluirProduto() {

		System.out.println("\nExcluir Produto\n");
		if (!Comercial.getProdutos().isEmpty()) {
			int codigo;
			codigo = Console.readInt("Digite o c�digo: ");
			try {
				Comercial.excluirProduto(codigo);
				System.out.println("\nProduto Exclu�do com Sucesso.");
			} catch (SisComException e) {
				System.out.println(e.getMessage());
			}
		} else
			System.out.println("N�o existem produtos cadastrados no sistema.");
	}

	/**
	 * Decri��o: Cadastrar Produto
	 */
	private static void incluirProduto() {

		System.out.println("\nCadastrar Produto\n");

		// Nome
		String nome;
		while (true) {
			nome = Console.readLine("Nome: ");
			if (!nome.equals(""))
				break;
			System.out.println("\nInforme o nome.\n");
		}

		// Pre�o Unit�rio
		double precoUnitario;
		while (true) {
			precoUnitario = Console.readDouble("Pre�o Unit�rio: ");
			if (precoUnitario > 0)
				break;
			System.out.println("\nPre�o Unit�rio Inconreto.\n");
		}

		// Estoque
		int estoque;
		while (true) {
			estoque = Console.readInt("Estoque: ");
			if (estoque > 0)
				break;
			System.out.println("\nEstoque Incorreto.\n");
		}

		// Estoque M�nimo
		int estoqueMinimo;
		while (true) {
			estoqueMinimo = Console.readInt("Estoque M�nimo: ");
			if (estoqueMinimo > 0)
				break;
			System.out.println("\nEstoque M�nimo Incorreto.\n");
		}

		// Data de Cadastro
		GregorianCalendar dataCad = new GregorianCalendar();

		// C�digo
		int codigo = (Comercial.getProdutos().isEmpty() ? 1 : Comercial
				.getProdutos().lastElement().getCodigo() + 1);

		Comercial.incluirProduto(new Produto(codigo, nome, precoUnitario,
				estoque, estoqueMinimo, dataCad));
		System.out.println("\nProduto Cadastrado com Sucesso.");
	}

	/**
	 * Decri��o: Consultar Produto pelo C�digo
	 */
	private static void consultarProdutoCod() {

		System.out.println("\nConsultar Produto pelo C�digo\n");
		if (!Comercial.getProdutos().isEmpty()) {
			int codigo;
			codigo = Console.readInt("Digite o c�digo: ");
			try {
				System.out.println(Comercial.consultarProdutoCod(codigo).toString());
			} catch (SisComException e) {
				System.out.println(e.getMessage());
			}
		} else
			System.out.println("N�o existem produtos cadastrados no sistema.");

	}

	/**
	 * Decri��o: Excluir Cliente, Fornecedor ou Vendedor
	 * @param tipo
	 */
	private static void excluirPessoa(int tipo) {

		Vector<Pessoa> resposta = new Vector<Pessoa>();
		int controle = 0;
		if (tipo == 1) {

			System.out.println("\nExcluir Cliente\n");
			for (Pessoa obj : Comercial.getPessoas()) {
				if (obj.tipoPessoa() == Pessoa.CLIENTE) {
					resposta.add(obj);
				}
			}
			if (!resposta.isEmpty()) {
				listarPessoas(1);
				String cpf;
				while (true) {
					cpf = Console.readLine("CPF: ");
					if (LtpLib.validarCPF(cpf))
						break;
					System.out.println("CPF Inv�lido!");
				}
				for (Pessoa obj : resposta) {

					if (((Cliente) obj).getCpf().equals(cpf)) {
						try {
							Comercial.excluirPessoa(obj);
							System.out.println("\nCliente Exclu�do com Sucesso.");
						} catch (SisComException e) {
							System.out.println(e.getMessage());
						}
						controle = 1;
					}
				}
				if(controle == 0)
					System.out.println("\nCPF n�o encontrado.");
			} else
				System.out.println("N�o existem clientes cadastrados no sistema.");
		} else if (tipo == 2) {

			System.out.println("\nExcluir Vendedor\n");
			for (Pessoa obj : Comercial.getPessoas()) {
				if (obj.tipoPessoa() == Pessoa.VENDEDOR) {
					resposta.add(obj);
				}
			}
			if (!resposta.isEmpty()) {
				listarPessoas(2);
				String cpf;
				while (true) {
					cpf = Console.readLine("CPF: ");
					if (LtpLib.validarCPF(cpf))
						break;
					System.out.println("CPF Inv�lido!");
				}
				for (Pessoa obj : resposta) {

					if (((Vendedor) obj).getCpf().equals(cpf)) {
						try {
							Comercial.excluirPessoa(obj);
							System.out.println("\nVendedor Exclu�do com Sucesso.");
						} catch (SisComException e) {
							System.out.println(e.getMessage());
						}
						controle = 1;
					}
				}
				if(controle == 0)
					System.out.println("\nCPF n�o encontrado.");

			} else
				System.out.println("N�o existem vendedores cadastrados no sistema.");
		} else if (tipo == 3) {

			System.out.println("\nExcluir Fornecedor\n");
			for (Pessoa obj : Comercial.getPessoas()) {
				if (obj.tipoPessoa() == Pessoa.FORNECEDOR) {
					resposta.add(obj);
				}
			}
			if (!resposta.isEmpty()) {
				listarPessoas(3);
				String cnpj;
				while (true) {
					cnpj = Console.readLine("CNPJ: ");
					if (LtpLib.validarCNPJ(cnpj))
						break;
					System.out.println("CNPJ Inv�lido!");
				}

				for (Pessoa obj : resposta) {

					if (((Fornecedor) obj).getCnpj().equals(cnpj)) {
						try {
							Comercial.excluirPessoa(obj);
							System.out.println("\nFornecedor Exclu�do com Sucesso.");
						} catch (SisComException e) {
							System.out.println(e.getMessage());
						}
						controle = 1;
					}
				}
				if(controle == 0)
					System.out.println("\nCNPJ n�o encontrado.");
			} else
				System.out.println("N�o existem fornecedores cadastrados no sistema.");
		}
	}

	/**
	 * Decri��o: Consultar Cliente ou Vendedor pelo CPF
	 */
	private static void consultarCPF(int tipo) {
		Vector<Pessoa> resposta = new Vector<Pessoa>();
		String cpf;
		if (tipo == 1) {
			System.out.println("\nConsultar Cliente pelo CPF\n");
			for (Pessoa obj : Comercial.getPessoas()) {
				if (obj.tipoPessoa() == Pessoa.CLIENTE) {
					resposta.add(obj);
				}
			}
			if (!resposta.isEmpty()) {
				while (true) {
					cpf = Console.readLine("CPF: ");
					if (LtpLib.validarCPF(cpf))
						break;
					System.out.println("\nCPF Inv�lido!");
				}

				try {
					System.out.println(Comercial.consultarCPF(cpf, 1).toString());
				} catch (SisComException e) {
					System.out.println(e.getMessage());
				}
			} else
				System.out.println("N�o existem clientes cadastrados no sistema.");
		} else if (tipo == 2) {
			System.out.println("\nConsultar Vendedor pelo CPF\n");
			for (Pessoa obj : Comercial.getPessoas()) {
				if (obj.tipoPessoa() == Pessoa.VENDEDOR) {
					resposta.add(obj);
				}
			}
			if (!resposta.isEmpty()) {
				while (true) {
					cpf = Console.readLine("CPF: ");
					if (LtpLib.validarCPF(cpf))
						break;
					System.out.println("\nCPF Inv�lido!");
				}
				try {
					System.out.println(Comercial.consultarCPF(cpf, 2)
							.toString());
				} catch (SisComException e) {
					System.out.println(e.getMessage());
				}
			} else
				System.out.println("N�o existem vendedores cadastrados no sistema.");
		}
	}

	/**
	 * Decri��o: Consultar Fornecedor pelo CNPJ
	 */
	private static void consultarForneCNPJ() {

		System.out.println("\nConsultar Fornecedor pelo CNPJ\n");
		Vector<Pessoa> resposta = new Vector<Pessoa>();
		String cnpj;
		for (Pessoa obj : Comercial.getPessoas()) {
			if (obj.tipoPessoa() == Pessoa.FORNECEDOR) {
				resposta.add(obj);
			}
		}
		if (!resposta.isEmpty()) {
			while (true) {
				cnpj = Console.readLine("CNPJ: ");
				if (LtpLib.validarCNPJ(cnpj))
					break;
				System.out.println("CNPJ Inv�lido!");
			}

			try {
				System.out.println(Comercial.consultarCNPJ(cnpj).toString());
			} catch (SisComException e) {
				System.out.println(e.getMessage());
			}
		} else
			System.out.println("N�o existem fornecedores cadastrados no sistema.");
	}

	/**
	 * Decri��o: Cadastrar Cliente, Fornecedor ou Vendedor
	 * @param tipo
	 */
	private static void incluirPessoa(int tipo) {
		if (tipo == 1) {
			System.out.println("\nCadastrar Cliente\n");
		} else if (tipo == 2) {
			System.out.println("\nCadastrar Vendedor\n");
		} else if (tipo == 3) {
			System.out.println("\nCadastrar Fornecedor\n");
		}

		// Nome
		String nome;
		while (true) {
			nome = Console.readLine("Nome: ");
			if (!nome.equals(""))
				break;
			System.out.println("\nInforme o nome.\n");
		}

		// E-Mail
		String email;
		while (true) {
			email = Console.readLine("e-Mail: ");
			if (LtpLib.validarEmail(email))
				break;
			System.out.println("\nE-Mail incorreto.\n");
		}

		// Telefone
		String telefone;
		while (true) {
			telefone = Console.readLine("Telefone: ");
			if (!telefone.equals(""))
				break;
			System.out.println("\nInforme o Telefone.\n");
		}

		// C�digo
		int codigo = (Comercial.getPessoas().isEmpty() ? 1 : Comercial
				.getPessoas().lastElement().getCodigo() + 1);

		// Data de Cadastro
		GregorianCalendar dataCad = new GregorianCalendar();

		if (tipo == 1) {

			// Cadastro De Cliente
			double limiteCredito = 0;
			while (true) {
				limiteCredito = Console.readDouble("Limite de Cr�dito: ");
				if (limiteCredito > 0)
					break;
				System.out.println("\nLimite de Cr�dito Inv�lido!\n");
			}
			String cpf;
			while (true) {
				cpf = Console.readLine("CPF: ");
				if (LtpLib.validarCPF(cpf))
					break;
				System.out.println("\nCPF Inv�lido!\n");
			}
			try {
				Comercial.incluirPessoa(new Cliente(codigo, nome, telefone,
						email, dataCad, cpf, limiteCredito));
				System.out.println("\nCliente Cadastrado com Sucesso.");
			} catch (SisComException e) {
				System.out.println(e.getMessage());
			}
		} else if (tipo == 2) {

			// Cadastro de Vendedor
			double metaMensal = 0;
			while (true) {
				metaMensal = Console.readDouble("Meta Mensal: ");
				if (metaMensal > 0)
					break;
				System.out.println("\nMeta Mensal Inv�lida.\n");
			}
			String cpf;
			while (true) {
				cpf = Console.readLine("CPF: ");
				if (LtpLib.validarCPF(cpf))
					break;
				System.out.println("\nCPF Inv�lido!\n");
			}
			try {
				Comercial.incluirPessoa(new Vendedor(codigo, nome, telefone,
						email, dataCad, cpf, metaMensal));
				System.out.println("\nVendedor Cadastrado com Sucesso.");
			} catch (SisComException e) {
				System.out.println(e.getMessage());
			}
		} else if (tipo == 3) {

			// Cadastro de Fornecedor
			String cnpj;
			while (true) {
				cnpj = Console.readLine("CNPJ: ");
				if (LtpLib.validarCNPJ(cnpj))
					break;
				System.out.println("\nCNPJ Inv�lido!\n");
			}

			String nomeContato;
			while (true) {
				nomeContato = Console.readLine("Nome de Contato: ");
				if (!nomeContato.trim().equals(""))
					break;
				System.out.println("\nNome Inv�lido.\n");
			}

			try {
				Comercial.incluirPessoa(new Fornecedor(codigo, nome, telefone,
						email, dataCad, cnpj, nomeContato));
				System.out.println("\nFornecedor Cadastrado com Sucesso.");
			} catch (SisComException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
