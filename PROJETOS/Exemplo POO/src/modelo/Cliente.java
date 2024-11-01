package modelo;

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
	
	public Cliente clone() {
		return new Cliente(codigo, nome, telefone, email);
	}
	
	public boolean equals(Cliente objCliente) {
		return codigo==objCliente.codigo;
	}
	
	public int compareTo(Cliente objCliente) {
		if (codigo==objCliente.getCodigo()) {
			return 0;
		} else {
			if (codigo < objCliente.getCodigo()) {
				return -1;
			} else {
				return 1;
			}
		}
	}
	
	public String toString() {
		return 
		   "Codigo   : " + codigo + "\n" +
		   "Nome     : " + nome + "\n" +
		   "Telefone : " + telefone + "\n" +
		   "E-mail   : " + email + "\n";
	}
}




