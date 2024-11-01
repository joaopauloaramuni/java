package usuario;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import utilitarios.Console;
import utilitarios.LtpLib;

import modelo.Funcionario;
import modelo.Gerente;
import modelo.Pessoa;
import modelo.PessoaFisica;

public class Teste {

	private static ArrayList<Pessoa> cadastro = new ArrayList<>();
	
	public static void main(String[] args) {
		cadastrarFuncionarios();
		listarCadastroFuncionarios();

	}

	private static void cadastrarFuncionarios() {
		System.out.println("\nCadastro de Funcionários\n");
		String nome;
		String telefone;
		String cpf;
		String identidade;
		String sexo;
		String caProf;
		GregorianCalendar admissao;
		double salario;
		do {
			nome=Console.readLine("NOME: ");
			telefone=Console.readLine("TELEFONE: ");
			cpf=Console.readLine("CPF: ");
			identidade=Console.readLine("IDENTIDADE: ");
			sexo=Console.readLine("SEXO: ");
			caProf=Console.readLine("CART.PROF: ");
			admissao=new GregorianCalendar();
			//LtpLib.validarData(Console.readLine("ADMISSÃO: "), admissao);
			salario=Console.readDouble("SALÁRIO: ");
			Funcionario funcionario = new Funcionario(nome,telefone,cpf,identidade,sexo,caProf,admissao,salario);
			cadastro.add(funcionario);
			cadastro.add(new Gerente(nome,telefone,cpf,identidade,sexo,caProf,admissao,salario,funcionario));
			cadastro.add(new PessoaFisica(nome,telefone,cpf,identidade,sexo));
			
			
			if (Console.readLine("Funcionario Cadastrado - Continuar (S/N)? ").equalsIgnoreCase("N")) break;
		} while (true);
		
	}
	private static void listarCadastroFuncionarios() {
		System.out.println("\nListagem do Cadastro de Funcionários\n");		
		for (Pessoa pessoa : cadastro) {
			System.out.println(pessoa.toString());
		}
	}
	
	
	
	
}
