import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Memoria {

	public static void main(String[] args) {
		
		double d = 1.5;
		
		try {
			OutputStream out = new ByteArrayOutputStream();
			DataOutputStream dout = new DataOutputStream(out);
			
			dout.writeDouble(d);
			dout.close();
			
			byte[] buf = ((ByteArrayOutputStream)out).toByteArray();
			
			System.out.println("Double gravado");
			
			DataInputStream din = new DataInputStream(new ByteArrayInputStream(buf));
			double e = din.readDouble();
			System.out.println("Lido: " + e);
			din.close();
		} catch (IOException e) {
		}
	}

}
