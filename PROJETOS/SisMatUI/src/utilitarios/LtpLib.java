package utilitarios;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;


/**
 * Classe de serviços de utilidade
 *
 */

public class LtpLib {
// Constantes
    public final static int RETORNAR_HORAS = 1;
    public final static int RETORNAR_MILISEGUNDOS = 2;
    public final static int RETORNAR_MINUTOS = 3;
    public final static int RETORNAR_SEGUNDOS = 4;
    
    public final static int DOMINGO = 1;
    public final static int SEGUNDA_FEIRA = 2;
    public final static int TERCA_FEIRA = 3;
    public final static int QUARTA_FEIRA = 4;
    public final static int QUINTA_FEIRA = 5;
    public final static int SEXTA_FEIRA = 6;
    public final static int SABADO = 7;

// Métodos
    /**
     * Método validarData - Validação básica de Data
     * @param s String com a Data
     * @return true para data válida ou false para data inválida
     */

    public static boolean validarData(String wdata) {
        // Vetor Constante com Nº max. de dias dos meses do ano
        final int[ ] DIAS = {31,28,31,30,31,30,31,31,30,31,30,31};
        if (wdata.equals("")) return false;
        // Inicializa os elementos do vetor (Dia , Mes, Ano)
        String[ ] auxData = wdata.split("/");
        if (auxData.length != 3) return false;
        if ( auxData[0].equals("") || auxData[1].equals("") || auxData[2].equals("") ) return false;
        // Valida mes
        if (!auxData[1].matches("[0-9]*") || Integer.parseInt(auxData[1]) < 1 || Integer.parseInt(auxData[1]) > 12 )
            return false;
        int mes = Integer.parseInt(auxData[1]);
        // Valida ano
        if (!auxData[2].matches("[0-9]*") || auxData[2].trim().length() < 2 || auxData[2].trim().length() == 3 || auxData[2].trim().length() > 4 )
            return false;
        if (auxData[2].trim().length()==2){
        	auxData[2] = formatarData(new GregorianCalendar(), "yyyy").substring(0, 2) + auxData[2].trim();
        }
        int ano = Integer.parseInt(auxData[2]);
        // Valida dia
        if (!auxData[0].matches("[0-9]*"))
            return false;
        int dia = Integer.parseInt(auxData[0]);
        // testando se o ano e bissexto
        if (new GregorianCalendar().isLeapYear(ano))  // Ano bissexto ?
          {
            if ( mes == 2 && (dia > 29 || dia < 1) )
                return false;
            else if ( mes !=2 && dia > DIAS[mes-1] || dia < 1)
                return false;
          }
        else
          {
            if ( dia > DIAS[mes-1] || dia < 1)
                return false;
          }
        return true;
    }
    /**
     * validarData verifica se o conteudo da String representa um data válida
     * @param wdata - String com a data
     * @param dt referência a um objeto da classe GregorianCalendar para receber a data válida
     * @return true para data válida ou false para data inválida
     */
    public static boolean validarData(String wdata, GregorianCalendar dt) {
        if (!validarData(wdata)) {
            return false;
        } else {
            String[] auxData = wdata.split("/"); // Inicializa os elementos do vetor (Dia , Mes, Ano)
            int dia = Integer.parseInt(auxData[0]);
            int mes = Integer.parseInt(auxData[1]);
            if (auxData[2].length()==2){
            	auxData[2] = formatarData(new GregorianCalendar(), "yyyy").substring(0, 2) + auxData[2];
            }            
            int ano = Integer.parseInt(auxData[2]);
            dt.setTimeInMillis(0);
            dt.set(ano,mes-1,dia,0,0,0); // Atualiza os atributos do objeto
            return true;
        }

    }
	/**
	 * validarData verifica se o conteudo da String representa um data válida
	 * @param wdata - String com a data
	 * @param dt referência a um objeto da classe java.sql.Date para receber a data válida
	 * @return true para data válida ou false para data inválida
	 */
	public static boolean validarData(String wdata, java.sql.Date dt) {
		GregorianCalendar dat = new GregorianCalendar();
		if (!validarData(wdata,dat)) {
			return false;
		} else {

			dt = new java.sql.Date(dat.getTimeInMillis());
			return true;
		}
	}
	/**
	 * validarHora verifica se o conteudo da String representa um horário válido
	 * @param wdata - String com a data no formato h:m:s ou hh:mm:ss
	 * @return true para horário válido ou false para horário inválido
	 */
	public static boolean validarHora(String whora) {
		if (whora.equals("")) return false;
        // Inicializa os elementos do vetor (hora , minuto , segundo)
		String [] hora1 = whora.split(":");
        if (hora1.length != 3) return false;
        if ( hora1[0].equals("") || hora1[1].equals("") || hora1[2].equals("") ) return false;
		if (!hora1[0].matches("[0-9]*") || Integer.parseInt(hora1[0]) < 0 || Integer.parseInt(hora1[0]) > 23 ||
			!hora1[1].matches("[0-9]*") || Integer.parseInt(hora1[1]) < 0 || Integer.parseInt(hora1[1]) > 59 ||
			!hora1[2].matches("[0-9]*") || Integer.parseInt(hora1[2]) < 0 || Integer.parseInt(hora1[2]) > 59)
			 return false;
		else return true;
	}

	/**
	 * validarHora verifica se o conteudo da String representa um horário válido
	 * @param wdata - String com a data no formato h:m:s ou hh:mm:ss
	 * @param dt - Objeto GregorianCalendar dt para atualizar a hora na data corrente
	 * @return true para horário válido ou false para horário inválido
	 */
	public static boolean validarHora(String whora, GregorianCalendar dt) {
        return validarDataHora( formatarData(new GregorianCalendar(), "dd/MM/yyyy") + " " + whora, dt); 
	}	
	/**
	 * validarDataHora verifica se o conteudo da String representa um horário válido
	 * @param wdataHora - String com a data no formato d/M/yy h:m:s ou d/M/yyyy hh:mm:ss
	 * @return true para horário válido ou false para horário inválido
	 */	
	public static boolean validarDataHora(String dataHora) {
		String wdataHora = padronizarTexto(dataHora);
		if (wdataHora.indexOf(" ")==-1) return false; 
		String [] arrDataHora = wdataHora.split(" ");
		if (!validarData(arrDataHora[0])) return false;
		if (!validarHora(arrDataHora[1])) return false;
		return true;
	}
	/**
	 * validarDataHora verifica se o conteudo da String representa um horário válido
	 * @param wdataHora - String com a data no formato d/M/yy h:m:s ou d/M/yyyy hh:mm:ss
	 * @param dt - Objeto GregorianCalendar dt para atualizar a data hora
	 * @return true para horário válido ou false para horário inválido
	 */	
	public static boolean validarDataHora(String dataHora, GregorianCalendar dt) {
		if (!validarDataHora(dataHora)) return false;
		String wdataHora = padronizarTexto(dataHora);
		String [] arrDataHora = wdataHora.split(" ");
		String [] arrData = arrDataHora[0].split("/");
        if (arrData[2].length()==2){
        	arrData[2] = formatarData(new GregorianCalendar(), "yyyy").substring(0, 2) + arrData[2];
        }  
		String [] arrHora = arrDataHora[1].split(":");		
		dt.set(Integer.parseInt(arrData[2]), Integer.parseInt(arrData[1])-1, Integer.parseInt(arrData[0]), 
			   Integer.parseInt(arrHora[0]), Integer.parseInt(arrHora[1]), Integer.parseInt(arrHora[2]));
		return true;
	}
	/**
	 * validarDataHora verifica se o conteudo da String representa um horário válido
	 * @param wdataHora - String com a data no formato d/M/yy h:m:s ou d/M/yyyy hh:mm:ss
	 * @param dt - Objeto java.sql.Date dt para atualizar a data hora
	 * @return true para horário válido ou false para horário inválido
	 */	
	public static boolean validarDataHora(String dataHora, java.sql.Date dt) {
		GregorianCalendar dat = new GregorianCalendar();
		if (!validarDataHora(dataHora,dat)) {
			return false;
		} else {

			dt = new java.sql.Date(dat.getTimeInMillis());
			return true;
		}		
	}		
    /**
     * Método validarCPF - Validação do DV do CPF
     * @param s String com o CPF
     * @return true para CPF com dv correto
     */
    public static boolean validarCPF (String wcpf) {
        if (wcpf.trim().equals("") || !wcpf.matches("[0-9]*") || wcpf.length() != 11) return false;
        String seq1 = "100908070605040302";
        String seq2 = "11100908070605040302";
        int soma1 , soma2;
        soma1 = soma2 = 0; // inicializa acumuladores
        int j = 0;
        for (int i=0;i<=8;i++){
            soma1 += Integer.parseInt(wcpf.substring(i,i+1)) * Integer.parseInt(seq1.substring(j,j+2));
            soma2 += Integer.parseInt(wcpf.substring(i,i+1)) * Integer.parseInt(seq2.substring(j,j+2));
            j += 2;
        }
        int dv1 = 11 - (soma1 % 11);
        if (dv1 > 9) dv1 = 0;
        soma2 += dv1 * 2;
        int dv2 = 11 - (soma2 % 11);
        if (dv2 > 9) dv2 =0;
        String dvc = Integer.toString(dv1) + Integer.toString(dv2);
        if (wcpf.substring(9,11).equals(dvc)) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Método validarCNPJ - Validação do DV do CNPJ
     * @param s String com o CNPJ
     * @return true para CNPJ com dv correto
     */

    public static boolean validarCNPJ (String wcnpj) {
        if (wcnpj.trim().equals("") || !wcnpj.matches("[0-9]*") || wcnpj.length() != 14) return false;
        String seq1 = "050403020908070605040302";
        String seq2 = "06050403020908070605040302";
        int soma1 , soma2;
        soma1 = soma2 = 0; // inicializa acumuladores
        int j = 0;
        for (int i=0;i<=11;i++){
            soma1 += Integer.parseInt(wcnpj.substring(i,i+1)) * Integer.parseInt(seq1.substring(j,j+2));
            soma2 += Integer.parseInt(wcnpj.substring(i,i+1)) * Integer.parseInt(seq2.substring(j,j+2));
            j += 2;
        }
        int dv1 = 11 - (soma1 % 11);
        if (dv1 > 9) dv1 = 0;
        soma2 += dv1 * 2;
        int dv2 = 11 - (soma2 % 11);
        if (dv2 > 9) dv2 =0;
        String dvc = Integer.toString(dv1) + Integer.toString(dv2);
        if (wcnpj.substring(12,14).equals(dvc)) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Método validarPIS - Validação do DV do PIS
     * @param s String com o PIS
     * @return true para PIS com dv correto
     */
    public static boolean validarPIS (String wpis) {
        final int[] tab = {3,2,9,8,7,6,5,4,3,2}; // vetor de constantes
        if (wpis.trim().equals("") || !wpis.matches("[0-9]*") || wpis.length() > 11) return false;
        String aux = wpis;
        int soma = 0;
        for (int j=0;j<11-wpis.length();j++) aux = "0" + aux; // completar com zeros a esquerda
        for (int i=0;i<aux.length()-1;i++) soma += Integer.parseInt(aux.substring(i,i+1)) * tab[i];
        int dv = 11 - (soma % 11) > 9 ? 0 : 11 - (soma % 11);
        return aux.substring(10,11).equals(Integer.toString(dv))? true : false;
    }
    /**
     * Método validarEmail - Validação básica de E-mail
     * @param s String com a E-mail
     * @return true para E-Mail válido
     */
    public static boolean validarEmail(String email)
     {
          int n = 0;
          if ((email.substring(0,1).equals("@")) || (email.substring(email.length()-1,email.length()).equals("@"))) return false;
          else
          {
              for (int i = 0; i < email.length() ;i++) if (email.substring(i,i + 1).equals("@"))  n += 1;
              if (n != 1) return false;
              else
              {
                  if(email.indexOf(".") != -1){
                      if ((email.substring(email.length() - 3,email.length() - 2).equals(".")) || (email.substring(email.length() - 4,email.length() - 3).equals("."))) return true;
                      else return false;
                  }
                  else return false;
              }
          }
     }
    /**
     * Método contarPalavras - Contar as palavras do texto
     * @param s String com o Texto
     * @return int com o número de palavras do texto
     */
    public static int contarPalavras ( String s) {
        String aux = s.trim();
        if (aux.equals("")) return 0;
        int contPal = 1;
        for (int i=0;i<=aux.length()-1;i++) {
            if (aux.charAt(i) == ' ' && aux.charAt(i+1) != ' ') contPal++ ;
        }
        return contPal;
    }
    /**
     * Método ajustarFimSemana - Ajusta data de fim de semana
     * @param dt - GregorianCalendar com a Data
     * @return GregorianCalendar com a data ajustada
     */
    public static GregorianCalendar ajustarFimSemana(GregorianCalendar dt) {
        switch (dt.get(GregorianCalendar.DAY_OF_WEEK)) {
            case 7:
                dt.add(GregorianCalendar.DAY_OF_MONTH,2);
                break;
            case 1:
                dt.add(GregorianCalendar.DAY_OF_MONTH,1);
                break;
        }

        return dt;
    }
    /**
     * Método padronizarTexto - Excluir espaços a esquerda, a direita e excesso entre palavras do texto
     * @param s String com o Texto
     * @return String com o texto padronizado
     */
    public static String padronizarTexto (String s) {
        String resposta = "";
        String aux = s.trim(); // Inicializa aux com s retirando espaços nas extremidades
        do {
            aux += " "; // incluir no final delimitador de palavra
            resposta += aux.substring(0,aux.indexOf(" ")) + " "; // concatenar palavra por palavra
            aux = aux.substring(aux.indexOf(" ")); // excluir palavra processada
            aux = aux.trim(); // retirar espaços a esquerda
        } while (!aux.equals("")); //verificar se terminou?
        return resposta.trim();
    }
    /**
     * Método formatarData - formata uma data dt a partir de uma máscara fmt
     * @param dt - DataGregorianCalendar
     * @param fmt - Máscara
     * @return String com a data formatada
     */
    public static String formatarData(GregorianCalendar dt , String fmt) {
        try {
            SimpleDateFormat formatoData = new SimpleDateFormat(fmt);
            return formatoData.format(dt.getTime());
        } catch (Exception e) {
            return "Formato inválido";
        }

    }
    
    /**
     * Método formatarData - formata uma data dt a partir de uma máscara fmt
     * @param dt - dataDate
     * @param fmt - Máscara
     * @return String com a data formatada
     */
    public static String formatarData(Date dt , String fmt) {
        try {
            SimpleDateFormat formatoData = new SimpleDateFormat(fmt);
            return formatoData.format(dt);
        } catch (Exception e) {
            return "Formato inválido";
        }

    }
    
    /**
     * Método formatarData - formata uma data dt a partir de uma máscara fmt
     * @param dt - Data java.sql.Date
     * @param fmt - Máscara
     * @return String com a data formatada
     */
    public static String formatarData(java.sql.Date dt , String fmt) {
        try {
            SimpleDateFormat formatoData = new SimpleDateFormat(fmt);
            return formatoData.format(dt.getTime());
        } catch (Exception e) {
            return "Formato inválido";
        }

    }
    /**
     * Método formatarValor - formata um valor a partir de uma máscara
     * @param x - valor
     * @param s - Máscara
     * @return String com o valor formatado
     */
    public static String formatarValor(double x, String s) {
        try {
            DecimalFormat formatoValor = new DecimalFormat(s);
            return formatoValor.format(x);
        } catch (Exception e) {
            return "Formato inválido";
        }
    }
    
    /**
     * Formatar CPF
     * @param cpf
     * @return cpf formatado
     */
    public static String formatarCPF(String cpf) {
    	return
    	   cpf.substring(0, 3) + "." +
    	   cpf.substring(3, 6) + "." +
    	   cpf.substring(6, 9) + "-" +
    	   cpf.substring(9, 11);
    }

    /**
     * Formatar CNPJ
     * @param cnpj
     * @return cnpj formatado
     */
    public static String formatarCNPJ(String cnpj) {
    	return
    		cnpj.substring(0, 2) + "." +
    		cnpj.substring(2, 5) + "." +
    		cnpj.substring(5, 8) + "/" +
    		cnpj.substring(8, 12) + "-" +
    		cnpj.substring(12, 14);
    }
    
    /**
     * Método replicarStr - Replicar String
     * @param numStr - número de copias
     * @param s - String
     * @return String com numStr copias de s
     */
    public static String replicarStr (int numStr, String s){
        String resp = s;
        for (int i = 0; i < numStr; i++) resp += s;
        return resp;
    }
    /**
     * Método espacosLeft - Completar o campo com espaços a esquerda
     * @param tamCampo - tamanho do campo
     * @param s - String s
     * @return String com espaços a esquerda e com o tamanho especificado por tamCampo
     */
    public static String espacosLeft (int tamCampo, String s){
        String resp = s;
        for (int i = 0; i < tamCampo - s.length(); i++) resp = " " + resp;
        return resp;
    }
    /**
     * Método subtrairDatas - Mostrar como achar a diferença entre duas datas em dias
     * @param dt1 - data de inicio do intervalo
     * @param dt2 - data final do intervalo
     * @return inteiro tipo long com o número de dias entre as datas
     */
    public static long subtrairDatas(GregorianCalendar dt1, GregorianCalendar dt2) {
        // Subtrair duas datas
        long miliseg = dt2.getTimeInMillis() - dt1.getTimeInMillis();
        long dias = (miliseg/3600000)/24; // 1 hora = 60*60*1000 ms ; 1 dia = 24 hs
        return dias;
    }
    /**
     * Método subtrairHoras - Mostrar como achar a diferença entre duas datas / horas
     * @param dt1 - data/hora de inicio do intervalo
     * @param dt2 - data/hora final do intervalo
     * @param tipoRetorno - 1: retorna horas, 2: retorna milisegundos, 3: retorna minutos, 4: retorna segundos
     * @return tipo double com o número de horas entre as datas
     */
    public static double subtrairHoras(GregorianCalendar dt1, GregorianCalendar dt2, int tipoRetorno) {
        // Subtrair duas datas
    	double resposta = 0;
        double miliseg = dt2.getTimeInMillis() - dt1.getTimeInMillis();
        switch (tipoRetorno) {
			case RETORNAR_HORAS:
                resposta =  (miliseg/3600000.0); // 1 hora = 60*60*1000 ms ;
				break;
			case RETORNAR_MINUTOS:
                resposta =  (miliseg/60000.0); // 1 minuto = 60*1000 ms ;
				break;
			case RETORNAR_SEGUNDOS:
                resposta =  (miliseg/1000.0); // 1 segundo = 1000 ms ;
				break;	
			default:
				resposta = miliseg;
				break;
		}
        return resposta;
    }
    /**
     * Método formatarMilisegundos - Mostrar as horas formatada
     * @param miliseg - representa o horário em milisegundos
     * @param retorno - LtpLib.RETORNAR_SEGUNDOS ou LtpLib.RETORNAR_MILISEGUNDOS
     * @return um String formatado com hhh:mm:ss,SSS
     */
    public static String formatarMilisegundos(long miliseg, int retorno) {
		long totSeg = (long)miliseg / 1000;
		long segundos = (long) totSeg % 60;
		long minutos = (long)(totSeg / 60) % 60;
		long horas = (long)(totSeg / 3600);
		if (retorno==LtpLib.RETORNAR_SEGUNDOS){
			return new DecimalFormat("#,###,#00").format(horas) + ":" +
			   new DecimalFormat("00").format(minutos) + ":" +
			   new DecimalFormat("00").format(segundos);
		}
		return new DecimalFormat("#,###,#00").format(horas) + ":" +
			   new DecimalFormat("00").format(minutos) + ":" +
			   new DecimalFormat("00").format(segundos) + "," +
			   new DecimalFormat("000").format(miliseg-totSeg*1000);
    }
    /**
     * Método valorExtenso - Mostrar o valor por extenso
     * @param valor - representa o valor em reais
     * @return um String formatado com o valor por extenso
     */
    public static String valorExtenso(double valor){

        if (!(valor > 0 && valor <= 999999999.99)) {
            return "O Valor tem que estar entre 0 a R$999.999.999,99";
        }

        // Variaveis
        String [] vetor = {"","Um","Dois","Tres","Quatro","Cinco","Seis","Sete","Oito","Nove","Dez",
                                 "Onze","Doze","Treze","Quatroze","Quinze","Dezesseis","Dezessete","Dezoito",
                                 "Dezenove","","","Vinte","Trinta","Quarenta","Cinquenta","Sessenta","Setenta",
                                 "Oitenta","Noventa","","Cem","Duzentos","Trezentos","Quatrocentos","Quinhentos",
                                 "Seiscentos","Setecentos","Oitocentos","Novecentos"};

        String [] vNomClasse = {"","Real","Reais","Mil","Mil","Milhão","Milhões","Bilhão","Bilhões",
                                      "Centavo","Centavos"};

        long[] vClasse = new long[6];
        String[] vExtenCla = new String[6];
        int[] vAlg = new int[4];
        String vExtenso = "";
        int aux , aux2;
        boolean vDec;
        long vInt = 0;

        // Processamento

        long valorInt = (long)(valor * 100);
        valor = valorInt / 100.0;

        if (valor==0) {
            return "";
        }

        vExtenso = "";
        vDec = false;
        if ((long)valor < valor ) {
            vClasse[5] = (long)((valor * 100) - ((long)valor * 100));
            vDec = true;
        }

        aux = 0;
        vInt = (long)valor;
        while (vInt > 0) {
            vClasse[aux + 1] = (long)(vInt % 1000);
            vInt = vInt / 1000;
            aux++;
        }

        aux2 = 1;

        //centavos
        if (vDec) {
            vAlg[1] = (int)(vClasse[5] % 10);
            vAlg[2] = (int)((vClasse[5] % 100) / 10);
            vExtenCla[5] = "";
            if (vAlg[2] > 1) {
                vExtenCla[5] = vExtenCla[5] + vetor[vAlg[2] + 20];
                if (vAlg[1] != 0) vExtenCla[5] = vExtenCla[5] + " e " + vetor[vAlg[1]];
            } else {
                if (vAlg[2] == 1) vExtenCla[5] = vExtenCla[5] + vetor[vAlg[1] + 10];
                else if (vAlg[1] != 0) vExtenCla[5] = vExtenCla[5] + vetor[vAlg[1]];
            }
            if (!vExtenCla[5].equals("Um")) vExtenCla[5] = vExtenCla[5] + " " + vNomClasse[2 * 5];
            else vExtenCla[5] = vExtenCla[5] + " " + vNomClasse[(2 * 5) - 1];
        }
//		 ----------------------------------------------------------;

        while (aux2 <= aux) {
            vAlg[1] = (int)(vClasse[aux2] % 10);
            vAlg[2] = (int)((vClasse[aux2] % 100) / 10);
            vAlg[3] = (int)(vClasse[aux2] / 100);
            if (vAlg[3] != 0) {
                if ((vAlg[3] == 1) && ((vAlg[2] != 0) || (vAlg[1] != 0))) vExtenCla[aux2] = "Cento e ";
                else  {
                     vExtenCla[aux2] = vetor[vAlg[3] + 30];
                     if (vAlg[2] != 0 || vAlg[1] != 0) vExtenCla[aux2] = vExtenCla[aux2] + " e ";
                }
            } else {
                vExtenCla[aux2] = "";
            }

           if (vAlg[2] > 1) {
              vExtenCla[aux2] = vExtenCla[aux2] + vetor[vAlg[2] + 20];
              if (vAlg[1] != 0) vExtenCla[aux2] = vExtenCla[aux2] + " e " + vetor[vAlg[1]];
           } else {
              if (vAlg[2] == 1) vExtenCla[aux2] = vExtenCla[aux2] + vetor[vAlg[1] + 10];
              else if (vAlg[1] != 0) vExtenCla[aux2] = vExtenCla[aux2] + vetor[vAlg[1]];
           }
           if (!vExtenCla[aux2].equals("Um")) vExtenCla[aux2] = vExtenCla[aux2] + " " + vNomClasse[2 * aux2];
           else vExtenCla[aux2] = vExtenCla[aux2] + " " + vNomClasse[2 * aux2 - 1];

           aux2 = aux2 + 1;
        }  // Final Loop

        if (aux2 > 1) vExtenso = vExtenCla[aux2 - 1];

        aux2 = aux2 - 2;

        while (aux2 > 0) {
           if (vExtenCla[aux2].trim().equals("Mil")) {
                aux2 = aux2 - 1;
                 continue;
           }
           if (aux2 == 1) {
               if (vExtenCla[aux2].trim().toUpperCase().substring(0,3).equals("REA"))
                   vExtenso = vExtenso + "" + vExtenCla[aux2];
               else vExtenso = vExtenso + " e " + vExtenCla[aux2];
           }
           else vExtenso = vExtenso + ", " + vExtenCla[aux2];

           aux2 = aux2 - 1;
        }  // Fim While

        if (vDec)
           if (vExtenso.length() > 0) vExtenso = vExtenso +  " e " + vExtenCla[5];
           else vExtenso = vExtenso  + vExtenCla[5];

        return vExtenso + ".";

    }
    /**
    * Método lerArquivoObjetos - Ler a lista de objetos do arquivo de objetos, se ele existir
    * @param nomeArquivo - representa o nome do arquivo em que está armazenado os objetos da lista
    * @return Vector - referência para a lista de objetos controlados pela classe ArrayList
    * @throws Exception - Exceção de java.io
    */
    @SuppressWarnings("unchecked")
    public static Vector lerArquivoObjetos(String nomeArquivo) throws Exception {
        Vector listaObjetos = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo));
             listaObjetos = (Vector)in.readObject(); // Ler os objetos e carregar na lista
            in.close();
        } catch (ClassNotFoundException errObj1) {
            throw errObj1;
        } catch (IOException errObj2) {
            throw errObj2;
        }
        return listaObjetos;
   }
    /**
     * Método lerArquivoObjetosArray - Ler a lista de objetos do arquivo de objetos, se ele existir
     * @param nomeArquivo - representa o nome do arquivo em que está armazenado os objetos da lista
     * @return ArrayList - referência para a lista de objetos controlados pela classe ArrayList
     * @throws Exception - Exceção de java.io
     */
     @SuppressWarnings("unchecked")
     public static ArrayList lerArquivoObjetosArray(String nomeArquivo) throws Exception {
    	 ArrayList listaObjetos = null;
         try {
             ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo));
              listaObjetos = (ArrayList)in.readObject(); // Ler os objetos e carregar na lista
             in.close();
         } catch (ClassNotFoundException errObj1) {
             throw errObj1;

         } catch (IOException errObj2) {
             throw errObj2;
         }
         return listaObjetos;
    }
    
    /**
    * Método gravarArquivoObjetos - Grava a listas de objetos em um arquivo de objetos
    * @param nomeArquivo - representa o nome do arquivo em que será gravado os objetos da lista
    * @param listaObjetos - referência para os objetos da lista controlados pela classe Vector
    * @throws Exception - Exceção de java.io
    */
   @SuppressWarnings("unchecked")
   public static void gravarArquivoObjetos(String nomeArquivo, Vector listaObjetos) throws Exception {
    try {
          ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo));
          out.writeObject(listaObjetos);  // Gravar todos os objetos da lista
          out.close();
    } catch (IOException errObj) {
    	throw errObj;
    }
   }
   /**
    * Método gravarArquivoObjetosArray - Grava a listas de objetos em um arquivo de objetos
    * @param nomeArquivo - representa o nome do arquivo em que será gravado os objetos da lista
    * @param listaObjetos - referência para os objetos da lista controlados pela classe ArrayList
    * @throws Exception - Exceção de java.io
    */
   @SuppressWarnings("unchecked")
   public static void gravarArquivoObjetosArray(String nomeArquivo, ArrayList listaObjetos) throws Exception {
    try {
          ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo));
          out.writeObject(listaObjetos);  // Gravar todos os objetos da lista
          out.close();
    } catch (IOException errObj) {
    	throw errObj;
    }
   }
   
   public static GregorianCalendar[] datasVencimento (int numParc, GregorianCalendar dataBase)  {
	   GregorianCalendar[] resposta = new GregorianCalendar[numParc];
	   // criação dos objetos
	   for (int i=0; i<numParc; i++) {
		   GregorianCalendar data = (GregorianCalendar)dataBase.clone();
		   data.add(GregorianCalendar.DAY_OF_MONTH, 30*(i+1));
		   resposta[i] = ajustarFimSemana(data);
	   }
	   return resposta;
   }
   
   public static GregorianCalendar[] datasAno (int ano, int diaSemana) {
	   
	   // Calcular a quantidade de dias do ano 
	   // em função do dia da semana
	   int numDatas = 0;
	   GregorianCalendar data = new GregorianCalendar(ano,0,1);
	   while (ano==data.get(GregorianCalendar.YEAR) ) {
		  if (data.get(GregorianCalendar.DAY_OF_WEEK)==diaSemana) {
			  numDatas++;
		  }
		  data.add(GregorianCalendar.DAY_OF_MONTH, 1);
	   }
	   
	   GregorianCalendar[] objDatas = new GregorianCalendar[numDatas];
	   
	   // Criar os objetos e preencher o array 
	   // com suas referencias
	   
	   data.set(ano,0,1);
	   int i = 0;
	   while (ano==data.get(GregorianCalendar.YEAR) ) {
		  if (data.get(GregorianCalendar.DAY_OF_WEEK)==diaSemana) {
			  // criar objeto
			  objDatas[i] = (GregorianCalendar)data.clone();
			  i++;
		  }
		  data.add(GregorianCalendar.DAY_OF_MONTH, 1);
	   }
	   
	   return objDatas;
   }
   
   // Retorna a maior data de admissão
   public static GregorianCalendar maiorDataAdm(GregorianCalendar[] datas) {
	   Arrays.sort(datas);
	   return datas[datas.length-1]; 
   }
   // Retornar um texto com padronização especial
   public static String padronizacaoEspecialTexto(String texto){
	   String wTexto = padronizarTexto(texto).toLowerCase();
	   String[] palavras = wTexto.split(" ");
	   String resposta = "";
	   for (int i=0;i<palavras.length;i++){
		   if (palavras[i].length() > 2) {
			   palavras[i] = palavras[i].substring(0,1).toUpperCase() +
			                 palavras[i].substring(1);
		   }
		   resposta += palavras[i] + " ";
	   }
	   return resposta.trim();
   }
   
   // Retornar um array com as palavras em ordem alfabética
   public static String[] palavrasTexto(String texto) {
	   String[] palavras = padronizarTexto(texto).split(" ");
	   Arrays.sort(palavras);
	   return palavras;
   }
   

}