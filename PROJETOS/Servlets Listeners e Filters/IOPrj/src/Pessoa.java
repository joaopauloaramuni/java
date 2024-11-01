import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = -8661057850630175364L;
	
	private String nome;
	private int codigo;
	private String senha;
	
	public Pessoa(String nome, int codigo, String senha) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getSenha() {
		return senha;
	}
	
	private void writeObject(ObjectOutputStream stream) throws IOException {
		senha = Cesar.converte(senha, 3, false);
		stream.defaultWriteObject();
	}

	private void readObject (ObjectInputStream stream) throws IOException, ClassNotFoundException {
		stream.defaultReadObject();
		senha = Cesar.converte(senha, 3, true);
	}
	
	@Override
	public String toString() {
		return "Pessoa [codigo=" + codigo + ", nome=" + nome + ", senha="
				+ senha + "]";
	}

}
