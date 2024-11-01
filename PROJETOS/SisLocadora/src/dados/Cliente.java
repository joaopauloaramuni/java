/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dados;
import java.sql.Date;
/**
 *
 * @author JP
 */
public class Cliente {
	private int codigo;
	private String nome;
        private String cpf;
	private String telefone;
	private String email;
        private Date data;

        /**
	 * Método construtor da Classe Cliente
	 * @param codigo
	 * @param nome
	 * @param cpf
      	 * @param telefone
       	 * @param email
         * @param data
	 */
    public Cliente(int codigo, String nome, String cpf, String telefone, String email, Date data) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.data = data;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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
        @Override
	public String toString() {
		return
		  "Código     : " + codigo + "\n" +
                  "Nome       : " + nome.trim() + "\n" +
                  "CPF        : " + cpf.trim() + "\n" +
		  "Telefone   : " + telefone.trim() + "\n" +
		  "E-Mail     : " + email.trim() + "\n" +
                  "Data       : " + data + "\n";
	}
}
