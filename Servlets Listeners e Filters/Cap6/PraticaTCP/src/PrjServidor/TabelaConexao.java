package PrjServidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Vector;

/**
 * DSD - Desenvolvimento de Sistemas Distribuídos
 * Cap 6
 * Data: 24/11/2013
 * @author João Paulo Aramuni
 *
 */
public class TabelaConexao implements Runnable {

	public TabelaConexao(Socket socket1, Socket socket2,
			HashMap<String, String> clients, Vector<TabelaConexao> filiais) {
		this.socket1 = socket1;
		this.socket2 = socket2;
		this.clients = clients;
		this.filiais = filiais;
	}

	public void run() {
		try {

			while (true) {
				String op = new BufferedReader(new InputStreamReader(
						socket1.getInputStream())).readLine();
				switch (Integer.parseInt(op)) {
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
				}
			}
		} catch (Exception e) {
		}
	}

	public void add() throws IOException {
		String cpf = new BufferedReader(new InputStreamReader(
				socket1.getInputStream())).readLine();
		if (!(clients.get(cpf) instanceof String)) {
			System.out.println(socket1.toString());
			clients.put(cpf, socket1.toString());
			PrintWriter out = new PrintWriter(socket1.getOutputStream());
			out.println("cadastrado");
			out.flush();
		} else {
			PrintWriter out = new PrintWriter(socket1.getOutputStream());
			out.println("");
			out.flush();
		}
	}

	public void delete() throws IOException {
		String cpf = new BufferedReader(new InputStreamReader(
				socket1.getInputStream())).readLine();
		if (clients.remove(cpf) instanceof String) {
			PrintWriter out = new PrintWriter(socket1.getOutputStream());
			out.println("removido");
			out.flush();
		} else {
			PrintWriter out = new PrintWriter(socket1.getOutputStream());
			out.println("");
			out.flush();
		}
	}

	public void debit() throws IOException {
		String cpf = new BufferedReader(new InputStreamReader(
				socket1.getInputStream())).readLine();
		String ip1 = clients.get(cpf);
		if (ip1 instanceof String) {
			for (TabelaConexao filial : filiais) {
				System.out.println(ip1 + " = " + filial.socket1.toString());
				if (ip1.equals(filial.socket1.toString())) {
					PrintWriter out = new PrintWriter(socket2.getOutputStream());
					out.println(cpf + "&search");
					out.flush();
					out = new PrintWriter(socket1.getOutputStream());
					out.println(new BufferedReader(new InputStreamReader(
							socket2.getInputStream())).readLine());
					out.flush();
					break;
				}
			}
		} else {
			PrintWriter out = new PrintWriter(socket1.getOutputStream());
			out.println("");
			out.flush();
		}
	}

	public void update() throws IOException {
		String number = new BufferedReader(new InputStreamReader(
				socket1.getInputStream())).readLine();
		String debit = new BufferedReader(new InputStreamReader(
				socket1.getInputStream())).readLine();
		String socketToString = clients.get(number);
		if (socketToString instanceof String) {
			for (TabelaConexao filial : filiais) {
				System.out.println(socketToString + " = "
						+ filial.socket1.toString());
				if (socketToString.equals(filial.socket1.toString())) {
					PrintWriter out = new PrintWriter(socket2.getOutputStream());
					out.println(number + "&update&" + debit);
					out.flush();
					out = new PrintWriter(socket1.getOutputStream());
					out.println("atualizado");
					out.flush();
					break;
				}
			}
		} else {
			PrintWriter out = new PrintWriter(socket1.getOutputStream());
			out.println("");
			out.flush();
		}
	}

	private Socket socket1;
	private Socket socket2;
	private HashMap<String, String> clients = new HashMap<String, String>();
	private Vector<TabelaConexao> filiais = new Vector<TabelaConexao>();
}
