package usuario;


import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import controle.*;
import utilitarios.*;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Classe ProInterface - com métodos para interagir com o usuário
 * da aplicação e com os métodos da classe controladora ProControle.
 *
 */
public class ProInterface {

   private static ProControle proctr = new ProControle();


	/**
	 * Método main ponto de entrada do aplicativo - chama o método menu
	 * @param args - vazio (não usado)
	 */

	public static void main(String[] args) {

     // Carrega a lista de produtos

		if (new File("produtos.dat").exists()) {
			try
			{
				proctr.leDados();
			}
			catch(Exception e){
				System.out.println("Erro na leitura da lista de objetos : " + e.getMessage());
				System.exit(1);
			}
		}	

    // Apresenta menu de opcoes
		menu();

	// Grava a lista de produtos

		try
		{
			proctr.gravaDados();
		}
		catch(Exception e){
			System.out.println("Erro na gravação da lista de objetos : " + e.getMessage());
			System.exit(1);
		}

    // Encerramento
	    System.out.println("Programa encerrado com sucesso.");
	    System.exit(0);
	}


/**
  * Método para abrir o menu do aplicativo
  *
  */
   private static void menu() {

	   // Abrir o Menu do aplicativo

	   int opcao = 0;
		  do {
             System.out.println("--- Menu : Cadastro de Produtos ---");
		     System.out.println("1 - Cadastra Produto");
		     System.out.println("2 - Exclui Produto");
		     System.out.println("3 - Exibe um Produto");
		     System.out.println("4 - Exibe todos Produtos em ordem de código");
		     System.out.println("5 - Exibe todos Produtos em ordem de nome");
		     System.out.println("6 - Importar Tabela de Preços de Produtos");
		     System.out.println("7 - Exportar Tabela de Preços de Produtos");

		     System.out.println("0 - Sai do Programa");
		     opcao = Console.readInt("Opção: ");
			 switch (opcao) {
				case 1: insereProduto(); break;
				case 2: excluiProduto(); break;
				case 3: imprimeProduto(); break;
				case 4: imprimeTodosProdutosCodigo(); break;
				case 5: imprimeTodosProdutosNome(); break;
				case 6: importarProdutos(); break;
				case 7: exportarProdutos(); break;
				case 0: break;
				default: System.out.println("Opção Inválida."); break;
			 }
	      } while (opcao != 0);

   }


   private static void insereProduto() {
		  System.out.println("\n--- Cadastro de Produtos ---");
		  String produto = "";
		  double preco = 0;
		  boolean ok = true;
		  while (ok) {
			  produto = LtpLib.padronizarTexto(Console.readLine("      Nome: "));
			  ok = produto.equals("") ||                        // Campo vazio
			  LtpLib.contarPalavras(produto) == 1;             // Nome com uma palavra
		  }
		  ok = true;
		  while (ok) {
			  preco  = Console.readDouble("    Preço: ");
			  ok = preco <= 0;                                 // Campo menor ou igual a 0
		  }

		  proctr.adicionarProduto(produto,preco,new GregorianCalendar());

		  Console.readLine("Produto Cadastrado! <Enter>");
	}

   private static void excluiProduto() {
		  int codigo = Console.readInt("\nDigite o código do produto: ");
		  try{
			  Produto pro = proctr.buscarProdutoPorCodigo(codigo);
			  System.out.println("Produto     : " + pro.getProduto());
			  System.out.println("Preço       : " + pro.getPreco());
			  String aux = Console.readLine("Confirmar a exclusão S/N ? ");
			  if (!aux.toUpperCase().equals("S")) return;

			  proctr.excluirProduto(pro);

			  Console.readLine("Produto Excluido! <Enter>");
		  }
		     catch (Exception e) {
		    	 System.out.println(e.getMessage());
		  }
	}

	private static void imprimeProduto() {
		  int codigo = Console.readInt("\nDigite o código do produto: ");
		  try{
			  System.out.println(proctr.buscarProdutoPorCodigo(codigo).toString());
			  Console.readLine("Pressione <Enter> para continuar");
		  }
		     catch (Exception e) {
		    	 System.out.println(e.getMessage());
		  }
	}

   private static void imprimeTodosProdutosCodigo() {
	   // Buscar Produtos por Código

	   Vector <Produto> listaprodutos = (Vector <Produto>)proctr.getListaProdutos();

	   for (Produto i : listaprodutos) {
		   System.out.println(i.toString());
	   }

	  Console.readLine("Pressione <Enter> para continuar");
   }

   @SuppressWarnings("unchecked")
	private static void imprimeTodosProdutosNome() {
	// Buscar Produtos por Nome
	   Vector <Produto> listaprodutos = (Vector <Produto>)proctr.getListaProdutos().clone();
	   Collections.sort(listaprodutos, new Comparator<Produto>(){

			public int compare(Produto o1, Produto o2) {
				return o1.getProduto().compareTo(o2.getProduto());
			}

	   });
	   for (Produto i : listaprodutos) {
		   System.out.println(i.toString());
	   }

	  Console.readLine("Pressione <Enter> para continuar");

	}

   private static void importarProdutos() {

		proctr.excluirTodosProdutos();  // Limpar a lista de produtos

		try {
		   // Abertura do Arquivo Texto para Leitura

		   BufferedReader in = new BufferedReader (new FileReader("produtos.txt"));

		   // Declaração do buffer de leitura

		   char[] c = new char[85]; // Tamanho da Linha + 2 (CR , Line Feed)

		   // Loop de Leitura das linhas do arquivo

		   int totPro = 0;

		   while (in.read(c)!=-1) { // Ler linha de dados ( -1 para EOF => End of File)

			   // Compor linha em String de trabalho

			   String linha = "";
			   for (int i = 0; i <c.length;i++) linha = linha + c[i];

			   // Buscar os campos na linha

			   @SuppressWarnings("unused")
			   int codigo  = Integer.parseInt(linha.substring(0,5));
			   String produto = linha.substring(5,65);
			   Double preco   = Double.parseDouble(linha.substring(65,73)+"."+linha.substring(73,75));
			   GregorianCalendar data  = new GregorianCalendar(Integer.parseInt(linha.substring(79,83)),
					                                           Integer.parseInt(linha.substring(77,79))-1,
					                                           Integer.parseInt(linha.substring(75,77)) );


			  proctr.adicionarProduto(produto,preco,data);

			  totPro++;

		   }

		   // Fechamento do arquivo texto

		   in.close();

		   Console.readLine("Total de produtos importados : " + totPro);

		}  catch (IOException e) {
			System.out.println(e.getMessage());
		}

   }


   private static void exportarProdutos() {

	   int totPro = 0;

	   // Buscar Produtos

	   Vector <Produto> listaprodutos = new Vector <Produto>();

	   listaprodutos = proctr.getListaProdutos();

	   // Abertura do Arquivo Texto para Gravação

	   try {

		   BufferedWriter out = new BufferedWriter(new FileWriter("produtos.txt"));

		   String codigo;  // Tamanho  = 5
		   String produto; // Tamanho = 60
		   String preco;   // Tamanho = 10 ( 2 decimais)
		   String data;	   // Tamanho = 8 (ddmmaaaa)
		   				   // Tamanho da Linha = 83

		   // Loop de Gravação das linhas do arquivo


		   for (int i = 0 ; i < listaprodutos.size(); i++) {

			   // Obter os campos da linha

			   codigo = String.valueOf(listaprodutos.get(i).getCodigo());
			   for (int j=0 ; codigo.length()<5  ; j++) codigo = "0" + codigo;  // inserir zeros a esquerda do campo

			   produto = listaprodutos.get(i).getProduto();
			   for (int j=0; produto.length()<60; j++) produto += " "; // Inserir espaços a direita do campo

			   preco = new DecimalFormat("00000000.00").format(listaprodutos.get(i).getPreco()).replace(",","");

			   data = new SimpleDateFormat("ddMMyyyy").format(listaprodutos.get(i).getData().getTime());

			   // Gravar Linha de texto
			   out.write(codigo + produto + preco + data);
			   // Gravar CR (Carriage Return \r - 13 e LF Line Feed \n - 10)
			   out.newLine();

			   totPro++;
		   }

		   out.close();


		}  catch (IOException e) {
			System.out.println(e.getMessage());
		}

		Console.readLine("Total de produtos exportados : " + totPro);
   }

}
