/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locnegocio;

import bdlocadora.BDLocadora;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import dados.*;
import javax.swing.JTable;
import java.sql.Date;

/**
 *
 * @author JP
 */
public class LocNegocio {

    /**
     * Classe LocNegocio - com os m�todos que tratam das regras do n�gocio e intera��o com as classes de entidade (Cliente),(Filmes) e Banco de Dados (BDLocadora).
     * @author  JP
     */
    // Atributos
    private BDLocadora bdloc = new BDLocadora();

    /**
     * M�todo para alterar cliente no banco de dados
     * @param objeto da Classe Cliente
     * @throws SQLException
     */
    public void alterarCliente(Cliente objCliente) throws SQLException {
        bdloc.alterarCliente(objCliente);
    }

    /**
     * M�todo para alterar filme no banco de dados
     * @param objeto da Classe Filmes
     * @throws SQLException
     */
    public void alterarFilme(Filme objFilme) throws SQLException {
        bdloc.alterarFilme(objFilme);
    }

     /**
     * M�todo para alterar loca��o no banco de dados
     * @param objetos das Classes LocacaoCab e LocacaoDet
     * @throws SQLException
     */
    public void alterarLocacao(Locacao objLoc) throws SQLException {
        bdloc.alterarLocacao(objLoc);
    }

    /**
     * M�todo para adicionar cliente no banco de dados
     * @param objeto da Classe Cliente
     * @throws SQLException
     */
    public void adicionarCliente(Cliente objCliente) throws SQLException {
        bdloc.adicionarCliente(objCliente);
    }

    /**
     * M�todo para adicionar filme no banco de dados
     * @param objeto da Classe Filmes
     * @throws SQLException
     */
    public void adicionarFilme(Filme objFilme) throws SQLException {
        bdloc.adicionarFilme(objFilme);
    }

     /**
     * M�todo para adicionar loca��o no banco de dados
     * @param objeto das Classe Locacao
     * @throws SQLException
     */
    public void adicionarLocacao(Locacao objLoc) throws SQLException {
        bdloc.adicionarLocacao(objLoc);
    }


    /**
     * M�todo para excluir um cliente via c�digo no Banco de Dados
     * @param codigo
     * @throws SQLException
     */
    public void excluirCliente(int codigo) throws SQLException {
        bdloc.excluirCliente(codigo);
    }

    /**
     * M�todo para excluir um filme via c�digo no Banco de Dados
     * @param codigo
     * @throws SQLException
     */
    public void excluirFilme(int codigo) throws SQLException {
        bdloc.excluirFilme(codigo);
    }

     /**
     * M�todo para excluir uma loca��o via c�digo no Banco de Dados
     * @param codigo
     * @throws SQLException
     */
    public void excluirLocacao(int codigo) throws SQLException {
        bdloc.excluirLocacao(codigo);
    }

    /**
     * M�todo para converter um Objeto ResultSet para um Objeto da Classe Cliente
     * @param objeto ResultSet
     * @return Objeto da Classe Cliente
     * @throws SQLException
     */
    private Cliente rsCliToObjCli(ResultSet rsCli) throws SQLException {
        return new Cliente(rsCli.getInt("COD_CLIENTE"),
                rsCli.getString("NOME_CLIENTE"),
                rsCli.getString("CPF"),
                rsCli.getString("TELEFONE"),
                rsCli.getString("EMAIL"),
                rsCli.getDate("DATA_CLIENTE"));
    }

    /**
     * M�todo para converter um Objeto ResultSet para um Objeto da Classe Filme
     * @param objeto ResultSet
     * @return Objeto da Classe Filme
     * @throws SQLException
     */
    private Filme rsFilToObjFil(ResultSet rsFil) throws SQLException {
        return new Filme(rsFil.getInt("CHAVE_TAB"),
                rsFil.getString("NOME_BRASIL"),
                rsFil.getString("NOME_ORIGINAL"),
                rsFil.getInt("ANO"),
                rsFil.getString("GENERO_PRINCIPAL"),
                rsFil.getString("ATOR_PRINCIPAL"),
                rsFil.getFloat("PONTUACAO_IMDB"),
                rsFil.getInt("QTE_VOTOS_IMDB"),
                rsFil.getString("RESUMO_IMDB"),
                rsFil.getInt("TEMPO_FILME"),
                rsFil.getInt("QUAN_MIDIAS"),
                rsFil.getInt("QUANT_EMP"),
                rsFil.getDouble("VALOR_DIARIA"),
                rsFil.getDate("DATA_FILME"));
    }

     /**
     * M�todo para converter um Objeto ResultSet em Locacao
     * @param objeto ResultSet
     * @return Objeto da Classe Locacao
     * @throws SQLException
     */
    private Locacao rsLocToObjLoc(ResultSet rsFil) throws SQLException {
        return new Locacao(rsFil.getInt("COD_LOC_CAB"),
                rsFil.getInt("COD_CLIENTE"),
                rsFil.getDate("DATA_LOC"),
                rsFil.getDate("DATA_DEVOLUCAO"),
                rsFil.getInt("COD_LOC_DET"),
                rsFil.getInt("COD_FILME"),
                rsFil.getDouble("VALOR"));
    }

    /**
     * M�todo para buscar o cliente no banco via c�digo
     * @param codigo
     * @return Objeto da Classe Cliente
     * @throws SQLException
     */
    public Cliente buscarClientePorCodigo(int codigo) throws SQLException {
        ResultSet rs = bdloc.buscarClientePorCodigo(codigo);
        rs.next();
        return rsCliToObjCli(rs);
    }

    /**
     * M�todo para buscar o filme no banco via c�digo
     * @param codigo
     * @return Objeto da Classe Filme
     * @throws SQLException
     */
    public Filme buscarFilmePorCodigo(int codigo) throws SQLException {
        ResultSet rs = bdloc.buscarFilmePorCodigo(codigo);
        rs.next();
        return rsFilToObjFil(rs);
    }

     /**
     * M�todo para buscar a Locacao no banco via c�digo
     * @param codigo
     * @return Objeto da Classe Locacao
     * @throws SQLException
     */
    public Locacao buscarLocacaoPorCodigo(int codigo) throws SQLException {
        ResultSet rs = bdloc.buscarLocacaoPorCodigo(codigo);
        rs.next();
        return rsLocToObjLoc(rs);
    }

    /**
     * M�todo para buscar o primeiro cliente no banco
     * @return Objeto da Classe Cliente
     * @throws SQLException
     */
    public Cliente buscarClientePrimeiro() throws SQLException {
        ResultSet rs = bdloc.buscarClientePrimeiro();
        rs.next();
        return rsCliToObjCli(rs);

    }

    /**
     * M�todo para buscar o primeiro filme no banco
     * @return Objeto da Classe Filme
     * @throws SQLException
     */
    public Filme buscarFilmePrimeiro() throws SQLException {
        ResultSet rs = bdloc.buscarFilmePrimeiro();
        rs.next();
        return rsFilToObjFil(rs);

    }

     /**
     * M�todo para buscar a primeira Locacao no banco
     * @return Objeto da Classe Locacao
     * @throws SQLException
     */
    public Locacao buscarLocacaoPrimeiro() throws SQLException {
        ResultSet rs = bdloc.buscarLocacaoPrimeiro();
        rs.next();
        return rsLocToObjLoc(rs);

    }

    /**
     * M�todo para buscar o proximo cliente no banco via c�digo
     * @param codigo
     * @return Objeto da Classe Cliente
     * @throws SQLException
     */
    public Cliente buscarClienteProximo(int codigo) throws SQLException {
        ResultSet rs = bdloc.buscarClienteProximo(codigo);
        rs.next();
        return rsCliToObjCli(rs);

    }

    /**
     * M�todo para buscar o proximo filme no banco via c�digo
     * @param codigo
     * @return Objeto da Classe Filme
     * @throws SQLException
     */
    public Filme buscarFilmeProximo(int codigo) throws SQLException {
        ResultSet rs = bdloc.buscarFilmeProximo(codigo);
        rs.next();
        return rsFilToObjFil(rs);
    }

     /**
     * M�todo para buscar a proxima Locacao no banco via c�digo
     * @param codigo
     * @return Objeto da Classe Locacao
     * @throws SQLException
     */
    public Locacao buscarLocacaoProximo(int codigo) throws SQLException {
        ResultSet rs = bdloc.buscarLocacaoProximo(codigo);
        rs.next();
        return rsLocToObjLoc(rs);
    }



    /**
     * M�todo para buscar o cliente anterior no banco via c�digo
     * @param codigo
     * @return Objeto da Classe Cliente
     * @throws SQLException
     */
    public Cliente buscarClienteAnterior(int codigo) throws SQLException {
        ResultSet rs = bdloc.buscarClienteAnterior(codigo);
        rs.next();
        return rsCliToObjCli(rs);

    }

    /**
     * M�todo para buscar o cliente anterior no banco via c�digo
     * @param codigo
     * @return Objeto da Classe Cliente
     * @throws SQLException
     */
    public Filme buscarFilmeAnterior(int codigo) throws SQLException {
        ResultSet rs = bdloc.buscarFilmeAnterior(codigo);
        rs.next();
        return rsFilToObjFil(rs);
    }

     /**
     * M�todo para buscar a LocacaoCab anterior no banco via c�digo
     * @param codigo
     * @return Objeto da Classe LocacaoCab
     * @throws SQLException
     */
    public Locacao buscarLocacaoAnterior(int codigo) throws SQLException {
        ResultSet rs = bdloc.buscarLocacaoAnterior(codigo);
        rs.next();
        return rsLocToObjLoc(rs);
    }


    /**
     * M�todo para buscar o �ltimo cliente no banco
     * @return Objeto da Classe Cliente
     * @throws SQLException
     */
    public Cliente buscarClienteUltimo() throws SQLException {
        ResultSet rs = bdloc.buscarClienteUltimo();
        rs.next();
        return rsCliToObjCli(rs);

    }

    /**
     * M�todo para buscar o �ltimo filme no banco
     * @return Objeto da Classe Filme
     * @throws SQLException
     */
    public Filme buscarFilmeUltimo() throws SQLException {
        ResultSet rs = bdloc.buscarFilmeUltimo();
        rs.next();
        return rsFilToObjFil(rs);
    }

     /**
     * M�todo para buscar a �ltima Locacao no banco
     * @return Objeto da Classe Locacao
     * @throws SQLException
     */
    public Locacao buscaLocacaoUltimo() throws SQLException {
        ResultSet rs = bdloc.buscarLocacaoUltimo();
        rs.next();
        return rsLocToObjLoc(rs);
    }

    /**
     * M�todo para buscar todos os clientes em ordem de c�digo
     * @return Conjunto de Objetos da Classe Cliente via Classe Vector
     * @throws SQLException
     */
    public Vector<Cliente> buscarTodosClientes() throws SQLException {
        ResultSet rs = bdloc.buscarTodosClientes();
        Vector<Cliente> clientes = new Vector<Cliente>();
        Cliente cli = null;
        while (rs.next()) {
            cli = rsCliToObjCli(rs);
            clientes.add(cli);
        }
        return clientes;
    }

    /**
     * M�todo para buscar todos os filmes em ordem de c�digo
     * @return Conjunto de Objetos da Classe Filme via Classe Vector
     * @throws SQLException
     */
    public Vector<Filme> buscarTodosFilmes() throws SQLException {
        ResultSet rs = bdloc.buscarTodosFilmes();
        Vector<Filme> filmes = new Vector<Filme>();
        Filme fil = null;
        while (rs.next()) {
            fil = rsFilToObjFil(rs);
            filmes.add(fil);
        }
        return filmes;
    }

     /**
     * M�todo para buscar todas as Locacoes em ordem de c�digo
     * @return Conjunto de Objetos da Classe Locacao via Classe Vector
     * @throws SQLException
     */
    public Vector<Locacao> buscarTodosLocacoes() throws SQLException {
        ResultSet rs = bdloc.buscarTodasLocacoes();
        Vector<Locacao> Locacoes = new Vector<Locacao>();
        Locacao loc = null;
        while (rs.next()) {
            loc = rsLocToObjLoc(rs);
            Locacoes.add(loc);
        }
        return Locacoes;
    }

    //M�todo Comum - Buscar Clientes Por Nome
    /*
    public Vector<Cliente> buscarClientesPorNome(String nome) throws SQLException {
    ResultSet rs = bdloc.buscarClientesPorNome(nome);
    Vector<Cliente> clientes = new Vector<Cliente>();
    Cliente cli = null;
    while (rs.next()) {
    cli = rsCliToObjCli(rs);
    clientes.add(cli);
    }
    return clientes;
    }*/
    
    //M�todo JTable - Buscar Clientes Por Nome
    /**
     * M�todo para buscar um conjunto de clientes parametrizado pelo nome
     * @param nome
     * @return Conjunto de Objetos da Classe Cliente via Classe Vector
     * @throws SQLException
     */
    public JTable buscarClientesPorNome(String nome) throws SQLException {
        JTable JT_Clientes = bdloc.buscarClientesPorNome(nome);
        return JT_Clientes;
    }

    //M�todo Comum - Buscar Filmes Por Nome
    /*
    public Vector<Filme> buscarFilmesPorNome(String nome) throws SQLException {
    ResultSet rs = bdloc.buscarFilmesPorNome(nome);
    Vector<Filme> filmes = new Vector<Filme>();
    Filme fil = null;
    while (rs.next()) {
    fil = rsFilToObjFil(rs);
    filmes.add(fil);
    }
    return filmes;
    }
     */
    
    //M�todo JTable - Buscar Filmes Por Nome
    /**
     * M�todo para buscar um conjunto de filmes parametrizado pelo nome
     * @param nome
     * @return JTable
     * @throws SQLException
     */
    public JTable buscarFilmesPorNome(String nome) throws SQLException {

        JTable JT_Filmes = bdloc.buscarFilmesPorNome(nome);
        return JT_Filmes;
    }

    //M�todo JTable - Buscar filmes alugados Por Nome
    /**
     * M�todo para buscar um conjunto de filmes alugados parametrizado pelo nome
     * @param nome
     * @return Conjunto de Objetos da Classe Cliente via Classe Vector
     * @throws SQLException
     */
    public JTable buscarFilmesAlugadosPorNome(String nome) throws SQLException {
        JTable JT_Filmes = bdloc.buscarFilmesAlugadosPorNome(nome);
        return JT_Filmes;
    }

    //M�todo JTable - Buscar Loca��es
    /**
     * M�todo para buscar um conjunto de loca��es
     * @param nome
     * @return JTable
     * @throws SQLException
     */
    public JTable buscarLocacoesPorData() throws SQLException {

        JTable JT_Filmes = bdloc.buscarLocacoesPorData();
        return JT_Filmes;
    }

    /**
     * M�todo para buscar um conjunto de clientes parametrizado pelo per�odo
     * @param per�odo de datas
     * @return Conjunto de Objetos da Classe Cliente
     * @throws SQLException
     */
    public JTable buscarClientesPorPeriodo(String nome,Date data1, Date data2) throws SQLException {
        JTable JT_Clientes = bdloc.buscarClientesPorPeriodo(nome,data1,data2);
        return JT_Clientes;
    }

    /**
     * M�todo para buscar um conjunto de filmes parametrizado pelo per�odo
     * @param per�odo de datas
     * @return Conjunto de Objetos da Classe Filme
     * @throws SQLException
     */
    public JTable buscarFilmesPorPeriodo(Date data1, Date data2) throws SQLException {
        JTable JT_Filmes = bdloc.buscarFilmesPorPeriodo(data1,data2);
        return JT_Filmes;
    }

      /**
     * M�todo para buscar total geral de loca��es e total do valor
     * @param per�odo de datas
     * @return Objeto ResultSet
     * @throws SQLException
     */
     public ResultSet buscarTotalLocacao(Date data1, Date data2) throws SQLException {
        ResultSet rs_tot = bdloc.buscarTotalLocacao(data1,data2);
        rs_tot.next();
        return rs_tot;
     }
}
