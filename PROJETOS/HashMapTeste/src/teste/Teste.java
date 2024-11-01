package teste;

import java.util.HashMap;
import java.util.Map;

public class Teste {

	public static void main(String args[]) {

		Map<String, String> example = new HashMap<String, String>();

		/*
		 * Vamos adicionar alguns valores a nossa lista
		 */
		example.put("00000000000", new String("pessoa 0"));
		example.put("11111111111", new String("pessoa 1"));
		example.put("22222222222", new String("pessoa 2"));
		example.put("33333333333", new String("pessoa 3"));
		example.put("44444444444", new String("pessoa 4"));

		String keyToSearch = "00000000000";

		if (example.containsKey(keyToSearch)) {
			System.out.println("Valor da Chave " + keyToSearch + " = " + example.get(keyToSearch));
		} else {
			System.err.println("Chave não existe");
		}

	}

}