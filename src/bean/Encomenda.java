package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Encomenda {
	
	private int idEncomenda;
	private String nomeCliente;
	private String endEntrega;
	private Produto produto;
	private double valorTotal;
	
	public Encomenda(String nome, String end, Produto produtos, double valorTotal) {
		this.nomeCliente = nome;
		this.endEntrega = end;
		this.produto = produtos;
		this.valorTotal = valorTotal;
	}
	
	public void addEncomenda() throws ClassNotFoundException, SQLException {

		String url = "jdbc:postgresql://localhost:5432/trab-prog3";
		Class.forName("org.postgresql.Driver");
		Connection cnx = DriverManager.getConnection(url, "postgres", "tca123");
		System.out.println("Conexгo ao Banco de Dados foi efetuada com sucesso!");

		try {

			StringBuilder cmd = new StringBuilder();
			cmd.append("insert into \"Encomenda\"\n");
			cmd.append("( \"nomeCliente\", \"endEntrega\", \"produto\", \"valorTotal\" )\n");
			cmd.append("values\n");
			cmd.append("( ? , ?, ?, ? )");

			try {

				PreparedStatement st = cnx.prepareStatement(cmd.toString());

				st.setString(1, getNomeCliente());
				st.setString(2, getEndEntrega());
				st.setString(3, produto.getCdProduto());
				st.setDouble(4, getValorTotal());

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
	
	
	
	
	
	
	

	public int getIdEncomenda() {
		return idEncomenda;
	}

	public void setIdEncomenda(int idEncomenda) {
		this.idEncomenda = idEncomenda;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEndEntrega() {
		return endEntrega;
	}

	public void setEndEntrega(String endEntrega) {
		this.endEntrega = endEntrega;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
