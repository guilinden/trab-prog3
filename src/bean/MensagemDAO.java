package bean;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.SGBD.Conexao;
import bean.SGBD.PoolDeConexoes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
		
		public static ArrayList<Mensagem> ListaMensagens() throws SQLException, IOException{
			
			PoolDeConexoes pool = PoolDeConexoes.getInstance();
	 		Conexao cnx = pool.getConexao();
			
				StringBuilder cmd = new StringBuilder();
				cmd.append("select * from \"Mensagens\"");
				ArrayList<Mensagem> list = new ArrayList<Mensagem>();
				
				try {

					PreparedStatement st = cnx.prepareStatement(cmd.toString());

					ResultSet resultList = st.executeQuery();
					
					
					
					while(resultList.next()){
					
										
						String nomeClienteTemp = resultList.getString("nome");
						String textoTemp = resultList.getString("texto");
						String emailTemp = resultList.getString("email");	
						
						int id = resultList.getInt("id");
						Mensagem m1 = new Mensagem(nomeClienteTemp, textoTemp, emailTemp);
						m1.setId(id);
						list.add(m1);
						
						
						
					}

		
				} catch (SQLException e) {
					System.out.println("Houve erro na execuзгo do comando insert");
					System.out.println(e.getMessage());
					System.out.println("Cуdigo de erro: " + e.getSQLState());
				}finally {
					cnx.libera();
				}
				return list;
			
		}
	
		public static void deleteMensagem(Mensagem m1) throws ClassNotFoundException, SQLException, IOException {

			PoolDeConexoes pool = PoolDeConexoes.getInstance();
	 		Conexao cnx = pool.getConexao();

			try {

				StringBuilder cmd = new StringBuilder();
				cmd.append("delete from \"Mensagens\"\n");
				cmd.append("where \"id\" = ?\n");

				try {

					PreparedStatement st = cnx.prepareStatement(cmd.toString());

					st.setInt(1, m1.getId());

					boolean status = st.execute();

					System.out.println("O comando delete foi executado com status: " + status);
				} catch (SQLException e) {
					System.out.println("Houve erro na execuзгo do comando insert");
					System.out.println(e.getMessage());
					System.out.println("Cуdigo de erro: " + e.getSQLState());
				}
			} finally {
				cnx.libera();
			}
		}
		
		public static Mensagem getOneMensagem(int id) throws ClassNotFoundException, SQLException, IOException{
			
			PoolDeConexoes pool = PoolDeConexoes.getInstance();
	 		Conexao cnx = pool.getConexao();
			
				StringBuilder cmd = new StringBuilder();
				cmd.append("select * from \"Mensagens\" WHERE \"id\" = ?");
				
				
				
				try {

					PreparedStatement st = cnx.prepareStatement(cmd.toString());
					st.setInt(1, id);

					ResultSet resultList = st.executeQuery();
					
					
					
					while(resultList.next()){
												
						String nomeClienteTemp = resultList.getString("nome");
						String textoTemp = resultList.getString("texto");
						String emailTemp = resultList.getString("email");	
						int cod = resultList.getInt("id");
						
						Mensagem m1 = new Mensagem(nomeClienteTemp, textoTemp, emailTemp);
						m1.setId(id);
						return m1;
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
		
		public static void updateMensagem(Mensagem m) throws ClassNotFoundException, SQLException, IOException {

			PoolDeConexoes pool = PoolDeConexoes.getInstance();
	 		Conexao cnx = pool.getConexao();

			try {

				StringBuilder cmd = new StringBuilder();
				cmd.append("update \"Mensagens\"\n");
				cmd.append("set \"nome\" = ?, \"texto\" = ?, \"email\" = ? \n");
				cmd.append("where \"id\" = ?\n");

				try {

					PreparedStatement st = cnx.prepareStatement(cmd.toString());

					st.setString(1, m.getNome());
					st.setString(2, m.getTexto());
					st.setString(3, m.getEmail());
					st.setInt(4,  m.getId());
					boolean status = st.execute();

					System.out.println("O comando update foi executado com status: " + status);
				} catch (SQLException e1) {
					System.out.println("Houve erro na execuзгo do comando insert");
					System.out.println(e1.getMessage());
					System.out.println("Cуdigo de erro: " + e1.getSQLState());
				}
			} finally {
				cnx.libera();
			}
		}
		

}