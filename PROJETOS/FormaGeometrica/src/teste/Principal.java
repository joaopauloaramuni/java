package teste;

import java.util.ArrayList;

public class Principal {

	
	public static void main(String[] args) {
		System.out.println("Projeto Forma Geometrica");
		
		Circulo circulo = new Circulo();
		Triangulo triangulo = new Triangulo();
		
		circulo.setRaio(2.0);
		
		triangulo.setLado1(3.0);
		triangulo.setLado2(3.0);
		triangulo.setLado3(4.0);
		
		ArrayList<FormaGeometrica> listaFormaGeometrica = new ArrayList<>();
		listaFormaGeometrica.add(circulo);
		listaFormaGeometrica.add(triangulo);
		
		for (FormaGeometrica forma : listaFormaGeometrica) {
			System.out.println(forma.obtemArea()); // Polimorfismo
		}
		
	}
}
