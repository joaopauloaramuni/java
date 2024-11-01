package controller;

import java.lang.invoke.CallSite;
import java.util.ArrayList;

import model.Aeronave;

/**
 * Classe de regras de negócio
 * @author joaopauloaramuni
 *
 */
public class HangarBiz {

	private ArrayList<Aeronave> listaAeronaves = new ArrayList<Aeronave>();

	public ArrayList<Aeronave> getListaAeronaves() {
		return listaAeronaves;
	}

	public void setListaAeronaves(ArrayList<Aeronave> listaAeronaves) {
		this.listaAeronaves = listaAeronaves;
	}

	//Método para CADASTRAR Aeronave
	public void cadastrarAeronave(Aeronave objAeronave) throws Exception {
		Boolean add = listaAeronaves.add(objAeronave);
		if(!add) {
			throw new Exception("Não foi possível realizar o cadastro de aeronave.");
		}
	}
	//Método para CONSULTAR Aeronave
	public Aeronave consultarAeronave(String idAeronave) throws Exception {
		for (Aeronave objAeronave : listaAeronaves) {
			if(idAeronave.equals(objAeronave.getIdAeronave())) {
				return objAeronave;
			}
		}
		throw new Exception("Não foi possível encontrar a aeronave.");
		
	}
	//Método para DELETAR Aeronave
	public void deletarAeronave(String idAeronave) throws Exception {
		Aeronave objAeronave = consultarAeronave(idAeronave);

		Boolean del = listaAeronaves.remove(objAeronave);
		if(!del) {
			throw new Exception("Não foi possível deletar a aeronave.");
		}
	}
	
}
