
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Este programa abre uma conexão TCP/IP com um servidor e envia
 * a este uma série de números inteiros. Para cada número enviado,
 * um valor lógico é recebido como resposta indicando se o número
 * é positivo (true) ou negativo (false). Zero provoca o encerramento
 * da conexão com o servidor.
 */
public class RedeClient {

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Utilização: java RedeClient <host>");
			System.exit(-1);
		}
		
		try {
			Socket s = new Socket(args[0],5432);
			
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			
			Scanner in = new Scanner(System.in);
			int i = in.nextInt();
			
			System.out.println("Informe um número inteiro (0 para encerrar)");
			dos.writeInt(i);
			
			while(i != 0) {
				boolean positivo = dis.readBoolean();
				System.out.println(i + ": " + (positivo ? "positivo" : "negativo"));
				System.out.println("Informe um número inteiro (0 para encerrar)");
				i = in.nextInt();
				dos.writeInt(i);
			}
			
			s.close();
			
		} catch (Exception e) {
			System.err.println("Exceção encontrada: " + e);
		}
	}

}