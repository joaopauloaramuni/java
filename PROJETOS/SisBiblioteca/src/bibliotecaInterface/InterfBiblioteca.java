package bibliotecaInterface;

import java.io.File;
import java.util.GregorianCalendar;
import java.util.Vector;
import utilitarios.Console;
import utilitarios.LtpLib;
import cadastro.Biblioteca;
import cadastro.Emprestimo;
import cadastro.Livro;
import cadastro.Usuario;
import cadastro.ErrosNegocioException;

/**
 * Classe InterfBiblioteca
 */
public class InterfBiblioteca 
{
	// Atributos
	private static Biblioteca bibliotecaObj = new Biblioteca(); 
	
	/**
	 * Main
	* @param args
	*/
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		// ler arquivo de funcionarios
		try {
			if (new File("TabBiblioteca.obj").exists())
			{
				bibliotecaObj.setListaLivro((Vector<Livro>)LtpLib.lerArquivoObjetos("CadLivro.obj"));
				bibliotecaObj.setListaUsuario(((Vector<Usuario>)LtpLib.lerArquivoObjetos("CadUsuario.obj")));
				bibliotecaObj.setListaEmprestimo(((Vector<Emprestimo>)LtpLib.lerArquivoObjetos("CadEmprestimo.obj")));
			}
			} catch (Exception e) 
			      {
				    System.out.println(e.getMessage());
				    System.exit(1); // terminar
			      }
			//MENU
			menu();
			
			// Gravar objetos 
			try {
				LtpLib.gravarArquivoObjetos("CadLivro.obj", bibliotecaObj.getListaLivro());
				LtpLib.gravarArquivoObjetos("CadUsuario.obj", bibliotecaObj.getListaUsuario());
				LtpLib.gravarArquivoObjetos("CadEmprestimo.obj", bibliotecaObj.getListaEmprestimo());
			
			} catch (Exception e) 
			      {
				    System.out.println(e.getMessage());
				    System.exit(1); // terminar
			      }
			System.out.println("\nPrograma Encerrado.");
			System.exit(0); // terminar

		}

		/**
		 * Menu
		 */
		private static void menu() 
		{
			int opcao=0;
			do {
				System.out.println("\nMenu ");
				System.out.println("1-Cadastrar Usuario");
				System.out.println("2-Excluir Usuario");
				System.out.println("3-Listar Usuario por CPF");
				System.out.println("4-Listar Usuario por Nome");
				System.out.println("5-Cadastrar Livro");
				System.out.println("6-Excluir Livro");
				System.out.println("7-Alterar Quantidade de Livro");
				System.out.println("8-Listar os Livros Pelo Codigo");
				System.out.println("9-Listar os Livros Pelo Titulo");
				System.out.println("10-Listar os Livros Pelo Autor");
				System.out.println("11-Fazer Emprestimo do Livro");
				System.out.println("12-Remover Livro Lançado Errado no Emprestimo");
				System.out.println("13-Devolver Livro do Emprestimo");
				System.out.println("14-Devolver Todos os Livros do Emprestimo");
				System.out.println("15-Consultar Emprestimo por Codigo");
				System.out.println("16-Consultar Emprestimo por Periodo");
				System.out.println("17-Consultar Emprestimo por Titulo do Livro");
				System.out.println("18-Lista Emprestimo por Usuario");
				System.out.println("0-Sair");
				opcao = Console.readInt("\nOpção: ");
				switch (opcao) {
					case 1:
						cadastrarUsuario();
						break;
					case 2:
						excluirUsuario();
						break;
					case 3:
						listarUsuarioCpf();
						break;
					case 4:
						listarUsuarioNome();
						break;	
					case 5:
						cadastrarLivro();
						break;
					case 6:
						excluirLivro();
						break;	
					case 7:
						alterarQuantLivro();
						break;	
					case 8:
						listarLivroCodigo();
			     		break;	
					case 9:
						listarLivroNome();
			     		break;
					case 10:
						listarLivroAutor();
			     		break;		     		
					case 11:
						cadastrarEmprestimo();
						break;
					case 12:
						removerEmprestimo();
						break;
					case 13:
						devolverEmprestimo();
						break;
					case 14:
						devolverTodosEmprestimo();
					    break;
					case 15:
					    consultarEmprestimoCodigo();
					    break;
					case 16:					    
					    consultarEmprestimoPeriodo();
					    break;
					case 17:    
					    listarEmprestimoTitulo();
					    break;
					case 18:    
					    listarEmprestimoUsuarioPeriodo(); 
					    break;
					case 0:
						break;
					default:
						System.out.println("Opção Inválida.");
						break;
				}
			} while (opcao!=0);
			
		}


		/**
		 * Cadastrar Pessoas
		 */
		private static void cadastrarUsuario() 
		{
			System.out.println("\nCadastrar Usuario\n");
			
			String nome;
			do {
				nome = LtpLib.padronizarTexto(Console.readLine("Nome: "));
				if (!nome.equals("")) break;
				System.out.println("Falta informar o nome.");
			   } while (true);
			
			String cpf = "";
			do {
				cpf = Console.readLine("CPF : ");
				if (LtpLib.validarCPF(cpf)) break;
				System.out.println("CPF inválido.");
			} while (true);
			
			
			String logradouro;
			do {
				  logradouro  = LtpLib.padronizarTexto(Console.readLine("Endereço: "));
				  if (!logradouro.equals("")) break;
				  System.out.println("Falta informar o Endereço.");// Campo vazio
			  }	while (true);


			int numero = 0;
			do
			{
				numero = Console.readInt("Numero: ");
				if(numero != ' ') break;
				System.out.println("Falta informar o Numero.");// Campo vazio
				
			}while(true);
			
			
			String complemento = LtpLib.padronizarTexto(Console.readLine("Complemento : "));

			
			String bairro;
			do {
				bairro = LtpLib.padronizarTexto(Console.readLine("Bairro: ").trim());
				if (!bairro.equals("")) break;
				System.out.println("Falta informar o Bairro.");
			} while (true);
			
			
			String cep;
			do {
				cep = Console.readLine("Cep: ").trim();
				if (!bairro.equals("") || (cep.length() != 8)) break;
				System.out.println("Cep Incorreto.");
			} while (true);
			
			
			String cidade;
			do {
				cidade = LtpLib.padronizarTexto(Console.readLine("Cidade: "));
				if (!cidade.equals("")) break;
				System.out.println("Falta informar a Cidade.");
			} while (true);
			
			
			String estado;
			do {
				estado = LtpLib.padronizarTexto(Console.readLine("Estado: "));
				if (!estado.equals("")) break;
				System.out.println("Falta informar o Estado.");
			} while (true);
			
			
			String telefone;
			do {
				 telefone = Console.readLine("Telefone: ").trim();
				 if (!telefone.equals("")) break;
				 System.out.println("Falta informar o telefone.");
			    } while (true);
			
			
			String email;
			do {
				 email = Console.readLine("Email: ").trim();
				 if (!email.equals("")) break;
				 System.out.println("Falta informar o email.");
			   } while (true);
			
			
	
			try 
			   {
			    bibliotecaObj.incluirUsuario(new Usuario(cpf, nome, logradouro, numero, complemento, bairro, cep, cidade, estado, telefone, email, new GregorianCalendar()));
			    System.out.println("Usuario cadastrado com sucesso.");
			   }catch (ErrosNegocioException e)
			        {
					  System.out.println(e.getMessage());
					  return;
				     }
		    Console.readLine("<ENTER>");
		  }


		private static void excluirUsuario()
		{
			System.out.println("--- Excluir Usuario ---");
			String cpf = "";
			  
			do {
				  cpf = Console.readLine("CPF....: ");
				  if (cpf.equals("")) return;           // P/ Vazio ? -> retornar
				  if  (!cpf.matches("[0-9]*") || !LtpLib.validarCPF(cpf) ) 
				  {
					  System.out.println("CPF Inválido.");
				  } else break;
			  } while (true);
			  
			  try {
				   bibliotecaObj.consultarUsuarioCPF(cpf);
				   System.out.println(bibliotecaObj.getListaUsuario().toString());
				  
		           if(Console.readLine("Confirmar a Exclusão (s/n) ? : ").equalsIgnoreCase("s"))
				      {
					     bibliotecaObj.excluirUsuario(cpf);
					     System.out.println("Usuario Excluído!");
				        }
				     }catch (ErrosNegocioException e)
			              {
				            System.out.println(e.getMessage());
			              }
			  Console.readLine("\n<Enter>\n");

		}
					
				
		private static void listarUsuarioCpf()
		{
			
			  System.out.println("--- Listar Usuario ---");
			  String cpf ;
			  
			  // CPF do Usuario
			  do {
				  cpf = Console.readLine("CPF....: ");
				  if (cpf.equals("")) return;           // P/ Vazio ? -> retornar
				  if  ( !cpf.matches("[0-9]*") || !LtpLib.validarCPF(cpf) ) {
					  System.out.println("CPF Inválido.");
				  } else break;
			  } while (true);
			  
			  try {
				    bibliotecaObj.consultarUsuarioCPF(cpf);
				    System.out.println("\n--- Dados do  ---\n");
				    System.out.println(bibliotecaObj.getListaUsuario().toString());
     			  } catch( Exception e ) {
				  System.out.println(e.getMessage());
			  }
			  Console.readLine("\n<Enter>\n");
		}
	
		
		private static void listarUsuarioNome() 
		{
			  System.out.println("--- Listar usuarios em ordem do nome ---");
			  String wnome ;
			  wnome = Console.readLine("Nome....: ");

			  try {
				    Vector<Usuario> todosUsuario = bibliotecaObj.consultarUsuarioNome(wnome);
				    for (Usuario objUsuario : todosUsuario)
				     {
					   System.out.println("\n--- Dados do Usuario ---\n");
					   System.out.println(objUsuario.toString());
				     }
			      } catch (ErrosNegocioException e)
			            {
				          System.out.println(e.getMessage());
			            }
			  Console.readLine("\n<Enter>\n");

		}

		private static void cadastrarLivro()
		{
			System.out.println("\nCadastrar Livro\n");
			
			String titulo = "";
			String editora = "";
			String edicao = "";
			String[] autores = new String[100];
			int quantexemplares = 0;
			
			do {
				titulo = Console.readLine("Titulo: ").trim();
				if (!titulo.equals("")) break;
				System.out.println("Falta informar o Titulo.");
			   } while (true);
			
			
			do {
				editora = Console.readLine("Editora: ").trim();
				if (!editora.equals("")) break;
				System.out.println("Falta informar a Editora.");
			   } while (true);
			
			do {
				edicao = Console.readLine("Edicão: ").trim();
				if (!edicao.equals("")) break;
				System.out.println("Falta informar a Edicao.");
			   } while(true);
			
			
			do{
				//autores = Console.readLine("Autor1: " + "Autor2: ");
				if (!autores.equals("")) break;
				System.out.println("Falta informar o Autor");
			   } while (true);
			
			
			do
			{
				quantexemplares = Console.readInt("Quantidade de Exemplares: ");
				if(quantexemplares == ' ') break;
				System.out.println("Falta informar a Qauntidade de Exemplares.");// Campo vazio
				
			}while(true);
			
			try {
	        	  int codigo= 0;
	        	  if(bibliotecaObj.getListaLivro().isEmpty() ) codigo = 1;
	        	  else codigo = bibliotecaObj.getListaLivro().lastElement().getCodigo() + 1;
	        	  bibliotecaObj.incluirLivro(new Livro(codigo, titulo, editora, edicao, autores, quantexemplares, 0, null));
	        	  System.out.println("Livro cadastrado com sucesso.");
	            }catch(ErrosNegocioException e)
	                 {
	        	       System.out.println(e.getMessage() + "Livro Ja Existe");
	                 }
		    Console.readLine("<ENTER>");
		}
		
		
		private static void excluirLivro()
		{
			System.out.println("--- Excluir Livro ---");
			
			int codLivro = Console.readInt("Código do Livro: ");
			if (codLivro <= 0) return;
			
			try {
				  Livro liv = bibliotecaObj.consultarLivroPeloCodigo(codLivro);
				  System.out.println(liv.toString());
				
				  if(Console.readLine("Confirmar a exclusão (s/n)? ").equalsIgnoreCase("s"))
				    {
					  bibliotecaObj.removerLivro(codLivro);
					  System.out.println("Livro excluído.");
				    }
			    }catch (ErrosNegocioException e)
			              {
				            System.out.println(e.getMessage());
			              }
			  Console.readLine("\n<Enter>\n");

		}
		
		private static void alterarQuantLivro()
		{
			System.out.println("\nAlterar Quantidade de Livros\n");
			try {
				  int campo = 0;
				  System.out.println("\nSelecionar o Campo para alteração\n" + 
				           "1-Acrescentar\n" +
				           "2-Decrementar\n"+
				           "0-Sair\n");
		         campo = Console.readInt("Opção: "); 
		         switch (campo)
		         {
					case 1:
				           int codAcr = Console.readInt("Código: ");
				           if(codAcr <= 0) return;
				           Livro livro = bibliotecaObj.consultarLivroPeloCodigo(codAcr);
				           System.out.println(livro.toString());
				           int quantAcr = Console.readInt("Quantidade: ");  
				           livro.incluirLivro(quantAcr);
				           break;
					case 2:
				           int codRem = Console.readInt("Código: ");
				           if(codRem <= 0) return;
				           Livro livro1 = bibliotecaObj.consultarLivroPeloCodigo(codRem);
				           System.out.println(livro1.toString());
				           int quantRem = Console.readInt("Quantidade: ");  
				           livro1.decrementarLivro(quantRem);
				           break;
		         }
			}catch (ErrosNegocioException e)
                {
	              System.out.println(e.getMessage());
                }
	            
			Console.readLine("\n<Enter>\n");
		}
		
		private static void listarLivroCodigo()
		{
			
			System.out.println("--- Listar Livros Pelo Codigo ---");

            int codigo = 0;
  
			try {
				    codigo = Console.readInt("Codigo: ");
				     if (codigo <= 0) return;   
				     bibliotecaObj.consultarLivroPeloCodigo(codigo);
				     
				     System.out.println("\n--- Dados do  Livro---\n");
				     System.out.println(bibliotecaObj.getListaLivro().toString());
     			   } catch( ErrosNegocioException e )
     			        {
				          System.out.println(e.getMessage());
			            }
			  Console.readLine("\n<Enter>\n");
		}

		
		private static void listarLivroNome() 
		{
			  System.out.println("--- Listar Livros em ordem do Titulo ---");
			  String titulo ;
			  titulo = Console.readLine("Titulo....: ");

			  try {
				    Vector<Livro> todosLivros = bibliotecaObj.listarLivroTitulo(titulo);
				    for(Livro objlivro : todosLivros)
				      {
					    System.out.println("\n--- Livros ---\n");
					    System.out.println(objlivro.toString());
				      } 
				  }catch (ErrosNegocioException e)
			          {
				       System.out.println(e.getMessage());
			          }
			  Console.readLine("\n<Enter>\n");
        }
		
		
		private static void listarLivroAutor() 
		{
			  System.out.println("--- Listar Livros de Autores por Ordem do Titulo ---");
			  String autor;
			  autor = Console.readLine("Autor....: ");

			  try {
				    Vector<Livro> todosLivros = bibliotecaObj.listarLivroAutor(autor);
				    for(Livro objlivro : todosLivros)
				      {
					    System.out.println("\n--- Livros ---\n");
					    System.out.println(objlivro.toString());
				      } 
				  }catch (ErrosNegocioException e)
			          {
				       System.out.println(e.getMessage());
			          }
			  Console.readLine("\n<Enter>\n");
        }
		
		
		private static void cadastrarEmprestimo() 
		{
			System.out.println("\nFazer Emprestimo do Livro\n");
			
			Usuario usuario = null;
			Livro livro = null;
			String nome;
			do {
				nome = LtpLib.padronizarTexto(Console.readLine("Nome: "));
				if (!nome.equals("")) break;
				System.out.println("Falta informar o nome.");
			   } while (true);
			
			String cpf = "";
			do {
				cpf = Console.readLine("CPF : ");
				if (LtpLib.validarCPF(cpf)) break;
				System.out.println("CPF inválido.");
			} while (true);
			
			
			try {
	        	  int numEmprestimo = 0;
	        	  if(bibliotecaObj.getListaEmprestimo().isEmpty() ) numEmprestimo = 1;
	        	  else numEmprestimo = bibliotecaObj.getListaEmprestimo().lastElement().getNumEmprestimo() + 1;
	        	  bibliotecaObj.incluirEmprestimo(new Emprestimo(numEmprestimo, usuario, livro, new GregorianCalendar(), new GregorianCalendar()));
	        	  System.out.println("Emprestimo Feito Com Sucesso.");
	            }catch(ErrosNegocioException e)
	                 {
	        	       System.out.println(e.getMessage() + "Ja foi feito Emprestimo desse Livro");
	                 }
		    Console.readLine("<ENTER>");
		  }
		
		
		
		private static void removerEmprestimo()
		{
			System.out.println("--- Remover Livro do Emprestimo ---");
			
			int codEmprestimo = Console.readInt("Código do Emprestimo: ");
			if (codEmprestimo != 0) return;
			
			try {
						
				  if(Console.readLine("Confirmar a Exclusão (s/n)? ").equalsIgnoreCase("s"))
				    {
					  bibliotecaObj.removerLivro(codEmprestimo);
					  System.out.println("Livro Removido.");
				    }
			    }catch (ErrosNegocioException e)
			              {
				            System.out.println(e.getMessage());
			              }
			  Console.readLine("\n<Enter>\n");

		}

		
		
		private static void devolverEmprestimo()
		{
			System.out.println("--- Devolver Livro do Emprestimo ---");
			
			int codEmprestimo = Console.readInt("Código do Emprestimo: ");
			if (codEmprestimo <= 0) return;
			
			try {
						
				  if(Console.readLine("Confirmar a Devolução (s/n)? ").equalsIgnoreCase("s"))
				    {
					  bibliotecaObj.devolverLivroEmprestimo(codEmprestimo);
					  System.out.println("Livro Devolvido.");
				    }
			    }catch (ErrosNegocioException e)
			              {
				            System.out.println(e.getMessage());
			              }
			  Console.readLine("\n<Enter>\n");

		}
		
		
		private static void devolverTodosEmprestimo()
		{
			System.out.println("--- Devolver Todos os Livros do Emprestimo ---");
			 Emprestimo lista = null;
						
		    try
		      {
			    if(Console.readLine("Confirmar a Devolução (s/n)? ").equalsIgnoreCase("s"))
	              {
			         bibliotecaObj.devolverTodosLivros(lista);
					 System.out.println("Todos os Livros Foram Devolvidos.");
				  }
			    }catch (ErrosNegocioException e)
			              {
				            System.out.println(e.getMessage());
			              }
			  Console.readLine("\n<Enter>\n");

		}

		
		private static void consultarEmprestimoCodigo()
		{
			
			System.out.println("--- Consultar Emprestimo por Codigo ---");

            int codigo = 0;
  
			try {
				    codigo = Console.readInt("Codigo: ");
				     if (codigo <= 0) return;   
				     bibliotecaObj.consultarEmprestimoPeloCodigo(codigo);
				     
				     System.out.println("\n--- Dados do  Emprestimo---\n");
				     System.out.println(bibliotecaObj.getListaEmprestimo().toString());
     			   } catch( ErrosNegocioException e )
     			        {
				          System.out.println(e.getMessage());
			            }
			  Console.readLine("\n<Enter>\n");
		}
		
		
		private static void consultarEmprestimoPeriodo()
		{
			System.out.println("--- Consultar Emprestimo pelo período ---");
			
			String dataEmp;
			GregorianCalendar dataEnt = new GregorianCalendar();
			do {
				dataEmp  = Console.readLine("Data/Hora Inicial (dd/mm/aaaa hh:mm:ss) : ");
				if (dataEmp.equals("")) return;
				if ( LtpLib.validarDataHora(dataEmp, dataEnt)) break;
				System.out.println("Data/Hora Inicial Inválida");
			} while (true);

			String dataDev;
			GregorianCalendar dataSai = new GregorianCalendar();
			do {
				dataDev  = Console.readLine("Data/Hora Final (dd/mm/aaaa hh:mm:ss)   : ");
				if ( LtpLib.validarDataHora(dataDev, dataSai)) break;
				System.out.println("Data Final Inválida");
			} while ( true );

			try {
				Vector<Emprestimo> listaEmp = bibliotecaObj.consultarEmprestimoPeriodo(dataEnt,dataSai);

				for (Emprestimo emp : listaEmp)
				{
					System.out.println(emp.toString());
					if (emp.getdtEmp(dataEnt) != null) 
					{
					   System.out.println("Tempo da Emprestimo até o momento: " + emp.getdtEmp(dataEnt));
					} else {
					   System.out.println("Tempo do Emprestimo: " + emp.getdtDev(new GregorianCalendar()));
					}
				}
				
			} catch (ErrosNegocioException e) {
				System.out.println(e.getMessage());
			}
	        Console.readLine("==>Consulta concluída.");
		}
		
		
		private static void listarEmprestimoTitulo() 
		{
			  System.out.println("--- Listar Emprestimo por Usuario ---");
			  
			  String titulo;
			  
			  titulo = Console.readLine("Titulo....: ");

			  try {
				    Vector<Emprestimo> todosEmprestimos = bibliotecaObj.listarEmprestimoLivro(titulo);
				    for(Emprestimo objEmprestimo : todosEmprestimos)
				      {
					    System.out.println("\n--- Livros ---\n");
					    System.out.println(objEmprestimo.toString());
				      } 
				  }catch (ErrosNegocioException e)
			          {
				       System.out.println(e.getMessage());
			          }
			  Console.readLine("\n<Enter>\n");
        }
		
		
		private static void listarEmprestimoUsuarioPeriodo() 
		{
			String dataEmp;
			GregorianCalendar dataEnt = new GregorianCalendar();
			do {
				dataEmp  = Console.readLine("Data/Hora Inicial (dd/mm/aaaa) : ");
				if (dataEmp.equals("")) return;
				if ( LtpLib.validarDataHora(dataEmp, dataEnt)) break;
				System.out.println("Data/Hora Inicial Inválida");
			} while (true);

			String dataDev;
			GregorianCalendar dataSai = new GregorianCalendar();
			do {
				dataDev  = Console.readLine("Data/Hora Final (dd/mm/aaaa) : ");
				if ( LtpLib.validarDataHora(dataDev, dataSai)) break;
				System.out.println("Data Final Inválida");
			} while ( true );

			try {
				Vector<Emprestimo> listaEmp = bibliotecaObj.consultarEmprestimoPeriodo(dataEnt,dataSai);

				for (Emprestimo emp : listaEmp)
				{
					System.out.println(emp.toString());
					if (emp.getdtEmp(dataEnt) != null) 
					{
						System.out.println("Nome do Usuario: " + emp.getUsuario().getNome());
						System.out.println("CPF do Usuario: " + emp.getUsuario().getCpf());
						System.out.println("Total de Livros Emprestados: " + emp.getLivro().getQtdeEmprestada());
						System.out.println("Tempo da Emprestimo até o momento: " + emp.getdtEmp(dataEnt));
					} 
				}
				
			} catch (ErrosNegocioException e) 
			{
				System.out.println(e.getMessage());
			}
	        Console.readLine("==>Consulta concluída.");
        }
		

}



