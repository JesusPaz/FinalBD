package mundo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Controladora {

	private static Connection con;
	
	
	public static Boolean ConectarYConsultar(String usuario, String contraseña ) {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con = DriverManager.getConnection(
					"jdbc:oracle:thin:@200.3.193.24:1522:ESTUD",
					usuario,
					contraseña);
			 
			 
			 return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static void commit() {
		
		try {
			Statement stmt =  con.createStatement();
			Boolean re = stmt.execute(
					"COMMIT");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
