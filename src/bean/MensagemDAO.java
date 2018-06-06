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
						
						Mensagem m1 = new Mensagem(nomeClienteTemp, textoTemp, emailTemp);
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
	


	
	
}