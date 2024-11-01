package controller;



import java.util.HashMap;

import erros.BizException;
import model.Aeronave;

/**
 * Classe de regras de negócio
 * @author joaopauloaramuni
 *
 */
public class HangarBiz {

	/*private ArrayList<Aeronave> listaAeronaves = new ArrayList<Aeronave>();

	public ArrayList<Aeronave> getListaAeronaves() {
		return listaAeronaves;
	}

	public void setListaAeronaves(ArrayList<Aeronave> listaAeronaves) {
		this.listaAeronaves = listaAeronaves;
	}*/
	
	private HashMap<String, Aeronave> mapaAeronaves = new HashMap<String, Aeronave>(); 

	public HashMap<String, Aeronave> getMapaAeronaves() {
		return mapaAeronaves;
	}
	public void setMapaAeronaves(HashMap<String, Aeronave> mapaAeronaves) {
		this.mapaAeronaves = mapaAeronaves;
	}
	//Método para CADASTRAR Aeronave
	public void cadastrarAeronave(Aeronave objAeronave) throws BizException {
		//Com ArrayList
		
		/*Boolean add = listaAeronaves.add(objAeronave);
		if(!add) {
			throw new BizException("Não foi possível adicionar.");
		}*/
		
		//Com HashMap
		mapaAeronaves.put(objAeronave.getIdAeronave(), objAeronave);
		if(!mapaAeronaves.containsKey(objAeronave.getIdAeronave())) {
			throw new BizException("Não foi possível adicionar.");
		}
		
	}
	//Método para CONSULTAR Aeronave
	public Aeronave consultarAeronave(String idAeronave) {
		//Com ArrayList
		/*
		for (Aeronave objAeronave : listaAeronaves) {
			if(idAeronave.equals(objAeronave.getIdAeronave())) {
				return objAeronave;
			}
		}
		return null;*/
		
		//Com HashMap
		if(mapaAeronaves.containsKey(idAeronave)) {
			return mapaAeronaves.get(idAeronave);
		}
		return null;
		
	}
	//Método para DELETAR Aeronave
	public void deletarAeronave(String idAeronave) throws BizException {
		//Com ArrayList
		/*
		Aeronave objAeronave = consultarAeronave(idAeronave);
		if(objAeronave == null) {
			return false;
		}
		listaAeronaves.remove(objAeronave);
		return true;
		*/
		
		//Com HashMap
		mapaAeronaves.remove(idAeronave);
		if(mapaAeronaves.containsKey(idAeronave)) {
			throw new BizException("Não foi possível remover.");
		}
		
	}
	
}
