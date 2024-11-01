package controller;

import java.util.ArrayList;

import model.Veiculo;

public class Oficina {

	private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

	public void cadastrarVeiculo(Veiculo veiculo) throws Exception {
		boolean adicionar = getVeiculos().add(veiculo);
		if (!adicionar) {
			throw new Exception("Erro ao cadastrar veículo!!!");
		}
	}

	public Veiculo consultarVeiculo(String placa) throws Exception {
		for (Veiculo veiculo : getVeiculos()) {
			if (placa.equals(veiculo.getPlaca())) {
				return veiculo;
			}
		}
		throw new Exception("Não existe veículo para a placa informada!");
	}

	public void deletarVeiculo(String placa) throws Exception {
		boolean remove = getVeiculos().remove(consultarVeiculo(placa));
		if (!remove) {
			throw new Exception("Erro ao deletar veiculo!!!");
		}
	}

	public ArrayList<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(ArrayList<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

}
