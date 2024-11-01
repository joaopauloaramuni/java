package usuario;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Vector;

import utilitarios.Console;
import utilitarios.LtpLib;

import modelopagto.Empresa;
import modelopagto.Funcionario;
import modelopagto.Horas;
import modelopagto.Horista;
import modelopagto.Mensalista;
import modelopagto.PagtoException;
import modelopagto.Faltas;

public class UsuarioPagto {

	// Atributos

	private static Empresa objEmpresa = new Empresa(); 

	/**
	 * Main
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// ler arquivo de funcionarios
		try {
			if (new File("CadFunc.obj").exists()) {
				objEmpresa.setListaFunc((Vector<Funcionario>)LtpLib.lerArquivoObjetos("CadFunc.obj"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1); // terminar
		}
		menu();
		// Gravar objetos Funcionario
		try {
			LtpLib.gravarArquivoObjetos("CadFunc.obj", objEmpresa.getListaFunc());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1); // terminar
		}
		System.out.println("\nPrograma Encerrado.");
		System.exit(0); // terminar

	}

	/**
	 * Menu
	 */
	private static void menu() {
		int opcao=0;
		do {
			System.out.println("\nMenu Funcionários");
			System.out.println("1-Cadastrar funcionário");
			System.out.println("2-Consultar funcionário pelo CPF");
			System.out.println("3-Registro de Horas Trabalhadas");
			System.out.println("4-Listagem dos funcionários em ordem do nome");
			System.out.println("5-Listagem dos funcionários em ordem do CPF");			
			System.out.println("6-Listagem dos funcionários em ordem do Tipo e Nome");	
		    System.out.println("7-Registrar falta do funcionário");	
		    System.out.println("8-Obter salário mensal do funcionário");
    	    System.out.println("9-Listar Horas trabalhadas do funcionário no mes/ano");	
		    System.out.println("10-Listar Faltas do funcionário no mes/ano");    	    
			System.out.println("0-Sair");
			opcao = Console.readInt("\nOpção: ");
			switch (opcao) {
				case 1:
					cadastrarFunc();
					break;
				case 2:
					consultarFunCPF();
					break;
				case 3:
					registrarHorasTrab();
					break;
				case 4:
					listagemFuncNome();
					break;	
				case 5:
					listagemFuncCPF();
					break;
				case 6:
					listagemFuncTipoNome();
					break;	
				case 7:
		     		registrarFalta();
					break;	
				case 8:
		     		obterSalarioMensal();
		     		break;	
				case 9:
		     		listarHorasTrab();
		     		break;
				case 10:
		     		listarFaltas();
		     		break;		     		
		     		
				case 0:
					break;
				default:
					System.out.println("Opção Inválida.");
					break;
			}
		} while (opcao!=0);
		
	}



	/**
	 * Cadastrar Funcionário
	 */
	private static void cadastrarFunc() {
		System.out.println("\nCadastrar Funcionário\n");
		String cpf = "";
		do {
			try {
				cpf = Console.readLine("CPF: ");
				if (cpf.equals("")) return;
				if (!LtpLib.validarCPF(cpf) )
					System.out.println("CPF inválido.");
				else {
					objEmpresa.consultaFuncCPF(cpf);
					System.out.println("Já existe funcionario para o CPF.");
				}
			} catch (PagtoException e) {
				break;
			}
		} while (true);
		String nome = "";
		do {
			nome = Console.readLine("Nome: ").trim();
			if (!nome.equals("")) break;
			System.out.println("Falta informar o nome.");
		} while (true);
		
		int tipo = 0;
		do {
			tipo = Console.readInt("1-Mensalista, 2-Horista : ");
			if (tipo < 1 || tipo > 2) 
				System.out.println("Tipo Inválido.");
			else break;
		} while (true);
		
		double valor = 0;
		do {
			valor = Console.readDouble((tipo==1?"Salario Mensal: ":"Salário Hora: "));
			if (valor<=0)
				System.out.println("Valor inválido.");
			else break;
		} while (true);
		
		if (tipo==1)
		      objEmpresa.cadastrarFunc(new Mensalista(cpf,nome,valor));
		else  objEmpresa.cadastrarFunc(new Horista(cpf,nome,valor));
		System.out.println("Funcionário cadastrado.");
		
		Console.readLine("<ENTER>");
		
	}

	
	/**
	 * Consultar Funcionário pelo CPF
	 */
	private static void consultarFunCPF() {
		System.out.println("\nConsultar Funcionário pelo CPF\n");
		try {
			String cpf = Console.readLine("CPF: ");
			System.out.println(objEmpresa.consultaFuncCPF(cpf).toString());
		} catch (PagtoException e) {
			System.out.println(e.getMessage());
		}
		Console.readLine("<ENTER>");
	}
	

	/**
	 * Registrar Horas Trabalhadas do funcionário
	 */
	private static void registrarHorasTrab() {
		System.out.println("\nRegistar Horas Trabalhadas para Funcionário\n");		
		String cpf = "";
		Funcionario objFunc = null;
		do {
			try {
				cpf = Console.readLine("CPF: ");
				objFunc = objEmpresa.consultaFuncCPF(cpf);
				if (objFunc.getTipo()==Funcionario.HORISTA)	break;
				System.out.println("Tipo de funcionário não é horista.");
			} catch (PagtoException e) {
				System.out.println(e.getMessage());
			}		
			
		} while (true);
		
		GregorianCalendar dataTrab = new GregorianCalendar();
		do {
			String data = Console.readLine("Data : ");
			if (LtpLib.validarData(data, dataTrab) && dataTrab.compareTo(new GregorianCalendar()) <= 0 )
				break;
			else System.out.println("Data inválida.");
			
		} while (true);
		
		double horasTrab = 0;
		do {
			horasTrab = Console.readDouble("Horas trabalhadas: ");
			if (horasTrab > 0 && horasTrab <= 24) break;
			else System.out.println("Horas inválido.");
		} while (true);
		
		try {
			((Horista)objFunc).addHoras(new Horas(dataTrab,horasTrab));
			System.out.println("Registro de horas efetuado.");
		} catch (PagtoException e) {
			System.out.println(e.getMessage());
		}
		Console.readLine("<ENTER>");
		
	}
	
	/**
	 * Listagem de funcionários em ordem do nome
	 */

	@SuppressWarnings("unchecked")
	private static void listagemFuncNome() {
		System.out.println("\nListagem de funcionários em ordem do nome\n");
		
		// Copiar a lista base para classificação
		Vector<Funcionario> listaFunc = (Vector<Funcionario>)objEmpresa.getListaFunc().clone();
		// Classificar a lista em ordem de nome usando a interface Comparable
		Collections.sort(listaFunc);
		int totFuncHor = 0;
		int totFuncMens = 0;
		for (Funcionario objFunc : listaFunc) {
			System.out.println(objFunc.toString());
			if (objFunc.getTipo()==Funcionario.HORISTA) totFuncHor++;
			else totFuncMens++;
		}
		System.out.println("\nHoristas    : " + totFuncHor + 
						   "\nMensalistas : " + totFuncMens + "\n");
		
		Console.readLine("<ENTER>");
	}
	/**
	 * Listagem de funcionário em ordem de CPF
	 */
	@SuppressWarnings("unchecked")	
	private static void listagemFuncCPF() {
		
		System.out.println("\nListagem de funcionários em ordem do CPF\n");
		// Copiar a lista base para classificação
		Vector<Funcionario> listaFunc = (Vector<Funcionario>)objEmpresa.getListaFunc().clone();		
		// Classificar a lista em ordem de nome usando a interface Comparator
		// Solução com classe interna anônima
		Collections.sort(listaFunc, new Comparator<Funcionario>() {

			@Override
			public int compare(Funcionario o1, Funcionario o2) {
				// TODO Auto-generated method stub
				return o1.getCpf().compareTo(o2.getCpf());
			} });
		int totFuncHor = 0;
		int totFuncMens = 0;
		for (Funcionario objFunc : listaFunc) {
			System.out.println(objFunc.toString());
			if (objFunc.getTipo()==Funcionario.HORISTA) totFuncHor++;
			else totFuncMens++;
		}
		System.out.println("\nHoristas    : " + totFuncHor + 
						   "\nMensalistas : " + totFuncMens + "\n");
		
		Console.readLine("<ENTER>");		
	}
	/**
	 * Listagem de funcionário em ordem de Tipo e Nome
	 */	
	@SuppressWarnings("unchecked")
	private static void listagemFuncTipoNome() {
		
		System.out.println("\nListagem de funcionários em ordem do Tipo e Nome\n");
		// Copiar a lista base para classificação
		Vector<Funcionario> listaFunc = (Vector<Funcionario>)objEmpresa.getListaFunc().clone();		
		// Classificar a lista em ordem de nome usando a interface Comparator
		// Solução com classe interna anônima
		Collections.sort(listaFunc, new Comparator<Funcionario>() {

			@Override
			public int compare(Funcionario o1, Funcionario o2) {
				if (o1.getTipo()==o2.getTipo())
				   return o1.getNome().compareTo(o2.getNome());
				else return String.valueOf(o1.getTipo()).compareTo(String.valueOf(o2.getTipo()));
			} });
		int totFuncHor = 0;
		int totFuncMens = 0;
		for (Funcionario objFunc : listaFunc) {
			System.out.println(objFunc.toString());
			if (objFunc.getTipo()==Funcionario.HORISTA) totFuncHor++;
			else totFuncMens++;
		}
		System.out.println("\nHoristas    : " + totFuncHor + 
						   "\nMensalistas : " + totFuncMens + "\n");
		
		Console.readLine("<ENTER>");		
	}	
	
	/**
	 * Registrar Falta do funcionário
	 */
	private static void registrarFalta() {
		System.out.println("\nRegistar Falta para Funcionário\n");			
		
		String cpf;
		do {
			cpf = Console.readLine("CPF : ");
			if (LtpLib.validarCPF(cpf)) break;
			System.out.println("CPF inválido.");
		} while (true);
		
		Funcionario func;
		try {
			func = objEmpresa.consultaFuncCPF(cpf);

		} catch (PagtoException e) {
			System.out.println(e.getMessage());
			return;
		}
		if (func.getTipo()==Funcionario.HORISTA) {
			System.out.println("CPF de funcionário horista.");
			return;
		}
		GregorianCalendar dataFalta = new GregorianCalendar();
		do {
			String data = Console.readLine("Data : ");
			if (LtpLib.validarData(data, dataFalta) && dataFalta.compareTo(new GregorianCalendar()) <= 0 )
				break;
			else System.out.println("Data inválida.");
			
		} while (true);

		String motivo;
		do {
			motivo = Console.readLine("Motivo : ");
			if (!motivo.trim().equals("")) break;
			System.out.println("Motivo inválido.");
		} while (true);	
		
		try {
			Mensalista funcMens = (Mensalista)func;
			funcMens.addFalta(new Faltas(dataFalta,motivo));
			System.out.println("Falta ao trabalho foi registrada.");
		} catch (PagtoException e) {
			System.out.println(e.getMessage());
		}
		
		Console.readLine("<ENTER>");		
	}

	/**
	 * Consultar Salário Mensal do funcionário
	 */
	private static void obterSalarioMensal() {
		System.out.println("\nConsulta de Salário Mensal\n");			
		
		String cpf;
		do {
			cpf = Console.readLine("CPF : ");
			if (LtpLib.validarCPF(cpf)) break;
			System.out.println("CPF inválido.");
		} while (true);
		
		Funcionario func;
		try {
			func = objEmpresa.consultaFuncCPF(cpf);

		} catch (PagtoException e) {
			System.out.println(e.getMessage());
			return;
		}
		int mes = Console.readInt("Mes : ");
		int ano = Console.readInt("Ano : ");
		System.out.println("\n--Cadastro--\n" + func.toString()
				           + "\nSalário do mes/ano : " 
				           + LtpLib.formatarValor(func.obterSalarioMensal(mes,ano),"R$#,##0.00"));;
		
		Console.readLine("<ENTER>");
	}	
	/**
	 * Listar horas trabalhadas do funcionário no mes
	 */
	private static void listarHorasTrab() {
		System.out.println("\n--- Listagem de horas trabalhadas do Funcionário ---\n");
		
		String cpf;
		do {
			cpf = Console.readLine("CPF : ");
			if (LtpLib.validarCPF(cpf)) break;
			System.out.println("CPF inválido.");
		} while (true);
		
		Funcionario func;
		try {
			func = objEmpresa.consultaFuncCPF(cpf);

		} catch (PagtoException e) {
			System.out.println(e.getMessage());
			return;
		}
		if (func.getTipo()==Funcionario.MENSALISTA) {
			System.out.println("CPF de funcionário mensalista.");
			return;
		}
		Vector <Horas> listaHor = ((Horista)func).getListaHoras();
		int mes = Console.readInt("Mês : ");
		int ano = Console.readInt("Ano : ");
		Vector<Horas> listaHorasMes = new Vector<Horas>();
		for (Horas objHora : listaHor) {
			if (objHora.getDataTrab().get(GregorianCalendar.MONTH)==(mes-1) && 
					objHora.getDataTrab().get(GregorianCalendar.YEAR)==ano)
			listaHorasMes.add(objHora);	
		}
		Collections.sort(listaHorasMes);
		
		double totHoras = 0;
		System.out.println();
		for (Horas objHora : listaHorasMes) {
			System.out.println(objHora.toString());
			totHoras += objHora.getQteHoras();
		}
		System.out.println("Total de Horas : " + LtpLib.formatarValor(totHoras, "#,##0.0"));
		Console.readLine("==>Listagem concluída.");
	}
	/**
	 * Listar Faltas do funcionário no mes
	 */	
	private static void listarFaltas() {
		System.out.println("\n--- Listagem das faltas do Funcionário ---\n");
		
		String cpf;
		do {
			cpf = Console.readLine("CPF : ");
			if (LtpLib.validarCPF(cpf)) break;
			System.out.println("CPF inválido.");
		} while (true);
		
		Funcionario func;
		try {
			func = objEmpresa.consultaFuncCPF(cpf);

		} catch (PagtoException e) {
			System.out.println(e.getMessage());
			return;
		}
		if (func.getTipo()==Funcionario.HORISTA) {
			System.out.println("CPF de funcionário horista.");
			return;
		}
		Vector <Faltas> listaFal = ((Mensalista)func).getListaFaltas();
		int mes = Console.readInt("Mês : ");
		int ano = Console.readInt("Ano : ");
		int totFaltas = 0;
		System.out.println();
		for (Faltas objFalta : listaFal) {
			if (objFalta.getDataFalta().get(GregorianCalendar.MONTH)==(mes-1) && 
					objFalta.getDataFalta().get(GregorianCalendar.YEAR)==ano) {
				System.out.println(objFalta.toString());
				totFaltas++;
			}
		}
		System.out.println("Total de Faltas : " + totFaltas);
		Console.readLine("==>Listagem concluída.");
		
	}	
}













