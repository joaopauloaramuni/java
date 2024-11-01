package Cadastro;

import java.util.Collections;
import java.util.Vector;

import modelo.Funcionario;
public class Empresa {
	private Vector<Funcionario> cadFunc = new Vector<Funcionario>();

	public Vector<Funcionario> getCadFunc() {
		return cadFunc;
	}
	public void setCadFunc(Vector<Funcionario> cadFunc) {
		this.cadFunc = cadFunc;
	}
	public Funcionario obterFuncionario(String cpf) throws Exception{
		for (Funcionario obj : cadFunc) {
			if (obj.getCpf().equals(cpf)) return obj;
		}
		throw new Exception("Não existe funcionário para o CPF informado.");
	}
	public void excluirFuncionario(Funcionario objFunc) {
		cadFunc.remove(objFunc);
	}
	public void incluirFuncionario(Funcionario objFunc) {
		cadFunc.add(objFunc);
	}
	public Vector<Funcionario> consFunNome(String nome) throws Exception{
		Vector<Funcionario> resposta = new Vector<Funcionario>();
		for (Funcionario obj : cadFunc) {
			if (obj.getNome().toUpperCase().indexOf(nome.toUpperCase())!=-1) {
				resposta.add(obj);
			}
		}
		if (resposta.isEmpty()) {
			throw new Exception("Não existe funcionário para o nome informado.");
		} else {
			Collections.sort(resposta);
			return resposta;
		}
	}
}






