import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;


public class Serializacao {

	public static void main(String[] args) {
		
		Date dt = new Date();
		System.out.println(dt);
		Pessoa p = new Pessoa("Caio", 1, "secreta");
		
		try {
			ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("serie.txt"));
			oout.writeObject(dt);
			oout.writeObject(p);
			oout.close();
			
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream("serie.txt"));
			Date dt2 = (Date)oin.readObject();
			Pessoa p2 = (Pessoa)oin.readObject();
			System.out.println("Data lida: " + dt2);
			System.out.println("Pessoa lida" + p2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
