package teste;

public class Principal {
	public static void main(String[] args) {
		Caixa c1 = new Caixa();
		System.out.println("Volume da caixa 1 = " + c1.volume()); // volume = 1000
		Caixa c2 = new Caixa(10, 5, 3);
		System.out.println("Volume da caixa 2 = " + c2.volume()); // volume = 150
		c2.setComp(8);
		c2.setLarg(c2.getLarg() - 3);
		System.out.println("Novo volume da caixa 2 = " + c2.volume()); // volume = 48
	}
}
