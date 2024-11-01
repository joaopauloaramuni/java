package validacao;

public class Validar {

	public String validarCPF(String cpf) {

		if (cpf.length() != 11 || !cpf.matches("[0-9]*"))
			return "CPF Inválido.";

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

		return (cpf.substring(9, 11).equals("" + dv1 + dv2)) ? "CPF Válido."
				: "CPF Inválido.";
	}

	public String validarCNPJ(String cnpj) {
		if (cnpj.length() != 14 || !cnpj.matches("[0-9]*"))
			return "CNPJ Inválido.";

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

		return (cnpj.substring(12, 14).equals("" + dv1 + dv2)) ? "CNPJ Válido."
				: "CNPJ Inválido.";
	}

	public String validarPIS(String pis) {
		if (pis.length() != 11 || !pis.matches("[0-9]*"))
			return "PIS Inválido.";

		String fator = "3298765432";

		int tot1 = 0;
		for (int i = 0; i <= 9; i++) {
			tot1 += Integer.parseInt(pis.substring(i, i + 1))
					* Integer.parseInt(fator.substring(i, i + 1));
		}

		int dv1 = 11 - (tot1 % 11);
		if (dv1 > 9)
			dv1 = 0;

		return (pis.substring(10, 11).equals("" + dv1)) ? "PIS Válido."
				: "PIS Inválido.";
	}

	public String validarEMAIL(String email) {
		if (email.charAt(0) == '@' || email.charAt(email.length() - 1) == '@'
				|| email.charAt(0) == '.'
				|| email.charAt(email.length() - 1) == '.')
			return "Email Inválido.";
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
			return "Email Válido.";
		else
			return "Email Inválido.";
	}
}
