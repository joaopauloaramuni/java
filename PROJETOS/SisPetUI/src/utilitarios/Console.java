package utilitarios;

public class Console
{  /**
      imprime um prompt no console
      
      @param prompt a string prompt a ser exibida
    */

   public static void printPrompt(String prompt)
   {  System.out.print(prompt + " ");
      System.out.flush();
   }
   
   /**
      lê uma string do console. A string é terminada por um newline

      @return a string de entrada (sem o newline)
    */
    
   public static String readLine()
   {  int ch;
      String r = "";
      boolean done = false;
      while (!done)
      {  try
         {  ch = System.in.read();
            if (ch < 0 || (char)ch == '\n')
               done = true;
            else if ((char)ch != '\r') // weird--it used to do \r\n translation
               r = r + (char) ch;
         }
         catch(java.io.IOException e)
         {  done = true;
         }
      }
      return r;
   }

   /**
      lê uma string do console. A string é terminada por um newline

      @param prompt a string prompt a ser exibida
      @return a string de entrada (sem o newline)
    */
    
   public static String readLine(String prompt)
   {  printPrompt(prompt);
      return readLine();
   }

   /**
      lê um inteiro do console. A entrada é terminada por um newline

      @param prompt a string prompt a ser exibida
      @return o valor de entrada como um int
      @exception NumberFormatException se entrada com erros
    */
    
   public static int readInt(String prompt)
   {  while(true)
      {  printPrompt(prompt);
         try
         {  return Integer.valueOf
               (readLine().trim()).intValue();
         } catch(NumberFormatException e)
         {  System.out.println
               ("Não é um número inteiro. Favor entre novamente!");
         }
      }
   }

   /**
      lê um número em ponto flutuante do console. A entrada é terminada por um newline

      @param prompt a string prompt a ser exibida
      @return o valor de entrada como um double
      @exception NumberFormatException se entrada com erros
    */
    
   public static double readDouble(String prompt)
   {  while(true)
      {  printPrompt(prompt);
         try
         {  return Double.parseDouble(readLine().trim());
         } catch(NumberFormatException e)
         {  System.out.println
         ("Não é um número em ponto flutuante. Favor entre novamente!");
         }
      }
   }
}
