package portariamodelo;

import java.io.Serializable;
import java.util.GregorianCalendar;
import utilitarios.LtpLib;

/**
 * Definir os dados registrados para os visitantes
 *
 */
public class Visitante implements Serializable{


		// Atributos
		private  int codVisitante ;
		private String nome;
		private String cpf;
		private String local;
		private String contato;
		private GregorianCalendar entrada;
		private GregorianCalendar saida;
		// Construtor
		public Visitante(int codVisitante, String nome, String cpf, String local, String contato,GregorianCalendar entrada,GregorianCalendar saida) {
			this.codVisitante = codVisitante;
			this.nome = nome;
			this.cpf = cpf;
			this.local = local;
			this.contato = contato;
			this.entrada = entrada;
			this.saida = saida;
		}
		// get e set´s
		public String getContato() {
			return contato;
		}
		public void setContato(String contato) {
			this.contato = contato;
		}
		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		public GregorianCalendar getEntrada() {
			return entrada;
		}
		public void setEntrada(GregorianCalendar entrada) {
			this.entrada = entrada;
		}
		public String getLocal() {
			return local;
		}
		public void setLocal(String local) {
			this.local = local;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public GregorianCalendar getSaida() {
			return saida;
		}
		public void setSaida(GregorianCalendar saida) {
			this.saida = saida;
		}
		public int getCodVisitante() {
			return codVisitante;
		}
		// metodo toString
		public String toString() {
					return          "-----------" + "\n" +
					                "Código   : " + codVisitante + "\n" +
					                "Nome     : " + nome + "\n" +
					                "CPF      : " + LtpLib.formatarCPF(cpf) + "\n"  +
					                "Local    : " + local + "\n" +
					                "Contato  : " + contato + "\n" +
					                "Entrada  : " + LtpLib.formatarData(entrada, "dd/MM/yyyy HH:mm:ss") + "\n" +
					                "Saida    : " + ( saida == null ? "" : LtpLib.formatarData(saida, "dd/MM/yyyy HH:mm:ss") );
		}
		public Visitante clone() {
			return new Visitante(codVisitante,nome,cpf,local,contato,entrada,saida);
		}
		public boolean equals(Visitante objVisitante) {
			return this.cpf.equals(objVisitante.cpf);
		}

}

