package PrjCliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;

/**
 * DSD - Desenvolvimento de Sistemas Distribu�dos
 * Cap 6
 * Data: 24/11/2013
 * @author Jo�o Paulo Aramuni
 *
 */
public class LocClient {

	public static void main(String[] args) throws Exception {
		socket1 = new Socket("127.0.0.1", 2018);
		socket2 = new Socket("127.0.0.1", 2018);
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						String[] msg = new BufferedReader(
								new InputStreamReader(socket2.getInputStream()))
								.readLine().split("&");
						Client client = clientes.get(msg[0]);
						if (msg[1].equals("search")) {
							PrintWriter out = new PrintWriter(socket2
									.getOutputStream());
							out.println(client.getDebit() + "");
							out.flush();
						} else {
							client.setDebit(Integer.parseInt(msg[2]));
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		while (true) {
			System.out.println("Menu");
			System.out.println("1- Debito.");
			System.out.println("2- Atualizar");
			System.out.println("3- Add cliente");
			System.out.println("4- Delete cliente.");
			System.out.println("Op��o:");
			int opcao = 0;
			while (true) {
				try {
					opcao = Integer.parseInt(new BufferedReader(
							new InputStreamReader(System.in)).readLine());
					if (opcao > 0)
						break;
				} catch (Exception e) {
				}
				System.out.println("Numero errado.");
			}
			switch (opcao) {
			case 1:
				debit();
				break;
			case 2:
				update();
				break;
			case 3:
				add();
				break;
			case 4:
				delete();
				break;
			default:
				return;
			}
		}
	}

	// Variaveis....
	private static Socket socket1;
	private static Socket socket2;
	private static HashMap<String, Client> clientes = new HashMap<String, Client>();

	private static void add() throws Exception {
		PrintWriter out = new PrintWriter(socket1.getOutputStream());
		out.println("3");
		out.flush();
		System.out.println("N�mero de Identifica��o:");
		String number = new BufferedReader(new InputStreamReader(System.in))
				.readLine();
		System.out.println("Nome:");
		String name = new BufferedReader(new InputStreamReader(System.in))
				.readLine();
		out = new PrintWriter(socket1.getOutputStream());
		out.println(number);
		out.flush();
		if ("cadastrado".equals(new BufferedReader(new InputStreamReader(
				socket1.getInputStream())).readLine())) {
			clientes.put(number, new Client(name, 0));
			System.out.println("Sucesso: cliente cadastrado.");
		} else
			System.out.println("Aviso: cliente j� cadastrado.");
	}

	private static void delete() throws Exception {
		PrintWriter out = new PrintWriter(socket1.getOutputStream());
		out.println("4");
		out.flush();
		System.out.println("N�mero de Identifica��o: ");
		String number = new BufferedReader(new InputStreamReader(System.in))
				.readLine();
		out = new PrintWriter(socket1.getOutputStream());
		out.println(number);
		out.flush();
		if ("removido".equals(new BufferedReader(new InputStreamReader(socket1
				.getInputStream())).readLine()))
			System.out.println("Sucesso: cliente removido.");
		else
			System.out.println("Aviso: cliente n�o encontrado");
	}

	private static void debit() throws IOException {
		PrintWriter out = new PrintWriter(socket1.getOutputStream());
		out.println("1");
		out.flush();
		System.out.println("N�mero de identifica��o: ");
		String number = new BufferedReader(new InputStreamReader(System.in))
				.readLine();
		out = new PrintWriter(socket1.getOutputStream());
		out.println(number);
		out.flush();
		String debito = new BufferedReader(new InputStreamReader(
				socket1.getInputStream())).readLine();
		if ("".equals(debito))
			System.out.println("Aviso: cliente n�o encontrado");
		else
			System.out.println("Sucesso: debito � R$" + debito);
	}

	private static void update() throws Exception {
		PrintWriter out = new PrintWriter(socket1.getOutputStream());
		out.println("2");
		out.flush();
		System.out.println("N�mero de identifica��o: ");
		String number = new BufferedReader(new InputStreamReader(System.in))
				.readLine();
		out = new PrintWriter(socket1.getOutputStream());
		out.println(number);
		out.flush();
		System.out.println("Novo valor: ");
		String debit = new BufferedReader(new InputStreamReader(System.in))
				.readLine();
		out = new PrintWriter(socket1.getOutputStream());
		out.println(debit);
		out.flush();
		if ("atualizado".equals(new BufferedReader(new InputStreamReader(
				socket1.getInputStream())).readLine())) {
			System.out.println("Sucesso: debito atualizado");
		} else
			System.out.println("Aviso: cliente n�o encontrado");
	}

}
