package poli;

public class Teste {

	public static void main(String[] args) {
		fazerAnimalComer(new Animal());
		fazerAnimalComer(new Cao());
		fazerAnimalComer(new Tigre());
	}

	private static void fazerAnimalComer(Animal animal) {
		animal.comer();
	}
}
