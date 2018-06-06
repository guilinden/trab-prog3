package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateStatements {
	
	public void deduzirEstoque(Produto p) throws ClassNotFoundException, SQLException {

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
}
