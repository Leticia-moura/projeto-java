package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.Notebook;
import util.Conexao;
import util.Configurador;

public class NotebookDAO {
	Configurador config = new Configurador();
	String url;
	String driver;
	String login;
	String senha;
	public NotebookDAO() {
		url = config.getUrl();
		driver = config.getDriver();
		login = config.getLogin();
		senha = config.getSenha();
	}

	
	public static  Notebook inserir(String serialNote, String modelo, String descricao, int estoque, double precoUnitario, String figura,
			String dataCadastro) {
		Notebook notebook = null;
		NotebookDAO noteDAO = new NotebookDAO();
		try {

			String sql = "insert into notebook " + "( serialNote,  modelo,  descricao, estoque, precoUnitario,  figura,\r\n" + 
					"				 dataCadastro) "
					+ "values (?,?,?,?,?,?,?)";

			Conexao conex = new Conexao(noteDAO.url, noteDAO.driver, noteDAO.login, noteDAO.senha);

			Connection con = conex.obterConexao();
			 
			 
			PreparedStatement comando = con.prepareStatement(sql);
			
			comando.setString(1,serialNote );
			comando.setString(2,modelo );
			comando.setString(3,descricao);
			comando.setInt(4, estoque);
			comando.setDouble(5, precoUnitario);
			comando.setString(6,figura );
			comando.setString(7,dataCadastro );

			comando.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		notebook = new Notebook( serialNote,  modelo,  descricao, estoque, precoUnitario,  figura,
				 dataCadastro);
		return notebook;
	}
	public static Notebook[] buscarTodos(){
		Notebook[] notebooks = null;
		NotebookDAO noteDAO = new NotebookDAO();
		 try {
		 
		 String sql = "Select * from notebook";
		 
		 Conexao conex = new Conexao (noteDAO.url, noteDAO.driver, noteDAO.login, noteDAO.senha);
		 Connection con = conex.obterConexao();
		 Statement comando = con.createStatement();
		 ResultSet rs = comando.executeQuery(sql);
		 notebooks = new Notebook[10];
		 int i = 0;
		 while (rs.next()) {
			 notebooks[i++] = new Notebook(
		  rs.getString("serialNote"),
		  rs.getString("modelo"),
		  rs.getString("descricao"),
		  rs.getInt("estoque"),
		  rs.getDouble("precoUnitario"),
		  rs.getString("figura"),
		  rs.getString("dataCadastro"));
		  rs.close();
		  comando.close();
		  con.close();
		 }
		 } catch (Exception e){
		  System.out.println(e.getMessage());
		  }
		  return notebooks;
		 }
	@SuppressWarnings("unused")
	public static Notebook excluir (String id) {
		Notebook notebook = null;
		NotebookDAO noteDAO = new NotebookDAO();
		try {
			String sql = "delete from notebook where id = ?";
			Conexao conex = new Conexao(noteDAO.url, noteDAO.driver, noteDAO.login, noteDAO.senha); 
			Connection con = conex.obterConexao();
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, id);
			comando.executeUpdate();
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
		
		}
		
		return notebook;
	}
	public static Notebook atualizar ( String modelo, String descricao, int estoque, double precoUnitario, String figura,
			String dataCadastro) {
		Notebook notebook = null;
		NotebookDAO noteDAO = new NotebookDAO();
		try {
			String sql = "update contato set mensagem = ? where id = ? ";
			Conexao conex = new Conexao(noteDAO.url, noteDAO.driver, noteDAO.login, noteDAO.senha); 
			Connection con = conex.obterConexao();
			PreparedStatement comando = con.prepareStatement(sql);
			
			
			
			comando.setString(1,modelo );
			comando.setString(2,descricao);
			comando.setInt(3, estoque);
			comando.setDouble(4, precoUnitario);
			comando.setString(5,figura );
			comando.setString(6,dataCadastro );
			
			comando.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return notebook;
	}
	
}
