package dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import SGBD.Conexao;
import SGBD.PoolDeConexoes;
import bean.Encomenda;
import bean.Produto;

public class EncomendaDAO {

	public static void addEncomenda(Encomenda e1) throws ClassNotFoundException, SQLException, IOException {

		PoolDeConexoes pool = PoolDeConexoes.getInstance();
 		Conexao cnx = pool.getConexao();

		try {

			StringBuilder cmd = new StringBuilder();
			cmd.append("insert into \"Encomendas\"\n");
			cmd.append("( \"nomeCliente\", \"endEntrega\", \"cdProduto\", \"valorTotal\" )\n");
			cmd.append("values\n");
			cmd.append("( ? , ?, ?, ? )");

			try {

				PreparedStatement st = cnx.prepareStatement(cmd.toString());

				st.setString(1, e1.getNomeCliente());
				st.setString(2, e1.getEndEntrega());
				st.setString(3, e1.getProduto().getCdProduto());
				st.setDouble(4, e1.getValorTotal());

				boolean status = st.execute();

				System.out.println("O comando insert foi executado com status: " + status);
			} catch (SQLException e) {
				System.out.println("Houve erro na execuзгo do comando insert");
				System.out.println(e.getMessage());
				System.out.println("Cуdigo de erro: " + e.getSQLState());
			}
		} finally {
			cnx.libera();
		}
	}
	
	public static void deleteEncomenda(Encomenda e1) throws ClassNotFoundException, SQLException, IOException {

		PoolDeConexoes pool = PoolDeConexoes.getInstance();
 		Conexao cnx = pool.getConexao();

		try {

			StringBuilder cmd = new StringBuilder();
			cmd.append("delete from \"Encomendas\"\n");
			cmd.append("where \"idEncomenda\" = ?\n");

			try {

				PreparedStatement st = cnx.prepareStatement(cmd.toString());

				st.setInt(1, e1.getIdEncomenda());

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
	

	public static Encomenda getOneEncomenda(int id) throws ClassNotFoundException, SQLException, IOException{
		
		PoolDeConexoes pool = PoolDeConexoes.getInstance();
 		Conexao cnx = pool.getConexao();
		
			StringBuilder cmd = new StringBuilder();
			cmd.append("select * from \"Encomendas\" WHERE \"idEncomenda\" = ?");
			
			
			
			try {

				PreparedStatement st = cnx.prepareStatement(cmd.toString());
				st.setInt(1, id);

				ResultSet resultList = st.executeQuery();
				
				
				
				while(resultList.next()){
					Produto produto1 = ProdutoDAO.getOneProduto((resultList.getString("cdProduto")));
					
					String nomeClienteTemp = resultList.getString("nomeCliente");
					String endEntregaTemp = resultList.getString("endEntrega");
					double valorTotalTemp = resultList.getDouble("valorTotal");	
					int cod = resultList.getInt("idEncomenda");
					
					Produto p1 = new Produto("","",0,0.0);
					
					Encomenda e1 = new Encomenda("tetet","",p1,0.0);
					
					e1.setNomeCliente(nomeClienteTemp);
					e1.setIdEncomenda(cod);
					e1.setEndEntrega(endEntregaTemp);
					e1.setValorTotal(valorTotalTemp);
					e1.setProduto(produto1);
					
					return e1;
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
	
	public static ArrayList<Encomenda> ListaEncomendas() throws ClassNotFoundException, SQLException, IOException {
		
		PoolDeConexoes pool = PoolDeConexoes.getInstance();
 		Conexao cnx = pool.getConexao();
		
			StringBuilder cmd = new StringBuilder();
			cmd.append("select * from \"Encomendas\"");
			ArrayList<Encomenda> list = new ArrayList<Encomenda>();
			
			try {

				PreparedStatement st = cnx.prepareStatement(cmd.toString());

				ResultSet resultList = st.executeQuery();
				
				
				
				while(resultList.next()){
				
					Produto produto1 = ProdutoDAO.getOneProduto((resultList.getString("cdProduto")));
					
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
			}finally {
				cnx.libera();
			}
			return list;
		
	}
	
	public static void updateEncomenda(Encomenda e) throws ClassNotFoundException, SQLException, IOException {

		PoolDeConexoes pool = PoolDeConexoes.getInstance();
 		Conexao cnx = pool.getConexao();

		try {

			StringBuilder cmd = new StringBuilder();
			cmd.append("update \"Encomendas\"\n");
			cmd.append("set \"nomeCliente\" = ?, \"endEntrega\" = ?\n");
			cmd.append("where \"idEncomenda\" = ?\n");

			try {

				PreparedStatement st = cnx.prepareStatement(cmd.toString());

				st.setString(1, e.getNomeCliente());
				st.setString(2, e.getEndEntrega());
				st.setInt(3, e.getIdEncomenda());
				
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
