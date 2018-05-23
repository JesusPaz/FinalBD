package controladoras;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Controladora {


	//---------------------------------------------------------------
	//Atributos
	//---------------------------------------------------------------
	
	/**
	 * instancia de la conexion actual
	 */
	protected Connection conexion;
	
	//---------------------------------------------------------------
	//Constructor
	//---------------------------------------------------------------
	
	/**
	 * Constructor encargado de establecer la conexion con la base de datos
	 * @throws Exception
	 */
	public void Conectar() throws Exception {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(
					"jdbc:oracle:thin:@200.3.193.24:1522:ESTUD","P09551_1_16","1234");
		} catch (Exception e) {
			throw e;
		}
	}
	
	//---------------------------------------------------------------
	//Metodos
	//---------------------------------------------------------------
	
	/**
	 * Metodo encargado de terminar la conexion establecidad por el usuario
	 * @throws SQLException
	 */
	public  void TerminarConexion() throws SQLException {
		if ( conexion != null ) {
			if( !conexion.isClosed()) {
				conexion.close();
			}
		}
	}
	
/**
 * este metodo permite hacer commit
 */
	
	public void commit() {
		
		try {
			Statement stmt =  conexion.createStatement();
			Boolean re = stmt.execute(
					"COMMIT");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

}
