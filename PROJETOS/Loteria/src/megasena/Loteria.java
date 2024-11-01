package megasena;

import java.util.*;
import utilitarios.*;
public class Loteria  {  
   public static void main(String[ ] args)     { 
	  System.out.println("\n"+ "--- L O T E R I A ---"); 
      int k = Console.readInt("Quantos números voce quer jogar? ");
      int n = Console.readInt("Qual é o maior número que voce pode jogar? ");
      // Preencher o vetor “numeros” com números 1 2 3 . . . n
      int [ ] numeros = new int[n];  //  Vetor para armazenar todos os números possíveis
      for (int i = 0; i < numeros.length; i++)
    	  numeros [ i ] = i + 1;
      // Jogar k numeros e armazená-los no segundo vetor “jogo”
      int [ ] jogo = new int [ k ];  // Vetor para armazenar o jogo
      for (int i = 0; i < jogo.length; i++)    {  
         // Criar um index aleatório entre 0 a n - 1
         int r = ( int ) (Math.random() * n); // O método random retorna um número real aleatório entre 
                                              //  0 (inclusive) e 1 (exclusive)
         // Buscar um número localizado na posição aleatória selecionada
         jogo [ i ] = numeros [ r ];   
         numeros [ r ] = numeros [n - 1];  // mover o último elemento para a posição aleatória selecionada
         n--; // ajustar n
      }
      // Imprimir o vetor ordenado através do método sort
      Arrays.sort (jogo);
      System.out.println("Jogo selecionado. Boa sorte!");
      for (int  elementos : jogo)   // 
           System.out.print(elementos + " ");
      System.out.println("\nAplicativo encerrado.");
   }
}

