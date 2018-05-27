package controladoras;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import mundo.Cliente;
import mundo.Solicitud;

public class ControladoraConsultas extends Controladora {

	
	//Atributos

	
		/**
		 * @instance actual de la clase
		 */
		private static ControladoraConsultas instance;
		
	
		//Constructor
		
		/**
		 * Construtor de AuthControl
		 */
		public ControladoraConsultas() {

		}
		//Metodos
		
		/**
		 * Metodo encargado de
		 * @return instance actual
		 */
		public static ControladoraConsultas getInstance() {
			if (instance == null) {
				synchronized (ControladoraInicioSesion.class) {
					if (instance == null) {
						instance = new ControladoraConsultas();
					}
				}
			}
			return instance;
		}
		
		
	
		/**
		 * Consulta solicitudes asignadas de un funcionario dado.
		 * @param cedulaFuncionario
		 * @return lista de solicitudes asignadas.
		 * @throws Exception
		 */
		public ArrayList<Solicitud> solicitudesAsignadasXFunc(String cedulaFuncionario) throws Exception{
		
	
		
		ArrayList<Solicitud> solicitudesAsignadas=null;
		
		try {
			
			this.Conectar();
			Statement stmt = this.conexion.createStatement();
			
			solicitudesAsignadas=new ArrayList<Solicitud>();
			
			
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM solicitud WHERE funcionario_cedulafuncionario="+cedulaFuncionario 
					+ "AND estado='Asignada'  ");
					
			while (rs.next()) {
			
			int id=Integer.parseInt(rs.getString("idsolicitud"));
			String estado=rs.getString("estado");
			String obs= rs.getString("observacion");
			String fechai= rs.getString("fechaini"); //cambiar a date
			String fechaf= rs.getString("fechaini"); //cambiar a date - no quitarrr
			String cliente= rs.getString("cliente_cedulacliente");
			int tipoSol= Integer.parseInt(rs.getString("tiposolicitud_idtiposolicitud"));
			String cedFuncionario= rs.getString("funcionario_cedulafuncionario");
			int tipoAnoma= Integer.parseInt(rs.getString("tipoanomalia_idanomalia")) ;
			int tipoP=Integer.parseInt( rs.getString("tipoproducto_idtipoproducto"));
			int prod=Integer.parseInt(rs.getString("producto_idproducto"));
				
			Solicitud s= new Solicitud(id, estado, obs, cliente, tipoSol, cedFuncionario, tipoAnoma, tipoP, prod);
				
				
				
				solicitudesAsignadas.add(s);
				

				}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error. La tabla no existe en la base de datos.");
		}
			
		
		return solicitudesAsignadas;
		
	}
		
		
		
		
		
		
		/**
		 * Consulta solicitudes por un estado dado.
		 * @param estado
		 * @return lista de solicitudes asignadas.
		 * @throws Exception
		 */
		public ArrayList<Solicitud> solicitudesXestado(String estado1) throws Exception{
		
	
		
		ArrayList<Solicitud> solicitudes=null;
		
		try {
			
			this.Conectar();
			Statement stmt = this.conexion.createStatement();
			
			solicitudes=new ArrayList<Solicitud>();
			ResultSet rs= stmt.executeQuery(
					"SELECT *  FROM solicitud WHERE estado = '"+estado1+"'");
			
			
					
			while (rs.next()) {
			
			int id=Integer.parseInt(rs.getString("idsolicitud"));
			String estad=rs.getString("estado");
			String obs= rs.getString("observacion");
			String fechai= rs.getString("fechaini"); //cambiar a date
			String fechaf= rs.getString("fechaini"); //cambiar a date
			String cliente= rs.getString("cliente_cedulacliente");
			int tipoSol= Integer.parseInt(rs.getString("tiposolicitud_idtiposolicitud"));
			String cedFuncionario= rs.getString("funcionario_cedulafuncionario");
			int tipoAnoma= Integer.parseInt(rs.getString("tipoanomalia_idanomalia")) ;
			int tipoP=Integer.parseInt( rs.getString("tipoproducto_idtipoproducto"));
			int prod=Integer.parseInt(rs.getString("producto_idproducto"));
				
			Solicitud s= new Solicitud(id, estad, obs, cliente, tipoSol, cedFuncionario, tipoAnoma, tipoP, prod);
				
				
				
				solicitudes.add(s);
				
//				System.out.println(s+","+f);
				}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error. La tabla no existe en la base de datos.");
		}
			
		
		return solicitudes;
		
	}
		
		
		
		
		
		/**
		 * Consulta solicitudes por un tipo de solicitud dado.
		 * @param tipo
		 * @return lista de solicitudes asignadas.
		 * @throws Exception
		 */
		public ArrayList<Solicitud> solicitudesXtipo(String tipo) throws Exception{
		
		ArrayList<Solicitud> solicitudes=null;
		
		try {
			
			this.Conectar();
			Statement stmt = this.conexion.createStatement();
			
			solicitudes=new ArrayList<Solicitud>();
			ResultSet rs=stmt.executeQuery(
					"SELECT * FROM solicitud WHERE tiposolicitud_idtiposolicitud='"+tipo+"'"); 
			
					
			while (rs.next()) {
			
			int id=Integer.parseInt(rs.getString("idsolicitud"));
			String estad=rs.getString("estado");
			String obs= rs.getString("observacion");
			String fechai= rs.getString("fechaini"); //cambiar a date
			String fechaf= rs.getString("fechaini"); //cambiar a date
			String cliente= rs.getString("cliente_cedulacliente");
			int tipoSol= Integer.parseInt(rs.getString("tiposolicitud_idtiposolicitud"));
			String cedFuncionario= rs.getString("funcionario_cedulafuncionario");
			int tipoAnoma= Integer.parseInt(rs.getString("tipoanomalia_idanomalia")) ;
			int tipoP=Integer.parseInt( rs.getString("tipoproducto_idtipoproducto"));
			int prod=Integer.parseInt(rs.getString("producto_idproducto"));
				
			Solicitud s= new Solicitud(id, estad, obs, cliente, tipoSol, cedFuncionario, tipoAnoma, tipoP, prod);
				
						
				solicitudes.add(s);
				
//				System.out.println(s+","+f);
				}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error. La tabla no existe en la base de datos.");
		}
			
		
		return solicitudes;
		
	}
		
		
		
		
		
		/**
		 * Consulta los productos por cliente dado
		 * @param cedulaFuncionario
		 * @return lista de productos del cliente
		 * @throws Exception
		 */
		public ArrayList<String[]> productosXclientes(String cedulaCliente) throws Exception{
		
	
		
		ArrayList<String[]> productos=null;
		
		try {
			
			this.Conectar();
			Statement stmt = this.conexion.createStatement();
			
			productos=new ArrayList<String[]>();
			
			
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM productosxcliente WHERE cliente_cedulacliente='"+cedulaCliente+"'");
					
			while (rs.next()) {
			
			String id=rs.getString("producto_idproducto");
			String estado=rs.getString("cliente_cedulacliente");
			String fechai= rs.getString("fechainicio");
			String fechaf= rs.getString("fechafin");
			
			
			String[] datos= new String[4];
			
			datos[0]=id;
			datos[1]=estado;
			datos[2]=fechai;
			datos[3]=fechaf;
				
			productos.add(datos);
				

				}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error. La tabla no existe en la base de datos.");
		}
			
		
		return productos;
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
}
