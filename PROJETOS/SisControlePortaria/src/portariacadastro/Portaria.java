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
// M�todos
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
	 * M�todo incluirVisitante
	 * @param visitante
	 * @throws Exception "Visitante j� est� no estabelecimento"
	 */
	public void incluirVisitante(Visitante visitante) throws Exception {
		// Visitante est� na lista de visitantes?
		for ( Visitante vis : listaVisitantes){
			if (vis.equals(visitante) &&
				vis.getSaida() == null ) {
				throw new Exception("O visitante " + vis.getNome() + " j� est� cadastrado com o c�digo = " + vis.getCodVisitante() + "\n" +
						            "Entrada no estabelecimento : " + LtpLib.formatarData(vis.getEntrada(),"dd/MM/yyyy hh:mm"));
			}
		}
		listaVisitantes.add(visitante);
	}
	/**
	 * M�todo excluirVisitante
	 * @param objVis
	 * 
	 */
	public void excluirVisitante(Visitante objVis) {
		listaVisitantes.remove(objVis);
	}
	/**
	 * M�todo encerrarVisitante
	 * @param objVis
	 * @throws Exception "Visitante j� saiu do estabelecimento" 
	 */
	public void encerrarVisitante(Visitante objVis) throws Exception {

		if ( objVis.getSaida()==null ) {
			objVis.setSaida(new GregorianCalendar());
		} else throw new Exception("J� existe registro de sa�da para a visita.");

	}
	/**
	 * COnsultar Visitante pelo codigo
	 * @param codigo
	 * @return objeto Visitante
	 * @throws Exception "N�o existe visitante para o codigo informado"
	 */
	public Visitante consultarVisitaCodigo( int codigo ) throws Exception {
		for ( Visitante vis : listaVisitantes ){
			if ( vis.getCodVisitante()==codigo) {
				return vis;
			}
		}
		throw new Exception ("N�o existe visitante para o c�digo informado.");
	}
	/**
	 * Consultar visitantes pelo nome
	 * @param nome
	 * @return lista de visitantes
	 * @throws Exception "N�o existe visita para o nome informado."
	 */
	public Vector<Visitante> consultarVisitasNome( String nome ) throws Exception {
		Vector<Visitante> consNome = new Vector<Visitante>();
		for ( Visitante vis : listaVisitantes ){
			if ( vis.getNome().toUpperCase().indexOf(nome.toUpperCase()) != -1 ) {
				consNome.add(vis);
			}
		}
		if ( consNome.isEmpty() )
			 throw new Exception("N�o existe visita para o nome informado.");
		else return consNome;
	}
	/**
	 * Consultar visitantes pelo per�odo
	 * @param nome
	 * @return lista de visitantes
	 * @throws Exception "N�o existe visita no estabelecimento para o per�odo informado."
	 */	
	public Vector<Visitante> consultarVisitasPeriodo( GregorianCalendar dtInicio, GregorianCalendar dtFim) throws Exception {
		Vector<Visitante> consPeriodo = new Vector<Visitante>();
		for ( Visitante vis : listaVisitantes ){
			if ((vis.getEntrada().compareTo(dtInicio)>=0) && (vis.getEntrada().compareTo(dtFim)<=0)) {
				consPeriodo.add(vis);
			}
		}
		if ( consPeriodo.isEmpty() )
			 throw new Exception("N�o existe visita no estabelecimento para o per�odo informado.");
		else return consPeriodo;
	}
	/**
	 * Consultar visitantes dentro do estabelecimento
	 * @param nome
	 * @return lista de visitantes
	 * @throws Exception "N�o existe visita em aberto no estabelecimento."
	 */		
	public Vector<Visitante> consultarVisitasNoEstabelec() throws Exception {
		Vector<Visitante> consVisitasEstab = new Vector<Visitante>();
		for ( Visitante vis : listaVisitantes ){
			if (vis.getSaida()==null) consVisitasEstab.add(vis);
		}
		if ( consVisitasEstab.isEmpty() )
			 throw new Exception("N�o existe visita em aberto no estabelecimento.");
		else return consVisitasEstab;
	}
}
