package teste;

import java.util.GregorianCalendar;
import java.util.Vector;

import modelo.Funcionario;
import modelo.Gerente;
import modelo.Pessoa;
import modelo.PessoaJuridica;

public class Teste {

	private static Vector<Pessoa> cadastroGeral = new Vector<Pessoa>();

	public static void main(String[] args) {
		// criação de dados de testes
		fornecedores();
		listarFornecedores();
		cadastrarAgenda();
		listarAgenda();
		cadastrarFuncionarios();
		listarFuncionarios();
	}

	private static void listarFuncionarios() {
		System.out.println("Relação de Funcionários");
		for (Pessoa obj : cadastroGeral) {
			if (obj.getTipo() == Pessoa.FUNCIONARIO || obj.getTipo() == Pessoa.GERENTE)
				System.out.println(obj.toString()); // Polimorfismo
		}
		
	}

	private static void cadastrarFuncionarios() {
		cadastroGeral.add(new Funcionario("Flavia Silva", "2222-3333",
				Pessoa.FUNCIONARIO, "11111111111", "MG-123456", "F",
				"333-456543", new GregorianCalendar(2017, 0, 1), 2000.00));
		
		cadastroGeral.add(new Gerente("Lucas Moura", "4444-3333",
				Pessoa.GERENTE, "11111111110", "MG-123452", "M",
				"333-456545", new GregorianCalendar(2005, 0, 1), 10000.00,(Funcionario)cadastroGeral.get(2)));

	}

	private static void listarAgenda() {
		System.out.println("Relação de Telefones");
		for (Pessoa obj : cadastroGeral) {
			if (obj.getTipo() == Pessoa.PESSOA)
				System.out.println(obj.toString()); // Polimorfismo
		}

	}

	private static void cadastrarAgenda() {
		cadastroGeral.add(new Pessoa("Lucas", "2222-2222", Pessoa.PESSOA));

	}

	private static void listarFornecedores() {
		System.out.println("Relação de Fornecedores");
		for (Pessoa obj : cadastroGeral) {
			if (obj.getTipo() == Pessoa.PESSOA_JURIDICA)
				System.out.println(obj.toString()); // Polimorfismo
		}

	}

	private static void fornecedores() {

		cadastroGeral.add(new PessoaJuridica("Face Sistemas Ltda", "3030-3030",
				Pessoa.PESSOA_JURIDICA, "11111111111111", "FUMEC"));

	}
}
