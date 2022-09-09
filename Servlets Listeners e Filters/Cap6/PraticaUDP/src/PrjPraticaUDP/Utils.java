package PrjPraticaUDP;

import java.net.UnknownHostException;
import java.util.GregorianCalendar;

/**
 * DSD - Desenvolvimento de Sistemas Distribuídos
 * Cap 6
 * Data: 24/11/2013
 * @author João Paulo Aramuni
 *
 */
public class Utils {

	public static void WriteRed(String message) throws UnknownHostException {
		WriteRed(null, message, true);
	}

	public static void WriteRed(String owner, String message, boolean readLine) {
		System.err.print((owner != null ? owner + " :" : "") + message + "."
				+ (readLine ? "\n" : ""));
	}

	public static void WriteRed(String owner, String message) {
		WriteRed(owner, message, true);
	}

	public static void WriteTrace(String msg) {
		WriteTrace(null, msg, true);
	}

	public static void WriteTrace(String owner, String msg) {
		WriteTrace(owner, msg, true);
	}

	public static void WriteTrace(String owner, String message, boolean readLine) {
		System.out.print((owner != null ? owner + " :" : "") + message
				+ (readLine ? "\n" : ""));
	}

	public static void printLine(int max) {
		System.out.println();
		for (int i = 0; i < max; i++)
			System.out.print('-');

		System.out.println();
	}

	public static void printLine() {
		printLine(40);
	}

	public static void WriteDateNow(String message) {
		int date = GregorianCalendar.DATE;
		String newMessage = String.format("%s %s", message, date);
		WriteTrace(newMessage);
	}

}
