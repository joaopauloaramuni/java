package webservice;

import javax.jws.WebService;

@WebService(endpointInterface = "webservice.Validador")
public class ValidadorImpl implements Validador {

	/**
	 * Método validarCPF
	 * 
	 * @param cpf
	 * @return "Correto" ou "Incorreto"
	 */
	public String validaCPF(String cpf) {

		if (cpf.length() != 11 || !cpf.matches("[0-9]*"))
			return "Incorreto!";

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

		if (cpf.substring(9, 11).equals("" + dv1 + dv2))
			return "Correto!";
		else
			return "Incorreto!";

	}
}
