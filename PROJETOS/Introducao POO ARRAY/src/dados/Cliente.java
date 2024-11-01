package dados;

public class Cliente {
	private int codigo;
	private String nome;
	private String telefone;
	private String email;
	public Cliente(int codigo, String nome, String telefone, String email) {
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCodigo() {
		return codigo;
	}
	public String toString() {
		return
		   "Codigo   : " + codigo + "\n" + 
		   "Nome     : " + nome + "\n" +
		   "Telefone : " + telefone + "\n" +
		   "E-mail   : " + email + "\n";
	}
	
}





