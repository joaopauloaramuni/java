package modelo;

public class Circulo extends FormaGeometrica {

	private double raio;
	
	
	public Circulo(double raio) {
		this.raio = raio;
	}


	public double getRaio() {
		return raio;
	}


	public void setRaio(double raio) {
		this.raio = raio;
	}


	@Override
	public double obtemArea() {
		// TODO Auto-generated method stub
		return Math.PI * Math.pow(raio, 2);
	}

}
