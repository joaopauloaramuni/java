package modelo;

public class Pessoa implements Comparable<Pessoa>{
	private int codigo;
	private String nome;
	private String cidade;
	public Pessoa(int codigo, String nome, String cidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.cidade = cidade;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String toString() {
		return
			"Código : " + codigo + "\n" +
			"Nome   : " + nome + "\n" +
			"Cidade : " + cidade + "\n";
 	}
	@Override
	public int compareTo(Pessoa o) {
		// TODO Auto-generated method stub
		if (cidade.equals(o.getCidade())) {
			return nome.compareTo(o.getNome());	
		} else {
			return cidade.compareTo(o.getCidade());
		}
		
	}
}
