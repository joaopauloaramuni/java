package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionManager;
import entity.Empresa;

public class EmpresaDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	public EmpresaDAO(){
		Connection conn;
		try {
			conn = ConnectionManager.getMysqlConnection();
			this.conn = conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public EmpresaDAO(Connection conn){
		this.conn = conn;
	}

	public ResultSet findByCodigo( int codigo ) {

		String sql = "select codigo, nome, endereco, telefone from EMPRESA where codigo = ?";

		try {
			this.stmt = this.conn.prepareStatement(sql);
			this.stmt.setInt(1, codigo);
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet findAll() {

		String sql = "select codigo, nome, endereco, telefone from EMPRESA order by codigo";

		try {
			this.stmt = this.conn.prepareStatement(sql);
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public void excluir(Empresa empresa) {		
		String sql = "delete from EMPRESA where codigo = ?";
		try {
			this.stmt = conn.prepareStatement(sql);
			this.stmt.setInt(1, empresa.getCodigo() );
			this.stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void inserir(Empresa empresa){
		
		String sql = "insert into EMPRESA(nome, endereco, telefone) values (?, ?, ?)";
		
		try {
			
			this.stmt = conn.prepareStatement(sql);
			//this.stmt.setInt(1, empresa.getCodigo());
			this.stmt.setString(1, empresa.getNome());
			this.stmt.setString(2, empresa.getEndereco());
			this.stmt.setString(3, empresa.getTelefone());
			this.stmt.executeUpdate();			
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void alterar(Empresa empresa){
		
		String sql = "update EMPRESA set nome = ?, endereco = ?, telefone = ? where codigo = ?";
		
		try {
			
			this.stmt = conn.prepareStatement(sql);
			this.stmt.setString(1, empresa.getNome());
			this.stmt.setString(2, empresa.getEndereco());
			this.stmt.setString(3, empresa.getTelefone());
			this.stmt.setInt(4, empresa.getCodigo());
			this.stmt.executeUpdate();			
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
}
