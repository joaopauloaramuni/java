package controller;

import java.util.ArrayList;

import model.Pet;

public class PetBiz {

	
	/**
	 * ArrayList global para grava��o dos pets
	 */
	private ArrayList<Pet> listaPets = new ArrayList<Pet>();

	public ArrayList<Pet> getListaPets() {
		return listaPets;
	}

	public void setListaPets(ArrayList<Pet> listaPets) {
		this.listaPets = listaPets;
	}

	/**
	 * M�todo para cadastrar Pet
	 * @param objPet
	 * @throws Exception Erro gen�rico que ir� ocorrer ao cadastrar um pet
	 */
	public void cadastrarPet(Pet objPet) throws Exception {

		boolean adicionar = getListaPets().add(objPet);
		if (!adicionar) {
			throw new Exception("Erro ao cadastrar pet!!!");
		}

	}

	/**
	 * M�todo para consultar Pet
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
		throw new Exception("N�o existe pet para o nome informado");
	}

	public void deletarPet(String nomePet) throws Exception {

		Pet objPet = consultarPet(nomePet);
		boolean remover = getListaPets().remove(objPet);
		if (!remover) {
			throw new Exception("Erro ao remover pet!!!");
		}
	}

}
