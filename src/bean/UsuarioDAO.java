package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
	
	public static void addUsuario(Usuario e1) throws ClassNotFoundException, SQLException {

		String url = "jdbc:postgresql://localhost:5432/trab-prog3";
		Class.forName("org.postgresql.Driver");
		Connection cnx = DriverManager.getConnection(url, "postgres", "tca123");
		System.out.println("Conexгo ao Banco de Dados foi efetuada com sucesso!");

		try {

			StringBuilder cmd = new StringBuilder();
			cmd.append("insert into \"Usuario\"\n");
			cmd.append("( \"nome\", \"senha\" )\n");
			cmd.append("values\n");
			cmd.append("( ? , ? )");

			try {

				PreparedStatement st = cnx.prepareStatement(cmd.toString());

				st.setString(1, e1.getNome());
				st.setString(2, e1.getSenha());

				boolean status = st.execute();

				System.out.println("O comando insert foi executado com status: " + status);
			} catch (SQLException e) {
				System.out.println("Houve erro na execuзгo do comando insert");
				System.out.println(e.getMessage());
				System.out.println("Cуdigo de erro: " + e.getSQLState());
			}
		} finally {
			cnx.close();
		}
	}
	
	public static Usuario find(String user,String senha) throws ClassNotFoundException, SQLException{
		String url = "jdbc:postgresql://localhost:5432/trab-prog3";
		Class.forName("org.postgresql.Driver");
		Connection cnx = DriverManager.getConnection(url, "postgres", "tca123");
		System.out.println("Conexгo ao Banco de Dados foi efetuada com sucesso!");
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
			}
			
			return null;
	}
	

}
