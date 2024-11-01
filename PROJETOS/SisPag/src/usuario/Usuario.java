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
		// Ler cadastro de funcion�rios
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
		// Gravar cadastro de Funcion�rios
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
			System.out.println("1-Cadastrar Funcion�rio");
			System.out.println("2-Consultar Funcion�rio pelo CPF");
			System.out.println("3-Consultar Funcion�rio pelo nome");
			System.out.println("4-Lan�amento de horas de trabalho");
			System.out.println("5-Consultar o Valor Liquido a Receber no mes/ano");
			System.out.println("0-Sair");
			opcao = Console.readInt("Op��o: ");
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
					System.out.println("Op��o Inv�lida.");
					break;
			}
		} while (opcao!=0);
		
	}
	private static void valorLiquidoMensal() {
		System.out.println("\nValor Liquido a Receber no mes/ano\n");
		String cpf = Console.readLine("CPF: ");
		int mes = Console.readInt("M�s: ");
		int ano = Console.readInt("Ano: ");
		try {
			System.out.println("Valor Liquido Mensal: " +
					objEmp.obterFuncionario(cpf).obterSalarioMensal(mes, ano));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	private static void lancHorasTrab() {
		System.out.println("\nLan�amento de Horas de Trabalho\n");
		String cpf = "";
		Funcionario objFunc = null;
		do {
			cpf = Console.readLine("CPF: ");
			try {
				objFunc = objEmp.obterFuncionario(cpf);
				if (objFunc.getTipo()!=Funcionario.HORARISTA) {
					System.out.println("O Func. n�o � Horista.");
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
				System.out.println("Data Inv�lida.");
			}
		} while (true);
		double quantHoras = 0;
		do {
			quantHoras = Console.readDouble("N� Horas: ");
			if (quantHoras > 0 && quantHoras <= 24) {
				break;
			} else {
				System.out.println("N� Horas Inv�lido.");
			}
		} while (true);
		try {
			((Horista)objFunc).incluirHoras(new Horas(dataTrab, quantHoras));
			System.out.println("Lan�amento de horas cadastrado.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	private static void consFuncNome() {
		System.out.println("\nConsultar Funcion�rio pelo Nome\n");
		try {
			for (Funcionario obj : objEmp.consFunNome(Console.readLine("Nome: "))) {
				System.out.println(obj.toString());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	private static void consFunCpf() {
		System.out.println("\nConsultar Funcion�rio pelo CPF\n");
		try {
			System.out.println(objEmp.obterFuncionario(Console.readLine("CPF: ")).toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	private static void incluirFunc() {
		System.out.println("\nCadastrar Funcion�rio\n");
		
		String cpf = "";
		do {
			cpf = Console.readLine("CPF : ");
			if (!LtpLib.validarCPF(cpf)) {
				System.out.println("DV do CPF n�o confere.");
				continue;
			}
			try {
				objEmp.obterFuncionario(cpf);
				System.out.println("CPF j� existe no cadastro.");
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
		double valor = Console.readDouble((tipoFun==1?"Sal�rio: ":"Valor Hora: "));
		if (tipoFun==1) {
			objEmp.incluirFuncionario(new Mensalista( cpf,nome,valor ) );
		} else {
			objEmp.incluirFuncionario(new Horista( cpf,nome,valor ) );
		}
		System.out.println("Funcion�rio Cadastrado.");
	}

}








