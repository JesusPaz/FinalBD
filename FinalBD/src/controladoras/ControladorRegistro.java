package controladoras;

import java.sql.CallableStatement;

import mundo.Solicitud;

public class ControladorRegistro extends Controladora{

	
	/**
	 * registra una solicitud en la base de datos
	 * @param solicitud
	 */
	public String registrarSolicitud(int idSol,String obser,String cedulaCli,int tipoSol,int tipoAnoma,int tipoPro,int pro) throws Exception {
		
		String salida = "Exito";
		try {
			this.Conectar();
			
			CallableStatement query = this.conexion
					.prepareCall("{call pkRegistroNivel3.pRegistarSolicitud(?,?,?,?,?,?,?,?)}");
	//PROCEDURE pRegistarSolicitud(ivIdSolicitud IN NUMBER,ivObservacion IN VARCHAR2,ivIdCliente IN VARCHAR2,ivTipoSolicitud IN NUMBER
	//,ivTipoAnomalia NUMBER,ivIdTipoProducto IN NUMBER,ivIdProducto IN NUMBER, ovRetorno out VARCHAR2);
				    
			query.setInt(1, idSol);
			query.setString(2, obser);
			query.setString(3, cedulaCli);
			query.setInt(4, tipoSol);
			query.setInt(5, tipoAnoma);
			query.setInt(6, tipoPro);
			query.setInt(7, pro);
			
			query.registerOutParameter(8, java.sql.Types.VARCHAR);
			
			query.execute();
			
			if (query.getString(8) != null) {
				salida = query.getString(8);
			}
			
			this.TerminarConexion();
			return salida;
		} catch (Exception e) {
			throw e;
		} finally {
			this.TerminarConexion();
		}

	}
}
