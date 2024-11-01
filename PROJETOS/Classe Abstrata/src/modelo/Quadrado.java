package modelo;

public class Quadrado extends FormaGeometrica {
	private double lado;
	
	public Quadrado(double lado) {
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
		return Math.pow(lado, 2);
	}

	@Override
	public int getTipo() {
		return FormaGeometrica.BI_DIMENSIONAL;
	}

	@Override
	public double getVolume() {
		return 0;
	}

}
