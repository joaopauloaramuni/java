package modelo;

public abstract class FormaGeometrica {
	// Constantes
	public static int BI_DIMENSIONAL = 1;
	public static int TRI_DIMENSIONAL = 2;
	
	public abstract int getTipo();
	
	public abstract double getArea();

	public abstract double getVolume();
}
