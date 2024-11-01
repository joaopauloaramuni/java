import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getByName("www.face.fumec.br");
			System.out.println("IP: " + address.getHostAddress());
			System.out.println("Hostname: " + address.getHostName());
			for(byte b: address.getAddress())
				System.out.print((0x0000FF & (int)b) + " ");
			System.out.println();
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("IP (local): " + local.getHostAddress());
			System.out.println("Hostname (local): " + local.getHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
