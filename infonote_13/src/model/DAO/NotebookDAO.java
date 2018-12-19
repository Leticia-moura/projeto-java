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

	
	public static  Notebook inserir(int numeroNote,String serialNote, String modelo, String descricao, int estoque, double precoUnitario, String figura,
			String dataCadastro) {
		Notebook notebook = null;
		NotebookDAO noteDAO = new NotebookDAO();
		try {

			String sql = "insert into notebook " + "(numeroNote, serialNote,  modelo,  descricao, estoque, precoUnitario,  figura,\r\n" + 
					"				 dataCadastro) "
					+ "values (?,?,?,?,?)";

			Conexao conex = new Conexao(noteDAO.url, noteDAO.driver, noteDAO.login, noteDAO.senha);

			Connection con = conex.obterConexao();
			 
			 
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(1,numeroNote );
			comando.setString(2,serialNote );
			comando.setString(3,modelo );
			comando.setString(4,descricao);
			comando.setInt(5, estoque);
			comando.setDouble(6, precoUnitario);
			comando.setString(7,figura );
			comando.setString(8,dataCadastro );

			comando.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		notebook = new Notebook(numeroNote, serialNote,  modelo,  descricao, estoque, precoUnitario,  figura,
				 dataCadastro);
		return notebook;
	}
	public static Notebook[] buscarTodos(){
		Notebook[] notebooks = null;
		 try {
		 
		 String sql = "Select * from notebook";
		 
		 Conexao conex = new Conexao ("jdbc:mysql://localhost:3306/18_conexaobd?useTimezone=true&serverTimezone=UTC", "com.mysql.cj.jdbc.Driver","root","1234");
		 Connection con = conex.obterConexao();
		 Statement comando = con.createStatement();
		 ResultSet rs = comando.executeQuery(sql);
		 notebooks = new Notebook[10];
		 int i = 0;
		 while (rs.next()) {
			 notebooks[i++] = new Notebook(
		  rs.getInt("numeroNote"),
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
	public static Notebook excluir (int id) {
		Notebook notebook = null;
		try {
			String sql = "delete from notebook where id = ?";
			Conexao conex = new Conexao("jdbc:mysql://localhost:3306/18_conexaobd?useTimezone=true&serverTimezone=UTC", "com.mysql.cj.jdbc.Driver","root","1234"); 
			Connection con = conex.obterConexao();
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(1, id);
			comando.executeUpdate();
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
		
		}
		
		return notebook;
	}
	public static Notebook atualizar (int numeroNote,String serialNote, String modelo, String descricao, int estoque, double precoUnitario, String figura,
			String dataCadastro, int id) {
		Notebook notebook = null;
		try {
			String sql = "update contato set mensagem = ? where id = ? ";
			Conexao conex = new Conexao("jdbc:mysql://localhost:3306/18_conexaobd?useTimezone=true&serverTimezone=UTC","com.mysql.cj.jdbc.Driver","root","1234"); 
			Connection con = conex.obterConexao();
			PreparedStatement comando = con.prepareStatement(sql);
			
			comando.setInt(1,numeroNote );
			comando.setString(2,serialNote );
			comando.setString(3,modelo );
			comando.setString(4,descricao);
			comando.setInt(5, estoque);
			comando.setDouble(6, precoUnitario);
			comando.setString(7,figura );
			comando.setString(8,dataCadastro );
			comando.setInt(9,id);
			comando.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return notebook;
	}
	
}
