package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.ConnectionManager;
import entity.Empresa;
import entity.Funcionario;

public abstract class DAOUtil {

	public static ArrayList<Empresa> obterEmpresas() {

		ArrayList<Empresa> empresas = new ArrayList<Empresa>();
		Connection conn;
		try {
			conn = ConnectionManager.getMysqlConnection();
			EmpresaDAO empresaDAO = new EmpresaDAO(conn);
			
			ResultSet resultSet = empresaDAO.findAll();
			
			while ( resultSet.next() ) {
				Empresa empresa = new Empresa();
				empresa.setCodigo(resultSet.getInt("codigo"));
				empresa.setNome(resultSet.getString("nome"));
				empresa.setEndereco(resultSet.getString("endereco"));
				empresa.setTelefone(resultSet.getString("telefone"));
				empresas.add(empresa);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empresas;
	}
	
	public static Empresa obterEmpresa( int codigo ) {
		Empresa empresa = null;
		Connection conn;
		try {
			conn = ConnectionManager.getMysqlConnection();
			EmpresaDAO empresaDAO = new EmpresaDAO(conn);
			
			ResultSet resultSet = empresaDAO.findByCodigo(codigo);
			if ( resultSet.next() ) {
				
				empresa = new Empresa();
				empresa.setCodigo(resultSet.getInt("codigo"));
				empresa.setNome(resultSet.getString("nome"));
				empresa.setEndereco(resultSet.getString("endereco"));
				empresa.setTelefone(resultSet.getString("telefone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return empresa;
	}

	public static ArrayList<Funcionario> obterFuncionarios( int codigoEmpresa ) {

		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		Connection conn;
		try {
			conn = ConnectionManager.getMysqlConnection();
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO(conn);
			
			ResultSet resultSet;
			if ( codigoEmpresa == 0 ) {
				resultSet = funcionarioDAO.findAll();				
			} else {
				resultSet = funcionarioDAO.findByEmpresa(codigoEmpresa);
			}
			
			while ( resultSet.next() ) {
				Funcionario funcionario = new Funcionario();
				funcionario.setNumRegistro(resultSet.getInt("num_Registro"));
				funcionario.setNome(resultSet.getString("nome"));
				funcionario.setEndereco(resultSet.getString("endereco"));
				funcionario.setSexo(resultSet.getString("sexo").charAt(0));
				funcionario.setSalarioBase(resultSet.getDouble("salario"));
				funcionarios.add(funcionario);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return funcionarios;
	}
	
}
