package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectStatements {
	
	public ArrayList<Produto> ArrayList() throws ClassNotFoundException, SQLException {
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
	
	public ArrayList<Encomenda> ListaEncomendas() throws ClassNotFoundException, SQLException {
		String url = "jdbc:postgresql://localhost:5432/trab-prog3";
		Class.forName("org.postgresql.Driver");
		Connection cnx = DriverManager.getConnection(url, "postgres", "tca123");
		System.out.println("Conexгo ao Banco de Dados foi efetuada com sucesso!");
			StringBuilder cmd = new StringBuilder();
			cmd.append("select * from \"Encomendas\"");
			ArrayList<Encomenda> list = new ArrayList<Encomenda>();
			
			try {

				PreparedStatement st = cnx.prepareStatement(cmd.toString());

				ResultSet resultList = st.executeQuery();
				
				
				
				while(resultList.next()){
				
					Produto produto1 = getOneProduto(resultList.getString("cdProduto"));
					
					String nomeClienteTemp = resultList.getString("nomeCliente");
					String endEntregaTemp = resultList.getString("endEntrega");
					double valorTotalTemp = resultList.getDouble("valorTotal");	
					int cod = resultList.getInt("idEncomenda");
					
					Encomenda e1 = new Encomenda(nomeClienteTemp, endEntregaTemp, produto1, valorTotalTemp);
					e1.setIdEncomenda(cod);
					list.add(e1);
					
				}

	
			} catch (SQLException e) {
				System.out.println("Houve erro na execuзгo do comando insert");
				System.out.println(e.getMessage());
				System.out.println("Cуdigo de erro: " + e.getSQLState());
			}
			return list;
		
	}

	public Produto getOneProduto(String id) throws ClassNotFoundException, SQLException{
		String url = "jdbc:postgresql://localhost:5432/trab-prog3";
		Class.forName("org.postgresql.Driver");
		Connection cnx = DriverManager.getConnection(url, "postgres", "tca123");
		System.out.println("Conexгo ao Banco de Dados foi efetuada com sucesso!");
			StringBuilder cmd = new StringBuilder();
			cmd.append("select * from \"Produtos\" WHERE \"cdProduto\" = ?");
			
			Produto p1 = new Produto("","",0,0.0);
			
			try {

				PreparedStatement st = cnx.prepareStatement(cmd.toString());
				st.setString(1, id);

				ResultSet resultList = st.executeQuery();
				
				
				
				while(resultList.next()){
					p1.setCdProduto(resultList.getString("cdProduto"));
					p1.setNomeProduto(resultList.getString("nomeProduto"));
					p1.setQtEstoque(resultList.getInt("qtEstoque"));
					p1.setValor(resultList.getDouble("valor"));
				}

	
			} catch (SQLException e) {
				System.out.println("Houve erro na execuзгo do comando select");
				System.out.println(e.getMessage());
				System.out.println("Cуdigo de erro: " + e.getSQLState());
			}
			return p1;
		
	}
	
	public Encomenda getOneEncomenda(int id) throws ClassNotFoundException, SQLException{
		String url = "jdbc:postgresql://localhost:5432/trab-prog3";
		Class.forName("org.postgresql.Driver");
		Connection cnx = DriverManager.getConnection(url, "postgres", "tca123");
		System.out.println("Conexгo ao Banco de Dados foi efetuada com sucesso!");
			StringBuilder cmd = new StringBuilder();
			cmd.append("select * from \"Encomendas\" WHERE \"idEncomenda\" = ?");
			
			Produto p1 = new Produto("","",0,0.0);
			
			Encomenda e1 = new Encomenda("tetet","",p1,0.0);
			
			try {

				PreparedStatement st = cnx.prepareStatement(cmd.toString());
				st.setInt(1, id);

				ResultSet resultList = st.executeQuery();
				
				
				
				while(resultList.next()){
					Produto produto1 = getOneProduto(resultList.getString("cdProduto"));
					
					String nomeClienteTemp = resultList.getString("nomeCliente");
					String endEntregaTemp = resultList.getString("endEntrega");
					double valorTotalTemp = resultList.getDouble("valorTotal");	
					int cod = resultList.getInt("idEncomenda");
					
					e1.setNomeCliente(nomeClienteTemp);
					e1.setIdEncomenda(cod);
					e1.setEndEntrega(endEntregaTemp);
					e1.setValorTotal(valorTotalTemp);
					e1.setProduto(produto1);
				}

	
			} catch (SQLException e) {
				System.out.println("Houve erro na execuзгo do comando select");
				System.out.println(e.getMessage());
				System.out.println("Cуdigo de erro: " + e.getSQLState());
			}
			return e1;
		
	}
	
	
}
