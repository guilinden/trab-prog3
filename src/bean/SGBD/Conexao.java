package bean.SGBD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

// classe Wrapper
public class Conexao {
	
	private Connection cnx;
	private boolean livre;
	
	public Conexao() throws SQLException, IOException {

		livre = true;
		Parametros p = Parametros.getInstance();
		String url = p.getParameter( "urlCnx" );
		
		try{
			Class.forName( p.getParameter( "driverJDBC" ) );
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		}
		
		cnx = DriverManager.getConnection( url, p.getParameter( "usuario"), p.getParameter( "senha" ) );
	}

	public Statement createStatement() throws SQLException {
		return cnx.createStatement();
	}

	public void close() throws SQLException {
		cnx.close();
	}

	public PreparedStatement prepareStatement( String cmd ) throws SQLException {
		return cnx.prepareStatement( cmd );
	}
	
	public void reserva() throws IOException {
		if( livre ) {
			livre = false;
		} else {
			throw new IOException( "A conexao já está sendo usada" );
		}
	}
	
	public void libera() {
		livre = true;
	}
	
	public boolean isLivre() {
		return livre;
	}
}










