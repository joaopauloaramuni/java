package view;

import java.io.File;
import java.util.ArrayList;
import controller.PetBiz;
import model.Pet;
import utilitarios.Console;
import utilitarios.LtpLib;

public class InterfaceUsuario {

	// Atributos
	private static PetBiz objPetBiz = new PetBiz();

	public static void main(String[] args) {

		// ler cadastro de alunos
		if (new File("Pet.obj").exists()) {
			try {
				objPetBiz.setListaPets(LtpLib.lerArquivoObjetosArray("Pet.obj"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(1);
			}
		}

		// menu
		menu();

		// gravar cadastro de alunos
		try {
			LtpLib.gravarArquivoObjetosArray("Pet.obj", objPetBiz.getListaPets());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(4);
		}

		// fechamento da aplicação
		System.out.println("Sistema finalizado.");
		System.exit(0);
	}

	private static void menu() {
		int opcao = 0;
		do {
			System.out.println("\nSisPet – Sistema de Cadastro de Pets");
			System.out.println("1-Cadastrar Pet");
			System.out.println("2-Consultar Pet");
			System.out.println("3-Editar Pet");
			System.out.println("4-Deletar Pet");
			System.out.println("5-Listar todos os pets");
			System.out.println("0-Sair da aplicação");
			opcao = Console.readInt("Opção: ");
			switch (opcao) {
			case 1:
				cadastrarPet();
				break;
			case 2:
				consultarPet();
				break;
			case 3:
				editarPet();
				break;
			case 4:
				deletarPet();
				break;
			case 5:
				listarPets();
				break;
			case 0:
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}
		} while (opcao != 0);
	}

	private static void listarPets() {
		System.out.println("\nListar Pet");
		System.out.println(objPetBiz.getListaPets().toString());
	}

	private static void deletarPet() {
		System.out.println("\nDeletar Pet");

		try {
			objPetBiz.deletarPet(Console.readLine("Nome do pet: "));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static Pet consultarPet() {

		Pet objPet = null;

		System.out.println("\nConsultar Pet");
		try {
			objPet = objPetBiz.consultarPet(Console.readLine("Nome do pet: "));
			System.out.println(objPet.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return objPet;
	}

	private static void cadastrarPet() {

		System.out.println("\nCadastrar Pet");

		int codigo;
		String nome;
		String cpfDono;
		String telDono;

		nome = Console.readLine("Nome do pet: ");
		cpfDono = Console.readLine("Cpf do dono: ");
		telDono = Console.readLine("Tel do dono: ");

		// Código
		if (objPetBiz.getListaPets().isEmpty()) {
			codigo = 1;
		} else {
			codigo = objPetBiz.getListaPets().size() + 1;
		}

		Pet objPet = new Pet(codigo, nome, cpfDono, telDono);

		try {
			objPetBiz.cadastrarPet(objPet);
			System.out.println("Pet cadastrado com sucesso!!!");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void editarPet() {
		System.out.println("\nEditar Pet");

		Pet objPet = consultarPet();
		if (objPet != null) {
			objPet.setNome(Console.readLine("Digite o novo nome do pet: "));
			objPet.setCpfDono(Console.readLine("Digite o novo cpf do dono: "));
			objPet.setTelDono(Console.readLine("Digite o novo tel do dono: "));
		}
	}

}
