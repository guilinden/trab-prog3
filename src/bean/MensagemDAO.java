package bean;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import bean.SGBD.Conexao;
import bean.SGBD.PoolDeConexoes;

import java.sql.PreparedStatement;

public class MensagemDAO{
	
	public static void addMensagem(Mensagem m1) throws ClassNotFoundException, SQLException, IOException {
		
		PoolDeConexoes pool = PoolDeConexoes.getInstance();
 		Conexao cnx = pool.getConexao();
		
		try {
			
			StringBuilder cmd = new StringBuilder();
			cmd.append("insert into \"Mensagens\"\n");
			cmd.append("(\"nome\", \"texto\", \"email\")\n");
			cmd.append("values\n");
			cmd.append("(? ,? ,?)");
			
			try {
				
				PreparedStatement st = cnx.prepareStatement(cmd.toString());
				
				st.setString(1,  m1.getNome());
				st.setString(2,  m1.getTexto());
				st.setString(3,  m1.getEmail());
				
				boolean status = st.execute();
				
				System.out.println("O comando insert foi executado com status: " + status);
			} catch (SQLException e) {
				System.out.println("Houve erro na execuзгo do comando insert");
				System.out.println(e.getMessage());
				System.out.println("Cуdigo de erro: " + e.getSQLState());	
			}
		}finally {
			cnx.libera();
		}
	}
	
}