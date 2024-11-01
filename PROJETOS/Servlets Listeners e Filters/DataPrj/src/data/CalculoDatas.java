package data;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalculoDatas {

   /**
    * Calcula a diferenca de dias entre uma data posterior e 
    * uma anterior. Pode retornar um valor
    * negativo se as mesmas estiverem invertidas.
    * 
    * @param posterior Data posterior.
    * @param anterior Data anterior.
    * @return Diferenca de dias entre as datas.
    */
   public static int diferenca (GregorianCalendar posterior, 
                                GregorianCalendar anterior) {
      return valor(posterior) - valor(anterior);
   }

   /**
    * Verifica se a data correspondente aos parametros recebidos
    * e valida.
    * 
    * @param dia Dia da data.
    * @param mes Mes da data.
    * @param ano Ano da data
    * @return true se a data e valida, false caso contrario.
    */
   public static boolean valida(int dia, int mes, int ano) {
      if (dia < 1 || dia > 31) return false;
      if (mes < 1 || mes > 12) return false;
      if (dia > 30 && (mes == 2 || mes == 4 || mes == 6 || 
                       mes == 9 || mes == 11)) return false;
      boolean bissexto = (ano % 400 == 0) || 
                         (ano % 4 == 100 && ano % 100 != 0);
      int ultDia = bissexto ? 29 : 28;
      if (mes == 2 && dia > ultDia) return false;
      return true;
   }

   /**
    * Calcula um valor numerico para uma data. 
    * Este valor representa o numero de dias
    * transcorridos entre essa data e 1/1/0.
    * 
    * @param d Data de entrada.
    * @return Valor numerico da data.
    */
   public static int valor (GregorianCalendar d) {
      int dia = d.get(Calendar.DAY_OF_MONTH);
      int mes = d.get(Calendar.MONTH)+1;
      int ano = d.get(Calendar.YEAR);

      if (mes < 3) {
         ano--; mes+=9;
      }
      else
         mes -=3;

      int fator = ano * 365;
      fator += (ano/4 - ano/100 + ano/400);
      fator += (int)(Math.floor(mes*30.6 + 0.5));
      return fator + dia + 60;
   }
}
