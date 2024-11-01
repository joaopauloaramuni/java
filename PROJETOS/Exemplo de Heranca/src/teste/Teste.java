package teste;

import java.util.GregorianCalendar;
import java.util.Vector;

import utilitarios.Console;

import modelo.Funcionario;
import modelo.Gerente;
import modelo.Pessoa;
import modelo.PessoaFisica;
import modelo.PessoaJuridica;

public class Teste {

	private static Vector<Pessoa> cadPessoas = new Vector<Pessoa>();
	
	public static void main(String[] args) {
		// AMOSTRAS
		cadPessoas.add(new Pessoa("Jose", "2222-2222"));
		cadPessoas.add(new PessoaFisica("Carlos", "3333-3333", "M", "12345", "11111111111"));
		cadPessoas.add(new PessoaJuridica("FUMEC", "4444-4444", "11111111111111", "Fundação de Educação e Cultura"));
		cadPessoas.add(new Funcionario("Maria", "1111-1111", "F", "54321", "22222222222", "123", new GregorianCalendar(2017, 0, 5), 2000));
		cadPessoas.add(new Gerente("Eduardo", "2323-2323", "M", "121212", "44444444444", "4321", new GregorianCalendar(2017,1,1), 12000, (Funcionario)cadPessoas.get(3)));
		listagemGeral();
		listagemPorTipo(Console.readInt("Tipo de Pessoa: "));
		
	}

	private static void listagemPorTipo(int tipo) {
		for (Pessoa objPessoa : cadPessoas) {
			if (objPessoa.getTipo()==tipo) {
				System.out.println(objPessoa.toString());
			}
		}
		
	}

	private static void listagemGeral() {
		for (Pessoa objPessoa : cadPessoas) {
			System.out.println(objPessoa.toString()); // POLIMORFISMO
		}
		
	}

}
