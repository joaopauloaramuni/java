package clubecadastro;

import java.util.GregorianCalendar;
import java.util.Vector;

import utilitarios.LtpLib;

import clubemodelo.Socio;

public class Clube {
	// Atributos
	private Vector<Socio> listaSocios = new Vector<Socio>();

	/**
	 * @return the listaSocios
	 */
	public Vector<Socio> getListaSocios() {
		return listaSocios;
	}

	/**
	 * @param listaSocios the listaSocios to set
	 */
	public void setListaSocios(Vector<Socio> listaSocios) {
		this.listaSocios = listaSocios;
	}
	
	/**
	 * Consultar Socio pelo CPF
	 * @param cpf
	 * @return o socio
	 * @throws Exception "Não existe sócio para o CPF informado"
	 */
	public Socio consultarSocioCpf(String cpf) throws Exception {
		for (Socio objSocioCad : listaSocios) {
			if (objSocioCad.getCpf().equals(cpf)) {
				return objSocioCad;
			}
		}
		throw new Exception("Não existe sócio para o CPF informado");
	}
	/**
	 * Incluir socio
	 * @param objSocio
	 */
	public void incluirSocio(Socio objSocio) {
		listaSocios.add(objSocio);
	}
	/**
	 * Consultar socios pelo nome
	 * @param nome
	 * @return
	 * @throws Exception "Não existe sócio para o nome informado"
	 */
	public Vector<Socio> consultarSocioNome(String nome) throws Exception {
		Vector<Socio> resposta = new Vector<Socio>();
		for (Socio objSocioCad : listaSocios) {
			if (objSocioCad.getNome().toUpperCase().indexOf(nome.toUpperCase())!=-1) {
				resposta.add(objSocioCad);
			}
		}
		if (resposta.isEmpty())
			throw new Exception("Não existe sócio para o nome informado");
		else return resposta;
	}
	/**
	 * Encerrar socio
	 * @param objSocio
	 * @throws Exception "Sócio já foi encerrado em xx/xx/xxxx"
	 */
	public void encerrarSocio(Socio objSocio) throws Exception {
		if (objSocio.getDataSaida()==null) {
			objSocio.setDataSaida(new GregorianCalendar());
		} else {
			throw new Exception("Sócio já foi encerrado em " + 
					LtpLib.formatarData(objSocio.getDataSaida(), "dd/MM/yyyy"));
		}
	}
	
}















