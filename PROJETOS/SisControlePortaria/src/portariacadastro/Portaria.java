/**
 *
 */
package portariacadastro;

import java.util.GregorianCalendar;
import java.util.Vector;

import portariamodelo.Visitante;

import utilitarios.LtpLib;



/**
 * Controlar o cadastro de visitantes
 *
 */
public class Portaria {
// Atributos
	private Vector<Visitante> listaVisitantes = new Vector<Visitante>();
// Métodos
	/**
	 * @return Returns the listaVisitantes.
	 */
	public Vector<Visitante> getListaVisitantes() {
		return listaVisitantes;
	}

	/**
	 * @param listaVisitantes The listaVisitantes to set.
	 */
	public void setListaVisitantes(Vector<Visitante> listaVisitantes) {
		this.listaVisitantes = listaVisitantes;
	}

	/**
	 * Método incluirVisitante
	 * @param visitante
	 * @throws Exception "Visitante já está no estabelecimento"
	 */
	public void incluirVisitante(Visitante visitante) throws Exception {
		// Visitante está na lista de visitantes?
		for ( Visitante vis : listaVisitantes){
			if (vis.equals(visitante) &&
				vis.getSaida() == null ) {
				throw new Exception("O visitante " + vis.getNome() + " já está cadastrado com o código = " + vis.getCodVisitante() + "\n" +
						            "Entrada no estabelecimento : " + LtpLib.formatarData(vis.getEntrada(),"dd/MM/yyyy hh:mm"));
			}
		}
		listaVisitantes.add(visitante);
	}
	/**
	 * Método excluirVisitante
	 * @param objVis
	 * 
	 */
	public void excluirVisitante(Visitante objVis) {
		listaVisitantes.remove(objVis);
	}
	/**
	 * Método encerrarVisitante
	 * @param objVis
	 * @throws Exception "Visitante já saiu do estabelecimento" 
	 */
	public void encerrarVisitante(Visitante objVis) throws Exception {

		if ( objVis.getSaida()==null ) {
			objVis.setSaida(new GregorianCalendar());
		} else throw new Exception("Já existe registro de saída para a visita.");

	}
	/**
	 * COnsultar Visitante pelo codigo
	 * @param codigo
	 * @return objeto Visitante
	 * @throws Exception "Não existe visitante para o codigo informado"
	 */
	public Visitante consultarVisitaCodigo( int codigo ) throws Exception {
		for ( Visitante vis : listaVisitantes ){
			if ( vis.getCodVisitante()==codigo) {
				return vis;
			}
		}
		throw new Exception ("Não existe visitante para o código informado.");
	}
	/**
	 * Consultar visitantes pelo nome
	 * @param nome
	 * @return lista de visitantes
	 * @throws Exception "Não existe visita para o nome informado."
	 */
	public Vector<Visitante> consultarVisitasNome( String nome ) throws Exception {
		Vector<Visitante> consNome = new Vector<Visitante>();
		for ( Visitante vis : listaVisitantes ){
			if ( vis.getNome().toUpperCase().indexOf(nome.toUpperCase()) != -1 ) {
				consNome.add(vis);
			}
		}
		if ( consNome.isEmpty() )
			 throw new Exception("Não existe visita para o nome informado.");
		else return consNome;
	}
	/**
	 * Consultar visitantes pelo período
	 * @param nome
	 * @return lista de visitantes
	 * @throws Exception "Não existe visita no estabelecimento para o período informado."
	 */	
	public Vector<Visitante> consultarVisitasPeriodo( GregorianCalendar dtInicio, GregorianCalendar dtFim) throws Exception {
		Vector<Visitante> consPeriodo = new Vector<Visitante>();
		for ( Visitante vis : listaVisitantes ){
			if ((vis.getEntrada().compareTo(dtInicio)>=0) && (vis.getEntrada().compareTo(dtFim)<=0)) {
				consPeriodo.add(vis);
			}
		}
		if ( consPeriodo.isEmpty() )
			 throw new Exception("Não existe visita no estabelecimento para o período informado.");
		else return consPeriodo;
	}
	/**
	 * Consultar visitantes dentro do estabelecimento
	 * @param nome
	 * @return lista de visitantes
	 * @throws Exception "Não existe visita em aberto no estabelecimento."
	 */		
	public Vector<Visitante> consultarVisitasNoEstabelec() throws Exception {
		Vector<Visitante> consVisitasEstab = new Vector<Visitante>();
		for ( Visitante vis : listaVisitantes ){
			if (vis.getSaida()==null) consVisitasEstab.add(vis);
		}
		if ( consVisitasEstab.isEmpty() )
			 throw new Exception("Não existe visita em aberto no estabelecimento.");
		else return consVisitasEstab;
	}
}
