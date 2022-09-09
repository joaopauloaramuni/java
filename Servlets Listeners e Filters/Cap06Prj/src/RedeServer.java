import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Este programa é um servidor multicliente que trata cada novo cliente
 * em uma thread exclusiva. Ele recebe uma série de números inteiros do
 * cliente e devolve como resposta um valor lógico indicando se o número
 * recebido é positivo (true) ou negativo (false). O recebimento de zero
 * é interpretado como uma indicação para o encerramento da conexão com
 * o cliente.
 */
public class RedeServer {

	public static void main(String[] args) {
		ServerSocket s = null;
		try {
			s = new ServerSocket(5432);
		} catch (IOException e) {
			System.err.println("Erro na abertura do socket: " + s);
			System.exit(-1);
		}
		
		while(true) {
			try {
				System.out.println("Aguardando conexões");
				Socket sc = s.accept();
				System.out.println("Cliente conectado");
				new Conexao(sc).start();
			} catch (IOException e) {
			}
		}
	}

}

class Conexao extends Thread {
	private Socket s = null;
	
	public Conexao(Socket s) {
		this.s = s;
	}
	
	public void run() {
		try {
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			
			int i = dis.readInt();
			while(i != 0) {
				dos.writeBoolean(i > 0);
				i = dis.readInt();
			}
			
			System.out.println("Encerrando conexão");
			s.close();
		} catch (IOException e) {}
	}
}