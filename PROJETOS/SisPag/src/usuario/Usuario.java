package usuario;

import java.io.File;
import java.util.GregorianCalendar;

import modelo.Funcionario;
import modelo.Horas;
import modelo.Horista;
import modelo.Mensalista;

import utilitarios.Console;
import utilitarios.LtpLib;

import Cadastro.Empresa;

public class Usuario {
	private static Empresa objEmp = new Empresa();
	public static void main(String[] args) {
		// Ler cadastro de funcionários
		if (new File("CadFuncionarios.obj").exists()) {
			try {
				objEmp.setCadFunc( LtpLib.lerArquivoObjetos("CadFuncionarios.obj") );
			} catch (Exception e) {
				System.out.println("Leitura - " + e.getMessage());
				System.exit(1);
			}
			
		}
		// Menu
		menu();
		// Gravar cadastro de Funcionários
		try {
			LtpLib.gravarArquivoObjetos("CadFuncionarios.obj", objEmp.getCadFunc());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		System.out.println("\nFinal do SisPag");
		System.exit(0);

	}
	private static void menu() {
		int opcao = 0;
		do {
			System.out.println("\n" + "Menu SisPag");
			System.out.println("1-Cadastrar Funcionário");
			System.out.println("2-Consultar Funcionário pelo CPF");
			System.out.println("3-Consultar Funcionário pelo nome");
			System.out.println("4-Lançamento de horas de trabalho");
			System.out.println("5-Consultar o Valor Liquido a Receber no mes/ano");
			System.out.println("0-Sair");
			opcao = Console.readInt("Opção: ");
			switch (opcao) {
				case 1:
					incluirFunc();
					break;
				case 2:
					consFunCpf();
					break;
				case 3:
					consFuncNome();
					break;
				case 4:
					lancHorasTrab();
					break;
				case 5:
					valorLiquidoMensal();
					break;
				case 0 :
					break;
				default:
					System.out.println("Opção Inválida.");
					break;
			}
		} while (opcao!=0);
		
	}
	private static void valorLiquidoMensal() {
		System.out.println("\nValor Liquido a Receber no mes/ano\n");
		String cpf = Console.readLine("CPF: ");
		int mes = Console.readInt("Mês: ");
		int ano = Console.readInt("Ano: ");
		try {
			System.out.println("Valor Liquido Mensal: " +
					objEmp.obterFuncionario(cpf).obterSalarioMensal(mes, ano));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	private static void lancHorasTrab() {
		System.out.println("\nLançamento de Horas de Trabalho\n");
		String cpf = "";
		Funcionario objFunc = null;
		do {
			cpf = Console.readLine("CPF: ");
			try {
				objFunc = objEmp.obterFuncionario(cpf);
				if (objFunc.getTipo()!=Funcionario.HORARISTA) {
					System.out.println("O Func. não é Horista.");
					continue;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		} while (true);
		GregorianCalendar dataTrab = new GregorianCalendar();
		do {
			String data = Console.readLine("Data Trabalho: ");
			if (LtpLib.validarData(data, dataTrab) && 
				dataTrab.compareTo(new GregorianCalendar())<=0){
				break;
			} else {
				System.out.println("Data Inválida.");
			}
		} while (true);
		double quantHoras = 0;
		do {
			quantHoras = Console.readDouble("Nº Horas: ");
			if (quantHoras > 0 && quantHoras <= 24) {
				break;
			} else {
				System.out.println("Nº Horas Inválido.");
			}
		} while (true);
		try {
			((Horista)objFunc).incluirHoras(new Horas(dataTrab, quantHoras));
			System.out.println("Lançamento de horas cadastrado.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	private static void consFuncNome() {
		System.out.println("\nConsultar Funcionário pelo Nome\n");
		try {
			for (Funcionario obj : objEmp.consFunNome(Console.readLine("Nome: "))) {
				System.out.println(obj.toString());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	private static void consFunCpf() {
		System.out.println("\nConsultar Funcionário pelo CPF\n");
		try {
			System.out.println(objEmp.obterFuncionario(Console.readLine("CPF: ")).toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	private static void incluirFunc() {
		System.out.println("\nCadastrar Funcionário\n");
		
		String cpf = "";
		do {
			cpf = Console.readLine("CPF : ");
			if (!LtpLib.validarCPF(cpf)) {
				System.out.println("DV do CPF não confere.");
				continue;
			}
			try {
				objEmp.obterFuncionario(cpf);
				System.out.println("CPF já existe no cadastro.");
				continue;
			} catch (Exception e) {
				break;
			}
		} while (true);
		String nome;
		do {
			nome = Console.readLine("Nome: ");
			if (nome.trim().equals("")) {
				System.out.println("Falta o nome.");
			} else break;
		} while (true);
		
		int tipoFun = Console.readInt("1-Mensalista/2-Horista : ");
		double valor = Console.readDouble((tipoFun==1?"Salário: ":"Valor Hora: "));
		if (tipoFun==1) {
			objEmp.incluirFuncionario(new Mensalista( cpf,nome,valor ) );
		} else {
			objEmp.incluirFuncionario(new Horista( cpf,nome,valor ) );
		}
		System.out.println("Funcionário Cadastrado.");
	}

}








