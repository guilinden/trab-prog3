package bean.SGBD;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.SGBD.Parametros;

/* Tarefas:
 * 
 * 1) tornar esta classe um Singleton
 *    . construtor privado;
 *    . referencia estática;
 *    . método estático para retornar uma instância da classe.
 * 2) criar um ArrayList de Objetos Conexao;
 * 3) criar o método getConexao()
 *    . percorrer a lista de conexoes e liberar uma conexao que esteja livre 
 */
public class PoolDeConexoes {
	
	private static PoolDeConexoes meuPool;
	
	private ArrayList<Conexao> listaConexoes;
	
	private PoolDeConexoes() {
		listaConexoes = new ArrayList<Conexao>();
	}

	public static PoolDeConexoes getInstance() {
		if( meuPool == null ) {
			meuPool =  new PoolDeConexoes();
		}
		
		return meuPool;
	}
	
	public synchronized Conexao getConexao() throws SQLException, IOException {
		for(Conexao cnx : listaConexoes) {
			if(cnx.isLivre()) {
				return cnx;
			}
		}
		Conexao cnx = new Conexao();
		listaConexoes.add(cnx);
		return cnx;
		
	}
}











