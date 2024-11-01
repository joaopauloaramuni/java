package clubemodelo;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Vector;

import utilitarios.LtpLib;

@SuppressWarnings("serial")
public class Socio implements Serializable{
	// Atributos
	private int codigo;
	private String cpf;
	private String nome;
	private String endereco;
	private GregorianCalendar dataEntrada;
	private GregorianCalendar dataSaida;
	private Vector<Dependente> listaDependentes = new Vector<Dependente>();
	/**
	 * @param codigo
	 * @param cpf
	 * @param nome
	 * @param endereco
	 * @param dataEntrada
	 * @param listaDependentes
	 */
	public Socio(int codigo, String cpf, String nome, String endereco,
			GregorianCalendar dataEntrada, Vector<Dependente> listaDependentes) {
		this.codigo = codigo;
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.dataEntrada = dataEntrada;
		this.listaDependentes = listaDependentes;
	}
	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}
	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	/**
	 * @return the dataEntrada
	 */
	public GregorianCalendar getDataEntrada() {
		return dataEntrada;
	}
	/**
	 * @param dataEntrada the dataEntrada to set
	 */
	public void setDataEntrada(GregorianCalendar dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	/**
	 * @return the dataSaida
	 */
	public GregorianCalendar getDataSaida() {
		return dataSaida;
	}
	/**
	 * @param dataSaida the dataSaida to set
	 */
	public void setDataSaida(GregorianCalendar dataSaida) {
		this.dataSaida = dataSaida;
	}
	/**
	 * @return the listaDependentes
	 */
	public Vector<Dependente> getListaDependentes() {
		return listaDependentes;
	}
	/**
	 * @param listaDependentes the listaDependentes to set
	 */
	public void setListaDependentes(Vector<Dependente> listaDependentes) {
		this.listaDependentes = listaDependentes;
	}
	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}
	public String toString(){
		return 
			"Código   : " + codigo + "\n" +
			"CPF      : " + LtpLib.formatarCPF(cpf) + "\n" +
			"Nome     : " + nome + "\n" +
			"Endereço : " + endereco + "\n" +
			"Entrada  : " + LtpLib.formatarData(dataEntrada, "dd/MM/YYYY") + "\n" +
			"Saída    : " + (dataSaida==null ? "" :
							 LtpLib.formatarData(dataSaida, "dd/MM/yyyy")) + "\n";
	}
	
	/**
	 * Incluir dependente
	 * @param objDep
	 * @throws Exception "O Dependente já está cadastrado"
	 */
	public void incluirDependente(Dependente objDep) throws Exception {
		for (Dependente objDepCad : listaDependentes) {
			if (objDepCad.getNome().equalsIgnoreCase(objDep.getNome())){
				throw new Exception("O Dependente já está cadastrado");
			}
		}
		listaDependentes.add(objDep);
	}
	/**
	 * Excluir dependente
	 * @param objDep
	 */
	public void excluirDependente(Dependente objDep) {
		listaDependentes.remove(objDep);
	}
}












