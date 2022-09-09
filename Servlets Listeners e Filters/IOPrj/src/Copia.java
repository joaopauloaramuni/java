import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class Copia {

	public static void main(String[] args) {
		
		if(args.length != 2) {
			System.out.println("Utilização: java Copia <entrada> <saída>");
			System.exit(-1);
		}
		
		try {
			InputStream in = new FileInputStream(args[0]);
			OutputStream out = new FileOutputStream(args[1]);
			int b;
			while((b = in.read()) != -1) {
				out.write(b);
			}
			System.out.println("Copiado " + args[0] + " para " + args[1]);
			in.close();
			out.close();
		} catch (IOException e) {
			System.out.println("Erro na cópia: " + e.getMessage());
		}
		
	}

}
