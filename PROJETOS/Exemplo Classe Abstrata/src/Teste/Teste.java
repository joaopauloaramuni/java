package Teste;

import java.util.Vector;

import modelo.Circulo;
import modelo.FormaGeometrica;
import modelo.Quadrado;

public class Teste {

	public static void main(String[] args) {
		Vector<FormaGeometrica> fg = new Vector<FormaGeometrica>();
		fg.add(new Circulo(2));
		fg.add(new Quadrado(2));
		for (FormaGeometrica objFG : fg) System.out.println(objFG.obtemArea());

	}

}
