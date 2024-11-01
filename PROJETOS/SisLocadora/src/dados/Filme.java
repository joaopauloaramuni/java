/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dados;
import java.sql.Date;
/**
 *
 * @author JP
 */
public class Filme {
	private int codigo;
	private String nomeBrasil;
        private String nomeOriginal;
        private int ano;
        private String genero;
        private String ator;
	private float pontos;
        private int votos;
        private String resumo;
        private int tempo;
        private int estoque;
        private int emprestado;
        private double valor;
        private Date data;

        /**
         * Método construtor da Classe Filmes
         * @param codigo
         * @param nomeBrasil
         * @param nomeOriginal
         * @param ano
         * @param genero
         * @param ator
         * @param pontos
         * @param votos
         * @param resumo
         * @param tempo
         * @param estoque
         * @param emprestado
         * @param valor
         * @param data
         */
    public Filme(int codigo, String nomeBrasil, String nomeOriginal, int ano, String genero, String ator, float pontos, int votos, String resumo, int tempo, int estoque, int emprestado, double valor, Date data) {
        this.codigo = codigo;
        this.nomeBrasil = nomeBrasil;
        this.nomeOriginal = nomeOriginal;
        this.ano = ano;
        this.genero = genero;
        this.ator = ator;
        this.pontos = pontos;
        this.votos = votos;
        this.resumo = resumo;
        this.tempo = tempo;
        this.estoque = estoque;
        this.emprestado = emprestado;
        this.valor = valor;
        this.data = data;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getAtor() {
        return ator;
    }

    public void setAtor(String ator) {
        this.ator = ator;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getEmprestado() {
        return emprestado;
    }

    public void setEmprestado(int emprestado) {
        this.emprestado = emprestado;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNomeBrasil() {
        return nomeBrasil;
    }

    public void setNomeBrasil(String nomeBrasil) {
        this.nomeBrasil = nomeBrasil;
    }

    public String getNomeOriginal() {
        return nomeOriginal;
    }

    public void setNomeOriginal(String nomeOriginal) {
        this.nomeOriginal = nomeOriginal;
    }

    public float getPontos() {
        return pontos;
    }

    public void setPontos(float pontos) {
        this.pontos = pontos;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }
        @Override
	public String toString() {
		return
		  "Código          : " + codigo + "\n" +
		  "Nome no Brasil  : " + nomeBrasil + "\n" +
		  "Nome Original   : " + nomeOriginal + "\n" +
                  "Ano             : " + ano + "\n" +
                  "Gênero          : " + genero + "\n" +
                  "Ator Principal  : " + ator + "\n" +
                  "Pontos IMDB     : " + pontos + "\n" +
                  "Votos IMDB      : " + votos + "\n" +
                  "Resuno IMDB     : " + resumo + "\n" +
                  "Tempo de Filme  : " + tempo + "\n" +
                  "Estoque         : " + estoque + "\n" +
                  "Emprestados     : " + emprestado + "\n" +
                  "Valor da Diária : " + valor + "\n" +
                  "Data            : " + data + "\n";
	}

}
