package view;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import controller.BizException;
import controller.Mat;
import model.Aluno;
import model.Curso;
import model.Matricula;
import utilitarios.Console;
import utilitarios.LtpLib;

public class InterfaceUsuario {

	// Atributos
	private static Mat objMat = new Mat();

	public static void main(String[] args) {

		// ler cadastro de alunos
		if (new File("Alunos.obj").exists()) {
			try {
				objMat.setListaAlunos(LtpLib.lerArquivoObjetosArray("Alunos.obj"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(1);
			}
		}
		// ler cadastro de cursos
		if (new File("Cursos.obj").exists()) {
			try {
				objMat.setListaCursos(LtpLib.lerArquivoObjetosArray("Cursos.obj"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(2);
			}
		}
		// ler cadastro de matriculas
		if (new File("Matriculas.obj").exists()) {
			try {
				objMat.setListaMatriculas(LtpLib.lerArquivoObjetosArray("Matriculas.obj"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(3);
			}
		}

		// menu
		menu();

		// gravar cadastro de alunos
		try {
			LtpLib.gravarArquivoObjetosArray("Alunos.obj", objMat.getListaAlunos());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(4);
		}

		// gravar cadastro de cursos
		try {
			LtpLib.gravarArquivoObjetosArray("Cursos.obj", objMat.getListaCursos());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(5);
		}

		// gravar cadastro de matriculas
		try {
			LtpLib.gravarArquivoObjetosArray("Matriculas.obj", objMat.getListaMatriculas());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(6);
		}

		// fechamento da aplicação
		System.out.println("Sistema finalizado.");
		System.exit(0);
	}

	private static void menu() {
		int opcao = 0;
		do {
			System.out.println("\nSisMat – Sistema de Matrículas de Alunos");
			System.out.println("1-Cadastrar Aluno");
			System.out.println("2-Consultar Aluno");
			System.out.println("3-Cadastrar Curso");
			System.out.println("4-Consultar Curso");
			System.out.println("5-Matricular Aluno");
			System.out.println("6-Desmatricular Aluno");
			System.out.println("7-Consultar Matricula");
			System.out.println("0-Sair da aplicação");
			opcao = Console.readInt("Opção: ");
			switch (opcao) {
			case 1:
				cadastrarAluno();
				break;
			case 2:
				consultarAluno();
				break;
			case 3:
				cadastrarCurso();
				break;
			case 4:
				consultarCurso();
				break;
			case 5:
				matricularAluno();
				break;
			case 6:
				desmatricularAluno();
				break;
			case 7:
				consultarMatricula();
				break;
			case 0:
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}
		} while (opcao != 0);
	}

	private static void consultarMatricula() {

		System.out.println("\nConsultar Matrícula");
		try {
			Matricula matricula = objMat.consultarMatriculaCodigo(Console.readInt("Código de matrícula: "));
			System.out.println(matricula.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void desmatricularAluno() {
		System.out.println("\nDesmatricular Aluno");
		try {
			Matricula objMatricula = objMat.consultarMatriculaCodigo(Console.readInt("Código da Matrícula: "));
			objMat.desmatricularAluno(objMatricula);
			System.out.println("Aluno desmatriculado com sucesso!");
		} catch (BizException e) {
			System.out.println("REGRAS DE NEGÓCIO: " + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void matricularAluno() {

		try {
			System.out.println("\nConsultar Aluno");
			Aluno objAluno = objMat.consultarAlunoCpf(Console.readLine("CPF: "));
			System.out.println("\nConsultar Curso");
			Curso objCurso = objMat.consultarCursoNome(Console.readLine("Nome do curso: "));

			int codigoMatricula = 0;
			if (objMat.getListaMatriculas().isEmpty()) {
				codigoMatricula = 1;
			} else {
				codigoMatricula = objMat.getListaMatriculas().size() + 1;
			}

			Matricula matricula = new Matricula(codigoMatricula, objCurso, objAluno, new Date());

			objMat.matricularAluno(matricula);

			System.out.println("Aluno " + objAluno.getNomeAluno() + "matriculado com sucesso no curso: "
					+ objCurso.getNomeCurso());
			System.out.println("Anote seu código de matrícula gerado: " + matricula.getCodigoMatricula());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void consultarCurso() {

		System.out.println("\nConsultar Curso");
		try {
			Curso objCurso = objMat.consultarCursoNome(Console.readLine("Nome do curso: "));
			System.out.println(objCurso.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void cadastrarCurso() {

		System.out.println("\nCadastrar Curso");

		int codigoCurso;
		String nomeCurso;
		Double valorCurso;
		int duracaoCurso;
		int notaMec;

		nomeCurso = Console.readLine("Nome do curso: ");
		valorCurso = Console.readDouble("Valor do curso: ");
		duracaoCurso = Console.readInt("Duração do curso: ");
		notaMec = Console.readInt("Nota MEC: ");

		// Código
		if (objMat.getListaCursos().isEmpty()) {
			codigoCurso = 1;
		} else {
			codigoCurso = objMat.getListaCursos().size() + 1;
		}

		Curso curso = new Curso(codigoCurso, nomeCurso, valorCurso, duracaoCurso, notaMec);

		try {
			objMat.cadastrarCurso(curso);

			System.out.println("Curso cadastrado com sucesso!!!");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void consultarAluno() {

		System.out.println("\nConsultar Aluno");
		try {
			Aluno objAluno = objMat.consultarAlunoCpf(Console.readLine("CPF: "));
			System.out.println(objAluno.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void cadastrarAluno() {

		System.out.println("\nCadastrar Aluno");

		int codigoAluno;
		String nomeAluno;
		String cpf;
		String telefone;

		nomeAluno = Console.readLine("Nome: ");
		cpf = Console.readLine("CPF: ");
		telefone = Console.readLine("Endereço: ");

		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			Date data = formato.parse(Console.readLine("Data Entrada: "));

			// Código
			if (objMat.getListaAlunos().isEmpty()) {
				codigoAluno = 1;
			} else {
				codigoAluno = objMat.getListaAlunos().size() + 1;
			}

			Aluno aluno = new Aluno(codigoAluno, nomeAluno, cpf, telefone, data);
			objMat.cadastrarAluno(aluno);
			System.out.println("Aluno cadastrado com sucesso!!!");

		} catch (BizException e) {
			System.out.println(e.getMessage());
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	

}
