package modelo;

public class Cubo extends FormaGeometrica {
	private double lado;
		
	public Cubo(double lado) {
		this.lado = lado;
	}

	public double getRaio() {
		return lado;
	}

	public void setRaio(double lado) {
		this.lado = lado;
	}

	@Override
	public double getArea() {
		return 6*Math.pow(lado, 2);
	}

	@Override
	public int getTipo() {
		return FormaGeometrica.TRI_DIMENSIONAL;
	}

	@Override
	public double getVolume() {
		return Math.pow(lado, 3);
	}

}
