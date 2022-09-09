package PrjPraticaUDP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.InvalidParameterException;

/**
 * DSD - Desenvolvimento de Sistemas Distribuídos
 * Cap 6
 * Data: 24/11/2013
 * @author João Paulo Aramuni
 *
 */
public class NameClient {

	private String _servidor = null;
	private int _porta = -1;
	private String _usuario = "[CLIENT]";
	private int _len = 1024;

	public NameClient(String servidor, int porta) {
		if (porta <= 1024)
			throw new InvalidParameterException(
					"Valor inválido para especificação de portaa. Parametro : "
							+ porta);

		_servidor = servidor;
		_porta = porta;
	}

	public static void main(String[] args) {
		new NameClient("localhost", 2060).startClient();
	}

	public void startClient() {

		try {
			Utils.WriteTrace(String.format("Cliente iniciado IP: %s (%s) ...",
					InetAddress.getLocalHost().getHostAddress(), InetAddress
							.getLocalHost().getHostName()));
			while (true) {
				Utils.printLine();
				Utils.WriteTrace(" Aguardando comando...");

				DatagramPacket sendPacket, receivedPacket;

				try {

					BufferedReader stdinp = new BufferedReader(
							new InputStreamReader(System.in));

					// Entrada de Dados
					String echoline = stdinp.readLine();
					if (echoline.equals("done"))
						break;

					// Endereço do servidor para enviar o pacote
					InetAddress ia = InetAddress.getByName(_servidor);

					DatagramSocket datasocket = new DatagramSocket();

					byte[] buffer = new byte[echoline.length()];

					buffer = echoline.getBytes();

					// Pacote que será enviado
					sendPacket = new DatagramPacket(buffer, buffer.length, ia,
							_porta);

					// Envia o pacote para o servidor
					datasocket.send(sendPacket);
					Utils.WriteTrace(
							_usuario,
							String.format(
									"Mensagem enviada para o servidor %s  porta %d ... ",
									_servidor, _porta));

					byte[] rbuffer = new byte[_len];

					receivedPacket = new DatagramPacket(rbuffer, rbuffer.length);

					// Aguarda recebimento de mensagem do servidor
					Utils.WriteTrace(_usuario, "Aguardando servidor...");
					datasocket.receive(receivedPacket);

					// Servidor recebeu a mensagem 
					String retstring = new String(receivedPacket.getData(), 0,
							receivedPacket.getLength());

					Utils.WriteTrace(_usuario, "Mensagem recebida : "
							+ retstring, false);
					
					datasocket.close();
					
				} catch (Exception e) {
					Utils.WriteRed(e.getMessage());
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} finally {

		}
		Utils.WriteDateNow("Sessão finlizada.");
	}

	public String get_servidor() {
		return _servidor;
	}

	public void set_servidor(String _servidor) {
		this._servidor = _servidor;
	}

	public int get_porta() {
		return _porta;
	}

	public void set_porta(int _porta) {
		this._porta = _porta;
	}

	public int get_len() {
		return _len;
	}

	public void set_len(int _len) {
		this._len = _len;
	}

}
