package teste;

public class Circulo extends FormaGeometrica{

	private double raio;

	@Override
	public double obtemArea() {

		return Math.PI * Math.pow(raio, 2);
	}

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}

	
}
