package controladoras;

import java.sql.CallableStatement;

public class ControladorAsignacion extends Controladora{

	/**
	 * se conecta con la base de datos para ejecutar la consulta de asignacion
	 * @param idSolicitud
	 */
	public String asignacionAutomatica(int idSolicitud) throws Exception {
		
		String salida = "";
		try {
			this.Conectar();

			CallableStatement query = this.conexion
					.prepareCall("{call pkDependenciaNivel3.pAgregarDependencia (?,?,?)}");
			//query.setInt(1, depencia.getIdPadre());
			//query.setInt(2, depencia.getIdHija());

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
	
	/**
	 * se conecta con la base de datos para ejecutar la consulta de asignacion
	 * @param idSolicitud
	 * @param idFuncionario
	 */
	public void asignacionIndividual(int idSolicitud, String idFuncionario) throws Exception {
		
	}
	
}
