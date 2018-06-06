package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class MensagemDAO{
	
	public static void addMensagem(Mensagem m1) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:postgresql://localhost:5432/trab-prog3";
		Class.forName("org.postgresql.Driver");
		Connection cnx = DriverManager.getConnection(url, "postgres", "tca123");
		System.out.println("Conexгo ao Banco de Dados foi efetuada com sucesso!");
		
		try {
			
			StringBuilder cmd = new StringBuilder();
			cmd.append("insert into \"Mensagem\"\n");
			cmd.append("(\"nome\", \"senha\", \"email\")\n");
			cmd.append("values\n");
			cmd.append("(? ,? ,?)");
			
			try {
				
				PreparedStatement st = cnx.prepareStatement(cmd.toString());
				
				st.setString(1,  m1.getEmail());
				st.setString(2,  m1.getNome());
				st.setString(3,  m1.getTexto());
				
				boolean status = st.execute();
				
				System.out.println("O comando insert foi executado com status: " + status);
			} catch (SQLException e) {
				System.out.println("Houve erro na execuзгo do comando insert");
				System.out.println(e.getMessage());
				System.out.println("Cуdigo de erro: " + e.getSQLState());	
			}
		}finally {
			cnx.close();
		}
	}
	
}