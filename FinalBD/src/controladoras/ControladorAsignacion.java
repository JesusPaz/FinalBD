package controladoras;

import java.sql.CallableStatement;

import mundo.Solicitud;

public class ControladorAsignacion extends Controladora{

	/**
	 * se conecta con la base de datos para ejecutar la consulta de asignacion
	 * @param idSolicitud
	 */
	public String asignacionAutomatica(Solicitud solicitud) throws Exception {
		
		String salida = "";
		try {
			this.Conectar();

			CallableStatement query = this.conexion
					.prepareCall("{call pkAsignacionNivel3.pAsignacionAutomatica (?,?)}");
			//PROCEDURE pAsignacionAutomatica(ivIdSolicitud IN NUMBER, ovRetorno out VARCHAR2)
			query.setInt(1, solicitud.getId());

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
	
	/**
	 * se conecta con la base de datos para ejecutar la consulta de asignacion
	 * @param idSolicitud
	 * @param idFuncionario
	 */
	public String asignacionIndividual(int solicitud, String idFuncionario) throws Exception {
		//PROCEDURE pAsignacionIndividual(ivIdSolicitud IN NUMBER,ivFuncionario IN VARCHAR2,ovRetorno out VARCHAR2);
		   

		String salida = "";
		try {
			this.Conectar();

			CallableStatement query = this.conexion
					.prepareCall("{call pkAsignacionNivel3.pAsignacionIndividual(?,?,?)}");
			
			query.setInt(1, solicitud);
			query.setString(2, idFuncionario);

			query.registerOutParameter(3, java.sql.Types.VARCHAR);

			query.execute();

			salida = query.getString(3);
			
			// System.out.println(salida);

			return salida;
		} catch (Exception e) {
			throw e;
		} finally {
			this.TerminarConexion();
		}

		
	}
	
}
