package controller;

import java.util.ArrayList;

import model.Cliente;
import model.Empregado;
import model.Gerente;
import model.Pessoa;
import model.Vendedor;

public class Cadastro {

	public static ArrayList<Pessoa> pessoas = new ArrayList<>();
	
	public static void cadastrarGerente(Gerente gerente) {
		pessoas.add(gerente);
	}
	
	public static void cadastrarEmpregado(Empregado empregado) {
		pessoas.add(empregado);
	}
	
	public static void cadastrarCliente(Cliente cliente) {
		pessoas.add(cliente);
	}
	
	public static void cadastrarVendedor(Vendedor vendedor) {
		pessoas.add(vendedor);
	}
	
}
