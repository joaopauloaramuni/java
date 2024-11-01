package caixa;
import utilitarios.Console;
/*
	Implemente a lógica para realização de saques em um caixa eletrônico
	considerando que o mesmo armazena cédulas de R$100,00, R$50,00, R$20,00, 
	R$10,00, R$5,00, R$2,00 e R$1,00 e devem ser entregues ao cliente o menor
	número possível de cédulas. 
*/
public class CaixaEletronico {
	public static void main(String[] args) {
		//Cedulas disponiveis no caixa eletronico
		int[] cedulas = {100, 50, 20, 10, 5, 2, 1};
		//Quantidade total de cedulas entregues ao cliente
		int quantidadeTotal = 0;
		//valor a ser sacado pelo cliente
		int valorReais = Console.readInt("Valor do Saque: ");
		//Percorrendo todas as cedulas disponiveis no caixa eletronico
		for(int i = 0; i < cedulas.length; i++)	{
			//Quantidade de cedulas para o valor cedulas[i]
			int quantidadeCedulas = valorReais/cedulas[i];
			//Impressao da quantidade de cedulas
			if (quantidadeCedulas > 0)
				System.out.println("Quantidade de cedulas de "+ cedulas[i] +
				": " + quantidadeCedulas );
			//Resto da divisao
			valorReais %= cedulas[i];
			//Quantidade total de cedulas entregues ao cliente
			quantidadeTotal += quantidadeCedulas;
		}
		//Impressao
		System.out.println("Quantidade total: " + quantidadeTotal);
	}
}
