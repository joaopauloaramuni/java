package teste;

import java.util.Vector;

import modelo.Cubo;
import modelo.FormaGeometrica;
import modelo.Quadrado;

public class Teste {
	
	private static Vector<FormaGeometrica> lista = new Vector<FormaGeometrica>();
	
	public static void main(String[] args) {
		cadastrarFormaGeometrica();
		listarFG();

	}

	private static void listarFG() {
		for (FormaGeometrica objFG : lista) {
			System.out.println("Area: " + objFG.getArea() + "\n" +
					           ((objFG.getTipo()==FormaGeometrica.TRI_DIMENSIONAL)?
					        	"Volume: " + objFG.getVolume() : "") + "\n");
		}
		
	}

	private static void cadastrarFormaGeometrica() {
		lista.add(new Quadrado(2));
		lista.add(new Cubo(2));
	}

}
