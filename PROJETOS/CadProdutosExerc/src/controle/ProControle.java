package controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;
import java.util.Vector;

public class ProControle {

// Atributos

	private Vector <Produto> listaProdutos = new Vector <Produto> ();

//  M�todos

	public Vector<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void adicionarProduto (String produto, double preco,GregorianCalendar data) {
		listaProdutos.addElement(new Produto(produto,preco,data));
		return;
	}

	public Produto buscarProdutoPorCodigo (int codigo) throws Exception  {
		for (Produto i : listaProdutos) {
			if (i.getCodigo()==codigo) return i;
		}
		throw new Exception("N�o Existe produto para o c�digo informado.");

	}

	public void excluirProduto (Produto pro) {
        listaProdutos.remove(pro);
	}

	public void excluirTodosProdutos () {
        listaProdutos.removeAllElements();
        Produto.setUltimoCodigo(0);  // zerar ultimo c�digo de produto
	}

	/**
    L� a lista de produtos do arquivo de objetos, se ele existir
   */
	@SuppressWarnings("unchecked")
	public void leDados() throws IOException, ClassNotFoundException {
     	if ( !new File("produtos.dat").exists()) return;
		ObjectInputStream in = new ObjectInputStream(
	       new FileInputStream("produtos.dat"));
     	listaProdutos = (Vector)in.readObject();
	    in.close();
  	    if (listaProdutos.size()==0) {
  	    	return;  // Lista est� vazia?
  	    }
     	Produto pro = (Produto) listaProdutos.get(listaProdutos.size()-1);
     	Produto.setUltimoCodigo(pro.getCodigo());  // Inicializar ultimo c�digo de produto - atributo est�tico

   }

   /**
    Grava a lista de produtos em um arquivo de objetos
   */
	public void gravaDados() throws IOException {
      ObjectOutputStream out = new ObjectOutputStream(
 	          new FileOutputStream("produtos.dat"));
      out.writeObject(listaProdutos);  // Gravar todos os objetos
      out.close();

   }
}
