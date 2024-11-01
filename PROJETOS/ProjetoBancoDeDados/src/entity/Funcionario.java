package entity;
public class Funcionario {

	private int numRegistro;
	private String nome;
	private String endereco;
	private char sexo;
	private double salarioBase;
	private Empresa empresa;
	
	public Funcionario() {
		super();
	}
	public Funcionario(int numRegistro, String nome, String endereco, char sexo, double salarioBase, Empresa empresa) {
		super();
		this.numRegistro = numRegistro;
		this.nome = nome;
		this.endereco = endereco;
		this.sexo = sexo;
		this.salarioBase = salarioBase;
		this.empresa = empresa;
	}
	public int getNumRegistro() {
		return numRegistro;
	}
	public void setNumRegistro(int numRegistro) {
		this.numRegistro = numRegistro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public double getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
}