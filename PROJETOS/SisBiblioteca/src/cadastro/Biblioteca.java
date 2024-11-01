package cadastro;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Vector;


/**
 * Classe Biblioteca
 */

public class Biblioteca implements Serializable
{
   private static final long serialVersionUID = 1L;
   
   public static int QUANTDIASPARADEVOLUCAO = 7;
   public static int QUANTLIVROEMPRESUSUARIO = 5;


   // ATRIBUTO
   private Vector<Usuario> listaUsuario = new Vector<Usuario>();
   private Vector<Livro> listaLivro = new Vector<Livro>();
   private Vector<Emprestimo> listaEmprestimo = new Vector<Emprestimo>();
   Emprestimo emprestimo;


	/**
	 * @return  Returns the listaUsuario.
	 */
   public Vector<Usuario> getListaUsuario()
	{
		return listaUsuario;
	}
	/**
	 * @param listaUsuario  The listaUsuario to set.
	 */
	public void setListaUsuario(Vector<Usuario> listaUsuario) 
	{
		this.listaUsuario = listaUsuario;
	}

	/**
	 * @return  Returns the listaLivro.
	 */
	public Vector<Livro> getListaLivro() 
	{
		return listaLivro;
	}
	/**
	 * @param listaLivro  The listaLivro to set.
	 */
	public void setListaLivro(Vector<Livro> listaLivro) 
	{
		this.listaLivro = listaLivro;
	}
	
	
	/**
	 * @return  Returns the listaEmprestimo.
	 */
	public Vector<Emprestimo> getListaEmprestimo() 
	{
		return listaEmprestimo;
	}
	/**
	 * @param listaEmprestimo  The listaEmprestimo to set.
	 */
	public void setListaEmprestimo(Vector<Emprestimo> listaEmprestimo) 
	{
		this.listaEmprestimo = listaEmprestimo;
	}

	
	/**
	 * @param metodo para Incluir Usuario
	 */
	public void incluirUsuario(Usuario objUsuario) throws ErrosNegocioException
	{
		for(Usuario usuarioCad : listaUsuario)
		{
		  if ((usuarioCad.getCpf().equals(objUsuario.getCpf()))) 
		    {
			 throw new ErrosNegocioException("O Usuario" + objUsuario.getCpf() + 
		    			             " já está cadastrado com o CPF: " + objUsuario.getCpf());
		    }
		}
		listaUsuario.addElement(objUsuario);
	}
	
	
	/**
	 * @param metodo para Excluir Usuario
	 */
	public void excluirUsuario(String cpf) throws ErrosNegocioException 
	{
		for(Usuario usuarioCad : listaUsuario)
		{
		  if(!usuarioCad.getCpf().equals(cpf))
		   {
			  throw new ErrosNegocioException("O Usuario" + usuarioCad.getCpf() + 
			             " Não Existe com o CPF: " + usuarioCad.getCpf());	
		   }
		   else if(cpf.equals(emprestimo.getUsuario().getCpf()))
		      {
			    throw new ErrosNegocioException("O Usuario" + usuarioCad.getCpf() + 
			             "Esta com um Livro Emprestado: " + emprestimo.getNumEmprestimo());	 
		      }
		      else listaUsuario.remove(usuarioCad);
		}
	}
	
	
	/**
	 * @param metodo para Consultar Usuario por CPF
	 */
	public Vector<Usuario> consultarUsuarioCPF(String cpf) throws ErrosNegocioException 
	{
		Vector<Usuario> conscpf = new Vector<Usuario>();
		for (Usuario usuario : listaUsuario)
		{
			if (!usuario.getCpf().equals(cpf))
			{
				throw new ErrosNegocioException("O Usuario Não Existe com o CPF: " 
						+ cpf);
			}
		}
		return conscpf;
	}

	
	/**
	 * @param metodo para Consultar Usuario por Nome
	 */
	public Vector<Usuario> consultarUsuarioNome(String nome) throws ErrosNegocioException 
	{
		Vector<Usuario> consNome = new Vector<Usuario>();
		for (Usuario usuario : listaUsuario)
		{
			if(usuario.getNome().toUpperCase().indexOf(nome.toUpperCase()) != -1 )
			{
				consNome.add(usuario);
			}
			else if(consNome.isEmpty() || (!usuario.getNome().equals(nome)))
				 throw new ErrosNegocioException("Não existe Usuario para o nome informado.");
		}
		return consNome;

	}

	
	/**
	 * @param metodo para incluir Livro
	 */
	public void incluirLivro(Livro objLivro) throws ErrosNegocioException 
	{
		for(Livro livroCad : listaLivro)
		{
		  if ((livroCad.getTitulo().equals(objLivro.getTitulo())) || (livroCad.getEditora().equals(objLivro.getEditora()))) 
		    {
			  throw new ErrosNegocioException("O Livro já está cadastrado com o Titulo: " + objLivro.getTitulo() +
					  "e com a Editora: " + objLivro.getEditora());
		    }
		}
		listaLivro.addElement(objLivro);
	}
	
	
	/**
	 * @param metodo para Consultar Livro pelo Codigo
	 */
	public Livro consultarLivroPeloCodigo(int codigo) throws  ErrosNegocioException 
	{
		for (Livro livro : listaLivro)
		{
			if (livro.getCodigo() == codigo)
			{
				return livro;
			}
				
			throw new ErrosNegocioException("O Livro Não Existe com o codigo: " 
						+ codigo);
		}
		return null;

	}
	
	
	/**
	 * @param metodo para Remover Livro
	 */
	public void removerLivro(int codigo) throws  ErrosNegocioException
	{
		for(Livro livroCad : listaLivro)
		{
		  if(livroCad.getCodigo() != codigo)
		   {
			  throw new ErrosNegocioException("O Livro Não Existe com o codigo" + codigo);	
		   }
		   else if(codigo == emprestimo.getNumEmprestimo())
		      {
			    throw new ErrosNegocioException("O Usuario" + livroCad.getCodigo() + 
			             "Esta com um Livro Emprestado: " + emprestimo.getNumEmprestimo());	 
		      }
		      else listaUsuario.remove(livroCad);
		}
	}
	

	/**
	 * @param metodo para Listar Livro por Titulo
	 */
	public Vector<Livro> listarLivroTitulo(String titulo) throws ErrosNegocioException 
	{
		Vector<Livro> listaTemp = new Vector<Livro>();
				
		for (Livro objLivro : listaLivro)
		{
			if (objLivro.getTitulo().toUpperCase().indexOf(titulo.toUpperCase())!=-1)
			{
				listaTemp.add(objLivro);
			}
		}
		if(listaLivro.isEmpty())
		  {
			  throw new ErrosNegocioException("Não existe Livro para o Titulo informado.");
		  }	else return listaTemp;
	}
		

	/**
	 * @param metodo para Listar Livrov pelo Autor
	 */
	public Vector<Livro> listarLivroAutor(String autor) throws ErrosNegocioException 
	{
		Vector<Livro> consAutor = new Vector<Livro>();
		for (Livro livro : listaLivro)
		{
			if(livro.getTitulo().toUpperCase().indexOf(autor.toUpperCase()) != -1 )
			{
				consAutor.add(livro);
			}
			else if(consAutor.isEmpty() || (!livro.getTitulo().equals(autor)))
				 throw new ErrosNegocioException("Não existe Livro para o Titulo informado.");
		}
		return consAutor;

	}
	
	
	/**
	 * @param metodo para Incluir Livro no Emprestimo
	 */
	public void incluirEmprestimo(Emprestimo lista) throws ErrosNegocioException
	{
		Usuario usuario = null;
		
		for(Usuario cadUsuario : listaUsuario)
		{
		  if(!cadUsuario.getCpf().equals(usuario.getCpf()) || (!cadUsuario.getNome().equals(usuario.getNome())))
		    {
			  throw new ErrosNegocioException("Usuario Nao Cadastrado"); 
		    }
		  
		}
		
		for(Emprestimo cadEmpres : listaEmprestimo)
		{
			if(cadEmpres.getNumEmprestimo() == lista.getNumEmprestimo() && (cadEmpres.getUsuario().getCpf().equals(lista.getUsuario().getCpf())))
			{
			  throw new ErrosNegocioException("O Usuário não pode ter mais de um exemplar emprestado do mesmo livro, Codigo: " + lista.getNumEmprestimo() + " na lista de empréstimos");
			}
			else if(lista.getUsuario().getCpf().equals(QUANTLIVROEMPRESUSUARIO))
			    {
				  throw new ErrosNegocioException("O usuário já estourou o limite de 5 livros emprestados na lista de empréstimos .");
			    }
			    else listaEmprestimo.addElement(lista);
		}
		
		
	}
	
	
	/**
	 * @param metodo para Remover Livro do Emprestimo
	 */
	public void removerLivroEmprestimo(int codigo) throws  ErrosNegocioException
	{
		
		for(Emprestimo livroCad : listaEmprestimo)
		{
		  if(livroCad.getNumEmprestimo() != codigo)
		   {
			  throw new ErrosNegocioException("O Livro Não Existe com o codigo" + codigo);	
		   }
		   else listaUsuario.remove(livroCad);
		}
	}
	
	
	/**
	 * @param metodo para Devolver Livro do Emprestimo
	 */
	public void devolverLivroEmprestimo(int codigo) throws  ErrosNegocioException
	{
		Livro livro=null;
		
		for(Emprestimo livroCad : listaEmprestimo)
		{
		  if(livro.getCodigo() != codigo)
		   {
			  throw new ErrosNegocioException("O Livro Não Existe com o codigo" + codigo);	
		   }
		   else if(codigo == livroCad.getNumEmprestimo())
		      {
			    throw new ErrosNegocioException("O Usuario" + livro.getCodigo() + 
			             "Esta com um Livro Emprestado: " + emprestimo.getNumEmprestimo());	 
		      }
		      else if(livroCad.getNumEmprestimo() == codigo)
		           {
		    	      throw new ErrosNegocioException("O Livro ja foi devolvido com o Codigo" + codigo);
		            }
		   
		   else listaUsuario.remove(livroCad);
		}
	}
	
	
	/**
	 * @param metodo para Devolver Todos os Livros do Emprestimo
	 */
	public void devolverTodosLivros(Emprestimo lista) throws  ErrosNegocioException
	{
		for(Emprestimo emprestimo : listaEmprestimo)
		{
		  if(emprestimo.getNumEmprestimo() != lista.getNumEmprestimo())
		   {
			  throw new ErrosNegocioException("O Livro Não Existe com o codigo" + lista.getNumEmprestimo());	
		   }
		   else listaUsuario.removeAllElements();
		}
		
    }
	
	
	/**
	 * @param metodo para Consultar Livro do Emprestimo
	 */
	public Emprestimo consultarEmprestimoPeloCodigo(int codigo) throws  ErrosNegocioException 
	{
		for (Emprestimo emprestimo : listaEmprestimo)
		{
			if (emprestimo.getNumEmprestimo() == codigo)
			{
				return emprestimo;
			}
				
			throw new ErrosNegocioException("O Emprestimo Não Existe Para o codigo: " 
						+ codigo);
		}
		return null;

	}
	
	
	/**
	 * @param metodo para Consultar Livro por Periodo de Emprestimo
	 */
	public Vector<Emprestimo> consultarEmprestimoPeriodo(GregorianCalendar dataInicio, GregorianCalendar dataFim) throws  ErrosNegocioException 
	{
		Vector<Emprestimo> consPeriodo = new Vector<Emprestimo>();
			for (Emprestimo emp : listaEmprestimo)
			{
				if ((emp.dtEmp.compareTo(dataInicio)>=0) && (emp.dtDev.compareTo(dataFim)<=0)) 
				{
					consPeriodo.add(emp);
				}
			}
			if ( consPeriodo.isEmpty() )
				 throw new ErrosNegocioException("Não existe Emprestimo para o período informado.");
			else return consPeriodo;
			
	}

	
	public Vector<Emprestimo> listarEmprestimoLivro(String titulo) throws  ErrosNegocioException 
	{
	
		for (Livro objLivro : listaLivro)
			{
				if (!objLivro.getTitulo().equals(titulo)) 
				{
					throw new ErrosNegocioException("Não existe o Livro Informado.");
				}
			}
		
		for (Emprestimo objEmprestimo : listaEmprestimo)
		{
			if (!objEmprestimo.getLivro().getTitulo().equals(titulo)) 
			{
				throw new ErrosNegocioException("Não Emprestimo para o Livro Informado.");
			}
			else{
				 listaEmprestimo.add(objEmprestimo);
			     return listaEmprestimo;
			    }
		}
		return null;
	}
	
	/**
	 * @param metodo para Consultar Listar Emprestimo por Titulo
	 */
	public void listarTodosEmprestimos(Emprestimo lista) throws ErrosNegocioException 
	{
		for (Emprestimo emprestimo : listaEmprestimo)
		{
			consultarEmprestimoPeloCodigo(lista.getNumEmprestimo());
			//consultarEmprestimoPeriodo(lista.getdtEmp());
		}
		listaEmprestimo.add(emprestimo);


	}
	
}

