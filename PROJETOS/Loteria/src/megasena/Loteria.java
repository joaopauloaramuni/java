package megasena;

import java.util.*;
import utilitarios.*;
public class Loteria  {  
   public static void main(String[ ] args)     { 
	  System.out.println("\n"+ "--- L O T E R I A ---"); 
      int k = Console.readInt("Quantos n�meros voce quer jogar? ");
      int n = Console.readInt("Qual � o maior n�mero que voce pode jogar? ");
      // Preencher o vetor �numeros� com n�meros 1 2 3 . . . n
      int [ ] numeros = new int[n];  //  Vetor para armazenar todos os n�meros poss�veis
      for (int i = 0; i < numeros.length; i++)
    	  numeros [ i ] = i + 1;
      // Jogar k numeros e armazen�-los no segundo vetor �jogo�
      int [ ] jogo = new int [ k ];  // Vetor para armazenar o jogo
      for (int i = 0; i < jogo.length; i++)    {  
         // Criar um index aleat�rio entre 0 a n - 1
         int r = ( int ) (Math.random() * n); // O m�todo random retorna um n�mero real aleat�rio entre 
                                              //  0 (inclusive) e 1 (exclusive)
         // Buscar um n�mero localizado na posi��o aleat�ria selecionada
         jogo [ i ] = numeros [ r ];   
         numeros [ r ] = numeros [n - 1];  // mover o �ltimo elemento para a posi��o aleat�ria selecionada
         n--; // ajustar n
      }
      // Imprimir o vetor ordenado atrav�s do m�todo sort
      Arrays.sort (jogo);
      System.out.println("Jogo selecionado. Boa sorte!");
      for (int  elementos : jogo)   // 
           System.out.print(elementos + " ");
      System.out.println("\nAplicativo encerrado.");
   }
}

