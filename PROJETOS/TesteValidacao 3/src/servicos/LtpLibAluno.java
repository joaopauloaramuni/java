package servicos;

import java.util.GregorianCalendar;

public class LtpLibAluno {

	/**
	 * Método validarCPF - Validação do DV do CPF
	 * 
	 * @param cpf
	 *            String com o CPF
	 * @return true para CPF com dv correto
	 */
	public static boolean validarCPF(String cpf) {

		if (cpf.length() != 11 || !cpf.matches("[0-9]*"))
			return false;

		String fator = "100908070605040302";
		String fator2 = "111009080706050403";

		int tot1 = 0;
		int tot2 = 0;
		int j = 0;

		for (int i = 0; i <= 8; i++) {
			tot1 += Integer.parseInt(cpf.substring(i, i + 1))
					* Integer.parseInt(fator.substring(j, j + 2));
			tot2 += Integer.parseInt(cpf.substring(i, i + 1))
					* Integer.parseInt(fator2.substring(j, j + 2));
			j += 2;
		}
		int dv1 = 11 - (tot1 % 11);
		if (dv1 > 9)
			dv1 = 0;
		tot2 += dv1 * 2;
		int dv2 = 11 - (tot2 % 11);
		if (dv2 > 9)
			dv2 = 0;

		return cpf.substring(9, 11).equals("" + dv1 + dv2);

	}

	/**
	 * Método validarCNPJ - Validação do DV do CNPJ
	 * 
	 * @param cnpj
	 *            String com o CNPJ
	 * @return true para CNPJ com dv correto
	 */
	public static boolean validarCNPJ(String cnpj) {

		if (cnpj.length() != 14 || !cnpj.matches("[0-9]*"))
			return false;

		String fator = "543298765432";
		String fator2 = "654329876543";

		int tot1 = 0, tot2 = 0;
		for (int i = 0; i <= 11; i++) {
			tot1 += Integer.parseInt(cnpj.substring(i, i + 1))
					* Integer.parseInt(fator.substring(i, i + 1));
			tot2 += Integer.parseInt(cnpj.substring(i, i + 1))
					* Integer.parseInt(fator2.substring(i, i + 1));
		}

		int dv1 = 11 - (tot1 % 11);
		if (dv1 > 9)
			dv1 = 0;

		tot2 += dv1 * 2;
		int dv2 = 11 - (tot2 % 11);
		if (dv2 > 9)
			dv2 = 0;

		return cnpj.substring(12, 14).equals("" + dv1 + dv2);

	}

	/**
	 * Método validarPIS - Validação do DV do PIS
	 * 
	 * @param pis
	 *            String com o PIS
	 * @return true para PIS com dv correto
	 */
	public static boolean validarPIS(String pis) {

		if (pis.length() != 11 || !pis.matches("[0-9]*"))
			return false;

		String fator = "3298765432";

		int tot1 = 0;
		for (int i = 0; i <= 9; i++) {
			tot1 += Integer.parseInt(pis.substring(i, i + 1))
					* Integer.parseInt(fator.substring(i, i + 1));
		}

		int dv1 = 11 - (tot1 % 11);
		if (dv1 > 9)
			dv1 = 0;

		return pis.substring(10, 11).equals("" + dv1);

	}

	/**
	 * Método validarEmail - Validação básica de E-mail
	 * 
	 * @param email
	 *            String com a E-mail
	 * @return true para E-Mail válido
	 */
	public static boolean validarEmail(String email) {

		if (email.charAt(0) == '@' || email.charAt(email.length() - 1) == '@'
				|| email.charAt(0) == '.'
				|| email.charAt(email.length() - 1) == '.')
			return false;
		int cont = 0, cont2 = 0;
		for (int i = 0; i < email.length(); i++) {
			if (email.charAt(i) == '@')
				cont++;
			if (email.charAt(i) == ' ')
				cont2++;
		}
		if (cont == 1 && cont2 == 0 && email.indexOf("..") == -1
				&& email.charAt(email.length() - 4) == '.' 
				|| email.charAt(email.length() - 3) == '.')
			return true;
		else
			return false;

	}

	/**
	 * Método padronizarTexto - Excluir espaços a esquerda, a direita e excesso
	 * entre palavras
	 * 
	 * @param s
	 *            String com o Texto
	 * @return String com o texto padronizado
	 */
	public static String padronizarTexto(String texto) {

		texto = texto.trim(); // Retorna sem espaços nas extremidades
		while (texto.indexOf("  ") >= 0)
			// Verificar excessos de espaços
			texto = texto.replaceAll("  ", " "); // Substitui 2 espaços por 1
		return texto;
	}

	/**
	 * Contar palavras do texto
	 * 
	 * @param texto
	 * @return o numero de palavras
	 */
	public static int contarPalavras(String texto) {

		if (texto.equals(""))
			return 0;
		// if (texto.isEmpty()) return 0;
		// if (texto.length() == 0) return 0;
		texto = padronizarTexto(texto);
		int cont = 1;
		for (int i = 0; i < texto.length(); i++) {
			if (texto.charAt(i) == ' ')
				cont++;
			// if (texto.substring(i,i+1).equals(" ")) cont++;
		}
		return cont;
	}

	// Outro Método para contar palavras do testo
	public static int contarPalavras2(String texto) {
		if (texto.isEmpty())
			return 0;
		texto = texto.trim();
		int cont = 0;
		for (int i = 0; i < texto.length(); i++) {
			if (texto.charAt(i) == ' ' && texto.charAt(i + 1) != ' ')
				cont++;
		}
		return ++cont;
	}

	public static int verificaPalavra(String texto, String palavra) {

		/*int cont = 0, i = 0;
		while (texto.toUpperCase().indexOf(palavra.toUpperCase(), i) >= 0) {
			cont++;
			i += palavra.length();
		}

		return cont;*/
		
		int cont = 0;
		
		while(texto.toUpperCase().indexOf(palavra.toUpperCase()) != -1){
			texto = texto.substring(texto.toUpperCase().indexOf(palavra.toUpperCase())+palavra.length());
			cont++;
		}  
		return cont;
		
	}

	public static String verificaUltimaPalavra(String texto) {
		
		return texto.trim().substring(texto.trim().lastIndexOf(" ") + 1);

	}
	//public static int[] posicoesPalavTexto(String texto, String palavra){}
	
	public static GregorianCalendar ajustarFimSemana(GregorianCalendar dt){
		
		switch(dt.get(GregorianCalendar.DAY_OF_WEEK)){
		case 1:
			dt.add(GregorianCalendar.DAY_OF_MONTH,1);
			break;
		case 7:
			dt.add(GregorianCalendar.DAY_OF_MONTH,2);
			break;
		}
		return dt;
	}
	public static int[] quantDiasCadaMesDoAno(int ano){
		
		int[] dias = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		
		GregorianCalendar data = new GregorianCalendar(ano, 1, 1);
		
		if (data.isLeapYear(ano))
			dias[1] = 29;
		
		return dias;
	}
	
	/**
	 * Calendário Mensal
	 * @param mes
	 * @param ano
	 * @return todas as datas do mes/ano em um array
	 */
	public static GregorianCalendar[] calendarioMensal(int mes, int ano) {
		
		int[] dias = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		GregorianCalendar dataBase = new GregorianCalendar(ano, mes - 1, 1);

		if (dataBase.isLeapYear(ano))
			dias[1] = 29;

		GregorianCalendar[] datasMes = new GregorianCalendar[dias[mes - 1]];

		for (int i = 0; i < datasMes.length; i++) {
			datasMes[i] = dataBase;
			dataBase = (GregorianCalendar) dataBase.clone();
			dataBase.add(GregorianCalendar.DAY_OF_MONTH, 1);
		}
		
		return datasMes;
	}
}
