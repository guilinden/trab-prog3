package bean.SGBD;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/*
   quando algo (atributo ou um método) NAO é estático ele é individualizado
   por objeto.  Exemplo:
   
   Na classe Cliente tem um atributo codigoCPF que NAO é estático,
   isto significa que cada objeto cliente tem seu próprio cpf;
   
   Quando é estático, o atributo ou metodo é o mesmo para TODAS as instancias
   da classe. Por exemplo, na mesma classe Clientes temos um atritubo
   limiteMaximoDeCredito.  Este atributo deve ser estático pois é o mesmo
   para TODOS os clientes.  Ou seja, todos os objetos compartilham o mesmo
   atributo.
*/
public class Parametros {

	private Properties parametros;
	
	// Neste caso, esta é a referencia estática do Singleton
	private static Parametros mySelf;
	
	public static Parametros getInstance() throws IOException {

		if( mySelf == null ) {
			mySelf = new Parametros();
			mySelf.loadFromFile( "C:/Users/0000782/Desktop/workspace/ProjetoWeb1/conf/parametros.xml" );
		}
		
		return mySelf;
	}
	
	// Perceba que o construtor é private
	private Parametros() {
		parametros = new Properties();
	}
	
	public void addParameter( String key, String value ) {
		parametros.put( key, value );
	}
	
	public String getParameter( String key ) {
		return parametros.getProperty( key );
	}
	
	public void saveToFile( String fileName ) throws IOException {
		
		FileOutputStream fos = new FileOutputStream( fileName );
		
		try {
			parametros.storeToXML( fos,  "Parametros do Banco de Dados" );
		} finally {
			fos.close();
		}
	}
	
	public void loadFromFile( String fileName ) throws IOException {
		
		FileInputStream fis = new FileInputStream( fileName );
		
		try {
			parametros = new Properties();
			parametros.loadFromXML( fis );
		} finally {
			fis.close();
		}
	}
}








