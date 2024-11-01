/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bdlocadora;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.firebirdsql.jdbc.FBDriver;
import dados.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import java.util.Vector;
import java.sql.Date;
import utilitarios.LtpUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 *
 * @author JP
 */
public class BDLocadora {

// Variaveis utilizadas pelos métodos para a consulta e atualização do banco BDLOCADORA.GDB
    public static Connection objCon = null;
    private static PreparedStatement pstm;

    /**
     * Abrir conexão com BDLocadora
     * @throws SQLException
     */
    public static void abrirConexao() throws SQLException {
       DriverManager.registerDriver(new FBDriver());
        objCon = DriverManager.getConnection(
                "jdbc:firebirdsql:localhost:C:/BDLOCADORA.GDB",
                "SYSDBA",
                "masterkey");
    }

    /**
     * Fechar conexão com BDLocadora
     * @throws SQLException
     */
    public static void fecharConexao() throws SQLException {
        objCon.close();
    }

    /**
     * Método para adicionar cliente no banco de dados
     * @param objeto da classe Cliente
     * @throws SQLException
     */
    public void adicionarCliente(Cliente cliente) throws SQLException {
        String queryCod = "SELECT COD_CLIENTE FROM CLIENTES WHERE COD_CLIENTE  = ?";
        pstm = objCon.prepareStatement(queryCod, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        pstm.setInt(1, cliente.getCodigo());
        ResultSet rsCod = pstm.executeQuery();
        if (rsCod.next()) {
            throw new SQLException("Já existe cliente cadastrado com o código: " + rsCod.getString("COD_CLIENTE"));
        }
        String queryCPF = "SELECT CPF FROM CLIENTES WHERE (COD_CLIENTE <> ? AND CPF = ?)";
        pstm = objCon.prepareStatement(queryCPF, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        pstm.setInt(1, cliente.getCodigo());
        pstm.setString(2, cliente.getCpf());
        ResultSet rsCPF = pstm.executeQuery();
        if (rsCPF.next()) {
            throw new SQLException("Já existe cliente cadastrado com o CPF: " + rsCPF.getString("CPF"));
        }
        String atualizaSQL = "Insert INTO CLIENTES (COD_CLIENTE,NOME_CLIENTE,CPF,TELEFONE ,EMAIL,DATA_CLIENTE ) VALUES (?,?,?,?,?,?)";
        pstm = objCon.prepareStatement(atualizaSQL);
        pstm.setInt(1, cliente.getCodigo());
        pstm.setString(2, cliente.getNome());
        pstm.setString(3, cliente.getCpf());
        pstm.setString(4, cliente.getTelefone());
        pstm.setString(5, cliente.getEmail());
        pstm.setDate(6, cliente.getData());
        pstm.executeUpdate();
    }

    /**
     * Método para adicionar filme no banco de dados
     * @param objeto da classe Filme
     * @throws SQLException
     */
    public void adicionarFilme(Filme filme) throws SQLException {
        String queryCod = "SELECT CHAVE_TAB FROM FILMES WHERE CHAVE_TAB = ?";
        pstm = objCon.prepareStatement(queryCod, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        pstm.setInt(1, filme.getCodigo());
        ResultSet rsCod = pstm.executeQuery();
        if (rsCod.next()) {
            throw new SQLException("Já existe filme cadastrado com o código: " + rsCod.getString("CHAVE_TAB"));
        }
        String queryName = "SELECT NOME_ORIGINAL FROM FILMES WHERE (NOME_ORIGINAL = ? AND CHAVE_TAB <> ?)";
        pstm = objCon.prepareStatement(queryName, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        pstm.setString(1, filme.getNomeOriginal());
        pstm.setInt(2, filme.getCodigo());
        ResultSet rsName = pstm.executeQuery();
        if (rsName.next()) {
            throw new SQLException("Já existe filme cadastrado com o nome: " + rsName.getString("NOME_ORIGINAL"));
        }
        String atualizaSQL = "Insert INTO FILMES (CHAVE_TAB,NOME_BRASIL,NOME_ORIGINAL,ANO,GENERO_PRINCIPAL,ATOR_PRINCIPAL,PONTUACAO_IMDB,QTE_VOTOS_IMDB,RESUMO_IMDB,TEMPO_FILME,QUAN_MIDIAS,QUANT_EMP,VALOR_DIARIA,DATA_FILME)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        pstm = objCon.prepareStatement(atualizaSQL);
        pstm.setInt(1, filme.getCodigo());
        pstm.setString(2, filme.getNomeBrasil());
        pstm.setString(3, filme.getNomeOriginal());
        pstm.setInt(4, filme.getAno());
        pstm.setString(5, filme.getGenero());
        pstm.setString(6, filme.getAtor());
        pstm.setFloat(7, filme.getPontos());
        pstm.setInt(8, filme.getVotos());
        pstm.setString(9, filme.getResumo());
        pstm.setInt(10, filme.getTempo());
        pstm.setInt(11, filme.getEstoque());
        pstm.setInt(12, filme.getEmprestado());
        pstm.setDouble(13, filme.getValor());
        pstm.setDate(14, filme.getData());
        pstm.executeUpdate();
    }

    /**
     * Método para adicionar Locacao no banco de dados
     * @param objeto da classe Locacao
     * @throws SQLException
     */
    public void adicionarLocacao(Locacao Loc) throws SQLException {
        String queryCli = "SELECT * FROM CLIENTES";
        pstm = objCon.prepareStatement(queryCli, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rsCli = pstm.executeQuery();
        if (!rsCli.next()) {
            throw new SQLException("Não existe cliente cadastrado.");
        }
        String queryFil = "SELECT * FROM FILMES";
        pstm = objCon.prepareStatement(queryFil, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rsFil = pstm.executeQuery();
        if (!rsFil.next()) {
            throw new SQLException("Não existe filme cadastrado.");
        }
        String queryDet = "SELECT COD_FILME,COD_LOC_CAB FROM LOC_FILMES_DET WHERE COD_FILME = ? AND COD_LOC_CAB = ?";
        pstm = objCon.prepareStatement(queryDet, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        pstm.setInt(1, Loc.getCodigoFilme());
        pstm.setInt(2, Loc.getCodigoDet());
        ResultSet rsDet = pstm.executeQuery();
        if (rsDet.next()) {
            throw new SQLException("Já existe filme cadastrado com o código: " + rsDet.getString("COD_FILME") + " para a locação: " + rsDet.getString("COD_LOC_CAB"));
        }

        String queryCab = "SELECT COD_LOC_CAB FROM LOC_FILMES_CAB WHERE COD_LOC_CAB = ?";
        pstm = objCon.prepareStatement(queryCab, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        pstm.setInt(1, Loc.getCodigoCab());
        ResultSet rsCab = pstm.executeQuery();
        if (rsCab.next()) {
            String atualizaSQL = "UPDATE LOC_FILMES_CAB SET COD_CLIENTE = ?,DATA_LOC = ?,DATA_DEVOLUCAO= ?";
            pstm = objCon.prepareStatement(atualizaSQL);
            pstm.setInt(1, Loc.getCodigoCliente());
            pstm.setDate(2, Loc.getDataLocacao());
            pstm.setDate(3, Loc.getDataDevolucao());
            pstm.executeUpdate();

        } else {
            String atualizaSQL = "Insert INTO LOC_FILMES_CAB (COD_LOC_CAB,COD_CLIENTE,DATA_LOC,DATA_DEVOLUCAO) VALUES (?,?,?,?)";
            pstm = objCon.prepareStatement(atualizaSQL);
            pstm.setInt(1, Loc.getCodigoCab());
            pstm.setInt(2, Loc.getCodigoCliente());
            pstm.setDate(3, Loc.getDataLocacao());
            pstm.setDate(4, Loc.getDataDevolucao());
            pstm.executeUpdate();

        }

        String atualizaSQL = "Insert INTO LOC_FILMES_DET (COD_LOC_DET,COD_LOC_CAB,COD_FILME,VALOR) VALUES (?,?,?,?)";
        pstm = objCon.prepareStatement(atualizaSQL);
        pstm.setInt(1, Loc.getCodigoDet());
        pstm.setInt(2, Loc.getCodigoCab());
        pstm.setInt(3, Loc.getCodigoFilme());
        pstm.setDouble(4, Loc.getValor());
        pstm.executeUpdate();
    }

    /**
     * Método para alterar Cliente no banco de dados
     * @param objeto da classe Cliente
     * @throws SQLException
     */
    public void alterarCliente(Cliente cliente) throws SQLException {
        String query = "SELECT CPF FROM CLIENTES WHERE (COD_CLIENTE <> ? AND CPF = ?)";
        pstm = objCon.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        pstm.setInt(1, cliente.getCodigo());
        pstm.setString(2, cliente.getCpf());
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            throw new SQLException("Já existe cliente cadastrado com o CPF: " + rs.getString("CPF"));
        }
        String atualizaSQL = "UPDATE CLIENTES SET NOME_CLIENTE  = ? , CPF = ?, TELEFONE  =  ? , EMAIL = ?, DATA_CLIENTE = ? WHERE COD_CLIENTE = ?";
        pstm = objCon.prepareStatement(atualizaSQL);
        pstm.setString(1, cliente.getNome());
        pstm.setString(2, cliente.getCpf());
        pstm.setString(3, cliente.getTelefone());
        pstm.setString(4, cliente.getEmail());
        pstm.setDate(5, cliente.getData());
        pstm.setInt(6, cliente.getCodigo());
        pstm.executeUpdate();
    }

    /**
     * Método para alterar Filme no banco de dados
     * @param objeto da classe Filme
     * @throws SQLException
     */
    public void alterarFilme(Filme filme) throws SQLException {
        String query = "SELECT NOME_ORIGINAL FROM FILMES WHERE (NOME_ORIGINAL = ? AND CHAVE_TAB <> ?)";
        pstm = objCon.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        pstm.setString(1, filme.getNomeOriginal());
        pstm.setInt(2, filme.getCodigo());
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            throw new SQLException("Já existe filme cadastrado com o nome: " + rs.getString("NOME_ORIGINAL"));
        }

        String atualizaSQL = "UPDATE FILMES SET NOME_BRASIL = ? ,NOME_ORIGINAL = ? ,ANO = ? ,GENERO_PRINCIPAL = ? ,ATOR_PRINCIPAL = ? ,PONTUACAO_IMDB = ? ,QTE_VOTOS_IMDB = ? ,RESUMO_IMDB = ? ,TEMPO_FILME = ? ,QUAN_MIDIAS = ? ,QUANT_EMP = ? ,VALOR_DIARIA = ? ,DATA_FILME = ? WHERE CHAVE_TAB = ?";
        pstm = objCon.prepareStatement(atualizaSQL);
        pstm.setString(1, filme.getNomeBrasil());
        pstm.setString(2, filme.getNomeOriginal());
        pstm.setInt(3, filme.getAno());
        pstm.setString(4, filme.getGenero());
        pstm.setString(5, filme.getAtor());
        pstm.setFloat(6, filme.getPontos());
        pstm.setInt(7, filme.getVotos());
        pstm.setString(8, filme.getResumo());
        pstm.setInt(9, filme.getTempo());
        pstm.setInt(10, filme.getEstoque());
        pstm.setInt(11, filme.getEmprestado());
        pstm.setDouble(12, filme.getValor());
        pstm.setDate(13, filme.getData());
        pstm.setInt(14, filme.getCodigo());
        pstm.executeUpdate();
    }

    /**
     * Método para alterar locação no banco de dados
     * @param objeto da classe Locacao
     * @throws SQLException
     */
    public void alterarLocacao(Locacao Loc) throws SQLException {

        String queryDet = "SELECT COD_FILME,COD_LOC_CAB FROM LOC_FILMES_DET WHERE COD_FILME = ? AND COD_LOC_CAB = ?";
        pstm = objCon.prepareStatement(queryDet, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        pstm.setInt(1, Loc.getCodigoFilme());
        pstm.setInt(2, Loc.getCodigoDet());
        ResultSet rsDet = pstm.executeQuery();
        if (rsDet.next()) {
            throw new SQLException("Já existe filme cadastrado com o código: " + rsDet.getString("COD_FILME") + " para a locação: " + rsDet.getString("COD_LOC_CAB"));
        }
        String atualizaSQLCab = "UPDATE LOC_FILMES_CAB SET COD_CLIENTE = ?,DATA_LOC = ?,DATA_DEVOLUCAO= ? WHERE COD_LOC_CAB = ?";
        pstm = objCon.prepareStatement(atualizaSQLCab);
        pstm.setInt(1, Loc.getCodigoCliente());
        pstm.setDate(2, Loc.getDataLocacao());
        pstm.setDate(3, Loc.getDataDevolucao());
        pstm.setInt(4, Loc.getCodigoCab());
        pstm.executeUpdate();

        String atualizaSQLDet = "UPDATE LOC_FILMES_DET SET COD_FILME = ?,VALOR = ? WHERE COD_LOC_DET = ?";
        pstm = objCon.prepareStatement(atualizaSQLDet);
        pstm.setInt(1, Loc.getCodigoFilme());
        pstm.setDouble(2, Loc.getValor());
        pstm.setInt(3, Loc.getCodigoDet());
        pstm.executeUpdate();

    }

    /**
     * Método para excluir um cliente via código no Banco de Dados
     * @param codigo
     * @throws SQLException
     */
    public void excluirCliente(int codigo) throws SQLException {
        String consultaSQL = "Select * from LOC_FILMES_CAB where COD_CLIENTE = ?";
        pstm = objCon.prepareStatement(consultaSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        pstm.setInt(1, codigo);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            throw new SQLException("Exclusão negada. Existe locação para esse cliente.");
        }

        String atualizaSQL = "Delete From CLIENTES where COD_CLIENTE = ? ";
        pstm = objCon.prepareStatement(atualizaSQL);
        pstm.setInt(1, codigo);
        pstm.executeUpdate();
    }

    /**
     * Método para excluir um Filme via código no Banco de Dados
     * @param codigo
     * @throws SQLException
     */
    public void excluirFilme(int codigo) throws SQLException {
         String consultaSQL = "Select * from LOC_FILMES_DET where COD_FILME = ?";
        pstm = objCon.prepareStatement(consultaSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        pstm.setInt(1, codigo);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            throw new SQLException("Exclusão negada. Existe locação para esse filme.");
        }

        String atualizaSQL = "Delete From FILMES where CHAVE_TAB = ? ";
        pstm = objCon.prepareStatement(atualizaSQL);
        pstm.setInt(1, codigo);
        pstm.executeUpdate();
    }

    /**
     * Método para excluir uma locacao via código no Banco de Dados
     * @param codigo
     * @throws SQLException
     */
    public void excluirLocacao(int codigo) throws SQLException {
        String atualizaSQLCab = "Delete From LOC_FILMES_CAB where COD_FILMES_CAB = ? ";
        pstm = objCon.prepareStatement(atualizaSQLCab);
        pstm.setInt(1, codigo);
        pstm.executeUpdate();

        String atualizaSQLDet = "Delete From LOC_FILMES_DET where COD_FILMES_CAB = ? ";
        pstm = objCon.prepareStatement(atualizaSQLDet);
        pstm.setInt(1, codigo);
        pstm.executeUpdate();

    }

    /**
     * Método para buscar o cliente no banco via código
     * @param codigo
     * @return Registro de cliente
     * @throws SQLException
     */
    public ResultSet buscarClientePorCodigo(int codigo) throws SQLException {
        String consultaSQL = "Select * from CLIENTES where COD_CLIENTE = ?";
        pstm = objCon.prepareStatement(consultaSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        pstm.setInt(1, codigo);
        ResultSet rs = pstm.executeQuery();
        if (!rs.next()) {
            throw new SQLException("Não existe cliente para o código informado.");
        }
        rs.beforeFirst();
        return rs;
    }

    /**
     * Método para buscar o filme no banco via código
     * @param codigo
     * @return Registro de Filme
     * @throws SQLException
     */
    public ResultSet buscarFilmePorCodigo(int codigo) throws SQLException {
        String consultaSQL = "Select * from FILMES where CHAVE_tAB = ?";
        pstm = objCon.prepareStatement(consultaSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        pstm.setInt(1, codigo);
        ResultSet rs = pstm.executeQuery();
        if (!rs.next()) {
            throw new SQLException("Não existe filme para o código informado.");
        }
        rs.beforeFirst();
        return rs;
    }

    /**
     * Método para buscar a locacao no banco via codigoCab
     * @param codigoCab
     * @return Registro de Locacao
     * @throws SQLException
     */
    public ResultSet buscarLocacaoPorCodigo(int codigo) throws SQLException {
        String consultaSQL = "Select LOC_FILMES_CAB.COD_LOC_CAB,LOC_FILMES_DET.COD_LOC_DET,LOC_FILMES_CAB.COD_CLIENTE,LOC_FILMES_CAB.DATA_LOC,LOC_FILMES_CAB.DATA_DEVOLUCAO,LOC_FILMES_DET.COD_FILME,LOC_FILMES_DET.VALOR from LOC_FILMES_CAB INNER JOIN LOC_FILMES_DET ON LOC_FILMES_DET.COD_LOC_CAB = LOC_FILMES_CAB.COD_LOC_CAB where LOC_FILMES_CAB.COD_LOC_CAB = ?";
        pstm = objCon.prepareStatement(consultaSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        pstm.setInt(1, codigo);
        ResultSet rs = pstm.executeQuery();
        if (!rs.next()) {
            throw new SQLException("Não existe locação para o código informado.");
        }
        rs.beforeFirst();
        return rs;
    }

    /**
     * Método para buscar todos os clientes no banco via código
     * @param codigo
     * @return Registro dos clientes
     * @throws SQLException
     */
    public ResultSet buscarTodosClientes() throws SQLException {
        String consultaSQL = "Select * from CLIENTES order by COD_CLIENTE";
        pstm = objCon.prepareStatement(consultaSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = pstm.executeQuery();
        if (!rs.next()) {
            throw new SQLException("Não existe nenhum cliente cadastrado.");
        }
        rs.beforeFirst();
        return rs;

    }

    /**
     * Método para buscar todos os filmes no banco via código
     * @param codigo
     * @return Registro dos filmes
     * @throws SQLException
     */
    public ResultSet buscarTodosFilmes() throws SQLException {
        String consultaSQL = "Select * from FILMES order by CHAVE_TAB";
        pstm = objCon.prepareStatement(consultaSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = pstm.executeQuery();
        if (!rs.next()) {
            throw new SQLException("Não existe nenhum filme cadastrado.");
        }
        rs.beforeFirst();
        return rs;

    }

    /**
     * Método para buscar todos as LocacoesCab no banco via codigoCab
     * @param codigoCab
     * @return Registro das LocacaoesCab
     * @throws SQLException
     */
    public ResultSet buscarTodasLocacoes() throws SQLException {
        String consultaSQL = "Select LOC_FILMES_CAB.COD_LOC_CAB,LOC_FILMES_CAB.COD_CLIENTE,LOC_FILMES_CAB.DATA_LOC,LOC_FILMES_CAB.DATA_DEVOLUCAO,LOC_FILMES_DET.COD_FILME,LOC_FILMES_DET.VALOR from LOC_FILMES_CAB INNER JOIN LOC_FILMES_DET ON LOC_FILMES_DET.COD_LOC_CAB = LOC_FILMES_CAB.COD_LOC_CAB";
        pstm = objCon.prepareStatement(consultaSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = pstm.executeQuery();
        if (!rs.next()) {
            throw new SQLException("Não existe nenhuma locação cadastrada.");
        }
        rs.beforeFirst();
        return rs;
    }

    //Método Comum - Buscar Clientes Por Nome
    /*
    public ResultSet buscarClientesPorNome(String nome) throws SQLException {
    String consultaSQL = "Select * from CLIENTES where upper(NOME_CLIENTE) like '%' || ? || '%' order by NOME_CLIENTE";
    pstm = objCon.prepareStatement(consultaSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    pstm.setString(1, nome.toUpperCase());
    ResultSet rs = pstm.executeQuery();
    if (!rs.next()) {
    throw new SQLException("Não existe nenhum cliente cadastrado para o nome informado.");
    }
    rs.beforeFirst();
    return rs;
    }
     */
    //Método JTable - Buscar Clientes Por Nome
    /**
     * Método para buscar os clientes pelo nome no banco
     * @return objeto JTable
     * @throws SQLException com mensagem "Não existe nenhum cliente cadastrado para o nome informado."
     */
    public JTable buscarClientesPorNome(String nome) throws SQLException {
        PreparedStatement objSQL = objCon.prepareStatement(
                "Select * from Clientes where upper(NOME_CLIENTE) like '%' || ? || '%' order by NOME_CLIENTE",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        objSQL.setString(1, nome.toUpperCase());
        ResultSet objResp = objSQL.executeQuery();
        if (!objResp.next()) {
            throw new SQLException("Não existe cliente para o nome informado.");
        }
        Vector<String> cabecalho = new Vector<String>();
        cabecalho.add("Código");
        cabecalho.add("Nome");
        cabecalho.add("CPF");
        cabecalho.add("Telefone");
        cabecalho.add("Email");
        cabecalho.add("Data");

        Vector<Vector> dados = new Vector<Vector>();
        objResp.beforeFirst();
        while (objResp.next()) {
            dados.add(new Vector<String>());
            dados.lastElement().add(objResp.getString("COD_CLIENTE"));
            dados.lastElement().add(objResp.getString("NOME_CLIENTE"));
            dados.lastElement().add(objResp.getString("CPF"));
            dados.lastElement().add(objResp.getString("TELEFONE"));
            dados.lastElement().add(objResp.getString("EMAIL"));
            dados.lastElement().add(LtpUtil.formatarData(objResp.getDate("DATA_CLIENTE"), "dd/MM/yyyy"));
        }

        return new JTable(dados, cabecalho);
    }

    //Método Comum - Buscar Filmes Por Nome
    /*
    public ResultSet buscarFilmesPorNome(String nome) throws SQLException {
    String consultaSQL = "Select * from FILMES where upper(NOME_BRASIL) like '%' || ? || '%' order by NOME_BRASIL";
    pstm = objCon.prepareStatement(consultaSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    pstm.setString(1, nome.toUpperCase());
    ResultSet rs = pstm.executeQuery();
    if (!rs.next()) {
    throw new SQLException("Não existe nenhum filme cadastrado para o nome informado.");
    }
    rs.beforeFirst();
    return rs;}*/
    //Método JTable - Buscar Filmes Por Nome
    /**
     * Método para buscar os filmes pelo nome no banco
     * @return objeto JTable
     * @throws SQLException com mensagem "Não existe nenhum filme cadastrado para o nome informado."
     */
    public JTable buscarFilmesPorNome(String nome) throws SQLException {
        PreparedStatement objSQL = objCon.prepareStatement(
                "Select * from FILMES where upper(NOME_BRASIL) like '%' || ? || '%' order by NOME_BRASIL",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        objSQL.setString(1, nome.toUpperCase());
        ResultSet objResp = objSQL.executeQuery();
        if (!objResp.next()) {
            throw new SQLException("Não existe filme para o nome informado.");
        }
        Vector<String> cabecalho = new Vector<String>();
        cabecalho.add("Nome no Brasil");
        cabecalho.add("Nome Original");
        cabecalho.add("Ano");
        cabecalho.add("Gênero Principal");
        cabecalho.add("Ator Principal");
        cabecalho.add("Tempo de Filme");
        cabecalho.add("Estoque");
        cabecalho.add("Data do Filme");

        Vector<Vector> dados = new Vector<Vector>();
        objResp.beforeFirst();
        while (objResp.next()) {
            dados.add(new Vector<String>());
            dados.lastElement().add(objResp.getString("NOME_BRASIL"));
            dados.lastElement().add(objResp.getString("NOME_ORIGINAL"));
            dados.lastElement().add(objResp.getString("ANO"));
            dados.lastElement().add(objResp.getString("GENERO_PRINCIPAL"));
            dados.lastElement().add(objResp.getString("ATOR_PRINCIPAL"));
            dados.lastElement().add(objResp.getString("TEMPO_FILME"));
            dados.lastElement().add(objResp.getString("QUAN_MIDIAS"));
            dados.lastElement().add(LtpUtil.formatarData(objResp.getDate("DATA_FILME"), "dd/MM/yyyy"));
        }

        return new JTable(dados, cabecalho);
    }

    //Método JTable - Buscar Locacoes com Atraso
    /**
     * Método para buscar as locacoes com atraso no banco
     * @return objeto JTable
     * @throws SQLException com mensagem "Não existe nenhuma locação atrasada."
     */
    public JTable buscarLocacoesPorData() throws SQLException {
        PreparedStatement objSQL = objCon.prepareStatement(
                "Select LOC_FILMES_CAB.COD_LOC_CAB,CLIENTES.NOME_CLIENTE,LOC_FILMES_CAB.DATA_LOC, FILMES.NOME_BRASIL,LOC_FILMES_DET.VALOR from LOC_FILMES_CAB INNER JOIN CLIENTES ON CLIENTES.COD_CLIENTE = LOC_FILMES_CAB.COD_CLIENTE INNER JOIN LOC_FILMES_DET ON LOC_FILMES_DET.COD_LOC_CAB = LOC_FILMES_CAB.COD_LOC_CAB INNER JOIN FILMES ON LOC_FILMES_DET.COD_FILME = FILMES.CHAVE_TAB where DATA_DEVOLUCAO IS NULL AND ? > DATEADD ( DAY ,3, DATA_LOC )",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        Date data = new Date(System.currentTimeMillis());
        objSQL.setDate(1, data);

        ResultSet objResp = objSQL.executeQuery();
        if (!objResp.next()) {
            throw new SQLException("Não existe nenhuma locação atrasada.");
        }
        Vector<String> cabecalho = new Vector<String>();
        cabecalho.add("Código da Locação");
        cabecalho.add("Nome do Cliente");
        cabecalho.add("Data da Locação");
        cabecalho.add("Nome do Filme");
        cabecalho.add("Valor");

        Vector<Vector> dados = new Vector<Vector>();
        objResp.beforeFirst();
        while (objResp.next()) {
            dados.add(new Vector<String>());
            dados.lastElement().add(objResp.getString("COD_LOC_CAB"));
            dados.lastElement().add(objResp.getString("NOME_CLIENTE"));
            dados.lastElement().add(LtpUtil.formatarData(objResp.getDate("DATA_LOC"), "dd/MM/yyyy"));
            dados.lastElement().add(objResp.getString("NOME_BRASIL"));
            dados.lastElement().add(objResp.getString("VALOR"));
        }

        return new JTable(dados, cabecalho);
    }

    /**
     * Método para buscar o primeiro cliente no banco
     * @return Registro de cliente
     * @throws SQLException
     */
    public ResultSet buscarClientePrimeiro() throws SQLException {
        String consultaSQL = "Select * from CLIENTES where COD_CLIENTE = (Select Min(COD_CLIENTE) from CLIENTES)";
        pstm = objCon.prepareStatement(consultaSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
        ResultSet rs = pstm.executeQuery();
        if (!rs.next()) {
            throw new SQLException("Não existe nenhum cliente cadastrado.");
        }
        rs.beforeFirst();
        return rs;
    }

    /**
     * Método para buscar o primeiro filme no banco
     * @return Registro de Filmes
     * @throws SQLException
     */
    public ResultSet buscarFilmePrimeiro() throws SQLException {
        String consultaSQL = "Select * from FILMES where CHAVE_TAB = (Select Min(CHAVE_TAB) from FILMES)";
        pstm = objCon.prepareStatement(consultaSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
        ResultSet rs = pstm.executeQuery();
        if (!rs.next()) {
            throw new SQLException("Não existe nenhum filme cadastrado.");
        }
        rs.beforeFirst();
        return rs;
    }

    /**
     * Método para buscar a primeira Locacoes no banco
     * @return Registro de Locacoes
     * @throws SQLException
     */
    public ResultSet buscarLocacaoPrimeiro() throws SQLException {
        String consultaSQL = "Select LOC_FILMES_CAB.COD_LOC_CAB,LOC_FILMES_DET.COD_LOC_DET,LOC_FILMES_CAB.COD_CLIENTE,LOC_FILMES_CAB.DATA_LOC,LOC_FILMES_CAB.DATA_DEVOLUCAO,LOC_FILMES_DET.COD_FILME,LOC_FILMES_DET.VALOR from LOC_FILMES_CAB INNER JOIN LOC_FILMES_DET ON LOC_FILMES_DET.COD_LOC_CAB = LOC_FILMES_CAB.COD_LOC_CAB where LOC_FILMES_CAB.COD_LOC_CAB = (Select Min( LOC_FILMES_CAB.COD_LOC_CAB) from LOC_FILMES_CAB)";
        pstm = objCon.prepareStatement(consultaSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
        ResultSet rs = pstm.executeQuery();
        if (!rs.next()) {
            throw new SQLException("Não existe nenhuma locação cadastrada.");
        }
        rs.beforeFirst();
        return rs;
    }

    /**
     * Método para buscar o próximo cliente no banco
     * @param codigo
     * @return Registro de cliente
     * @throws SQLException
     */
    public ResultSet buscarClienteProximo(int codigo) throws SQLException {
        String consultaSQL = "Select * from CLIENTES where COD_CLIENTE = (Select  min(COD_CLIENTE)  from CLIENTES where COD_CLIENTE > ? )";
        pstm = objCon.prepareStatement(consultaSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
        pstm.setInt(1, codigo);
        ResultSet rs = pstm.executeQuery();
        if (!rs.next()) {
            throw new SQLException("Não existe próximo registro.");
        }
        rs.beforeFirst();
        return rs;
    }

    /**
     * Método para buscar o próximo filme no banco
     * @param codigo
     * @return Registro de Filme
     * @throws SQLException
     */
    public ResultSet buscarFilmeProximo(int codigo) throws SQLException {
        String consultaSQL = "Select * from FILMES where CHAVE_TAB = (Select  min(CHAVE_TAB)  from FILMES where CHAVE_TAB > ? )";
        pstm = objCon.prepareStatement(consultaSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
        pstm.setInt(1, codigo);
        ResultSet rs = pstm.executeQuery();
        if (!rs.next()) {
            throw new SQLException("Não existe próximo registro.");
        }
        rs.beforeFirst();
        return rs;
    }

    /**
     * Método para buscar o próxima Locacao no banco
     * @param codigo
     * @return Registro de Locacao
     * @throws SQLException
     */
    public ResultSet buscarLocacaoProximo(int codigo) throws SQLException {
        String consultaSQL = "Select LOC_FILMES_CAB.COD_LOC_CAB,LOC_FILMES_DET.COD_LOC_DET,LOC_FILMES_CAB.COD_CLIENTE,LOC_FILMES_CAB.DATA_LOC,LOC_FILMES_CAB.DATA_DEVOLUCAO,LOC_FILMES_DET.COD_FILME,LOC_FILMES_DET.VALOR from LOC_FILMES_CAB INNER JOIN LOC_FILMES_DET ON LOC_FILMES_DET.COD_LOC_CAB = LOC_FILMES_CAB.COD_LOC_CAB where LOC_FILMES_CAB.COD_LOC_CAB  > ?";
        pstm = objCon.prepareStatement(consultaSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
        pstm.setInt(1, codigo);
        ResultSet rs = pstm.executeQuery();
        if (!rs.next()) {
            throw new SQLException("Não existe próximo registro.");
        }
        rs.beforeFirst();
        return rs;
    }

    /**
     * Método para buscar o cliente anterior no banco
     * @param codigo
     * @return Registro de cliente
     * @throws SQLException
     */
    public ResultSet buscarClienteAnterior(int codigo) throws SQLException {
        String consultaSQL = "Select * from CLIENTES where COD_CLIENTE = (Select  max(COD_CLIENTE)  from CLIENTES where COD_CLIENTE < ? )";
        pstm = objCon.prepareStatement(consultaSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
        pstm.setInt(1, codigo);
        ResultSet rs = pstm.executeQuery();
        if (!rs.next()) {
            throw new SQLException("Não existe registro anterior.");
        }
        rs.beforeFirst();
        return rs;
    }

    /**
     * Método para buscar o filme anterior no banco
     * @param codigo
     * @return Registro de filme
     * @throws SQLException
     */
    public ResultSet buscarFilmeAnterior(int codigo) throws SQLException {
        String consultaSQL = "Select * from FILMES where CHAVE_TAB = (Select  max(CHAVE_TAB)  from FILMES where CHAVE_TAB < ? )";
        pstm = objCon.prepareStatement(consultaSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
        pstm.setInt(1, codigo);
        ResultSet rs = pstm.executeQuery();
        if (!rs.next()) {
            throw new SQLException("Não existe registro anterior.");
        }
        rs.beforeFirst();
        return rs;
    }

    /**
     * Método para buscar a Locacao anterior no banco
     * @param codigo
     * @return Registro de Locacao
     * @throws SQLException
     */
    public ResultSet buscarLocacaoAnterior(int codigo) throws SQLException {
        String consultaSQL = "Select LOC_FILMES_CAB.COD_LOC_CAB,LOC_FILMES_DET.COD_LOC_DET,LOC_FILMES_CAB.COD_CLIENTE,LOC_FILMES_CAB.DATA_LOC,LOC_FILMES_CAB.DATA_DEVOLUCAO,LOC_FILMES_DET.COD_FILME,LOC_FILMES_DET.VALOR from LOC_FILMES_CAB INNER JOIN LOC_FILMES_DET ON LOC_FILMES_DET.COD_LOC_CAB = LOC_FILMES_CAB.COD_LOC_CAB where LOC_FILMES_CAB.COD_LOC_CAB < ? AND LOC_FILMES_CAB.COD_LOC_CAB  = (Select Max( LOC_FILMES_CAB.COD_LOC_CAB) from LOC_FILMES_CAB where loc_filmes_cab.COD_LOC_CAB < ?)";
        pstm = objCon.prepareStatement(consultaSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
        pstm.setInt(1, codigo);
        pstm.setInt(2, codigo);
        ResultSet rs = pstm.executeQuery();
        if (!rs.next()) {
            throw new SQLException("Não existe registro anterior.");
        }
        rs.beforeFirst();
        return rs;
    }

    /**
     * Método para buscar o ultimo cliente no banco
     * @return Registro de cliente
     * @throws SQLException
     */
    public ResultSet buscarClienteUltimo() throws SQLException {
        String consultaSQL = "Select * from CLIENTES where COD_CLIENTE = (Select Max(COD_CLIENTE) from CLIENTES)";
        pstm = objCon.prepareStatement(consultaSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
        ResultSet rs = pstm.executeQuery();
        if (!rs.next()) {
            throw new SQLException("Não existe nenhum cliente cadastrado.");
        }
        rs.beforeFirst();
        return rs;
    }

    /**
     * Método para buscar o ultimo filme no banco
     * @return Registro de filme
     * @throws SQLException
     */
    public ResultSet buscarFilmeUltimo() throws SQLException {
        String consultaSQL = "Select * from FILMES where CHAVE_TAB = (Select Max(CHAVE_TAB) from FILMES)";
        pstm = objCon.prepareStatement(consultaSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
        ResultSet rs = pstm.executeQuery();
        if (!rs.next()) {
            throw new SQLException("Não existe nenhum filme cadastrado.");
        }
        rs.beforeFirst();
        return rs;
    }

    /**
     * Método para buscar a ultima Locacao no banco
     * @return Registro de Locacao
     * @throws SQLException
     */
    public ResultSet buscarLocacaoUltimo() throws SQLException {
        String consultaSQL = "Select LOC_FILMES_CAB.COD_LOC_CAB,LOC_FILMES_DET.COD_LOC_DET,LOC_FILMES_CAB.COD_CLIENTE,LOC_FILMES_CAB.DATA_LOC,LOC_FILMES_CAB.DATA_DEVOLUCAO,LOC_FILMES_DET.COD_FILME,LOC_FILMES_DET.VALOR from LOC_FILMES_CAB INNER JOIN LOC_FILMES_DET ON LOC_FILMES_DET.COD_LOC_CAB = LOC_FILMES_CAB.COD_LOC_CAB where LOC_FILMES_CAB.COD_LOC_CAB = (Select Max( LOC_FILMES_CAB.COD_LOC_CAB) from LOC_FILMES_CAB) AND LOC_FILMES_DET.COD_LOC_DET  = (Select Max( LOC_FILMES_DET.COD_LOC_DET) from LOC_FILMES_DET)";
        pstm = objCon.prepareStatement(consultaSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
        ResultSet rs = pstm.executeQuery();
        if (!rs.next()) {
            throw new SQLException("Não existe nenhuma locação cadastrada.");
        }
        rs.beforeFirst();
        return rs;
    }
    /**
     * Método para consulta de clientes que alugaram filmes por período de locação
     * @return objeto JTable
     * @throws SQLException com mensagem "Não existe cliente para o período informado."
     */
    public JTable buscarClientesPorPeriodo(String nome,Date data1, Date data2) throws SQLException {
        PreparedStatement objSQL = objCon.prepareStatement(
                "Select CLIENTES.NOME_CLIENTE,CLIENTES.TELEFONE,CLIENTES.EMAIL,LOC_FILMES_CAB.DATA_LOC,LOC_FILMES_CAB.DATA_DEVOLUCAO,FILMES.NOME_BRASIL,LOC_FILMES_DET.VALOR from Clientes INNER JOIN LOC_FILMES_CAB ON LOC_FILMES_CAB.COD_CLIENTE = CLIENTES.COD_CLIENTE INNER JOIN LOC_FILMES_DET ON LOC_FILMES_DET.COD_LOC_CAB = LOC_FILMES_cAB.COD_LOC_CAB INNER JOIN FILMES ON FILMES.CHAVE_TAB = LOC_FILMES_DET.COD_FILME WHERE (upper(NOME_CLIENTE) like '%' || ? || '%') AND (LOC_FILMES_CAB.DATA_LOC  BETWEEN ? AND ?) ORDER BY CLIENTES.NOME_CLIENTE",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        objSQL.setString(1, nome.toUpperCase());
        objSQL.setDate(2, data1);
        objSQL.setDate(3, data2);
        ResultSet objResp = objSQL.executeQuery();
        if (!objResp.next()) {
            throw new SQLException("Não existe cliente para o período informado.");
        }
        Vector<String> cabecalho = new Vector<String>();
        cabecalho.add("Nome do Cliente");
        cabecalho.add("Telefone");
        cabecalho.add("Email");
        cabecalho.add("Data da Locação");
        cabecalho.add("Data da Devolução");
        cabecalho.add("Nome do Filme");
        cabecalho.add("Valor");

        Vector<Vector> dados = new Vector<Vector>();
        objResp.beforeFirst();
        while (objResp.next()) {
            dados.add(new Vector<String>());
            dados.lastElement().add(objResp.getString("NOME_CLIENTE"));
            dados.lastElement().add(objResp.getString("TELEFONE"));
            dados.lastElement().add(objResp.getString("EMAIL"));
            dados.lastElement().add(LtpUtil.formatarData(objResp.getDate("DATA_LOC"), "dd/MM/yyyy"));
            dados.lastElement().add(LtpUtil.formatarData(objResp.getDate("DATA_DEVOLUCAO"), "dd/MM/yyyy"));
            dados.lastElement().add(objResp.getString("NOME_BRASIL"));
            dados.lastElement().add(objResp.getString("VALOR"));
        }

        return new JTable(dados, cabecalho);
    }

    /**
     * Método para consulta de filmes
     * @return objeto JTable
     * @throws SQLException com mensagem "Não existe filme para o período informado."
     */
    public JTable buscarFilmesPorPeriodo(Date data1, Date data2) throws SQLException {
        PreparedStatement objSQL = objCon.prepareStatement(
                "SELECT FILMES.NOME_BRASIL,MAX(LOC_FILMES_CAB.DATA_LOC) DATA_LOC,COUNT(LOC_FILMES_DET.COD_FILME) TOTAL_LOCACOES, SUM(LOC_FILMES_DET.VALOR) TOTAL_VALOR FROM FILMES INNER JOIN LOC_FILMES_DET ON LOC_FILMES_DET.COD_FILME = FILMES.CHAVE_TAB INNER JOIN LOC_FILMES_CAB ON LOC_FILMES_CAB.COD_LOC_CAB = LOC_FILMES_DET.COD_LOC_CAB WHERE LOC_FILMES_CAB.DATA_LOC BETWEEN ? AND ? GROUP BY FILMES.NOME_BRASIL ORDER BY TOTAL_LOCACOES DESC",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        objSQL.setDate(1, data1);
        objSQL.setDate(2, data2);
        ResultSet objResp = objSQL.executeQuery();
        if (!objResp.next()) {
            throw new SQLException("Não existe filme para o período informado.");
        }
        Vector<String> cabecalho = new Vector<String>();
        cabecalho.add("Nome do Filme");
        cabecalho.add("Data da Última Locação");
        cabecalho.add("Total de Locações");
        cabecalho.add("Total do Valor");

        Vector<Vector> dados = new Vector<Vector>();
        objResp.beforeFirst();
        while (objResp.next()) {
            dados.add(new Vector<String>());
            dados.lastElement().add(objResp.getString("NOME_BRASIL"));
            dados.lastElement().add(LtpUtil.formatarData(objResp.getDate("DATA_LOC"), "dd/MM/yyyy"));
            dados.lastElement().add(objResp.getString("TOTAL_LOCACOES"));
            dados.lastElement().add(objResp.getString("TOTAL_VALOR"));
        }

        return new JTable(dados, cabecalho);
    }

     /**
     * Método para buscar total geral de locações no período e o total do valor
     * @return Registro de Locacao
     * @throws SQLException
     */
    public ResultSet buscarTotalLocacao(Date data1, Date data2) throws SQLException {
        String consultaSQL = "SELECT COUNT(COD_LOC_DET) TOTAL_LOCACOES, SUM(VALOR) TOTAL_VALOR FROM LOC_FILMES_DET ";
        pstm = objCon.prepareStatement(consultaSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
        ResultSet rs = pstm.executeQuery();
        if (!rs.next()) {
            throw new SQLException("Não existe nenhuma locação cadastrada.");
        }
        rs.beforeFirst();
        return rs;
    }
      /**
     * Método para consulta de filmes alugados
     * @return objeto JTable
     * @throws SQLException com mensagem "Não existe filme alugado."
     */
    public JTable buscarFilmesAlugadosPorNome(String nome) throws SQLException {
               PreparedStatement objSQL = objCon.prepareStatement(
                "Select FILMES.NOME_BRASIL,LOC_FILMES_CAB.DATA_LOC, CLIENTES.NOME_CLIENTE,CLIENTES.TELEFONE FROM FILMES INNER JOIN LOC_FILMES_DET ON LOC_FILMES_DET.COD_FILME = FILMES.CHAVE_TAB INNER JOIN LOC_FILMES_CAB ON LOC_FILMES_CAB.COD_LOC_CAB = LOC_FILMES_DET.COD_LOC_CAB INNER JOIN CLIENTES ON CLIENTES.COD_CLIENTE = LOC_FILMES_CAB.COD_CLIENTE where upper(NOME_CLIENTE) like '%' || ? || '%' AND LOC_FILMES_CAB.DATA_DEVOLUCAO IS NULL",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        objSQL.setString(1, nome.toUpperCase());
        ResultSet objResp = objSQL.executeQuery();
        if (!objResp.next()) {
            throw new SQLException("Não existe filme para o nome informado.");
        }
        Vector<String> cabecalho = new Vector<String>();
        cabecalho.add("Nome do Filme");
        cabecalho.add("Data da Locação");
        cabecalho.add("Nome do Cliente");
        cabecalho.add("Telefone");

        Vector<Vector> dados = new Vector<Vector>();
        objResp.beforeFirst();
        while (objResp.next()) {
            dados.add(new Vector<String>());
            dados.lastElement().add(objResp.getString("NOME_BRASIL"));
            dados.lastElement().add(LtpUtil.formatarData(objResp.getDate("DATA_LOC"), "dd/MM/yyyy"));
            dados.lastElement().add(objResp.getString("NOME_CLIENTE"));
            dados.lastElement().add(objResp.getString("TELEFONE"));
        }

        return new JTable(dados, cabecalho);
    }
}
