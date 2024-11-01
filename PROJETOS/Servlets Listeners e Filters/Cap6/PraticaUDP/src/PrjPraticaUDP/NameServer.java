package PrjPraticaUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.security.InvalidParameterException;

import exceptions.InsertException;
import exceptions.SearchException;

/**
 * DSD - Desenvolvimento de Sistemas Distribuídos
 * Cap 6
 * Data: 24/11/2013
 * @author João Paulo Aramuni
 *
 */
public class NameServer {

	private int _maxBuffer = 1024;
	static int _porta = -1;
	private NameTable _names = new NameTable();
	private String _usuario = "[SERVER]";

	public NameServer(int porta) {
		if (porta < 0 || porta <= 1024)
			throw new InvalidParameterException("Valor inválido para porta");
		_porta = porta;

	}

	public void listen() throws IOException {

		byte[] buffer = new byte[_maxBuffer];
		DatagramPacket packetReceive = new DatagramPacket(buffer, _maxBuffer);

		DatagramSocket socketServer = new DatagramSocket(_porta);
		;
		Utils.WriteTrace(_usuario, String.format(
				"Servidor iniciado IP: %s (%s)  portaA: %d ...", InetAddress
						.getLocalHost().getHostAddress(), InetAddress
						.getLocalHost().getHostName(), _porta));

		while (true) {
			try {
				Utils.printLine();
				Utils.WriteTrace("Aguardando pacotes ...");
				socketServer.receive(packetReceive);

				Utils.WriteDateNow("Pacote recebido...");

				byte[] bytesReceived = packetReceive.getData();

				String cmdMessage = new String(bytesReceived, 0,
						packetReceive.getLength());

				Utils.WriteTrace("Mensagem recebida: " + cmdMessage);
				Utils.WriteTrace(String.format(
						"Remetente : IP %s  - HostName %s", packetReceive
								.getAddress().getHostAddress(), packetReceive
								.getAddress().getHostName()));

				DatagramPacket packToClient = null;

				try {
					TypeMessage tpMsg = _names.Validate(cmdMessage);

					if (tpMsg == TypeMessage.Insert) {
						_names.InsertName(cmdMessage);
						packToClient = createPacket("Result : 1 ( Sucesso ) ",
								packetReceive.getAddress(),
								packetReceive.getPort());
					} else if (tpMsg == TypeMessage.Search) {
						String hostFound = null;
						if (tpMsg == TypeMessage.Search)
							hostFound = _names.SearchName(cmdMessage
									.substring(cmdMessage.indexOf(' ') + 1));
						packToClient = createPacket("Result : 1 - \n"
								+ hostFound, packetReceive.getAddress(),
								packetReceive.getPort());
					} else {
						packToClient = createPacket(
								"Result : 1 - Nomes registrados :\n"
										+ _names.List(),
								packetReceive.getAddress(),
								packetReceive.getPort());
					}
				} catch (InsertException e) {
					String errorMessage = " Result: 0\n Detalhes : "
							+ e.getMessage();
					socketServer
							.send(createPacket(errorMessage,
									packetReceive.getAddress(),
									packetReceive.getPort()));

					WriteCommandException(e);
					continue;
				} catch (SearchException e) {
					String errorMessage = " Result: 0\n Detalhes : "
							+ e.getMessage();
					socketServer
							.send(createPacket(errorMessage,
									packetReceive.getAddress(),
									packetReceive.getPort()));

					WriteCommandException(e);
					continue;
				}

				socketServer.send(packToClient);

				packToClient = null;
				
				socketServer.close();
				
				Utils.WriteTrace("Sucesso!!! : " + cmdMessage);

			} catch (Exception e) {
				String message = " Result: -1 (Erro inesperado) \n\tErro : "
						+ e.getMessage();
				DatagramPacket returnPacket = createPacket(message,
						packetReceive.getAddress(), packetReceive.getPort());
				socketServer.send(returnPacket);
				WriteCommandException(e);
			}
		}
	}

	private void WriteCommandException(Exception e) {
		Utils.WriteTrace("Erro. Motivo : " + e.getMessage());

	}

	private DatagramPacket createPacket(String message, InetAddress address,
			int porta) {
		byte[] byteMsg = message.getBytes();
		DatagramPacket returnPacket = new DatagramPacket(byteMsg,
				byteMsg.length, address, porta);

		return returnPacket;
	}

	public static void main(String[] args) {
		NameServer server = new NameServer(2060);
		try {
			server.listen();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
