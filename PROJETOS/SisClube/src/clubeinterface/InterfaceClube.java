package clubeinterface;

import java.io.File;
import java.util.GregorianCalendar;
import java.util.Vector;

import clubecadastro.Clube;
import clubemodelo.Dependente;
import clubemodelo.Socio;

import utilitarios.Console;
import utilitarios.LtpLib;

public class InterfaceClube {
	// Atributos
	private static Clube objClube = new Clube();
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// ler cadastro de socios
		if (new File("Cadastro de Socios.obj").exists()) {
			try {
				objClube.setListaSocios(LtpLib.lerArquivoObjetos("Cadastro de Socios.obj"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(1);
			}
		}
		// menu
		menu();
		// gravar cadastro de socios
		try {
			LtpLib.gravarArquivoObjetos("Cadastro de Socios.obj", objClube.getListaSocios());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(2);			
		}
		// fechamento da aplicação
		System.out.println("Sistema finalizado.");
		System.exit(0);
	}

	private static void menu() {
		int opcao = 0;
		do {
			System.out.println("\nCadastro de Sócios");
			System.out.println("1-Cadastrar Sócio/Dependentes");
			System.out.println("2-Consultar Sócio/Dependentes pelo CPF");
			System.out.println("3-Consultar Sócios/Dependentes pelo Nome");	
			System.out.println("4-Encerrar Sócio pelo CPF");
			System.out.println("0-Sair da aplicação");
			opcao = Console.readInt("Opção: ");
			switch (opcao) {
				case 1:
					cadastarSocio();
					break;
				case 2:
					ConsultarSocioCPF();
					break;	
				case 3:
					
					break;
				case 4:
					
					break;	
				case 0:
					break;
				default:
					System.out.println("Opção inválida.");
					break;
			}
		} while (opcao!=0);
	}

	private static void cadastarSocio() {
		System.out.println("\nCadastrar Sócio/Dependentes");
		int codigo=0;
		String cpf;
		String nome="";
		String endereco="";
		GregorianCalendar dataEntrada = new GregorianCalendar();
		String entrada;		

		// CPF
		do {
			cpf = Console.readLine("CPF: ");
			if (!LtpLib.validarCPF(cpf) ) {
				System.out.println("DV do CPF inválido.");
			} else {
				try {
					objClube.consultarSocioCpf(cpf);
					System.out.println("Já existe Sócio para o CPF.");
				} catch (Exception e) {
					break;
				}
			}
		} while (true);
		
		nome = Console.readLine("Nome: ");
		endereco = Console.readLine("Endereço: ");
		// Código
		if (objClube.getListaSocios().isEmpty()) {
			codigo = 1;
		} else {
			codigo = objClube.getListaSocios().lastElement().getCodigo() + 1;
		}
		// Data de Entrada
		do {
			entrada = Console.readLine("Entrada: ");
			if (LtpLib.validarData(entrada, dataEntrada) && 
				dataEntrada.compareTo(new GregorianCalendar()) <= 0) {
				break;
			} else {
				System.out.println("Data Entrada Inválida.");
			}
		} while (true);
		
		// Dependentes
		Vector<Dependente> listaDependentes = new Vector<Dependente>();
		String nomeDep = "";
		GregorianCalendar nascimento = new GregorianCalendar();
		String nascimentoDep = "";
		String tipoDependencia = "";	
		int quantidadeDep = Console.readInt("Quantidade de dependentes: ");
		
		if (quantidadeDep > 0) {
			for (int i = 1 ; i <=quantidadeDep; i++) {
				nomeDep = Console.readLine("Nome do Dependente : ");
				do {
					nascimentoDep = Console.readLine("Nascimento: ");
					if (LtpLib.validarData(nascimentoDep, nascimento) && 
						nascimento.compareTo(new GregorianCalendar()) < 0	) {
						break;
					} else System.out.println("Nascimento inválido");
				} while (true);
				tipoDependencia = Console.readLine("Tipo de dependencia: ");
				listaDependentes.add(new Dependente(nomeDep, nascimento, tipoDependencia));
			}
			
			objClube.incluirSocio(new Socio(codigo, cpf, nome, endereco, dataEntrada, listaDependentes));
			System.out.println("Socio Cadastrado.");
		}
		
	}

	private static void ConsultarSocioCPF() {
		System.out.println("\nConsulta de Sócio/Dependentes pelo CPF");
		try {
			Socio objSocio = objClube.consultarSocioCpf(Console.readLine("CPF: "));
			System.out.println(objSocio.toString());
			// Dependentes
			if (objSocio.getListaDependentes().isEmpty()) {
				System.out.println("\nSócio não possui dependentes");
			} else {
				for (Dependente objDep : objSocio.getListaDependentes()) {
					System.out.println(objDep.toString());
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}














