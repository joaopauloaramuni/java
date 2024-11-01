package controller;

import java.lang.invoke.CallSite;
import java.util.ArrayList;

import model.Aeronave;

/**
 * Classe de regras de neg�cio
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

	//M�todo para CADASTRAR Aeronave
	public void cadastrarAeronave(Aeronave objAeronave) throws Exception {
		Boolean add = listaAeronaves.add(objAeronave);
		if(!add) {
			throw new Exception("N�o foi poss�vel realizar o cadastro de aeronave.");
		}
	}
	//M�todo para CONSULTAR Aeronave
	public Aeronave consultarAeronave(String idAeronave) throws Exception {
		for (Aeronave objAeronave : listaAeronaves) {
			if(idAeronave.equals(objAeronave.getIdAeronave())) {
				return objAeronave;
			}
		}
		throw new Exception("N�o foi poss�vel encontrar a aeronave.");
		
	}
	//M�todo para DELETAR Aeronave
	public void deletarAeronave(String idAeronave) throws Exception {
		Aeronave objAeronave = consultarAeronave(idAeronave);

		Boolean del = listaAeronaves.remove(objAeronave);
		if(!del) {
			throw new Exception("N�o foi poss�vel deletar a aeronave.");
		}
	}
	
}
