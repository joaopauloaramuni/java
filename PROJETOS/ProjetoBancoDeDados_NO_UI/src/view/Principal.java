package view;

import java.util.ArrayList;

import dao.DAOUtil;
import entity.Empresa;
import entity.Funcionario;

public class Principal {
	public static void main(String[] args) {
		ArrayList<Empresa> empresas = new ArrayList<Empresa>();
		empresas = DAOUtil.obterEmpresas();
		
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		funcionarios = DAOUtil.obterFuncionarios(0);
		
		for (Empresa empresa : empresas) {
			System.out.println("EMPRESA: \n"  + empresa.getNome() + " " + empresa.getEndereco() + "\n");
		}
		
		for (Funcionario funcionario : funcionarios) {
			System.out.println("FUNCIONÁRIO: \n" + funcionario.getNome() + " " + funcionario.getEndereco() + "\n");
		}

	}
}
