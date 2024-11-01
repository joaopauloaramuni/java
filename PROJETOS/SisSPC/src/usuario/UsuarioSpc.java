package usuario;

import java.io.File;
import java.util.GregorianCalendar;
import java.util.Vector;

import modelo.Devedor;
import modelo.Divida;
import modelo.Estabelecimento;
import utilitarios.Console;
import utilitarios.LtpLib;
import cadastro.Cadastro;
import erros.SisSPCException;

public class UsuarioSpc {
	
    public static Cadastro objCad = new Cadastro();
    
	public static void main(String[] args) {
		
		// Ler Cadastro de Empresas e Devedores
		if (new File("Empresas.obj").exists()) {
			try {
				objCad.setListaEmpresas(LtpLib.lerArquivoObjetos("Empresas.obj"));
				objCad.setListaDevedores(objCad.convVectorHashMap(LtpLib.lerArquivoObjetos("Devedores.obj")));	
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(1);
			}
		}
		
		menu();
		
		// Gravar Cadastro de Empresas e Devedores
		try {
			LtpLib.gravarArquivoObjetos("Empresas.obj", objCad.getListaEmpresas());
			LtpLib.gravarArquivoObjetos("Devedores.obj", objCad.convHashMapVector());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		// Finalizar
		System.out.println("Final de SisSPC");
		System.exit(0);
		
	}
	private static void menu() {
		int opcao = 0;
		do {
			System.out.println("\nMenu SisSpc");
			System.out.println("1-Cadastrar Empresa");
			System.out.println("2-Excluir Empresa");
			System.out.println("3-Listar as empresas pelo nome");
			System.out.println("4-Consultar Spc pelo Cpf");
			System.out.println("5-Consultar Spc pelo nome");
			System.out.println("6-Cadastrar Dívida/Devedor");
			System.out.println("7-Excluir Dívida/Devedor");
			System.out.println("0-Sair do SisSpc");
			opcao = Console.readInt("Opção: ");
			switch (opcao) {
				case 1:
					cadastrarEmpresa();
					break;
				case 2:
					excluirEmpresa();
					break;	
				case 3:
					listarEmpresasNome();
					break;
				case 4:
					consultarSPCCPF();
					break;
				case 5:
					consultarSPCNome();
					break;					
				case 6:
					cadastrarSPC();
					break;	
				case 7:
					excluirSPC();
					break;	
					
				case 0:
					break;	
				default:
					System.out.println("Opção Inválida.");
					break;
			}
		} while (opcao!=0);
		
	}
	
	private static void listarEmpresasNome() {
		System.out.println("\nListar as Empresas pelo Nome\n");
		try {
			String nome = Console.readLine("Nome da Empresa : ");
			System.out.println("--------\n");
			for (Estabelecimento obj : objCad.listaEmpresaNome(nome)) {
				System.out.println(obj.toString());
			}			
		} catch (SisSPCException e) {
			System.out.println(e.getMessage());
		}

		
	}
	
	private static void excluirEmpresa() {
		System.out.println("\nExcluir Empresa\n");
		try {
			String cnpj = Console.readLine("CNPJ : ");
			System.out.println(objCad.consultarEmpCnpj(cnpj).toString());
			if (Console.readLine("Confirmar a exclusão?(S/N) ").toUpperCase().equals("S")) {
				objCad.excluirEmpresa(cnpj);
				System.out.println("Empresa excluída.");
			}
			
		} catch (SisSPCException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private static void cadastrarEmpresa() {
		System.out.println("\nCadastrar Empresa\n");
		String cnpj = "";
		String nome = "";
		do {
			cnpj = Console.readLine("CNPJ : ");
			if (LtpLib.validarCNPJ(cnpj))
				break;
			else System.out.println("CNPJ inválido.");
		} while (true);
		do {
			nome = Console.readLine("Nome : ");
			if (nome.trim().equals(""))
				System.out.println("Falta informar o nome.");
			else break;
		} while (true);
		try {
			objCad.addEmpresa(new Estabelecimento(cnpj, nome));
			System.out.println("Empresa cadastrada.");
		} catch (SisSPCException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Método cadastrarSPC
	 */
	private static void cadastrarSPC() {
		  System.out.println("\n--- Cadastrar SPC ---\n");

		  // Devedor

		  String cpf = "";

		  // CPF
		  do {
			  cpf = Console.readLine("CPF...: ");
			  if (cpf.equals("")) return;   // P/ Vazio ? -> retornar
			  if  ( !cpf.matches("[0-9]*") || !LtpLib.validarCPF(cpf) ) {
				  System.out.println("CPF Inválido.");
				  continue;
			  }
			  break;
		  } while (true);
		  Devedor objDev = null;
		  // NOME
		  String nome = "";		  
		  try {
			objDev = objCad.consultarSpcCpf(cpf);
			System.out.println("Nome : " + objDev.getNome());
    	  } catch (SisSPCException e) {
    		  do  {
    			  nome = LtpLib.padronizarTexto(Console.readLine("Nome..: "));
    			  if (!nome.equals("")) break;    // Campo <> vazio?
    			  System.out.println("Nome Inválido.");
    		  } while (true);
    		  objDev = new Devedor(cpf, nome);
		  }

		  // Dados da Dívida

		  // Empresa

		  String cnpj = "";
		  Estabelecimento empresa;
		  // CNPJ
		  do {
			  cnpj = Console.readLine("CNPJ..: ");
			  if (cnpj.equals("")) return;   // P/ Vazio ? -> retornar
			  if  ( !cnpj.matches("[0-9]*") || !LtpLib.validarCNPJ(cnpj) ) {
				  System.out.println("CNPJ Inválido.");
				  continue;
			  }

			  try {
				  empresa = objCad.consultarEmpCnpj(cnpj);
			  } catch (SisSPCException e) {
				  System.out.println(e.getMessage());
				  return;
			  }

			  break;
		  } while (true);

		  // Identificação do débito
		  String ident = "";
		  do  {
			  ident = LtpLib.padronizarTexto(Console.readLine("Id.Débito.: "));
			  if (!ident.equals("")) break;    // Campo <> vazio?
			  System.out.println("Identificação Inválida.");
		  } while (true);



		  // Data de Vencimento

		  String vencimento;
		  GregorianCalendar dt = new GregorianCalendar();
		  do {
			  vencimento = Console.readLine("Data Vencimento (dd/mm/aaaa) : ");
			  if (!vencimento.equals("") && LtpLib.validarData(vencimento, dt)) break;
			  System.out.println("Data Inválida");
		  } while (true);


         //	Valor do Dívida
	     double valor = 0;
	     do {
	    	 valor = Console.readDouble("Valor da Dívida..: ");
	    	 if (valor > 0) break;
	    	 System.out.println("Valor Inválido.");
	     } while(true);

	     try {
	    	 objCad.addSpc(objDev, new Divida(empresa,ident,dt,valor, new GregorianCalendar()));
		     Console.readLine("\n" + "Registro incluído no SPC.");
	     } catch (SisSPCException e) {
			  System.out.println(e.getMessage());
	     }

	}

	/**
	 * Método excluirSPC
	 */
	private static void excluirSPC() {
		  System.out.println("\n--- Excluir Registro do SPC ---\n");

		  // Devedor

		  String cpf = "";
		  Devedor objDev = null;
		  // CPF
		  do {
			  cpf = Console.readLine("CPF...: ");
			  if (cpf.equals("")) return;   // P/ Vazio ? -> retornar
			  if  ( !cpf.matches("[0-9]*") || !LtpLib.validarCPF(cpf) ) {
				  System.out.println("CPF Inválido.");
				  continue;
			  }
			  try {
				  objDev = objCad.consultarSpcCpf(cpf);
			  } catch (SisSPCException e) {
				System.out.println(e.getMessage());
				continue;
			  }
			  System.out.println("Nome : " + objDev.getNome());
			  break;
		  } while (true);

		  // Empresa

		  String cnpj = "";
		  Estabelecimento objEmp = null;
		  // CNPJ
		  do {
			  cnpj = Console.readLine("CNPJ..: ");
			  if (cnpj.equals("")) return;   // P/ Vazio ? -> retornar
			  if  ( !cnpj.matches("[0-9]*") || !LtpLib.validarCNPJ(cnpj) ) {
				  System.out.println("CNPJ Inválido.");
				  continue;
			  }
			  try {
				  objEmp = objCad.consultarEmpCnpj(cnpj);
			  } catch (SisSPCException e) {
				System.out.println(e.getMessage());
				continue;
			  }
			  System.out.println("Nome Empresa : " + objEmp.getNomeEmpresa());			  
			  break;
		  } while (true);

		  // Identificação do débito
		  String ident = "";
		  do  {
			  ident = LtpLib.padronizarTexto(Console.readLine("Id.Débito.: "));
			  if (!ident.equals("")) break;    // Campo <> vazio?
			  System.out.println("Identificação Inválida.");
		  } while (true);

          try {
        	   Divida objDiv = objDev.consDivida(objEmp,ident); 
        	   objCad.excluirSpc(objDev, objDiv); 
	      } catch (SisSPCException e) {
			   System.out.println(e.getMessage());
			   return;
	      }

	     Console.readLine("\n" + "Registro excluído no SPC.");
	}

	/**
	 * Método consultarSPCCPF
	 */
	private static void consultarSPCCPF() {
		  System.out.println("\n--- Consultar o SPC pelo CPF ---\n");

		  // Devedor

		  String cpf = "";
		  // CPF
		  do {
			  cpf = Console.readLine("CPF...: ");
			  if (cpf.equals("")) return;   // P/ Vazio ? -> retornar
			  if  ( !cpf.matches("[0-9]*") || !LtpLib.validarCPF(cpf) ) {
				  System.out.println("CPF Inválido.");
				  continue;
			  }
			  break;
		  } while (true);

		  try {
	    	 Devedor dev = objCad.consultarSpcCpf(cpf);
	    	 System.out.println("----------\n");
	    	 System.out.println(dev.toString());
	    	 double totDivida = 0;
	    	 int totReg = 0;
	    	 for (Divida  div : dev.getListaDividas() ) {
	    		 System.out.println(div.toString());
	    		 totReg++;
	    		 totDivida += div.getValor();
	    	 }
	    	 if (totReg > 1) {
	    		 System.out.println("\nQuantidade de registros : " + totReg + 
	    				 " Total da divida: " + LtpLib.formatarValor(totDivida, "R$#,##0.00"));
	    	 }
	      } catch (SisSPCException e) {
	    	  Console.readLine("\n" +e.getMessage());
			  return;
	      }

	      Console.readLine("\n" + "Consulta concluida no SPC.");

	}

	/**
	 *  Método consultarSPCNome
	 */
	private static void consultarSPCNome() {
		  System.out.println("\n--- Consultar o SPC pelo Nome ---\n");
		  // NOME
		  String nome = Console.readLine("Nome : ");

		  try {
			  Vector<Devedor> dev = objCad.consultarSpcNome(nome);
			  System.out.println("----------\n");
		    	 for (Devedor  devedor : dev ) {
		    		 System.out.println(devedor.toString());
		    		 for (Divida div : devedor.getListaDividas())
		    		      System.out.println(div.toString());
		    	 }
		      } catch (SisSPCException e) {
		    	  Console.readLine("\n" +e.getMessage());
				  return;
		      }

		      Console.readLine("\n" + "Consulta concluida no SPC.");
	}

	
}









