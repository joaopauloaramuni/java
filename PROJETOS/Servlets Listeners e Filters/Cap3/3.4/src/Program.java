/**
 * DSD - Desenvolvimento de Sistemas Distribu�dos
 * Cap 3
 * Data: 15/10/2013
 * @author Jo�o Paulo Aramuni
 *
 */
public class Program {

	public static void main(String[] args) {

		SleepingBarber barbearia = new SleepingBarber(3);
		try {

			new Barber(barbearia).start();

			int ini = 1;
			while (true) {
				new Customer(barbearia, "Cliente " + ini++).start();
				if (ini % 5 == 0)
					Thread.sleep(4000);
				if (ini == 20)
					break;
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}
}
