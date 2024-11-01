import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class DoubleIO {

	public static void main(String[] args) {
		
		double d = 1.5;
		
		try {
			OutputStream out = new FileOutputStream("dados.txt");
			DataOutputStream dout = new DataOutputStream(out);
			
			dout.writeDouble(d);
			dout.close();
			
			System.out.println("Double gravado");
			
			DataInputStream din = new DataInputStream(new FileInputStream("dados.txt"));
			double e = din.readDouble();
			System.out.println("Lido: " + e);
			din.close();
		} catch (IOException e) {
		}
	}

}
