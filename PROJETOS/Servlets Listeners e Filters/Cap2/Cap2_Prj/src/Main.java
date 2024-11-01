/***
 * DSD - Noite 
 * Nome: João Paulo C. Aramuni 
 * Peterson para N threads 
 * Data: 07/09/2013
 */
import java.util.Scanner;

public class Main {
	/***
	 * Método main
	 * 
	 * @author joao
	 * @exception e
	 */
	public static void main(String[] args) throws Exception {

		System.out.print("***** Peterson para N threads ***** \n");
		String resp = "";
		try {
			Scanner s = new Scanner(System.in);
			System.out.print("Digite o número de threads: ");
			resp = s.nextLine();
			s.close();

			int numthreads = Integer.parseInt(resp);

			Peterson threads[] = new Peterson[numthreads];
			PetersonLock lock = new PetersonLock(numthreads);

			int i = 0;
			for (Peterson p : threads) {
				p = new Peterson(i, lock);
				p.start();
				i++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
