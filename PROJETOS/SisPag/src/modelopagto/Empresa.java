package modelopagto;

import java.util.Vector;

public class Empresa {

	private Vector<Funcionario> listaFunc = new Vector<Funcionario>();

	public Vector<Funcionario> getListaFunc() {
		return listaFunc;
	}

	public void setListaFunc(Vector<Funcionario> listaFunc) {
		this.listaFunc = listaFunc;
	}
	
	public Funcionario consultaFuncCPF(String cpf) throws PagtoException {
		for (Funcionario objFunc : listaFunc) {
			if (objFunc.getCpf().equals(cpf)) return objFunc;
		}
		throw new PagtoException("Não existe funcionario para o CPF.");
	}
	
	public void cadastrarFunc (Funcionario objFunc) {
		listaFunc.add(objFunc);
	}
}



