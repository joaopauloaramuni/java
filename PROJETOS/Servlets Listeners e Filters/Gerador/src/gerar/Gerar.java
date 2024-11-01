package gerar;

import java.util.Random;

public class Gerar {
	
	private String num;
	private Random rnd = new Random();
	private Validar vld = new Validar();

	public String gerarDados(int tipo, int length) {
		num = "";
		do {
			num += rnd.nextInt();
			if (num.length() > length)
				num = num.substring(0, length);
		} while (num.length() != length);

		switch (tipo) {
		case 1:
			if (vld.validarCPF(num))
				return num;
			else
				return gerarDados(tipo, length);
		case 2:
			if (vld.validarCNPJ(num))
				return num;
			else
				return gerarDados(tipo, length);
		case 3:
			if (vld.validarPIS(num))
				return num;
			else
				return gerarDados(tipo, length);
		default:
			break;
		}
		return "";
	}
}
