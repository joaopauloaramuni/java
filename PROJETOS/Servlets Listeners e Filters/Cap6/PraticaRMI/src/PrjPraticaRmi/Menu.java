package PrjPraticaRmi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu extends Locadora {

	public static void main(String[] args) {

		BufferedReader stdinp = new BufferedReader(new InputStreamReader(
				System.in));

		String nomeCliente;
		Float debito;

		while (true) {
			try {

				nomeCliente = null;
				debito = null;

				System.out.println("Ação:");
				System.out.println("1 - Adicionar cliente");
				System.out.println("2 - Consultar débito do cliente");
				System.out.println("3 - Atualizar débito do cliente");
				System.out.println("4 - Remover cliente");

				System.out.println("Informe o comando desejado");
				String comando = stdinp.readLine();

				if (comando.equals("1")) {
					System.out.println("Informe o nome do cliente:");
					nomeCliente = stdinp.readLine();
					try {
						InserirCliente(nomeCliente);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

				if (comando.equals("2")) {
					System.out.println("Nome do cliente:");
					nomeCliente = stdinp.readLine();
					debito = ConsultarDebito(nomeCliente);
					if (!(debito < 0.0f))
						System.out.println("Débito do cliente " + nomeCliente
								+ " é igual a " + debito);
					else
						System.out.println("Cliente não existe nos servidores");
				}

				if (comando.equals("3")) {
					System.out.println("Nome do cliente:");
					nomeCliente = stdinp.readLine();
					System.out.println("Débito-->>:");
					debito = Float.parseFloat(stdinp.readLine());
					AtualizarDebitoCliente(nomeCliente, debito);
					System.out
							.println("Débito do cliente atualizao com sucesso.");
				}

				if (comando.equals("4")) {
					System.out.println("Nome do cliente:");
					nomeCliente = stdinp.readLine();
					RemoverCliente(nomeCliente);
					System.out.println("Cliente remvido com sucesso");
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
