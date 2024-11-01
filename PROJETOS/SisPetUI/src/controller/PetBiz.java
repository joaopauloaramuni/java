package controller;

import java.util.ArrayList;

import model.Pet;

public class PetBiz {

	
	/**
	 * ArrayList global para gravação dos pets
	 */
	private ArrayList<Pet> listaPets = new ArrayList<Pet>();

	public ArrayList<Pet> getListaPets() {
		return listaPets;
	}

	public void setListaPets(ArrayList<Pet> listaPets) {
		this.listaPets = listaPets;
	}

	/**
	 * Método para cadastrar Pet
	 * @param objPet
	 * @throws Exception Erro genérico que irá ocorrer ao cadastrar um pet
	 */
	public void cadastrarPet(Pet objPet) throws Exception {

		boolean adicionar = getListaPets().add(objPet);
		if (!adicionar) {
			throw new Exception("Erro ao cadastrar pet!!!");
		}

	}

	/**
	 * Método para consultar Pet
	 * @param nomePet
	 * @return Pet
	 * @throws Exception
	 */
	public Pet consultarPet(String nomePet) throws Exception {
		for (Pet pet : getListaPets()) {
			if (nomePet.equals(pet.getNome())) {
				return pet;
			}
		}
		throw new Exception("Não existe pet para o nome informado");
	}

	public void deletarPet(String nomePet) throws Exception {

		Pet objPet = consultarPet(nomePet);
		boolean remover = getListaPets().remove(objPet);
		if (!remover) {
			throw new Exception("Erro ao remover pet!!!");
		}
	}

}
