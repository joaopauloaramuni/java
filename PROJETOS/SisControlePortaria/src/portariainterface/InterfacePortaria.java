package portariainterface;

import java.io.File;
import java.util.GregorianCalendar;
import java.util.Vector;

import portariacadastro.Portaria;
import portariamodelo.Visitante;
import utilitarios.Console;
import utilitarios.LtpLib;

/**
 * Interagir com o usu�rio do sistema de registro de visitantes
 */
public class InterfacePortaria {
	// 	Atributos
	private static Portaria controle = new Portaria();
	
	// M�todos
	
	public static void main(String[] args) {
		// Ler Arquivo
		try {
			if (  new File("Portaria.obj").exists() )
				controle.setListaVisitantes(LtpLib.lerArquivoObjetos("Portaria.obj"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}

		menu();

		// Gravar Arquivo
		try {
			LtpLib.gravarArquivoObjetos("Portaria.obj",controle.getListaVisitantes());			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}


		// Fechar aplicativo
		System.out.println("\nPrograma Encerrado !");
		System.exit(0);
	}

	private static void menu() {
       int opcao = 0;
       do {
		     System.out.println("\n--- Menu Portaria ---");
		     System.out.println("1 - Cadastrar Visita");
		     System.out.println("2 - Excluir Visita");
		     System.out.println("3 - Encerrar Visita");
		     System.out.println("4 - Consultar visita pelo c�digo");
		     System.out.println("5 - Consultar visitas pelo per�odo");
		     System.out.println("6 - Consultar os visitantes que est�o no estabelecimento");
		     System.out.println("7 - Consultar visitas pelo nome");
		     System.out.println("0 - Sai do Programa");
		     opcao = Console.readInt("Op��o : ");
		     switch (opcao) {
		     	case 1 :
		     		cadastrarVisita();
		     		break;
		     	case 2 :
		     		excluirVisita();
		     		break;
		     	case 3 :
		     		encerrarVisita();
		     		break;
		     	case 4 :
		     		consultarVisitaCodigo();
		     		break;
		     	case 5 :
		     		consultarVisitasPeriodo();
		     		break;
		     	case 6 :
		     		consultarVisitasNoEstabelec();
		     		break;
		     	case 7 :
		     		consultarVisitasNome();
		     		break;

		     	case 0 :
		     		break;
		     	default :
		     		System.out.println("Op��o Inv�lida.");
		     		break;
		     }
       } while (opcao!=0);

    }

	private static void cadastrarVisita() {
		System.out.println("\n--- Cadastrar Visita ---\n");
		int codigo = controle.getListaVisitantes().isEmpty() ? 1 : controle.getListaVisitantes().lastElement().getCodVisitante()+1;		String nome;
		do {
			nome = LtpLib.padronizarTexto(Console.readLine("Nome : "));
			if (nome.equals("")) return;
			if (LtpLib.contarPalavras(nome)>1) break;
			System.out.println("Nome inv�lido.");
		} while (true);
		String cpf;
		do {
			cpf = Console.readLine("CPF : ");
			if (LtpLib.validarCPF(cpf)) break;
			System.out.println("CPF inv�lido.");
		} while (true);
		String localVisita;
		do {
			localVisita = LtpLib.padronizarTexto(Console.readLine("Local Visita : "));
			if (!localVisita.trim().equals("")) break;
			System.out.println("Falta o da Local Visita.");
		} while (true);
		String contato;
		do {
			contato = LtpLib.padronizarTexto(Console.readLine("Contato : "));
			if (!contato.trim().equals("")) break;
			System.out.println("Falta Contato.");
		} while (true);
		try {
			controle.incluirVisitante(new Visitante(codigo, nome, cpf, localVisita, contato,new GregorianCalendar(),null));
			System.out.println("Visita cadastrada.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		Console.readLine("\n<ENTER>");
	}

	private static void excluirVisita() {
		System.out.println("\n--- Excluir Visita ---\n");
		int codVisita = Console.readInt("C�digo da visita: ");
		if (codVisita <= 0) return;
		try {
			Visitante vis = controle.consultarVisitaCodigo(codVisita);
			System.out.println(vis.toString());
			
			if (Console.readLine("Confirmar a exclus�o (s/n)? ").equalsIgnoreCase("s")) {
				controle.excluirVisitante(vis);
				System.out.println("Visita exclu�da.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Console.readLine("\n<ENTER>");
	}

	private static void encerrarVisita() {
		System.out.println("\n--- Encerrar Visita ---\n");
		int codVisita = Console.readInt("C�digo da visita: ");
		if (codVisita <= 0) return;
		try {
			Visitante vis = controle.consultarVisitaCodigo(codVisita);
			System.out.println(vis.toString());
			if (Console.readLine("Confirmar o encerramento (s/n)? ").equalsIgnoreCase("s")) {
				controle.encerrarVisitante(vis);
				System.out.println("Visita encerrada.");
			}	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Console.readLine("\n<ENTER>");		
	}

	private static void consultarVisitaCodigo() {
		System.out.println("\n--- Consultar Visita pelo c�digo ---\n");
		int codVisita = Console.readInt("C�digo da visita: ");
		if (codVisita <= 0) return;
		try {
			Visitante vis = controle.consultarVisitaCodigo(codVisita);
			System.out.println( vis.toString());
			if (vis.getSaida()==null) {
			   System.out.println("Tempo da visita at� o momento: " + LtpLib.formatarMilisegundos((long)LtpLib.subtrairHoras(vis.getEntrada(),new GregorianCalendar(),LtpLib.RETORNAR_MILISEGUNDOS), LtpLib.RETORNAR_MILISEGUNDOS));
			} else {
			   System.out.println("Tempo da visita: " + LtpLib.formatarMilisegundos((long)LtpLib.subtrairHoras(vis.getEntrada(),vis.getSaida(),LtpLib.RETORNAR_MILISEGUNDOS), LtpLib.RETORNAR_MILISEGUNDOS));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
        Console.readLine("\n==>Consulta concluida.");
	}

	private static void consultarVisitasPeriodo() {
		System.out.println("\n--- Consultar Visitas pelo per�odo ---\n");
		
		String dataInput1;
		GregorianCalendar dt1 = new GregorianCalendar();
		do {
			dataInput1  = Console.readLine("Data/Hora Inicial (dd/mm/aaaa hh:mm:ss) : ");
			if (dataInput1.equals("")) return;
			if ( LtpLib.validarDataHora(dataInput1, dt1)) break;
			System.out.println("Data/Hora Inicial Inv�lida");
		} while (true);

		String dataInput2;
		GregorianCalendar dt2 = new GregorianCalendar();
		do {
			dataInput2  = Console.readLine("Data/Hora Final (dd/mm/aaaa hh:mm:ss) : ");
			if ( LtpLib.validarDataHora(dataInput2, dt2)) break;
			System.out.println("Data Final Inv�lida");
		} while ( true );

		try {
			Vector<Visitante> lisVis = controle.consultarVisitasPeriodo(dt1,dt2);

			for (Visitante vis : lisVis) {
				System.out.println(vis.toString());
				if (vis.getSaida()==null) {
				   System.out.println("Tempo da visita at� o momento: " + LtpLib.formatarMilisegundos((long)LtpLib.subtrairHoras(vis.getEntrada(),new GregorianCalendar(),LtpLib.RETORNAR_MILISEGUNDOS), LtpLib.RETORNAR_MILISEGUNDOS));
				} else {
				   System.out.println("Tempo da visita: " + LtpLib.formatarMilisegundos((long)LtpLib.subtrairHoras(vis.getEntrada(),vis.getSaida(),LtpLib.RETORNAR_MILISEGUNDOS), LtpLib.RETORNAR_MILISEGUNDOS));
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
        Console.readLine("\n==>Consulta concluida.");
	}

	private static void consultarVisitasNoEstabelec() {
		System.out.println("\n--- Consultar Visitas que est�o no estabelecimento ---\n");
        try {
    		Vector<Visitante> lisVis = controle.consultarVisitasNoEstabelec();

    		for (Visitante vis : lisVis){
    			System.out.println(vis.toString());
    			System.out.println("Tempo da visita at� o momento: " + LtpLib.formatarMilisegundos((long)LtpLib.subtrairHoras(vis.getEntrada(),new GregorianCalendar(),LtpLib.RETORNAR_MILISEGUNDOS), LtpLib.RETORNAR_MILISEGUNDOS));
    		}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
        Console.readLine("\n==>Consulta concluida.");
	}
	private static void consultarVisitasNome() {
		
		System.out.println("\n--- Consultar Visitas pelo nome ---\n");
		String nome = Console.readLine("Nome :");

        try {
    		Vector<Visitante> lisVis = controle.consultarVisitasNome(nome);

    		for (Visitante vis : lisVis){
    			System.out.println(vis.toString());
    			if (vis.getSaida()==null) {
    			   System.out.println("Tempo da visita at� o momento: " + LtpLib.formatarMilisegundos((long)LtpLib.subtrairHoras(vis.getEntrada(),new GregorianCalendar(),LtpLib.RETORNAR_MILISEGUNDOS), LtpLib.RETORNAR_MILISEGUNDOS));
    			} else {
    			   System.out.println("Tempo da visita: " + LtpLib.formatarMilisegundos((long)LtpLib.subtrairHoras(vis.getEntrada(),vis.getSaida(),LtpLib.RETORNAR_MILISEGUNDOS), LtpLib.RETORNAR_MILISEGUNDOS));
    			}
    		}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Console.readLine("\n==>Consulta concluida.");

	}

}