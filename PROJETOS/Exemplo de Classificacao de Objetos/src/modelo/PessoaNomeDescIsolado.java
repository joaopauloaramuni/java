package modelo;

import java.util.Comparator;

public class PessoaNomeDescIsolado implements Comparator<Pessoa> {

	@Override
	public int compare(Pessoa o1, Pessoa o2) {
		// TODO Auto-generated method stub
		return o1.getNome().compareTo(o2.getNome()) * -1;
	}
}
