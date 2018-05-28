package controladoras;

import java.sql.CallableStatement;

public class ControladorAtencion extends Controladora{

	
	/**
	 * Se concecta con la base de datos y valida la atencion
	 * @param cedulaFunc
	 * @param idSolicitud
	 * @return
	 * @throws Exception
	 */
public int validarAtencion(String cedulaFunc, int idSolicitud) throws Exception {
		
		int salida = 0;
		try {
			this.Conectar();

			CallableStatement query = this.conexion
					.prepareCall("{call pkAtencionNivel3.pAtenderSolicitud (?,?,?)}");
			
			query.setString(1, cedulaFunc);
			query.setInt(2, idSolicitud);
			
			query.registerOutParameter(3, java.sql.Types.NUMERIC);

			query.execute();

		
			salida = query.getInt(3);
			
			
			this.TerminarConexion();
			return salida;
		} catch (Exception e) {
			throw e;
		} finally {
			this.TerminarConexion();
		}

		
	}
	
	/**
	 * Se conecta con la base de datos para atender una solicitud
	 * @param cedulaFunc
	 * @param idSolicitud
	 * @param comentario
	 * @return
	 * @throws Exception
	 */
public String atenderSolicitud(String cedulaFunc, int idSolicitud, String comentario) throws Exception {
		
		String salida = "";
		try {
			this.Conectar();

			CallableStatement query = this.conexion
					.prepareCall("{call pkAtencionNivel3.pAtenderSolicitud (?,?,?,?)}");
			
			query.setString(1, cedulaFunc);
			query.setInt(2, idSolicitud);
			query.setString(3, comentario);

			
			query.registerOutParameter(4, java.sql.Types.VARCHAR);

			query.execute();

		
			salida = query.getString(4);
			
			
			this.TerminarConexion();
			return salida;
		} catch (Exception e) {
			throw e;
		} finally {
			this.TerminarConexion();
		}

		
	}
	

	public String atenderReclamoODano(String cedulaFuncion, int idSolicitud, String estado,String comentario) throws Exception {
		//PROCEDURE pAsignacionIndividual(ivIdSolicitud IN NUMBER,ivFuncionario IN VARCHAR2,ovRetorno out VARCHAR2);
		   

		String salida = "";
		try {
			this.Conectar();

			CallableStatement query = this.conexion
					.prepareCall("{call pkAtencionNivel3.pAtenderReclamoODano(?,?,?,?,?)}");
			
			query.setString(1, cedulaFuncion);
			query.setInt(2, idSolicitud);
			query.setString(3, comentario);
			query.setString(4, estado);
			
			query.registerOutParameter(5, java.sql.Types.VARCHAR);

			query.execute();

			salida = query.getString(5);
			
			// System.out.println(salida);

			return salida;
		} catch (Exception e) {
			throw e;
		} finally {
			this.TerminarConexion();
		}

		
	}
	
	public String atenderReclamoODanoAutomatico(int idSolicitud) throws Exception {
		//PROCEDURE pAsignacionIndividual(ivIdSolicitud IN NUMBER,ivFuncionario IN VARCHAR2,ovRetorno out VARCHAR2);
		   

		String salida = "";
		try {
			this.Conectar();

			CallableStatement query = this.conexion
					.prepareCall("{call pkAtencionNivel3.pAtenderReclamoODanoAutomatico(?,?)}");
			
			query.setInt(1, idSolicitud);
			
			query.registerOutParameter(2, java.sql.Types.VARCHAR);

			query.execute();

			salida = query.getString(2);
			
			// System.out.println(salida);

			return salida;
		} catch (Exception e) {
			throw e;
		} finally {
			this.TerminarConexion();
		}

		
	}
	
}
