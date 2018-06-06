package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO {
	
	
	
	public static void addProduto(Produto p) throws ClassNotFoundException, SQLException {

		String url = "jdbc:postgresql://localhost:5432/trab-prog3";
		Class.forName("org.postgresql.Driver");
		Connection cnx = DriverManager.getConnection(url, "postgres", "tca123");
		System.out.println("Conexгo ao Banco de Dados foi efetuada com sucesso!");

		try {

			StringBuilder cmd = new StringBuilder();
			cmd.append("insert into \"Produtos\"\n");
			cmd.append("( \"cdProduto\", \"nomeProduto\", \"qtEstoque\", \"valor\" )\n");
			cmd.append("values\n");
			cmd.append("( ? , ?, ?, ? )");

			try {

				PreparedStatement st = cnx.prepareStatement(cmd.toString());

				st.setString(1, p.getCdProduto());
				st.setString(2, p.getNomeProduto());
				st.setInt(3, p.getQtEstoque());
				st.setDouble(4, p.getValor());

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
	

	public static Produto getOneProduto(String id) throws ClassNotFoundException, SQLException{
		String url = "jdbc:postgresql://localhost:5432/trab-prog3";
		Class.forName("org.postgresql.Driver");
		Connection cnx = DriverManager.getConnection(url, "postgres", "tca123");
		System.out.println("Conexгo ao Banco de Dados foi efetuada com sucesso!");
			StringBuilder cmd = new StringBuilder();
			cmd.append("select * from \"Produtos\" WHERE \"cdProduto\" = ?");
			
			
			
			try {

				PreparedStatement st = cnx.prepareStatement(cmd.toString());
				st.setString(1, id);

				ResultSet resultList = st.executeQuery();
				
				
				
				while(resultList.next()){
					Produto p1 = new Produto("","",0,0.0);
					p1.setCdProduto(resultList.getString("cdProduto"));
					p1.setNomeProduto(resultList.getString("nomeProduto"));
					p1.setQtEstoque(resultList.getInt("qtEstoque"));
					p1.setValor(resultList.getDouble("valor"));
					return p1;
				}

	
			} catch (SQLException e) {
				System.out.println("Houve erro na execuзгo do comando select");
				System.out.println(e.getMessage());
				System.out.println("Cуdigo de erro: " + e.getSQLState());
			}
			return null;
		
	}
	
	public static ArrayList<Produto> ArrayList() throws ClassNotFoundException, SQLException {
		String url = "jdbc:postgresql://localhost:5432/trab-prog3";
		Class.forName("org.postgresql.Driver");
		Connection cnx = DriverManager.getConnection(url, "postgres", "tca123");
		System.out.println("Conexгo ao Banco de Dados foi efetuada com sucesso!");
			StringBuilder cmd = new StringBuilder();
			cmd.append("select * from \"Produtos\"");
			ArrayList<Produto> list = new ArrayList<Produto>();
			
			try {

				PreparedStatement st = cnx.prepareStatement(cmd.toString());

				ResultSet resultList = st.executeQuery();
				
				
				
				while(resultList.next()){
					String cdProdutoTemp = resultList.getString("cdProduto");
					String nomeProdutoTemp = resultList.getString("nomeProduto");
					int qtEstoqueTemp = resultList.getInt("qtEstoque");
					double valorTemp = resultList.getDouble("valor");
					
					
					
					Produto p1 = new Produto(cdProdutoTemp, nomeProdutoTemp, qtEstoqueTemp, valorTemp);
					list.add(p1);
					
				}

	
			} catch (SQLException e) {
				System.out.println("Houve erro na execuзгo do comando insert");
				System.out.println(e.getMessage());
				System.out.println("Cуdigo de erro: " + e.getSQLState());
			}
			return list;
		
	}
	
	public static void deduzirEstoque(Produto p) throws ClassNotFoundException, SQLException {

		String url = "jdbc:postgresql://localhost:5432/trab-prog3";
		Class.forName("org.postgresql.Driver");
		Connection cnx = DriverManager.getConnection(url, "postgres", "tca123");
		System.out.println("Conexгo ao Banco de Dados foi efetuada com sucesso!");

		try {

			StringBuilder cmd = new StringBuilder();
			cmd.append("update \"Produtos\"\n");
			cmd.append("set \"qtEstoque\" = ?\n");
			cmd.append("where \"cdProduto\" = ?\n");

			try {

				PreparedStatement st = cnx.prepareStatement(cmd.toString());

				st.setInt(1, p.getQtEstoque()-1);
				st.setString(2, p.getCdProduto());
				
				boolean status = st.execute();

				System.out.println("O comando update foi executado com status: " + status);
			} catch (SQLException e) {
				System.out.println("Houve erro na execuзгo do comando insert");
				System.out.println(e.getMessage());
				System.out.println("Cуdigo de erro: " + e.getSQLState());
			}
		} finally {
			cnx.close();
		}
	}
}