package teste;

public class Caixa {

	private double comp, larg, alt;

	public Caixa() { // Construtor
		this(10, 10, 10);
	}

	public Caixa(double comp, double larg, double alt) { // Construtor
		this.comp = comp;
		this.larg = larg;
		this.alt = alt;
	}

	public double getComp() {
		return comp;
	}

	public void setComp(double comp) {
		this.comp = comp;
	}

	public double getLarg() {
		return larg;
	}

	public void setLarg(double larg) {
		this.larg = larg;
	}

	public double getAlt() {
		return alt;
	}

	public void setAlt(double alt) {
		this.alt = alt;
	}

	public double volume() {
		return (comp * larg * alt);
	}

}
