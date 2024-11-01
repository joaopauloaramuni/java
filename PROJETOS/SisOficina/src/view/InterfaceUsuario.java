package view;

import utilitarios.Console;
import utilitarios.LtpLib;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import model.Carro;
import model.Moto;
import model.Veiculo;

import controller.Oficina;

public class InterfaceUsuario {

	private static Oficina objOficina = new Oficina();

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// ler arquivo veiculos.obj
		if (new File("Veiculos.obj").exists()) {
			try {
				objOficina.setVeiculos(LtpLib
						.lerArquivoObjetosArray("Veiculos.obj"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(1);
			}
		}

		// menu
		menu();

		// gravar arquivo veiculos.obj
		try {
			LtpLib.gravarArquivoObjetosArray("Veiculos.obj",
					objOficina.getVeiculos());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(2);
		}

	}

	private static void menu() {
		int opcao = 0;
		do {
			System.out
					.println("\nSisOficina � Sistema para controle interno de oficina mec�nica");
			System.out.println("1-Cadastrar ve�culo");
			System.out.println("2-Consultar ve�culo");
			System.out.println("3-Editar ve�culo");
			System.out.println("4-Deletar ve�culo");
			System.out.println("5-Listar todos os ve�culos");
			System.out.println("6-Informar sa�da do ve�culo");
			System.out.println("7-Gerar relat�rio gerencial");
			System.out.println("0-Sair da aplica��o");
			opcao = Console.readInt("Op��o: ");
			switch (opcao) {
			case 1:
				cadastrarVeiculo();
				break;
			case 2:
				consultarVeiculo();
				break;
			case 3:
				editarVeiculo();
				break;
			case 4:
				deletarVeiculo();
				break;
			case 5:
				listarVeiculos();
				break;
			case 6:
				informarSaidaVeiculo();
				break;
			case 7:
				gerarRelatorio();
				break;
			case 0:
				break;
			default:
				System.out.println("Op��o inv�lida.");
				break;
			}
		} while (opcao != 0);

	}

	private static void gerarRelatorio() {
		System.out.println("\nGerar Relat�rio");

		String dataInicio = Console.readLine("Data in�cio: ");
		String dataFim = Console.readLine("Data fim: ");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date dataFormatadaInicio = sdf.parse(dataInicio);
			System.out.println("Data in�cio v�lida!!!");

			Date dataFormatadaFim = sdf.parse(dataFim);
			System.out.println("Data fim v�lida!!!");

			for (Veiculo veiculo : objOficina.getVeiculos()) {
				if (setTimeToMidnight(veiculo.getDataEntrada()).compareTo(
						dataFormatadaFim) <= 0
						&& setTimeToMidnight(veiculo.getDataEntrada())
								.compareTo(dataFormatadaInicio) >= 0) {
					// Polimorfismo
					System.out.println(veiculo.toString());
				}

			}

		} catch (Exception e) {
			System.out.println("Data inv�lida!!!");
			System.out.println(e.getMessage());
		}
	}

	private static Date setTimeToMidnight(Date date) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

	private static void informarSaidaVeiculo() {
		System.out.println("\nInformar Sa�da do Ve�culo");
		try {
			Veiculo objVeiculo = objOficina.consultarVeiculo(Console
					.readLine("Placa: "));

			// Polimorfismo
			System.out.println("Antes:" + objVeiculo.toString());
			objVeiculo.informarSaidaVeiculo();
			System.out.println("Depois:" + objVeiculo.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void listarVeiculos() {
		System.out.println("\nListar Ve�culos");
		for (Veiculo veiculo : objOficina.getVeiculos()) {
			// Polimorfismo
			System.out.println(veiculo.toString());
		}
	}

	private static void deletarVeiculo() {
		System.out.println("\nDeletar Ve�culo");
		try {
			objOficina.deletarVeiculo(Console.readLine("Placa: "));
			System.out.println("Ve�culo deletado com sucesso!!!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void editarVeiculo() {
		System.out.println("\nEditar Ve�culo");
		try {
			Veiculo objVeiculo = objOficina.consultarVeiculo(Console
					.readLine("Placa: "));

			// Informa��es do ve�culo
			objVeiculo.setPlaca(Console.readLine("Digite a nova placa: "));
			objVeiculo.setChassi(Console.readLine("Digite o novo chassi: "));
			objVeiculo.setMarca(Console.readLine("Digite a nova marca: "));
			objVeiculo.setModelo(Console.readLine("Digite o novo modelo: "));
			objVeiculo.setAnoModelo(Console
					.readInt("Digite o novo ano modelo: "));
			objVeiculo.setAnoFabricacao(Console
					.readInt("Digite o novo ano fabrica��o: "));

			// No caso de carro
			if (objVeiculo instanceof Carro) {
				((Carro) objVeiculo).setCpfDono(Console
						.readLine("Digite o novo cpf do dono: "));
				((Carro) objVeiculo).setTelefoneDono(Console
						.readLine("Digite o novo telefone do dono: "));
				((Carro) objVeiculo).setQuilometragem(Console
						.readLine("Digite a nova quilometragem: "));
				((Carro) objVeiculo).setCavalos(Console
						.readInt("Digite a nova quantidade de cavalos: "));
			}

			// No caso de moto
			if (objVeiculo instanceof Moto) {
				((Moto) objVeiculo).setNomeMotoboy(Console
						.readLine("Digite o novo nome do motoboy: "));
				((Moto) objVeiculo).setTelefoneMotoboy(Console
						.readLine("Digite o novo telefone do motoboy: "));
				((Moto) objVeiculo).setModeloCapacete(Console
						.readLine("Digite a novo modelo do capacete: "));
				((Moto) objVeiculo).setCilindradas(Console
						.readInt("Digite a nova quantidade de cilindradas: "));
			}

			System.out.println("Ve�culo editado com sucesso!!!");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void consultarVeiculo() {
		System.out.println("\nConsultar Ve�culo");
		try {
			Veiculo objVeiculo = objOficina.consultarVeiculo(Console
					.readLine("Placa: "));

			// Polimorfismo
			System.out.println(objVeiculo.toString());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void cadastrarVeiculo() {

		try {

			System.out.println("\nCadastrar Ve�culo");

			// Preencher informa��es de ve�culo
			String placa;
			String chassi;
			String marca;
			String modelo;
			int anoModelo;
			int anoFabricacao;
			Date dataEntrada = new Date();

			placa = Console.readLine("Placa: ");
			chassi = Console.readLine("Chassi: ");
			marca = Console.readLine("Marca: ");
			modelo = Console.readLine("Modelo: ");
			anoModelo = Console.readInt("Ano Modelo: ");
			anoFabricacao = Console.readInt("Ano Fabrica��o: ");

			// Verificar se � carro ou moto
			int selecao = 0;

			selecao = Console
					.readInt("Deseja efetuar o cadastro de carro (1) ou de moto (2): ");
			if (selecao == 1) {
				String cpfDono;
				String telefoneDono;
				String quilometragem;
				int cavalos;

				cpfDono = Console.readLine("Cpf dono: ");
				telefoneDono = Console.readLine("Telefone dono: ");
				quilometragem = Console.readLine("Quilometragem: ");
				cavalos = Console.readInt("Cavalos: ");

				Carro carro = new Carro(cpfDono, telefoneDono, quilometragem,
						cavalos, true, placa, chassi, marca, modelo, anoModelo,
						anoFabricacao, dataEntrada);

				objOficina.cadastrarVeiculo(carro);

				System.out.println("Carro cadastrado com sucesso!!!");
			} else if (selecao == 2) {
				String nomeMotoboy;
				String telefoneMotoboy;
				String modeloCapacete;
				int cilindradas;

				nomeMotoboy = Console.readLine("Nome motoboy: ");
				telefoneMotoboy = Console.readLine("Telefone motoboy: ");
				modeloCapacete = Console.readLine("Modelo capacete: ");
				cilindradas = Console.readInt("Cilindradas: ");

				Moto moto = new Moto(nomeMotoboy, telefoneMotoboy,
						modeloCapacete, cilindradas, true, placa, chassi,
						marca, modelo, anoModelo, anoFabricacao, dataEntrada);

				objOficina.cadastrarVeiculo(moto);

				System.out.println("Moto cadastrada com sucesso!!!");
			} else {
				System.out.println("Op��o inv�lida!!!");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
