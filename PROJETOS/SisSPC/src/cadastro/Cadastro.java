package cadastro;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Vector;

import erros.SisSPCException;

import modelo.Devedor;
import modelo.Divida;
import modelo.Estabelecimento;

public class Cadastro {
	
	private Vector<Estabelecimento> listaEmpresas = new Vector<Estabelecimento>();
	private HashMap<String, Devedor> listaDevedores = new HashMap<String, Devedor>();
	
	public Vector<Estabelecimento> getListaEmpresas() {
		return listaEmpresas;
	}
	public void setListaEmpresas(Vector<Estabelecimento> listaEmpresas) {
		this.listaEmpresas = listaEmpresas;
	}
	public HashMap<String, Devedor> getListaDevedores() {
		return listaDevedores;
	}
	public void setListaDevedores(HashMap<String, Devedor> listaDevedores) {
		this.listaDevedores = listaDevedores;
	}
	
	/**
	 * Cadastrar Empresa
	 * @param objEmp
	 * @throws SisSPCException "CNPJ já Existe"
	 */
	public void addEmpresa(Estabelecimento objEmp) throws SisSPCException{
		for (Estabelecimento obj : listaEmpresas) {
			if (obj.getCnpj().equals(objEmp.getCnpj())) {
				throw new SisSPCException("CNPJ já existe.");
			}
		}
		listaEmpresas.add(objEmp);
	}
	
	/**
	 * Consultar a empresa pelo cnpj
	 * @param cnpj
	 * @return
	 * @throws SisSPCException "Não existe empresa para o cnpj"
	 */
	public Estabelecimento consultarEmpCnpj(String cnpj) throws SisSPCException {
		for (Estabelecimento obj : listaEmpresas) {
			if (obj.getCnpj().equals(cnpj)) return obj;
		}
		throw new SisSPCException("Não existe empresa para o cnpj");
	}
	
	/**
	 * Excluir Empresa
	 * @param cnpj
	 * @throws SisSPCException "Não existe empresa para o CNPJ"
	 */
	public void excluirEmpresa(String cnpj) throws SisSPCException {
		for (Estabelecimento obj : listaEmpresas) {
			if (obj.getCnpj().equals(cnpj)) {
				excluirDividasEmpresa(obj);
				listaEmpresas.remove(obj);
				return;
			}
		}
		throw new SisSPCException("Não existe empresa para o CNPJ.");
	}
	
	/**
	 * Excluir as dividas da Empresa
	 * @param objEmp
	 */
	private void excluirDividasEmpresa(Estabelecimento objEmp) {
		Vector<String> listaCPFExclusao = new Vector<String>();
		for (Devedor objDev : listaDevedores.values()) {
			for (Divida objDiv : objDev.getListaDividas()) {
				if (objDiv.getEmpresa()==objEmp) {
					objDev.excluirDivida(objDiv);
					if (objDev.getListaDividas().isEmpty()) {
						listaCPFExclusao.add(objDev.getCpf());
						break;
					}
				}
			}
		}
		
		for (String cpf : listaCPFExclusao) {
			listaDevedores.remove(cpf); // REMOVER OBJETO VIA CHAVE DA LISTA HashMap
		}
		
	}
	
	/**
	 * Lista de empresas pelo nome em ordem alfabética
	 * @param nome
	 * @return
	 * @throws SisSPCException
	 */
	public Vector<Estabelecimento> listaEmpresaNome(String nome) throws SisSPCException{
		Vector<Estabelecimento> resp = new Vector<Estabelecimento>();
		for (Estabelecimento obj : listaEmpresas) {
			if (obj.getNomeEmpresa().toUpperCase().indexOf(nome.toUpperCase())!=-1) {
				resp.add(obj);
			}
		}
		if (resp.isEmpty()) {
			throw new SisSPCException("Não existe empresa para o nome.");
		} else {
			Collections.sort(resp, new Comparator<Estabelecimento>() {

				@Override
				public int compare(Estabelecimento o1, Estabelecimento o2) {
					return o1.getNomeEmpresa().compareTo(o2.getNomeEmpresa());
				}
			});
			return resp;
		}
	}
	
	/**
	 * Consultar a lista de devedores pelo CPF
	 * @param cpf
	 * @return
	 * @throws SisSPCException  "Nada Consta."
	 */
	public Devedor consultarSpcCpf(String cpf) throws SisSPCException {
		if (listaDevedores.containsKey(cpf)) {
			return listaDevedores.get(cpf);
		} else {
			throw new SisSPCException("Nada Consta.");
		}
	}
	
	/**
	 * Consultar a lista de devedores pelo nome com resposta em ordem alfabética
	 * @param nome
	 * @return
	 * @throws SisSPCException
	 */
	public Vector<Devedor> consultarSpcNome(String nome) throws SisSPCException {
		Vector<Devedor> resp = new Vector<Devedor>();
		for (Devedor obj : listaDevedores.values()) {
			if (obj.getNome().toUpperCase().indexOf(nome.toUpperCase())!=-1) {
				resp.add(obj);
			}
		}
		if (resp.isEmpty()) {
			throw new SisSPCException("Não existe devedor para o nome.");
		} else {
			Collections.sort(resp, new Comparator<Devedor>() {

				@Override
				public int compare(Devedor o1, Devedor o2) {
					return o1.getNome().compareTo(o2.getNome());
				}
			});
			return resp;
		}
	}
	
	/**
	 * Incluir devedor/Divida no SPC
	 * @param objDev
	 * @param objDiv
	 * @throws SisSPCException "Divida já cadastrada"
	 */
	public void addSpc(Devedor objDev, Divida objDiv) throws SisSPCException {
		if ( listaDevedores.containsKey(objDev.getCpf())) {
			objDev.incluirDivida(objDiv);	
		} else {
			listaDevedores.put(objDev.getCpf(), objDev);
			objDev.incluirDivida(objDiv);
		}
	}
	
	/**
	 * Excluir Divida/Devedor do SPC
	 * @param objDev
	 * @param objDiv
	 * @throws SisSPCException
	 */
	public void excluirSpc(Devedor objDev, Divida objDiv) throws SisSPCException {
		objDev.excluirDivida(objDiv);
		if (objDev.getListaDividas().isEmpty()) listaDevedores.remove(objDev.getCpf());
	}
	
	/**
	 * Converter a lista de devedores de HashMap para Vector
	 * @return Vector<Devedor>
	 */
	public Vector<Devedor> convHashMapVector() {
		Vector<Devedor> devedores = new Vector<Devedor>();
		for (Devedor obj : listaDevedores.values()) {
			devedores.add(obj);
		}
		return devedores;
	}
	
	/**
	 * Converter a lista de devedores de Vector para HashMap
	 * @param devedores
	 * @return HashMap<String, Devedor>
	 */
	public HashMap<String, Devedor> convVectorHashMap(Vector<Devedor> devedores) {
		HashMap<String, Devedor> listaDev = new HashMap<String, Devedor>();
		for (Devedor obj : devedores) {
			listaDev.put(obj.getCpf(), obj);
		}
		return listaDev;
	}
	
}






