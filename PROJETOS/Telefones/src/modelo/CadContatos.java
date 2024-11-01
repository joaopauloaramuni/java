package modelo;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Vector;

public class CadContatos {
	private HashMap<String, Contatos> listaContatos = new HashMap<String, Contatos>();

	public HashMap<String, Contatos> getListaContatos() {
		return listaContatos;
	}

	public void setListaContatos(HashMap<String, Contatos> listaContatos) {
		this.listaContatos = listaContatos;
	}
	public String consPorTelefone(String telefone) throws Exception {
		if (listaContatos.containsKey(telefone)) {
			return listaContatos.get(telefone).getNome();
		} else {
			throw new Exception("Telefone não está cadastrado.");
		}
	}
    public Vector<Contatos> consPorNome(String nome) throws Exception {
    	Vector<Contatos> contatos = new Vector<Contatos>();
    	for (Contatos obj : listaContatos.values()) {
    		if (obj.getNome().toUpperCase().indexOf(nome.toUpperCase())!=-1) {
    			contatos.add(obj);
    		}
    	}
    	if (contatos.isEmpty()) {
    		throw new Exception("Não existe telefone para o nome informado.");
    	}
    	Collections.sort(contatos, new Comparator<Contatos>() {

			@Override
			public int compare(Contatos o1, Contatos o2) {
				// TODO Auto-generated method stub
				return o1.getNome().compareTo(o2.getNome());
			}
		});
    	return contatos;
    }
	
}




