package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionManager;
import entity.Funcionario;

public class FuncionarioDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	public FuncionarioDAO(){
		Connection conn;
		try {
			conn = ConnectionManager.getMysqlConnection();
			this.conn = conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public FuncionarioDAO(Connection conn){
		this.conn = conn;
	}
	
	public ResultSet findByEmpresa( int codigoEmpresa ) {

		String sql = "select num_registro, nome, endereco, sexo, salario, codigo_empresa from FUNCIONARIO where codigo_empresa = ?";

		try {
			this.stmt = this.conn.prepareStatement(sql);
			this.stmt.setInt(1, codigoEmpresa);
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}	
	
	public ResultSet findByCodigo( int numRegistro ) {

		String sql = "select num_registro, nome, endereco, sexo, salario, codigo_empresa from FUNCIONARIO where num_registro = ?";

		try {
			this.stmt = this.conn.prepareStatement(sql);
			this.stmt.setInt(1, numRegistro);
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet findAll() {

		String sql = "select num_registro, nome, endereco, sexo, salario, codigo_empresa from FUNCIONARIO order by num_registro";

		try {
			this.stmt = this.conn.prepareStatement(sql);
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public void excluir(Funcionario funcionario) {		
		String sql = "delete from FUNCIONARIO where num_Registro = ?";
		try {
			this.stmt = conn.prepareStatement(sql);
			this.stmt.setInt(1, funcionario.getNumRegistro());
			this.stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void inserir(Funcionario funcionario){
		
		String sql = "insert into FUNCIONARIO(num_registro, nome, endereco, sexo, salario, codigo_empresa) values (?, ?, ?, ?, ?, ?)";
		
		try {
			
			this.stmt = conn.prepareStatement(sql);
			this.stmt.setInt(1, funcionario.getNumRegistro());
			this.stmt.setString(2, funcionario.getNome());
			this.stmt.setString(3, funcionario.getEndereco());
			this.stmt.setString(4, Character.toString(funcionario.getSexo()));
			this.stmt.setDouble(5, funcionario.getSalarioBase());
			this.stmt.setInt(6, funcionario.getEmpresa().getCodigo());
			this.stmt.executeUpdate();			
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void alterar(Funcionario funcionario){
		
		String sql = "update FUNCIONARIO set nome = ?, endereco = ?, sexo = ?, salario = ? where num_registro = ?";
		
		try {
			
			this.stmt = conn.prepareStatement(sql);
			this.stmt.setString(1, funcionario.getNome());
			this.stmt.setString(2, funcionario.getEndereco());
			this.stmt.setString(3, Character.toString(funcionario.getSexo()));
			this.stmt.setDouble(4, funcionario.getSalarioBase());
			this.stmt.setInt(5, funcionario.getNumRegistro());
			this.stmt.executeUpdate();			
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
}
