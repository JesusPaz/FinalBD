package controladoras;

import java.sql.CallableStatement;

import mundo.Cliente;


public class ControladoraInicioSesion extends Controladora {


	//---------------------------------------------------------------
	//Atributos
	//---------------------------------------------------------------
	
	/**
	 * @instance actual de la clase
	 */
	private static ControladoraInicioSesion instance;
	/**
	 * @userActual en el sistema
	 */
	private Cliente usuarioActual;

	//---------------------------------------------------------------
	//Constructor
	//---------------------------------------------------------------
	
	/**
	 * Construtor de AuthControl
	 */
	private ControladoraInicioSesion() {

	}

	//---------------------------------------------------------------
	//Metodos
	//---------------------------------------------------------------
	
	/**
	 * Metodo encargado de
	 * @return instance actual
	 */
	public static ControladoraInicioSesion getInstance() {
		if (instance == null) {
			synchronized (ControladoraInicioSesion.class) {
				if (instance == null) {
					instance = new ControladoraInicioSesion();
				}
			}
		}
		return instance;
	}
	/**
	 * Metodo encargado de verificar el login del usuario
	 * @param cedula identificador el usuario que hace login
	 * @return salida confirmacion del login
	 * @throws Exception
	 */
	public String login(String cedula) throws Exception {
		String salida = "Correcto";
		try {
			this.Conectar();

			CallableStatement query = this.conexion
					.prepareCall("{call pkEmpleadoNivel3.pConsultarEmpleado (?,?,?,?,?)}");
			query.setString(1, cedula);
			query.registerOutParameter(2, java.sql.Types.VARCHAR);
			query.registerOutParameter(3, java.sql.Types.VARCHAR);
			query.registerOutParameter(4, java.sql.Types.VARCHAR);
			query.registerOutParameter(5, java.sql.Types.VARCHAR);

			query.execute();

			String nombre = query.getString(2);

			if (nombre != null) {
				//Empleado actual = new Empleado(cedula, query.getString(2), query.getString(3), query.getString(4));
				//setUserActual(actual);
			}

			if (query.getString(5) != null) {
				salida = query.getString(5);
			}

		} catch (Exception e) {
			throw e;
		} finally {
			this.TerminarConexion();
		}
		return salida;
	}
	/**
	 * Metodo encargado de
	 * @return userActual en el sistema
	 */
	public Cliente getUserActual() {
		return usuarioActual;
	}
	/**
	 * Metodo encargado de recibir el nuevo
	 * @param userActual en el sistema, y modificar el actual
	 */
	public void setUserActual(Cliente usuarioActual) {
		this.usuarioActual = usuarioActual;
	}


	
}
