package modelo;

import java.io.Serializable;
import java.util.Vector;

import erros.SisSPCException;

import utilitarios.LtpLib;

public class Devedor implements Serializable{
	
	private String cpf;
	private String nome;
	
	private Vector<Divida> listaDividas = new Vector<Divida>();
	
	public Devedor(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Vector<Divida> getListaDividas() {
		return listaDividas;
	}
	public void setListaDividas(Vector<Divida> listaDividas) {
		this.listaDividas = listaDividas;
	}
	public String toString() {
		return
			"CPF : " + LtpLib.formatarCPF(cpf) + "\n" +
			"Nome : " + nome + "\n";
	}
	
	public void incluirDivida(Divida objDiv) throws SisSPCException {
		for (Divida obj : listaDividas) {
			if (objDiv.getEmpresa().getCnpj().equals(obj.getEmpresa().getCnpj()) &&
				objDiv.getCodDividaEmpresa().equals(obj.getCodDividaEmpresa())) {
				throw new SisSPCException("Divida já existe no cadastro");
			}
		}
		listaDividas.add(objDiv);
	}
	
	public void excluirDivida(Divida objDiv){
		listaDividas.remove(objDiv);
	}
	
	public Divida consDivida(Estabelecimento empresa, String doc) throws SisSPCException {
		
		for (Divida obj : listaDividas) {
			if (empresa.getCnpj().equals(obj.getEmpresa().getCnpj()) &&
				doc.equals(obj.getCodDividaEmpresa())) {
				return obj;
			}
		}		
		throw new SisSPCException("Divida não existe no cadastro");
	}
	
}






