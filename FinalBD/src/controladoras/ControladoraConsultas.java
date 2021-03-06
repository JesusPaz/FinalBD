package controladoras;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.*;
import java.util.ArrayList;

import java.util.Locale;
import java.sql.*;

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
		
		public Date convertirADate(String fecha) {
			
			Date date=null;
			try {
				if(fecha!=null && !fecha.equals("")) {
				DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
				
				java.util.Date daa= format.parse(fecha);
				date = new Date(daa.getTime());
				}
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null,"La fecha no est� en el debido formato.");
//				e.printStackTrace();
			}
			
			return date;
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
					"SELECT * FROM solicitud WHERE funcionario_cedulafuncionario='"+cedulaFuncionario 
					+"'"+ "AND estado='Asignada'  ");
					
			while (rs.next()) {
			
			int id=Integer.parseInt(rs.getString("idsolicitud"));
			String estado=rs.getString("estado");
			String obs= rs.getString("observacion");
			Date fechai= convertirADate(rs.getString("fechaini")); 
			Date fechaf= convertirADate(rs.getString("fechafin")); 
			String cliente= rs.getString("cliente_cedulacliente");
			int tipoSol= Integer.parseInt(rs.getString("tiposolicitud_idtiposolicitud"));
			String cedFuncionario= rs.getString("funcionario_cedulafuncionario");
			int tipoAnoma= Integer.parseInt(rs.getString("tipoanomalia_idanomalia")) ;
			int tipoP=Integer.parseInt( rs.getString("tipoproducto_idtipoproducto"));
			int prod=Integer.parseInt(rs.getString("producto_idproducto"));
				
			Solicitud s= new Solicitud(id, estado, obs, cliente, tipoSol, cedFuncionario, tipoAnoma, tipoP, prod);
	
			if(fechai!=null && fechaf!=null) {
			s.setFechaIni(fechai);
			s.setFechaIni(fechaf);
			}
				
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
					
			if(rs!=null) {
			while (rs.next()) {
			
			String id=rs.getString("producto_idproducto");
			String estado=rs.getString("cliente_cedulacliente");
			String fechai= rs.getString("fechainicio");
			String fechaf= rs.getString("fechafin");
			
			
			String[] datos= new String[4];
			
			datos[0]=id;
			datos[1]=estado;
			if(fechai!=null)datos[2]=fechai;
			else datos[2]="No definida";
			if(fechaf!=null)datos[3]=fechaf;
			else datos[3]="No definida";	
			productos.add(datos);
				

				}
		}else {
				System.out.println("null, no hay tabla");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error. La tabla no existe en la base de datos.");
		}
			
		
		return productos;
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
}
