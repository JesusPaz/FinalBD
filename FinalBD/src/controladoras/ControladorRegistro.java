package controladoras;

import java.sql.CallableStatement;

import mundo.Solicitud;

public class ControladorRegistro extends Controladora{

	
	/**
	 * registra una solicitud en la base de datos
	 * @param solicitud
	 */
	public String registrarSolicitud(Solicitud solicitud) throws Exception {
		
		String salida = "";
		try {
			this.Conectar();

			CallableStatement query = this.conexion
					.prepareCall("{call pkRegistroNivel3.pRegistarSolicitud(?,?,?,?,?,?,?,?)}");
	//PROCEDURE pRegistarSolicitud(ivIdSolicitud IN NUMBER,ivObservacion IN VARCHAR2,ivIdCliente IN VARCHAR2,ivTipoSolicitud IN NUMBER
	//,ivTipoAnomalia NUMBER,ivIdTipoProducto IN NUMBER,ivIdProducto IN NUMBER, ovRetorno out VARCHAR2);
				    
			query.setInt(1, solicitud.getId());
			query.setString(2, solicitud.getObservacion());
			query.setString(3, solicitud.getCedulaCliente());
			query.setInt(4, solicitud.getTipoSolicitud());
			query.setInt(5, solicitud.getTipoAnomalia());
			query.setInt(6, solicitud.getTipoProducto());
			query.setInt(7, solicitud.getProducto());
			

			query.registerOutParameter(8, java.sql.Types.VARCHAR);

			query.execute();

			salida = query.getString(8);
			
			// System.out.println(salida);
			return salida;
		} catch (Exception e) {
			throw e;
		} finally {
			this.TerminarConexion();
		}

	}
}
