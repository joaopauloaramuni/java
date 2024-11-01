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
public class Locacao {
    private int codigoCab;
    private int codigoCliente;
    private Date dataLocacao;
    private Date dataDevolucao;
    private int codigoDet;
    private int codigoFilme;
    private Double valor;

    public Locacao(int codigoCab, int codigoCliente, Date dataLocacao, Date dataDevolucao, int codigoDet, int codigoFilme, Double valor) {
        this.codigoCab = codigoCab;
        this.codigoCliente = codigoCliente;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.codigoDet = codigoDet;
        this.codigoFilme = codigoFilme;
        this.valor = valor;
    }

    public int getCodigoCab() {
        return codigoCab;
    }

    public void setCodigoCab(int codigoCab) {
        this.codigoCab = codigoCab;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoDet() {
        return codigoDet;
    }

    public void setCodigoDet(int codigoDet) {
        this.codigoDet = codigoDet;
    }

    public int getCodigoFilme() {
        return codigoFilme;
    }

    public void setCodigoFilme(int codigoFilme) {
        this.codigoFilme = codigoFilme;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Date getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(Date dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Código Locação Cab.  : " + codigoCab + "\n"
                + "Código do Cliente : " + codigoCliente + "\n"
                + "Data de Locação   : " + dataLocacao + "\n"
                + "Data de Devolução : " + dataDevolucao + "\n"
                + "Código Locação Det. : " + codigoDet + "\n"
                + "Código Locação Cab. : " + codigoCab + "\n"
                + "Código do Filme     : " + codigoFilme + "\n"
                + "Valor               : " + valor + "\n";
    }
}
