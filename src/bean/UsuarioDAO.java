package bean;

import bean.SGBD.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

;

public class UsuarioDAO {
	
	
 public static Usuario find(String user,String senha) throws ClassNotFoundException, SQLException, IOException{
	
	 		PoolDeConexoes pool = PoolDeConexoes.getInstance();
	 		Conexao cnx = pool.getConexao();
	 
			StringBuilder cmd = new StringBuilder();
			cmd.append("select * from \"Usuarios\" WHERE \"nome\" = ? AND \"senha\" = ?");
			
			try {

				PreparedStatement st = cnx.prepareStatement(cmd.toString());
				st.setString(1, user);
				st.setString(2, senha);

				ResultSet resultList = st.executeQuery();		
				if(resultList.next()){
					Usuario u1 = new Usuario(resultList.getString("nome"), resultList.getString("senha"));
					return u1;
				}
			} catch (SQLException e) {
				System.out.println("Houve erro na execuзгo do comando select");
				System.out.println(e.getMessage());
				System.out.println("Cуdigo de erro: " + e.getSQLState());
			}finally {
				cnx.libera();
			}
			
			return null;
	}
	
 
 public static void addUsuario( Usuario usuario ) throws SQLException, IOException {
		
		PoolDeConexoes pool = PoolDeConexoes.getInstance();
		Conexao cnx = pool.getConexao();
		
		try {

			StringBuilder cmd = new StringBuilder();
			cmd.append("insert into \"Usuarios\"\n");
			cmd.append("( \"nome\", \"senha\" )\n");
			cmd.append("values\n");
			cmd.append("( ? , ? )");
			
			PreparedStatement st = cnx.prepareStatement(cmd.toString());
			st.setString(1, usuario.getNome());
			st.setString(2, usuario.getSenha());
			
			boolean status = st.execute();
			
			System.out.println("O comando insert foi executado com status: " + status);
			 
		} catch (SQLException e) {
			System.out.println("Houve erro na execuзгo do comando insert");
			System.out.println(e.getMessage());
			System.out.println("Cуdigo de erro: " + e.getSQLState());
		}finally {
			cnx.libera();
		}
	}
	
 
 

}
