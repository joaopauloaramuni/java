package controller;

import java.util.ArrayList;
import java.util.Date;

import model.Aluno;
import model.Curso;
import model.Matricula;

public class Mat {

	// Atributos
	private ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
	private ArrayList<Curso> listaCursos = new ArrayList<Curso>();
	private ArrayList<Matricula> listaMatriculas = new ArrayList<Matricula>();

	public ArrayList<Aluno> getListaAlunos() {
		return listaAlunos;
	}

	public void setListaAlunos(ArrayList<Aluno> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}

	public ArrayList<Curso> getListaCursos() {
		return listaCursos;
	}

	public void setListaCursos(ArrayList<Curso> listaCursos) {
		this.listaCursos = listaCursos;
	}

	public ArrayList<Matricula> getListaMatriculas() {
		return listaMatriculas;
	}

	public void setListaMatriculas(ArrayList<Matricula> listaMatriculas) {
		this.listaMatriculas = listaMatriculas;
	}

	public void cadastrarAluno(Aluno aluno) throws Exception {
		boolean adicionar = getListaAlunos().add(aluno);
		if (!adicionar) {
			throw new Exception("Erro ao cadastrar aluno!!!");
		}
	}

	public Aluno consultarAlunoCpf(String cpf) throws Exception {
		for (Aluno aluno : getListaAlunos()) {
			if (cpf.equals(aluno.getCpf())) {
				return aluno;
			}
		}
		throw new Exception("Não existe aluno para o CPF informado");
	}

	public void cadastrarCurso(Curso curso) throws Exception {

		boolean adicionar = getListaCursos().add(curso);
		if (!adicionar) {
			throw new Exception("Erro ao cadastrar curso!!!");
		}
	}

	public Curso consultarCursoNome(String nomeCurso) throws Exception {
		for (Curso curso : getListaCursos()) {
			if (nomeCurso.equals(curso.getNomeCurso())) {
				return curso;
			}
		}
		throw new Exception("Não existe curso para o nome informado");
	}

	public Matricula consultarMatriculaCodigo(int codigoMatricula) throws Exception {
		for (Matricula matricula : getListaMatriculas()) {
			if (codigoMatricula == matricula.getCodigoMatricula()) {
				return matricula;
			}
		}
		throw new Exception("Não existe matrícula para o código informado");
	}

	public void desmatricularAluno(Matricula objMatricula) throws Exception {
		boolean remove = getListaMatriculas().remove(objMatricula);
		if (!remove) {
			throw new Exception("Erro ao desmatricular aluno!!!");
		}
	}

	public void matricularAluno(Matricula objMatricula) throws Exception{

		boolean adicionar = getListaMatriculas().add(objMatricula);
		if (!adicionar) {
			throw new Exception("Erro ao matricular aluno!!!");
		}
		
	}

}
