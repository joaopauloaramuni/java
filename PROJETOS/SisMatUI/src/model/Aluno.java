package model;

import java.io.Serializable;
import java.util.Date;

import utilitarios.LtpLib;

public class Aluno implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int codigoAluno;
	private String nomeAluno;
	private String cpf; 
	private String telefone;
	private Date dataEntrada;
	
	public Aluno(){
	}
	
	public Aluno(int codigoAluno, String nomeAluno, String cpf, String telefone, Date dataEntrada) {
		super();
		this.codigoAluno = codigoAluno;
		this.nomeAluno = nomeAluno;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataEntrada = dataEntrada;
	}
	public int getCodigoAluno() {
		return codigoAluno;
	}
	public void setCodigoAluno(int codigoAluno) {
		this.codigoAluno = codigoAluno;
	}
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	@Override
	public String toString() {
		return "Aluno [codigoAluno=" + codigoAluno + ", nomeAluno=" + nomeAluno + ", cpf=" + cpf + ", telefone="
				+ telefone + ", dataEntrada=" + LtpLib.formatarData(dataEntrada, "dd/MM/yyyy") + "]";
	}
	
}
