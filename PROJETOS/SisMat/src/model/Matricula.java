package model;

import java.io.Serializable;
import java.util.Date;

public class Matricula implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int codigoMatricula; 
	private Curso curso; 
	private Aluno aluno;
	private Date dataMatricula;
	
	public Matricula(){
	
	}
	
	public Matricula(int codigoMatricula, Curso curso, Aluno aluno, Date dataMatricula) {
		super();
		this.codigoMatricula = codigoMatricula;
		this.curso = curso;
		this.aluno = aluno;
		this.dataMatricula = dataMatricula;
	}
	public int getCodigoMatricula() {
		return codigoMatricula;
	}
	public void setCodigoMatricula(int codigoMatricula) {
		this.codigoMatricula = codigoMatricula;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Date getDataMatricula() {
		return dataMatricula;
	}
	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Matricula [codigoMatricula=" + codigoMatricula + ", curso=" + curso + ", aluno=" + aluno
				+ ", dataMatricula=" + dataMatricula + "]";
	}
	
}
