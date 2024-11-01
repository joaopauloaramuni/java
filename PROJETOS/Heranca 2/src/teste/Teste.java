package teste;

import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Vector;

import utilitarios.Console;
import utilitarios.LtpLib;

import modelo.Funcionario;
import modelo.Gerente;
import modelo.Pessoa;
import modelo.PessoaJuridica;

public class Teste {
	// Lista de Pessoas
	private static Vector<PessoaJuridica> listaPessoa = 
		                 new Vector<PessoaJuridica>();
	private static Vector<Funcionario> listaFuncionarios = 
						 new Vector<Funcionario>();

	public static void main(String[] args) {
		menu();
		System.out.println("\nTeste finalizado.");
		System.exit(0);
	}

	private static void menu() {
		int opcao=0;
		do {
			System.out.println("Menu Testes");
			System.out.println("1-Cadastrar Fornecedor");
			System.out.println("2-Lista de Fornecedores em ordem alfab�tica");
			System.out.println("3-Cadastrar Funcion�rio");
			System.out.println("4-Lista de Funcion�rios em ordem alfab�tica");			
			System.out.println("0-Sair");
			opcao=Console.readInt("Op��o: ");
			switch (opcao) {
				case 1:
					cadastrarForn();
					break;
				case 2:
					listarForn();
					break;	
				case 3:
					cadFunc();
					break;					
				case 0:
					break;
				default:
					System.out.println("Op��o Inv�lida.");
					break;
			}
		} while (opcao!=0);
		
	}


	private static void cadFunc() {
		System.out.println("\nCadastrar Funcion�rio\n");
		String nome;
		String telefone;
		String cpf;
		String identidade;
		String sexo;
		String caProf;
		GregorianCalendar admissao = new GregorianCalendar();
		double salario;
		do {
			nome=Console.readLine("Nome : ");
			if ( nome.trim().equals("")){
				System.out.println("Nome inv�lido.");
			} else break;
		} while (true);	
		do {
			telefone=Console.readLine("Telefone: ");
			if ( telefone.trim().equals("")){
				System.out.println("Telefone inv�lido.");
			} else break;
		} while (true);	
		do {
			cpf=Console.readLine("CPF : ");
			if ( !LtpLib.validarCPF(cpf)){
				System.out.println("CPF inv�lido.");
			} else break;
		} while (true);	
		do {
			identidade=Console.readLine("Identidade : ");
			if ( identidade.trim().equals("")){
				System.out.println("Identidade inv�lido.");
			} else break;
		} while (true);	
		do {
			sexo=Console.readLine("Sexo : ");
			if ( sexo.trim().equals("")){
				System.out.println("Sexo inv�lido.");
			} else break;
		} while (true);	
		do {
			caProf=Console.readLine("Cart.Prof : ");
			if ( caProf.trim().equals("")){
				System.out.println("Cart.Prof inv�lido.");
			} else break;
		} while (true);	
		do {
			String admis=Console.readLine("Admiss�o : ");
			if ( !LtpLib.validarData(admis, admissao)){
				System.out.println("Data admiss�o inv�lida.");
			} else break;
		} while (true);	
		do {
			salario=Console.readDouble("Sal�rio : ");
			if ( salario <= 0){
				System.out.println("Sal�rio inv�lido.");
			} else break;
		} while (true);	
		
		if (Console.readLine("Gerente? (S/N) ").equalsIgnoreCase("S")) {
			String cpfSecret = Console.readLine("CPF Secret�ria: ");
			Funcionario secretaria = null;
			for(Funcionario objFun : listaFuncionarios) {
				if (objFun.getCpf().equals(cpfSecret)) {
					secretaria=objFun;
					break;
				}
			}
			listaFuncionarios.add(new Gerente(nome,telefone,cpf,identidade,sexo,caProf,admissao,salario,secretaria));
		} else listaFuncionarios.add(new Funcionario(nome,telefone,cpf,identidade,sexo,caProf,admissao,salario));
		System.out.println("\nFuncion�rio cadastrado.\n");
		Console.readLine("<ENTER>");		
		
	}

	private static void cadastrarForn() {
		System.out.println("\nCadastrar Fornecedor\n");
		String cnpj;
		String razaoSocial;
		String nome;
		String telefone;
		do {
			cnpj=Console.readLine("CNPJ: ");
			if ( !LtpLib.validarCNPJ(cnpj)){
				System.out.println("CNPJ inv�lido.");
			} else break;
		} while (true);
		do {
			razaoSocial=Console.readLine("R.Social: ");
			if ( razaoSocial.trim().equals("")){
				System.out.println("R.Social inv�lido.");
			} else break;
		} while (true);
		do {
			nome=Console.readLine("Nome Fantasia: ");
			if ( nome.trim().equals("")){
				System.out.println("Nome Fantasia inv�lido.");
			} else break;
		} while (true);		
		do {
			telefone=Console.readLine("Telefone: ");
			if ( telefone.trim().equals("")){
				System.out.println("Telefone inv�lido.");
			} else break;
		} while (true);	
		listaPessoa.add(new PessoaJuridica(nome,telefone,cnpj,razaoSocial));
		System.out.println("\nFornededor cadastrado.\n");
		Console.readLine("<ENTER>");
	}
	private static void listarForn() {
		System.out.println("\nListar Fornecedor\n");
		Vector<PessoaJuridica> listaAux = (Vector<PessoaJuridica>)listaPessoa.clone();
		Collections.sort(listaAux);
		for (Pessoa objPessoa : listaAux) {
			System.out.println((objPessoa.toString()));
		}
		Console.readLine("<ENTER>");
	}
}





