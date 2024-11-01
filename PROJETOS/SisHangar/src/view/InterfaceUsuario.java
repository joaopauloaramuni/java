package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import controller.HangarBiz;
import model.*;
import utilitarios.Console;
import utilitarios.LtpLib;

/**
 * Interface com o usuário
 * 
 * @author joaopauloaramuni
 *
 */
public class InterfaceUsuario {

	// obj view-controller
	public static HangarBiz objBiz = new HangarBiz();

	// Método main
	public static void main(String[] args) {
		//menu();
		TelaPrincipal minhaJanela = new TelaPrincipal(objBiz);
		//minhaJanela.setSize(400,400);
	}

	// Método menu
	private static void menu() {
		int opcao = 0;
		do {
			System.out.println("\r\n" + "************ SisAeronave ***********\r\n" + "1 – Cadastrar aeronave\r\n"
					+ "2 – Consultar aeronave\r\n" + "3 – Editar aeronave\r\n" + "4 – Deletar aeronave\r\n"
					+ "5 – Listar todas as aeronaves\r\n" + "6 – Informar saída da aeronave\r\n"
					+ "7 – Gerar relatório gerencial\r\n" + "0 – Sair\r\n" + "");

			opcao = Console.readInt("Digite a opcao desejada: ");

			switch (opcao) {
			case 1:
				cadastrarAeronave();
				break;
			case 2:
				consultarAeronave();
				break;
			case 3:
				editarAeronave();
				break;
			case 4:
				deletarAeronave();
				break;
			case 5:
				listarAeronave();
				break;
			case 6:
				informarSaidaAeronave();
				break;
			case 7:
				gerarRelatorio();
				break;
			case 0:
				break;
			default:
				break;
			}

		} while (opcao != 0);
	}

	private static void gerarRelatorio() {

		System.out.println("Gerar Relatorio");

		String dataInicioString = Console.readLine("Digite a data inicio");
		String dataFimString = Console.readLine("Digite a data fim");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date dataInicio = sdf.parse(dataInicioString);
			Date dataFim = sdf.parse(dataFimString);

			for (Aeronave objAeronave : objBiz.getListaAeronaves()) {
				// Polimorfismo
				if (objAeronave.getDataEntrada().compareTo(dataFim) <= 0
						&& objAeronave.getDataEntrada().compareTo(dataInicio) >= 0)
					System.out.println(objAeronave.toString());

			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	private static void informarSaidaAeronave() {

		System.out.println("Informar Saida Aeronave");

		Aeronave objAeronave = null;
		try {
			objAeronave = objBiz.consultarAeronave(Console.readLine("Digite o idAeronave: "));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (objAeronave != null) {

			objAeronave.informarSaidaAeronave();
		} else {
			System.out.println("Aeronave não encontrada.");
		}
	}

	private static void listarAeronave() {
		System.out.println("Listar Aeronaves");
		System.out.println(objBiz.getListaAeronaves().toString());
	}

	private static void deletarAeronave() {
		System.out.println("Deletar Aeronave");

		try {
			objBiz.deletarAeronave(Console.readLine("Digite o id da Aeronave: "));
			System.out.println("Deletado com sucesso.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void editarAeronave() {
		System.out.println("Editar Aeronave");

		Aeronave objAeronave = null;
		try {
			objAeronave = objBiz.consultarAeronave(Console.readLine("Digite o idAeronave: "));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		objAeronave.setAnoFabricacao(Console.readInt("Digite o novo ano fab"));
		objAeronave.setAnoModelo(Console.readInt("Digite o novo ano mod"));
		objAeronave.setChassi(Console.readLine("Digite o novo chassi"));
		String dataString = Console.readLine("Digite a nova data entrada");
		objAeronave.setDataEntrada(new Date(dataString));
		objAeronave.setIdAeronave(Console.readLine("Digite o novo idAeronave"));
		objAeronave.setMarca(Console.readLine("Digite a nova marca"));
		objAeronave.setModelo(Console.readLine("Digite o novo modelo"));

		if (objAeronave instanceof Aviao) {
			((Aviao) objAeronave).setTelefonePiloto(Console.readLine("Digite o novo telefone piloto."));
			((Aviao) objAeronave).setLinhaAerea(Console.readLine("Digite a nova linha aerea"));
			((Aviao) objAeronave).setHorasVoo(Console.readInt("Digite horas voo."));
			((Aviao) objAeronave).setCpfPiloto(Console.readLine("Digite o novo cpf piloto."));
			((Aviao) objAeronave).setBrevePiloto(Console.readLine("Digite o novo breve piloto."));
		}

		if (objAeronave instanceof Jato) {
			((Jato) objAeronave).setValorAluguel(Console.readDouble("Digite o novo valor aluguel."));
			((Jato) objAeronave).setNomeEmpresa(Console.readLine("Digite o novo nome empresa"));
			((Jato) objAeronave).setCpfCopiloto(Console.readLine("Digite o novo cpf copiloto."));
			((Jato) objAeronave).setCpfComandante(Console.readLine("Digite o novo cpf comandante."));
		}

		if (objAeronave instanceof Helicoptero) {
			((Helicoptero) objAeronave).setCpfPilotoPrivado(Console.readLine("Digite o novo cpf piloto privado."));
			((Helicoptero) objAeronave).setQtdAssentos(Console.readLine("Digite a nova qtd de assentos"));
			((Helicoptero) objAeronave).setTipoCombustivel(Console.readLine("Digite o novo tipo combustivel."));
			((Helicoptero) objAeronave).setVelocidadeMax(Console.readInt("Digite a nova velocidade."));
		}

	}

	private static void consultarAeronave() {
		System.out.println("Consultar Aeronave");

		Aeronave objAeronave = null;
		try {
			objAeronave = objBiz.consultarAeronave(Console.readLine("Digite o idAeronave: "));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (objAeronave != null) {
			System.out.println(objAeronave.toString());
		} else {
			System.out.println("Aeronave não foi encontrada.");
		}
	}

	private static void cadastrarAeronave() {
		System.out.println("Cadastrar Aeronave");

		String idAeronave = Console.readLine("Digite o idAeronave: ");
		String chassi = Console.readLine("Digite o chassi: ");
		String marca = Console.readLine("Digite a marca: ");
		String modelo = Console.readLine("Digite o modelo: ");
		int anoModelo = Console.readInt("Digite o ano: ");
		int anoFabricacao = Console.readInt("Digite o anoFab: ");
		Date dataEntrada = new Date();
		// Date dataSaida;

		int opcao = Console.readInt("Digite 1 para cadastrar aviao, 2 para jato, 3 para helicoptero: ");
		Boolean validaCadastro = false;

		if (opcao == 1) {
			Aviao objAviao = new Aviao();

			String cpfPiloto = Console.readLine("Digite o cpfPiloto: ");
			String telefonePiloto = Console.readLine("Digite o telefone piloto: ");
			String brevePiloto = Console.readLine("Digite o breve: ");
			String linhaAerea = Console.readLine("Digite a linha aerea: ");
			int horasVoo = Console.readInt("Digite horas voo: ");
			boolean aviaoNoHangar = false;

			objAviao.setAnoFabricacao(anoFabricacao);
			objAviao.setAnoModelo(anoModelo);
			objAviao.setAviaoNoHangar(aviaoNoHangar);
			objAviao.setBrevePiloto(brevePiloto);
			objAviao.setChassi(chassi);
			objAviao.setCpfPiloto(cpfPiloto);
			objAviao.setDataEntrada(dataEntrada);
			objAviao.setHorasVoo(horasVoo);
			objAviao.setIdAeronave(idAeronave);
			objAviao.setLinhaAerea(linhaAerea);
			objAviao.setMarca(marca);
			objAviao.setModelo(modelo);
			objAviao.setTelefonePiloto(telefonePiloto);

			try {
				objBiz.cadastrarAeronave(objAviao);
				System.out.println("Sucesso ao cadastrar.");
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 

		} else if (opcao == 2) {
			Jato objJato = new Jato();

			String cpfComandante = Console.readLine("Digite o cpf comandante: ");
			String cpfCopiloto = Console.readLine("Digite o cpf copiloto: ");
			String nomeEmpresa = Console.readLine("Digite o nome empresa: ");
			Double valorAluguel = Console.readDouble("Digite o valor aluguel: ");
			boolean jatoNoHangar = false;

			objJato.setAnoFabricacao(anoFabricacao);
			objJato.setAnoModelo(anoModelo);
			objJato.setChassi(chassi);
			objJato.setCpfComandante(cpfComandante);
			objJato.setCpfCopiloto(cpfCopiloto);
			objJato.setDataEntrada(dataEntrada);
			objJato.setIdAeronave(idAeronave);
			objJato.setJatoNoHangar(jatoNoHangar);
			objJato.setMarca(marca);
			objJato.setModelo(modelo);
			objJato.setNomeEmpresa(nomeEmpresa);
			objJato.setValorAluguel(valorAluguel);

			try {
				objBiz.cadastrarAeronave(objJato);
				System.out.println("Sucesso ao cadastrar.");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} else if (opcao == 3) {
			Helicoptero objHelicoptero = new Helicoptero();

			String cpfPilotoPrivado = Console.readLine("Digite o cpf piloto privado");
			String tipoCombustivel = Console.readLine("Digite o tipo combustivel");
			String qtdAssentos = Console.readLine("Digite a qtd assentos");
			;
			int velocidadeMax = Console.readInt("Digite a velocidade max");
			boolean helicopteroNoHangar = false;

			objHelicoptero.setAnoFabricacao(anoFabricacao);
			objHelicoptero.setAnoModelo(anoModelo);
			objHelicoptero.setChassi(chassi);

			// Validacao cpf
			Boolean validaCpf = LtpLib.validarCPF(cpfPilotoPrivado);

			if (validaCpf) {
				objHelicoptero.setCpfPilotoPrivado(cpfPilotoPrivado);

				objHelicoptero.setDataEntrada(dataEntrada);
				objHelicoptero.setHelicopteroNoHangar(helicopteroNoHangar);
				objHelicoptero.setIdAeronave(idAeronave);
				objHelicoptero.setMarca(marca);
				objHelicoptero.setModelo(modelo);
				objHelicoptero.setQtdAssentos(qtdAssentos);
				objHelicoptero.setTipoCombustivel(tipoCombustivel);
				objHelicoptero.setVelocidadeMax(velocidadeMax);

				try {
					objBiz.cadastrarAeronave(objHelicoptero);
					System.out.println("Sucesso ao cadastrar.");

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} else {
				System.out.println("Cpf inválido.");
			}
		}

		if (validaCadastro) {
			System.out.println("Cadastrado com sucesso.");
		} else {
			System.out.println("Erro ao cadastrar.");
		}
	}
}
